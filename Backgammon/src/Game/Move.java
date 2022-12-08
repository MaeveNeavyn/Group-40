package Game;

public class Move {
	
	private int moveFrom;
	private int moveTo;
	private boolean knockOpponent;
	private int no_dice;
	
	public Move (int moveFrom, int moveTo, boolean knockOpponent, int no_dice)
	{
		this.moveFrom = moveFrom;
		this.moveTo = moveTo;
		this.knockOpponent = knockOpponent;
		this.no_dice = no_dice;
	}
	
	public int getMoveFrom()
	{
		return moveFrom;
	}
	
	public int getMoveTo()
	{
		return moveTo;
	}
	
	public boolean getKnockOpponent()
	{
		return knockOpponent;
	}
	
	public int getNoDice()
	{
		return no_dice;
	}
	

}
