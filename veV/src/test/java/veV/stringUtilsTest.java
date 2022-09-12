package veV;

import static veV.stringUtils.substringBetween;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


class stringUtilsTest {

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
	
	// Tamanho de str = 1
	@ParameterizedTest
	@CsvSource({"a,b,c","a,a,b","b,a,b","a,a,a"})
	void strOfLength1 (String s, String o, String c) {
		assertEquals(null,substringBetween(s,o,c));
	}
	
	// Tamanho de str > 1
	static Stream <Arguments> openandCloseOfLength1Data () {
		return Stream.of(
				Arguments.of(null,"abc","x","y"),
				Arguments.of(null,"abc","a","y"),
				Arguments.of(null,"abc","x","c"),
				Arguments.of(new String[] {"b"},"abc","a","c"),
				Arguments.of(new String[] {"b","b"},"abcabc","a","c")
				);
	}
	@ParameterizedTest
	@MethodSource("openandCloseOfLength1Data")
	void openandCloseOfLength1 (String [] expected, String str, String open, String close) {
		assertArrayEquals(expected,substringBetween(str,open,close));
	}
	
	// Tamanho de str > 1, open > 1 e close > 1
	static Stream <Arguments> dataopenandCloseOfLengthGreaterThan1 () {
		return Stream.of(
				Arguments.of(null,"aabcc","xx","yy"),
				Arguments.of(null,"aabcc","aa","yy"),
				Arguments.of(null,"aabcc","x","cc"),
				Arguments.of(new String[] {"bb"},"aabbcc","aa","cc"),
				Arguments.of(new String[] {"bb","ee"},"aabbccaaeecc","aa","cc")	
				);
	}
				
	@ParameterizedTest
	@MethodSource("dataopenandCloseOfLengthGreaterThan1")
	void openandCloseofLengthGreaterThan1 (String [] expected, String str, String open, String close) {
		assertArrayEquals(expected,substringBetween(str,open,close));
	}
	
	// Teste Valor Limite
	static Stream <Arguments> datanoStringBetween () {
		return Stream.of(
				Arguments.of(new String[] {""},"aabb","aa","bb")
				);
	}
	
	@ParameterizedTest
	@MethodSource("datanoStringBetween")
	void noSubstringBetween (String [] expected, String str, String open, String close) {
		assertArrayEquals(expected,substringBetween(str,open,close));
	}
	
}
