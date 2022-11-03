package Controller;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import Constant.ApplicationConstant;
import Constant.DataFileConstant;
import Entity.Cinema;
import Entity.Cineplex;
import Entity.ShowTime;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Repository.CineplexRepository;

public class BookingController {

    private static List<int[]> showTimeList = new ArrayList<>();
    private static HashSet<String> selectedSeats = new HashSet<>();

    private static CineplexRepository cineplexRepository = new CineplexRepository(DataFileConstant.CINEPLEX_FILE);

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
                    if (showTime.getMovieId() == movieId) {
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

    public static void selectSeat(int showTimeSelection, String seatNo) throws InvalidInputException {
        showTimeSelection = normaliseId(showTimeSelection);
        if (!BookingController.checkIfSeatAvailable(showTimeSelection, seatNo))
            throw new InvalidInputException("Please select a valid seat.");
        if (selectedSeats.contains(seatNo))
            throw new InvalidInputException("You have already selected this seat.");
        selectedSeats.add(seatNo);
    }

    public static void unselectSeat(String seatNo) throws InvalidInputException {
        if (!selectedSeats.contains(seatNo))
            throw new InvalidInputException("You have not selected this seat.");
        selectedSeats.remove(seatNo);
    }

    public static Cineplex getCineplex(int showTimeSelection) {
        showTimeSelection = normaliseId(showTimeSelection);
        int[] ids = showTimeList.get(showTimeSelection);
        return cineplexRepository.get(ids[0]);
    }

    public static Cinema getCinema(int showTimeSelection) {
        showTimeSelection = normaliseId(showTimeSelection);
        int[] ids = showTimeList.get(showTimeSelection);
        return cineplexRepository.get(ids[0]).getCinemas().get(ids[1]);
    }

    public static ShowTime getShowTime(int showTimeSelection) {
        showTimeSelection = normaliseId(showTimeSelection);
        int[] ids = showTimeList.get(showTimeSelection);
        return cineplexRepository.get(ids[0]).getCinemas().get(ids[1]).getShowTime().get(ids[2]);
    }

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
                "\nLEGEND:\nSeat ranges from 1 (starting from to left) to the right.\n|*| - Available, |*  *| - Couple Seat, |x| - Sold, |o| - Selected Seat");
        return newString.toString();
    }

    private static String getSeatTypeFormat(char c, char row, int seatNo, ShowTime showTime) {
        if (c == 1) {
            if (showTime.getSeatsTaken().contains(new StringBuilder().append(row).append(seatNo).toString()))
                return "|x|";
            else if (selectedSeats.contains(new StringBuilder().append(row).append(seatNo).toString()))
                return "|o|";
            else
                return "|*|";
        } else if (c == 2) {
            if (showTime.getSeatsTaken().contains(new StringBuilder().append(row).append(seatNo).toString()))
                return "|x  x|";
            else if (selectedSeats.contains(new StringBuilder().append(row).append(seatNo).toString()))
                return "|o  o|";
            else
                return "|*  *|";
        } else if (c == 0) {
            return "   ";
        } else {
            return new StringBuilder().append(c).toString();
        }
    }

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

    public static String getDateTimeFormat(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ApplicationConstant.DATETIME_FORMAT);
        return dateTime.format(formatter).toString();
    }

    public static int normaliseId(int id) {
        return id - 1;
    }

}
