package Controller;

import java.util.HashMap;
import java.util.List;

import Constant.DataFileConstant;
import Entity.Movie;
import Entity.MovieRating;
import Entity.MovieStatus;
import Entity.MovieType;
import Exception.EmptyListException;
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
            int movieType, int movieRating, int movieStatus) throws InvalidIdException, InvalidInputException {    
        if (id < 0 || id >= movieRepository.size())
            throw new InvalidIdException("Please enter a valid movie id.");
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

    public static Movie getMovie(int id) throws InvalidIdException {
        if (id < 0 || id >= movieRepository.size())
            throw new InvalidIdException("Please enter a valid movie id.");

        return movieRepository.get(id);
    }

    public static List<Movie> getMovieList() throws EmptyListException {
        if (movieRepository.isEmpty())
            throw new EmptyListException("No movies found.");
        return movieRepository.getAll();
    }

    public static HashMap<Integer, Movie> getAvailableMovieList() throws EmptyListException {

        List<Movie> movies = movieRepository.getAll();   
        if (movies.isEmpty())     
            throw new EmptyListException("No available movies found.");

        HashMap<Integer, Movie> list = new HashMap<>(); 
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getMovieStatus() != MovieStatus.FINISHED)
                list.put(i, movies.get(i));
        }

        return list;
    }    
    
    public static boolean isEmpty() {
        return movieRepository.isEmpty();
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


    /*public static String getAvailableMovies() {
        List<Movie> movies = movieRepository.getAll();
        movies.removeIf(x -> x.getMovieStatus().equals(MovieStatus.FINISHED));
        if (movies.size() < 1)
            return "No movies found";
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < movies.size(); i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i + 1, movies.get(i).getName()));
        }
        return output.substring(0, output.length() - 1).toString();
    }*/

}
