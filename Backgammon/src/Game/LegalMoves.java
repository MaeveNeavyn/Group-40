package Game;
import java.util.*;

public class LegalMoves {

	private Stack<Option> options;
	
	LegalMoves (Board board, Player player, List<Integer> rolls)
	{
		Option current_option = new Option();
		int moveToOption;
		int playerNumber = player.getPlayerNumber();
		int no_options = 0;
		int no_dice = rolls.size();
		
		for (int i=0; i<no_dice; i++)
		{
			if (playerNumber == 1)
				{
					for (int j=0;j<24;j++)
					{
						if(board.isOneRedChecker(j) || board.isMultipleRedChecker(j))
						{
							moveToOption = j + rolls.get(i);
							if (board.isOneBlueChecker(moveToOption))
							{
								current_option.setKnockOpponent(true);
								current_option.setMoveFrom(j);
								current_option.setMoveTo(moveToOption);
								current_option.setOptionNumber(no_options+1);
								current_option.setNoDice(i+1);
								System.out.println(current_option.toString());
								options.add(current_option);
							}
							else if (board.isOneRedChecker(moveToOption) || board.isMultipleRedChecker(moveToOption)|| board.isPointEmpty(moveToOption))
							{
								current_option.setKnockOpponent(false);
								current_option.setMoveFrom(j);
								current_option.setMoveTo(moveToOption);
								current_option.setOptionNumber(no_options+1);
								current_option.setNoDice(i+1);
								System.out.println(current_option.toString());
								options.add(current_option);
								
							}
							
						}
					}
				}
				else if (playerNumber == 2) 
				{
					for (int j=23;j>=0;j--)
					{
						if(board.isOneBlueChecker(j) || board.isMultipleBlueChecker(j))
						{
							moveToOption = j - rolls.get(i);
							if (board.isOneRedChecker(moveToOption))
							{
								current_option.setKnockOpponent(true);
								current_option.setMoveFrom(j);
								current_option.setMoveTo(moveToOption);
								current_option.setOptionNumber(no_options+1);
								current_option.setNoDice(i+1);
								options.add(current_option);
							}
							else if (board.isOneBlueChecker(moveToOption) || board.isMultipleBlueChecker(moveToOption)|| board.isPointEmpty(moveToOption))
							{
								current_option.setKnockOpponent(false);
								current_option.setMoveFrom(j);
								current_option.setMoveTo(moveToOption);
								current_option.setOptionNumber(no_options+1);
								current_option.setNoDice(i+1);
								options.add(current_option);
								
							}
						}
					}
				}
		}			
	}
	
	public Option pickOption(int i)
	{
		return options.get(i);
	}
	
	
}
