package Game;
import java.util.*;

public class Board {
	
	public final static int NUM_POINTS = 24;
	private List<Stack<Checkers>> points; 
	private final static int[] RED_START = {1, 1, 12, 12, 12, 12, 12, 17, 17, 17, 19, 19, 19, 19, 19};
	private final static int[] BLUE_START = {24, 24, 13, 13, 13, 13, 13, 8, 8, 8, 6, 6, 6, 6, 6};
	
	
	Board()
	{
		points = new ArrayList<>(NUM_POINTS);
		for (int i = 0; i<NUM_POINTS; i++)
		{
			points.add(new Stack<>());
			if (isRedStartPoint(i))
			{
				points.get(i).push(Checkers.RED_CHECKER);
			}
			else if (isBlueStartPoint(i))
			{
				points.get(i).push(Checkers.BLUE_CHECKER);
			}
		}
		
		
	}
	
	private boolean isRedStartPoint(int index)
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
	
	private boolean isBlueStartPoint(int index)
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
