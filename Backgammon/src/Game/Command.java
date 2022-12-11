package Game;


public class Command {

	// CommandType lists all valid commands
	private enum CommandType {ROLL, QUIT, PIP, HINT, DICE, TEST, DOUBLE};
	private CommandType commandType;
	private char roll1, roll2;
	private String fileName;
	
	
	//User inputs commands for quit, roll, pips, hint, dice, test, double 
	Command (String input) {
		String inputFormatted = input.trim().toUpperCase();
		if (inputFormatted.equals("QUIT")) {
			commandType = CommandType.QUIT;
		} 
		else if (inputFormatted.equals("ROLL")) {
			commandType = CommandType.ROLL;
		} 
		else if (inputFormatted.equals("PIP")) {
			commandType = CommandType.PIP;	
		} 
		else if (inputFormatted.equals("HINT")) {
			commandType = CommandType.HINT;
		} 
	
		else if (inputFormatted.matches("DICE\s[1-6][1-6]")) {
			commandType = CommandType.DICE;
			roll1 = inputFormatted.charAt(5);
			roll2 = inputFormatted.charAt(6);
		}
		else if (inputFormatted.matches("DOUBLE")) {
			commandType = CommandType.DOUBLE;
		}
		else {
			commandType = CommandType.TEST;
			
			String[] str = inputFormatted.split("\s");
			str[1] = str[1].toLowerCase();
			fileName = str[1];
		
			
		}
			
		
	}
	
	
	//Methods below check which command user entered
	public boolean isQuit() {
		return commandType == CommandType.QUIT;
	}
	
	public boolean isDouble() {
		return commandType == CommandType.DOUBLE;
	}
	public boolean isRoll () {
		return commandType == CommandType.ROLL;
	}

	public boolean isPip() {
		return commandType == CommandType.PIP;
	}
	
	public boolean isHint() {
		return commandType == CommandType.HINT;
	}
	
	public boolean isDice() {
		return commandType == CommandType.DICE;
	}
	
	public boolean isTestFile() {
		return commandType == CommandType.TEST;
		
	}
	
	// Used in view - Checks if the command entered is valid
	public static boolean isValid (String input) {
		String inputFormatted = input.trim().toUpperCase();
		//System.out.println(inputFormatted);
		return  inputFormatted.equals("ROLL") || 
				inputFormatted.equals("PIP") ||
				inputFormatted.equals("HINT") ||
				//inputFormatted.equals("MOVE") ||
				inputFormatted.equals("QUIT") ||
				inputFormatted.equals("DOUBLE") ||
				//inputFormatted.matches("TEST\s\\.txt") ||
				(inputFormatted.contains("TEST") && inputFormatted.endsWith(".TXT")) ||
				inputFormatted.matches("DICE\s[1-6][1-6]");
				//inputFormatted.matches("[P1-7DHCS][1-7DHCS][0-9]*");
		
	}
	
	
	// REturns the values of the dice
	public int getDice1() {
		int dice1 = roll1 -'0';
		return dice1;
	}
	public int getDice2() {
		int dice2 = roll2 -'0';
		return dice2;
	}
	
	// Returns the filename entered by the user as a string
	public String getFileName() {
		return fileName;
	}
		
		
}	
	
	
	
