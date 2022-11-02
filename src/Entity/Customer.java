package Entity;

public class Customer extends User{
	private String name;
	private String email;
	private String password;
	private UserRole role;
	public Customer(String name, String email, String password, UserRole role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		
	}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public UserRole getRole() {
		return role;
	}
}