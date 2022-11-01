package Game;
import java.util.*;

public class BlueCheckers extends Stack<Checkers>{

	BlueCheckers () {
		super();
		for (int i=0; i<15; i++) {
				super.add(new Checkers(CheckerColour.BLUE));
			}
		}
}
