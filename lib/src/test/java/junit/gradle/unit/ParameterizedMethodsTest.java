package junit.gradle.unit;
import org.junit.jupiter.params.ParameterizedTest;  // Correct annotation
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ParameterizedMethodsTest {

	@ParameterizedTest  // Correct annotation here
	@CsvSource({"1,2,3", "2,3,5"})
	void testAddition(int a, int b, int expected) {
	    assertEquals(expected, a + b);
	}

	@ParameterizedTest  // Correct annotation here
	@CsvSource({"5,2,3", "10,4,6"})
	void testSubtraction(int a, int b, int expected) {
	    assertEquals(expected, a - b);
	}
}
