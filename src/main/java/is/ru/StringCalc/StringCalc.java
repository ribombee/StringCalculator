package is.ru.StringCalc;

public class StringCalc {

	//string calculator.  Currently only functions correctly for empty string.  Returns 0.
	public int Add(String input) {
		if(input == "") {
			return 0;
		}
		else if(input.contains(",") || input.contains("\n")) {
			String[] numbers = input.split(",|\\n");

			int outcome = 0;
			for(String s : numbers) {
				outcome += Integer.parseInt(s);
			}

			return outcome;
		}
		else {
			return Integer.parseInt(input);
		}
	}
}