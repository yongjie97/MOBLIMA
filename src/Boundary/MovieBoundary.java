package Boundary;

import java.util.InputMismatchException;
import java.util.Scanner;

import Constant.MovieRating;
import Constant.MovieStatus;
import Constant.MovieType;
import Controller.MovieController;
import Entity.Movie;
import Exception.InvalidInputException;

public class MovieBoundary {

    public static void addMovie() {
        try {
            String name, synopsis, cast, director;
            int type, rating, status;
            Scanner sc = new Scanner(System.in);

            System.out.print("Please enter a movie name: ");
            name = sc.nextLine().trim();

            System.out.print("Please enter a synopsis: ");
            synopsis = sc.nextLine().trim();

            System.out.print("Please enter the cast: ");
            cast = sc.nextLine().trim();

            System.out.print("Please enter the director: ");
            director = sc.nextLine().trim();

            System.out.println(MovieController.getMovieType());
            System.out.print("Please select a movie type: ");
            type = sc.nextInt();
            sc.nextLine();

            System.out.println(MovieController.getMovieRating());
            System.out.print("Please select a movie rating: ");
            rating = sc.nextInt();
            sc.nextLine();

            System.out.println(MovieController.getMovieStatus());
            System.out.print("Please select the movie status: ");
            status = sc.nextInt();
            sc.nextLine();

            MovieController.addMovie(name, synopsis, cast, director, type - 1, rating - 1, status - 1);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editMovie() {

        while (true) {
            try {
                showMovieList();
                Scanner sc = new Scanner(System.in);
                int movieId;
                System.out.print("Please select a movie to edit (-1 to back): ");
                movieId = sc.nextInt();
                sc.nextLine();
                if (movieId == -1)
                    return;

                if (movieId - 1 >= 0 || movieId - 1 < MovieController.size()) {
                    Movie movie = MovieController.getMovie(movieId - 1);
                    int editField = 0;
                    while (editField != -1) {
                        System.out.println(MovieController.getMovieDetails(movieId - 1));
                        System.out.println("1: Name");
                        System.out.println("2: Synopsis");
                        System.out.println("3: Cast");
                        System.out.println("4: Director");
                        System.out.println("5: Movie Type");
                        System.out.println("6: Movie Rating");
                        System.out.println("7: Movie Status");
                        System.out.print("Please select a field to edit (-1 to back): ");
                        editField = sc.nextInt();
                        sc.nextLine();
                        String newInput;
                        int newIntInput;
                        switch (editField) {
                            case 1:
                                System.out.print("Please enter a movie name: ");
                                newInput = sc.nextLine().trim();
                                movie.setName(newInput);
                                break;
                            case 2:
                                System.out.print("Please enter a synopsis: ");
                                newInput = sc.nextLine().trim();
                                movie.setSynopsis(newInput);
                                break;
                            case 3:
                                System.out.print("Please enter the cast: ");
                                newInput = sc.nextLine().trim();
                                movie.setCast(newInput);
                                break;
                            case 4:
                                System.out.print("Please enter the director: ");
                                newInput = sc.nextLine().trim();
                                movie.setDirector(newInput);
                                break;
                            case 5:
                                System.out.println(MovieController.getMovieType());
                                System.out.print("Please select a movie type: ");
                                newIntInput = sc.nextInt();
                                movie.setMovieType(MovieType.values()[newIntInput-1]);
                                break;
                            case 6:
                                System.out.println(MovieController.getMovieRating());
                                System.out.print("Please select a movie rating: ");
                                newIntInput = sc.nextInt();
                                movie.setMovieRating(MovieRating.values()[newIntInput-1]);
                                break;
                            case 7:
                                System.out.println(MovieController.getMovieStatus());
                                System.out.print("Please select the movie status: ");
                                newIntInput = sc.nextInt();
                                movie.setMovieStatus(MovieStatus.values()[newIntInput-1]);
                                break;
                            case -1:
                                break;
                        }
                        if (editField != -1) {
                            MovieController.editMovie(movieId - 1, movie.getName(), movie.getSynopsis(),
                                    movie.getCast(), movie.getDirector(), movie.getMovieType().ordinal(),
                                    movie.getMovieRating().ordinal(), movie.getMovieStatus().ordinal());
                        }
                    }
                } else {
                    System.out.println("Please enter a valid movie id.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        }
    }

    public static void deleteMovie() {
        while (true) {
            showMovieList();
            int userInput = 0;
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Please select a movie to delete (-1 to back): ");
                userInput = sc.nextInt();
                sc.nextLine();
                if (userInput == -1)
                    return;
                MovieController.deleteMovie(userInput - 1);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void showMovieList() {
        System.out.println("Movie List");
        System.out.println(MovieController.getMovieList());
    }

    public static void showMovieListByStatus() {
        System.out.println("Movie List");
        System.out.println(MovieController.getMovieList());
    }

    public static void showMovieDetails() {
        showMovieList();
        if (!MovieController.isEmpty()) {
            System.out.print("Please select a movie: ");

            Scanner sc = new Scanner(System.in);
            int userInput = sc.nextInt();

            System.out.println("Movie Detail");
            System.out.println(MovieController.getMovieDetails(userInput - 1));
        }
    }

}
