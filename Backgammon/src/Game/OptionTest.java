package Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OptionTest {
	
	Option option = new Option();
	
	@Test
	void testSetGetOptionNumber() {
		option.setOptionNumber(2);
		assertEquals(option.getOptionNumber(),2);
		assertNotEquals(option.getOptionNumber(),4);
	}

	@Test
	void testSetMoveFrom() {
		option.setMoveFrom(2);
		assertEquals(option.getMoveFrom(),2);
		assertNotEquals(option.getMoveFrom(),4);
	}

	@Test
	void testSetMoveTo() {
		option.setMoveTo(2);
		assertEquals(option.getMoveTo(),2);
		assertNotEquals(option.getMoveTo(),4);
	}

	@Test
	void testSetNoDice() {
		option.setNoDice(2);
		assertEquals(option.getNoDice(),2);
		assertNotEquals(option.getNoDice(),4);
	}

	@Test
	void testSetKnockOpponent() {
		option.setKnockOpponent(true);
		assertEquals(option.getKnockOpponent(), true);
		assertNotEquals(option.getKnockOpponent(), false);
	}


	@Test
	void testToString() {
		option.setOptionNumber(2);
		option.setMoveFrom(2);
		option.setMoveTo(3);
		option.setNoDice(1);
		option.setKnockOpponent(true);
		String str = "Option: 2 is move from point 3 to point 4 using dice number: 1";
		assertEquals(str,option.toString());
		
	}

	@Test
	void testSetPlayerNumber() {
		option.setPlayerNumber(2);
		assertEquals(option.getPlayerNumber(),2);
		assertNotEquals(option.getPlayerNumber(),3);
	}


}
