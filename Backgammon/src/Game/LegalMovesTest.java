package Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;

import org.junit.jupiter.api.Test;


class LegalMovesTest {

	LegalMoves legal_moves;
	Board board;
	Player player1, player2;
	List<Integer> rolls = new ArrayList<>();
	Option move;
	
	@BeforeEach
	void setUp()
	{
		board = new Board();
		player1 = new Player("Maeve",1,167,0,false,false);
		player2 = new Player("Kate",2,167,0,false,false);
		
	}
	
	@Test
	void testLegalMoves() {
		rolls.add(1);
		legal_moves = new LegalMoves(board,player1,rolls); //Red checker  move with middle point empty
		legal_moves = new LegalMoves(board,player2,rolls); //Blue checker move with middle point empty
		rolls.clear();
		
		//Blue checker legal move knock red checker and blue middle point empty
		move = new Option(1,0,4,1,false,1);
		board.move(move);
		assertTrue(board.isOneRedChecker(4));	
		rolls.clear();
		rolls.add(1);
		legal_moves = new LegalMoves(board,player2,rolls); 
		
		// Red checker knock off Blue with middle point empty
		move = new Option(1,5,3,1,false,2);
		board.move(move);
		assertTrue(board.isOneBlueChecker(3));
		rolls.clear();
		rolls.add(3);
		legal_moves = new LegalMoves(board,player1,rolls);
		
		// Blue checker knocking red checker into middle point
		rolls.clear();
		move = new Option(1,5,4,1,true,2);
		board.move(move);
		// Red has options to move from middle point either knocking blue off or not
		rolls.add(5);
		rolls.add(10);
		legal_moves = new LegalMoves(board,player1,rolls);
		
		// Red checker knocking blue into middle point
		move = new Option(1,0,3,1,true,1);
		board.move(move);
		move = new Option(1,18,19,1,false,1);
		board.move(move);
		legal_moves = new LegalMoves(board,player2,rolls);
		
		// Moving all red checkers into end zone
		board = new Board();
		for (int i=0;i<2;i++)
		{
			move = new Option(1,0,22,1,false,1);
			board.move(move);
		}
		for (int i=0;i<5;i++)
		{
			move = new Option(1,11,22,1,false,1);
			board.move(move);
		}
		legal_moves = new LegalMoves(board,player1,rolls);
		for (int i=0;i<3;i++)
		{
			move = new Option(1,16,22,1,false,1);
			board.move(move);
		}
		legal_moves = new LegalMoves(board,player1,rolls);
		
		// Moving all blue checkers into end zone
		board = new Board();
		for (int i=0;i<2;i++)
		{
			move = new Option(1,23,2,1,false,2);
			board.move(move);
		}
		for (int i=0;i<5;i++)
		{
			move = new Option(1,12,2,1,false,2);
			board.move(move);
		}
		legal_moves = new LegalMoves(board,player2,rolls);
		for (int i=0;i<3;i++)
		{
			move = new Option(1,5,2,1,false,2);
			board.move(move);
		}
		legal_moves = new LegalMoves(board,player2,rolls);

		
		
	}

	@Test
	void testPickOption() {
		rolls.add(1);
		legal_moves = new LegalMoves(board,player1,rolls);
		legal_moves.pickOption(1);
		
	}

	@Test
	void testClearOptions() {
		rolls.add(1);
		legal_moves = new LegalMoves(board,player1,rolls);
		legal_moves.clearOptions();
		assertEquals(legal_moves.size(),0);
	}

	@Test
	void testSize() {
		rolls.clear();
		rolls.add(1);
		rolls.add(1);
		legal_moves = new LegalMoves(board,player1,rolls);
		assertEquals(legal_moves.size(),6);
	}

}
