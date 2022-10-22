package Controller;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import Constant.ApplicationConstant;
import Constant.DataFileConstant;
import Entity.Cinema;
import Entity.CinemaClass;
import Entity.ShowTime;
import Exception.EmptyListException;
import Exception.InvalidIdException;
import Repository.CinemaRepository;

public class CinemaController {

    private static CinemaRepository cinemaRepository = new CinemaRepository(DataFileConstant.CINEMA_FILE);

    public static void addCinema(String name, CinemaClass cinemaClass, char[][] cinemaLayout) {
        Cinema cinema = new Cinema(name, cinemaClass, cinemaLayout);
        cinemaRepository.add(cinema);
    }

    public static void editCinema(int id, String name, CinemaClass cinemaClass,
            char[][] cinemaLayout) {
        Cinema cinema = new Cinema(name, cinemaClass, cinemaLayout);
        cinemaRepository.edit(id, cinema);
    }

    public static String getCinemaList() {
        int size = cinemaRepository.size();
        if (size < 1)
            return "No cinema found";
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < size; i++) {
            output.append(MessageFormat.format("{0}: {1}\n", i + 1, cinemaRepository.get(i).getName()));
        }
        if (output.isEmpty())
            return "No cinema found";
        else
            return output.substring(0, output.length() - 1).toString();
    }

    public static String getCinemaShowTime(int cinemaId) throws InvalidIdException, EmptyListException {
        int size = cinemaRepository.size();

        if (cinemaId < 0 || cinemaId >= size)
            throw new InvalidIdException("Please enter a valid cinema id.");

        List<ShowTime> showTime = cinemaRepository.get(cinemaId).getShowTime();
        if (showTime.isEmpty())
            throw new EmptyListException("No showtime found");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < showTime.size(); i++) {
            output.append(MessageFormat.format("{0}: {1} | {2}\n", i + 1, showTime.get(i).getMovie().getName(), getDateTimeFormat(showTime.get(i).getDateTime())));
        }
        return output.substring(0, output.length() - 1).toString();
    }

    public static String getDateTimeFormat(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ApplicationConstant.DATETIME_FORMAT);
        return dateTime.format(formatter).toString();
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
                if (seatLayout[i][j] == 1)
                    seatNo++;
            }
            newString.append("\n");
        }
        return newString.toString().substring(0, newString.length() - 1);
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
