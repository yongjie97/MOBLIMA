package Repository;

import Entity.Movie;

public class MovieRepository extends Repository<Movie> {

    public MovieRepository(String fileName) {
        super(fileName);
    }

}
