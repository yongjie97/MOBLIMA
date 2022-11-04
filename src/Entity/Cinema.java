package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cinema implements Serializable {

    private String cinemaCode;

    private String name;

    private CinemaClass cinemaClass;

    private char[][] cinemaLayout;

    private List<ShowTime> showTime;

    public Cinema(String cinemaCode, String name, CinemaClass cinemaClass, char[][] cinemaLayout) {
        this.cinemaCode = cinemaCode;
        this.name = name;
        this.cinemaClass = cinemaClass;
        this.cinemaLayout = cinemaLayout;
        this.showTime = new ArrayList<>();
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

    public List<ShowTime> getShowTime() {
        return showTime;
    }

    public void setShowTime(List<ShowTime> showTime) {
        this.showTime = showTime;
    }



    public String getCinemaCode() {
        return cinemaCode;
    }



    public void setCinemaCode(String cinemaCode) {
        this.cinemaCode = cinemaCode;
    }
    
}
