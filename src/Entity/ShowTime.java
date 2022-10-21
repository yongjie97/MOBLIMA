package Entity;

import java.time.LocalDateTime;
import java.util.HashSet;

public class ShowTime {

    private Cinema cinema;

    private Movie movie;

    private LocalDateTime dateTime;

    private HashSet<String> seatsTaken;

    public ShowTime(Cinema cinema, Movie movie, LocalDateTime dateTime) {
        this.cinema = cinema;
        this.movie = movie;
        this.dateTime = dateTime;
        seatsTaken = new HashSet<>();
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
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
