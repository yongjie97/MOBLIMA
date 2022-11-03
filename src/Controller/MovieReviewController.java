package Controller;

import java.text.MessageFormat;

import Constant.DataFileConstant;
import Entity.Movie;
import Entity.MovieReview;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Repository.MovieRepository;

public class MovieReviewController {

    private static MovieRepository movieRepository = new MovieRepository(DataFileConstant.MOVIE_FILE);

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

    private static double calculateRating(Movie movie) {
        if (movie.getMovieReviews().isEmpty())
            return 0;

        double totalRating = 0;
        for (MovieReview review : movie.getMovieReviews()) {
            totalRating += review.getRating();
        }
        return totalRating / movie.getMovieReviews().size();
    }

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

    private static boolean isValidInput(String name, String review, double rating) throws InvalidInputException {
        if (name.isBlank())
            throw new InvalidInputException("Please enter a name.");
        if (review.isBlank())
            throw new InvalidInputException("Please enter a review.");
        if (rating < 1 || rating > 5)
            throw new InvalidInputException("Please select a valid movie rating.");

        return true;
    }

    public static int normaliseId(int id) {
        return id - 1;
    }

}
