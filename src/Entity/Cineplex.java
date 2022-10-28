package Entity;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.CinemaController;
import Entity.Cinema;
import Entity.CinemaClass;

public class Cineplex {
	private String name;

	ArrayList<Cinema> cinemalist = new ArrayList<Cinema>();
	
	public Cineplex(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Cinema> getCinemas() {
		return cinemalist;	
		}
	
	}
	
}
