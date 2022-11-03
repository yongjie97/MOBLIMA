package Entity;

public enum MovieStatus {

    COMING_SOON("Coming Soon"),
    PREVIEW("Preview"),
    NOW_SHOWING("Now Showing"),
    FINISHED("Finished");

    private String value;

    MovieStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
    
}
