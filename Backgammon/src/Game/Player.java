package Game;

public class Player {
	
	private String name;
	private int player_number;
	private int score;
//	private int roll1, roll2;
	private int pips;
	
	Player (String name, int player_number, int pips, int score) 
	{
		this.name = name;
		this.player_number = player_number;
		this.pips = pips;
		this.score = score;
		//roll1 = 1;
	//	roll2 = 1;
		
	}
	
	/*public void move (int roll1, int roll2, Board board )
	{
		this.roll1 = roll1;
		this.roll2 = roll2;
		
	}*/
	
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
	
	/*public int[] getRolls()
	{
		
		int [] rolls = {roll1,roll2};
		return rolls;
	}*/
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
