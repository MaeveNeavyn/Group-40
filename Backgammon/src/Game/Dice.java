package Game;

public class Dice {
	private final static double SIDES_ON_DICE = 6.0;    // changing to 1.0 is good for testing

	public final static int getRoll () {
		double roll = Math.random()*SIDES_ON_DICE+1.0;
		return (int) roll;
	}

}
