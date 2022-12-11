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
		assertFalse(board.isMultipleRedChecker(4));
		assertFalse(board.isMultipleRedChecker(5));
	
	}

	@Test
	void testIsMultipleBlueChecker() {
		assertTrue(board.isMultipleBlueChecker(23));
		move = new Option(1,23,21,1,false,1);
		board.move(move);
		assertFalse(board.isMultipleBlueChecker(21));
		assertFalse(board.isMultipleBlueChecker(0));
	}


	@Test
	void testIsBlueMiddlePointEmpty() {
		assertTrue(board.isBlueMiddlePointEmpty());
		move = new Option(1,5,2,1,false,2);
		board.move(move);
		move = new Option(1,0,2,1,true,1);
		board.move(move);
		assertFalse(board.isBlueMiddlePointEmpty());
		move = new Option(1,-1,2,1,true,2);
		board.move(move);
		assertTrue(board.isBlueMiddlePointEmpty());
		move = new Option(1,-1,3,1,false,1);
		board.move(move);
	}

	@Test
	void testIsRedMiddlePointEmpty() {
		assertTrue(board.isRedMiddlePointEmpty());
		move = new Option(1,0,2,1,false,1);
		board.move(move);
		move = new Option(1,5,2,1,true,2);
		board.move(move);
		assertFalse(board.isRedMiddlePointEmpty());
		move = new Option(1,-1,2,1,true,1);
		board.move(move);
		assertTrue(board.isRedMiddlePointEmpty());
		move = new Option(1,-1,3,1,false,2);
		board.move(move);
	}

	/*@Test
	void testSizeMiddlePoint() {
		fail("Not yet implemented");
	}*/

	@Test
	void testIsRedHomeEmpty() {
		assertTrue(board.isRedHomeEmpty());
		move = new Option(1,0,25,1,false,1);
		board.move(move);
		assertFalse(board.isRedHomeEmpty());
	}

	@Test
	void testIsBlueHomeEmpty() {
		assertTrue(board.isBlueHomeEmpty());
		move = new Option(1,23,25,1,false,2);
		board.move(move);
		assertFalse(board.isBlueHomeEmpty());
	}



}
