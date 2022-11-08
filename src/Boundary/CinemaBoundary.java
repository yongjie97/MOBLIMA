package Boundary;

import java.text.MessageFormat;
import java.util.Scanner;

import Controller.CinemaController;
import Controller.CineplexController;
import Exception.EmptyListException;
import Exception.InvalidIdException;
/**
 * Interface for managing the cinema for staff members
 * A staff can list cinema details
 * list cinemas
 * manage the cinema show time
 */
public class CinemaBoundary {
	/**
	 * UI for staff to manage cinema
	 * Staff can view cinema details or
	 * manage the show time for each cineplex
	 * 
	 * @param cineplexId			Id of cineplex
	 * @throws InvalidIdException	If an id input 
     * 								exception occurs
	 */
    public static void manageCinema(int cineplexId) throws InvalidIdException {
        CineplexController.getCineplex(cineplexId);

        int userInput = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("===============================");
                System.out.println("==      Managing Cinema      ==");
                System.out.println("===============================");
                System.out.println(MessageFormat.format("Selected: {0}", CineplexController.getCineplex(cineplexId).getName()));
                System.out.println("===============================");
                CinemaBoundary.listCinema(cineplexId);
                System.out.println("===============================");
                System.out.println("Action List");
                System.out.println("1: Cinema Details");
                // System.out.println("2: Add Cinema");
                // System.out.println("3: Edit Cinema");
                // System.out.println("4: Delete Cinema");
                System.out.println("2: Manage Cinema's Showtime");
                System.out.println("Enter -1 to go back");
                System.out.println("===============================");
                System.out.print("Please enter your option: ");
                userInput = sc.nextInt();
                sc.nextLine();
                switch (userInput) {
                    case 1:
                        CinemaBoundary.listCinemaDetails(cineplexId);
                        System.out.print("Press enter to continue..");
                        sc.nextLine();
                        break;
                    // case 2:
                    //     // Add cinema
                    //     break;
                    // case 3:
                    //     // Edit cinema
                    //     break;
                    // case 4:
                    //     // Delete cinema
                    //     break;
                    case 2:
                        int cinemaId = CinemaBoundary.chooseCinema(cineplexId);
                        ShowTimeBoundary.manageShowTime(cineplexId, cinemaId);
                        break;
                    case -1:
                        break;
                    default:
                        throw new Exception();
                }
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());
            } catch (InvalidIdException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (userInput != -1);
    }
    /**
     * Lists the cinema in the cineplex
     * 
     * @param cineplexId	Id of cineplex
     */

    public static void listCinema(int cineplexId) {
        try {
            System.out.println("Cinema List");
            System.out.println(CinemaController.listCinema(cineplexId));
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Lists the details of the cinema
     * 
     * @param cineplexId	Id of cineplex
     */

    public static void listCinemaDetails(int cineplexId) {
        try {
            int cinemaId = chooseCinema(cineplexId);
            System.out.println(CinemaController.listCinemaInfo(cineplexId, cinemaId));
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Choose a cinema from given cineplex
     * 
     * @param cineplexId			Id of cineplex
     * @return						Choice of the user
     * @throws EmptyListException	If an empty list 
     * 								exception occurs
     */
    public static int chooseCinema(int cineplexId) throws EmptyListException {
        if (!CinemaController.hasCinema(cineplexId))
            throw new EmptyListException("No cinema found.");

        int userInput = 0;
        do {
            try {
                System.out.print("Please enter a cinema id (-1 to back): ");
                Scanner sc = new Scanner(System.in);
                userInput = sc.nextInt();
                sc.nextLine();
                return userInput;
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (userInput != -1);
        return -1;
    }

}
