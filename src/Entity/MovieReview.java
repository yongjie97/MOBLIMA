package Entity;

import java.io.Serializable;

public class MovieReview implements Serializable {

    private String review;
    private double rating;
    // private User name;

    public MovieReview(String review, double rating) {
        this.review = review;
        this.rating = rating;
    }

    public String getReview() {
        return this.review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

}
