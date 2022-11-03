package Game;

public class Command {

	private enum CommandType {ROLL, QUIT};
	
	private CommandType commandType;
	
	
	//User inputs commands for quit and roll
	Command (String input) {
		String inputFormatted = input.trim().toUpperCase();
		if (inputFormatted.equals("QUIT")) {
			commandType = CommandType.QUIT;
		} else if (inputFormatted.equals("ROLL")) {
			commandType = CommandType.ROLL;
		}	
}
	
	
	public boolean isQuit() {
		return commandType == CommandType.QUIT;
	}
	
	public boolean isRoll () {
		return commandType == CommandType.ROLL;
	}

	
}