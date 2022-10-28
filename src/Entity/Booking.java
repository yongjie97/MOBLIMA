package Entity;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Booking implements Serializable{
	private Customer customer;
	private Movie movie;
	private ShowTime time;
	private int seatno;
	private double price;
	private String cinemaname;
	private int transID;
	public Booking(Customer customer, Movie movie, ShowTime time, int seatno, double price, int transID, String cinemaname) {
		this.customer = customer;
		this.time = time;
		this.movie = movie;
		this.seatno = seatno;
		this.price = price;
		this.transID = transID;
		this.cinemaname = cinemaname;
	}
	
	public String getName() {
		return customer.getName();
	}
	
	public String getMovieName() {
		return movie.getName();
	}
	
	public LocalDateTime getShowTime() {
		return time.getDateTime();
	}
	
	public int getSeat() {
		return seatno;
	}
	
	public double getPrice() {
		return price;
	}
	public int getID() {
		return transID;
	}
	
	public String getCinema() {
		return cinemaname;
	}
	
}	
