package Constant;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DataFileConstant {

    private final static Path currentRelativePath = Paths.get("");
    private final static String s = currentRelativePath.toAbsolutePath().toString();

    public final static String MOVIE_FILE = s.concat("/src/data/movie.txt");
    public final static String CINEMA_FILE = s.concat("/src/data/cinema.txt");

    
}
