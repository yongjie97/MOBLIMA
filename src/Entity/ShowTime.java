package Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
/**
 * Class that contains the required information about show times of movies in the application
 * 
 *
 */
public class ShowTime implements Serializable {
	/**
	 *  Declaration of variables for show time class
	 */
    private int movieId;

    private LocalDateTime dateTime;

    private HashSet<String> seatsTaken;
    /**
     * Constructor for show time 
     * @param movieId - ID of movies
     * @param dateTime - timings of movies
     */
    public ShowTime(int movieId, LocalDateTime dateTime) {
        this.movieId = movieId;
        this.dateTime = dateTime;
        seatsTaken = new HashSet<>();
    }
    /**
     * Method to get seats taken 
     * @return information of seats taken
     */
    public HashSet<String> getSeatsTaken() {
        return seatsTaken;
    }
    /**
     * Method to set seats taken
     * @param seatTaken - HashSet<String>
     */
    public void setSeatsTaken(HashSet<String> seatTaken) {
        this.seatsTaken = seatTaken;
    }
    /**
     * Method to get show time
     * @return timings of movies
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    /**
     * Method to set show time
     * @param dateTime - LocalDateTime
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    /**
     * Method to get movie ID
     * @return ID of movies
     */
    public int getMovieId() {
        return movieId;
    }
    /**
     * Method to set movie ID
     * @param movieId -  integer
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    
}
