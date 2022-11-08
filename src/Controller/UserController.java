package Controller;

import Constant.DataFileConstant;
import Entity.Staff;
import Entity.User;
import Exception.InvalidIdException;
import Exception.InvalidInputException;
import Repository.UserRepository;
/**
 * Logic and function for User

 */
public class UserController {
	/**
	 * The stores user data from repository
	 */
    private static UserRepository userRepository = new UserRepository(DataFileConstant.USER_FILE);
    /**
     * User name for customer
     */
    private static User loginUser;
    /**
     * For user to log in
     * @param email - String
     * @param password - String
     * @throws InvalidInputException - if an input exception occurs
     */
    public static void login(String email, String password) throws InvalidInputException {
        for (User user : userRepository.getAll()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                loginUser = user;
                return;
            }
        }
        throw new InvalidInputException("Email/Password is wrong.");
	}
    /**
     * Registration for customer
     * Details stored in user repository
     * 
     * @param name							Name of customer
     * @param email							Email of customer
     * @param password						Password of customer
     * @throws InvalidInputException		If an input
     * 										exception occurs
     */
    public static void register(String name, String email, String password) throws InvalidInputException {
        if (email.isEmpty())
            throw new InvalidInputException("Please enter a email.");
        if (password.isEmpty())
            throw new InvalidInputException("Please enter a password.");
        User user = new Staff(name, email, password);
        userRepository.add(user);
    }
    /**
     * For user to logout
     */
    public static void logout() {
        loginUser = null;
    }
    /**
     * Check if user is logged in
     * 
     * @return			true/false
     */
    public static boolean isLoggedIn() {
        return loginUser != null;
    }
    /**
     * Gets user name
     * 
     * @return							user name
     * @throws InvalidIdException		If an id input
     * 									exception occurs
     */
    public static User getUser() throws InvalidIdException {
        if (!isLoggedIn())
            throw new InvalidIdException("You are not logged in.");
        return loginUser;
    }

}
