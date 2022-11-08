package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Class for cineplex that contains the needed information about the cineplex in the application
 * 
 *
 */
public class Cineplex implements Serializable {
	 /**
     * Declaration of name of cineplex
     * 
     */
    public String name;
    /**
     * Declaration of the list of cinemas
     */
    public List<Cinema> cinemas;
    /**
     * Constructor for cineplex
     * @param name - name of cineplex
     */
    public Cineplex(String name) {
        this.name = name;
        cinemas = new ArrayList<>();
    }
    /**
     * Method to get name of cineplex
     * @return name of cineplex
     */
    public String getName() {
        return name;
    }
    /**
     * Method to set name of cineplex
     * @param name - String 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method to get a list of cinemas
     * @return list of cinemas
     */
    public List<Cinema> getCinemas() {
        return cinemas;
    }
    /**
     * Method to set a list of cinemas
     * @param cinemas - List <Cinema>
     */
    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

}
