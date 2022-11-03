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
		Command command;
		
		//do {
			
			view.displayBoard(board, players[0], players[1]);
			boolean commandDone = false;
			
			//for(int i=0; i<=1; i++){
			
			do {
				command = view.getUserInput(players[0]); //issue with printing player name
				if (command.isRoll()) {
					view.displayMove(players[0]);
					commandDone = true;
				} else if (command.isQuit()) {
					view.displayQuit();
					commandDone = true;
					
				}
				
			}
			while (!commandDone);
			
		//}while (!commandDone);
			

	

}
}
