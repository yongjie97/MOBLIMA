package Entity;

import java.io.Serializable;

public class Cinema implements Serializable {

    private String name;

    private CinemaClass cinemaClass;

    private char[][] cinemaLayout;

    public Cinema(String name, CinemaClass cinemaClass, char[][] cinemaLayout) {
        this.name = name;
        this.cinemaClass = cinemaClass;
        this.cinemaLayout = cinemaLayout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CinemaClass getCinemaClass() {
        return cinemaClass;
    }

    public void setCinemaClass(CinemaClass cinemaClass) {
        this.cinemaClass = cinemaClass;
    }

    public char[][] getCinemaLayout() {
        return cinemaLayout;
    }

    public void setCinemaLayout(char[][] cinemaLayout) {
        this.cinemaLayout = cinemaLayout;
    }
    
}
