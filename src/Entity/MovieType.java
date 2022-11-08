package Entity;
/**
 *  Different types of movie
 */
public enum MovieType {

    ACTION("Action"),
    ADVENTURE("Adventure"),
    BLOCKBLUSTER("Blockbuster"),
    COMEDY("Comedy"),
    THREE_D("3D");
	/**
	 *  Declaration of variables for movie type class
	 */
    private String value;
    /**
     * Constructor for movie type
     * @param value - information about movie type 
     */
    MovieType(String value) {
        this.value = value;
    }
    /**
     * Method to get the value of movie type
     * @return information about movie type
     */
    public String getValue() {
        return this.value;
    }
    
}
