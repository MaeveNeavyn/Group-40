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
		view.displayBoard(board, players[0], players[1]);
		

	}

}
