package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Class for cinema that contains the required information about cinema in the application
 * 
 *
 */
public class Cinema implements Serializable {
	/**
	 * Declarations of variables for cinema class
	 */
    private String cinemaCode;

    private String name;

    private CinemaClass cinemaClass;

    private char[][] cinemaLayout;

    private List<ShowTime> showTime;
    /**
     * Constructor for cinema
     * @param cinemaCode - code of cinema
     * @param name - name of cinema
     * @param cinemaClass - class of cinema
     * @param cinemaLayout - seat layout of cinema
     */
    public Cinema(String cinemaCode, String name, CinemaClass cinemaClass, char[][] cinemaLayout) {
        this.cinemaCode = cinemaCode;
        this.name = name;
        this.cinemaClass = cinemaClass;
        this.cinemaLayout = cinemaLayout;
        this.showTime = new ArrayList<>();
    }
    /**
     * Method to get cinema name
     * @return name of cinema
     */
    public String getName() {
        return name;
    }
    /**
     * Method to set cinema name 
     * @param name - String 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method to get cinema class
     * @return class of cinema
     */
    public CinemaClass getCinemaClass() {
        return cinemaClass;
    }
    /**
     * Method to set cinema class
     * @param cinemaClass - CinemaClass
     */
    public void setCinemaClass(CinemaClass cinemaClass) {
        this.cinemaClass = cinemaClass;
    }
    /**
     * Method to get cinema layout
     * @return seat layout of cinema 
     */
    public char[][] getCinemaLayout() {
        return cinemaLayout;
    }
    /**
     * Method to set cinema layout
     * @param cinemaLayout - char[][]
     */
    public void setCinemaLayout(char[][] cinemaLayout) {
        this.cinemaLayout = cinemaLayout;
    }
    /**
     * Method to get movie show times
     * @return show time of movies
     */
    public List<ShowTime> getShowTime() {
        return showTime;
    }
    /**
     * Method to set movie show times
     * @param showTime - List<ShowTime>
     */
    public void setShowTime(List<ShowTime> showTime) {
        this.showTime = showTime;
    }


    /**
     * Method to get cinema code
     * @return cinema code 
     */
    public String getCinemaCode() {
        return cinemaCode;
    }


    /**
     * Method to set cinema code
     * @param cinemaCode - String 
     */
    public void setCinemaCode(String cinemaCode) {
        this.cinemaCode = cinemaCode;
    }
    
}
