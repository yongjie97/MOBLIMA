package Boundary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Constant.ApplicationConstant;
import Controller.ShowTimeController;

public class ShowTimeBoundary {

    public static void addShowTime() {
        String userInput;
        Scanner sc = new Scanner(System.in);

        System.out.println("Please select a cineplex:");
        // Show a list of cineplex
        userInput = sc.nextLine();
        // Get the cinema

        System.out.println("Please select a cinema:");
        // Show a list of cinema
        userInput = sc.nextLine();
        // Get the cinema

        System.out.println("Please select a movie:");
        // Show a list of movie
        userInput = sc.nextLine();
        // Get the movie

        System.out.println("Please enter the date and time (" + ApplicationConstant.DATETIME_FORMAT + ") for the showtime.");
        userInput = sc.nextLine();
        sc.close();
        LocalDateTime dateTime = LocalDateTime.parse(userInput, DateTimeFormatter.ofPattern(ApplicationConstant.DATETIME_FORMAT));

        //ShowTime newShowTime()
        //ShowTimeService.addShowTime(null, dateTime);
    }

    
    
}
