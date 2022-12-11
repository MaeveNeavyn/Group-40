package Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;

class MatchTest {

	Match match;
	
	@BeforeEach
	void testMatch() {
		match = new Match(2,1);		
	}

	@Test
	void testGetMatchLength() {
		assertEquals(match.getMatchLength(),2);
		assertNotEquals(match.getMatchLength(),1);
	}

	@Test
	void testGetGameStake() {
		assertEquals(match.getGameStake(),1);
		assertNotEquals(match.getGameStake(),2);
	}

	@Test
	void testSetGameStake() {
		match.setGameStake(4);
		assertEquals(match.getGameStake(),4);
	}

}
