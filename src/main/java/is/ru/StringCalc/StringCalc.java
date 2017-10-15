package is.ru.StringCalc;

public class StringCalc {

	public int Add(String input) {

		String negativeNumbers = "";
		String[] numbers = input.split(",|\\n");
		int outcome = 0;

		if(input == "") {
			return 0;
		}

		for(String s : numbers) {

			if(s.contains("-")) {
				negativeNumbers = addNegative(negativeNumbers, s);
			}
			else {
				outcome = addNum(outcome, s);
			}
		}
		if(!negativeNumbers.equals("")) {
			throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
		}
		else {
			return outcome;
		}
	}

	private String addNegative(String negatives, String s) {
		if(negatives != "") {
			negatives += ",";
		}
		negatives +=s;
		return negatives;
	}

	private int addNum(int outcome, String s) {
		int theNum = Integer.parseInt(s);
		if(theNum <= 1000) {
			outcome += Integer.parseInt(s);
		}
		return outcome;
	}

}