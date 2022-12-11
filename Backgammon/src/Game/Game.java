package Game;

import java.util.*;
import java.io.*;
//import java.nio.file.Path;
//import java.nio.file.Paths;



public class Game {

	
	// had to include throw file exception for test file to scan in
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub	
		
		boolean newMatch = true;
		
		do  {
		// GAME INTRO & GETTING PLAYER DETAILS
		Board board = new Board();
		Player[] players = new Player[2];
		View view = new View();
		Scanner in = new Scanner(System.in);
		
		// Initializes that no player has the double cube at start of new game
		boolean doubleOwnership1 = true;
		boolean doubleOwnership2 = true;
		boolean player1Quit = false;
		boolean player2Quit = false;
		int gameStake = 1;
		int gameValue = 1;
		
		view.displayWelcome();
		
		
		// PLAYER DETAILS
		int player1Score = 0;
		int player2Score = 0;
		System.out.println("Enter Player 1 Name: ");
		String name1 = in.nextLine();
		System.out.println("Enter Player 2 Name: ");
		String name2 = in.nextLine();
		
		
		players[0] = new Player(name1, 1, view.pipCountX(board), player1Score, doubleOwnership1, player1Quit);
		players[1] = new Player(name2, 2, view.pipCountO(board), player2Score, doubleOwnership2, player2Quit);
		
		
		// MATCH DETAILS 
		int matchLength = 0;
		do {
		System.out.print("Enter the length of the match: ");
		String length = in.nextLine();
		matchLength = view.getMatchLength(length);
		} while (matchLength < 1);
		Match match = new Match(matchLength, gameStake);
		
		
		
		System.out.println("\n"+ players[0] + " is moving the X Checker");
		System.out.println(players[1] + " is moving the O Checker");
		// Players able to see board before first move based off first roll
		view.displayBoard(board, players[0], players[1], 2, match);
		
		
		
		// SETTING UP VARIABLES/ARRAYS/LISTS TO BE USED IN GAME
		List<Integer> rolls = new ArrayList<>();
		LegalMoves legal_moves = new LegalMoves(board, players[0], rolls);
		//Need to ask user what they want to choose
		Option option_chosen = new Option();
		int selection = 0;
		
		Command command = null;  
		int count = 0;
		int playerTurn;
		int player1roll, player2roll;
		
		boolean quit = false;
		
		// MATCH DO WHILE LOOP - continues until player wins
		do { 
				
			// GAME STARTS - First rolls determines who goes first
			do {
				player1Quit = false;
				player2Quit = false;
			
				// FIRST DICE ROLL - continues until a player rolls a higher number
				do 
				{
					// Gets players first roll
					player1roll = view.displayFirstRoll(players[0], Dice.getRoll());
					player2roll = view.displayFirstRoll(players[1], Dice.getRoll());
					System.out.println();
					rolls.add(player1roll);
					rolls.add(player2roll);
		
		
					if (player1roll != player2roll) {
						if (player1roll > player2roll) {
							count = 2;
						}
						else if (player1roll < player2roll) {
							count = 3;
						}
						playerTurn = count%2;	// Determines whether it is player 1 or 2's turn
						
						System.out.println(players[playerTurn] + " starts the game!");
						
						// Shows options for both dice and lets user choose option
						legal_moves = new LegalMoves(board,players[playerTurn], rolls);
						System.out.println("Please enter option you would like to choose");
						selection = in.nextInt();
						//System.out.println("Option chosen was: " + (selection-1));
						option_chosen = legal_moves.pickOption(selection-1);
						System.out.println(legal_moves.pickOption(selection-1).toString());
						legal_moves.clearOptions();
						board.move(option_chosen);
						view.displayBoard(board, players[0], players[1], playerTurn, match);
						rolls.remove(option_chosen.getNoDice()-1);
						
						// Shows move options for the dice that wasn't picked for first move 
						legal_moves = new LegalMoves(board,players[playerTurn], rolls);
						System.out.println("Please enter option you would like to choose");
						selection = in.nextInt();
						//System.out.println("Option chosen was: " + (selection-1));
						option_chosen = legal_moves.pickOption(selection-1);
						System.out.println(legal_moves.pickOption(selection-1).toString());
						legal_moves.clearOptions();
						board.move(option_chosen);
						rolls.remove(0);
		
						
						players[0].setPips(view.pipCountX(board));
						players[1].setPips(view.pipCountO(board));
						
					}
					else 
						{
							System.out.println("Players rolled the same number. Roll again!\n"); 		//when values the same, game breaks and repeats
							rolls.remove(1);
							rolls.remove(0);
						}
				} while (player1roll == player2roll);
				
	
		
			playerTurn = count%2;
				
			// GAME DO WHILE - game continues until player quits or game is over and player pip count is 0
			do {
				// Updating players turn
				count++;
				playerTurn = count%2;
				int otherPlayer = (count + 1)%2;		//gets other player value, will change according to count value, will always be opposite of playerTurn
				
				view.displayBoard(board, players[0], players[1], playerTurn, match);
				
				// Initiating players Turn
				boolean commandDone = false;
				boolean startTurn = true;
				//prints players pips for whoevers turn it is onto display after board print out
				System.out.println(players[playerTurn] + " pip count: "+ players[playerTurn].getPips());
				String commandInput = in.nextLine();
			
				do {
					boolean validCommand = false;
					//String commandInput;
					
					do {	
						System.out.println(players[playerTurn].getName() + " enter command: ");	
						commandInput = in.nextLine();
						validCommand = view.validCommand(commandInput);
						
					} while (validCommand == false);
					
					//String commandInput;
					command = view.getUserInput(commandInput);
						
						// DOUBLE COMMAND - can only be used if player is at start of their turn and owns the double cube, and if game Stake less than 64
						if (command.isDouble()) {
							
							if (players[playerTurn].getDoubleOwnership() == false) {
								System.out.println("You cannot use the Double command as you have just used it.");
							} else if (startTurn == false) {
								System.out.println("You cannot use the Double command as it is not the start of your turn.");
							} else if (gameStake == 64) {
								System.out.println("You cannot use the Double command as it is at its maximum value of 64!");
							}
							else {
								view.displayDoubleQuestion(players[playerTurn], players[otherPlayer]);
								String answer = in.nextLine();
								boolean doubleAnswer = view.getDoubleAnswer(answer);
								startTurn = false;
								
								if (doubleAnswer == true) {		// other Player has accepted double
									gameStake *= 2;
									match.setGameStake(gameStake);
									System.out.println("game stake value after double is now: " + gameStake);		//print test
									
									// Assigns who has the double cube
									players[playerTurn].removeDoubleOwnership();
									players[otherPlayer].setDoubleOwnership();
									
									System.out.println(players[playerTurn] + " has the doubling cube: " + players[playerTurn].getDoubleOwnership());	
								}
								else {
									view.displayQuit(players[otherPlayer]);
									players[otherPlayer].userQuitting();
									quit = true;
									commandDone = true;
								}
							}
						}

						startTurn = false;
						
						// TEST COMMAND - reads command from .txt file specified by user
						if (command.isTestFile()) {
							String fileName = command.getFileName();
							String fileCommand;
							fileCommand = null;
							
							try {
								File file = new File(fileName);
								FileReader filereader = new FileReader(file);
								BufferedReader reader = new BufferedReader(filereader);
								
								String line = null;
								
								fileCommand = reader.readLine();
								if ((line = fileCommand) != null) {
									fileCommand = line;
								}
								reader.close();
								
							}
							catch (FileNotFoundException e) {
								e.printStackTrace();
							}
							catch (IOException e) {
								e.printStackTrace();
							}
							
							command = new Command(fileCommand);		// Overwrites command to be command from test file

						}
						
			
						//Legal moves is done based on certain dice roll
						// DICE & ROLL COMMAND
						if (command.isRoll() || command.isDice()) {
							
							// ROLL COMMAND
							if (command.isRoll()) {
								rolls.add(Dice.getRoll());
								rolls.add(Dice.getRoll());
								if (rolls.get(0) == rolls.get(1)) {
								
									System.out.println("Double's rolled!");
									int rolledDouble = rolls.get(0);
									rolls.add(rolledDouble);
									rolls.add(rolledDouble);
									System.out.println("Roll 1: " + rolls.get(0));
									System.out.println("Roll 2: " +rolls.get(1));
									System.out.println("Roll 3: " + rolls.get(2));
									System.out.println("Roll 4: " + rolls.get(3));
								
								}else {
									System.out.println("Roll 1: " + rolls.get(0));
									System.out.println("Roll 2: " +rolls.get(1));
								}
	
							// DICE COMMAND	
							} else if (command.isDice() ) {
								rolls.add(command.getDice1());
								rolls.add(command.getDice2());
							}
							
							//This will need to be a loop to accommodate double rolls 
							do 
							{
								legal_moves = new LegalMoves(board, players[playerTurn],rolls);
								if (legal_moves.size() == 0)
								{
									System.out.println("No legal moves available");
									rolls.clear();
									break;
								}
								System.out.println("Please enter option you would like to choose");
								selection = in.nextInt();
								option_chosen = legal_moves.pickOption(selection-1);
								System.out.println(legal_moves.pickOption(selection-1).toString());
								legal_moves.clearOptions();
								board.move(option_chosen);
								view.displayBoard(board, players[0], players[1], playerTurn, match);
								rolls.remove(option_chosen.getNoDice()-1);
							}
							while (rolls.size()>0);
							
							players[0].setPips(view.pipCountX(board));
							players[1].setPips(view.pipCountO(board));
							view.displayBoard(board, players[0], players[1], playerTurn, match);
							
							//breaks out of loop, next players turn
							commandDone = true;
							
							
						}
						
				
						// QUIT COMMAND - user quits the current game
						else if (command.isQuit()) {
							view.displayQuit(players[playerTurn]);
							players[playerTurn].userQuitting();
							commandDone = true;
							quit = true;
						}
						
						// PIP COMMAND - displays pip count
						else if(command.isPip()) {
							view.displayPipCounts(players[0], players[1]);
						}
						
						// HINT COMMAND - gives hints about commands to user
						else if (command.isHint() ) {
							// Method needs to be completed
							view.displayHints(players[playerTurn]);
							// command not done, want player to do something, either roll or quit
						}
	
					}while (!commandDone); 		// end of current users
					
				if (quit == true)
						break;		// Breaks out of game loop when quit entered
					
			} while ((quit == false) && !players[0].isGameOver() && !players[1].isGameOver());
			
			
	
			// GAME OVER
			// PLAYER 1 WON GAME
			if (players[0].isGameOver() || players[1].hasQuit()) {
				
				// DETERMINE GAME VALUE
				// BACK GAMMON
				if (!view.isOStartEmpty(board) && !board.isRedMiddlePointEmpty() && board.isRedHomeEmpty()) {
					gameValue = 3;
					System.out.println("This game has ended in a Backgammon.");
				}
				// GAMMONED
				else if (board.isRedMiddlePointEmpty() && board.isRedHomeEmpty()) {
					gameValue = 2;
					System.out.println("This game has ended in a Gammon.");
				}
				// SINGLE
				else if (!board.isRedHomeEmpty()) {
					gameValue = 1;
					System.out.println("This game has ended in a Single.");
				}
				
				player1Score += (gameValue*gameStake);
				players[0].updateScore(player1Score);
				System.out.println( players[0] + " has won this game!");
				
				
				
			// PLAYER 2 WON GAME	
			} else if (players[1].isGameOver() || players[0].hasQuit()) {
				// DETERMINE GAME VALUE
				// BACK GAMMON
				if (!view.isXStartEmpty(board) && !board.isBlueMiddlePointEmpty() && board.isBlueHomeEmpty()) {
					gameValue = 3;
					System.out.println("This game has ended in a Backgammon.");
				}
				// GAMMONED
				else if (board.isBlueMiddlePointEmpty() && board.isBlueHomeEmpty()) {
					gameValue = 2;
					System.out.println("This game has ended in a Gammon.");
				}
				// SINGLE
				else if (!board.isBlueHomeEmpty()) {
					gameValue = 1;
					System.out.println("This game has ended in a Single.");
				}
				
				player2Score += (gameValue*gameStake);
				players[1].updateScore(player2Score);
				System.out.println(players[1] + " has won this game!");
			}
			
			
			System.out.println("player 1 Score: " + player1Score);
			System.out.println("player 2 Score: " + player2Score);
			
			System.out.println("Player1 Gameover: " + players[0].isGameOver());
			System.out.println("Player2 Gameover: " + players[1].isGameOver());
			System.out.println("Player1 has Quit: " + players[0].hasQuit());
			System.out.println("Player2 has Quit: " + players[1].hasQuit());

			
			
			} while ((players[0].isGameOver()==false) && (players[1].isGameOver()==false) && (players[0].hasQuit()==false) && (players[1].hasQuit()==false)); 	//Game Loop
			
			System.out.println("match length value: " +match.getMatchLength());
			
		} while (players[0].getScore() < match.getMatchLength() && players[1].getScore() < match.getMatchLength()); // End of for loops for match length
		// Loops through games until player 1 or 2 score is greater than match length
		
		// MATCH OVER
		if (player1Score >= match.getMatchLength() && player1Score > player2Score) {
			System.out.println("Congratulations " + players[0].getName() + "! You have won the game of Backgammon!");
		}
		if (player2Score >= match.getMatchLength() && player1Score < player2Score) {
			System.out.println("Congratulations " + players[1].getName() + "! You have won the game of Backgammon!");
		}
		
	
		System.out.println("Would you like to play another match? (Y/N)");
		String choice = in.nextLine();
		newMatch = choice.equalsIgnoreCase("y"); 
		
		in.close(); 		// Closes Scanner

		
	} while (newMatch );// end of do while (newMatch)
		// START NEW MATCH
			
}
}
