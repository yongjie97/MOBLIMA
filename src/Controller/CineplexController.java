package Controller;

import java.text.MessageFormat;
import java.util.List;

import Constant.DataFileConstant;
import Entity.Cineplex;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Repository.CineplexRepository;

public class CineplexController {

    private static CineplexRepository cineplexRepository = new CineplexRepository(DataFileConstant.CINEPLEX_FILE);

    public static Cineplex getCineplex(int id) throws InvalidIdException {
        id = normaliseId(id);
        if (id < 0 || id > cineplexRepository.size())
            throw new InvalidIdException("Please enter a valid cineplex id.");

        return cineplexRepository.get(id);
    }

    public static void addCineplex(String name) {
        Cineplex cineplex = new Cineplex(name);
        cineplexRepository.add(cineplex);
    }

    public static void editCineplex(int id, String name) {
        id = normaliseId(id);
        Cineplex cineplex = cineplexRepository.get(id);
        cineplex.setName(name);
        cineplexRepository.edit(id, cineplex);
    }

    public static void removeCineplex(int id) {
        id = normaliseId(id);
        cineplexRepository.remove(id);
    }

    public static boolean hasCineplex() {
        return cineplexRepository.size() > 0;
    }

    public static String listCineplex() throws EmptyListException {
        List<Cineplex> cineplexList = cineplexRepository.getAll();
        if (cineplexList.size() < 1)
            throw new EmptyListException("No cineplex found.");

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < cineplexList.size(); i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i + 1, cineplexList.get(i).getName()));
        }
        return output.substring(0, output.length() - 1).toString();
    }

    public static int normaliseId(int id) {
        return id-1;
    }

}
