package veV;

import static veV.LeftPad.leftPad;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LeftPadTest2 {

	@ParameterizedTest
	@MethodSource("generator")
	void test (String originalStr, int size, String padString, String expectedStr) {
		assertEquals(expectedStr, leftPad(originalStr, size, padString));
	}
	static Stream <Arguments> generator () {
		return Stream.of(
				Arguments.of(null,10,"-",null), // str is null
				Arguments.of("", 5, "-", "-----"), // str is empty
				Arguments.of("abc", -1, "-", "abc"), // negative size
				Arguments.of("abc", 5, null, "  abc"), // padStr is null
				Arguments.of("abc", 5, "", "  abc"), // padStr is empty
				Arguments.of("abc", 5, "-", "--abc"), // padStr has a single character
				Arguments.of("abc", 3, "-", "abc"), // size is equal to the length of str
				Arguments.of("abc", 0, "-", "abc"), // size is equal to 0
				Arguments.of("abc", 2, "-", "abc"), // size is smaller than the length of str
				Arguments.of("abc", 5, "--", "--abc"), // the length of padStr is equal to the remaining spaces in str
				Arguments.of("abc", 5, "---", "--abc") // the length of padStr is greater than the remaining spaces in str
				);
	}

}
