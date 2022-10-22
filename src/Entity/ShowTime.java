package Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;

public class ShowTime implements Serializable {

    private Movie movie;

    private LocalDateTime dateTime;

    private HashSet<String> seatsTaken;

    public ShowTime(Movie movie, LocalDateTime dateTime) {
        this.movie = movie;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
}
