import java.util.ArrayList;
import java.util.Scanner;

public class Staff extends User {
	
public class Staff extends MovieBoundary{
	
	public void manageMovie() {
		this.manageMovie();
	}
}
	
	public void setHolidays() {
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
	public ArrayList<String> getHoliday() {
		return holiday;
	}
	

}
