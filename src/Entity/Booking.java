package Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.util.ArrayList;
	public class Booking implements Serializable{
		private Customer customer;
		private Movie movie;
		private ShowTime time;
		private int seatNo;
		private String cinemaName;
		private String transID; 
		private String emailAddress;
		private int mobileNumber;
		private String bookingdate;
		private BigDecimal totalPrice;
		
		public Booking(Customer customer, Movie movie, ShowTime time, int seatNo, BigDecimal totalPrice, String transID, String cinemaName,int mobileNumber,String emailAddress,String bookingDate) {
			this.customer = customer;
			this.time = time;
			this.movie = movie;
			this.seatNo = seatNo;
			this.totalPrice = totalPrice;
			this.transID = transID;
			this.cinemaName = cinemaName;
			this.mobileNumber = mobileNumber;
			this.emailAddress = emailAddress;
			this.bookingdate = bookingDate;		
		}
		

		public Booking(Boolean upgraded, Boolean coupleSeat, int age, BigDecimal normalPrice, BigDecimal totalPrice2,
				BigDecimal couplePrice, BigDecimal platinumPrice, BigDecimal seniorPrice, BigDecimal childPrice) {
			// TODO Auto-generated constructor stub
		}



		public Booking(Customer customer2, Movie movie2, ShowTime showtime, int seatno2, double price, int transID2,
				String cinemaname2) {
			// TODO Auto-generated constructor stub
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
		public int getmobileNumber() {
			return mobileNumber;
		}
		public int getSeat() {
			return seatNo;
		}
		
		public BigDecimal gettotalPrice() {
			return totalPrice;
		}
		public String getID() {
			return transID;
		}
		public String getemailAddress() {
			return emailAddress;
		}
		public String getCinema() {
			return cinemaName;
		}
		public String getbookingDate() {
			return bookingdate;
		}
		}
