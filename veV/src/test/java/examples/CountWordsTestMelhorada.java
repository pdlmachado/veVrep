package examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import examples.CountWords;

class CountWordsTestMelhorada {
	
	@Test
	void testnull () {
		int words = new CountWords().count(null);
		assertEquals(-1,words);		
	}
	
	@Test
	void testempty () {
		int words = new CountWords().count("");
		assertEquals(0,words);			
	}
	
	// Zero ocorrências
	@ParameterizedTest
	@CsvSource({"dog and cat",
		        "0000"
	})
	void testzerooccurrences (String argument) {
		int words = new CountWords().count(argument);
		assertEquals(0,words);
	}
	
	// Uma ocorrência, palavras de tamanho 1 ou maior
	@ParameterizedTest
	@CsvSource({"dogs and cat",
		        "my car drive"
	})
	void testoneoccurrence(String argument) {
		int words = new CountWords().count(argument);
		assertEquals(1,words);	
	}
	
	// Mais de uma ocorrência, palavras de qualquer tamanho
	@ParameterizedTest
	@CsvSource({"2, dogs and cats run",
		        "2, car and driver run",
                "3, car and dogs and cats run"
	})
	void testmoreoccurrences(int expected, String argument) {
		int words = new CountWords().count(argument);
		assertEquals(expected,words);	
	}

}
