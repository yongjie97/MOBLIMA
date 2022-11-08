package Constant;

import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *Data containing movie, cineplex, system settings, user and booking details. 
 */
public class DataFileConstant {

    private final static Path currentRelativePath = Paths.get("");
    private final static String s = currentRelativePath.toAbsolutePath().toString();

    public final static String MOVIE_FILE = s.concat("/src/data/movie.txt");
    public final static String CINEPLEX_FILE = s.concat("/src/data/cineplex.txt");
    public final static String SYSTEM_SETTINGS_FILE = s.concat("/src/data/system_settings.txt");
    public final static String USER_FILE = s.concat("/src/data/user.txt");
    public final static String BOOKING_FILE = s.concat("/src/data/booking.txt");
    
}
