package Entity;

/**
 * Represents a staff employed by the restaurant.
 */
public class Staff {

	/**
	 * The employee ID of the staff.
	 */
	private int employeeID;
	
	/**
	 * The name of the staff.
	 */
	private String name;
	
	/**
	 * The gender of the staff.
	 */
	private Gender gender;
	
	/**
	 * The job title of the staff.
	 */
	private String jobTitle;

	/**
	 * Initializes the staff based on their personal details and job title.
	 * @param employeeID	the serial number of the staff
	 * @param name			the name of the staff
	 * @param gender		the gender of the staff
	 * @param jobTitle		the job title of the staff
	 */
	public Staff(int employeeID, String name, Gender gender, String jobTitle) {
		this.employeeID = employeeID;
		this.name = name;
		this.gender = gender;
		this.jobTitle = jobTitle;
	}

	/**
	 * Gets the employee ID of this staff.
	 * @return	the employee ID of this staff
	 */
	public int getEmployeeID() {
		return this.employeeID;
	}

	/**
	 * Updates the employee ID of this staff.
	 * @param employeeID	the new employee ID
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * Gets the name of this staff.
	 * @return	the name of this staff
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Updates the name of this staff, in case there is a typo or a change.
	 * @param name	the new name of this staff
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the gender of this staff.
	 * @return	the gender of this staff
	 */
	public Gender getGender() {
		return this.gender;
	}

	/**
	 * Updates the gender of this staff.
	 * @param gender	the new gender of this staff
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the job title of this staff.
	 * @return	the job title of this staff
	 */
	public String getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * Updates the job title of this staff.
	 * @param jobTitle	the new job title of this staff
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	/**
	 * Displays the details of the staff.
	 */
	public void display() {
		System.out.println();
		System.out.println("***Staff Details***");
		System.out.println("Employee ID: "+this.employeeID);
		System.out.println("Name: "+this.name);
		System.out.println("Gender: "+this.gender);
		System.out.println("Job title: "+this.jobTitle);
	}

}