package Controller;

import java.util.Scanner;

import Constant.MovieRating;
import Constant.MovieStatus;
import Constant.MovieType;
import Service.MovieService;

public class MovieController {

    public static void addMovie() {

        try {
            String name, synopsis, cast, director;
            int type, rating, status;
            Scanner sc = new Scanner(System.in);

            System.out.print("Please enter a movie name: ");
            name = sc.nextLine();

            System.out.print("Please enter a synopsis: ");
            synopsis = sc.nextLine();

            System.out.print("Please enter the cast: ");
            cast = sc.nextLine();

            System.out.print("Please enter the director: ");
            director = sc.nextLine();

            System.out.println(MovieService.getMovieType());
            System.out.print("Please select a movie type: ");
            type = sc.nextInt();
            sc.nextLine();
            MovieType movieType = MovieType.values()[type-1];  
            
            System.out.println(MovieService.getMovieRating());
            System.out.print("Please select a movie rating: ");
            rating = sc.nextInt(); 
            sc.nextLine();
            MovieRating movieRating = MovieRating.values()[rating-1];

            System.out.println(MovieService.getMovieStatus());
            System.out.print("Please select the movie status: ");
            status = sc.nextInt();  
            sc.nextLine();
            MovieStatus movieStatus = MovieStatus.values()[status-1];    

            MovieService.addMovie(name, synopsis, cast, director, movieType, movieRating, movieStatus);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showMovieList() {
        System.out.println("Movie List");
        System.out.println(MovieService.getMovieList());
    }

    public static void showMovieListByStatus() {
        System.out.println("Movie List");
        System.out.println(MovieService.getMovieList());
    }

    public static void showMovieDetails() {        
        showMovieList();
        if (!MovieService.isEmpty()) {
            System.out.print("Please select a movie: ");

            Scanner sc = new Scanner(System.in);
            int userInput = sc.nextInt();

            System.out.println("Movie Detail");
            System.out.println(MovieService.getMovieDetails(userInput));
        }
    }
    
}
