package is.ru.StringCalc;

public class StringCalc {

	//string calculator.  Currently only functions correctly for empty string.  Returns 0.
	public int Add(String input) {
		if(input == "") {
			return 0;
		}
		else if(input.contains(",")) {
			String[] numbers = input.split(",");
			return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
		}
		else {
			return Integer.parseInt(input);
		}
	}
}