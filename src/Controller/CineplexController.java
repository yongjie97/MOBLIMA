package Controller;

import Constant.DataFileConstant;
import Entity.Cineplex;
import Repository.CineplexRepository;



public class CineplexController{
	private static CineplexRepository cineplexRepository = new CineplexRepository(DataFileConstant.CINEPLEX_FILE);
	
	
	public static void addCineplex(String name) {
		Cineplex cineplex = new Cineplex(name);
		cineplexRepository.add(cineplex);
	}
	
	public static void removeCineplex(int id) {
		cineplexRepository.remove(id);
		
	}
}