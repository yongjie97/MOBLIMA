package Controller;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import Constant.DataFileConstant;
import Entity.Movie;
import Entity.MovieReview;
import Entity.MovieStatus;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Repository.MovieRepository;
/**
 * The logic and functions for Movie
 */
public class MovieReviewController {
	/**
	 * Stored details of movie
	 */
    private static MovieRepository movieRepository = new MovieRepository(DataFileConstant.MOVIE_FILE);
    /**
     * Adds a review to the review list in the movie object
     * 
     * @param movieId						Id of movie
     * @param name							Name of reviewer
     * @param review						Review
     * @param rating						Rating
     * @throws InvalidIdException			If an id input
     * 										exception occurs
     * @throws InvalidInputException		If an input
     * 										exception occurs
     */
    public static void addReview(int movieId, String name, String review, double rating)
            throws InvalidIdException, InvalidInputException {
        movieId = normaliseId(movieId);
        if (movieId < 0 || movieId >= MovieController.movieRepository.size())
            throw new InvalidIdException("Please enter a valid movie id.");
        if (!isValidInput(name, review, rating))
            throw new InvalidInputException("Please enter a valid input.");

        MovieReview movieReview = new MovieReview(name, review, rating);
        Movie movie = movieRepository.get(movieId);
        movie.getMovieReviews().add(movieReview);
        movie.setRating(calculateRating(movie));
        movieRepository.edit(movieId, movie);
    }
    /**
     * Calculates the new value of rating and returns the average
     * 
     * @param movie			Movie object
     * @return				Average rating
     */
    private static double calculateRating(Movie movie) {
        if (movie.getMovieReviews().isEmpty())
            return 0;

        double totalRating = 0;
        for (MovieReview review : movie.getMovieReviews()) {
            totalRating += review.getRating();
        }
        return totalRating / movie.getMovieReviews().size();
    }
    /**
     * Get the list of movie reviews and returns them as a string
     * 
     * @param movieId					Id of movie
     * @return							String of list of reviews
     * @throws EmptyListException		If an empty list
     * 									exception occurs
     * @throws InvalidIdException		If an id input
     * 									exception occurs
     */
    public static String listMovieReviews(int movieId) throws EmptyListException, InvalidIdException {
        movieId = normaliseId(movieId);
        if (movieId < 0 || movieId >= MovieController.movieRepository.size())
            throw new InvalidIdException("Please enter a valid movie id.");

        Movie movie = movieRepository.get(movieId);
        if (movie.getMovieReviews().isEmpty())
            throw new EmptyListException("No reviews found.");

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < movie.getMovieReviews().size(); i++) {
            output.append(MessageFormat.format("Name: {0}\n", movie.getMovieReviews().get(i).getName()));
            output.append(MessageFormat.format("Rating: {0,number,#.##}\n", movie.getMovieReviews().get(i).getRating()));
            output.append(MessageFormat.format("Review: {0}\n\n", movie.getMovieReviews().get(i).getReview()));
        }
        return output.substring(0, output.length() - 2).toString();
    }
    /**
     * Sorts the movie based on rating in desending order
     * 
     * @return							Sorted list of movies
     * @throws EmptyListException		If an empty list
     * 									exception occurs
     */
    public static String listByRating() throws EmptyListException {
        List<Movie> movies = movieRepository.getAll();
        if (movies.isEmpty())
            throw new EmptyListException("No available movies found.");

        List<Movie> highestRated = new ArrayList<>();
        Comparator<Movie> ratingSorter = Comparator.comparing(Movie::getRating);
        PriorityQueue<Movie> maxHeap = new PriorityQueue<Movie>(ratingSorter.reversed());
        for (int i = 0; i < MovieController.size(); i++) {
            if (movies.get(i).getMovieStatus() != MovieStatus.FINISHED)
            if (movies.get(i).getRating() != 0)
                maxHeap.add(movies.get(i));
        }

        for (int i = 0; i < 5; i++) {
            if (maxHeap.isEmpty())
                break;
            highestRated.add(i, maxHeap.poll());
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (i < highestRated.size()) {
                output.append(MessageFormat.format("{0}: {1} - {2,number,#.#}/5\n", i+1, highestRated.get(i).getName(), highestRated.get(i).getRating()));
            } else {
                output.append(MessageFormat.format("{0}: N/A\n", i+1));
            }
        }
        return output.substring(0, output.length() - 1).toString();
    }
    /**
     * Checks if input is valid
     * 
     * @param name						Name
     * @param review					Review
     * @param rating					Rating
     * @return							Exception/true
     * @throws InvalidInputException	If an input
     * 									exception occurs
     */
    private static boolean isValidInput(String name, String review, double rating) throws InvalidInputException {
        if (name.isBlank())
            throw new InvalidInputException("Please enter a name.");
        if (review.isBlank())
            throw new InvalidInputException("Please enter a review.");
        if (rating < 1 || rating > 5)
            throw new InvalidInputException("Please select a valid movie rating.");

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
