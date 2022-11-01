package Boundary;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;  

import java.io.Serializable;
import java.util.ArrayList;

import Controller.BookingController

import Controller.CinemaController;
import Controller.ShowTimeController;
import Entity.ShowTime;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Entity.Booking
import Entity.Cinema

public class BookingBoundary {
	static BigDecimal  TotalPrice=null;
	static BigDecimal NormalPrice = new BigDecimal("13.50");
	static BigDecimal SeniorPrice = new BigDecimal("5.00");
	static BigDecimal ChildPrice  = new BigDecimal("7.50");
	static BigDecimal PlatinumPrice = new BigDecimal("15.00");
	static BigDecimal WeekendPriceIncrementpercent =new BigDecimal("0.40");
    static BigDecimal HolidayPriceIncrement = new BigDecimal("2.00");
    static BigDecimal GoodsandServicesTaxpercentforWeekdays= new BigDecimal("0.7");

	public static void Booking() {
		 int userInput = 0;
	
	do { 
		try{
			Scanner sc = new Scanner(System.in);
			 System.out.println("===============================");
             System.out.println("Welcome to MOBLIMA - Booking Module");
             System.out.println("1: View ShowTimes ");
             System.out.println("2: View Seats");
             System.out.println("3: View Ticket Prices");
             System.out.println("4: View Transaction Details");
             System.out.println("Enter -1 to exit the program");
             System.out.println("===============================");
             System.out.print("Please enter your option: ");
             userInput = sc.nextInt();
             sc.nextLine();
             switch (userInput) {
             case 1:
                 BookingBoundary.viewShowTimes();
                 break;
             case 2:
                 BookingBoundary.viewSeats();
                 break;
             case 3:
                 BookingBoundary.viewTicketPrices();
                 break;
             case 4:
                 BookingBoundary.viewTransactionDetails();
                 break;
             case -1:
                 System.out.println("Thank you for choosing MOBLIMA");
                 break;
             default:
                 throw new Exception();
         }
     } catch (Exception e) {
         System.out.println("Please enter a valid option.");
     }
 } while (userInput != -1);

	
	
	 public static void viewShowTimes() {
		 while (true) {
	            try {
	                getCinema();
	                System.out.print("Please enter a cinema id (-1 to back): ");
	                Scanner sc = new Scanner(System.in);
	                int cinemaId = sc.nextInt();
	                sc.nextLine();
	                if (cinemaId == -1)
	                    return;

	                getShowTime(cinemaId - 1);
	            } catch (EmptyListException e) {
	                System.out.println(e.getMessage());
	            } catch (Exception e) {
	                System.out.println("Please enter a valid option.");
	            }
	        }
	 }
	 
	 public static String viewSeats() {
		 StringBuilder newString = new StringBuilder();
	        char[][] seatLayout = cinema.getCinemaLayout();

	        for (int i = 0; i < seatLayout.length; i++) {
	            char row = seatLayout[i][0];
	            int seatNo = 1;
	            for (int j = 0; j < seatLayout[i].length; j++) {
	                newString.append(getSeatTypeFormat(seatLayout[i][j], row, seatNo));
	                if (seatLayout[i][j] == 1)
	                    seatNo++;
	            }
	            newString.append("\n");
	        }
	        return newString.toString().substring(0, newString.length() - 1);
	 }

	    private static String getSeatTypeFormat(char c, char row, int seatNo) {
	        if (c == 1) {
	            return "|*|";
	        } else if (c == 0) {
	            return "   ";
	        } else {
	            return new StringBuilder().append(c).toString();
	        }
	    }
	    public static void viewTicketPrices() {
	    	
	    	 Scanner s = new Scanner(System.in);
	    	 System.out.println("What is your age?");
	        int age = s.nextInt();
	        System.out.println("Do you want an upgraded seat(Type 1 = Yes; Type 2 = No)");
	        int YesorNo = s.nextInt();
			 System.out.print("Please enter a positive integer (0 for holidays,1 for weekends, others for other days): ");
			   int choice = s.nextInt();
		   while (true) {
					 if (choice==0) {
						TotalPrice = NormalPrice.add(HolidayPriceIncrement);
						TotalPrice = SeniorPrice.add(HolidayPriceIncrement);
						TotalPrice = ChildPrice.add(HolidayPriceIncrement);
						TotalPrice = PlatinumPrice.add(HolidayPriceIncrement);
						 if (age < 12) { 
					            TotalPrice = ChildPrice;
					        System.out.println("You are under 12." + "Your price is: " + TotalPrice);}
					        

					        else {
					        	if (age >= 12 && age <= 65) {
					            TotalPrice = NormalPrice;
					                System.out.println("Your price is SGD " + TotalPrice);}
					                else if (age >65) {
					            TotalPrice = SeniorPrice;
					                 System.out.println("You are over 65. Your price is SGD " + TotalPrice);}}
					        System.out.println("For Upgraded Seats :");
					        if (YesorNo < 2 ){
						       TotalPrice = PlatinumPrice;
						       System.out.println("Your price is SGD " + TotalPrice);}
					        else {
					              if(YesorNo>=2) {
					    		  System.out.println("Not Applicable");}
					      }
					 }
					 else {
			             if (choice==1) {
						BigDecimal weekendPriceIncrement = NormalPrice.multiply(WeekendPriceIncrementpercent);
						BigDecimal weekendPriceIncrement2 = PlatinumPrice.multiply(WeekendPriceIncrementpercent);
						BigDecimal weekendPriceIncrement3 = SeniorPrice.multiply(WeekendPriceIncrementpercent);
						BigDecimal weekendPriceIncrement4 = ChildPrice.multiply(WeekendPriceIncrementpercent);

					    weekendPriceIncrement = weekendPriceIncrement.setScale(2, RoundingMode.HALF_UP);
					    weekendPriceIncrement2 = weekendPriceIncrement2.setScale(2, RoundingMode.HALF_UP);
					    weekendPriceIncrement3 = weekendPriceIncrement3.setScale(2, RoundingMode.HALF_UP);
					    weekendPriceIncrement4 = weekendPriceIncrement4.setScale(2, RoundingMode.HALF_UP);

					     TotalPrice = NormalPrice.add(weekendPriceIncrement);
					     TotalPrice = PlatinumPrice.add(weekendPriceIncrement2);
					     TotalPrice = SeniorPrice.add(weekendPriceIncrement3);
					     TotalPrice = ChildPrice.add(weekendPriceIncrement4);
					     if (age < 12) { 
					            TotalPrice = ChildPrice;
					        System.out.println("You are under 12." + "Your price is: " + TotalPrice);}
					        

					        else {
					        	if (age >= 12 && age <= 65) {
					            TotalPrice = NormalPrice;
					                System.out.println("Your price is SGD " + TotalPrice);}
					                else if (age >65) {
					            TotalPrice = SeniorPrice;
					                 System.out.println("You are over 65. Your price is SGD " + TotalPrice);}}
					        System.out.println("For Upgraded Seats :");
					        if (YesorNo < 2 ){
						       TotalPrice = PlatinumPrice;
						       System.out.println("Your price is SGD " + TotalPrice);}
					        else {
					              if(YesorNo>=2) {
					    		  System.out.println("Not Applicable");}
					      }}
			             else if (choice>1) {
							 BigDecimal GoodsandServicesTax = NormalPrice.multiply(GoodsandServicesTaxpercentforWeekdays);
							 BigDecimal GoodsandServicesTax2 = PlatinumPrice.multiply(GoodsandServicesTaxpercentforWeekdays);
							 BigDecimal GoodsandServicesTax3 = SeniorPrice.multiply(GoodsandServicesTaxpercentforWeekdays);
							 BigDecimal GoodsandServicesTax4 = ChildPrice.multiply(GoodsandServicesTaxpercentforWeekdays);
				             
							GoodsandServicesTax = GoodsandServicesTax.setScale(2, RoundingMode.HALF_UP);
							  
							GoodsandServicesTax2 = GoodsandServicesTax2.setScale(2, RoundingMode.HALF_UP);
							  
							GoodsandServicesTax3 = GoodsandServicesTax3.setScale(2, RoundingMode.HALF_UP);
							  
							GoodsandServicesTax4 = GoodsandServicesTax4.setScale(2, RoundingMode.HALF_UP);
					     
							 TotalPrice = NormalPrice.add(GoodsandServicesTax);
						     TotalPrice = PlatinumPrice.add(GoodsandServicesTax2);
						     TotalPrice = SeniorPrice.add(GoodsandServicesTax3);
						     TotalPrice = ChildPrice.add(GoodsandServicesTax4);
						     if (age < 12) { 
						            TotalPrice = ChildPrice;
						        System.out.println("You are under 12." + "Your price is: " + TotalPrice);}
						        

						        else {
						        	if (age >= 12 && age <= 65) {
						            TotalPrice = NormalPrice;
						                System.out.println("Your price is SGD " + TotalPrice);}
						                else if (age >65) {
						            TotalPrice = SeniorPrice;
						                 System.out.println("You are over 65. Your price is SGD " + TotalPrice);}}
						        System.out.println("For Upgraded Seats :");
						        if (YesorNo < 2 ){
							       TotalPrice = PlatinumPrice;
							       System.out.println("Your price is SGD " + TotalPrice);}
						        else {
						              if(YesorNo>=2) {
						    		  System.out.println("Not Applicable");}
						      }
			             }
					 }
				 }

				}
public static void viewTransactionDetails() {
LocalDateTime DateTime = LocalDateTime.now();  
DateTimeFormatter Format = DateTimeFormatter.ofPattern("YYYYMMDDHHmm");  
String FormatDateTime = DateTime.format(Format);  
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



public static void getShowTime(int cinemaId) throws InvalidIdException, EmptyListException {
System.out.println(CinemaController.getCinemaShowTime(cinemaId));
}

public static void getShowTimeDetail(int cinemaId, int showTimeId) throws InvalidIdException {
System.out.println(ShowTimeController.getShowTimeDetail(cinemaId, showTimeId));
}
	}
