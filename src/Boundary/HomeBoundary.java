package Boundary;

import java.util.Scanner;

import Controller.MovieController;

public class HomeBoundary {

    public static void adminUI() {
        int userInput = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("===============================");
                System.out.println("Welcome to MOBLIMA - ADMIN");
                System.out.println("1: Manage Movie Listing");
                System.out.println("2: Manage Cinema/Showtime");
                System.out.println("3: Configure System Settings");
                System.out.println("Enter -1 to exit the program");
                System.out.println("===============================");
                System.out.print("Please enter your option: ");
                userInput = sc.nextInt();
                sc.nextLine();
                switch (userInput) {
                    case 1:
                        MovieBoundary.manageMovie();
                        break;
                    case 2:
                        CinemaBoundary.manageCinema();
                        break;
                    case 3:
                        // Configure settings UI
                        break;
                    case -1:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (userInput != -1);
    }

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
                        //MovieBoundary.showAvailableMovieList();
                        break;
                    case 3:
                        break;
                    case 4:
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
