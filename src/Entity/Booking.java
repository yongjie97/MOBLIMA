package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
/**
 * Class for booking that contains the relevant details needed for booking in the application
 * 
 *
 */
public class Booking implements Serializable {
	/**
	 * Declarations of variables for booking class
	 */
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
    /**
     * Constructor for booking 
     * @param transactionID - cinema code + date and time of booking 
     * @param name - name of customer
     * @param email - email address of customer
     * @param mobile -  mobile number of customer
     * @param seats -  seats chosen by customer
     * @param movieId - movie ID of the movie chosen
     * @param cineplexId - ID of the cineplex booked
     * @param cinemaId -  ID of the cinema booked
     * @param showTimeId - ID of show time booked
     * @param bookingTime -  Time of booking
     * @param totalPrice - Total price of booking
     */
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
    /**
     * Method to get transaction ID
     * @return ID of transaction
     */
    public String getTransactionID() {
        return transactionID;
    }
   /**
    * Method to set transaction ID 
    * @param transactionID - string
    */
    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }
    /**
     * Method to get customer name 
     * @return name of customer
     */
    public String getName() {
        return name;
    }
    /**
     * Method to set customer  name
     * @param name - string 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method to get Email
     * @return email address of customer
     */
    public String getEmail() {
        return email;
    }
    /**
     * Method to get booking time
     * @return booking time of transaction 
     */
    public LocalDateTime getBookingTime() {
        return bookingTime;
    }
    /**
     * Method to set booking time
     * @param bookingTime - LocalDateTime
     */
    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
    /**
     * Method to set email
     * @param email - String
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Method to get seats
     * @return seats booked
     */
    public List<String> getSeats() {
        return seats;
    }
    /**
     * Method to set seats
     * @param seats - List<String>
     */
    public void setSeats(List<String> seats) {
        this.seats = seats;
    }
    /**
     * Method to get mobile number 
     * @return mobile number of customer
     */
    public String getMobile() {
        return mobile;
    }
    /**
     * Method to set mobile number
     * @param mobile - String 
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /**
     * Method to get movieID
     * @return ID of movie booked
     */
    public int getMovieId() {
        return movieId;
    }
    /**
     * Method to set movieID
     * @param movieID - integer
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    /**
     * Method to get cineplexID
     * @return ID of cineplex
     */
    public int getCineplexId() {
        return cineplexId;
    }
    /**
     * Method to set cineplexID
     * @param cineplexId integer
     */
    public void setCineplexId(int cineplexId) {
        this.cineplexId = cineplexId;
    }
    /**
     * Method to get cinemaID
     * @return ID of cinema booked
     */
    public int getCinemaId() {
        return cinemaId;
    }
    /**
     * Method to set cinemaID
     * @param cinemaId - integer
     */
    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }
    /**
     * Method to get showtimeID
     * @return ID of show time booked
     */
    public int getShowTimeId() {
        return showTimeId;
    }
    /**
     * Method to set showtimeID
     * @param ShowTimeId - integer
     */
    public void setShowTimeId(int showTimeId) {
        this.showTimeId = showTimeId;
    }
    /**
     * Method to get total price
     * @return total price of booking
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    /**
     * Method to set total price
     * @param totalPrice - BigDecimal
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    /**
     * Method to set age of customer
     * @param age - integer
     */
	public void setAge(int age) {
		this.age = age;
		
	}
	/**
	 * Method to get age of customer
	 * @return age of customer
	 */
	public int getAge() {
		return age;
	}

}
