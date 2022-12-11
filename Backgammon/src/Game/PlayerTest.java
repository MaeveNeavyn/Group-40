package Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	private String name = "Maeve";
	private int player_number = 1;
	private int score = 0;
	private int pips = 167;
	private boolean doubleOwnership = true;
	private boolean hasQuit = false;
	
	private Player player;
	
	
	@BeforeEach
	void testPlayer() {
		player = new Player(name, player_number,pips,score,doubleOwnership,hasQuit);		
	}

	@Test
	void testHasQuit() {
		assertEquals(player.hasQuit(),false);
		assertNotEquals(player.hasQuit(),true);
	}

	@Test
	void testUserQuitting() {
		player.userQuitting();
		assertEquals(player.hasQuit(),true);
		assertNotEquals(player.hasQuit(),false);
	}

	@Test
	void testGetDoubleOwnership() {
		assertEquals(player.getDoubleOwnership(),true);
		assertNotEquals(player.getDoubleOwnership(),false);
	}

	@Test
	void testSetDoubleOwnership() {
		player.setDoubleOwnership();
		assertEquals(player.getDoubleOwnership(),true);
	}

	@Test
	void testRemoveDoubleOwnership() {
		player.removeDoubleOwnership();
		assertEquals(player.getDoubleOwnership(),false);
	}

	@Test
	void testSetPips() {
		player.setPips(120);
		assertEquals(player.getPips(),120);
	}

	@Test
	void testGetName() {
		assertEquals(player.getName(),name);
	}

	@Test
	void testGetPlayerNumber() {
		assertEquals(player.getPlayerNumber(),player_number);
	}

	@Test
	void testGetPips() {
		assertEquals(player.getPips(),pips);
	}

	@Test
	void testGetScore() {
		assertEquals(player.getScore(),score);
	}

	@Test
	void testUpdateScore() {
		player.updateScore(3);
		assertEquals(player.getScore(),3);		
	}


	@Test
	void testToString() {
		assertEquals(player.toString(),name);
	}

	@Test
	void testIsGameOver() {
		assertFalse(player.isGameOver());
		player.setPips(0);
		assertTrue(player.isGameOver());
	}

}
