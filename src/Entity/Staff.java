package Entity;

public class Staff extends User {

	private String staffID;

	public Staff(String name, String email, String password) {
		super(name, email, password, UserRole.Staff);
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

}
