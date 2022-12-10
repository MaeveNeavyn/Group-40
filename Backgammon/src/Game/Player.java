package Game;

public class Player {
	
	private String name;
	private int player_number;
	private int score;
	private int pips;
	private boolean doubleOwnership;
	private boolean hasQuit;
	
	Player (String name, int player_number, int pips, int score, boolean doubleOwnership, boolean hasQuit) 
	{
		this.name = name;
		this.player_number = player_number;
		this.pips = pips;
		this.score = score;
		this.doubleOwnership = doubleOwnership;
		this.hasQuit = hasQuit;
		
	}
	
	public boolean hasQuit() {
		return hasQuit;
	}
	
	public void userQuitting() {
		this.hasQuit = true;
	}
	
	public boolean getDoubleOwnership() {
		return doubleOwnership; // if true, player owns double cube
		
	}
	
	public void setDoubleOwnership() {
		this.doubleOwnership = true;
	}
	
	public void removeDoubleOwnership() {
		this.doubleOwnership = false;
	}
	
	public void setPips (int pips)
	{
		this.pips = pips;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getPlayerNumber()
	{
		return player_number;
	}
	
	public int getPips()
	{
		return pips;
	}
	
	
	public int getScore()
	{
		return score;
	}
	
	public void updateScore(int gameScore) {
		this.score = gameScore;
	}
	
	public void movePlayed (Command command, Board board)
	{
		
	}
	
	public String toString()
	{
		return name;
	}
	
	
	public boolean isGameOver() {
		return pips == 0;
	}
	

}
