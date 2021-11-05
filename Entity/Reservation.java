package Entity;
import java.util.Calendar;
import java.util.Date;

public class Reservation {

	private int resID;
	private Date resTime;
	private boolean isValid;
	private int paxSize;
	private String name;
	private String contactNo;
	private Table assignedTable;
	private String memberID;

	/**
	 * 
	 * @param resID
	 * @param resTime
	 * @param paxSize
	 * @param name
	 * @param contactNo
	 * @param memberID
	 */
	public Reservation(int resID, Date resTime, int paxSize, String name, String contactNo, String memberID) {
		this.resID = resID;
		this.resTime = resTime;
		this.paxSize = paxSize;
		this.name = name;
		this.contactNo = contactNo;
		this.memberID = memberID;
	}

	public int getResID() {
		return this.resID;
	}

	/**
	 * 
	 * @param resID
	 */
	public void setResID(int resID) {
		this.resID = resID;
	}

	public Date getResTime() {
		return this.resTime;
	}

	/**
	 * 
	 * @param resTime
	 */
	public void setResTime(Date resTime) {
		this.resTime = resTime;
	}

	public int getPaxSize() {
		return this.paxSize;
	}

	/**
	 * 
	 * @param paxSize
	 */
	public void setPaxSize(int paxSize) {
		this.paxSize = paxSize;
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

	public String getContactNo() {
		return this.contactNo;
	}

	/**
	 * 
	 * @param contactNo
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Table getAssignedTable() {
		return this.assignedTable;
	}

	/**
	 * 
	 * @param assignedTable
	 */
	public void setAssignedTable(Table assignedTable) {
		this.assignedTable = assignedTable;
	}

	public Date calculateExpiryTime() {
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(resTime);               
		cal.add(Calendar.HOUR_OF_DAY, 1);      // adds one hour
		return cal.getTime();  
	}

	public boolean getisValid() {
		return this.isValid;
	}
	
	public boolean updateValidity() {
		boolean updatedValidity;
		Date curDate = new Date();  //gets current date
		if (calculateExpiryTime().after(curDate)) {
			this.isValid = false;
			updatedValidity = false;
		}
		else {
			this.isValid = true;
			updatedValidity = true;
		}
		return updatedValidity;
	}
	
	public String getMemberID() {
		return this.memberID;
	}
	
	public void displayReservationDetails() {
		System.out.println("complete later");
	}
	
	public void resetReservation() {
		this.resID = -1;
		this.assignedTable.setIsOccupied(false);
		this.resTime = null;
		this.paxSize = 0;
		this.name = "";
		this.contactNo = "";
		this.memberID = "";
	}

}