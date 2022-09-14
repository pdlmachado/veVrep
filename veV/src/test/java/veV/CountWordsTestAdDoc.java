package veV;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CountWordsTestAdDoc {
	
	@Test
	void testempty () {
		int words = new CountWords().count("");
		assertEquals(0,words);
				
	} 
	
	@ParameterizedTest
	@CsvSource({"dog and cat","0000" })
	void testzerooccurrences (String argument) {
		int words = new CountWords().count(argument);
		assertEquals(0,words);
	}	

	@ParameterizedTest
	@CsvSource({"1, dogs and cat", 
		        "2, driver and car at night"})
	void testoneormoreoccurrences(int expected, String argument) {
		int words = new CountWords().count(argument);
		assertEquals(expected,words);	
	}	
}
