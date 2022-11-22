package Game;
import java.util.*;

public class Board {
	
	public final static int NUM_POINTS = 24;
	private Stack<Checkers> point;
	private List<Stack<Checkers>> points; 
	private List<Stack<Checkers>> middle_lane;
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
	
	public void move(int roll1, int roll2, int moveFrom1, int moveFrom2) {
		
		int moveTo1 = moveFrom1 + roll1;
		int moveTo2 = moveFrom2 + roll2;
		
		System.out.println("player moves from point " + (moveFrom1+1) + " to " + (moveTo1+1));
		System.out.println("player moves from point " + (moveFrom2+1) + " to " + (moveTo2+1));
		
		Checkers checker1 =getPoint(moveFrom1).pop();
		getPoint(moveTo1).push(checker1);
		
		Checkers checker2 =getPoint(moveFrom2).pop();
		getPoint(moveTo2).push(checker2);
		
		
	}
	
	
	//Get Pip count value for all 0's
	public int pipValueO() {
		int pipCount = 0;
		int i;
		points = new ArrayList<>(NUM_POINTS);
		
		for (i=0; i<24; i++) {	//point value in terms of array number
			//Initialize values back to 0 for each point check
			int numCheckers = 0;
			int pointValue = 0;
			int pips = 0;
			
			if (points.get(i).contains("O")) {
				numCheckers = points.size();
				pointValue = i+1;
				pips = pointValue*numCheckers;
				pipCount += pips;
			}
		}
		return pipCount;
	}
	
	

	
	
	

}
