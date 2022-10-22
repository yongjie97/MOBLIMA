package Boundary;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Controller.MovieController;
import Entity.Movie;
import Entity.MovieRating;
import Entity.MovieStatus;
import Entity.MovieType;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Exception.InvalidInputException;

public class MovieBoundary {

    private static List<Integer> movieIds = new ArrayList<>();

    public static void manageMovie() {
        int userInput = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("===============================");
                System.out.println("Welcome to MOBLIMA - Movie Module");
                System.out.println("1: Add Movie");
                System.out.println("2: Edit Movie");
                System.out.println("3: Delete Movie");
                System.out.println("4: View Movie List");
                System.out.println("5: Show Movie Details");
                System.out.println("Enter -1 to go back");
                System.out.println("===============================");
                System.out.print("Please enter your option: ");
                userInput = sc.nextInt();
                sc.nextLine();
                switch (userInput) {
                    case 1:
                        MovieBoundary.addMovie();
                        break;
                    case 2:
                        MovieBoundary.editMovie();
                        break;
                    case 3:
                        MovieBoundary.deleteMovie();
                        break;
                    case 4:
                        MovieBoundary.showMovieList();
                        break;
                    case 5:
                        MovieBoundary.selectMovieForDetails();
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (userInput != -1);
    }

    public static void findMovie() {
        int userInput = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("===============================");
                System.out.println("1: Search Movie");
                System.out.println("2: List Available Movie");
                System.out.println("Enter -1 to go back");
                System.out.println("===============================");
                System.out.print("Please enter your option: ");
                userInput = sc.nextInt();
                sc.nextLine();
                switch (userInput) {
                    case 1:
                        MovieBoundary.searchMovie();
                        break;
                    case 2:
                        MovieBoundary.showAvailableMovieList();
                        break;
                    case -1:
                        break;
                    default:
                        throw new Exception();
                }
                int movieId = MovieBoundary.askForMovieSelection();
                if (movieId == -1) break;
                MovieBoundary.showMovieOptions(movieIds.get(movieId-1));
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (userInput != -1);
    }

    public static int askForMovieSelection() {
        int userInput = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Please select a movie (-1 to back): ");
                userInput = sc.nextInt();
                if (userInput == -1) break;
                return userInput;
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (userInput != -1);
        return -1;
    }

    public static void showMovieOptions(int movieId) {
        int userInput = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("===============================");
                System.out.println("You have selected: " + MovieController.getMovie(movieId).getName());
                System.out.println("1: View Movie Details");
                System.out.println("2: View Movie Rating & Reviews");
                System.out.println("3: Purchase Ticket");
                System.out.println("Enter -1 to go back");
                System.out.println("===============================");
                System.out.print("Please enter your option: ");
                userInput = sc.nextInt();
                sc.nextLine();
                switch (userInput) {
                    case 1:
                        MovieBoundary.showMovieDetails(movieId);
                        break;
                    case 2:
                        // Rating & Reviews
                        break;
                    case 3:
                        // Purchase Ticket
                        break;
                    case -1:
                        break;
                    default:
                        throw new Exception();
                }
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid option.");
            }
        } while (userInput != -1);
    }

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

            showMovieType();
            System.out.print("Please select a movie type: ");
            type = sc.nextInt();
            sc.nextLine();

            showMovieRating();
            System.out.print("Please select a movie rating: ");
            rating = sc.nextInt();
            sc.nextLine();

            showMovieStatus();
            System.out.print("Please select the movie status: ");
            status = sc.nextInt();
            sc.nextLine();

            MovieController.addMovie(name, synopsis, cast, director, type - 1, rating - 1, status - 1);
            System.out.println("Movie has been added.");
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
                        showMovieDetails(movieId - 1);
                        System.out.println("1: Edit mame");
                        System.out.println("2: Edit synopsis");
                        System.out.println("3: Edit cast");
                        System.out.println("4: Edit director");
                        System.out.println("5: Edit movie type");
                        System.out.println("6: Edit movie rating");
                        System.out.println("7: Edit movie status");
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
                                showMovieType();
                                System.out.print("Please select a movie type: ");
                                newIntInput = sc.nextInt();
                                movie.setMovieType(MovieType.values()[newIntInput - 1]);
                                break;
                            case 6:
                                showMovieRating();
                                System.out.print("Please select a movie rating: ");
                                newIntInput = sc.nextInt();
                                movie.setMovieRating(MovieRating.values()[newIntInput - 1]);
                                break;
                            case 7:
                                showMovieStatus();
                                System.out.print("Please select the movie status: ");
                                newIntInput = sc.nextInt();
                                movie.setMovieStatus(MovieStatus.values()[newIntInput - 1]);
                                break;
                            case -1:
                                break;
                        }
                        System.out.println("Movie has been edited.");
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
                System.out.println("Movie has been deleted.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void selectMovieForDetails() {
        showMovieList();
        if (!MovieController.isEmpty()) {
            System.out.print("Please select a movie: ");

            Scanner sc = new Scanner(System.in);
            int userInput = sc.nextInt();

            System.out.println("Movie Detail");
            showMovieDetails(userInput - 1);
        }
    }

    public static void showMovieList() {
        try {
            List<Movie> movies = MovieController.getMovieList();
            StringBuilder output = new StringBuilder("Movie List\n");
            for (int i = 0; i < movies.size(); i++) {
                output.append(MessageFormat.format("{0}: {1}\n", i + 1, movies.get(i).getName()));
            }
            System.out.println(output.substring(0, output.length() - 1).toString());
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showAvailableMovieList() throws EmptyListException {
        try {
            movieIds.clear();
            HashMap<Integer, Movie> movies = MovieController.getAvailableMovieList();
            StringBuilder output = new StringBuilder("Movie List\n");
            int i = 1;
            for (HashMap.Entry<Integer, Movie> movie : movies.entrySet()) {
                movieIds.add(movie.getKey());
                output.append(MessageFormat.format("{0}: {1}\n", i++, movie.getValue().getName()));
            }
            System.out.println(output.substring(0, output.length() - 1).toString());
        } catch (EmptyListException e) {
            throw new EmptyListException (e.getMessage());
        }
    }

    public static void searchMovie() throws EmptyListException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter your search query: ");
            String query = sc.nextLine();
            movieIds.clear();
            HashMap<Integer, Movie> movies = MovieController.getAvailableMovieList();
            StringBuilder output = new StringBuilder("Movie List\n");
            int i = 1;
            for (HashMap.Entry<Integer, Movie> movie : movies.entrySet()) {
                if (movie.getValue().getName().contains(query)) {
                    movieIds.add(movie.getKey());
                    output.append(MessageFormat.format("{0}: {1}\n", i++, movie.getValue().getName()));
                }
            }
            if (i == 1)
                throw new EmptyListException("No movies found.");
            System.out.println(output.substring(0, output.length() - 1).toString());
        } catch (EmptyListException e) {
            throw new EmptyListException (e.getMessage());
        }
    }

    public static void showMovieDetails(int movieId) {
        try {
            Movie movie = MovieController.getMovie(movieId);
            StringBuilder output = new StringBuilder("");
            output.append("Movie Name: " + movie.getName() + "\n");
            output.append("Synopsis: " + movie.getSynopsis() + "\n");
            output.append("Cast " + movie.getCast() + "\n");
            output.append("Director: " + movie.getDirector() + "\n");
            output.append("Rating: " + movie.getRating() + "\n");
            output.append("Movie Type: " + movie.getMovieType() + "\n");
            output.append("Movie Rating: " + movie.getMovieRating() + "\n");
            output.append("Movie Status: " + movie.getMovieStatus());
            System.out.println(output.toString());
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showMovieType() throws EmptyListException {
        StringBuilder output = new StringBuilder("Movie Type\n");
        for (int i = 0; i < MovieType.values().length; i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i + 1, MovieType.values()[i]));
        }
        System.out.println(output.substring(0, output.length() - 1).toString());
    }

    public static void showMovieRating() {
        StringBuilder output = new StringBuilder("Movie Rating\n");
        for (int i = 0; i < MovieRating.values().length; i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i + 1, MovieRating.values()[i]));
        }
        System.out.println(output.substring(0, output.length() - 1).toString());
    }

    public static void showMovieStatus() {
        StringBuilder output = new StringBuilder("Movie Status\n");
        for (int i = 0; i < MovieStatus.values().length; i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i + 1, MovieStatus.values()[i]));
        }
        System.out.println(output.substring(0, output.length() - 1).toString());
    }

}
