package Boundary;

import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import Constant.ApplicationConstant;
import Controller.CinemaController;
import Controller.ShowTimeController;
import Entity.ShowTime;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;

public class CinemaBoundary {

    public static void manageCinema() {
        int userInput = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("===============================");
                System.out.println("Welcome to MOBLIMA - Cinema/Showtime Module");
                System.out.println("1: Add Showtime");
                System.out.println("2: Edit Showtime");
                System.out.println("3: Delete Showtime");
                System.out.println("4: View Cinema's Showtime");
                System.out.println("Enter -1 to exit the program");
                System.out.println("===============================");
                System.out.print("Please enter your option: ");
                userInput = sc.nextInt();
                sc.nextLine();
                switch (userInput) {
                    case 1:
                        CinemaBoundary.addShowTime();
                        break;
                    case 2:
                        CinemaBoundary.editShowTime();
                        break;
                    case 3:
                        CinemaBoundary.deleteShowTime();
                        break;
                    case 4:
                        CinemaBoundary.showShowTime();
                        break;
                    case -1:
                        System.out.println("Thank you for choosing MOBLIMA");
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (userInput != -1);
    }

    public static void addShowTime() {
        try {
            getCinema();
            System.out.print("Please enter a cinema id: ");
            Scanner sc = new Scanner(System.in);
            int cinemaId = sc.nextInt();
            sc.nextLine();

            MovieBoundary.showMovieList();
            System.out.print("Please enter a movie id to add: ");
            int movieId = sc.nextInt();
            sc.nextLine();

            System.out.print("Please enter the date and time (" + ApplicationConstant.DATETIME_FORMAT + "): ");
            String dateTime = sc.nextLine().trim();

            ShowTimeController.addShowTime(cinemaId - 1, movieId - 1, dateTime);
            System.out.println("Showtime has been added.");
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Please enter a valid option.");
        }
    }

    public static void editShowTime() {
        while (true) {
            try {
                getCinema();
                System.out.print("Please enter a cinema id (-1 to back): ");
                Scanner sc = new Scanner(System.in);
                int cinemaId = sc.nextInt();
                sc.nextLine();
                if (cinemaId == -1)
                    return;

                getShowTime(cinemaId - 1);
                System.out.print("Please enter a showtime id to edit (-1 to back): ");
                int showTimeId = sc.nextInt();
                sc.nextLine();
                if (showTimeId == -1)
                    return;

                int editField = 0;
                String newDateTime;
                int newMovieId;
                do {                
                    getShowTimeDetail(cinemaId-1, showTimeId-1);
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
                            ShowTimeController.editShowTimeMovie(cinemaId-1, showTimeId-1, newMovieId-1);
                            break;
                        case 2:
                            System.out.print("Please enter the date and time to edit (" + ApplicationConstant.DATETIME_FORMAT + "): ");
                            newDateTime = sc.nextLine().trim();
                            ShowTimeController.editShowTimeDateTime(cinemaId-1, showTimeId-1, newDateTime);
                            break;
                        case -1:
                            break;
                    }
                    System.out.println("Showtime has been edited.");
                } while (editField != -1);
            } catch (InvalidIdException e) {
                System.out.println(e.getMessage());
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        }
    }

    public static void deleteShowTime() {
        while (true) {
            try {
                getCinema();
                System.out.print("Please enter a cinema id (-1 to back): ");
                Scanner sc = new Scanner(System.in);
                int cinemaId = sc.nextInt();
                sc.nextLine();
                if (cinemaId == -1)
                    return;

                getShowTime(cinemaId - 1);
                System.out.print("Please enter a showtime id to delete (-1 to back): ");
                int showTimeId = sc.nextInt();
                sc.nextLine();
                if (showTimeId == -1)
                    return;

                ShowTimeController.deleteShowTime(cinemaId - 1, showTimeId - 1);
                System.out.println("Showtime has been deleted.");
            } catch (InvalidIdException e) {
                System.out.println(e.getMessage());
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        }
    }

    public static void showShowTime() {
        while (true) {
            try {
                getCinema();
                System.out.print("Please enter a cinema id (-1 to back): ");
                Scanner sc = new Scanner(System.in);
                int cinemaId = sc.nextInt();
                sc.nextLine();
                if (cinemaId == -1)
                    return;

                getShowTime(cinemaId - 1);
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        }
    }

    public static void getCinema() {
        System.out.println("Cinema List");
        System.out.println(CinemaController.getCinemaList());
    }

    public static void getShowTime(int cinemaId) throws InvalidIdException, EmptyListException {
        System.out.println(CinemaController.getCinemaShowTime(cinemaId));
    }

    public static void getShowTimeDetail(int cinemaId, int showTimeId) throws InvalidIdException {
        System.out.println(ShowTimeController.getShowTimeDetail(cinemaId, showTimeId));
    }

}
