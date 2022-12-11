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

		// Cycling through the number of rolled dice
		for (int i=0; i<no_dice; i++)
		{
			// If it's player 1's turn (Red X)
			if (playerNumber == 1)
				{
					// Check if the red middle point is empty
					if (board.isRedMiddlePointEmpty())
					{
						// If the red middle point is empty we cycle through all the lanes from 0-23
						for (int j=0;j<24;j++)
						{
							// Checking if there is a red checker in the lane
							if(board.isOneRedChecker(j) || board.isMultipleRedChecker(j))
							{
								// If there is a red checker in the lane we calculate the move to option using the lane and dice
								moveToOption = j + rolls.get(i);
								// If one of the options might be to move off the board
								if (moveToOption>=24)
								{
									//Cycle through the first 0-17 lanes and check if there are any red checkers there

										for (int k=0; k<18;k++)
										{
											if(board.isOneRedChecker(k) || board.isMultipleRedChecker(k))
													{
														// If there are any red checkers outside of the end zone you cannot move home
														not_option = true;
														break;
													}
										}

										//If there are no red checkers outside of the end zone we create an option to move home
										if (not_option == false)
										{
											Option current_option = new Option();
											no_options = no_options+1;
											current_option.setPlayerNumber(playerNumber);
											current_option.setKnockOpponent(false);
											current_option.setMoveFrom(j);
											//Saying you are moving to 0
											current_option.setMoveTo(25);
											current_option.setOptionNumber(no_options);
											current_option.setNoDice(i+1);
											System.out.println(current_option.toString());
											options.push(current_option);
										}
									}
									// If the move to Option is not home check if there is a blue checker at the move to option
									else if (board.isOneBlueChecker(moveToOption))
									{
										// If there is a blue checker set Knock Opponent to be true
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
									// If there is no blue checker there we can still move onto that point
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
						// If there is a red checker in the middle lane must move that first
						moveToOption = -1 + rolls.get(i);
						// Move option for knocking a blue checker off from middle lane
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
						// Move option for not knocking a blue checker off moving from middle lane
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
					// If player number 2 is playing same cycle as above is used but swapped for player 2
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
											current_option.setMoveTo(25);
											current_option.setOptionNumber(no_options);
											current_option.setNoDice(i+1);
											System.out.println(current_option.toString());
											options.push(current_option);
										}
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

	// When player picks an option the option they picked is returned
	public Option pickOption(int i)
	{
		return options.get(i);
	}

	// Once an option is chosen all options need to be removed
	public void clearOptions()
	{
		options.clear();
	}

	// Returns the number of options available
	public int size()
	{
		return options.size();
	}



}
