public class LowerCaseRule implements Rule {
	/*
	 * check() returns true if inputStr contains a lower case letter (a-z),
	 * and returns false if otherwise.
	 */
	public boolean check(String inputStr) {
		return inputStr.matches(".*[a-z].*");
	}
}
