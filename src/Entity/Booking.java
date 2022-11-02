package Entity;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.util.ArrayList;
	public class Booking implements Serializable{
		private Customer customer;
		private Movie movie;
		private ShowTime time;
		private int seatno;
		private String cinemaname;
		private String transID; 
		private String emailaddress;
		private int mobilenumber;
		private String bookingdate;
		private BigDecimal TotalPrice;
		
		public Booking(Customer customer, Movie movie, ShowTime time, int seatno, BigDecimal TotalPrice, String transID, String cinemaname,int mobilenumber,String emailaddress,String bookingdate) {
			this.customer = customer;
			this.time = time;
			this.movie = movie;
			this.seatno = seatno;
			this.TotalPrice = TotalPrice;
			this.transID = transID;
			this.cinemaname = cinemaname;
			this.mobilenumber = mobilenumber;
			this.emailaddress = emailaddress;
			this.bookingdate = bookingdate;		
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
		public int getMobileNumber() {
			return mobilenumber;
		}
		public int getSeat() {
			return seatno;
		}
		
		public BigDecimal getTotalPrice() {
			return TotalPrice;
		}
		public String getID() {
			return transID;
		}
		public String getEmailAddress() {
			return emailaddress;
		}
		public String getCinema() {
			return cinemaname;
		}
		public String getBookingDate() {
			return bookingdate;
		}
		}
			
