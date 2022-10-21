package Controller;

import java.text.MessageFormat;

import Constant.DataFileConstant;
import Constant.MovieRating;
import Constant.MovieStatus;
import Constant.MovieType;
import Entity.Movie;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Repository.MovieRepository;

public class MovieController {

    public static MovieRepository movieRepository = new MovieRepository(DataFileConstant.MOVIE_FILE);

    public static void addMovie(String name, String synopsis, String cast, String director,
            int movieType, int movieRating, int movieStatus) throws InvalidInputException {
        try {
            if (isValidInput(name, synopsis, cast, director, movieType, movieRating, movieStatus)) {
                Movie newMovie = new Movie(name, synopsis, director, cast, MovieType.values()[movieType],
                        MovieStatus.values()[movieStatus], MovieRating.values()[movieRating]);
                movieRepository.add(newMovie);
            }
        } catch (InvalidInputException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }

    public static void editMovie(int id, String name, String synopsis, String cast, String director,
            int movieType, int movieRating, int movieStatus) throws InvalidInputException {
        try {
            if (isValidInput(name, synopsis, cast, director, movieType, movieRating, movieStatus)) {
                Movie newMovie = new Movie(name, synopsis, director, cast, MovieType.values()[movieType],
                        MovieStatus.values()[movieStatus], MovieRating.values()[movieRating]);
                movieRepository.edit(id, newMovie);
            }
        } catch (InvalidInputException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }

    public static void deleteMovie(int id) throws InvalidIdException {
        if (id < 0 || id >= movieRepository.size())
            throw new InvalidIdException("Please enter a valid movie id.");
        else
            movieRepository.remove(id);
    }

    public static Movie getMovie(int id) {
        return movieRepository.get(id);
    }

    public static String getMovieDetails(int id) {
        if (id < 0 || id >= movieRepository.size()) return "Please enter a valid movie id.";
        Movie movie = movieRepository.get(id);
        StringBuilder output = new StringBuilder("");
        output.append("Movie Name: " + movie.getName() + "\n");
        output.append("Synopsis: " + movie.getSynopsis() + "\n");
        output.append("Cast " + movie.getCast() + "\n");
        output.append("Director: " + movie.getDirector() + "\n");
        output.append("Rating: " + movie.getRating() + "\n");
        output.append("Movie Type: " + movie.getMovieType() + "\n");
        output.append("Movie Rating: " + movie.getMovieRating() + "\n");
        output.append("Movie Status: " + movie.getMovieStatus());
        return output.toString();
    }

    public static String getMovieList() {
        if (movieRepository.size() < 1)
            return "No movies found";
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < movieRepository.size(); i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i + 1, movieRepository.get(i).getName()));
        }
        return output.substring(0, output.length() - 1).toString();
    }

    public static String getMovieListByStatus(int selection) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < movieRepository.size(); i++) {
            if (movieRepository.get(i).getMovieStatus() == MovieStatus.values()[selection - 1])
                output.append(MessageFormat.format("{0}: {1}\n", i + 1, movieRepository.get(i).getName()));
        }
        if (output.isEmpty())
            return "No movies found";
        else
            return output.substring(0, output.length() - 1).toString();
    }

    public static String getMovieListByRating(int selection) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < movieRepository.size(); i++) {
            if (movieRepository.get(i).getMovieRating() == MovieRating.values()[selection - 1])
                output.append(MessageFormat.format("{0}: {1}\n", i + 1, movieRepository.get(i).getName()));
        }
        if (output.isEmpty())
            return "No movies found";
        else
            return output.substring(0, output.length() - 1).toString();
    }

    public static String getMovieListByType(int selection) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < movieRepository.size(); i++) {
            if (movieRepository.get(i).getMovieType() == MovieType.values()[selection - 1])
                output.append(MessageFormat.format("{0}: {1}\n", i + 1, movieRepository.get(i).getName()));
        }
        if (output.isEmpty())
            return "No movies found";
        else
            return output.substring(0, output.length() - 1).toString();
    }

    public static String getMovieType() {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < MovieType.values().length; i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i + 1, MovieType.values()[i]));
        }
        return output.substring(0, output.length() - 1).toString();
    }

    public static String getMovieRating() {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < MovieRating.values().length; i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i + 1, MovieRating.values()[i]));
        }
        return output.substring(0, output.length() - 1).toString();
    }

    public static String getMovieStatus() {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < MovieStatus.values().length; i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i + 1, MovieStatus.values()[i]));
        }
        return output.substring(0, output.length() - 1).toString();
    }

    public static boolean isEmpty() {
        return movieRepository.size() < 1;
    }

    public static int size() {
        return movieRepository.size();
    }

    private static boolean isValidInput(String name, String synopsis, String cast, String director,
            int movieType, int movieRating, int movieStatus) throws InvalidInputException {
        if (name.isBlank())
            throw new InvalidInputException("Please enter a movie name.");
        if (synopsis.isBlank())
            throw new InvalidInputException("Please enter a synopsis.");
        if (cast.isBlank())
            throw new InvalidInputException("Please enter the cast.");
        if (director.isBlank())
            throw new InvalidInputException("Please enter the director.");
        if (movieType < 0 || movieType >= MovieType.values().length)
            throw new InvalidInputException("Please select a valid movie type.");
        if (movieRating < 0 || movieRating >= MovieRating.values().length)
            throw new InvalidInputException("Please select a valid movie rating.");
        if (movieStatus < 0 || movieStatus >= MovieStatus.values().length)
            throw new InvalidInputException("Please select a valid movie status.");

        return true;
    }

}
