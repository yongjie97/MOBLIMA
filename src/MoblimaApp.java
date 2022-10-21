import java.util.Scanner;

import Boundary.MovieBoundary;
import Controller.CinemaController;
import Entity.Cinema;
import Entity.CinemaClass;

public class MoblimaApp {
    public static void main(String[] args) throws Exception {

        /*char[][] layout = { 
        {  0, 0, 0, 0, 0, 'S', 'C', 'R','E', 'E', 'N', 0, 0, 0 },
        { 'E', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'E' },
        { 'D', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'D' },
        { 'C', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'C' },
        { 'B', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'B' },
        { 'A', 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 'A' } };
        //CinemaService.addCinema("Hall 1", CinemaClass.NORMAL, layout);
        System.out.println(CinemaService.getCinemaInfo(0));

        CinemaService.editCinema(0, "Hall 1", CinemaClass.NORMAL, layout);
        System.out.println(CinemaService.getCinemaInfo(0));*/

        Scanner sc = new Scanner(System.in);
        int userInput;
        do {
            System.out.println("===============================");
            System.out.println("Welcome to MOBLIMA");
            System.out.println("1: Add Movie");
            System.out.println("2: Edit Movie");
            System.out.println("3: Delete Movie");
            System.out.println("4: View Movie List");
            System.out.println("5: Show Movie Details");
            System.out.println("Enter -1 to exit the program");
            System.out.println("===============================");
            System.out.print("Please enter your option: ");
            userInput = sc.nextInt();
            sc.nextLine();
            switch (userInput) {
                case 1: 
                    MovieBoundary.addMovie();
                    break;
                case 2: 
                    MovieBoundary.editMovie();
                    break;
                case 3: 
                    MovieBoundary.deleteMovie();
                    break;
                case 4: 
                    MovieBoundary.showMovieList();
                    break;
                case 5: 
                    MovieBoundary.showMovieDetails();
                    break;
                case -1: 
                    System.out.println("Thank you for choosing MOBLIMA");
                    break;
                default: 
                    System.out.println("Please enter a valid option");
                    break;
            }
        } while (userInput != -1);
    }
}
