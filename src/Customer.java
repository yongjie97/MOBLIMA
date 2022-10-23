import java.util.Scanner;
import java.util.ArrayList;

public class Customer extends User{
	static String name;
	static String email;
	static String password;
	static UserRole role;
	ArrayList<MovieReview> Reviews = new ArrayList<MovieReview>();
	ArrayList<Bookings> Bookings = new ArrayList<Bookings>();
	Customer(String name, String email, String password, UserRole role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		
	}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public UserRole getRole() {
		return role;
	}
	
	private static void bookMovie() {
		// depends on Booking
	}
	
	// dependent on Booking object
	public static void getBookings() {
		for (int x = 0; x < Bookings.size; x ++) {
			System.out.println((x+1)+ ". "+ Bookings[x].getMovieName+ " at " + Bookings[x].getShowTime);
		}
	}
	public static void setReview() {
		int rating;
		String review;
		System.out.println("Please enter a number between 1 to 5");
		Scanner scan = new Scanner(System.in);
		rating = scan.nextInt();
		System.out.println("Please enter the reason");
		review = scan.next(review);
		
		// i think movie review needs to have a constructor
		MovieReview(name,password, rating, review);
	}
	