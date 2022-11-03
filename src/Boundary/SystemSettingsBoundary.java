package sce.SC2002.WWC.first;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import Controller.SystemSettingsController;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Entity.SystemSettings;


public class SystemSettingsBoundary {
	public static void SystemSettings() {
		int userInput = 0;

		do {
			try {
				Scanner s = new Scanner(System.in);
				System.out.println("===============================");
				System.out.println("Welcome to MOBLIMA - SystemSettings Module");
				System.out.println("1: View Ticket Prices ");
				System.out.println("2: View WeekendPriceIncrementpercent");
				System.out.println("3: View HolidayPriceIncrement");
				System.out.println("4: View GoodsandServicesTaxpercentforWeekdays");
				System.out.println("Enter -1 to exit the program");
				System.out.println("===============================");
				System.out.print("Please enter your option: ");
				userInput = s.nextInt();
				s.nextLine();
				switch (userInput) {
				case 1:
					SystemSettingsBoundary.seeTicketPrices();
					break;
				case 2:
					SystemSettingsBoundary.viewWeekendPriceIncrementpercent();
					break;
				case 3:
					SystemSettingsBoundary.viewHolidayPriceIncrement();
					break;
				case 4:
					SystemSettingsBoundary.viewGoodsandServicesTaxpercentforWeekdays();
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
	}


public static void seeTicketPrices() {
	while(true) { 

	Scanner x = new Scanner(System.in);
	BigDecimal N = null,S = null,C = null,P = null,Cp = null;
	BigDecimal NormalPrice = N;
	BigDecimal SeniorPrice = S;
	BigDecimal ChildPrice  = C;
	BigDecimal PlatinumPrice = P;
	BigDecimal CouplePrice = Cp;
	System.out.println("Please enter Normal Price: ");
	N = x.nextBigDecimal();
	System.out.println("Please enter Senior Price: ");
	S = x.nextBigDecimal();
	System.out.println("Please enter Child Price: ");
	C = x.nextBigDecimal();
	System.out.println("Please enter Platinum Price: ");
	P = x.nextBigDecimal();
	System.out.println("Please enter Couple Price: ");
    Cp = x.nextBigDecimal();
	}
}
	
	
	
	



public static void viewWeekendPriceIncrementpercent() {
	while(true) { 
		Scanner g = new Scanner(System.in);
		BigDecimal j = null;
		BigDecimal weekendPriceIncrementpercent = j;
		System.out.println("Please enter Weekend Price Increment percent (e.g. 1.23):");
		j = g.nextBigDecimal();	
}
}

public static void viewHolidayPriceIncrement() {
	while(true) { 
		Scanner k = new Scanner(System.in);
		BigDecimal p = null;
		BigDecimal HolidayPriceIncrement = p;
		System.out.println("Please enter Holiday Price Increment (e.g. 1.23):");
		p = k.nextBigDecimal();	
}
}

public static void viewGoodsandServicesTaxpercentforWeekdays() {
	while(true) { 
		Scanner q = new Scanner(System.in);
		BigDecimal w = null;
		BigDecimal GoodsandServicesTaxpercentforWeekdays = w;
		System.out.println("Please enter Goods and Services Tax percent for Weekdays(e.g. 1.23):");
		w = q.nextBigDecimal();	
}
}

public static void getTicketPrices(BigDecimal NormalPrice, BigDecimal SeniorPrice, BigDecimal ChildPrice,BigDecimal PlatinumPrice, BigDecimal CouplePrice) 
	throws InvalidIdException {
		System.out.println(SystemSettingsController.getTicketPrices(NormalPrice, SeniorPrice, ChildPrice, PlatinumPrice, CouplePrice));
}
public static void getWeekendPriceIncrementpercent() {
	System.out.println("WeekendPriceIncrementpercent");
	System.out.println(SystemSettingsController.getWeekendPriceIncrementpercent());
}
public static void getHolidayPriceIncrement() {
	System.out.println("HolidayPriceIncrement");
	System.out.println(SystemSettingsController.getHolidayPriceIncrement());
}
public static void getGoodsandServicesTaxpercentforWeekdays() {
	System.out.println("GoodsandServicesTaxpercentforWeekdays");
	System.out.println(SystemSettingsController.getGoodsandServicesTaxpercentforWeekdays());
}
}
