package Boundary;

import java.util.Scanner;

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
                        //MovieBoundary.deleteMovie();
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
    
}
