package is.ru.StringCalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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

	@Test //Testing three numbers
	public void testThreeNumbers() {
		assertEquals(3, calculator.Add("1,1,1"));
		assertEquals(6, calculator.Add("1,2,3"));
	}

	@Test //Testing many numbers
	public void testMany() {
		assertEquals(55, calculator.Add("1,2,3,4,5,6,7,8,9,10"));
	}

	@Test //Testing the \n delimeter
	public void testnewline() {
		assertEquals(3, calculator.Add("1\n2"));
	}

	@Test //Tesing \n with ,
	public void testnewlinecomma() {
		assertEquals(6, calculator.Add("1\n2,3"));
	}

	@Test //testing single negative number
	public void testNegative1() {
	    try {
	        calculator.Add("-1");
	        fail("No exception thrown, IllegalArgumentException expected");
	    } 
	    catch (Exception e) {
	        assertEquals( "Negatives not allowed: -1", e.getMessage());
	    }    
	}

	@Test //testing more than one negative number
	public void testNegativemany() {
	    try {
	        calculator.Add("-1,-3,-5,2,-4");
	        fail("No exception thrown, IllegalArgumentException expected");
	    } 
	    catch (Exception e) {
	        assertEquals( "Negatives not allowed: -1,-3,-5,-4", e.getMessage());
	    }   
	}

	@Test //Testing that numbers bigger than zero get ignored
	public void testBigNumber() {

		assertEquals(2, calculator.Add("1,1,1002"));
	}

	@Test //Testing just one big number
	public void testBigNumberAlone() {
		assertEquals(0, calculator.Add("10000"));
	}

	@Test //testing new delimeter
	public void testDelimSemicolon() {
		assertEquals(3, calculator.Add("\\;\n1;2"));
	}

	@Test //testing new daelimeter with commas and newline
	public void testDelimAFew() {
		assertEquals(10, calculator.Add("\\;\n1;2,3\n4"));
	}
}