package Game;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board();
		Player[] players = new Player[2];
		View view = new View();
		players[0] = new Player(view.getName());
		players[1] = new Player(view.getName());
		view.displayWelcome();
		Command command = null;  //WHY DO I NEED NULL
		
		do {
			//Command command;
			view.displayBoard(board, players[0], players[1]);
			boolean commandDone = false;
			for(int i=0; i<=1; i++){
			
			do {
				command = view.getUserInput(players[i]); //issue with printing player name
				if (command.isRoll()) {
					players[i].move(Dice.getRoll(),Dice.getRoll(),board);
					//int roll1 = Dice.getRoll();
					//int roll2 = Dice.getRoll();
					view.displayMove(players[i], players[i].getRolls());
					commandDone = true;
				} else if (command.isQuit()) {
					view.displayQuit();
					commandDone = true;	
				}
				
			}
			while (!commandDone);
			if (command.isQuit()) 
				break;
			}
			
			
		}while (!command.isQuit() );
			
	}
}
