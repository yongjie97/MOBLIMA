package Boundary;
import java.util.Scanner;

import Constant.DataFileConstant;
import Entity.UserRole;
import Repository.UserRepository;

public class LoginBoundary {
	private static int choice;
	private static String username;
	private static String password;
	private static UserRepository userRepository = new UserRepository(DataFileConstant.USER_FILE);
	private static int size = userRepository.size();
	public static int Login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("===============================");
	    System.out.println("Welcome to MOBLIMA - Login Module");
	    System.out.println("1: LOGIN AS STAFF");
	    System.out.println("2: LOGIN AS USER");
	    System.out.println("3: EXIT");
	    System.out.println("===============================");
	    choice = scan.nextInt();
	    if (choice == 3) {
	    	return 3;
	    }
	    System.out.println("Please enter your username");
		username = scan.next();
		System.out.println("Please enter your password");
		password = scan.next();
	    switch(choice) {
	    	case 1:	    		
            	for (int i=0;i < size; i++) {
            		if ((userRepository.get(i).getName() == username) && (userRepository.get(i).getPassword()== password)&&(userRepository.get(i).getRole()== UserRole.Staff)) {
            			return 2;
            		}
            	}
            	return 0;
	    	case 2:
	    		for (int i=0;i < size; i++) {
            		if ((userRepository.get(i).getName() == username) && (userRepository.get(i).getPassword()== password)&&(userRepository.get(i).getRole()== UserRole.Customer)) {
            			return 2;
            		}
	    		}
	    		return 0;
	    	default:
	    		return 0;
	    }
    
    }
}
