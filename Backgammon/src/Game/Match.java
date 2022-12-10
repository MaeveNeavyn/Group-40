package Game;

public class Match {
	
	private int matchLength;
	private int gameStake;
	
	// maybe include match value, set at 1 first then adjusted based off final game result
	
	Match(int matchLength, int gameStake) {
		this.matchLength = matchLength;
		this.gameStake = gameStake;
	}
	
	
	public int getMatchLength() {
		return matchLength;
	}
	
	public int getGameStake() {
		return gameStake;
	}
	
	public void setGameStake (int newGameStake) {
		this.gameStake = newGameStake;
	}
	

}



