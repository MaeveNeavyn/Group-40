package Game;

public class Player {
	
	private String name;
	private int pips;
	private int score;
	
	Player (String name) 
	{
		this.name = name;
		pips = 167;
		score = 0;
	}
	
	public String getName()
	{
		return name;
	}

}
