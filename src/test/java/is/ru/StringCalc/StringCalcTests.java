package is.ru.StringCalc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalcTests {

	private StringCalc calculator;

	public StringCalcTests() {
		calculator = new StringCalc();
	}

	@Test //Testing the empty string: "", which should return 0.
	public void testEmptyString() {
		assertEquals(0, calculator.Add(""));
	}

	@Test //Testing two numbers separated by a comma, should return their sum.
	public void testSumOfCommaSeparated() {
		assertEquals(8, calculator.Add("3,5"));
	}

	@Test //Testing a single number, should return the number.
	public void testOneNumber() {
		assertEquals(1, calculator.Add("1"));
		assertEquals(2, calculator.Add("2"));
	}
}