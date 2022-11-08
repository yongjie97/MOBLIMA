package Boundary;

import java.text.MessageFormat;
import java.util.Scanner;

import Constant.ApplicationConstant;
import Controller.CinemaController;
import Controller.CineplexController;
import Controller.ShowTimeController;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
/**
 * UI to interact with the show time
 */
public class ShowTimeBoundary {
	/**
	 * UI for staff to manage the show time of a movie
	 * 
	 * @param cineplexId					Id of cineplex
	 * @param cinemaId						Id of cinema
	 * @throws InvalidIdException			If an id input 
     * 										exception occurs
	 * @throws IndexOutOfBoundsException	If an index out of 
     * 										bounds exception occurs
	 */
    public static void manageShowTime(int cineplexId, int cinemaId) throws InvalidIdException, IndexOutOfBoundsException {
        String cineplexName = CineplexController.getCineplexName(cineplexId);
        String cinemaName = CinemaController.getCinemaName(cineplexId, cinemaId);

        int userInput = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("===============================");
                System.out.println("==     Managing Showtime     ==");
                System.out.println("===============================");
                System.out.println(MessageFormat.format("Selected: {0} | {1}", cineplexName, cinemaName));
                System.out.println("===============================");
                System.out.println("Action List");
                System.out.println("1: Add Showtime");
                System.out.println("2: Edit Showtime");
                System.out.println("3: Delete Showtime");
                System.out.println("4: View Cinema's Showtime");
                System.out.println("Enter -1 to go back");
                System.out.println("===============================");
                System.out.print("Please enter your option: ");
                userInput = sc.nextInt();
                sc.nextLine();
                switch (userInput) {
                    case 1:
                        ShowTimeBoundary.addShowTime(cineplexId, cinemaId);
                        break;
                    case 2:
                        ShowTimeBoundary.editShowTime(cineplexId, cinemaId);
                        break;
                    case 3:
                        ShowTimeBoundary.deleteShowTime(cineplexId, cinemaId);
                        break;
                    case 4:
                        ShowTimeBoundary.listShowTime(cineplexId, cinemaId);
                        System.out.print("Press enter to continue..");
                        sc.nextLine();
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
     * Adds the show time to selected movie
     * 
     * @param cineplexId	Id of cineplex
     * @param cinemaId		Id of cinema
     */
    public static void addShowTime(int cineplexId, int cinemaId) {
        try {
            MovieBoundary.showMovieList();
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter a movie id for the showtime: ");
            int movieId = sc.nextInt();
            sc.nextLine();

            System.out.print("Please enter the date and time (" +
                    ApplicationConstant.DATETIME_FORMAT + "): ");
            String dateTime = sc.nextLine().trim();

            ShowTimeController.addShowTime(cineplexId, cinemaId, movieId, dateTime);
            System.out.println("Showtime has been added.");
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Please enter a valid option.");
        }
    }
    /**
     * Edits the show time of a movie
     * 
     * @param cineplexId			Id of cineplex
     * @param cinemaId				Id of cinema
     * @throws EmptyListException	If an empty list
     * 								exception occurs
     */
    public static void editShowTime(int cineplexId, int cinemaId) throws EmptyListException {
        if (!ShowTimeController.hasShowTime(cineplexId, cinemaId))
            throw new EmptyListException("No showtime found.");

        while (true) {
            try {
                ShowTimeBoundary.listShowTime(cineplexId, cinemaId);
                System.out.print("Please enter a showtime id to edit (-1 to back): ");
                Scanner sc = new Scanner(System.in);
                int showTimeId = sc.nextInt();
                sc.nextLine();
                if (showTimeId == -1)
                    return;

                int editField = 0;
                String newDateTime;
                int newMovieId;
                do {
                    ShowTimeBoundary.listShowTimeDetail(cineplexId, cinemaId, showTimeId);
                    System.out.println("1: Edit movie");
                    System.out.println("2: Edit date time");
                    System.out.print("Please select a field to edit (-1 to back): ");
                    editField = sc.nextInt();
                    sc.nextLine();
                    switch (editField) {
                        case 1:
                            MovieBoundary.showMovieList();
                            System.out.print("Please enter a movie id to edit: ");
                            newMovieId = sc.nextInt();
                            ShowTimeController.editShowTimeMovie(cineplexId, cinemaId, showTimeId, newMovieId);
                            break;
                        case 2:
                            System.out.print("Please enter the date and time to edit ("
                                    + ApplicationConstant.DATETIME_FORMAT + "): ");
                            newDateTime = sc.nextLine().trim();
                            ShowTimeController.editShowTimeDateTime(cineplexId, cinemaId, showTimeId, newDateTime);
                            break;
                        case -1:
                            break;
                    }
                    System.out.println("Showtime has been edited.");
                } while (editField != -1);
            } catch (InvalidIdException e) {
                System.out.println(e.getMessage());
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        }
    }
    /**
     * Lists the show time of a cinema
     * 
     * @param cineplexId	Id of cineplex
     * @param cinemaId		Id of cinema	
     */
    public static void listShowTime(int cineplexId, int cinemaId) {
        try {
            System.out.println("Showtime List");
            System.out.println(ShowTimeController.listShowTime(cineplexId, cinemaId));
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Lists the details of a selected show time
     * 
     * @param cineplexId	Id of cineplex
     * @param cinemaId		Id of cinema
     * @param showTimeId	Id of show time
     */
    public static void listShowTimeDetail(int cineplexId, int cinemaId, int showTimeId) {
        try {
            System.out.println(ShowTimeController.listShowTimeDetail(cineplexId, cinemaId, showTimeId));
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Deletes a show time
     * 
     * @param cineplexId			Id of cineplex
     * @param cinemaId				Id of cinema
     * @throws EmptyListException	If an empty list
     * 								exception occurs
     */
    public static void deleteShowTime(int cineplexId, int cinemaId) throws EmptyListException {
        if (!ShowTimeController.hasShowTime(cineplexId, cinemaId))
        throw new EmptyListException("No showtime found.");

        while (true) {
            try {
                ShowTimeBoundary.listShowTime(cineplexId, cinemaId);
                System.out.print("Please enter a showtime id to delete (-1 to back): ");
                Scanner sc = new Scanner(System.in);
                int showTimeId = sc.nextInt();
                sc.nextLine();
                if (showTimeId == -1)
                    return;

                ShowTimeController.deleteShowTime(cineplexId, cinemaId, showTimeId);
                System.out.println("Showtime has been deleted.");
            } catch (InvalidIdException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        }
    }

}
