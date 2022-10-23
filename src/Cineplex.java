import java.util.ArrayList;
import java.util.Scanner;

public class Cineplex {
	String name;
	
	// creating list of cinema objects
	ArrayList<Cinema> cinemalist = new ArrayList<Cinema>();
	
	private String getName() {
		return name;
	}
	private void setName(String a) {
		name = a;
	}
	private void getCinemas() {
		for (int a=0; a < cinemalist.size();a++) {
			System.out.println(a+1+". "+ cinemalist.get(a));	
		}
	}
	
	/// not sure about this////
	private void setCinemas() {
		int choice;
		String cinemaname;
		CinemaClass cinemaClass;
		System.out.println("Options:"
				+ "1. Remove Cinema"
				+ "2. Add Cinema"
				+ "3. Edit Cinema");
		Scanner scan = new Scanner(System.in);
		choice = scan.nextInt();
		switch(choice) {
			case 1:
				getCinemas();
				System.out.println("Choose which Cinema to remove");
				choice2 = scan.nextInt();
				cinemalist.remove(choice2-1);
			case 2:
				System.out.println("What is the name of the new Cinema");
				cinemaname = scan.next();
				System.out.println("What is the class of the new Cinema");
				cinemaClass = scan.next();
				System.out.println("What is the seat layout of the new Cinema");
				// adds in the seat layout??
				//create a cinema and add it into the array
		        CinemaController.addCinema(name, cinemaClass, cinemaLayout);
			case 3:
				CinemaController.editCinema();
				}
		}
	}
}
