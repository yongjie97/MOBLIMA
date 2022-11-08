package Entity;

import java.io.Serializable;
/**
 * Class that contains the relevant information about review of movies in the application
 * 
 *
 */
public class MovieReview implements Serializable {
	/**
	 *  Declaration of variables for movie review class
	 */
    private String name;
    private String review;
    private double rating;
    /**
     * Constructor for movie review
     * @param name - name of movie review 
     * @param review - comments about the movie
     * @param rating -  rating of the movie
     */
    public MovieReview(String name, String review, double rating) {
        this.name = name;
        this.review = review;
        this.rating = rating;
    }
    /**
     * Method to get name of movie review 
     * @return name of movie review
     */
    public String getName() {
        return name;
    }
    /**
     * Method to set name of movie review
     * @param name - String 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method to get review of movie
     * @return review of movie
     */
    public String getReview() {
        return this.review;
    }
    /**
     * Method to set review of movie
     * @param review - String 
     */
    public void setReview(String review) {
        this.review = review;
    }
    /**
     * Method to get rating of movie
     * @return rating of movie
     */
    public double getRating() {
        return this.rating;
    }
    /**
     * Method to set rating of movie
     * @param rating - rating of movie
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

}
