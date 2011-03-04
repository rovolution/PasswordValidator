public class SpecialCharRule implements Rule {
	/*
	 * check() returns true if inputStr contains a special character
	 * (special characters are any non-numerical or non-alpha characters)
	 * and returns false if otherwise.
	 */
	public boolean check(String inputStr) {
		return inputStr.matches(".*[\\W_].*");
	}
}
