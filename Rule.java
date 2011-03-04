public interface Rule {
	/*
	 * check() returns true if inputStr passes the rule, and false if it doesn't
	 */
	public boolean check(String inputStr);
}