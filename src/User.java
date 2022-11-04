// either Staff or Customer
enum UserRole{
	Staff,
	Customer;
}

public abstract class User {
	public User(){
	}
	public abstract String getName();
	public abstract String getEmail();
	public abstract String getPassword();
	public abstract UserRole getRole();
	
}
