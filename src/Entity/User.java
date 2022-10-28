package Entity;
import java.io.Serializable;
enum UserRole{
	Staff,
	Customer;
}

public abstract class User implements Serializable {
	public User(){
	}
	public abstract String getName();
	public abstract String getEmail();
	public abstract String getPassword();
	public abstract UserRole getRole();
	
}
