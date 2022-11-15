package Game;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board();
		Player[] players = new Player[2];
		View view = new View();
		view.displayWelcome();
		players[0] = new Player(view.getName());
		players[1] = new Player(view.getName());
		
		Command command = null;  //WHY DO I NEED NULL
		
		// Gets players first roll
		int player1roll = view.displayFirstRoll(players[0], Dice.getRoll());
		int player2roll = view.displayFirstRoll(players[1], Dice.getRoll());
					
		do
		{
			if (player1roll > player2roll) {
				players[0].move(player1roll, 0, board);
				System.out.println(players[0] + " starts the game!");
				
				// Get player 2s command, then for loop can continue as normal
			}
			else if (player1roll < player2roll) {
				players[1].move(player2roll,  0, board);
				System.out.println(players[1] + " starts the game!");
			}
			else System.out.println("Players rolled the same number. Roll again!\n");
		}
		while (player1roll==player2roll);
			
		
				
					// Need to add in whoever starts moves their checker (move function)
					// Player who lost first roll is going to be asked their command first
					// Need to edit for loop
					
		
		
		
		do {
			//Command command;
			view.displayBoard(board, players[0], players[1]);
			
			boolean commandDone = false;
			
			
			
			
			for(int i=0; i<=1; i++){
				
			//prints players pips for whoevers turn it is onto display after board print out
			System.out.println(players[i] + "pip count: "+ players[i].getPips());
			
			
				do {
					command = view.getUserInput(players[i]); //issue with printing player name
					if (command.isRoll()) {
						players[i].move(Dice.getRoll(),Dice.getRoll(),board);
						//int roll1 = Dice.getRoll();
						//int roll2 = Dice.getRoll();
						view.displayMove(players[i], players[i].getRolls());
						
						commandDone = true;
					} 
					else if (command.isQuit()) {
						view.displayQuit();
						commandDone = true;	
					}
					else if(command.isPip()) {
						view.displayPipCounts(players[0], players[1]);
						// command not done, want player to do something, either roll or quit
					}
					else if (command.isHint() ) {
						// Method needs to be completed
						view.displayHints(players[i]);
						// command not done, want player to do something, either roll or quit

					}
					
					
				}
				while (!commandDone);
				if (command.isQuit()) 
					break;
			}
			
			
		}while (!command.isQuit() && !players[0].isGameOver() && !players[1].isGameOver());
		
		if (players[0].isGameOver()) {
			System.out.println("Congratulations " + players[0] + "!!!\nYou have won backgammon!");
		} else if (players[1].isGameOver()) {
			System.out.println("Congratulations " + players[1] + "!!!\nYou have won backgammon!");
		}
			
	}
}
