package Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	Board board;
	Option move;
	View view;

	@BeforeEach
	void setUp()
	{
		board = new Board();
	}
	
	@Test
	void testNoRedCheckers() {
		assertEquals(board.noRedCheckers(2),0);	
	}

	@Test
	void testNoBlueCheckers() {
		assertEquals(board.noBlueCheckers(2),0);	
	}


	@Test
	void testMove() {
		move = new Option(1,0,4,1,false,0);
		board.move(move);
		move = new Option(1,5,4,1,true,1);
		
	}

	@Test
	void testIsOneRedChecker() {
		assertFalse(board.isOneRedChecker(0));
		move = new Option(1,0,4,1,false,0);
		board.move(move);
		assertTrue(board.isOneRedChecker(4));
		move = new Option(1,7,6,1,false,1);
		board.move(move);
		assertFalse(board.isOneRedChecker(6));
	}

	@Test
	void testIsOneBlueChecker() {
		assertFalse(board.isOneBlueChecker(0));
		move = new Option(1,23,22,1,false,1);
		board.move(move);
		assertTrue(board.isOneBlueChecker(22));
		move = new Option(1,0,4,1,false,0);
		board.move(move);
		assertFalse(board.isOneBlueChecker(4));
	}

	@Test
	void testIsMultipleRedChecker() {
		assertTrue(board.isMultipleRedChecker(0));
		move = new Option(1,0,4,1,false,0);
		board.move(move);
		assertTrue(board.isOneRedChecker(4));
		move = new Option(1,7,6,1,false,1);
		board.move(move);
		assertFalse(board.isOneRedChecker(6));
	
	}

	@Test
	void testIsMultipleBlueChecker() {
		fail("Not yet implemented");
	}

	@Test
	void testIsPointEmpty() {
		fail("Not yet implemented");
	}

	@Test
	void testIsBlueMiddlePointEmpty() {
		fail("Not yet implemented");
	}

	@Test
	void testIsRedMiddlePointEmpty() {
		fail("Not yet implemented");
	}

	@Test
	void testSizeMiddlePoint() {
		fail("Not yet implemented");
	}

	@Test
	void testIsRedHomeEmpty() {
		fail("Not yet implemented");
	}

	@Test
	void testIsBlueHomeEmpty() {
		fail("Not yet implemented");
	}

	@Test
	void testPrintBlueMPoint() {
		fail("Not yet implemented");
	}

	@Test
	void testPrintRedMPoint() {
		fail("Not yet implemented");
	}

	@Test
	void testPrintBlueHome() {
		fail("Not yet implemented");
	}

	@Test
	void testPrintRedHome() {
		fail("Not yet implemented");
	}

}
