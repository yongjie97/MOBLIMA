package Entity;

import java.io.Serializable;
/**
 * Class that contains the required information about the user in the application
 * 
 *
 */
public abstract class User implements Serializable {
	/**
	 * Declarations of variables for user class
	 */
    private String name;
	private String email;
	private String password;
	private UserRole role;
	/**
	 * Constructor for user
	 * @param name - name of user
	 * @param email - email address of user
	 * @param password - password of user
	 * @param role - role of user
	 */
    public User(String name, String email, String password, UserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    /**
     * Method to get name of user
     * @return name of user
     */
    public String getName() {
        return name;
    }
    /**
     * Method to set name of user
     * @param name - String 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method to get e-mail address
     * @return e-mail address of user
     */
    public String getEmail() {
        return email;
    }
    /**
     * Method to set e-mail address
     * @param email - String 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Method to get password
     * @return password of user
     */
    public String getPassword() {
        return password;
    }
    /**
     * Method to set password
     * @param password - String 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Method to get role of user
     * @return role of user
     */
    public UserRole getRole() {
        return role;
    }
    /**
     * Method to set role of user
     * @param role - UserRole
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

}