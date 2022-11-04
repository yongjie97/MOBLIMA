package Controller;

import java.text.MessageFormat;
import java.util.List;

import Constant.DataFileConstant;
import Entity.Cinema;
import Entity.CinemaClass;
import Entity.Cineplex;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Repository.CineplexRepository;

public class CinemaController {

    private static CineplexRepository cineplexRepository = new CineplexRepository(DataFileConstant.CINEPLEX_FILE);

    public static void addCinema(int cineplexId, String cinemaCode, String name, CinemaClass cinemaClass, char[][] cinemaLayout)
            throws InvalidIdException {
        cineplexId = normaliseId(cineplexId);
        Cineplex cineplex = CineplexController.getCineplex(cineplexId + 1);
        Cinema newCinema = new Cinema(cinemaCode, name, cinemaClass, cinemaLayout);
        cineplex.getCinemas().add(newCinema);
        cineplexRepository.edit(cineplexId, cineplex);
    }

    public static void editCinema(int cineplexId, int cinemaId, int id, String name, CinemaClass cinemaClass,
            char[][] cinemaLayout) throws InvalidIdException {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);

        Cineplex cineplex = CineplexController.getCineplex(cineplexId + 1);
        if (cinemaId < 0 || cinemaId > cineplex.getCinemas().size())
            throw new InvalidIdException("Please enter a valid cinema id.");

        Cinema cinema = cineplex.getCinemas().get(cinemaId);
        cinema.setName(name);
        cinema.setCinemaClass(cinemaClass);
        cinema.setCinemaLayout(cinemaLayout);
        cineplexRepository.edit(cineplexId, cineplex);
    }

    public static void removeCinema(int cineplexId, int cinemaId) throws InvalidIdException {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);
        Cineplex cineplex = CineplexController.getCineplex(cineplexId + 1);
        if (cinemaId < 0 || cinemaId > cineplex.getCinemas().size())
            throw new InvalidIdException("Please enter a valid cinema id.");
        cineplexRepository.remove(cinemaId);
    }

    public static Cinema getCinema(int cineplexId, int cinemaId) throws InvalidIdException {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);

        Cineplex cineplex = CineplexController.getCineplex(cineplexId + 1);
        if (cinemaId < 0 || cinemaId > cineplex.getCinemas().size())
            throw new InvalidIdException("Please enter a valid cinema id.");
        return cineplex.getCinemas().get(cinemaId);
    }

    public static boolean hasCinema(int cineplexId) {
        cineplexId = normaliseId(cineplexId);
        return cineplexRepository.get(cineplexId).getCinemas().size() > 0;
    }

    public static String listCinema(int cineplexId) throws InvalidIdException, EmptyListException {
        cineplexId = normaliseId(cineplexId);
        Cineplex cineplex = cineplexRepository.get(cineplexId);
        if (cineplexId < 0)
            throw new InvalidIdException("Please enter a valid cineplex id.");
        if (cineplex.getCinemas().size() < 1)
            throw new EmptyListException("No cinema found.");

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < cineplex.getCinemas().size(); i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i + 1, cineplex.getCinemas().get(i).getName()));
        }
        return output.substring(0, output.length() - 1).toString();
    }

    public static String listCinemaInfo(int cineplexId, int cinemaId) throws InvalidIdException, EmptyListException {
        cineplexId = normaliseId(cineplexId);
        cinemaId = normaliseId(cinemaId);
        List<Cineplex> cineplexList = cineplexRepository.getAll();
        if (cineplexId < 0 || cineplexId > cineplexList.size())
            throw new InvalidIdException("Please enter a valid cineplex id.");
        if (cineplexList.size() < 1)
            throw new EmptyListException("No cineplex found.");
        if (cinemaId < 0 || cinemaId > cineplexList.get(cineplexId).getCinemas().size())
            throw new InvalidIdException("Please enter a valid cinema id.");
        if (cineplexList.get(cineplexId).getCinemas().size() < 1)
            throw new EmptyListException("No cinema found.");

        Cinema cinema = cineplexList.get(cineplexId).getCinemas().get(cinemaId);
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
                if (seatLayout[i][j] == 1)
                    seatNo++;
            }
            newString.append("\n");
        }
        newString.append(
                "\nLEGEND:\nSeat ranges from 1 (starting from to left) to the right.\n|*| - Available, |*  *| - Couple Seat, |x| - Sold");
        return newString.toString();
    }

    private static String getSeatTypeFormat(char c, char row, int seatNo) {
        if (c == 1) {
            return "|*|";
        } else if (c == 2) {
            return "|*  *|";
        } else if (c == 0) {
            return "   ";
        } else {
            return new StringBuilder().append(c).toString();
        }
    }

    public static int normaliseId(int id) {
        return id - 1;
    }

}
