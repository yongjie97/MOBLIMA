package Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Constant.ApplicationConstant;
import Entity.Cinema;
import Entity.Movie;
import Entity.ShowTime;

public class ShowTimeController {

    public static void addShowTime(Cinema cinema, Movie movie, LocalDateTime dateTime) {
        ShowTime newShowTime = new ShowTime(cinema, movie, dateTime);
        //CentralRepository.showTimes.add(newShowTime);
    }

    public static String getShowingTime(ShowTime showTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ApplicationConstant.DATETIME_FORMAT);
        return showTime.getDateTime().format(formatter).toString();
    }

    public static String getAvailableSeats(ShowTime showTime) {
        StringBuilder newString = new StringBuilder();
        char[][] seatLayout = showTime.getCinema().getCinemaLayout();

        for (int i = 0; i < seatLayout.length; i++) {
            char row = seatLayout[i][0];
            int seatNo = 1;
            for (int j = 0; j < seatLayout[i].length; j++) {
                newString.append(getSeatTypeFormat(seatLayout[i][j], row, seatNo, showTime));
                if (seatLayout[i][j] == 1) seatNo++;
            }
            newString.append("\n");
        }
        newString.append("* - Available Seat\n");
        newString.append("x - Reserved Seat");
        return newString.toString();
    }

    private static String getSeatTypeFormat(char c, char row, int seatNo, ShowTime showTime) {
        if (c == 1) {
            if (showTime.getSeatsTaken().contains(new StringBuilder().append(row).append(seatNo).toString()))
                return "|x|";
            else
                return "|*|";
        } else if (c == 0) {
            return "   ";
        } else {
            return new StringBuilder().append(c).toString();
        }
    }

    public static void reserveSeat(ShowTime showTime, String seatNo) {
        showTime.getSeatsTaken().add(seatNo);
    }

    public static boolean checkIfSeatAvailable(ShowTime showTime, String seat) {
        if (showTime.getSeatsTaken().contains(seat))
            return false;
        else {
            char[][] seatLayout = showTime.getCinema().getCinemaLayout();
            int currentSeat = 0;
            for (int i = 0; i < seatLayout.length; i++) {
                if (seatLayout[i][0] == seat.charAt(0)) {
                    for (int j = 0; j < seatLayout[i].length; j++) {
                        if (seatLayout[i][j] == 1) { 
                            currentSeat +=1;
                            if (currentSeat == (seat.charAt(1)-'0')) return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkIfFullyBooked(ShowTime showTime) {
        char[][] seatLayout = showTime.getCinema().getCinemaLayout();
        int totalSeats = 0;
        for (int i = 0; i < seatLayout.length; i++) {
            for (int j = 0; j < seatLayout[i].length; j++) {
                if (seatLayout[i][j] == 1) totalSeats +=1;
            }
        }
        return (totalSeats == showTime.getSeatsTaken().size()) ? true : false;
    }

}
