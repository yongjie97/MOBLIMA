package Boundary;

import java.util.Scanner;

import Controller.MovieReviewController;
import Exception.EmptyListException;

public class MovieReviewBoundary {

    public static void listReview(int movieId) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(MovieReviewController.listMovieReviews(movieId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Press enter to continue..");
        sc.nextLine();
    }

    public static void listTop5ByRating() {
        try {
            System.out.println("Top 5 Movies by Rating: ");
            System.out.print(MovieReviewController.listByRating());
            System.out.print("Press enter to continue..");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addReview(int movieId) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter your name: ");
            String name = sc.nextLine();
            System.out.print("Please enter your review: ");
            String review = sc.nextLine();
            System.out.print("Please enter your rating (1-5): ");
            double rating = sc.nextDouble();
            MovieReviewController.addReview(movieId, name, review, rating);
            System.out.println("Your review has been added.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
