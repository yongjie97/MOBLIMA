package Boundary;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Constant.ApplicationConstant;
import Controller.BookingController;
import Controller.MovieController;
import Entity.Cinema;
import Entity.Cineplex;
import Entity.ShowTime;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;

public class BookingBoundary {

    public static void purchaseTicket(int movieId) {
        int userInput = -1;
        do {
            try {
                BookingBoundary.listShowTime(movieId);
                Scanner sc = new Scanner(System.in);
                System.out.print("Please select a showtime (-1 to go back): ");
                userInput = sc.nextInt();
                sc.nextLine();
                BookingBoundary.seatOptions(userInput);
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());
            } catch (InvalidIdException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (userInput != -1);
    }

    public static void seatOptions(int selectedShowTime) throws InvalidIdException {
        int userInput = -1;
        do {
            try {
                Cineplex cineplex = BookingController.getCineplex(selectedShowTime);
                Cinema cinema = BookingController.getCinema(selectedShowTime);
                ShowTime showtime = BookingController.getShowTime(selectedShowTime);
                System.out.println("===============================");
                System.out.println(MessageFormat.format("Selected: {0} | {1} - {2}\n", cineplex.getName(),
                        cinema.getName(), getDateTimeFormat(showtime.getDateTime())));
                listSeats(selectedShowTime);
                System.out.println("===============================");
                System.out.println("Action List");
                System.out.println("1. Select Seat");
                System.out.println("2. Unselect Seat");
                System.out.println("3. Confirm Selection");
                System.out.println("Enter -1 to go back");
                System.out.println("===============================");
                System.out.print("Please enter your option: ");
                Scanner sc = new Scanner(System.in);
                userInput = sc.nextInt();
                sc.nextLine();
                switch (userInput) {
                    case 1:
                        selectSeat(selectedShowTime);
                        break;
                    case 2:
                        unselectSeat();
                        break;
                    case 3:
                        break;
                    case -1:
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }

        } while (userInput != -1);
    }

    public static void selectSeat(int selectedShowtime) throws InvalidIdException {
        try {
            System.out.print("Please select your seat (-1 to go back): ");
            Scanner sc = new Scanner(System.in);
            String selectedSeat = sc.nextLine();
            if (selectedSeat.equals("-1"))
                return;
            BookingController.selectSeat(selectedShowtime, selectedSeat);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void unselectSeat() throws InvalidInputException {
        try {
            System.out.print("Please enter the seat to unselect (-1 to go back): ");
            Scanner sc = new Scanner(System.in);
            String selectedSeat = sc.nextLine();
            if (selectedSeat.equals("-1"))
                return;
            BookingController.unselectSeat(selectedSeat);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void listShowTime(int movieId) throws InvalidIdException, EmptyListException {
        System.out.println("Showtime List - " + MovieController.getMovie(movieId).getName());
        System.out.println(BookingController.listMovieShowTime(movieId));
    }

    public static void listSeats(int selectedShowtime) throws InvalidIdException {
        System.out.println(BookingController.listShowTimeSeats(selectedShowtime));
    }

    public static String getDateTimeFormat(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ApplicationConstant.DATETIME_FORMAT);
        return dateTime.format(formatter).toString();
    }

}
