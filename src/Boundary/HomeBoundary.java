package Boundary;

import java.util.Scanner;

import Controller.UserController;

public class HomeBoundary {

    public static void userUI() {
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
                System.out.println(order++ +": Search/List Movie");
                System.out.println(order++ +": My Purchase History");
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
                        MovieBoundary.findMovie();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        if (!UserController.isLoggedIn())
                            throw new Exception();
                        else if (userInput == 6)
                            MovieBoundary.manageMovie();
                        else if (userInput == 7)
                            CineplexBoundary.manageCineplex();
                        else if (userInput == 8)
                            SystemSettingsBoundary.manageSystemSettings();
                        else if (userInput == 9)
                            UserController.logout();
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

    /*public static void adminUI() {
        int userInput = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("===============================");
                System.out.println("==       MOBLIMA ADMIN       ==");
                System.out.println("===============================");
                System.out.println("Action List");
                System.out.println("1: Manage Movie Listing");
                System.out.println("2: Manage Cineplex");
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
                        CineplexBoundary.manageCineplex();
                        break;
                    case 3:
                        SystemSettingsBoundary.manageSystemSettings();
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
    }*/

}
