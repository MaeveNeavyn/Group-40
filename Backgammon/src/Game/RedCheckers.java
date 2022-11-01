package Game;
import java.util.*;

public class RedCheckers extends Stack<Checkers> {
		RedCheckers () {
			super();
			for (int i=0; i<15; i++) {
					super.add(new Checkers(CheckerColour.RED));
				}
			}
		}


