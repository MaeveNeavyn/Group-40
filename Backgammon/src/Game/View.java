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
		System.out.println("Welcome to Backgammon\n");
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
			//command = new Command(input);
			//commandEntered = true;
			if (Command.isValid(input)) {
				command = new Command(input);
				commandEntered = true;
			} else {
				System.out.println("The command is invalid. Try again.");
			}
		}
		while (!commandEntered);
		return command;
	}
	
	
	
	public void displayPlayer( Player player)
	{
		System.out.println("\nPlayer: " + player.getName());
		System.out.println("Pips: " + player.getPips());
		System.out.println("Score: " + player.getScore());
		
	}
	
	
	
	
	public void displayBoard (Board board, Player player1, Player player2)
	{
		displayPlayer(player1);
		displayPlayer(player2);
		
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("|  13  |  14  |  15  |  16  |  17  |  18  |       |   19  |  20  |  21  |  22  |  23  |  24  | ");
		System.out.println("---------------------------------------------------------------------------------------------");
		
		for (int i=0;i<6;i++)
		{
			//System.out.println("Test");
			for (int j = 12; j<24;j++)
			{
				// if theres nothing in the point eg 11, it prints empty
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
		System.out.println("--------------------------------------------------------------------------------------------\n");
	}
	
	
	public void displayMove (Player player, int[] rolls) {
		System.out.println(player.toString() + " rolls dice:\n" + "Roll 1: " + rolls[0] + "\nRoll 2: " + rolls[1] );
		
	}
	
	
	public void displayQuit (Player player) {
		System.out.println(player.toString() + " has quit the game.");
	}
	
	public int displayFirstRoll (Player player, int roll) {
		System.out.println(player.toString() + " first rolls: " + roll);
		return roll;
	}
	
	
	public void displayPipCounts (Player player1, Player player2) {
		System.out.println(player1.toString() + " pips: " + player1.getPips());
		System.out.println(player2.toString() + " pips: " + player2.getPips());
	}
	
	public void displayHints(Player player) {
		System.out.println("Type ROLL to roll the dice");
		System.out.println("Type QUIT to quit the game");
		System.out.println("Type PIP to display the pip count for both players");
		//lists all possible moves for player
	}
	
	
	//Unused right now
	/*
	public int[][] allLegalMoves(Player player, Board board)
	{
		player.getRolls();
		player.getPlayerNumber();
		
	}*/
	
	
	// Going from 24 to 1 
	// Goes through each point checks the top element of the stack (element in point)
	// If element is an O, it gets the size of the point (number of O's)
	// Multiplies by the point value to get pip count
	public int pipCountO(Board board) {
		int i;
		int pipCount = 0;		// Initializes Pip count

		for (i=0; i<24; i++) {
		
			Stack<Checkers> point = board.getPoint(i);
			int pips = 0;
			int pointValue = i+1;
			int numCheckers = board.getPoint(i).size();
			int numCheckerO = 0;
			
			// determines if any checkers in point i
			if (numCheckers != 0) {
				if (point.peek().toString().contains("O")) {		// Checks if O checkers are in point
					numCheckerO = point.size();						// Gets amount of O Checkers in point
				} 
			}
			pips = pointValue*numCheckerO;
			pipCount += pips;
		}
		return pipCount;
	}
	
	
	//Going from 1 to 24
	public int pipCountX(Board board) {
		int i;
		int j = 24;
		int pipCount = 0;		// Initializes Pip count
		for (i=0; i<24; i++) {
		
			Stack<Checkers> point = board.getPoint(i);
			int numCheckers = board.getPoint(i).size();
			int pips = 0;
			int numCheckerX = 0;
			
			if (numCheckers != 0) {
				if (point.peek().toString().contains("X")) {		// Checks if X checkers are in point
					numCheckerX = point.size();						// Gets amount of X Checkers in point
				}
			}
			pips = j*numCheckerX;
			j--;
			pipCount += pips;
		}
		return pipCount;
	}
	
	
	
	
	
	
}
