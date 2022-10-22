package Controller;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import Constant.ApplicationConstant;
import Constant.DataFileConstant;
import Entity.Cinema;
import Entity.Movie;
import Entity.ShowTime;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Repository.CinemaRepository;
import Repository.MovieRepository;

public class ShowTimeController {

    private static CinemaRepository cinemaRepository = new CinemaRepository(DataFileConstant.CINEMA_FILE);
    private static MovieRepository movieRepository = new MovieRepository(DataFileConstant.MOVIE_FILE);

    public static void addShowTime(int cinemaId, int movieId, String dateTime)
            throws InvalidIdException, InvalidInputException {
        if (cinemaId < 0 || cinemaId >= cinemaRepository.size())
            throw new InvalidIdException("Please enter a valid cinema id.");
        if (movieId < 0 || movieId >= movieRepository.size())
            throw new InvalidIdException("Please enter a valid movie id.");

        try {
            LocalDateTime formattedDateTime = LocalDateTime.parse(dateTime,
                    DateTimeFormatter.ofPattern(ApplicationConstant.DATETIME_FORMAT));
            Cinema cinema = cinemaRepository.get(cinemaId);
            Movie movie = movieRepository.get(movieId);
            ShowTime newShowTime = new ShowTime(movie, formattedDateTime);
            cinema.getShowTime().add(newShowTime);
            cinemaRepository.edit(cinemaId, cinema);
        } catch (Exception e) {
            throw new InvalidInputException("Please enter a valid date time format.");
        }
    }

    public static void editShowTimeMovie(int cinemaId, int showTimeId, int movieId) throws InvalidIdException {
        if (cinemaId < 0 || cinemaId >= cinemaRepository.size())
            throw new InvalidIdException("Please enter a valid cinema id.");
        if (showTimeId < 0 || showTimeId >= movieRepository.size())
            throw new InvalidIdException("Please enter a valid showtime id.");
        if (movieId < 0 || movieId >= movieRepository.size())
            throw new InvalidIdException("Please enter a valid movie id.");

        Cinema cinema = cinemaRepository.get(cinemaId);
        Movie movie = movieRepository.get(movieId);
        ShowTime oldShowTime = cinema.getShowTime().get(showTimeId);
        ShowTime newShowTime = new ShowTime(movie, oldShowTime.getDateTime());
        cinema.getShowTime().set(showTimeId, newShowTime);
        cinemaRepository.edit(cinemaId, cinema);

    }

    public static void editShowTimeDateTime(int cinemaId, int showTimeId, String dateTime)
            throws InvalidIdException, InvalidInputException {
        if (cinemaId < 0 || cinemaId >= cinemaRepository.size())
            throw new InvalidIdException("Please enter a valid cinema id.");
        if (showTimeId < 0 || showTimeId >= movieRepository.size())
            throw new InvalidIdException("Please enter a valid showtime id.");

        try {
            LocalDateTime formattedDateTime = LocalDateTime.parse(dateTime,
                    DateTimeFormatter.ofPattern(ApplicationConstant.DATETIME_FORMAT));
            Cinema cinema = cinemaRepository.get(cinemaId);
            ShowTime oldShowTime = cinema.getShowTime().get(showTimeId);
            ShowTime newShowTime = new ShowTime(oldShowTime.getMovie(), formattedDateTime);
            cinema.getShowTime().set(showTimeId, newShowTime);
            cinemaRepository.edit(cinemaId, cinema);
        } catch (DateTimeParseException e) {
            throw new InvalidInputException("Please enter a valid date time format.");
        }
    }

    public static void deleteShowTime(int cinemaId, int showTimeId) throws InvalidIdException {
        if (cinemaId < 0 || cinemaId >= cinemaRepository.size())
            throw new InvalidIdException("Please enter a valid cinema id.");
        if (showTimeId < 0 || showTimeId >= movieRepository.size())
            throw new InvalidIdException("Please enter a valid showtime id.");

        Cinema cinema = cinemaRepository.get(cinemaId);
        cinema.getShowTime().remove(showTimeId);
        cinemaRepository.edit(cinemaId, cinema);
    }

