package Game;

public class Command {

	private enum CommandType {ROLL, QUIT, PIP, HINT};
	
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
	
}