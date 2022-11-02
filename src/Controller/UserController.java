package Controller;

import Constant.DataFileConstant;
import Entity.UserRole;
import Repository.UserRepository;

public class UserController {
	private static UserRepository userRepository = new UserRepository(DataFileConstant.USER_FILE);
	private static int isLogin = 0;
	private static int size = userRepository.size();

	public static int LoginFunction(String username, String password) {
		for (int i = 0; i < size; i++) {
			if ((userRepository.get(i).getName().equals(username)) && (userRepository.get(i).getPassword().equals(password))){
				isLogin = 1;
				if (userRepository.get(i).getRole() == UserRole.Customer) {
				return 1;
			} 
			else {
				isLogin = 2;
				return 2;
			}
			}
		}
		return 0;
	}

	public static int isLogin() {
		return isLogin;
	}

	public static int Logout() {
		if (isLogin() == 1) {
			isLogin = 0;
			return 1;
		} else {
			return 0;
		}
	}
}
