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
}