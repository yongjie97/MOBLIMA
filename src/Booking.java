	import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;  

import java.io.Serializable;
import java.util.ArrayList;
public class Booking implements Serializable{
	private Customer customer;
	private Movie movie;
	private ShowTime time;
	private int seatno;
	private double price;
	private String cinemaname;
	private int transID;
	private int age; 
	private String emailaddress;
	private int mobilenumber;
	
	public Booking(Customer customer, Movie movie, ShowTime time, int seatno, double price, int transID, String cinemaname,int mobilenumber,String emailaddress) {
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
	public int getMobileNumber() {
		return mobilenumber;
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
	public String getEmailAddress() {
		return emailaddress;
	}
	public String getCinema() {
		return cinemaname;
	}
		
			BigDecimal  TotalPrice=null;
			BigDecimal NormalPrice = new BigDecimal("13.50");
			BigDecimal SeniorPrice = new BigDecimal("5.00");
			BigDecimal ChildPrice  = new BigDecimal("7.50");
			BigDecimal PlatinumPrice = new BigDecimal("15.00");
			LocalDateTime DateTime = LocalDateTime.now();  
	        DateTimeFormatter Format = DateTimeFormatter.ofPattern("YYYYMMDDHHmm");  
	        String FormatDateTime = DateTime.format(Format);  
		
			
			 
			BigDecimal WeekendPriceIncrementpercent =new BigDecimal("0.40");
		    BigDecimal HolidayPriceIncrement = new BigDecimal("2.00");
		    BigDecimal GoodsandServicesTaxpercent= new BigDecimal("0.7");
			int k = 0;
			int Saturday=1;
			int Sunday=2;
			ArrayList<String> Holiday = new ArrayList <String>();
			ArrayList<String> s = Holiday; 
			
			{
			
		    if (Holiday != null) {
							TotalPrice = NormalPrice.add(HolidayPriceIncrement);
							TotalPrice = SeniorPrice.add(HolidayPriceIncrement);
							TotalPrice = ChildPrice.add(HolidayPriceIncrement);
							TotalPrice = PlatinumPrice.add(HolidayPriceIncrement);
						 }
		    else {
				             if (k<=3) {
							BigDecimal WeekendPriceIncrement = NormalPrice.multiply(WeekendPriceIncrementpercent);
							BigDecimal WeekendPriceIncrement2 = PlatinumPrice.multiply(WeekendPriceIncrementpercent);
							BigDecimal WeekendPriceIncrement3 = SeniorPrice.multiply(WeekendPriceIncrementpercent);
							BigDecimal WeekendPriceIncrement4 = ChildPrice.multiply(WeekendPriceIncrementpercent);

						    WeekendPriceIncrement = WeekendPriceIncrement.setScale(2, RoundingMode.HALF_UP);
						    WeekendPriceIncrement2 = WeekendPriceIncrement2.setScale(2, RoundingMode.HALF_UP);
						    WeekendPriceIncrement3 = WeekendPriceIncrement3.setScale(2, RoundingMode.HALF_UP);
						    WeekendPriceIncrement4 = WeekendPriceIncrement4.setScale(2, RoundingMode.HALF_UP);

						     TotalPrice = NormalPrice.add(WeekendPriceIncrement);
						     TotalPrice = PlatinumPrice.add(WeekendPriceIncrement2);
						     TotalPrice = SeniorPrice.add(WeekendPriceIncrement3);
						     TotalPrice = ChildPrice.add(WeekendPriceIncrement4);}
				              else if (k>=3) {
								 BigDecimal GoodsandServicesTax = NormalPrice.multiply(GoodsandServicesTaxpercent);
								 BigDecimal GoodsandServicesTax2 = PlatinumPrice.multiply(GoodsandServicesTaxpercent);
								 BigDecimal GoodsandServicesTax3 = SeniorPrice.multiply(GoodsandServicesTaxpercent);
								 BigDecimal GoodsandServicesTax4 = ChildPrice.multiply(GoodsandServicesTaxpercent);
					             
								GoodsandServicesTax = GoodsandServicesTax.setScale(2, RoundingMode.HALF_UP);
								  
								GoodsandServicesTax2 = GoodsandServicesTax2.setScale(2, RoundingMode.HALF_UP);
								  
								GoodsandServicesTax3 = GoodsandServicesTax3.setScale(2, RoundingMode.HALF_UP);
								  
								GoodsandServicesTax4 = GoodsandServicesTax4.setScale(2, RoundingMode.HALF_UP);
						     
								 TotalPrice = NormalPrice.add(GoodsandServicesTax);
							     TotalPrice = PlatinumPrice.add(GoodsandServicesTax2);
							     TotalPrice = SeniorPrice.add(GoodsandServicesTax3);
							     TotalPrice = ChildPrice.add(GoodsandServicesTax4);
				             }
						 }
			        System.out.println("ShowTime:" + time);
			        System.out.println("Movie Title : " + movie);
			        System.out.println("Name : " + customer);
			        System.out.println("Cinema Name:"+cinemaname);
			        System.out.println("Seat No.:"+ seatno);
			        System.out.println("Total Price:" + TotalPrice);
			        System.out.println("Mobile Number:"+ mobilenumber);
			        System.out.println("Email Address:"+ emailaddress);
			        System.out.println("Booking Date:"+ FormatDateTime);
			        System.out.println("Transaction ID: MOB"+FormatDateTime); 
			        System.out.println("Thanks for Booking with Us!");
			        
		
}
}
			



