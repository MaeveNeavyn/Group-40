package Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BlueCheckersTest {

	BlueCheckers blue_pile;
	
	@Test
	void testBlueCheckers() {
		blue_pile = new BlueCheckers();
		assertEquals(blue_pile.size() , 15);
		assertNotEquals(blue_pile.size() , 16);
	}

}
