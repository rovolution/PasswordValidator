import java.util.*;

/*
 * 
 * Validator is used to check whether a given password is valid or not
 * 
 * A passwords validity is determined by whether it passes the user specified 
 * minimum # of rules
 */
public class Validator {
	/*
	 * Private Variables 
	 */
	private int numRules; //The minimum number of rules that must pass
	private int ruleCount; //The number of rules that have passed so far
	private List<Rule> rules; //A list of the various rules to check for
	
	/* 
	 * CONSTRUCTOR: Takes in # of rules that must be passed 
	 */
	public Validator() {
		//Initialize ruleCount and rules
		ruleCount = 0;
		rules = new LinkedList<Rule>();
		
		//Add the rules to the rules array
		rules.add(new UpperCaseRule());
		rules.add(new LowerCaseRule());
		rules.add(new DigitRule());
		rules.add(new SpecialCharRule());
		
		//Initialize numRules to be equal to the number of rules in the rules array
		numRules = rules.size();
	}

	/*
	 * getNumRules() returns the number of rules to pass (numRules
	 */
	public int getNumRules() {
		return numRules;
	}
		
	/*
	 * setNumRules() allows a user of Validator to set the number of rules to pass
	 * at any given time.
	 * 
	 * Returns true if the user specified a valid number of rules,and returns false if otherwise
	 */
	public boolean setNumRules(int newNumRules) {
		//At least one rule must be passed but no more than the number of rules in the rules array
		if (newNumRules > 0 && newNumRules <= rules.size()) {
			numRules = newNumRules;
			return true;
		} else {
			return false;
		}
	}
	
	/* 
	 * checkPassword() function iterates through list of rules checking to see if
	 * password passes the minimum number of rules (numRules)
	 * 
	 * If it does, return true, otherwise false.
	 */
	public boolean checkPassword(String password) {
		//Loop through the list of rules
		for (Rule rule : rules) {
			//If the number of specified rules has not been passed,
			//call checkRule()
			if (!rulesPassed()) {
				checkRule(rule, password);
			} 
			//Otherwise the number of required rules have passed (without having to
			//have checked all of the rules), so return true
			else {
				//Set ruleCount back to 0 so this Validator object can be reused
				return true;
			}
		}
		
		//Check one last time if the required number of rules have passed.
		//NOTE: Reason for this final check is because the last rule in the list could 
		//have been one that needed to pass in order for the password to be valid.
		//Will return true if all rules have passed and false if otherwise.
		return rulesPassed();
	}
	
	/*
	 * rulesPassed() returns true if numRules of rules have been passed and 
	 * returns false if otherwise.
	 */
	private boolean rulesPassed() {
		return numRules == ruleCount;
	}
	
	/*
	 * checkRule() checks to see if String password passes the Rule rule
	 * 
	 * If so, it increments ruleCount by 1. If not, it does nothing
	 */
	private void checkRule(Rule rule, String password) {
		if (rule.check(password)) {
			ruleCount++;
		}
	}
	
}
