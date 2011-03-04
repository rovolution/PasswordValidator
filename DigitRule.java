public class DigitRule implements Rule{	
	/*
	 * check() returns true if inputStr contains a digit character (0-9),
	 * and returns false if otherwise.
	 */
	public boolean check(String inputStr) {
		return inputStr.matches(".*[\\d].*");
	}
}
