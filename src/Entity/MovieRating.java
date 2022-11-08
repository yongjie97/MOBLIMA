package Entity;
/**
 * Class containing information about different ratings of movies 
 * 
 *
 */
public enum MovieRating {
	/**
	 * Rating for general guidance
	 */
    G("General"),
    /**
     * Rating for parental guidance
     */
    PG("Parental Guidance"),
    /**
     * Rating for parental guidance for 13 years old 
     */
    PG13("Parental Guidance 13"),
    /**
     * Rating for no children under 16 years old
     */
    NC16("No Children Under 16"),
    /**
     * Rating for 18 years old and above
     */
    M18("Mature 18"),
    /**
     * Rating for 21 years old and above
     */
    R21("Restricted 21");

    private String value;
    /**
     * Constructor movie rating
     * @param value - value of movie rating 
     */
    MovieRating(String value) {
        this.value = value;
    }
    /**
     * Method to get value of movie rating
     * @return value of movie rating 
     */
    public String getValue() {
        return this.value;
    }

}
