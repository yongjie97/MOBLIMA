import java.util.ArrayList;
import java.util.Scanner;

public class Staff extends User {
	
	private static ArrayList<Movie> movieList = new ArrayList <Movie>();
	private static ArrayList<String> holiday = new ArrayList <String>();
	
	
	public Staff(){
		
	}
	
	public static void addMovie() {
		String Name,Synopsis,Director,Cast;
		MovieType movieType;
		MovieStatus movieStatus;
		MovieRating movieRating;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name of Movie:");
		Name = sc.nextLine();
		System.out.println("Enter Synopsis:");
		Synopsis =sc.nextLine();
		System.out.println("Enter Director:");
		Director = sc.nextLine();
		System.out.println("Enter Cast:");
		Cast = sc.nextLine();
		
		System.out.println("Enter Movie type:\nACTION\nADVENTURE\nBLOCKBLUSTER\nCOMEDY");
		while(true) {
			String string = sc.next().toUpperCase();
			if(string.equals("ACTION")||string.equals("ADVENTURE")||string.equals("BLOCKBUSTER")||string.equals("COMEDY")) {
				movieType = MovieType.valueOf(string);
				break;
				}
			System.out.println("Input error");
		}
		
		System.out.println("Enter Movie Status:\nCOMING_SOON\nPREVIEW\nNOW_SHOWING\nFINISHED");
		while(true) {
			String string = sc.next().toUpperCase();
			if(string.equals("COMING_SOON")||string.equals("PREVIEW")||string.equals("NOW_SHOWING")||string.equals("FINISHED")) {
				movieStatus = MovieStatus.valueOf(string);
				break;
				}
			System.out.println("Input error");
		}
		
		System.out.println("Enter Movie Rating:\nG\nPG\nPG13\nNC16\nM18\nR21");
		while(true) {
			String string = sc.next().toUpperCase();
			if(string.equals("G")||string.equals("PG")||string.equals("PG13")||string.equals("NC16")||string.equals("M18")||string.equals("R21")) {
				movieRating = MovieRating.valueOf(string);
				break;
				}
			System.out.println("Input error");
		}
		sc.close();
		
		Movie M = new Movie(Name, Synopsis, Director, Cast, movieType, movieStatus, movieRating);
		movieList.add(M);
		
		

		
		
	}
	
	
	
	
	public static void editMovie() {
		Scanner sc = new Scanner(System.in);
		int choice;
		int arrSize = movieList.size();
		System.out.println("Enter Name of movie to edit");
		String Name = sc.nextLine().toLowerCase();
		
		for (int i=0;i<arrSize;i++) {
			if (movieList.get(i).getName().toLowerCase().equals(Name)) {
				
				System.out.println("1: Edit Movie Name");
				System.out.println("2: Edit Synopsis");
				System.out.println("3: Edit Director");
				System.out.println("4: Edit Cast");
				System.out.println("5: Edit Movie Type");
				System.out.println("6: Edit Movie Status");
				System.out.println("7: Edit Movie Rating");
				System.out.println("8: Exit");
				
				do {
					choice = sc.nextInt();
					
					switch (choice) {
						case 1:
							System.out.println("Enter New Name of movie");
							String name = sc.nextLine();
							movieList.get(i).setName(name);
							break;
							
						case 2:
							System.out.println("Enter New Synopsis of movie");
							String Synopsis =sc.nextLine();
							movieList.get(i).setSynopsis(Synopsis);
							break;
							
						case 3:
							System.out.println("Enter New Director of movie");
							String Director =sc.nextLine();
							movieList.get(i).setSynopsis(Director);
							break;
							
						case 4:
							System.out.println("Enter New Cast of movie");
							String Cast =sc.nextLine();
							movieList.get(i).setSynopsis(Cast);
							break;
							
						case 5:
							System.out.println("Enter New Movie type:\nACTION\nADVENTURE\nBLOCKBLUSTER\nCOMEDY");
							while(true) {
								String string = sc.next().toUpperCase();
								if(string.equals("ACTION")||string.equals("ADVENTURE")||string.equals("BLOCKBUSTER")||string.equals("COMEDY")) {
									MovieType movieType = MovieType.valueOf(string);
									movieList.get(i).setMovieType(movieType);
									break;
									}
								System.out.println("Input error");
							}
							break;
							
							
						case 6:
							System.out.println("Enter Movie Status:\nCOMING_SOON\nPREVIEW\nNOW_SHOWING\nFINISHED");
							while(true) {
								String string = sc.next().toUpperCase();
								if(string.equals("COMING_SOON")||string.equals("PREVIEW")||string.equals("NOW_SHOWING")||string.equals("FINISHED")) {
									MovieStatus movieStatus = MovieStatus.valueOf(string);
									movieList.get(i).setMovieStatus(movieStatus);
									break;
									}
								System.out.println("Input error");
							}
							break;
							
						case 7:
							System.out.println("Enter Movie Rating:\nG\nPG\nPG13\nNC16\nM18\nR21");
							while(true) {
								String string = sc.next().toUpperCase();
								if(string.equals("G")||string.equals("PG")||string.equals("PG13")||string.equals("NC16")||string.equals("M18")||string.equals("R21")) {
									MovieRating movieRating = MovieRating.valueOf(string);
									movieList.get(i).setMovieRating(movieRating);
									break;
									}
								System.out.println("Input error");
							}
							break;
						case 8:
							sc.close();
							return;
					
					
					
					}
					
				}while(choice<8);
			}
			
			
			
		}
		sc.close();
		System.out.println("Movie not found");
		
	}
	
	public static void setHolidays() {
		String date;
		int j;
		Scanner sc = new Scanner(System.in);
		int arrSize;
		System.out.println("Enter date of holiday DD/MM/YY");
		System.out.println("Enter quit to exit");
		while(true) {
			date = sc.next();
			if (date.equalsIgnoreCase("quit")) {
				sc.close();
				System.out.println("Exiting");
				return;
			}
			j=0;
			arrSize = holiday.size();
			for (int i=0;i<arrSize;i++) {
				if(holiday.get(i).equals(date)) {
					System.out.println("Date already added");
					j=1;
			}
			}
			if (j==0) {
				holiday.add(date);
				System.out.println("Date added");
			}
		
		}
		
		
		
		
	}
	public static ArrayList<String> getHoliday() {
		return holiday;
	}
	

}
