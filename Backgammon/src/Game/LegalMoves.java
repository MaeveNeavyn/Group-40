package Game;
import java.util.*;

public class LegalMoves {
	
	int moveFrom;
	int moveTo;
	int moveFromOption;
	int moveToOption;
	int playerNumber;
	int moves_counter = 0;
	private List<Integer> rolls = new ArrayList<>();
	private List<String> options = new ArrayList<>();
	
	LegalMoves (Board board, Player player, List<Integer> rolls)
	{
		this.rolls = rolls;
		this.playerNumber = player.getPlayerNumber();
		int no_rolls = rolls.size();
		
		
		for (int i=0;i<no_rolls;i++)
		{
			if (playerNumber == 1)
			{
				for (int j=0;j<24;j++)
				{
					if(board.isOneRedChecker(j) || board.isMultipleRedChecker(j))
					{
						moveFromOption = j;
						moveToOption = j + rolls.get(i);
						if (board.isOneBlueChecker(moveToOption) || board.isOneRedChecker(moveToOption) || board.isMultipleRedChecker(moveToOption)|| board.isPointEmpty(moveToOption))
						{
							options.add(Integer.toString(moveFromOption) + " -> " + Integer.toString(moveToOption));
						}
					}
				}
			}
			else if (playerNumber ==2) 
			{
				for (int j=23;j>=0;j--)
				{
					if(board.isOneBlueChecker(j) || board.isMultipleBlueChecker(j))
					{
						moveFromOption = j;
						moveToOption = j - rolls.get(i);
						if (board.isOneRedChecker(moveToOption) || board.isOneBlueChecker(moveToOption) || board.isPointEmpty(moveToOption))
						{
							options.add(Integer.toString(moveFromOption) + " -> " + Integer.toString(moveToOption));
						}
					}
				}
			}
		}
		//System.out.println(" Number of rolls to make: " + no_rolls);
					
	}
	
	public int getMoveFrom()
	{
		return moveFrom;
	}
	
	public int getMoveTo()
	{
		return moveTo;
	}
	
	public int getPlayerNumber()
	{
		return playerNumber;
	}
	
	
}
