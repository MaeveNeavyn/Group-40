package Game;
import java.util.*;

public class LegalMoves {

	private List<String> options = new ArrayList<>();
	
	LegalMoves (Board board, Player player, int roll)
	{
		int moveFromOption;
		int moveToOption;
		int playerNumber = player.getPlayerNumber();
		int no_options = 0;
		
			if (playerNumber == 1)
			{
				for (int j=0;j<24;j++)
				{
					if(board.isOneRedChecker(j) || board.isMultipleRedChecker(j))
					{
						moveFromOption = j;
						moveToOption = j + roll;
						if (board.isOneBlueChecker(moveToOption) || board.isOneRedChecker(moveToOption) || board.isMultipleRedChecker(moveToOption)|| board.isPointEmpty(moveToOption))
						{
							int moveFromIndex = moveFromOption+1;
							int moveToIndex = moveToOption +1;
							options.add(Integer.toString(moveFromIndex) + " -> " + Integer.toString(moveToIndex));
							int index = no_options +1;
							System.out.println("Option "+ index + " is moving: " + options.get(no_options));
							no_options = no_options+1;
							
						}
					}
				}
			}
			else if (playerNumber ==2) 
			{
				for (int j=23;j<=0;j--)
				{
					if(board.isOneBlueChecker(j) || board.isMultipleBlueChecker(j))
					{
						moveFromOption = j;
						moveToOption = j - roll;
						if (board.isOneRedChecker(moveToOption) || board.isOneBlueChecker(moveToOption) || board.isPointEmpty(moveToOption))
						{
							int moveFromIndex = moveFromOption+1;
							int moveToIndex = moveToOption +1;
							options.add(Integer.toString(moveFromIndex) + " -> " + Integer.toString(moveToIndex));
							int index = no_options +1;
							System.out.println("Option "+ index + " is moving: " + options.get(no_options));
							no_options = no_options+1;
						}
					}
				}
			}
		//System.out.println(" Number of rolls to make: " + no_rolls);				
	}
	
	
}
