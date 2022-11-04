package Entity;

public class Customer extends User {

	public Customer(String name, String email, String password) {
		super(email, password, name, UserRole.Customer);
	}
    
}
