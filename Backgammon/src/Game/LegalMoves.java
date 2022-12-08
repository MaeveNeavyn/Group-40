package Game;
import java.util.*;

public class LegalMoves {

	private Stack<Option> options = new Stack<Option>();
	int no_options = 0;
	
	LegalMoves (Board board, Player player, List<Integer> rolls)
	{
		Option current_option = new Option();
		int moveToOption;
		no_options = 0;
		int playerNumber = player.getPlayerNumber();
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
								no_options = no_options +1;
								current_option.setKnockOpponent(true);
								current_option.setMoveFrom(j);
								current_option.setMoveTo(moveToOption);
								current_option.setOptionNumber(no_options);
								current_option.setNoDice(i+1);
								System.out.println(current_option.toString());
								options.push(current_option); //This is not working right 
								System.out.println("Size options: " + options.size());
								System.out.println(options.get(0).toString());
								System.out.println(options.get(no_options-1).toString());
							}
							else if (board.isOneRedChecker(moveToOption) || board.isMultipleRedChecker(moveToOption)|| board.isPointEmpty(moveToOption))
							{
								no_options = no_options +1;
								current_option.setKnockOpponent(false);
								current_option.setMoveFrom(j);
								current_option.setMoveTo(moveToOption);
								current_option.setOptionNumber(no_options);
								current_option.setNoDice(i+1);
								System.out.println(current_option.toString());
								options.push(current_option);
								System.out.println("Size options: " + options.size());
								System.out.println(options.get(0).toString());
								System.out.println(options.get(no_options-1).toString());
								
							}
							
						}
					}
				}
				else 
				{
					for (int j=23;j>=0;j--)
					{
						if(board.isOneBlueChecker(j) || board.isMultipleBlueChecker(j))
						{
							moveToOption = j - rolls.get(i);
							if (board.isOneRedChecker(moveToOption))
							{
								no_options = no_options +1;
								current_option.setKnockOpponent(true);
								current_option.setMoveFrom(j);
								current_option.setMoveTo(moveToOption);
								current_option.setOptionNumber(no_options);
								current_option.setNoDice(i+1);
								System.out.println(current_option.toString());
								options.push(current_option);
								System.out.println("Size options: " + options.size());
								System.out.println(options.get(0).toString());
								System.out.println(options.get(no_options-1).toString());
							}
							else if (board.isOneBlueChecker(moveToOption) || board.isMultipleBlueChecker(moveToOption)|| board.isPointEmpty(moveToOption))
							{
								no_options = no_options +1;
								current_option.setKnockOpponent(false);
								current_option.setMoveFrom(j);
								current_option.setMoveTo(moveToOption);
								current_option.setOptionNumber(no_options);
								current_option.setNoDice(i+1);
								System.out.println(current_option.toString());
								options.push(current_option);
								System.out.println("Size options: " + options.size());
								System.out.println(options.get(0).toString());
								System.out.println(options.get(no_options-1).toString());
								
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
	
	public void clearOptions()
	{
		options.clear();
	}
	
	
}
