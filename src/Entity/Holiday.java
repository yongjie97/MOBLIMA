package Entity;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * Class that contains information about holidays in the application
 * 
 *
 */
public class Holiday implements Serializable {
	/**
	 * Declaration of variables for holiday class
	 */
    private String name;
    private LocalDate date;
    /**
     * Constructor for holiday
     * @param name -  name of holiday
     * @param date - date of holiday
     */
    public Holiday(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }
    /**
     * Method to get name of holiday
     * @return name of holiday
     */
    public String getName() {
        return name;
    }
    /**
     * Method to set name of holiday
     * @param name - String
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *  Method to get date of holiday  
     * @return date of holiday
     */
    public LocalDate getDate() {
        return date;
    }
    /**
     * Method to set date of holiday
     * @param date - LocalDate
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}
