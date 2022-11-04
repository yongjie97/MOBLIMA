package Entity;

public enum MovieType {

    ACTION("Action"),
    ADVENTURE("Adventure"),
    BLOCKBLUSTER("Blockbuster"),
    COMEDY("Comedy"),
    THREE_D("3D");

    private String value;

    MovieType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
    
}
