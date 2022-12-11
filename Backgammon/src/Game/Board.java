package Game;
import java.util.*;

public class Board {
	
	public final static int NUM_POINTS = 24;
	private List<Stack<Checkers>> points; 
	private Stack<Checkers> blue_middle_point = new Stack<Checkers>();
	private Stack<Checkers> red_middle_point = new Stack<Checkers>();;
	private BlueCheckers blue_pile;
	private RedCheckers red_pile;
	
	// Initializes the board with all checkers in their correct spots
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
	
	// Checks if this point is a red starting point
	private boolean isRedStartPoint(int index) {
		if (index == 0 || index == 11 || index == 16 || index == 18) {
			return true;
		}
		else
			return false;	
	}
	
	// If index is a red starting point the number of checkers at that starting point is returned
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
	
	// Checks if this point is a blue starting point
	private boolean isBlueStartPoint(int index) {
		if (index == 5 || index == 7 || index == 12 || index == 23) {
			return true;
		}
		else
			return false;	
	}
	
	// If index a blue starting point the number of checkers at that starting point is returned
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
	
	
	
	//Returns the point
	public Stack<Checkers> getPoint(int index) {
		return points.get(index);
	}
	
	
	// Excecutes the move selected by the player
	public void move(Option move) {
		
		if (move.getKnockOpponent())
		{
			//For knocking opponent off move the knocked checker into a temporary checker hold
			Checkers moving_checker = points.get(move.getMoveTo()).pop();
			
				// If the knocked checker is red put it in the red middle point
				if (moving_checker.getcolour() == CheckerColour.RED)
				{
					red_middle_point.push(moving_checker);
				}
				// Else the knocked checker is blue so put it in the blue middle point
				else
					blue_middle_point.push(moving_checker);
				
				// The middle lanes are labeled as -1
				if (move.getMoveFrom() == -1)
				{
					// If Red is moving from the middle lane 
					if (move.getPlayerNumber() == 1)
						points.get(move.getMoveTo()).push(red_middle_point.pop());
					else
						// Blue is moving from the middle lane
						points.get(move.getMoveTo()).push(blue_middle_point.pop());
				}
				else
					// Checker is not moving from middle lane it is moving from a point on the board and knocking opponent off
					points.get(move.getMoveTo()).push(points.get(move.getMoveFrom()).pop());
			
		}
			// If we are moving a checker home - home is indexed as 25 
		else if (move.getMoveTo() == 25)
		{
			// Check whether moving red or blue checker
			if (move.getPlayerNumber()==1)
				red_pile.push(points.get(move.getMoveFrom()).pop());
			else
				blue_pile.push(points.get(move.getMoveFrom()).pop());
		}
		
		// If you are not moving home and are not knocking a player off
		else 
		{
			// If you are moving from middle point
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
	}
	
	// Returns true if there is one red checker in the point
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
		
	// Returns true if there is one blue checker in the point
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
	
	// Returns true if there is more than one red checker in the point
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
	
	// Return true if there is more than one blue checker in the point
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
	
	// Returns true if the point is empty
	public boolean isPointEmpty (int pointNumber)
	{
		if (points.get(pointNumber).size()==0)
			return true;
		else 
			return false;
	}
	
	// REturn true if the blue middle point is empty
	public boolean isBlueMiddlePointEmpty()
	{
		if (blue_middle_point.size() == 0)
			return true;
		else
			return false;
	}
	
	// Returns true if the red middle point is empty
	public boolean isRedMiddlePointEmpty()
	{
		if (red_middle_point.size() == 0)
			return true;
		else
			return false;
	}
	
	// Returns the size of the middle point given the player number
	public int sizeMiddlePoint(int n)
	{
		int sz;
		if (n==1)
		{
			sz = red_middle_point.size();
			return sz;
		}
		else
		{
			sz = blue_middle_point.size();
			return sz;
		}
	}
	
	// Returns true if Red has no checkers home
	public boolean isRedHomeEmpty()
	{
		if (red_pile.size() == 0)
			return true;
		else 
			return false;
	}
	
	// REturns true if blue has no players home
	public boolean isBlueHomeEmpty()
	{
		if (blue_pile.size() == 0)
			return true;
		else 
			return false;
	}
	
	// Returns the blue middle point converted to a string
	public String printBlueMPoint()
	{
		String str = blue_middle_point.toString();
		return str;
	}
		
	// Returns the red middle point converted to a string 
	public String printRedMPoint()
	{
		String str = red_middle_point.toString();
		return str;
	}
	
	// REturns blue home as a string
	public String printBlueHome()
	{
		String str = blue_pile.toString();
		return str;
	}
	
	// Returns red home as a string
	public String printRedHome()
	{
		String str = red_pile.toString();
		return str;
	}
	
	

}
