package Game;

public class Board {
	
	public final static int NUM_POINTS = 24;
	private Points[] points;
	private final static int[] RED_START = {1, 1, 12, 12, 12, 12, 12, 17, 17, 17, 19, 19, 19, 19, 19};
	private final static int[] BLUE_START = {24, 24, 13, 13, 13, 13, 13, 8, 8, 8, 6, 6, 6, 6, 6};
	
	
	Board()
	{
		points = new Points[NUM_POINTS + 1];
		for (int i=1; i<NUM_POINTS; i++)
		{
			if (isRedStartSquare(i))
			{
				points[i] = new Checkers(RED_CHECKER);
			}
		}
		
	}
	
	private boolean isRedStartSquare(int index)
	{
		for(int i=0; i<RED_START.length; i++)
		{
			if (RED_START[i] ==index)
			{
				return true;
			}
			
		}
		return false;
	}
	
	private boolean isBlueStartSquare(int index)
	{
		for(int i=0; i<BLUE_START.length; i++)
		{
			if (BLUE_START[i] ==index)
			{
				return true;
			}
			
		}
		return false;
	}

}
