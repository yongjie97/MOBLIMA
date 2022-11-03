package sce.SC2002.WWC.first;

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
	private static BigDecimal TotalPrice;
	static BigDecimal CouplePrice = new BigDecimal("16.00");
	static BigDecimal NormalPrice = new BigDecimal("13.50");
	static BigDecimal SeniorPrice = new BigDecimal("5.00");
	static BigDecimal ChildPrice = new BigDecimal("7.50");
	static BigDecimal PlatinumPrice = new BigDecimal("15.00");
	static BigDecimal WeekendPriceIncrementpercent = new BigDecimal("0.40");
	static BigDecimal HolidayPriceIncrement = new BigDecimal("2.00");
	static BigDecimal GoodsandServicesTaxpercentforWeekdays = new BigDecimal("0.7");

	Scanner s = new Scanner(System.in);
	int choice = s.nextInt();{
	while (true) {
		if (choice == 0) {
			TotalPrice = NormalPrice.add(HolidayPriceIncrement);
			TotalPrice = SeniorPrice.add(HolidayPriceIncrement);
			TotalPrice = ChildPrice.add(HolidayPriceIncrement);
			TotalPrice = PlatinumPrice.add(HolidayPriceIncrement);
			TotalPrice = CouplePrice.add(HolidayPriceIncrement);
			
		} else {
			if (choice == 1) {
				BigDecimal weekendPriceIncrement = NormalPrice.multiply(WeekendPriceIncrementpercent);
				BigDecimal weekendPriceIncrement2 = PlatinumPrice.multiply(WeekendPriceIncrementpercent);
				BigDecimal weekendPriceIncrement3 = SeniorPrice.multiply(WeekendPriceIncrementpercent);
				BigDecimal weekendPriceIncrement4 = ChildPrice.multiply(WeekendPriceIncrementpercent);
				BigDecimal weekendPriceIncrement5 = CouplePrice.multiply(WeekendPriceIncrementpercent);

				weekendPriceIncrement = weekendPriceIncrement.setScale(2, RoundingMode.HALF_UP);
				weekendPriceIncrement2 = weekendPriceIncrement2.setScale(2, RoundingMode.HALF_UP);
				weekendPriceIncrement3 = weekendPriceIncrement3.setScale(2, RoundingMode.HALF_UP);
				weekendPriceIncrement4 = weekendPriceIncrement4.setScale(2, RoundingMode.HALF_UP);
				weekendPriceIncrement5 = weekendPriceIncrement5.setScale(2, RoundingMode.HALF_UP);

				TotalPrice = NormalPrice.add(weekendPriceIncrement);
				TotalPrice = PlatinumPrice.add(weekendPriceIncrement2);
				TotalPrice = SeniorPrice.add(weekendPriceIncrement3);
				TotalPrice = ChildPrice.add(weekendPriceIncrement4);
				TotalPrice = CouplePrice.add(weekendPriceIncrement5);
			} else if (choice > 1) {
				BigDecimal GoodsandServicesTax = NormalPrice.multiply(GoodsandServicesTaxpercentforWeekdays);
				BigDecimal GoodsandServicesTax2 = PlatinumPrice.multiply(GoodsandServicesTaxpercentforWeekdays);
				BigDecimal GoodsandServicesTax3 = SeniorPrice.multiply(GoodsandServicesTaxpercentforWeekdays);
				BigDecimal GoodsandServicesTax4 = ChildPrice.multiply(GoodsandServicesTaxpercentforWeekdays);
				BigDecimal GoodsandServicesTax5 = CouplePrice.multiply(GoodsandServicesTaxpercentforWeekdays);

				GoodsandServicesTax = GoodsandServicesTax.setScale(2, RoundingMode.HALF_UP);

				GoodsandServicesTax2 = GoodsandServicesTax2.setScale(2, RoundingMode.HALF_UP);

				GoodsandServicesTax3 = GoodsandServicesTax3.setScale(2, RoundingMode.HALF_UP);

				GoodsandServicesTax4 = GoodsandServicesTax4.setScale(2, RoundingMode.HALF_UP);

				GoodsandServicesTax5 = GoodsandServicesTax5.setScale(2, RoundingMode.HALF_UP);

				TotalPrice = NormalPrice.add(GoodsandServicesTax);
				TotalPrice = PlatinumPrice.add(GoodsandServicesTax2);
				TotalPrice = SeniorPrice.add(GoodsandServicesTax3);
				TotalPrice = ChildPrice.add(GoodsandServicesTax4);
				TotalPrice = CouplePrice.add(GoodsandServicesTax5);

				
				
			
		}
		}
	}

}
		private static BookingRepository bookingRepository = new BookingRepository(DataFileConstant.BOOKING_FILE);
		
		
		
		public static void addBooking(Customer customer, Movie movie,ShowTime showtime, int seatno,double price, int transID, String cinemaname) {
			Booking Booking = new Booking(customer, movie,  showtime, seatno,price,transID,cinemaname);
			bookingRepository.add(Booking);
		}
	
		public static void getPrice(Boolean upgraded,Boolean coupleSeat, int age , BigDecimal NormalPrice, BigDecimal TotalPrice, BigDecimal CouplePrice, BigDecimal PlatinumPrice,BigDecimal SeniorPrice, BigDecimal ChildPrice) {
			Booking Booking  = new Booking(upgraded, coupleSeat, age , NormalPrice, TotalPrice, CouplePrice, PlatinumPrice, SeniorPrice, ChildPrice);
		       bookingRepository.get(upgraded,coupleSeat,age,NormalPrice,TotalPrice,CouplePrice,PlatinumPrice,SeniorPrice,ChildPrice);
		}

}
