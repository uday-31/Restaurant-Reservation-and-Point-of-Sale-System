package Entity;
public class Staff {

	private int employeeID;
	private String name;
	private Gender gender;
	private String jobTitle;

	/**
	 * 
	 * @param employeeID
	 * @param name
	 * @param gender
	 * @param jobTitle
	 */
	public Staff(int employeeID, String name, Gender gender, String jobTitle) {
		this.employeeID = employeeID;
		this.name = name;
		this.gender = gender;
		this.jobTitle = jobTitle;
	}

	public int getEmployeeID() {
		return this.employeeID;
	}

	/**
	 * 
	 * @param employeeID
	 */
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return this.gender;
	}

	/**
	 * 
	 * @param gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * 
	 * @param jobTitle
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public void display() {
		System.out.println();
		System.out.println("***Staff Details***");
		System.out.println("Employee ID: "+this.employeeID);
		System.out.println("Name: "+this.name);
		System.out.println("Gender: "+this.gender);
		System.out.println("Job title: "+this.jobTitle);
	}

}