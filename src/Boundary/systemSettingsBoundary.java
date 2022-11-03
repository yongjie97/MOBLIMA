package Boundary;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import Controller.systemSettingsController;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Entity.systemSettings;


public class systemSettingsBoundary {
	public static void systemSettings() {
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
					systemSettingsBoundary.seeticketPrices();
					break;
				case 2:
					systemSettingsBoundary.viewweekendPriceIncrementpercent();
					break;
				case 3:
					systemSettingsBoundary.viewholidayPriceIncrement();
					break;
				case 4:
					systemSettingsBoundary.viewgoodsandServicesTaxpercentforWeekdays();
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


public static void seeticketPrices() {
	while(true) { 

	Scanner x = new Scanner(System.in);
	BigDecimal N = null,S = null,C = null,P = null,Cp = null;
	BigDecimal normalPrice = N;
	BigDecimal seniorPrice = S;
	BigDecimal childPrice  = C;
	BigDecimal platinumPrice = P;
	BigDecimal couplePrice = Cp;
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
	
	
	
	



public static void viewweekendPriceIncrementpercent() {
	while(true) { 
		Scanner g = new Scanner(System.in);
		BigDecimal j = null;
		BigDecimal weekendPriceIncrementpercent = j;
		System.out.println("Please enter Weekend Price Increment percent (e.g. 1.23):");
		j = g.nextBigDecimal();	
}
}

public static void viewholidayPriceIncrement() {
	while(true) { 
		Scanner k = new Scanner(System.in);
		BigDecimal p = null;
		BigDecimal holidayPriceIncrement = p;
		System.out.println("Please enter Holiday Price Increment (e.g. 1.23):");
		p = k.nextBigDecimal();	
}
}

public static void viewgoodsandServicesTaxpercentforWeekdays() {
	while(true) { 
		Scanner q = new Scanner(System.in);
		BigDecimal w = null;
		BigDecimal goodsandServicesTaxpercentforWeekdays = w;
		System.out.println("Please enter Goods and Services Tax percent for Weekdays(e.g. 1.23):");
		w = q.nextBigDecimal();	
}
}

public static void getticketPrices(BigDecimal normalPrice, BigDecimal seniorPrice, BigDecimal childPrice,BigDecimal platinumPrice, BigDecimal couplePrice) 
	throws InvalidIdException {
		System.out.println(systemSettingsController.getticketPrices(normalPrice, seniorPrice, childPrice, platinumPrice, couplePrice));
}
public static void getweekendPriceIncrementpercent() {
	System.out.println("weekendPriceIncrementpercent");
	System.out.println(systemSettingsController.getweekendPriceIncrementpercent());
}
public static void getholidayPriceIncrement() {
	System.out.println("HolidayPriceIncrement");
	System.out.println(systemSettingsController.getholidayPriceIncrement());
}
public static void getgoodsandServicesTaxpercentforWeekdays() {
	System.out.println("GoodsandServicesTaxpercentforWeekdays");
	System.out.println(systemSettingsController.getgoodsandServicesTaxpercentforWeekdays());
}
}
