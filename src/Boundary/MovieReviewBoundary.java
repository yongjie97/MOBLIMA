package Boundary;

import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;

import Controller.MovieController;
import Controller.MovieReviewController;
import Entity.Movie;
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
            List<Movie> sortedMovies = MovieController.listByRating();
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                if (i < sortedMovies.size()) {
                    output.append(MessageFormat.format("{0}: {1} - {2,number,#.#}/5\n", i+1, sortedMovies.get(i).getName(), sortedMovies.get(i).getRating()));
                } else {
                    output.append(MessageFormat.format("{0}: N/A\n", i+1));
                }
            }
            System.out.println(output.substring(0, output.length() - 1).toString());
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
