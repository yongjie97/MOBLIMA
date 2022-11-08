package Entity;
/**
 * Class that contains information about staff in the application
 * 
 *
 */
public class Staff extends User {
	/**
	 *  Declaration of variables for staff class
	 */
	private String staffID;
	/**
	 * super constructor for staff 
	 * @param name -  name of staff
	 * @param email - email address of staff
	 * @param password - password of staff
	 */
	public Staff(String name, String email, String password) {
		super(name, email, password, UserRole.Staff);
	}
	/**
	 * Method to get staff ID
	 * @return ID of staff
	 */
	public String getStaffID() {
		return staffID;
	}
	/**
	 * Method to set staff ID
	 * @param staffID - String
	 */
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

}
