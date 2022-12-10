package Game;


public class Command {

	private enum CommandType {ROLL, QUIT, PIP, HINT, MOVE, DICE, TEST, DOUBLE};
	
	//private char moveFrom;
	//private char moveTo;
	private CommandType commandType;
	private char roll1, roll2;
	private String fileName;
	
	
	//User inputs commands for quit, roll, pips, hint, dice, test 
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
		//else if (inputFormatted.equals("MOVE")) {
		//	commandType = CommandType.MOVE;
		//}
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
			fileName = str[1];
			
			
		}
			
		
	}
	
	
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
	
	// added in move command for testing to move checker
	/*public boolean isMove() {
		return commandType == CommandType.MOVE;
	}*/
	
	public boolean isTestFile() {
		
		
		return commandType == CommandType.TEST;
	}
	
	// Used in view
	public static boolean isValid (String input) {
		String inputFormatted = input.trim().toUpperCase();
		return  inputFormatted.equals("ROLL") || 
				inputFormatted.equals("PIP") ||
				inputFormatted.equals("HINT") ||
				inputFormatted.equals("MOVE") ||
				inputFormatted.equals("QUIT") ||
				inputFormatted.equals("DOUBLE") ||
				inputFormatted.matches("DICE\s[1-6][1-6]");
				//inputFormatted.matches("[P1-7DHCS][1-7DHCS][0-9]*");
		
	}
	
	
	public int getDice1() {
		int dice1 = roll1 -'0';
		return dice1;
	}
	public int getDice2() {
		int dice2 = roll2 -'0';
		return dice2;
	}
	
	public String getFileName() {
		return fileName;
	}
		
		
}	
	
	
	
