package Game;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;



public class Game {

	
	// had to include throw file exception for test file to scan in
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub	
		
		
		// GAME INTRO & GETTING PLAYER DETAILS
		Board board = new Board();
		Player[] players = new Player[2];
		View view = new View();
		view.displayWelcome();
		
		int player1Score = 0;
		int player2Score = 0;
		players[0] = new Player(view.getName(), 1, view.pipCountX(board), player1Score);
		players[1] = new Player(view.getName(), 2, view.pipCountO(board), player2Score);
		System.out.println("\n"+ players[0] + " is moving the X Checker");
		System.out.println(players[1] + " is moving the O Checker");
		// Put this here so players can see board before first move based off first roll
		view.displayBoard(board, players[0], players[1], 2);
		
		
		
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
				playerTurn = count%2;
				
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
				view.displayBoard(board, players[0], players[1], playerTurn);
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
//Printing line checking code
			//System.out.println("Player's turn: "+playerTurn);
			view.displayBoard(board, players[0], players[1], playerTurn);
			boolean commandDone = false;
			
			//prints players pips for whoevers turn it is onto display after board print out
			System.out.println(players[playerTurn] + " pip count: "+ players[playerTurn].getPips());

				do {
					command = view.getUserInput(players[playerTurn]); //issue with printing player name
		
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
							System.out.println("Please enter option you would like to choose");
							selection = in.nextInt();
							option_chosen = legal_moves.pickOption(selection-1);
							System.out.println(legal_moves.pickOption(selection-1).toString());
							legal_moves.clearOptions();
							board.move(option_chosen);
							view.displayBoard(board, players[0], players[1], playerTurn);
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
						view.displayBoard(board, players[0], players[1], playerTurn);
						
						//breaks out of loop, next players turn
						commandDone = true;
						
						
					}
					
			
					/*else if (command.isMove())
					{

					}*/
					else if (command.isQuit()) {
						view.displayQuit(players[playerTurn]);
						commandDone = true;
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
				if (command.isQuit())
					break;
				
		} while (!command.isQuit() && !players[0].isGameOver() && !players[1].isGameOver());

		if (players[0].isGameOver()) {
			System.out.println("Congratulations " + players[0] + "!!!\nYou have won backgammon!");
		} else if (players[1].isGameOver()) {
			System.out.println("Congratulations " + players[1] + "!!!\nYou have won backgammon!");
		}

	}
}
