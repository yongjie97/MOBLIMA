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
/**
 * The logic and functions for Movie
 */
public class MovieController {
	/**
	 * Stored details of cineplex
	 */
    public static MovieRepository movieRepository = new MovieRepository(DataFileConstant.MOVIE_FILE);
    /**
     * Adds a movie to the movie repository	
     * 
     * @param name							Name of movie
     * @param synopsis						Synopsis of movie
     * @param cast							Cast of movie
     * @param director						Director of movie
     * @param movieType						Movie Type
     * @param movieRating					Movie Rating
     * @param movieStatus					Movie Status
     * @throws InvalidInputException		If an id input
     * 										exception occurs
     */
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
    /**
     * Edits the movie in the repository
     * 
     * @param id						Id of movie
     * @param name						Name of movie
     * @param synopsis					Synopsis of movie
     * @param cast						Cast of movie
     * @param director					Director of movie
     * @param movieType					Movie Type
     * @param movieRating				Movie Rating
     * @param movieStatus				Movie Status
     * @throws InvalidIdException		If an id input
     * 									exception occurs
     * @throws InvalidInputException	If an input
     * 									exception occurs
     */
    public static void editMovie(int id, String name, String synopsis, String cast, String director,
            int movieType, int movieRating, int movieStatus) throws InvalidIdException, InvalidInputException {
        id = normaliseId(id);
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
    /**
     * Deletes a movie in the repository
     * 
     * @param id						Id of movie
     * @throws InvalidIdException		If an id input
     * 									exception occurs
     */
    public static void deleteMovie(int id) throws InvalidIdException {
        id = normaliseId(id);
        if (id < 0 || id >= movieRepository.size())
            throw new InvalidIdException("Please enter a valid movie id.");

        Movie movie = movieRepository.get(id);
        movie.setMovieStatus(MovieStatus.FINISHED);
        movieRepository.edit(id, movie);
    }
    /**
     * Gets movie from the repository from chosen id
     * 
     * @param id						Id of movie
     * @return							Movie object
     * @throws InvalidIdException		If an id input
     * 									exception occurs
     */
    public static Movie getMovie(int id) throws InvalidIdException {
        id = normaliseId(id);
        if (id < 0 || id >= movieRepository.size())
            throw new InvalidIdException("Please enter a valid movie id.");

        return movieRepository.get(id);
    }
    /**
     * Gets the list of movies
     * 
     * @return							List of movie
     * @throws EmptyListException		If an empty list
     * 									exception occurs
     */
    public static List<Movie> getMovieList() throws EmptyListException {
        if (movieRepository.isEmpty())
            throw new EmptyListException("No movies found.");
        return movieRepository.getAll();
    }
    /**
     * Gets list of movies that are still airing
     * 
     * @return							HashMap of movie
     * @throws EmptyListException		If an empty list
     * 									exception occurs
     */
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
    /**
     * Checks if movie repository is empty
     * 
     * @return		true/false
     */
    public static boolean isEmpty() {
        return movieRepository.isEmpty();
    }
    /**
     * Gets size of list of movies in the repository
     * 
     * @return		int of size of list
     */
    public static int size() {
        return movieRepository.size();
    }
    /**
     * Checks if an input is valid
     * 
     * @param name						Name
     * @param synopsis					Synopsis
     * @param cast						Cast
     * @param director					Director
     * @param movieType					Movie Type
     * @param movieRating				Movie Rating
     * @param movieStatus				Movie Status
     * @return							Exception/true
     * @throws InvalidInputException	If an input
     * 									exception occurs
     */
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
    /**
     * Normalises id
     * 
     * @param id	Id
     * @return		Normalised id
     */
    public static int normaliseId(int id) {
        return id - 1;
    }

}
