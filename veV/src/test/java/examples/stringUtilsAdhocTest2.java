package examples;

import static examples.stringUtils.substringBetween;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class stringUtilsAdhocTest2 {

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
		assertArrayEquals(new String [] {"bc", "bf"}, substringBetween("aabcddaabfddaab", "aa", "dd"));
	}
	
	@Test
	void emptystring() {
		assertArrayEquals(new String [] {"", ""}, substringBetween("aabcddaabfddaab", "dd", "aa"));
	}
	
	// Casos Excepcionais
	@Test
	void strIsNullorEmpty () {
		assertEquals(null,substringBetween(null,"a","b"),"str é null");
		assertArrayEquals(new String[0],substringBetween("","a","b"),"str é vazia");
	}
	
	@Test
	void openIsNullorEmpty () {
		assertEquals(null,substringBetween("abc",null,"b"),"open é null");
		assertArrayEquals(null,substringBetween("abc","","b"),"open é vazia");
	}
	
	@Test
	void closeIsNullorEmpty () {
		assertEquals(null,substringBetween("abc","a",null),"close é null");
		assertArrayEquals(null,substringBetween("abc","a",""),"close é vazia");
	}

}
