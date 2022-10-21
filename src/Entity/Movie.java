package Entity;

import java.io.Serializable;
import java.util.List;

import Constant.MovieRating;
import Constant.MovieStatus;
import Constant.MovieType;

public class Movie implements Serializable {

    private String name;

    private String synopsis;

    private String director;

    private String cast;

    private double rating;

    private MovieType movieType;

    private MovieStatus movieStatus;
    
    private MovieRating movieRating;

    //private List<Review> reviews;

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
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public MovieStatus getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }

    public MovieRating getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(MovieRating movieRating) {
        this.movieRating = movieRating;
    }
    
}
