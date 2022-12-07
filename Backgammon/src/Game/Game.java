package Game;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board();
		Player[] players = new Player[2];
		View view = new View();
		view.displayWelcome();
		players[0] = new Player(view.getName(), 1, view.pipCountX(board));
		players[1] = new Player(view.getName(), 2, view.pipCountO(board));
		System.out.println("\n"+ players[0] + " is moving the X Checker");
		System.out.println(players[1] + " is moving the O Checker");
		
		// Put this here so players can see board before first move based off first roll
		view.displayBoard(board, players[0], players[1], 2);

		
		Command command = null;  //WHY DO I NEED NULL
		int count = 0;
		int playerTurn;
		
		int player1roll, player2roll;
					
		do
		{
			// Gets players first roll
			player1roll = view.displayFirstRoll(players[0], Dice.getRoll());
			player2roll = view.displayFirstRoll(players[1], Dice.getRoll());
			System.out.println();
			
			int r1 = 3;
			int r2 = 5;
			int p1 = 18;
			int p2 = 0;

			if (player1roll > player2roll) {
				// Move function to move based off first roll
				players[0].move(player1roll, 0, board);
				count = 2;
				System.out.println(players[0] + " starts the game!");
				board.move(r1, r2, p1, p2);

				
				// Get player 2s command, then for loop can continue as normal
			}
			else if (player1roll < player2roll) {
				// Add in move function here to move based off first roll
				players[1].move(player2roll,  0, board);
				count = 3;
				System.out.println(players[1] + " starts the game!");
				board.move(r1, r2, p1, p2);

			}
			else System.out.println("Players rolled the same number. Roll again!\n"); 		//when values the same, game breaks and repeats
		}
		while (player1roll == player2roll);
		
		playerTurn = count%2;
		// legal move for this player
		
				
		
					// Need to add in whoever starts moves their checker (move function)
					// Player who lost first roll is going to be asked their command first
					// Need to edit for loop
					
		
		
		// do while game is not quit or over
		do {
			//Command command;
			//int turn = 0;
			count++;
			playerTurn = count%2;
			view.displayBoard(board, players[0], players[1], playerTurn);
			boolean commandDone = false;
	
			
			//for(int i=0; i<=1; i++){
			//int i = playerTurn -1;	
			//prints players pips for whoevers turn it is onto display after board print out
			System.out.println(players[playerTurn] + " pip count: "+ players[playerTurn].getPips());
			//System.out.println("The total pip count for O Checkers is: "  );
			view.pipCountO(board);
			view.pipCountX(board);
			
				do {
					command = view.getUserInput(players[playerTurn]); //issue with printing player name
					if (command.isRoll()) {
						players[playerTurn].move(Dice.getRoll(),Dice.getRoll(),board);
						//int roll1 = Dice.getRoll();
						//int roll2 = Dice.getRoll();
						view.displayMove(players[playerTurn], players[playerTurn].getRolls());
						
						//commandDone = true;
						// don't want command to be finished as want to have the option to move checker
					} 
					else if (command.isMove()) {
						int r1 = 3;
						int r2 = 5;
						int p1 = 18;
						int p2 = 0;
						board.move(r1, r2, p1, p2);
						
						/*if(i==0) {
							turn =1;
						}
						else if (i==1) {
							turn = 0;
						}*/
						view.displayBoard(board, players[0], players[1], playerTurn);
						commandDone = true;
					}
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
			
			
			
		}while (!command.isQuit() && !players[0].isGameOver() && !players[1].isGameOver());
		
		if (players[0].isGameOver()) {
			System.out.println("Congratulations " + players[0] + "!!!\nYou have won backgammon!");
		} else if (players[1].isGameOver()) {
			System.out.println("Congratulations " + players[1] + "!!!\nYou have won backgammon!");
		}
			
	}
}
