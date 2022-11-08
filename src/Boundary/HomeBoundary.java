package Boundary;

import java.util.Locale;

import java.util.Scanner;

import Controller.UserController;
/**
 * Home UI for the MOBALIMA app
 * Customers can view ticket prices
 * Search and list movies
 * Search for bookings
 * List the top 5 movies by sales or ratings
 * 
 * Staff can manage movies/cinplex
 * Configure system settings
 */
public class HomeBoundary {
	/**
	 * Main UI for MOBALIMA app 
	 * Staff can access staff options after login
	 */
    public static void userUI() {
        Locale.setDefault(Locale.US);
        int userInput = 0;
        do {
            try {
                int order = 1;
                Scanner sc = new Scanner(System.in);
                System.out.println("===============================");
                System.out.println("=      Welcome to MOBLIMA     =");
                System.out.println("===============================");
                if (!UserController.isLoggedIn())
                    System.out.println(order++ +": Login (FOR ADMIN ONLY)");
                System.out.println(order++ +": View Ticket Prices");
                System.out.println(order++ +": Search/List Movie");
                System.out.println(order++ +": Search Booking");
                System.out.println(order++ +": List Top 5 Movie Ranking by Sales");
                System.out.println(order++ +": List Top 5 Movie Ranking by Ratings");
                if (UserController.isLoggedIn()) {
                    System.out.println("==== ADMIN FUNCTIONALITIES ====");
                    System.out.println(order++ +": Manage Movie Listing");
                    System.out.println(order++ +": Manage Cineplex");
                    System.out.println(order++ +": Configure System Settings");
                    System.out.println(order++ +": Logout");
                    System.out.println("===============================");
                }
                System.out.println("Enter -1 to exit the program");
                System.out.println("===============================");
                System.out.print("Please enter your option: ");
                userInput = sc.nextInt();
                sc.nextLine();
                if (userInput != -1)
                    userInput += UserController.isLoggedIn() ? 1 : 0;
                switch (userInput) {
                    case 1:
                        if (UserController.isLoggedIn())
                            throw new Exception();
                        UserBoundary.login();
                        break;
                    case 2:
                        BookingBoundary.listPrices();
                        break;
                    case 3:
                        MovieBoundary.findMovie();
                        break;
                    case 4:
                        BookingBoundary.searchBooking();
                        break;
                    case 5:
                        BookingBoundary.listTop5BySales();
                        break;
                    case 6:
                        MovieReviewBoundary.listTop5ByRating();
                        break;
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        if (!UserController.isLoggedIn())
                            throw new Exception();
                        else if (userInput == 7)
                            MovieBoundary.manageMovie();
                        else if (userInput == 8)
                            CineplexBoundary.manageCineplex();
                        else if (userInput == 9)
                            SystemSettingsBoundary.manageSystemSettings();
                        else if (userInput == 10)
                            UserController.logout();
                        break;
                    case -1:
                        System.out.println("Thank you for choosing MOBLIMA! We hope to see you again.");
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (userInput != -1);
    }

}
