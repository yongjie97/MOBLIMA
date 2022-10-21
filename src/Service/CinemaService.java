package Service;

import Constant.DataFileConstant;
import Entity.Cinema;
import Entity.CinemaClass;
import Repository.CinemaRepository;

public class CinemaService {

    private static CinemaRepository cinemaRepository = new CinemaRepository(DataFileConstant.CINEMA_FILE);

    public static void addCinema(String name, CinemaClass cinemaClass, char[][] cinemaLayout) {
        Cinema cinema = new Cinema(name, cinemaClass, cinemaLayout);
        cinemaRepository.add(cinema);
    }

    public static String getCinemaInfo(int id) {
        Cinema cinema = cinemaRepository.get(id);
        StringBuilder output = new StringBuilder("");
        output.append("Cinema Name: " + cinema.getName() + "\n");
        output.append("Cinema Class: " + cinema.getCinemaClass() + "\n");
        output.append("Cinema Layout: \n");
        output.append(getCinemaLayout(cinema));
        return output.toString();
    }

    private static String getCinemaLayout(Cinema cinema) {
        StringBuilder newString = new StringBuilder();
        char[][] seatLayout = cinema.getCinemaLayout();

        for (int i = 0; i < seatLayout.length; i++) {
            char row = seatLayout[i][0];
            int seatNo = 1;
            for (int j = 0; j < seatLayout[i].length; j++) {
                newString.append(getSeatTypeFormat(seatLayout[i][j], row, seatNo));
                if (seatLayout[i][j] == 1) seatNo++;
            }
            newString.append("\n");
        }
        return newString.toString();
    }

    private static String getSeatTypeFormat(char c, char row, int seatNo) {
        if (c == 1) {
                return "|*|";
        } else if (c == 0) {
            return "   ";
        } else {
            return new StringBuilder().append(c).toString();
        }
    }
    
}
