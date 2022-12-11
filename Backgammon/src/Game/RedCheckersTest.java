package Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RedCheckersTest {

	RedCheckers red_pile;
	@Test
	void testRedCheckers() {
		red_pile = new RedCheckers();
		assertEquals(red_pile.size() , 15);
		assertNotEquals(red_pile.size() , 16);
	}

}
