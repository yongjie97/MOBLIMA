package Boundary;

import java.util.Scanner;

import Constant.DataFileConstant;
import Repository.UserRepository;
import Controller.UserController;

public class LoginBoundary {
	private static int choice;
	private static int result;
	private static String username;
	private static String password;
	private static UserRepository userRepository = new UserRepository(DataFileConstant.USER_FILE);
	private static int size = userRepository.size();

	public static void Login() {
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("===============================");
		    System.out.println("Welcome to MOBLIMA - Login Module");
		    System.out.println("Please enter your username");
			username = scan.next();
			System.out.println("Please enter your password");
			password = scan.next();
		    System.out.println("===============================");
	    	result =UserController.LoginFunction(username, password);
	    	if (result > 0) {
	    		break;
	    	}
	    	System.out.println("Wrong information");
	    	System.out.println("1. Try again");
	    	System.out.println("2. Exit");
	    	choice = scan.nextInt();
	    	if (choice == 2)
	    		break;
	    }
	    return;
	    
		// login function giving 1 for customer, 2 for staff
    
    }
}