    public static String getShowTimeDetail(int cinemaId, int showTimeId) throws InvalidIdException {
        if (cinemaId < 0 || cinemaId >= cinemaRepository.size())
            throw new InvalidIdException("Please enter a valid cinema id.");
        if (showTimeId < 0 || showTimeId >= movieRepository.size())
            throw new InvalidIdException("Please enter a valid showtime id.");

        Cinema cinema = cinemaRepository.get(cinemaId);
        ShowTime showtime = cinema.getShowTime().get(showTimeId);

        String output = MessageFormat.format("Movie Name: {0}\nDate Time: {1}", showtime.getMovie().getName(),
                getDateTimeFormat(showtime.getDateTime()));
        return output;
    }

    public static ShowTime getShowTime(int cinemaId, int showTimeId) throws InvalidIdException {
        if (cinemaId < 0 || cinemaId >= cinemaRepository.size())
            throw new InvalidIdException("Please enter a valid cinema id.");
        if (showTimeId < 0 || showTimeId >= movieRepository.size())
            throw new InvalidIdException("Please enter a valid showtime id.");

        return cinemaRepository.get(cinemaId).getShowTime().get(showTimeId);
    }

    public static String getDateTimeFormat(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ApplicationConstant.DATETIME_FORMAT);
        return dateTime.format(formatter).toString();
    }

    public static String getAvailableSeats(int cinemaId, int showTimeId) {
        Cinema cinema = cinemaRepository.get(cinemaId);
        ShowTime showTime = cinema.getShowTime().get(showTimeId);

        StringBuilder newString = new StringBuilder();
        char[][] seatLayout = cinema.getCinemaLayout();

        for (int i = 0; i < seatLayout.length; i++) {
            char row = seatLayout[i][0];
            int seatNo = 1;
            for (int j = 0; j < seatLayout[i].length; j++) {
                newString.append(getSeatTypeFormat(seatLayout[i][j], row, seatNo, showTime));
                if (seatLayout[i][j] == 1)
                    seatNo++;
            }
            newString.append("\n");
        }
        newString.append("* - Available Seat\n");
        newString.append("x - Reserved Seat");
        return newString.toString();
    }

    private static String getSeatTypeFormat(char c, char row, int seatNo, ShowTime showTime) {
        if (c == 1) {
            if (showTime.getSeatsTaken().contains(new StringBuilder().append(row).append(seatNo).toString()))
                return "|x|";
            else
                return "|*|";
        } else if (c == 0) {
            return "   ";
        } else {
            return new StringBuilder().append(c).toString();
        }
    }

    public static void reserveSeat(int cinemaId, int showTimeId, String seatNo) {
        Cinema cinema = cinemaRepository.get(cinemaId);
        ShowTime showTime = cinema.getShowTime().get(showTimeId);
        showTime.getSeatsTaken().add(seatNo);
    }

    public static boolean checkIfSeatAvailable(int cinemaId, int showTimeId, String seat) {
        Cinema cinema = cinemaRepository.get(cinemaId);
        ShowTime showTime = cinema.getShowTime().get(showTimeId);

        if (showTime.getSeatsTaken().contains(seat))
            return false;
        else {
            char[][] seatLayout = cinema.getCinemaLayout();
            int currentSeat = 0;
            for (int i = 0; i < seatLayout.length; i++) {
                if (seatLayout[i][0] == seat.charAt(0)) {
                    for (int j = 0; j < seatLayout[i].length; j++) {
                        if (seatLayout[i][j] == 1) {
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

    public static boolean checkIfFullyBooked(int cinemaId, int showTimeId) {
        Cinema cinema = cinemaRepository.get(cinemaId);
        ShowTime showTime = cinema.getShowTime().get(showTimeId);

        char[][] seatLayout = cinema.getCinemaLayout();
        int totalSeats = 0;
        for (int i = 0; i < seatLayout.length; i++) {
            for (int j = 0; j < seatLayout[i].length; j++) {
                if (seatLayout[i][j] == 1)
                    totalSeats += 1;
            }
        }
        return (totalSeats == showTime.getSeatsTaken().size()) ? true : false;
    }

}
