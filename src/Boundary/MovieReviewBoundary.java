package Boundary;

import java.util.Scanner;

import Controller.MovieReviewController;

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

    public static void addReview(int movieId) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter your review: ");
            String review = sc.nextLine();
            System.out.print("Please enter your rating (1-5): ");
            double rating = sc.nextDouble();
            MovieReviewController.addReview(movieId, review, rating);
            System.out.println("Your review has been added.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
