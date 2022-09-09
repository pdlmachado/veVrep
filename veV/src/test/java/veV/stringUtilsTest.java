package veV;

import static veV.stringUtils.substringBetween;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class stringUtilsTest {

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
		assertArrayEquals(null,substringBetween("abc","",null),"close é vazia");
	}
	
	@ParameterizedTest
	@CsvSource({"a,b,c","a,a,b","b,a,b","a,a,a"})
	void strOfLength1 (String s, String o, String c) {
		assertEquals(null,substringBetween(s,o,c));
	}
	
	@Test
	void openandCloseOfLength1 () {
		assertArrayEquals(null,substringBetween("abc","x","y"));
		assertArrayEquals(null,substringBetween("abc","a","y"));
		assertArrayEquals(null,substringBetween("abc","x","c"));
		assertArrayEquals(new String[] {"b"},substringBetween("abc","a","c"));
		assertArrayEquals(new String[] {"b","b"},substringBetween("abcabc","a","c"));
	}
	
	@Test
	void openandCloseofLengthGreaterThan1 () {
		assertArrayEquals(null,substringBetween("aabcc","xx","yy"));
		assertArrayEquals(null,substringBetween("aabcc","aa","yy"));
		assertArrayEquals(null,substringBetween("aabcc","x","cc"));
		assertArrayEquals(new String[] {"bb"},substringBetween("aabbcc","aa","cc"));
		assertArrayEquals(new String[] {"bb","ee"},substringBetween("aabbccaaeecc","aa","cc"));
	}
	
	@Test
	void noSubstringBetween () {
		assertArrayEquals(new String[] {""},substringBetween("aabb","aa","bb"));
	}
	
}
