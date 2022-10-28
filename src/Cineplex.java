import java.util.ArrayList;
import java.util.Scanner;

import Controller.CinemaController;
import Entity.Cinema;
import Entity.CinemaClass;

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
	private void setCinemas() {
		int remove_add_edit;
		int class_choice;
		int select_choice;
		int edit_choice;
		String new_name;
		String new_class;
		String cinemaname;
		CinemaClass cinemaClass;
		System.out.println("Options:"
				+ "1. Remove Cinema"
				+ "2. Add Cinema"
				+ "3. Edit Cinema");
		Scanner scan = new Scanner(System.in);
		remove_add_edit = scan.nextInt();
		switch(remove_add_edit) {
			case 1:
				getCinemas();
				System.out.println("Choose which Cinema to remove");
				select_choice = scan.nextInt();
				cinemalist.remove(select_choice-1);
			case 2:
				System.out.println("What is the name of the new Cinema");
				cinemaname = scan.next();
				System.out.println("What is the class of the new Cinema"
						+ "1. Platinum"
						+ "2. Normal");
				while(true) {
					if (scan.nextInt()==1)
						cinemaClass = CinemaClass.PLATINUM;
						break;
					if (scan.nextInt()==2)
						cinemaClass = CinemaClass.NORMAL;
						break;
					System.out.println("Wrong input. Please try again");
				}
				System.out.println("What is the seat layout of the new Cinema");
				//selecting cinemalayout
		        CinemaController.addCinema(name, cinemaClass, cinemaLayout);
			case 3:
				getCinemas();
				System.out.println("Choose which Cinema to edit");
				select_choice = scan.nextInt()-1;
				
				while (edit_choice != 4) {
				System.out.println("What do you want to edit:"
						+ "1. Cinema Name"
						+ "2. Cinema Class"
						+ "3. Cinema Seat Layout"
						+ "4. Exit");
				edit_choice = scan.nextInt()-1;
				switch(edit_choice) {
					case 1:
						System.out.println("Please input the new Name");
						new_name = scan.next();
						cinemalist.get(select_choice).setName(new_name);
						break;
					case 2:
						System.out.println("Please select the new Class\n"
								+ "1. PLATINUM\n"
								+ "2. NORMAL\n");
						while(true) {
							if (scan.nextInt()==1)
								cinemaClass = CinemaClass.PLATINUM;
								break;
							if (scan.nextInt()==2)
								cinemaClass = CinemaClass.NORMAL;
								break;
							System.out.println("Wrong input. Please try again");
						}
						cinemalist.get(select_choice).setCinemaClass(cinemaClass);
						break;
					case 3:
						System.out.println("Please input the new seat layout");
						cinemalist.get(select_choice).setCinemaLayout(//seat layout//);
						
				}
				}
				}
		}
	}
