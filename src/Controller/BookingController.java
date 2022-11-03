package Controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

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
	
	
	public static void getPrice(Boolean upgraded,Boolean coupleSeat, int age , BigDecimal normalPrice, BigDecimal totalPrice, BigDecimal couplePrice, BigDecimal platinumPrice,BigDecimal seniorPrice, BigDecimal childPrice) {
		Booking Booking  = new Booking(upgraded, coupleSeat, age , normalPrice, totalPrice, couplePrice, platinumPrice, seniorPrice, childPrice);
	       bookingRepository.get(upgraded,coupleSeat,age,normalPrice,totalPrice,couplePrice,platinumPrice,seniorPrice,childPrice);

}



	private static BigDecimal totalPrice;
	static BigDecimal couplePrice = new BigDecimal("16.00");
	static BigDecimal normalPrice = new BigDecimal("13.50");
	static BigDecimal seniorPrice = new BigDecimal("5.00");
	static BigDecimal childPrice = new BigDecimal("7.50");
	static BigDecimal platinumPrice = new BigDecimal("15.00");
	static BigDecimal weekendPriceIncrementpercent = new BigDecimal("0.40");
	static BigDecimal holidayPriceIncrement = new BigDecimal("2.00");
	static BigDecimal goodsandServicesTaxpercentforWeekdays = new BigDecimal("0.7");

     int choice;
	Scanner s = new Scanner(System.in);
	{
	
		if (choice == 0) {
			totalPrice = normalPrice.add(holidayPriceIncrement);
			totalPrice = seniorPrice.add(holidayPriceIncrement);
			totalPrice = childPrice.add(holidayPriceIncrement);
			totalPrice = platinumPrice.add(holidayPriceIncrement);
			totalPrice = couplePrice.add(holidayPriceIncrement);
			
		} else {
			if (choice == 1) {
				BigDecimal weekendPriceIncrement = normalPrice.multiply(weekendPriceIncrementpercent);
				BigDecimal weekendPriceIncrement2 = platinumPrice.multiply(weekendPriceIncrementpercent);
				BigDecimal weekendPriceIncrement3 = seniorPrice.multiply(weekendPriceIncrementpercent);
				BigDecimal weekendPriceIncrement4 = childPrice.multiply(weekendPriceIncrementpercent);
				BigDecimal weekendPriceIncrement5 = couplePrice.multiply(weekendPriceIncrementpercent);

				weekendPriceIncrement = weekendPriceIncrement.setScale(2, RoundingMode.HALF_UP);
				weekendPriceIncrement2 = weekendPriceIncrement2.setScale(2, RoundingMode.HALF_UP);
				weekendPriceIncrement3 = weekendPriceIncrement3.setScale(2, RoundingMode.HALF_UP);
				weekendPriceIncrement4 = weekendPriceIncrement4.setScale(2, RoundingMode.HALF_UP);
				weekendPriceIncrement5 = weekendPriceIncrement5.setScale(2, RoundingMode.HALF_UP);

				totalPrice = normalPrice.add(weekendPriceIncrement);
				totalPrice = platinumPrice.add(weekendPriceIncrement2);
				totalPrice = seniorPrice.add(weekendPriceIncrement3);
				totalPrice = childPrice.add(weekendPriceIncrement4);
				totalPrice = couplePrice.add(weekendPriceIncrement5);
			} else if (choice > 1) {
				BigDecimal goodsandServicesTax = normalPrice.multiply(goodsandServicesTaxpercentforWeekdays);
				BigDecimal goodsandServicesTax2 = platinumPrice.multiply(goodsandServicesTaxpercentforWeekdays);
				BigDecimal goodsandServicesTax3 = seniorPrice.multiply(goodsandServicesTaxpercentforWeekdays);
				BigDecimal goodsandServicesTax4 = childPrice.multiply(goodsandServicesTaxpercentforWeekdays);
				BigDecimal goodsandServicesTax5 = couplePrice.multiply(goodsandServicesTaxpercentforWeekdays);

				goodsandServicesTax = goodsandServicesTax.setScale(2, RoundingMode.HALF_UP);

				goodsandServicesTax2 = goodsandServicesTax2.setScale(2, RoundingMode.HALF_UP);

				goodsandServicesTax3 = goodsandServicesTax3.setScale(2, RoundingMode.HALF_UP);

				goodsandServicesTax4 = goodsandServicesTax4.setScale(2, RoundingMode.HALF_UP);

				goodsandServicesTax5 = goodsandServicesTax5.setScale(2, RoundingMode.HALF_UP);

				totalPrice = normalPrice.add(goodsandServicesTax);
				totalPrice = platinumPrice.add(goodsandServicesTax2);
				totalPrice = seniorPrice.add(goodsandServicesTax3);
				totalPrice = childPrice.add(goodsandServicesTax4);
				totalPrice = couplePrice.add(goodsandServicesTax5);

				
				
			
		}
		}
	
	}
	public static char[] gettransactionDetails(Customer customer, Movie movie, ShowTime time, int seatNo,
			BigDecimal totalPrice2, String transID, String cinemaName, int mobileNumber, String emailAddress,
			String bookingDate) {
		// TODO Auto-generated method stub
		return null;
	}
}
