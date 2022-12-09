package Game;
import java.util.*;

public class LegalMoves {

	private Stack<Option> options = new Stack<Option>();
	int no_options = 0;
	
	LegalMoves (Board board, Player player, List<Integer> rolls)
	{
		int moveToOption;
		no_options = 0;
		int playerNumber = player.getPlayerNumber();
		int no_dice = rolls.size();
		boolean not_option = false;
		
		for (int i=0; i<no_dice; i++)
		{
			if (playerNumber == 1)
				{
					if (board.isRedMiddlePointEmpty())
					{
						for (int j=0;j<24;j++)
						{
							if(board.isOneRedChecker(j) || board.isMultipleRedChecker(j))
							{
								moveToOption = j + rolls.get(i);
								if (moveToOption>=24)
								{
									//Brain is gone we changed things here and now I'm confused
									
										for (int k=0; k<18;k++)
										{
											if(board.isOneRedChecker(k) || board.isMultipleRedChecker(k))
													{
														not_option = true;
														break;
													}
										}
										if (not_option == false)
										{
											Option current_option = new Option();
											no_options = no_options+1;
											current_option.setPlayerNumber(playerNumber);
											current_option.setKnockOpponent(false);
											current_option.setMoveFrom(j);
											current_option.setMoveTo(0);
											current_option.setOptionNumber(no_options);
											current_option.setNoDice(i+1);
											System.out.println(current_option.toString());
											options.push(current_option);
										}
									}
									else if (board.isOneBlueChecker(moveToOption))
									{
										Option current_option = new Option();
										no_options = no_options +1;
										current_option.setPlayerNumber(playerNumber);
										current_option.setKnockOpponent(true);
										current_option.setMoveFrom(j);
										current_option.setMoveTo(moveToOption);
										current_option.setOptionNumber(no_options);
										current_option.setNoDice(i+1);
										System.out.println(current_option.toString());
										options.push(current_option); 
									}
									else if (board.isOneRedChecker(moveToOption) || board.isMultipleRedChecker(moveToOption)|| board.isPointEmpty(moveToOption))
									{
										Option current_option = new Option();
										no_options = no_options +1;
										current_option.setPlayerNumber(playerNumber);
										current_option.setKnockOpponent(false);
										current_option.setMoveFrom(j);
										current_option.setMoveTo(moveToOption);
										current_option.setOptionNumber(no_options);
										current_option.setNoDice(i+1);
										System.out.println(current_option.toString());
										options.push(current_option);
									}
								}	
							}
						}
					
					else
					{
						moveToOption = 0 + rolls.get(i);
						if (board.isOneBlueChecker(moveToOption))
						{
							Option current_option = new Option();
							no_options = no_options +1;
							current_option.setPlayerNumber(playerNumber);
							current_option.setKnockOpponent(true);
							current_option.setMoveFrom(-1);
							current_option.setMoveTo(moveToOption);
							current_option.setOptionNumber(no_options);
							current_option.setNoDice(i+1);
							System.out.println(current_option.toString());
							options.push(current_option); 
						}
						else if (board.isOneRedChecker(moveToOption) || board.isMultipleRedChecker(moveToOption)|| board.isPointEmpty(moveToOption))
						{
							Option current_option = new Option();
							no_options = no_options +1;
							current_option.setPlayerNumber(playerNumber);
							current_option.setKnockOpponent(false);
							current_option.setMoveFrom(-1);
							current_option.setMoveTo(moveToOption);
							current_option.setOptionNumber(no_options);
							current_option.setNoDice(i+1);
							System.out.println(current_option.toString());
							options.push(current_option);
						}
						
					}
				}
				else 
				{
					if (board.isBlueMiddlePointEmpty())
					{
						//System.out.println("No checkers in middle point for player 2");
						for (int j=23;j>=0;j--)
						{
							//System.out.println("Checking point: " +j);
							if(board.isOneBlueChecker(j) || board.isMultipleBlueChecker(j))
							{
								//System.out.println("There is a blue checker at this point");
								moveToOption = j - rolls.get(i);
								//System.out.println("Checking if can move to point: "+moveToOption);
								if (moveToOption <= -1)
									{
										//System.out.println("Move to option would play checker off checking if that's allowed happen");
										for (int k=23; k>7;k--)
										{
											if(board.isOneBlueChecker(k) || board.isMultipleBlueChecker(k))
											{	
												//System.out.println("Not allowed to move checkers off board yet");
												break;
											}
										}
										Option current_option = new Option();
										no_options = no_options+1;
										current_option.setPlayerNumber(playerNumber);
										current_option.setKnockOpponent(false);
										current_option.setMoveFrom(j);
										current_option.setMoveTo(0);
										current_option.setOptionNumber(no_options);
										current_option.setNoDice(i+1);
										System.out.println(current_option.toString());
										options.push(current_option);
									}
									else if (board.isOneRedChecker(moveToOption))
									{
										Option current_option = new Option();
										no_options = no_options +1;
										current_option.setPlayerNumber(playerNumber);
										current_option.setKnockOpponent(true);
										current_option.setMoveFrom(j);
										current_option.setMoveTo(moveToOption);
										current_option.setOptionNumber(no_options);
										current_option.setNoDice(i+1);
										System.out.println(current_option.toString());
										options.push(current_option);
									}
									else if (board.isOneBlueChecker(moveToOption) || board.isMultipleBlueChecker(moveToOption)|| board.isPointEmpty(moveToOption))
									{
										Option current_option = new Option();
										no_options = no_options +1;
										current_option.setPlayerNumber(playerNumber);
										current_option.setKnockOpponent(false);
										current_option.setMoveFrom(j);
										current_option.setMoveTo(moveToOption);
										current_option.setOptionNumber(no_options);
										current_option.setNoDice(i+1);
										System.out.println(current_option.toString());
										options.push(current_option);
										
									}
								
							}
						}
					}
					else
					{
						moveToOption = 24 - rolls.get(i);
						if (board.isOneRedChecker(moveToOption))
						{
							Option current_option = new Option();
							no_options = no_options +1;
							current_option.setPlayerNumber(playerNumber);
							current_option.setKnockOpponent(true);
							current_option.setMoveFrom(-1);
							current_option.setMoveTo(moveToOption);
							current_option.setOptionNumber(no_options);
							current_option.setNoDice(i+1);
							System.out.println(current_option.toString());
							options.push(current_option); 
						}
						else if (board.isOneBlueChecker(moveToOption) || board.isMultipleBlueChecker(moveToOption)|| board.isPointEmpty(moveToOption))
						{
							Option current_option = new Option();
							no_options = no_options +1;
							current_option.setPlayerNumber(playerNumber);
							current_option.setKnockOpponent(false);
							current_option.setMoveFrom(-1);
							current_option.setMoveTo(moveToOption);
							current_option.setOptionNumber(no_options);
							current_option.setNoDice(i+1);
							System.out.println(current_option.toString());
							options.push(current_option);
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
	
	public int size()
	{
		return options.size();
	}
	
	
	
}
