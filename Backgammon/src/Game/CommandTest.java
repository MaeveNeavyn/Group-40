package Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommandTest {

	private String inputTest;
	private Command commandTest;

	@Test
	void testIsQuit() {
		inputTest = "quit";
		commandTest = new Command(inputTest);
		assertTrue(commandTest.isQuit());
		inputTest = "pip";
		commandTest = new Command(inputTest);
		assertFalse(commandTest.isQuit());
	}
	
	@Test
	void testIsDouble() {
		inputTest = "double";
		commandTest = new Command(inputTest);
		assertTrue(commandTest.isDouble());
		inputTest = "quit";
		commandTest = new Command(inputTest);
		assertFalse(commandTest.isDouble());
		
	}
	

	@Test
	void testIsRoll() {
		inputTest = "roll";
		commandTest = new Command(inputTest);
		assertTrue(commandTest.isRoll());
		inputTest = "quit";
		commandTest = new Command(inputTest);
		assertFalse(commandTest.isRoll());
		
	}

	@Test
	void testIsPip() {
		inputTest = "pip";
		commandTest = new Command(inputTest);
		assertTrue(commandTest.isPip());
		inputTest = "quit";
		commandTest = new Command(inputTest);
		assertFalse(commandTest.isPip());
	}

	@Test
	void testIsHint() {
		inputTest = "hint";
		commandTest = new Command(inputTest);
		assertTrue(commandTest.isHint());
		inputTest = "quit";
		commandTest = new Command(inputTest);
		assertFalse(commandTest.isHint());
	}

	@Test
	void testIsDice() {
		inputTest = "dice 55";
		commandTest = new Command(inputTest);
		assertTrue(commandTest.isDice());
		inputTest = "quit";
		commandTest = new Command(inputTest);
		assertFalse(commandTest.isDice());
	}
 

	@Test
	void testIsTestFile() {
		inputTest = "test roll";
		commandTest = new Command(inputTest);
		assertTrue(commandTest.isTestFile());
		inputTest = "quit";
		commandTest = new Command(inputTest);
		assertFalse(commandTest.isTestFile());
	}

	@Test 
	void testIsValid() {
		inputTest = "roll";
		assertTrue(commandTest.isValid(inputTest));
		inputTest = "pip";
		assertTrue(commandTest.isValid(inputTest));
		inputTest = "hint";
		assertTrue(commandTest.isValid(inputTest));
		inputTest = "quit";
		assertTrue(commandTest.isValid(inputTest));
		inputTest = "double";
		assertTrue(commandTest.isValid(inputTest));
		inputTest = "dice 56";
		assertTrue(commandTest.isValid(inputTest));	
	}

	@Test
	void testGetDice1() {
		inputTest = "dice 34";
		commandTest = new Command(inputTest);
		assertEquals(commandTest.getDice1() , 3);
		commandTest = new Command(inputTest);
		assertNotEquals(commandTest.getDice1() , 4);
	}

	@Test
	void testGetDice2() {
		inputTest = "dice 34";
		commandTest = new Command(inputTest);
		assertEquals(commandTest.getDice2() , 4);
		commandTest = new Command(inputTest);
		assertNotEquals(commandTest.getDice2() , 3);
	}

	@Test
	void testGetFileName() {
		inputTest = "test testroll.txt";
		commandTest = new Command(inputTest);
		assertEquals(commandTest.getFileName() , "testroll.txt");
		assertNotEquals(commandTest.getFileName() , "quit");
	}

}
