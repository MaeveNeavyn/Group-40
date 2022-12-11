package Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;

class ViewTest {

	View view ;
	Player player1 ;
	Player player2 ;
	private String name1 = "Maeve";
	private int player_number1 = 1;
	private int score1 = 0;
	private int pips1 = 167;
	private boolean doubleOwnership1 = true;
	private boolean hasQuit1 = false;
	private String name2 = "Kate";
	private int player_number2 = 2;
	private int score2 = 0;
	private int pips2 = 167;
	private boolean doubleOwnership2 = true;
	private boolean hasQuit2 = false;
	
	Command command;
	Board board;
	Match match;
	
	@BeforeEach
	void testView() {
		view = new View();
		player1 = new Player(name1,player_number1,score1,pips1,doubleOwnership1,hasQuit1);
		player2 = new Player(name2,player_number2,score2,pips2,doubleOwnership2,hasQuit2);
		command = new Command("roll");
		board = new Board();
		match = new Match(2,2);
	}

	@Test
	void testDisplayWelcome() {
		view.displayWelcome();
	}

	@Test
	void testGetName() {
		view.getName();
	}

	@Test
	void testGetDoubleAnswer() {
		System.out.println("Enter accept when asked for double");
		view.getDoubleAnswer(player1, player2);
		System.out.println("Enter an invalid command when asked for double");
		view.getDoubleAnswer(player1, player2);
		
	}

	@Test
	void testGetMatchLength() {
		System.out.println("Enter 2");
		view.getMatchLength();
		System.out.println("Enter invalid answer e.g. seven");
		view.getMatchLength();
		
	}

	@Test
	void testGetCommand() {
		System.out.println("Enter roll");
		view.getUserInput(player1);
		assertEquals(view.getCommand(), "ROLL");
	}

	@Test
	void testGetUserInput() {
		System.out.println("Enter roll");
		view.getUserInput(player1);
		System.out.println("Enter invalid command");
		view.getUserInput(player1);
		
	}

	@Test
	void testDisplayPlayer() {
		view.displayPlayer(player1);
	}

	@Test
	void testDisplayBoard() {
		view.displayBoard(board,player1, player2, 0, match);
		view.displayBoard(board,player1, player2, 1, match);
	}


	@Test
	void testDisplayScore() {
		view.displayScore(player1);
	}

	@Test
	void testDisplayQuit() {
		view.displayQuit(player1);;
	}

	@Test
	void testDisplayFirstRoll() {
		assertEquals(view.displayFirstRoll(player1, 2),2);	
	}

	@Test
	void testDisplayPipCounts() {
		view.displayPipCounts(player1, player2);
	}

	@Test
	void testDisplayHints() {
		view.displayHints(player1);
	}

	@Test
	void testPipCountO() {
		assertEquals(view.pipCountO(board),167);
	}

	@Test
	void testIsOStartEmpty() {
		assertFalse(view.isOStartEmpty(board));
	}

	@Test
	void testPipCountX() {
		assertEquals(view.pipCountX(board),167);
	}

	@Test
	void testIsXStartEmpty() {
		assertFalse(view.isXStartEmpty(board));
	}

}
