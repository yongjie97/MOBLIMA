package Repository;

import Entity.Cineplex;
/**
 * 
 * Repository that encapsulate the logic required to access the data sources for cineplex.
 */
public class CineplexRepository extends Repository<Cineplex> {

    public CineplexRepository(String fileName) {
        super(fileName);
    }

}
