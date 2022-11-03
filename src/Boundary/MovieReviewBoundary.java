package Boundary;
import java.util.ArrayList;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Exception.EmptyListException;
import java.util.List;
import java.util.Scanner;
import Controller.MovieReviewController;
import Entity.MovieReview;
import Exception.InvalidIdException;

public class MovieReviewBoundary {

	public MovieReviewBoundary() {

	}
	
	public void userReview() throws InvalidIdException, InvalidInputException, EmptyListException {
		System.out.println("1: Add Movie Review");
		System.out.println("2: See Movie Reviews");
		System.out.println("3: Exit");
		Scanner sc = new Scanner(System.in);
		int choice,id;
		double rating;
		String review,name;
		while(true) {
			choice = sc.nextInt();
			if (choice==1) {
				System.out.println("Enter movie id to review");
				id = sc.nextInt();
				System.out.println("Enter your name");
				name = sc.next();
				System.out.println("Enter review");
				review = sc.next();
				System.out.println("Enter rating");
				rating =sc.nextDouble();
				MovieReviewController.addReview(id,name,review,rating);
				
				}
				
			
			else if (choice == 2) {
				System.out.println("Enter movie id");
				id = sc.nextInt();
				List<MovieReview> reviewList = MovieReviewController.getMovieReviewList(id);
				int size = reviewList.size();
				for (int i = 0; i<size;i++) {
					System.out.println(reviewList.get(i));
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
		
}

