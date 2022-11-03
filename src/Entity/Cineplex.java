package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cineplex implements Serializable {
    
    public String name;

    public List<Cinema> cinemas;

    public Cineplex(String name) {
        this.name = name;
        cinemas = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

}
