package Entity;

public enum MovieRating {

    G("General"),
    PG("Parental Guidance"),
    PG13("Parental Guidance 13"),
    NC16("No Children Under 16"),
    M18("Mature 18"),
    R21("Restricted 21");

    private String value;

    MovieRating(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
