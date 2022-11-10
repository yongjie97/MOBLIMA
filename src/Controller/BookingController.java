package Controller;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Constant.ApplicationConstant;
import Constant.DataFileConstant;
import Entity.Booking;
import Entity.Cinema;
import Entity.Cineplex;
import Entity.Holiday;
import Entity.Movie;
import Entity.MovieStatus;
import Entity.MovieType;
import Entity.ShowTime;
import Entity.SystemSettings;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Repository.BookingRepository;
import Repository.CineplexRepository;
import Repository.MovieRepository;

/**
 * The logic and functions for bookings
 */
public class BookingController {
    /**
     * Seat types that can be used
     */
    public enum SeatType {
        /**
         * Normal seat
         */
        NORMAL,
        /**
         * Couple seat
         */
        COUPLE,
        /**
         * Student seat
         */
        STUDENT,
        /**
         * Senior seat
         */
        SENIOR,
        /**
         * Platinum seat
         */
        PLATINUM
    }

    /**
     * The list of show times
     */
    private static List<int[]> showTimeList = new ArrayList<>();
    /**
     * The hash map of seats
     */
    private static HashMap<String, SeatType> selectedSeats = new HashMap<>();
    /**
     * The stored details of cineplex
     */
    private static CineplexRepository cineplexRepository = new CineplexRepository(DataFileConstant.CINEPLEX_FILE);
    /**
     * The stored details of movie
     */
    public static MovieRepository movieRepository = new MovieRepository(DataFileConstant.MOVIE_FILE);
    /**
     * The stored details of booking
     */
    private static BookingRepository bookingRepository = new BookingRepository(DataFileConstant.BOOKING_FILE);

