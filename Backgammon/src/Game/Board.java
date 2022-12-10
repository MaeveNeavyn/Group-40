package Game;
import java.util.*;

public class Board {
	
	public final static int NUM_POINTS = 24;
	//private Stack<Checkers> point;
	private List<Stack<Checkers>> points; 
	private Stack<Checkers> blue_middle_point = new Stack<Checkers>();
	private Stack<Checkers> red_middle_point = new Stack<Checkers>();;
	private BlueCheckers blue_pile;
	private RedCheckers red_pile;
	
	
	Board()
	{
		blue_pile = new BlueCheckers();		//player 1
		red_pile = new RedCheckers(); 		//player 2
		points = new ArrayList<>(NUM_POINTS);
		
		//point = new Stack<>();
		for (int i = 0; i<NUM_POINTS; i++)
		{
			points.add(new Stack<>());
			// initialising red checkers
			if (isRedStartPoint(i))
			{
				
				for (int j = 0; j<noRedCheckers(i); j++)	// adds number of red checkers based on index value i
				points.get(i).push(red_pile.pop());
				
			}
			else if (isBlueStartPoint(i))
			{
				for (int j = 0; j<noBlueCheckers(i); j++)
				points.get(i).push(blue_pile.pop());
			}
		}
		
		
	}
	
	private boolean isRedStartPoint(int index) {
		if (index == 0 || index == 11 || index == 16 || index == 18) {
			return true;
		}
		else
			return false;	
	}
	
	public int noRedCheckers(int index) {
		if (index==0) {
			return 2;
		}
		else if (index == 11) {
			return 5;
		}
		else if (index == 16) {
			return 3;
		}
		else if (index == 18) {
			return 5;	
		}
		else
			return 0;
	}
	
	private boolean isBlueStartPoint(int index) {
		if (index == 5 || index == 7 || index == 12 || index == 23) {
			return true;
		}
		else
			return false;	
	}
	
	public int noBlueCheckers(int index) {
		if (index==23) {
			return 2;
		}
		else if (index == 12) {
			return 5;
		}
		else if (index == 7) {
			return 3;
		}
		else if (index == 5) {
			return 5;	
		}
		else
			return 0;
	}
	
	
	
	public Stack<Checkers> getPoint(int index) {	//gets lane (point) number
		return points.get(index);
	}
	
	/*
	public void move(Command command) {
		if (command.isMoveFromPoint() && command.isMoveToPoint()) {
			Checkers checker = point.pop();
			points.get(command.getToIndex()).push(checker);
					
		}
	}*/
	
	public void move(Option move) {
		
		/*First need to check if there's a checker being removed from the destination point
		 * If there is then I need to remove that checker first into a Checker variable
		 * Then I need to check if that checker is red or blue and move it into the appropriate middle lane
		 * I can then move my original checker from the moveFrom lane to the moveTo lane
		 */
		
		if (move.getKnockOpponent())
		{
			Checkers moving_checker = points.get(move.getMoveTo()).pop();
			{
				if (moving_checker.getcolour() == CheckerColour.RED)
				{
					red_middle_point.push(moving_checker);
				}
				else
					blue_middle_point.push(moving_checker);
				
				if (move.getMoveFrom() == -1)
				{
					if (move.getPlayerNumber() == 1)
						points.get(move.getMoveTo()).push(red_middle_point.pop());
					else
						points.get(move.getMoveTo()).push(blue_middle_point.pop());
				}
				else
					points.get(move.getMoveTo()).push(points.get(move.getMoveFrom()).pop());
			}
		}
		else if (move.getMoveTo() == 0)
			{
				blue_pile.push(points.get(move.getMoveFrom()).pop());
			}
		else
			if (move.getMoveFrom() == -1)
			{
				if (move.getPlayerNumber() == 1)
					points.get(move.getMoveTo()).push(red_middle_point.pop());
				else
					points.get(move.getMoveTo()).push(blue_middle_point.pop());
			}
			else
				points.get(move.getMoveTo()).push(points.get(move.getMoveFrom()).pop());
		
		System.out.println("Player moves from point " + (move.getMoveFrom()+1) + " to " + (move.getMoveTo()+1) + " using dice number: " + (move.getNoDice()+1));		
	}
	
	public boolean isOneRedChecker(int pointNumber) 
	{
		if (points.get(pointNumber).size()==1)
		{
			if(points.get(pointNumber).peek().toString().contains("X"))
				return true;
			else 
				return false;
		}
		
		else
		return false;
	
	}
		
	public boolean isOneBlueChecker(int pointNumber) 
	{
		if (points.get(pointNumber).size()==1)
		{
			if(points.get(pointNumber).peek().toString().contains("O"))
				return true;
			else 
				return false;
		}
		
		else
		return false;
	
	}
	
	public boolean isMultipleRedChecker( int pointNumber)
	{
		if (points.get(pointNumber).size()>1)
		{
			if(points.get(pointNumber).peek().toString().contains("X"))
				return true;
			else 
				return false;
		}
		
		else
		return false;
	}
	
	public boolean isMultipleBlueChecker( int pointNumber)
	{
		if (points.get(pointNumber).size()>1)
		{
			if(points.get(pointNumber).peek().toString().contains("O"))
				return true;
			else 
				return false;
		}
		
		else
		return false;
	}
	
	public boolean isPointEmpty (int pointNumber)
	{
		if (points.get(pointNumber).size()==0)
			return true;
		else 
			return false;
	}
	
	public boolean isBlueMiddlePointEmpty()
	{
		if (blue_middle_point.size() == 0)
			return true;
		else
			return false;
	}
	
	public boolean isRedMiddlePointEmpty()
	{
		if (red_middle_point.size() == 0)
			return true;
		else
			return false;
	}

	
	
	/*
	//Get Pip count value for all 0's
	public int pipValueO() {
		int pipCount = 0;
		int i;
		points = new ArrayList<>(NUM_POINTS);
		point = new Stack<Checkers>(); 
		for (i=0; i< NUM_POINTS; i++) {	//point value in terms of array number
			//Initialize values back to 0 for each point check
			int numCheckers = 0;
			int pointValue = 0;
			int pips = 0;
			/*
			//if (points.get(i).contains("O")) {
				//numCheckers = points.size();
				numCheckers = Collections.frequency(points, "O");
				
				pips = pointValue*numCheckers;
				pipCount += pips;
			//}
			
			pointValue = i+1;
			System.out.println("Point value is: " + pointValue);
			System.out.println("Number of checkers in point is: " + board.getPoint().point.size());
		}
		return pipCount;
	}*/
	
	
public String printBlueMPoint()
{
	String str = blue_middle_point.toString();
	return str;
}
	
public String printRedMPoint()
{
	String str = red_middle_point.toString();
	return str;
}
	
	

}
