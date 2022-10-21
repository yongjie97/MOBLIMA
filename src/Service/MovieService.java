package Service;

import java.text.MessageFormat;

import Constant.DataFileConstant;
import Constant.MovieRating;
import Constant.MovieStatus;
import Constant.MovieType;
import Entity.Movie;
import Repository.MovieRepository;

public class MovieService {

    public static MovieRepository movieRepository = new MovieRepository(DataFileConstant.MOVIE_FILE);

    public static void addMovie(String name, String synopsis, String cast, String director,
        MovieType movieType, MovieRating movieRating, MovieStatus movieStatus) {
        Movie newMovie = new Movie(name, synopsis, director, cast, movieType, movieStatus, movieRating);
        movieRepository.add(newMovie);
    }

    public static String getMovieDetails(int selection) {
        Movie movie = movieRepository.get(selection-1);
        StringBuilder output = new StringBuilder("");
        output.append("Movie Name: " + movie.getName() + "\n");
        output.append("Synopsis: " + movie.getSynopsis() + "\n");
        output.append("Cast " + movie.getCast() + "\n");
        output.append("Director: " + movie.getDirector() + "\n");
        output.append("Rating: " + movie.getRating() + "\n");
        output.append("Movie Type: " + movie.getMovieType() + "\n");
        output.append("Movie Rating: " + movie.getMovieRating() + "\n");
        output.append("Movie Status: " + movie.getMovieStatus());
        return output.toString();
    }

    public static String getMovieList() {
        if (movieRepository.size() < 1) return "No movies found";
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < movieRepository.size(); i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i+1, movieRepository.get(i).getName()));
        }
        return output.substring(0, output.length()-1).toString();
    }

    public static String getMovieListByStatus(int selection) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < movieRepository.size(); i++) {
            if (movieRepository.get(i).getMovieStatus() == MovieStatus.values()[selection-1])
                output.append(MessageFormat.format("{0}: {1}\n", i+1, movieRepository.get(i).getName()));
        }
        if (output.isEmpty())
            return "No movies found";
        else
            return output.substring(0, output.length()-1).toString();
    }

    public static String getMovieListByRating(int selection) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < movieRepository.size(); i++) {
            if (movieRepository.get(i).getMovieRating() == MovieRating.values()[selection-1])
                output.append(MessageFormat.format("{0}: {1}\n", i+1, movieRepository.get(i).getName()));
        }
        if (output.isEmpty())
            return "No movies found";
        else
        return output.substring(0, output.length()-1).toString();
    }

    public static String getMovieListByType(int selection) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < movieRepository.size(); i++) {
            if (movieRepository.get(i).getMovieType() == MovieType.values()[selection-1])
                output.append(MessageFormat.format("{0}: {1}\n", i+1, movieRepository.get(i).getName()));
        }
        if (output.isEmpty())
            return "No movies found";
        else
            return output.substring(0, output.length()-1).toString();
    }

    public static String getMovieType() {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < MovieType.values().length; i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i+1, MovieType.values()[i]));
        }
        return output.substring(0, output.length()-1).toString();
    }

    public static String getMovieRating() {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < MovieRating.values().length; i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i+1, MovieRating.values()[i]));
        }
        return output.substring(0, output.length()-1).toString();
    }

    public static String getMovieStatus() {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < MovieStatus.values().length; i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i+1, MovieStatus.values()[i]));
        }
        return output.substring(0, output.length()-1).toString();
    }

    public static boolean isEmpty() {
        return movieRepository.size() < 1;
    }
    
}