    /**
     * Sorts the list of movies by sales
     * 
     * @return Sorted list of movies by sales
     * @throws EmptyListException If an empty list
     *                            exception occurs
     */
    public static List<Entry<Movie, Integer>> listBySales() throws EmptyListException {
        if (movieRepository.isEmpty())
            throw new EmptyListException("No movies found.");

        List<Movie> movies = movieRepository.getAll();
        HashMap<Integer, Integer> movieKey = new HashMap<>();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getMovieStatus() != MovieStatus.FINISHED)
                movieKey.put(i, 0);
        }
        List<Booking> bookings = bookingRepository.getAll();
        for (Booking b : bookings) {
            if (movieKey.containsKey(b.getMovieId()))
                movieKey.put(b.getMovieId(), movieKey.get(b.getMovieId()) + 1);
        }

        List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(movieKey.entrySet());
        Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        List<Entry<Movie, Integer>> sortedMovieList = new ArrayList<>();
        for (Entry<Integer, Integer> item : list) {
            if (item.getValue() != 0)
                sortedMovieList.add(Map.entry(movies.get(item.getKey()), item.getValue()));
        }
        return sortedMovieList;
    }

    /**
     * Lists the show time of a movie
     * 
     * @param movieId Id of selected movie
     * @return String of movie show time
     * @throws EmptyListException If an empty list
     *                            exception occurs
     */
    public static String listMovieShowTime(int movieId) throws EmptyListException {
        movieId = normaliseId(movieId);
        showTimeList.clear();
        selectedSeats.clear();
        List<Cineplex> cineplexes = cineplexRepository.getAll();
        StringBuilder output = new StringBuilder();
        int i = 1;
        for (int j = 0; j < cineplexes.size(); j++) {
            Cineplex cineplex = cineplexes.get(j);
            for (int j2 = 0; j2 < cineplex.getCinemas().size(); j2++) {
                Cinema cinema = cineplex.getCinemas().get(j2);
                for (int j3 = 0; j3 < cinema.getShowTime().size(); j3++) {
                    ShowTime showTime = cinema.getShowTime().get(j3);
                    if (showTime.getMovieId() == movieId && showTime.getDateTime().isAfter(LocalDateTime.now())) {
                        output.append(MessageFormat.format("{0}: {1} | {2} - {3}\n", i++, cineplex.getName(),
                                cinema.getName(), getDateTimeFormat(showTime.getDateTime())));
                        showTimeList.add(new int[] { j, j2, j3 });
                    }
                }
            }
        }
        if (output.isEmpty())
            throw new EmptyListException("No showtime found.");
        else
            return output.substring(0, output.length() - 1).toString();
    }

    /**
     * Selects seats and stores it into
     * {@link BookingController#selectedSeats } hash map
     * 
     * @param showTimeSelection Choice of show time
     * @param seatNo            Seat number
     * @param seatType          Type of seat
     * @throws InvalidInputException If an id input
     *                               exception occurs
     */
    public static void selectSeat(int showTimeSelection, String seatNo, int seatType) throws InvalidInputException {
        seatType = normaliseId(seatType);
        showTimeSelection = normaliseId(showTimeSelection);
        if (!BookingController.checkIfSeatAvailable(showTimeSelection, seatNo))
            throw new InvalidInputException("Please select a valid seat.");
        if (selectedSeats.containsKey(seatNo))
            throw new InvalidInputException("You have already selected this seat.");
        SeatType stype;
        if (seatType == 0)
            stype = SeatType.NORMAL;
        else if (seatType == 1)
            stype = SeatType.STUDENT;
        else if (seatType == 2)
            stype = SeatType.SENIOR;
        else if (seatType == 3)
            stype = SeatType.COUPLE;
        else if (seatType == 4)
            stype = SeatType.PLATINUM;
        else
            throw new InvalidInputException("Please enter a valid ticket type.");

        selectedSeats.put(seatNo, stype);
    }

    /**
     * Lists the bookings of a customer
     * 
     * @param query Query of customer
     * @return Booking made by customer
     * @throws EmptyListException If an empty list
     *                            exception occurs
     */
    public static List<Booking> searchBooking(String query) throws EmptyListException {
        List<Booking> bookings = bookingRepository.getAll();
        List<Booking> bookingList = new ArrayList<>();
        for (Booking b : bookings) {
            if (b.getEmail().equals(query) || b.getMobile().equals(query)) {
                bookingList.add(b);
            }
            if (b.getTransactionID().equals(query)) {
            	bookingList.add(b);
            	return bookingList;
            }
        }
        if (bookingList.isEmpty())
            throw new EmptyListException("No bookings found");
        return bookingList;
    }

    /**
     * Unselectes a selected seat
     * 
     * @param seatNo Seat number
     * @throws InvalidInputException If an input
     *                               exception occurs
     */
    public static void unselectSeat(String seatNo) throws InvalidInputException {
        if (!selectedSeats.containsKey(seatNo))
            throw new InvalidInputException("You have not selected this seat.");
        selectedSeats.remove(seatNo);
    }

    /**
     * Confirms the booking of a customer
     * and adds it to the repository
     * 
     * @param showTimeSelection Selection of time of movie
     * @param name              Name of customer
     * @param email             Email of customer
     * @param mobile            Mobile of customer
     * @return Return booking
     * @throws InvalidIdException    If an id input
     *                               exception occurs
     * @throws InvalidInputException If an input
     *                               exception occurs
     */
    public static Booking confirmSelection(int showTimeSelection, String name, String email, String mobile)
            throws InvalidIdException, InvalidInputException {

        if (selectedSeats.isEmpty())
            throw new InvalidInputException("Please select a seat");

        showTimeSelection = normaliseId(showTimeSelection);
        int[] ids = showTimeList.get(showTimeSelection);
        int cineplexId = ids[0];
        int cinemaId = ids[1];
        int showTimeId = ids[2];

        Cineplex cineplex = cineplexRepository.get(cineplexId);
        Cinema cinema = cineplex.getCinemas().get(cinemaId);
        ShowTime showTime = cinema.getShowTime().get(showTimeId);
        Movie movie = movieRepository.get(showTime.getMovieId());
        SystemSettings systemSettings = SystemSettingsController.getSystemSettings();

        BigDecimal totalPrice = new BigDecimal(0);
        List<String> seats = new ArrayList<>();
        for (Map.Entry<String, SeatType> entry : selectedSeats.entrySet()) {
            String key = entry.getKey();
            SeatType value = entry.getValue();

            seats.add(key);
            showTime.getSeatsTaken().add(key);

            switch (value) {
                case NORMAL:
                    totalPrice = totalPrice.add(systemSettings.getNormalPrice());
                    break;
                case COUPLE:
                    totalPrice = totalPrice.add(systemSettings.getCouplePrice());
                    break;
                case STUDENT:
                    totalPrice = totalPrice.add(systemSettings.getStudentPrice());
                    break;
                case SENIOR:
                    totalPrice = totalPrice.add(systemSettings.getSeniorPrice());
                    break;
                case PLATINUM:
                    totalPrice = totalPrice.add(systemSettings.getPlatinumPrice());
                    break;
            }
        }

        if (movie.getMovieType() == MovieType.BLOCKBLUSTER)
            totalPrice = totalPrice
                    .add(systemSettings.getBlockbusterIncrement().multiply(new BigDecimal(selectedSeats.size())));
        if (movie.getMovieType() == MovieType.THREE_D)
            totalPrice = totalPrice
                    .add(systemSettings.getThreeDIncrement().multiply(new BigDecimal(selectedSeats.size())));

        boolean isHoliday = false;
        for (Holiday holiday : systemSettings.getHolidays()) {
            if (holiday.getDate().isEqual(showTime.getDateTime().toLocalDate())) {
                totalPrice = totalPrice
                        .add(systemSettings.getHolidayIncrement().multiply(new BigDecimal(selectedSeats.size())));
                isHoliday = true;
                break;
            }
        }

        if (!isHoliday)
            if (showTime.getDateTime().getDayOfWeek() == DayOfWeek.SATURDAY
                    || showTime.getDateTime().getDayOfWeek() == DayOfWeek.SUNDAY)
                totalPrice = totalPrice
                        .add(systemSettings.getWeekendIncrement().multiply(new BigDecimal(selectedSeats.size())));

        totalPrice = totalPrice.add(totalPrice.multiply(systemSettings.getGst()));

        showTimeSelection = normaliseId(showTimeSelection);
        LocalDateTime bookingDate = LocalDateTime.now();
        StringBuilder tid_sb = new StringBuilder(cinema.getCinemaCode());
        tid_sb.append(bookingDate.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")));
        Collections.sort(seats);
        Booking booking = new Booking(tid_sb.toString(), name, email, mobile, seats, showTime.getMovieId(), cineplexId,
                cinemaId,
                showTimeId,
                bookingDate, totalPrice);
        bookingRepository.add(booking);
        cineplexRepository.edit(cineplexId, cineplex);

        return booking;
    }

    /**
     * Checks if seat is selected
     * 
     * @return true/false
     */
    public static boolean hasSelectedSeat() {
        return !selectedSeats.isEmpty();
    }

    /**
     * Gets cineplex
     * 
     * @param showTimeSelection Selected show time
     * @return This cineplex with the show time
     */
    public static Cineplex getCineplex(int showTimeSelection) {
        showTimeSelection = normaliseId(showTimeSelection);
        int[] ids = showTimeList.get(showTimeSelection);
        return cineplexRepository.get(ids[0]);
    }

    /**
     * Gets cinema
     * 
     * @param showTimeSelection Selected show time
     * @return This cinema with the show time
     */
    public static Cinema getCinema(int showTimeSelection) {
        showTimeSelection = normaliseId(showTimeSelection);
        int[] ids = showTimeList.get(showTimeSelection);
        return cineplexRepository.get(ids[0]).getCinemas().get(ids[1]);
    }

    /**
     * Gets show time
     * 
     * @param showTimeSelection Selected show time
     * @return Cinema with the show time
     */
    public static ShowTime getShowTime(int showTimeSelection) {
        showTimeSelection = normaliseId(showTimeSelection);
        int[] ids = showTimeList.get(showTimeSelection);
        return cineplexRepository.get(ids[0]).getCinemas().get(ids[1]).getShowTime().get(ids[2]);
    }

    /**
     * Lists the seats for a show time
     * 
     * @param showTimeSelection Selected show time
     * @return Seats for the show time
     * @throws InvalidIdException If an id input
     *                            exception occurs
     */
    public static String listShowTimeSeats(int showTimeSelection) throws InvalidIdException {
        showTimeSelection = normaliseId(showTimeSelection);
        if (showTimeSelection < 0 || showTimeSelection > showTimeList.size())
            throw new InvalidIdException("Please select a valid option");

        int[] ids = showTimeList.get(showTimeSelection);
        int cineplexId = ids[0];
        int cinemaId = ids[1];
        int showTimeId = ids[2];

        if (cineplexId < 0 || cineplexId > cineplexRepository.size())
            throw new InvalidIdException("Please enter a valid cineplex id.");

        Cineplex cineplex = cineplexRepository.get(cineplexId);
        if (cinemaId < 0 || cinemaId >= cineplex.getCinemas().size())
            throw new InvalidIdException("Please enter a valid cinema id.");

        Cinema cinema = cineplex.getCinemas().get(cinemaId);
        if (showTimeId < 0 || showTimeId >= cinema.getShowTime().size())
            throw new InvalidIdException("Please enter a valid showtime id.");

        ShowTime showTime = cinema.getShowTime().get(showTimeId);

        StringBuilder newString = new StringBuilder();
        char[][] seatLayout = cinema.getCinemaLayout();

        for (int i = 0; i < seatLayout.length; i++) {
            char row = seatLayout[i][0];
            int seatNo = 1;
            for (int j = 0; j < seatLayout[i].length; j++) {
                newString.append(getSeatTypeFormat(seatLayout[i][j], row, seatNo, showTime));
                if (seatLayout[i][j] == 1 || seatLayout[i][j] == 2)
                    seatNo++;
            }
            newString.append("\n");
        }
        newString.append(
                "\nLEGEND:\nSeat ranges from 1 (starting from to left) to the right.\n|*| - Available, |*  *| - Couple Seat, \u001B[31m|x| - Sold\u001B[0m, \u001B[34m|*| - Selected Seat\u001B[0m");
        return newString.toString();
    }

    /**
     * Gets format of seat type
     * 
     * @param c        layout of seat
     * @param row      row in cinema
     * @param seatNo   seat number
     * @param showTime show time
     * @return
     */
    private static String getSeatTypeFormat(char c, char row, int seatNo, ShowTime showTime) {
        if (c == 1) {
            if (showTime.getSeatsTaken().contains(new StringBuilder().append(row).append(seatNo).toString()))
                return "\u001B[31m|x|\u001B[0m";
            else if (selectedSeats.containsKey(new StringBuilder().append(row).append(seatNo).toString()))
                return "\u001B[34m|*|\u001B[0m";
            else
                return "|*|";
        } else if (c == 2) {
            if (showTime.getSeatsTaken().contains(new StringBuilder().append(row).append(seatNo).toString()))
                return "\u001B[31m|x  x|\u001B[0m";
            else if (selectedSeats.containsKey(new StringBuilder().append(row).append(seatNo).toString()))
                return "\u001B[34m|*  *|\u001B[0m";
            else
                return "|*  *|";
        } else if (c == 0) {
            return "   ";
        } else {
            return new StringBuilder().append(c).toString();
        }
    }

    /**
     * Checks type of seat
     * 
     * @param showTimeSelection Selected show time
     * @param seat              seat selected
     * @return true/false
     * @throws InvalidInputException If an id input
     *                               exception occurs
     */
    public static boolean checkIfNormalSeat(int showTimeSelection, String seat) throws InvalidInputException {
        showTimeSelection = normaliseId(showTimeSelection);
        int[] ids = showTimeList.get(showTimeSelection);
        int cineplexId = ids[0];
        int cinemaId = ids[1];

        Cineplex cineplex = cineplexRepository.get(cineplexId);
        Cinema cinema = cineplex.getCinemas().get(cinemaId);

        char[][] seatLayout = cinema.getCinemaLayout();
        int currentSeat = 0;
        for (int i = 0; i < seatLayout.length; i++) {
            if (seatLayout[i][0] == seat.charAt(0)) {
                for (int j = 0; j < seatLayout[i].length; j++) {
                    if (seatLayout[i][j] == 1 || seatLayout[i][j] == 2) {
                        currentSeat += 1;
                        if (currentSeat == (seat.charAt(1) - '0'))
                            return seatLayout[i][j] == 1;
                    }
                }
            }
        }
        throw new InvalidInputException("Please enter a valid seat.");
    }

    /**
     * Checks availability of seats
     * 
     * @param showTimeSelection Selected show time
     * @param seat              selected seat
     * @return true/false
     */
    private static boolean checkIfSeatAvailable(int showTimeSelection, String seat) {
        int[] ids = showTimeList.get(showTimeSelection);
        int cineplexId = ids[0];
        int cinemaId = ids[1];
        int showTimeId = ids[2];

        Cineplex cineplex = cineplexRepository.get(cineplexId);
        Cinema cinema = cineplex.getCinemas().get(cinemaId);
        ShowTime showTime = cinema.getShowTime().get(showTimeId);

        if (showTime.getSeatsTaken().contains(seat))
            return false;
        else {
            char[][] seatLayout = cinema.getCinemaLayout();
            int currentSeat = 0;
            for (int i = 0; i < seatLayout.length; i++) {
                if (seatLayout[i][0] == seat.charAt(0)) {
                    for (int j = 0; j < seatLayout[i].length; j++) {
                        if (seatLayout[i][j] == 1 || seatLayout[i][j] == 2) {
                            currentSeat += 1;
                            if (currentSeat == (seat.charAt(1) - '0'))
                                return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if the show time is fully booked
     * 
     * @param showTimeSelection Selected show time
     * @return true/false
     */
    public static boolean checkIfFullyBooked(int showTimeSelection) {
        showTimeSelection = normaliseId(showTimeSelection);
        int[] ids = showTimeList.get(showTimeSelection);
        int cineplexId = ids[0];
        int cinemaId = ids[1];
        int showTimeId = ids[2];

        Cineplex cineplex = cineplexRepository.get(cineplexId);
        Cinema cinema = cineplex.getCinemas().get(cinemaId);
        ShowTime showTime = cinema.getShowTime().get(showTimeId);

        char[][] seatLayout = cinema.getCinemaLayout();
        int totalSeats = 0;
        for (int i = 0; i < seatLayout.length; i++) {
            for (int j = 0; j < seatLayout[i].length; j++) {
                if (seatLayout[i][j] == 1 || seatLayout[i][j] == 2)
                    totalSeats += 1;
            }
        }
        return (totalSeats == showTime.getSeatsTaken().size()) ? true : false;
    }

    /**
     * Changes date time to fixed format
     * 
     * @param dateTime Date and time
     * @return Formatted date and time
     */
    public static String getDateTimeFormat(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ApplicationConstant.DATETIME_FORMAT);
        return dateTime.format(formatter).toString();
    }

    /**
     * Normalises id
     * 
     * @param id id
     * @return normalised id
     */
    public static int normaliseId(int id) {
        return id - 1;
    }

}
