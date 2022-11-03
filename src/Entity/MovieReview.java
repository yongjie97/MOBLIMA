package Entity;

import java.io.Serializable;

public class MovieReview implements Serializable {

    private String name;
    private String review;
    private double rating;

    public MovieReview(String name, String review, double rating) {
        this.name = name;
        this.review = review;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
