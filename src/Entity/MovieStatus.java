package Entity;
/**
 *  Different types of status for movie listing
 */
public enum MovieStatus {

    COMING_SOON("Coming Soon"),
    PREVIEW("Preview"),
    NOW_SHOWING("Now Showing"),
    FINISHED("Finished");
	/**
	 *  Declaration of variable for movie status class
	 */
    private String value;
    /**
     * constructor for movie status
     * @param value - information of movie status
     */
     
    MovieStatus(String value) {
        this.value = value;
    }
    /**
     * Method to get value of movie status
     * @return the information of movie status
     */
    public String getValue() {
        return this.value;
    }
    
}
