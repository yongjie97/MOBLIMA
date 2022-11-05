package Boundary;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import Constant.ApplicationConstant;
import Controller.BookingController;
import Controller.CineplexController;
import Controller.MovieController;
import Controller.SystemSettingsController;
import Entity.Booking;
import Entity.Cinema;
import Entity.CinemaClass;
import Entity.Cineplex;
import Entity.Movie;
import Entity.MovieStatus;
import Entity.ShowTime;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;

public class BookingBoundary {

    public static void searchBooking() {
        String userInput = "";
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Please enter either your email/mobile number/transaction ID (-1 to go back): ");
                userInput = sc.nextLine();
                if (userInput.equals("-1"))
                    break;
                List<Booking> bookings = BookingController.searchBooking(userInput);
                listBookings(bookings);
                System.out.print("Please select a transaction (-1 to go back): ");
                int transaction = sc.nextInt();
                sc.nextLine();
                if (transaction == -1)
                    break;
                listBookingDetails(bookings.get(transaction-1));
                System.out.print("Press enter to continue..");
                sc.nextLine();
                return;
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (true);
    }

    public static void listTop5BySales() {
        try {
            System.out.println("Top 5 Movies by Sales:");
            List<Entry<Movie, Integer>> sortedMovies = BookingController.listBySales();
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                if (i < sortedMovies.size()) {
                    output.append(MessageFormat.format("{0}: {1} - {2} Tickets Sold\n", i+1, sortedMovies.get(i).getKey().getName(), sortedMovies.get(i).getValue()));
                } else {
                    output.append(MessageFormat.format("{0}: N/A\n", i+1));
                }
            }
            System.out.println(output.substring(0, output.length() - 1).toString());
            System.out.print("Press enter to continue..");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void listBookings(List<Booking> bookings) {
        System.out.println("Booking List");
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println(MessageFormat.format("{0}: {1} - {2}", i + 1, bookings.get(i).getTransactionID(),
                    getDateTimeFormat(bookings.get(i).getBookingTime())));
        }
    }

    public static void listPrices() {
        System.out.println("Prices");
        System.out.println(SystemSettingsController.listPrices());
        System.out.print("Press enter to continue..");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public static void purchaseTicket(int movieId) {
        int userInput = -1;
        do {
            try {
                BookingBoundary.listShowTime(movieId);
                Scanner sc = new Scanner(System.in);
                System.out.print("Please select a showtime (-1 to go back): ");
                userInput = sc.nextInt();
                sc.nextLine();
                BookingBoundary.seatOptions(userInput, movieId);
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());
            } catch (InvalidIdException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (userInput != -1);
    }

    public static void seatOptions(int selectedShowTime, int movieId) throws InvalidIdException {
        int userInput = -1;
        do {
            try {
                Cineplex cineplex = BookingController.getCineplex(selectedShowTime);
                Cinema cinema = BookingController.getCinema(selectedShowTime);
                ShowTime showtime = BookingController.getShowTime(selectedShowTime);
                System.out.println("===============================");
                System.out.println(MessageFormat.format("Selected: {0} | {1} ({2}) - {3}\n", cineplex.getName(),
                        cinema.getName(), cinema.getCinemaClass(), getDateTimeFormat(showtime.getDateTime())));
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
                        BookingBoundary.selectSeat(selectedShowTime);
                        break;
                    case 2:
                        unselectSeat();
                        break;
                    case 3:
                        BookingBoundary.confirmSelection(selectedShowTime);
                        return;
                    case -1:
                        break;
                    default:
                        throw new Exception();
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (userInput != -1);
    }

    public static void listBookingDetails(Booking booking) throws InvalidIdException {
        Cineplex cineplex = CineplexController.getCineplex(booking.getCineplexId() + 1);
        Cinema cinema = cineplex.getCinemas().get(booking.getCinemaId());
        ShowTime showTime = cinema.getShowTime().get(booking.getShowTimeId());
        Movie movie = MovieController.getMovie(booking.getMovieId()+1);
        StringBuilder output = new StringBuilder("===============================\n");
        output.append(MessageFormat.format("Ticket #: {0}\n", booking.getTransactionID()));
        output.append(MessageFormat.format("Price: {0,number,currency}\n", booking.getTotalPrice()));
        output.append(MessageFormat.format("Purchase Date: {0}\n", getDateTimeFormat(booking.getBookingTime())));
        output.append(MessageFormat.format("Theatre: {0} | {1} ({2})\n", cineplex.getName(), cinema.getName(),
                cinema.getCinemaClass()));
        output.append(MessageFormat.format("Showtime: {0} - {1}\n", movie.getName(), getDateTimeFormat(showTime.getDateTime())));
        String seats = "";
        for (String s : booking.getSeats()) {
            seats = seats.concat(s + ", ");
        }
        seats = seats.substring(0, seats.length()-2);
        output.append(MessageFormat.format("Seat(s): {0}\n", seats));
        output.append("===============================");
        System.out.println(output.toString());
    }

    public static void selectSeat(int selectedShowtime) throws InvalidIdException {
        try {
            System.out.print("Please select your seat (-1 to go back): ");
            Scanner sc = new Scanner(System.in);
            String selectedSeat = sc.nextLine();
            if (selectedSeat.equals("-1"))
                return;
            int ticketType = 4;
            Cinema cinema = BookingController.getCinema(selectedShowtime);
            if (cinema.getCinemaClass() == CinemaClass.PLATINUM) {
                ticketType = 5;
            } else {
                if (BookingController.checkIfNormalSeat(selectedShowtime, selectedSeat)) {
                    System.out.println("Ticket Type");
                    System.out.println("1. Normal");
                    System.out.println("2. Student (Valid ID required on entry)");
                    System.out.println("3. Senior (Valid ID required on entry)");
                    System.out.print("Please select a ticket type (-1 to go back): ");
                    ticketType = sc.nextInt();
                    sc.nextLine();
                    if (ticketType == -1)
                        return;
                    if (ticketType < 1 || ticketType > 3)
                        throw new InvalidInputException("Please enter a valid option.");
                }
            }
            BookingController.selectSeat(selectedShowtime, selectedSeat, ticketType);
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

    public static void confirmSelection(int selectedShowTime) throws InvalidInputException {
        if (!BookingController.hasSelectedSeat())
            throw new InvalidInputException("Please select a seat.");

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter your name: ");
            String name = sc.nextLine().trim();

            System.out.print("Please enter your email: ");
            String email = sc.nextLine().trim();

            System.out.print("Please enter your mobile number: ");
            String mobile = sc.nextLine().trim();

            Booking booking = BookingController.confirmSelection(selectedShowTime, name, email, mobile);
            System.out.println("Booking Successful! Thank you for choosing MOBLIMA.");
            BookingBoundary.listBookingDetails(booking);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void listShowTime(int movieId) throws InvalidIdException, EmptyListException {
        Movie movie = MovieController.getMovie(movieId);
        if (movie.getMovieStatus() == MovieStatus.COMING_SOON)
            throw new InvalidIdException("Movie not available for booking yet.");
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
