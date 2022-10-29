package Game;
import java.util.*;

public class View {
	
	Scanner in;
	
	View () {
		in = new Scanner(System.in);
	}

	public void displayWelcome()
	{
		System.out.println("Welcome to Backgammon");
	}
	
	public void displayPlayer( Player player)
	{
		System.out.println("Player: " + player.getName());
		System.out.println("Pips: " + player.getPips());
		System.out.println("Score: " + player.getScore());
		
	}
	
	public void displayBoard (Board board, Player player1, Player player2)
	{
		displayPlayer(player1);
		displayPlayer(player2);
		//System.out.println(" | 13 | 14 | 15 | 16 | 17 | 18 | 19 | 20 | 21 | 22 | 23 | 24 | "); 
		List<Checkers> point1 = board.getPoint(0);
		System.out.println("Printing point 1 : "+ point1.toString());
	}
	
	
	
	public String getName () {
		System.out.print("Enter the player name: ");
		String name = in.nextLine();
		return name;
	}
	
	
	
	

}
