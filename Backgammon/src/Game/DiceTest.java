package Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiceTest {
	
	Dice dice;

	@Test
	void testGetRoll() {
		dice = new Dice();
		int roll1 = dice.getRoll();
		boolean test = (roll1>=1 && roll1<=6);
		assertTrue(test);
		
	}

}
