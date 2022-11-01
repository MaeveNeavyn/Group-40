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
		System.out.println(" | 13 | 14 | 15 | 16 | 17 | 18 | 19 | 20 | 21 | 22 | 23 | 24 | ");  
		for (int i=0; i<24;i++)
		System.out.println("Printing point " + i + " : "+ board.getPoint(i).toString());
	}
	
	
	
	public String getName () {
		System.out.print("Enter the player name: ");
		String name = in.nextLine();
		return name;
	}
	
	
	
	

}
