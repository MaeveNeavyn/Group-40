package Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiceTest {
	
	Dice dice;

	@Test
	void testGetRoll() {
		dice = new Dice();
		int roll1 = dice.getRoll();
		assertTrue(roll1>0 && roll1<7);
		
	}

}
