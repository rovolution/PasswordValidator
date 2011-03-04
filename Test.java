import java.io.*;

/*
 * Test program
 */
public class Test{
	public static void main(String[] args) throws IOException {	
		//Declare and init string variables that store user input
		String passwordInput = "";
		int rulesToPass = 0;
		BufferedReader keyboard;

		//Read in user input from keyboard
		keyboard = new BufferedReader(new InputStreamReader(System.in)); 
		
		//Read in password from command line
		System.out.println("Enter in Password: ");
		passwordInput = keyboard.readLine();
		
		//Read in number of rules to pass from command line
		System.out.println("Enter in minimum number of rules to pass: ");
		rulesToPass = Integer.parseInt(keyboard.readLine());
					
		//Use a Validator object to check whether the given password is valid or not
		Validator checker = new Validator();
		
		//Set the number of rules to pass
		//If it is a valid number proceed, if not, the Test program terminates
		if (!checker.setNumRules(rulesToPass)) {
			System.out.println("ERROR: Invalid number of rules to pass. Please input valid number.");
			return;
		} 
		else{
			//Let the user know the number of rules to pass
			System.out.println("Number of rules to pass: " + checker.getNumRules());	
			
			//If the password is valid, then let user know.
			//Likewise, let the user know if it fails
			if (checker.checkPassword(passwordInput)) {
				System.out.println("PASS: Password is strong enough.");	
			} else {
				System.out.println("FAIL: Password is too weak.");	
			}
		}
	}
}
