package Boundary;
import java.util.Scanner;

public class MovieReviewBoundary extends MovieReviewController{

	public MovieReviewBoundary(String movieName) {
		super(movieName);

	}
	
	public void userReview() {
		System.out.println("1: Add Movie Review");
		System.out.println("2: See Movie Reviews");
		System.out.println("3: Exit");
		Scanner sc = new Scanner(System.in);
		int choice;
		String name,review;
		while(true) {
			choice = sc.nextInt();
			if (choice==1) {
				System.out.println("Enter movie name to review");
				name = sc.next();
				if(checkMovie(name)) {
					System.out.println("Enter review");
					review = sc.next();
					addReview(name,review);
				}
				else {
					System.out.println("Movie not found");
				}
				
			}
			else if (choice == 2) {
				System.out.println("Enter movie name");
				name = sc.next();
				if(!checkMovie(name)) {
					System.out.println("Movie not found");		
				}
				else {
					printReview(name);
				}
				
			}
			
			else if (choice == 3) {
				System.out.println("Exitting");
				break;
			}
			
			else {System.out.println("Enter valid choice");}
			
		}
		sc.close();
		
	}
	
	public void staffReview() {
		System.out.println("Enter movie name");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		addMovieForReview(name);
		sc.close();
		
	}
	
	

}
