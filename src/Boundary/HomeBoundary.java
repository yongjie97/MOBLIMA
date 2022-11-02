package Boundary;

import java.util.Scanner;
import Controller.UserController;
import Entity.UserRole;
import Controller.MovieController;

public class HomeBoundary {
	public static void userUI() {
		int userInput = 0;
		do {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("===============================");
				System.out.println("Welcome to MOBLIMA");
				System.out.println("1: Search/List Movie");
				System.out.println("2: My Purchase History");
				System.out.println("3: List Top 5 Movie Ranking by Sales");
				System.out.println("4: List Top 5 Movie Ranking by Ratings");
				if (UserController.isLogin() == 2) {
					System.out.println("5: Manage Movie Listing");
					System.out.println("6: Manage Cinema/Showtime");
					System.out.println("7: Configure System Settings");
				}
				if (UserController.isLogin() == 0) {
					System.out.println("8: Login");
				}
				System.out.println("Enter -1 to exit the program");
				System.out.println("===============================");
				System.out.print("Please enter your option: ");
				userInput = sc.nextInt();
				sc.nextLine();
				switch (userInput) {
				case 1:
					MovieBoundary.findMovie();
					break;
				case 2:
					// MovieBoundary.showAvailableMovieList();
					break;
				case 3:
					// Sales is total number of bookings per movie
					// if not then by alphabetical
					break;
				case 4:
					// by average rating
					// if not then by alphabetical
					break;
				case 5:
					MovieBoundary.manageMovie();
					break;
				case 6:
					CinemaBoundary.manageCinema();
					break;
				case 7:
					// system settings boundary;
					break;
				case 8:
					LoginBoundary.Login();
					break;
				case -1:
					System.out.println("Thank you for choosing MOBLIMA! We hope to see you again.");
					break;
				default:
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Please enter a valid option.");
			}
		} while (userInput != -1);
	}

}
