package technicalTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValueTest {

	@Test
	void testValidateString() {
		String test = "this is an invalid string!";
		Value v1 = new Value(test);
		boolean actual = v1.validateString();
		boolean expected = false;
		
		assertTrue(actual==expected);
	}

	@Test
	void testCountWords() {
		String test = "thisSentenceIsInCamelCase";
		Value v1 = new Value(test);
		int actual = v1.countWords();
		int expected = 6;
		
		assertTrue (actual==expected);
	}

	@Test
	void testEncode() {
		String test = "abc xyz";
		Value v1 = new Value(test);
		String actual = v1.encode();
		String expected = "def abc";
		
		assertEquals(actual,expected);
	}

	@Test
	void testIsPangram() {
		String test = "The quick brown fox jumps over the lazy dog";
		Value v1 = new Value(test);
		boolean actual = v1.isPangram();
		boolean expected = true;
		assertTrue(actual==expected);
	}

}
