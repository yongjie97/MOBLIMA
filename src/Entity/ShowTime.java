package Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;

public class ShowTime implements Serializable {

    private int movieId;

    private LocalDateTime dateTime;

    private HashSet<String> seatsTaken;

    public ShowTime(int movieId, LocalDateTime dateTime) {
        this.movieId = movieId;
        this.dateTime = dateTime;
        seatsTaken = new HashSet<>();
    }

    public HashSet<String> getSeatsTaken() {
        return seatsTaken;
    }

    public void setSeatsTaken(HashSet<String> seatTaken) {
        this.seatsTaken = seatTaken;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    
}
