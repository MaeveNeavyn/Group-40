package Game;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Board board = new Board();
		Player[] players = new Player[2];
		View view = new View();
		players[0] = new Player(view.getName());
		players[1] = new Player(view.getName());
		//System.out.println("Player 1 is: " + players[0].getName());
		//System.out.println("Player 2 is: " + players[1].getName());

	}

}
