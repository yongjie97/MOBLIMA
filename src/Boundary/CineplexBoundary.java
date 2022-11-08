package Boundary;

import java.util.Scanner;

import Controller.CineplexController;
import Exception.EmptyListException;
import Exception.InvalidIdException;
/**
 * Interface for managing the cineplex for staff members
 * A staff can choose the cineplex they wish to edit
 */
public class CineplexBoundary {
	/**
	 * UI for staff to manage cineplex
	 * Staff can manage the cinema in selected cineplex
	 */
    public static void manageCineplex() {
        int userInput = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("===============================");
                System.out.println("==     Managing Cineplex     ==");
                System.out.println("===============================");
                CineplexBoundary.listCineplex();
                System.out.println("===============================");
                System.out.println("Action List");
                // System.out.println("1: Add Cineplex");
                // System.out.println("2: Edit Cineplex");
                // System.out.println("3: Delete Cineplex");
                System.out.println("1: Manage Cineplex's Cinema");
                System.out.println("Enter -1 to go back");
                System.out.println("===============================");
                System.out.print("Please enter your option: ");
                userInput = sc.nextInt();
                sc.nextLine();
                switch (userInput) {
                    // case 1:
                    //     // Add cineplex
                    //     break;
                    // case 2:
                    //     // Edit cineplex
                    //     break;
                    // case 3:
                    //     // Delete cineplex
                    //     break;
                    case 1:
                        int cineplexId = CineplexBoundary.chooseCineplex();
                        if (cineplexId == -1)
                            break;
                        CinemaBoundary.manageCinema(cineplexId);
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
     * Lists the cineplexs
     */

    public static void listCineplex() {
        System.out.println("Cineplex List");
        try {
            System.out.println(CineplexController.listCineplex());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Chooses a cineplex 
     * 
     * @return						exit status
     * @throws EmptyListException	If an empty list 
     * 								exception occurs
     */

    public static int chooseCineplex() throws EmptyListException {
        if (!CineplexController.hasCineplex())
            throw new EmptyListException("No cineplex found.");
            
        int userInput = 0;
        do {
            try {
                System.out.print("Please enter a cineplex id (-1 to back): ");
                Scanner sc = new Scanner(System.in);
                userInput = sc.nextInt();
                sc.nextLine();
                if (userInput == -1)
                    return -1;
                return userInput;
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (userInput != -1);
        return -1;
    }

}
