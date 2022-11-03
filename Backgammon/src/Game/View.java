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
			command = new Command(input);
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
		
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("|  13  |  14  |  15  |  16  |  17  |  18  |       | 19  |  20  |  21  |  22  |  23  |  24  | ");
		System.out.println("---------------------------------------------------------------------------------------------");
		
		for (int i=0;i<6;i++)
		{
			//System.out.println("Test");
			for (int j = 12; j<24;j++)
			{
				if (board.getPoint(j).size()<=i)
					System.out.print("|      ");
				else
					System.out.print("|  " + board.getPoint(j).get(i).toString() +"   ");
				//System.out.print("j = "+j);
				if (j == 17)
					System.out.print("|       ");
			}
			System.out.println("|");
		}
		
		System.out.println("------------------------------------------|       |------------------------------------------");
		System.out.println("|                                         |       |                                         |");
		System.out.println("|                                         |       |                                         |");
		System.out.println("|                                         |       |                                         |");
		System.out.println("|                                         |       |                                         |");
		System.out.println("------------------------------------------|       |------------------------------------------");
		
		
		for (int i=5;i>-1;i--) 
		{
			for (int j = 11; j>-1;j--)
			{
				if (board.getPoint(j).size()<=i)
					System.out.print("|      ");
				else
					System.out.print("|  " + board.getPoint(j).get(i).toString() +"   ");
				//System.out.print("j = "+j);
				if (j == 6)
					System.out.print("|       ");
				if (j == 17)
					System.out.print("|       ");
			}
			System.out.println("|");
		}
		
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("|  12  |  11  |  10  |   9  |   8  |   7  |       |   6  |   5  |   4  |   3  |   2  |   1  | ");
		System.out.println("--------------------------------------------------------------------------------------------");
	}
	
	
	public void displayMove (Player player, int[] rolls) {
		System.out.println(player.toString() + " rolls dice:\n" + "Roll 1: " + rolls[0] + "\nRoll 2: " + rolls[1] );
		
	}
	
	
	public void displayQuit () {
		System.out.println("Quit");
	}
	
	
	
	
	

}
