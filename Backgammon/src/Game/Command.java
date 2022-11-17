package Game;


public class Command {

	private enum CommandType {ROLL, QUIT, PIP, HINT, MOVE};
	
	private char moveFrom;
	private char moveTo;
	private CommandType commandType;
	
	
	//User inputs commands for quit and roll
	Command (String input) {
		String inputFormatted = input.trim().toUpperCase();
		if (inputFormatted.equals("QUIT")) {
			commandType = CommandType.QUIT;
		} else if (inputFormatted.equals("ROLL")) {
			commandType = CommandType.ROLL;
		} else if (inputFormatted.equals("PIP")) {
			commandType = CommandType.PIP;	
		} else if (inputFormatted.equals("HINT")) {
			commandType = CommandType.HINT;
		} else if (inputFormatted.equals("MOVE")) {
			commandType = CommandType.MOVE;
			moveFrom = inputFormatted.charAt(0);
			moveTo = inputFormatted.charAt(1);
		}
	}
	
	
	public boolean isQuit() {
		return commandType == CommandType.QUIT;
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
	
	
	
	
	// added in move command for testing to move checker
	public boolean isMove() {
		return commandType == CommandType.MOVE;
	}
	
	
	public static boolean isValid (String input) {
		String inputFormatted = input.trim().toUpperCase();
		return  inputFormatted.equals("ROLL") || 
				inputFormatted.equals("PIP") ||
				inputFormatted.equals("HINT") ||
				inputFormatted.equals("MOVE") ||
				inputFormatted.equals("[1-24][1-24]*");
				//inputFormatted.matches("[P1-7DHCS][1-7DHCS][0-9]*");
		
	}
	
	
	public boolean isMoveFromPoint() {
		return Character.toString(moveFrom).matches("[1-24]");
	}
	
	public boolean isMoveToPoint() {
		return Character.toString(moveTo).matches("[1-24]");
	}
	
	public int getToIndex() {
		if (isMoveToPoint()) { 
			int a = Character.getNumericValue(moveTo) - 1;
			 		//saying this isn't integer value on its own so added in else return 1
		} 
		return moveTo-1;
	}
	
	public int getFromIndex() {
		if (isMoveFromPoint()) {
			return Character.getNumericValue(moveFrom) - 1;
		} 
	}
		
		
		
}	
	
	
	
