package Boundary;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.lang.Math;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Controller.BookingController;

import Controller.CinemaController;
import Controller.ShowTimeController;
import Entity.ShowTime;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Entity.Booking;
import Entity.Cinema;

public class bookingBoundary {
	public static void Booking() {
		int userInput = 0;

		do {
			try {
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
					bookingBoundary.viewshowTimes();
					break;
				case 2:
					bookingBoundary.viewSeats();
					break;
				case 3:
					bookingBoundary.viewticketPrices();
					break;
				case 4:
					bookingBoundary.viewtransactionDetails();
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

	public static void viewshowTimes() {
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
		while(true) {
		getCinemaLayout();
		Scanner g = new Scanner(System.in);
		System.out.println("Which Cinema do you want to view?");
		int cinemaId= g.nextInt();
		g.nextLine();
		System.out.println("How many seats do you want to book?");
		int numberOfSeats = g.nextInt();
		System.out.println("Which seat(s) do you want to book?");
		System.out.println("0, 0, 0, 0, 0, 'S', 'C', 'R', 'E', 'E', 'N', 0, 0, 0, 0, 0"+ g.nextLine()+
				                   "'E', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'E'"+ g.nextLine()+
				                   "'D', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'D'"+g.nextLine()+
				                   "'C', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'C'"+ g.nextLine()+
				                   "'B', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'B'"+ g.nextLine()+
				                   "'A', 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 'A'");
		String seatNo = g.toString();
		}
	}

	public static void viewticketPrices() {

		Scanner s = new Scanner(System.in);
		System.out.println("What is your age?");
		int age = s.nextInt();
		System.out.println("Do you want an upgraded seat(Type 1 = Yes; Type 2 = No)?");
		int yesOrNo = s.nextInt();
		System.out.println("Do you want to have a couple seat(Type 1=Yes; Type 2 = No)?");
		int yorN = s.nextInt();
		System.out.print("Please enter a positive integer (0 for holidays,1 for weekends, others for other days): ");
		int choice = s.nextInt();

		List<List<String>> rows = new ArrayList<>();
		List<String> headers = Arrays.asList("        ", "Weekday", "Weekend", "Holiday");
		rows.add(headers);
		rows.add(Arrays.asList("Child", TotalPrice = ChildPrice.add(GoodsandServicesTax4),TotalPrice = ChildPrice.add(weekendPriceIncrement4),TotalPrice = ChildPrice.add(HolidayPriceIncrement)));
		rows.add(Arrays.asList("Senior", TotalPrice = SeniorPrice.add(GoodsandServicesTax3), TotalPrice = SeniorPrice.add(weekendPriceIncrement3), TotalPrice = SeniorPrice.add(HolidayPriceIncrement)));
		rows.add(Arrays.asList("Normal", TotalPrice = NormalPrice.add(GoodsandServicesTax), TotalPrice = NormalPrice.add(weekendPriceIncrement), TotalPrice = NormalPrice.add(HolidayPriceIncrement)));
		rows.add(Arrays.asList("Couple", TotalPrice = CouplePrice.add(GoodsandServicesTax5), TotalPrice = CouplePrice.add(weekendPriceIncrement5), TotalPrice = CouplePrice.add(HolidayPriceIncrement)));
		System.out.println(formatAsTable(rows));
	private static String formatAsTable(List<List<String>> rows) {
		{
		    int[] maxLengths = new int[rows.get(0).size()];
		    for (List<String> row : rows)
		    {
		        for (int i = 0; i < row.size(); i++)
		        {
					maxLengths[i] = Math.max(maxLengths[i], row.get(i).length());
		        }
		    }

		    StringBuilder formatBuilder = new StringBuilder();
		    for (int maxLength : maxLengths)
		    {
		        formatBuilder.append("%-").append(maxLength + 2).append("s");
		    }
		    String format = formatBuilder.toString();

		    StringBuilder result = new StringBuilder();
		    for (List<String> row : rows)
		    {
		        result.append(String.format(format, row.toArray(new String[0]))).append("\n");
		    }
		    return result.toString();
		}
	}

	public static void viewtransactionDetails() {
		LocalDateTime DateTime = LocalDateTime.now();
		DateTimeFormatter Format = DateTimeFormatter.ofPattern("YYYYMMDDHHmm");
		String formatDateTime = DateTime.format(Format);
		String transID = "Transaction ID: MOB" + formatDateTime;
		String bookingDate = formatDateTime;
		System.out.println("ShowTime:" + time);
		System.out.println("Movie Title : " + movie);
		System.out.println("Name : " + customer);
		System.out.println("Cinema Name:" + cinemaName);
		System.out.println("Seat No.:" + seatNo);
		System.out.println("Total Price:" + totalPrice);
		System.out.println("Mobile Number:" + mobileNumber);
		System.out.println("Email Address:" + emailAddress);
		System.out.println("Booking Date:" + formatDateTime);
		System.out.println("Transaction ID: MOB" + formatDateTime);
		System.out.println("Thanks for Booking with Us!");

	}

	public static void gettransactionDetails(Customer customer, Movie movie, ShowTime time, int seatNo,
			BigDecimal totalPrice, String transID, String cinemaName, int mobileNumber, String emailAddress,
			String bookingDate) throws InvalidIdException {
		System.out.println(BookingController.gettransactionDetails(customer, movie, time, seatNo, totalPrice, transID,
				cinemaName, mobileNumber, emailAddress, bookingDate));
	}

	public static void getShowTime(int cinemaId) throws InvalidIdException, EmptyListException {
		System.out.println(CinemaController.getCinemaShowTime(cinemaId));
	}

	public static void getShowTimeDetail(int cinemaId, int showTimeId) throws InvalidIdException {
		System.out.println(ShowTimeController.getShowTimeDetail(cinemaId, showTimeId));
	}

	public static void getCinema() {
		System.out.println("Cinema List");
		System.out.println(CinemaController.getCinemaList());
	}
	public static void getCinemaLayout() {
		System.out.println("Cinema Layout");
		System.out.println(CinemaController.getCinemaLayout());
	}
}
