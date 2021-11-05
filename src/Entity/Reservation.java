package Entity;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Represents a reservation made at the restaurant.
 */
public class Reservation {

	private static int expiryMins = 30;

	/**
	 * Serial number of the reservation.
	 */
	private int resID;
	
	/**
	 * Time of the reservation.
	 */
	private Date resTime;
	
	/**
	 * Whether the reservation is valid.
	 */
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
		this.isValid = true;
		assignTable();
	}
	
	public Reservation(int resID, Date resTime, int paxSize, String name, String contactNo) {
		this.resID = resID;
		this.resTime = resTime;
		this.paxSize = paxSize;
		this.name = name;
		this.contactNo = contactNo;
		this.memberID = "";
		this.isValid = true;
		assignTable();
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

	public boolean getIsValid() {
		return this.isValid;
	}
	
	/**
	 * @param isValid the isValid to set
	 */
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getMemberID() {
		return this.memberID;
	}
	
	/**
	 * @param memberID the memberID to set
	 */
	public void setMemberID(String memberID) {
		this.memberID = memberID;
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
	
	public void display() {
		System.out.println();
		System.out.println("***Reservation Details***");
		System.out.println("ID: "+this.resID);
		System.out.println("Name: "+this.name);
		System.out.println("Size: "+this.paxSize+" pax");
		System.out.println("Time: "+this.resTime);
		System.out.println("Contact number: "+this.contactNo);
		if(this.memberID.length()>0) {
			System.out.println("Membership number: "+this.memberID);
		}
		else {
			System.out.println("Not a member");
		}
		if(this.isValid)  {
			System.out.println("Reservation valid until "+ new Date((this.resTime.getTime() + TimeUnit.MINUTES.toMillis(expiryMins))));
			if(this.assignedTable!=null) {
				System.out.println("Assigned table: "+this.assignedTable.getTableID());
			}
			else {
				System.out.println("No assigned table");
			}
		}
		else {
			System.out.println("Reservation invalid");
		}
		
		
	}

	/**
	 * @return the expiryMins
	 */
	public static int getExpiryMins() {
		return expiryMins;
	}

	/**
	 * @param expiryMins the expiryMins to set
	 */
	public static void setExpiryMins(int expiryMins) {
		Reservation.expiryMins = expiryMins;
	}

	public Date calculateExpiryTime() {
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(resTime);               
		cal.add(Calendar.HOUR_OF_DAY, 1);      // adds one hour
		return cal.getTime();  
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

	private void assignTable() {
		
	}

}