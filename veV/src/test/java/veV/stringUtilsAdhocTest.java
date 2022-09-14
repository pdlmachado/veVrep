package veV;

import static veV.stringUtils.substringBetween;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class stringUtilsAdhocTest {

	@Test
	void basic() {
		assertArrayEquals(new String [] {"bc"}, substringBetween("abcd", "a", "d"));
	}
	
	@Test
	void many() {
		assertArrayEquals(new String [] {"bc", "bc"}, substringBetween("abcdabcdab", "a", "d"));
	}
	
	@Test
	void opencloselonger() {
		assertArrayEquals(new String [] {"bc", "bf"}, substringBetween("aabcdddddddaabfdddddddaab", "aa", "ddddddd"));
	}

}
