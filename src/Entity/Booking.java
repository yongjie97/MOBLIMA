package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Booking implements Serializable {

    private String transactionID; 
    private String name;
    private String email;
    private String mobile;
    private List<String> seats;
    private int movieId;
    private int cineplexId;
    private int cinemaId;
    private int showTimeId;
    private LocalDateTime bookingTime;
    private BigDecimal totalPrice;
    private int age;

    public Booking(String transactionID, String name, String email, String mobile, List<String> seats, int movieId,
            int cineplexId, int cinemaId, int showTimeId, LocalDateTime bookingTime, BigDecimal totalPrice) {
        this.transactionID = transactionID;
        this.name = name;
        this.email = email;
        this.email = email;
        this.mobile = mobile;
        this.seats = seats;
        this.movieId = movieId;
        this.cineplexId = cineplexId;
        this.cinemaId = cinemaId;
        this.showTimeId = showTimeId;
        this.bookingTime = bookingTime;
        this.totalPrice = totalPrice;
    }

    public String getTransactionID() {
        return transactionID;
    }
    
    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCineplexId() {
        return cineplexId;
    }

    public void setCineplexId(int cineplexId) {
        this.cineplexId = cineplexId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getShowTimeId() {
        return showTimeId;
    }

    public void setShowTimeId(int showTimeId) {
        this.showTimeId = showTimeId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

	public void setAge(int age) {
		this.age = age;
		
	}
	
	public int getAge() {
		return age;
	}

}
