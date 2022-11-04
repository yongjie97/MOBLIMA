package Controller;

import Constant.DataFileConstant;
import Entity.Staff;
import Entity.User;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Repository.UserRepository;

public class UserController {

    private static UserRepository userRepository = new UserRepository(DataFileConstant.USER_FILE);
    private static User loginUser;

    public static void login(String email, String password) throws InvalidInputException {
        for (User user : userRepository.getAll()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                loginUser = user;
                return;
            }
        }
        throw new InvalidInputException("Email/Password is wrong.");
	}

    public static void register(String name, String email, String password) throws InvalidInputException {
        if (email.isEmpty())
            throw new InvalidInputException("Please enter a email.");
        if (password.isEmpty())
            throw new InvalidInputException("Please enter a password.");
        User user = new Staff(name, email, password);
        userRepository.add(user);
    }

    public static void logout() {
        loginUser = null;
    }

    public static boolean isLoggedIn() {
        return loginUser != null;
    }

    public static User getUser() throws InvalidIdException {
        if (!isLoggedIn())
            throw new InvalidIdException("You are not logged in.");
        return loginUser;
    }

}
