package Controller;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import Constant.ApplicationConstant;
import Constant.DataFileConstant;
import Entity.Cinema;
import Entity.Cineplex;
import Entity.Movie;
import Entity.ShowTime;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Repository.CineplexRepository;
import Repository.MovieRepository;

public class ShowTimeController {

    private static CineplexRepository cineplexRepository = new CineplexRepository(DataFileConstant.CINEPLEX_FILE);
    private static MovieRepository movieRepository = new MovieRepository(DataFileConstant.MOVIE_FILE);

    public static void addShowTime(int cineplexId, int cinemaId, int movieId, String dateTime)
            throws InvalidIdException, InvalidInputException {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);
        movieId = normaliseId(movieId);

        if (cineplexId < 0 || cineplexId > cineplexRepository.size())
            throw new InvalidIdException("Please enter a valid cineplex id.");

        Cineplex cineplex = cineplexRepository.get(cineplexId);
        if (cinemaId < 0 || cinemaId >= cineplex.getCinemas().size())
            throw new InvalidIdException("Please enter a valid cinema id.");

        if (movieId < 0 || movieId >= movieRepository.size())
            throw new InvalidIdException("Please enter a valid movie id.");

        try {
            LocalDateTime formattedDateTime = LocalDateTime.parse(dateTime,
                    DateTimeFormatter.ofPattern(ApplicationConstant.DATETIME_FORMAT));
            Cinema cinema = cineplex.getCinemas().get(cinemaId);
            Movie movie = movieRepository.get(movieId);
            ShowTime newShowTime = new ShowTime(movie, formattedDateTime);
            cinema.getShowTime().add(newShowTime);
            cineplexRepository.edit(cineplexId, cineplex);
        } catch (Exception e) {
            throw new InvalidInputException("Please enter a valid date time format.");
        }
    }

    public static void editShowTimeMovie(int cineplexId, int cinemaId, int showTimeId, int movieId)
            throws InvalidIdException {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);
        movieId = normaliseId(movieId);
        showTimeId = normaliseId(showTimeId);

        if (cineplexId < 0 || cineplexId > cineplexRepository.size())
            throw new InvalidIdException("Please enter a valid cineplex id.");

        Cineplex cineplex = cineplexRepository.get(cineplexId);
        if (cinemaId < 0 || cinemaId >= cineplex.getCinemas().size())
            throw new InvalidIdException("Please enter a valid cinema id.");

        Cinema cinema = cineplex.getCinemas().get(cinemaId);
        if (showTimeId < 0 || showTimeId >= cinema.getShowTime().size())
            throw new InvalidIdException("Please enter a valid showtime id.");

        if (movieId < 0 || movieId >= movieRepository.size())
            throw new InvalidIdException("Please enter a valid movie id.");

        Movie movie = movieRepository.get(movieId);
        ShowTime oldShowTime = cinema.getShowTime().get(showTimeId);
        ShowTime newShowTime = new ShowTime(movie, oldShowTime.getDateTime());
        cinema.getShowTime().set(showTimeId, newShowTime);
        cineplexRepository.edit(cinemaId, cineplex);
    }

    public static void editShowTimeDateTime(int cineplexId, int cinemaId, int showTimeId, String dateTime)
            throws InvalidIdException, InvalidInputException {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);
        showTimeId = normaliseId(showTimeId);

        if (cineplexId < 0 || cineplexId > cineplexRepository.size())
            throw new InvalidIdException("Please enter a valid cineplex id.");

        Cineplex cineplex = cineplexRepository.get(cineplexId);
        if (cinemaId < 0 || cinemaId >= cineplex.getCinemas().size())
            throw new InvalidIdException("Please enter a valid cinema id.");

        Cinema cinema = cineplex.getCinemas().get(cinemaId);
        if (showTimeId < 0 || showTimeId >= cinema.getShowTime().size())
            throw new InvalidIdException("Please enter a valid showtime id.");

        try {
            LocalDateTime formattedDateTime = LocalDateTime.parse(dateTime,
                    DateTimeFormatter.ofPattern(ApplicationConstant.DATETIME_FORMAT));
            ShowTime oldShowTime = cinema.getShowTime().get(showTimeId);
            ShowTime newShowTime = new ShowTime(oldShowTime.getMovie(), formattedDateTime);
            cinema.getShowTime().set(showTimeId, newShowTime);
            cineplexRepository.edit(cinemaId, cineplex);
        } catch (DateTimeParseException e) {
            throw new InvalidInputException("Please enter a valid date time format.");
        }
    }

    public static void deleteShowTime(int cineplexId, int cinemaId, int showTimeId) throws InvalidIdException {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);
        showTimeId = normaliseId(showTimeId);

        if (cineplexId < 0 || cineplexId > cineplexRepository.size())
            throw new InvalidIdException("Please enter a valid cineplex id.");

        Cineplex cineplex = cineplexRepository.get(cineplexId);
        if (cinemaId < 0 || cinemaId >= cineplex.getCinemas().size())
            throw new InvalidIdException("Please enter a valid cinema id.");

        Cinema cinema = cineplex.getCinemas().get(cinemaId);
        if (showTimeId < 0 || showTimeId >= cinema.getShowTime().size())
            throw new InvalidIdException("Please enter a valid showtime id.");

        cinema.getShowTime().remove(showTimeId);
        cineplexRepository.edit(cinemaId, cineplex);
    }

    public static boolean hasShowTime(int cineplexId, int cinemaId) {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);
        
        return cineplexRepository.get(cineplexId).getCinemas().get(cinemaId).getShowTime().size() > 0;
    }

    public static String listShowTimeDetail(int cineplexId, int cinemaId, int showTimeId) throws InvalidIdException {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);
        showTimeId = normaliseId(showTimeId);

        if (cineplexId < 0 || cineplexId > cineplexRepository.size())
            throw new InvalidIdException("Please enter a valid cineplex id.");

        Cineplex cineplex = cineplexRepository.get(cineplexId);
        if (cinemaId < 0 || cinemaId >= cineplex.getCinemas().size())
            throw new InvalidIdException("Please enter a valid cinema id.");

        Cinema cinema = cineplex.getCinemas().get(cinemaId);
        if (showTimeId < 0 || showTimeId >= cinema.getShowTime().size())
            throw new InvalidIdException("Please enter a valid showtime id.");

        ShowTime showtime = cinema.getShowTime().get(showTimeId);
        String output = MessageFormat.format("Movie Name: {0}\nDate Time: {1}", showtime.getMovie().getName(),
                getDateTimeFormat(showtime.getDateTime()));
        return output;
    }

    public static String listShowTime(int cineplexId, int cinemaId) throws InvalidIdException, EmptyListException {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);
        if (cineplexId < 0 || cineplexId > cineplexRepository.size())
            throw new InvalidIdException("Please enter a valid cineplex id.");

        Cineplex cineplex = cineplexRepository.get(cineplexId);
        if (cinemaId < 0 || cinemaId >= cineplex.getCinemas().size())
            throw new InvalidIdException("Please enter a valid cinema id.");

        Cinema cinema = cineplex.getCinemas().get(cinemaId);
        if (cinema.getShowTime().isEmpty())
            throw new EmptyListException("No showtime found.");

        List<ShowTime> showTime = cinema.getShowTime();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < showTime.size(); i++) {
            output.append(MessageFormat.format("{0}: {1} | {2}\n", i + 1, showTime.get(i).getMovie().getName(),
                    getDateTimeFormat(showTime.get(i).getDateTime())));
        }
        return output.substring(0, output.length() - 1).toString();

    }

    public static ShowTime getShowTime(int cineplexId, int cinemaId, int showTimeId) throws InvalidIdException {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);
        showTimeId = normaliseId(showTimeId);

        if (cineplexId < 0 || cineplexId > cineplexRepository.size())
            throw new InvalidIdException("Please enter a valid cineplex id.");

        Cineplex cineplex = cineplexRepository.get(cineplexId);
        if (cinemaId < 0 || cinemaId >= cineplex.getCinemas().size())
            throw new InvalidIdException("Please enter a valid cinema id.");

        Cinema cinema = cineplex.getCinemas().get(cinemaId);
        if (showTimeId < 0 || showTimeId >= cinema.getShowTime().size())
            throw new InvalidIdException("Please enter a valid showtime id.");

        return cinema.getShowTime().get(showTimeId);
    }

    public static String getDateTimeFormat(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ApplicationConstant.DATETIME_FORMAT);
        return dateTime.format(formatter).toString();
    }

    public static String getAvailableSeats(int cineplexId, int cinemaId, int showTimeId) throws InvalidIdException {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);
        showTimeId = normaliseId(showTimeId);

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

    public static void reserveSeat(int cineplexId, int cinemaId, int showTimeId, String seatNo) {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);
        showTimeId = normaliseId(showTimeId);

        Cineplex cineplex = cineplexRepository.get(cineplexId);
        Cinema cinema = cineplex.getCinemas().get(cinemaId);
        ShowTime showTime = cinema.getShowTime().get(showTimeId);
        showTime.getSeatsTaken().add(seatNo);
    }

    public static boolean checkIfSeatAvailable(int cineplexId, int cinemaId, int showTimeId, String seat) {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);
        showTimeId = normaliseId(showTimeId);

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

    public static boolean checkIfFullyBooked(int cineplexId, int cinemaId, int showTimeId) {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);
        showTimeId = normaliseId(showTimeId);

        Cineplex cineplex = cineplexRepository.get(cineplexId);
        Cinema cinema = cineplex.getCinemas().get(cinemaId);
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

    public static int normaliseId(int id) {
        return id - 1;
    }
}
