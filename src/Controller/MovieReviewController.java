package Controller;

import java.util.ArrayList;
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

public class MovieReviewController {
	
	
	
	public static void addReview(int id, String name, String review, double rating) throws InvalidIdException, InvalidInputException {
		if (id < 0 || id >= MovieController.movieRepository.size())
			throw new InvalidIdException("Please enter a valid movie id.");
		try {
			if (isValidInput(review, rating)) {
				MovieReview newReview = new MovieReview(name, review, rating);
				Movie movie =MovieController.getMovie(id);
			    movie.getMovieReview().add(newReview);
			    double size = movie.getMovieReview().size();
			    double newRating = (((size-1)*movie.getRating())+rating)/size;
			    movie.setRating(newRating);
			    MovieController.movieRepository.edit(id,movie);
			}
		} catch (InvalidInputException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
    
    public static List<MovieReview> getMovieReviewList(int id) throws EmptyListException, InvalidIdException {
    	if (id < 0 || id >= MovieController.movieRepository.size())
			throw new InvalidIdException("Please enter a valid movie id.");
   
        if (MovieController.getMovie(id).getMovieReview().isEmpty())
            throw new EmptyListException("No reviews found.");
        return MovieController.getMovie(id).getMovieReview();
    }



	private static boolean isValidInput(String name, double movieRating) throws InvalidInputException {
		if (name.isBlank())
			throw new InvalidInputException("Please enter a review.");
		if (movieRating < 0 || movieRating >= MovieRating.values().length)
			throw new InvalidInputException("Please select a valid movie rating.");

		return true;
	}

}
