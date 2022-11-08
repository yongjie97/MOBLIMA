package Controller;

import java.text.MessageFormat;
import java.util.List;

import Constant.DataFileConstant;
import Entity.Cineplex;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Repository.CineplexRepository;
/**
 * The logic and functions for cinema
 */
public class CineplexController {
	/**
	 * Stored details of cineplex
	 */
    private static CineplexRepository cineplexRepository = new CineplexRepository(DataFileConstant.CINEPLEX_FILE);
    /**
     * Gets cineplex from selected id
     * 
     * @param id						id of cineplex
     * @return							cineplex
     * @throws InvalidIdException		If an id input
     * 									exception occurs
     */
    public static Cineplex getCineplex(int id) throws InvalidIdException {
        id = normaliseId(id);
        if (id < 0 || id > cineplexRepository.size())
            throw new InvalidIdException("Please enter a valid cineplex id.");

        return cineplexRepository.get(id);
    }
/**
 * Gets cineplex name from selected id 
 * @param id                  id of cineplex
 * @return                    name of cineplex
 * @throws InvalidIdException If an id input exception occurs
 */
    public static String getCineplexName(int id) throws InvalidIdException {
        return getCineplex(id).getName();
    }
    /**
     * Adds a cineplex to the repository
     * 
     * @param name		Name of cineplex
     */
    public static void addCineplex(String name) {
        Cineplex cineplex = new Cineplex(name);
        cineplexRepository.add(cineplex);
    }
    /**
     * Edits the cinplex from the repository
     * @param id		Id of cineplex to be edited
     * @param name		Name of cineplex
     */
    public static void editCineplex(int id, String name) {
        id = normaliseId(id);
        Cineplex cineplex = cineplexRepository.get(id);
        cineplex.setName(name);
        cineplexRepository.edit(id, cineplex);
    }
    /**
     * Removes a cinplex from the repository	
     * 
     * @param id			Id of cineplex
     */
    public static void removeCineplex(int id) {
        id = normaliseId(id);
        cineplexRepository.remove(id);
    }
    /**
     * Check if cineplex exists in the repository
     * 
     * @return			true/false
     */
    public static boolean hasCineplex() {
        return cineplexRepository.size() > 0;
    }
    /**
     * Returns a string of the cineplexes
     * 
     * @return							String of cineplex name
     * @throws EmptyListException		If an empty list
     * 									exception occurs
     */
    public static String listCineplex() throws EmptyListException {
        List<Cineplex> cineplexList = cineplexRepository.getAll();
        if (cineplexList.size() < 1)
            throw new EmptyListException("No cineplex found.");

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < cineplexList.size(); i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i + 1, cineplexList.get(i).getName()));
        }
        return output.substring(0, output.length() - 1).toString();
    }
    /**
     * Normalises id
     * 
     * @param id	Id
     * @return		Normalised id
     */
    public static int normaliseId(int id) {
        return id-1;
    }

}
