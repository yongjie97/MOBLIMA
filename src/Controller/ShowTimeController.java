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
            ShowTime newShowTime = new ShowTime(movieId, formattedDateTime);
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

        ShowTime oldShowTime = cinema.getShowTime().get(showTimeId);
        ShowTime newShowTime = new ShowTime(movieId, oldShowTime.getDateTime());
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
            ShowTime newShowTime = new ShowTime(oldShowTime.getMovieId(), formattedDateTime);
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
        cineplexRepository.edit(cineplexId, cineplex);
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
        Movie movie = movieRepository.get(showtime.getMovieId());
        String output = MessageFormat.format("Movie Name: {0}\nDate Time: {1}", movie.getName(),
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
            Movie movie = movieRepository.get(showTime.get(i).getMovieId());
            output.append(MessageFormat.format("{0}: {1} | {2}\n", i + 1, movie.getName(),
                    getDateTimeFormat(showTime.get(i).getDateTime())));
        }
        return output.substring(0, output.length() - 1).toString();
    }

    public static String listAvailableShowTime(int cineplexId, int cinemaId) throws InvalidIdException, EmptyListException {
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
            if (showTime.get(i).getDateTime().isAfter(LocalDateTime.now())) {
                Movie movie = movieRepository.get(showTime.get(i).getMovieId());
                output.append(MessageFormat.format("{0}: {1} | {2}\n", i + 1, movie.getName(),
                        getDateTimeFormat(showTime.get(i).getDateTime())));
            }
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

    public static int normaliseId(int id) {
        return id - 1;
    }
}
