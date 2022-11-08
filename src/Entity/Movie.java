package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Class that contains information about movies in the application
 * 
 *
 */
public class Movie implements Serializable {
	/**
	 * Declaration of variables for movie class
	 */
    private String name;

    private String synopsis;

    private String director;

    private String cast;

    private double rating;

    private MovieType movieType;

    private MovieStatus movieStatus;
    
    private MovieRating movieRating;

    private List<MovieReview> movieReviews;
    /**
     * Constructor for movie
     * @param name -  name of movie
     * @param synopsis - synopsis of movie
     * @param director - director of movie
     * @param cast - cast of movie
     * @param movieType - type of movie
     * @param movieStatus - status of movie
     * @param movieRating -  rating of movie
     */
    public Movie(String name, String synopsis, String director, String cast,
            MovieType movieType, MovieStatus movieStatus, MovieRating movieRating) {
        this.name = name;
        this.synopsis = synopsis;
        this.director = director;
        this.cast = cast;
        this.movieType = movieType;
        this.movieStatus = movieStatus;
        this.movieRating = movieRating;
        this.rating = 0;
        movieReviews = new ArrayList<>();
    }
    /**
     * Method to get name of movie
     * @return name of movie
     */
    public String getName() {
        return name;
    }
    /**
     * Method to set name of movie
     * @param name - String 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method to get synopsis of movie
     * @return synopsis of movie
     */
    public String getSynopsis() {
        return synopsis;
    }
    /**
     * Method to set synopsis of movie
     * @param synopsis - String 
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    /**
     * Method to get director of movie
     * @return director of movie 
     */
    public String getDirector() {
        return director;
    }
    /**
     * Method to set director of movie
     * @param director - String 
     */
    public void setDirector(String director) {
        this.director = director;
    }
    /**
     * Method to get cast of movie
     * @return cast of movie 
     */
    public String getCast() {
        return cast;
    }
    /**
     * Method to set cast of movie
     * @param cast - String 
     */
    public void setCast(String cast) {
        this.cast = cast;
    }
    /**
     * Method to get rating of movie
     * @return rating of movie 
     */
    public double getRating() {
        return rating;
    }
    /**
     * Method to set rating of movie
     * @param rating - double 
     */
    public void setRating(double rating) {
        this.rating = rating;
    }
    /**
     * Method to get type of movie
     * @return type of movie 
     */
    public MovieType getMovieType() {
        return movieType;
    }
    /**
     * Method to set type of movie
     * @param movieType - MovieType
     */
    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }
    /**
     * Method to get status of movie
     * @return status of movie 
     */
    public MovieStatus getMovieStatus() {
        return movieStatus;
    }
    /**
     * Method to set status of movie
     * @param movieStatus - MovieStatus
     */
    public void setMovieStatus(MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }
    /**
     * Method to get rating of movie
     * @return rating of movie
     */
    public MovieRating getMovieRating() {
        return movieRating;
    }
    /**
     * Method to set rating of movie
     * @param movieRating - MovieRating
     */
    public void setMovieRating(MovieRating movieRating) {
        this.movieRating = movieRating;
    }
    /**
     * Method to get movie reviews
     * @return movie reviews
     */
    public List<MovieReview> getMovieReviews() {
        return movieReviews;
    }
    /**
     * Method to set movie reviews
     * @param movieReviews = List<MovieReview>
     */
    public void setMovieReviews(List<MovieReview> movieReviews) {
        this.movieReviews = movieReviews;
    }
    
}
