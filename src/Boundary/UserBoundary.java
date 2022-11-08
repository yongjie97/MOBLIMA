package Boundary;

import java.util.Scanner;

import Controller.UserController;
import Exception.InvalidInputException;
/**
 * UI for user
 */
public class UserBoundary {
	/**
	 * Login function for user to enter their account
	 */
    public static void login() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter your email: ");
            String email = sc.next().trim();
            System.out.print("Please enter your password: ");
            String password = sc.next().trim();
            UserController.login(email, password);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

}
