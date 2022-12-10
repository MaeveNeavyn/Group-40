package Game;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;



public class Game {

	
	// had to include throw file exception for test file to scan in
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub	
		
		boolean newMatch = true;
		
		while (newMatch ) {
		// GAME INTRO & GETTING PLAYER DETAILS
		Board board = new Board();
		Player[] players = new Player[2];
		View view = new View();
		
		// Initializes that no player has the double cube at start of new game
		boolean doubleOwnership1 = false;
		boolean doubleOwnership2 = false;
		int gameStake = 1;
		
		view.displayWelcome();
		
		int player1Score = 0;
		int player2Score = 0;
		players[0] = new Player(view.getName(), 1, view.pipCountX(board), player1Score, doubleOwnership1);
		players[1] = new Player(view.getName(), 2, view.pipCountO(board), player2Score, doubleOwnership2);
		
		Match match = new Match(view.getMatchLength(), gameStake);
		//view.getMatchLength();
		System.out.println("\n"+ players[0] + " is moving the X Checker");
		System.out.println(players[1] + " is moving the O Checker");
		// Put this here so players can see board before first move based off first roll
		view.displayBoard(board, players[0], players[1], 2, match);
		
		
		
		// SETTING UP VARIABLES/ARRAYS/LISTS TO BE USED IN GAME
		List<Integer> rolls = new ArrayList<>();
		LegalMoves legal_moves = new LegalMoves(board, players[0], rolls);
		//Need to ask user what they want to choose
		Option option_chosen = new Option();
		int selection = 0;
		Scanner in = new Scanner(System.in);
		Command command = null;  //WHY DO I NEED NULL
		int count = 0;
		int playerTurn;
		int player1roll, player2roll;
		
		boolean quit = false;
		//boolean startTurn = true;
		//int matchLength = view.
		
		do { // do while loop for entire match, continues until player wins
				
			// GAME STARTS - First rolls determines who goes first
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
				
				/*if (player1roll > player2roll) {
					count = 2;
					System.out.println(players[0] + " starts the game!");
					legal_moves = new LegalMoves(board,players[0], rolls);
					System.out.println("Please enter option you would like to choose");
					selection = in.nextInt();
					//System.out.println("Option chosen was: " + (selection-1));
					option_chosen = legal_moves.pickOption(selection-1);
					System.out.println(legal_moves.pickOption(selection-1).toString());
					legal_moves.clearOptions();
					board.move(option_chosen);
					rolls.remove(option_chosen.getNoDice()-1);
					
					legal_moves = new LegalMoves(board,players[1], rolls);
					System.out.println("Please enter option you would like to choose");
					selection = in.nextInt();
					//System.out.println("Option chosen was: " + (selection-1));
					option_chosen = legal_moves.pickOption(selection-1);
					System.out.println(legal_moves.pickOption(selection-1).toString());
					legal_moves.clearOptions();
					board.move(option_chosen);
					rolls.remove(option_chosen.getNoDice()-1);
	
					
					players[0].setPips(view.pipCountX(board));
					players[1].setPips(view.pipCountO(board));
					// Get player 2s command, then for loop can continue as normal
				}
				else if (player1roll < player2roll) {
					// Add in move function here to move based off first roll
					count = 3;
					System.out.println(players[1] + " starts the game!");
					legal_moves = new LegalMoves(board,players[1], rolls);
					System.out.println("Please enter option you would like to choose");
					selection = in.nextInt();
					//System.out.println("Option chosen was: " + (selection-1));
					option_chosen = legal_moves.pickOption(selection-1);
					System.out.println(legal_moves.pickOption(selection-1).toString());
					legal_moves.clearOptions();
					board.move(option_chosen);
					rolls.remove(option_chosen.getNoDice()-1);
					
					legal_moves = new LegalMoves(board,players[1], rolls);
					System.out.println("Please enter option you would like to choose");
					selection = in.nextInt();
					//System.out.println("Option chosen was: " + (selection-1));
					option_chosen = legal_moves.pickOption(selection-1);
					System.out.println(legal_moves.pickOption(selection-1).toString());
					legal_moves.clearOptions();
					board.move(option_chosen);
					rolls.remove(option_chosen.getNoDice()-1);
	
					players[0].setPips(view.pipCountX(board));
					players[1].setPips(view.pipCountO(board));
	
				}*/
				else 
					{
						System.out.println("Players rolled the same number. Roll again!\n"); 		//when values the same, game breaks and repeats
						rolls.remove(1);
						rolls.remove(0);
					}
			}
			while (player1roll == player2roll);
	
			playerTurn = count%2;
			// legal move for this player
	
	
	
						
	
			// do while: game is not quit or over
			do {
				//Command command;
				//int turn = 0;
				count++;
				playerTurn = count%2;
				int otherPlayer = (count +1)%2;		//gets other player value, will change according to count value, will always be opposite of playerTurn
	//Printing line checking code
				//System.out.println("Player's turn: "+playerTurn);
				view.displayBoard(board, players[0], players[1], playerTurn, match);
				boolean commandDone = false;
				boolean startTurn = true;
				//prints players pips for whoevers turn it is onto display after board print out
				System.out.println(players[playerTurn] + " pip count: "+ players[playerTurn].getPips());
				

					do {
						command = view.getUserInput(players[playerTurn]); //issue with printing player name
						
						// DOUBLE COMMAND
						// Need to include print statement if they try to use double again when they have already made move or already have the double
						if ((startTurn == true) && (players[playerTurn].getDoubleOwnership() == false)) {
							if (command.isDouble()) {
								boolean doubleAnswer = view.getDoubleAnswer(players[playerTurn], players[otherPlayer]);
								startTurn = false;
								if (doubleAnswer == true) {		// other Player has accepted double
									gameStake *= 2;
									match.setGameStake(gameStake);
									System.out.println("game stake value after double is now: " + gameStake);		//print test
									
									// Assigns who has the double cube
									players[playerTurn].setDoubleOwnership();
									players[otherPlayer].removeDoubleOwnership();
									
									System.out.println(players[playerTurn] + " has the doubling cube: " + players[playerTurn].getDoubleOwnership());
									
								}else {
									view.displayQuit(players[otherPlayer]);
									quit = true;
									commandDone = true;
								}
							}
						}
						
						
						startTurn = false;
						
						
						// If user uses test command, it reads command from file then goes through command loop
						if (command.isTestFile()) {
							String fileName = command.getFileName();
							File file = new File(fileName);
							Scanner sc = new Scanner(file);
							String fileCommand = sc.nextLine();
							sc.close();
							
							command = new Command(fileCommand);		// Overwrites command to be command from test file
							
						}
						
			
						//Legal moves is done based on certain dice roll
						if (command.isRoll() || command.isDice()) {
							if (command.isRoll()) {
								rolls.add(Dice.getRoll());
								rolls.add(Dice.getRoll());
								if (rolls.get(0) == rolls.get(1))
								{
									System.out.println("Double's rolled!");
									int rolledDouble = rolls.get(0);
									rolls.add(rolledDouble);
									rolls.add(rolledDouble);
									System.out.println("Roll 1: " + rolls.get(0));
									System.out.println("Roll 2: " +rolls.get(1));
									System.out.println("Roll 3: " + rolls.get(2));
									System.out.println("Roll 4: " + rolls.get(3));
								}
								else 
								{
									System.out.println("Roll 1: " + rolls.get(0));
									System.out.println("Roll 2: " +rolls.get(1));
								}
	
								//commandDone = true;
								// don't want command to be finished as want to have the option to move checker
							}
							else if (command.isDice() ) {
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
							
							/*legal_moves = new LegalMoves(board,players[1], rolls);
							System.out.println("Please enter option you would like to choose");
							selection = in.nextInt();
							//System.out.println("Option chosen was: " + (selection-1));
							option_chosen = legal_moves.pickOption(selection-1);
							System.out.println(legal_moves.pickOption(selection-1).toString());
							legal_moves.clearOptions();
							board.move(option_chosen);
							rolls.remove(0);*/
							
							
							players[0].setPips(view.pipCountX(board));
							players[1].setPips(view.pipCountO(board));
							view.displayBoard(board, players[0], players[1], playerTurn, match);
							
							//breaks out of loop, next players turn
							commandDone = true;
							
							
						}
						
				
						/*else if (command.isMove())
						{
	
						}*/
						else if (command.isQuit()) {
							view.displayQuit(players[playerTurn]);
							commandDone = true;
							quit = true;
						}
						else if(command.isPip()) {
							view.displayPipCounts(players[0], players[1]);
							// command not done, want player to do something, either roll or quit
						}
						else if (command.isHint() ) {
							// Method needs to be completed
							view.displayHints(players[playerTurn]);
							// command not done, want player to do something, either roll or quit
						}
						
	
						
					}
					while (!commandDone);
					if (quit == true)
						break;
					
			} while ((quit == false) && !players[0].isGameOver() && !players[1].isGameOver());
	
			// GAME OVER
			// need to do score adjustments based on sing;e, gammon or backgammon
			if (players[0].isGameOver()) {
				player1Score++;
				System.out.println( players[0] + " has won this game!");
			} else if (players[1].isGameOver()) {
				player2Score++;
				System.out.println(players[1] + " has won this game!");
			}
			
		} while (player1Score < match.getMatchLength() || player2Score < match.getMatchLength()); // End of for loops for match length
		
		// MATCH OVER
		if (player1Score >= match.getMatchLength() && player1Score > player2Score) {
			System.out.println("Congratulations " + players[0].getName() + "! You have won the game of Backgammon!");
		}
		if (player2Score >= match.getMatchLength() && player1Score < player2Score) {
			System.out.println("Congratulations " + players[1].getName() + "! You have won the game of Backgammon!");
		}
		
		// START NEW MATCH
		Scanner userInput = new Scanner(System.in);
		System.out.println("Would you like to play another match? (Y/N)");
		String choice = userInput.nextLine();
		
		newMatch = choice.equalsIgnoreCase("y"); 
		userInput.close();	
			
		
		
	}// end of while (newMatch)
	}
}
