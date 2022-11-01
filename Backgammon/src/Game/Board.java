package Game;
import java.util.*;

public class Board {
	
	public final static int NUM_POINTS = 24;
	private List<Stack<Checkers>> points; 
	private BlueCheckers blue_pile;
	private RedCheckers red_pile;
	
	
	Board()
	{
		blue_pile = new BlueCheckers();
		red_pile = new RedCheckers();
		points = new ArrayList<>(NUM_POINTS);
		for (int i = 0; i<NUM_POINTS; i++)
		{
			points.add(new Stack<>());
			if (isRedStartPoint(i))
			{
				
				for (int j = 0; j<noRedCheckers(i); j++)
				points.get(i).push(red_pile.pop());
				
			}
			else if (isBlueStartPoint(i))
			{
				for (int j = 0; j<noBlueCheckers(i); j++)
				points.get(i).push(blue_pile.pop());
			}
		}
		
		
	}
	
	private boolean isRedStartPoint(int index)
	{
		if (index == 0 || index == 11 || index == 16 || index == 18)
		{
			return true;
		}
		else
			return false;
		
	}
	
	public int noRedCheckers(int index)
	{
		if (index==0)
		{
			return 2;
		}
		else if (index == 11)
		{
			return 5;
		}
		else if (index == 16)
		{
			return 3;
		}
		else if (index == 18)
		{
			return 5;	
		}
		else
			return 0;
	}
	
	private boolean isBlueStartPoint(int index)
	{
		if (index == 5 || index == 7 || index == 12 || index == 23)
		{
			return true;
		}
		else
			return false;
		
	}
	
	public int noBlueCheckers(int index)
	{
		if (index==23)
		{
			return 2;
		}
		else if (index == 12)
		{
			return 5;
		}
		else if (index == 7)
		{
			return 3;
		}
		else if (index == 5)
		{
			return 5;	
		}
		else
			return 0;
	}
	
	
	
	public Stack<Checkers> getPoint(int index)
	{
		return points.get(index);
	}
	
	

}
