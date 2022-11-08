package Entity;
/**
 * Class that contains the relevant information about the customer
 * 
 *
 */
public class Customer extends User {
	/**
	 * Superclass constructor for customer
	 * @param name -  name of customer
	 * @param email - email address of customer
	 * @param password - password of customer
	 */
	public Customer(String name, String email, String password) {
		super(email, password, name, UserRole.Customer);
	}
    
}
