package is.ru.StringCalc;

public class StringCalc {

	public int Add(String input) {

		//find special delimeter if applicable, and if it is present,
		//remove its declaration from the input.
		String delimeter = findDelimeter(input);
		if(!delimeter.equals(",")) {
			input = input.substring(input.indexOf("\n")+1);
		}

		String negativeNumbers = "";
		String[] numbers = input.split(",|\\n|" + delimeter);
		int outcome = 0;

		//if input is the empty string, return 0.
		if(input == "") {
			return 0;
		}

		//add the numbers and see if any are negative.
		for(String s : numbers) {

			if(s.contains("-")) {
				negativeNumbers = addNegative(negativeNumbers, s);
			}
			else {
				outcome = addNum(outcome, s);
			}
		}

		//return the number, or if it is negative, throw an exception.
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

	private String findDelimeter(String input) {
		int indexStart = input.indexOf("\\");
		int indexEnd = input.indexOf("\n");

		String delimeter;

		if(indexStart == 0) {
			delimeter = input.substring(1, indexEnd);
		}
		else {
			delimeter = ","; //if we don't find anything
		}
		return delimeter;
	}

}