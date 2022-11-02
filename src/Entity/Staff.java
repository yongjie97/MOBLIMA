
public class Staff extends User {

	private String name;
	private String email;
	private String password;
	private UserRole role;

	public Staff(String name, String email, String password, UserRole role) {
		super(email, password, name, role);

	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public UserRole getRole() {
		return this.role;
	}

}
