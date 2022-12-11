package Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckersTest {

	private CheckerColour colour;
	Checkers checker;
	
	@Test
	void testCheckers() {
		colour = CheckerColour.RED;
		checker = new Checkers(colour);
		assertEquals(colour, CheckerColour.RED);
		colour = CheckerColour.BLUE;
		checker = new Checkers(colour);
		assertEquals(colour, CheckerColour.BLUE);
		assertNotEquals(colour ,CheckerColour.RED);
	}

	@Test
	void testGetcolour() {
		colour = CheckerColour.RED;
		checker = new Checkers(colour);
		assertEquals(checker.getcolour() , CheckerColour.RED);
	}

	@Test
	void testToString() {
		checker = new Checkers(CheckerColour.RED);
		assertEquals(checker.toString() , "X");
		checker = new Checkers(CheckerColour.BLUE);
		assertEquals(checker.toString() ,"O");
		
	}

}
