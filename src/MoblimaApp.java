import Boundary.HomeBoundary;
import Constant.DataFileConstant;
import Repository.UserRepository;
import Boundary.LoginBoundary;

public class MoblimaApp {
	public static UserRepository userRepository = new UserRepository(DataFileConstant.USER_FILE);
	
    public static void main(String[] args) throws Exception {
    	int choice;
        char[][] layout = {
                { 0, 0, 0, 0, 0, 'S', 'C', 'R', 'E', 'E', 'N', 0, 0, 0 },
                { 'E', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'E' },
                { 'D', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'D' },
                { 'C', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'C' },
                { 'B', 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 'B' },
                { 'A', 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 'A' } };
        //CinemaController.addCinema("Hall 1", CinemaClass.NORMAL, layout);
        do {
        	choice = LoginBoundary.Login();
        	if (choice == 1) {
        		HomeBoundary.userUI();
        		break;
        	}
        	else if (choice == 2) {
				HomeBoundary.adminUI();
				break;
        	}
        	else if (choice == 3) {
        		break;
        	}
			System.out.println("Wrong Login Details. Please try again");
			}while (choice != 3);
    }
}

