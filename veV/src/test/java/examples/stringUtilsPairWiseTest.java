package examples;

import java.util.stream.Stream;

import static examples.stringUtils.substringBetween;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class stringUtilsPairWiseTest {

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
	
	static Stream <Arguments> pairwiseData () {
		return Stream.of(
				//strSize,strOccurrence,strContains,openSize,closeSize
				//2+      several 2openclose+     2+      1
				Arguments.of(new String[] {"bb","ee"},"aaaabbcccccccaaaaeeccccccccaa","aaaa","c"),
				//2+      none    1close  2+      2+
				Arguments.of(null,"aaaabbcaaaaeeccccccccaa","aaaaa","ccc"),
				//2+      none    1open   1       2+
				Arguments.of(null,"abbcuuueeccvv","a","ccc"),
				//1       none    1open   1       1
				Arguments.of(null,"abbcuuueeccccccccvv","a","x"),
				//2+      nonempty        1openclose      2+      2+
				Arguments.of(new String[] {"bbcuuueecc"},"vaabbcuuueeccxxccccccvv","aa","xx"),
				//2+      several 2openclose+     1       2+     **
				Arguments.of(new String[] {"bbcuuueecc",""},"vabbcuuueeccxxxcccaxxxvv","a","xxx"),
				//2+      empty   1openclose      1       1
				Arguments.of(new String[] {""},"ax","a","x"),
				//1       none    1close  1       1
				Arguments.of(null,"x","j","x"),
				//1       none    none    1       1 ***
				Arguments.of(null,"y","j","x"),
				//2+      nonempty        1openclose      1       1
				Arguments.of(new String[] {"ad"},"xdfadfx","f","f"),
				//2+      none    1open   2+      1
				Arguments.of(null,"xdfffadfx","fab","f"),
				//2+      empty   1openclose      2+      2+
				Arguments.of(new String[] {""},"xdfadfx","fad","fx"),
				//2+      none    none    1       1
				Arguments.of(null,"xdfadfx","h","g"),
				//2+      none    none    2+      2+
				Arguments.of(null,"xdfadfx","ht","gy")
				);
	}
	
	@ParameterizedTest
	@MethodSource("pairwiseData")
	void pairwiseTest (String [] expected, String str, String open, String close) {
		assertArrayEquals(expected,substringBetween(str,open,close));
	}				
}
