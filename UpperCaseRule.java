public class UpperCaseRule implements Rule {
	/*
	 * check() returns true if inputStr contains an upper case letter (A-Z),
	 * and returns false if otherwise.
	 */
	public boolean check(String inputStr) {
		return inputStr.matches(".*[A-Z].*");
	}
}
