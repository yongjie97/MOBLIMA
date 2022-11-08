package Repository;

import Entity.Movie;
/**
 * Repository that encapsulate the logic required to access data sources for movie.
 * 
 */
public class MovieRepository extends Repository<Movie> {

    public MovieRepository(String fileName) {
        super(fileName);
    }

}
