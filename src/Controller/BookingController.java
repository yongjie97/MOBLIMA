package Controller;

import Constant.DataFileConstant;
import Entity.Booking;
import Entity.Customer;
import Entity.Movie;
import Entity.ShowTime;
import Repository.BookingRepository;



public class BookingController{
	private static BookingRepository bookingRepository = new BookingRepository(DataFileConstant.BOOKING_FILE);
	
	
	public static void addBooking(Customer customer, Movie movie,ShowTime showtime, int seatno,double price, int transID, String cinemaname) {
		Booking Booking = new Booking(customer, movie,  showtime, seatno,price,transID,cinemaname);
		bookingRepository.add(Booking);
	}
}