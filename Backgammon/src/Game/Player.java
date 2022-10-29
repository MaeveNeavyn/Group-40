package Game;

public class Player {
	
	private String name;
	private int pips;
	private int score;
	private int roll1, roll2;
	
	Player (String name) 
	{
		this.name = name;
		pips = 167;
		score = 0;
	}
	
	public void move (int roll1, int roll2, Board board )
	{
		this.roll1 = roll1;
		this.roll2 = roll2;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getPips()
	{
		return pips;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public int[] getRolls()
	{
		int [] rolls = {roll1,roll2};
		return rolls;
	}

}
