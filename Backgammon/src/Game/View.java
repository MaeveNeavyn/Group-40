package Game;
import java.util.*;

public class View {
	
	//private final static String BLANK = "   ";

	Scanner in;
	Command command;
	
	View () {
		in = new Scanner(System.in);
	}

	public void displayWelcome()
	{
		System.out.println("Welcome to Backgammon");
	}
	
	public String getName () {
		System.out.print("Enter the player name: ");
		String name = in.nextLine();
		return name;
	}
	
	
	
	public Command getCommand () {
		return command;
	}
	
	public Command getUserInput (Player player) {
		boolean commandEntered = false;
		do {
			System.out.println(player.toString() + " enter command: ");	//issue with printing player name
			String input = in.nextLine();
			commandEntered = true;
			/*if (Command.isValid(input)) {
				command = new Command(input);
				commandEntered = true;
			} else {
				System.out.println("The command is invalid. Try again.");
			}*/
		}
		while (!commandEntered);
		return command;
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
	
	
	public void displayMove (Player player) {
		System.out.println(player + "rolls " + player.getRolls() + ". ");
		
	}
	
	
	public void displayQuit () {
		System.out.println("Quit");
	}
	
	
	
	
	

}
