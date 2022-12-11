package Game;

public class Option {
	private int option_number;
	private int moveFrom;
	private int moveTo;
	private int no_dice;
	private boolean knockOpponent;
	private int playerNumber;
	
	Option()
	{

	}
	
	Option (int option_number,int moveFrom,int moveTo,int no_dice,boolean knockOpponent, int playerNumber)
	{
		this.option_number = option_number;
		this.moveFrom=moveFrom;
		this.moveTo=moveTo;
		this.no_dice=no_dice;
		this.knockOpponent=knockOpponent;
		this.playerNumber=playerNumber;
		
	}
	
	public void setOptionNumber (int n)
	{
		option_number = n;
	}
	
	public void setMoveFrom (int n)
	{
		moveFrom = n;
	}
	public void setMoveTo (int n)
	{
		moveTo = n;
	}
	public void setNoDice (int n)
	{
		no_dice = n;
	}
	public void setKnockOpponent (boolean n)
	{
		knockOpponent = n;
	}
	
	public int getOptionNumber()
	{
		return option_number;
	}
	
	public int getMoveFrom()
	{
		return moveFrom;
	
	}
	public int getMoveTo()
	{
		return moveTo;
	}
	public int getNoDice()
	{
		return no_dice;
	}
	
	public boolean getKnockOpponent()
	{
		return knockOpponent;
	}
	
	public String toString()
	{
		String str = "Option: "+ (option_number) + " is move from point " + (moveFrom+1) + " to point " + (moveTo+1) + " using dice number: " + no_dice;
		return str;
	}
	
	public void setPlayerNumber(int n)
	{
		playerNumber = n;
	}
	
	public int getPlayerNumber()
	{
		return playerNumber;
	}
		

}
