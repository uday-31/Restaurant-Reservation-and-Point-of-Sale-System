package Entity;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Represents a reservation made at the restaurant.
 */
public class Reservation {

	/**
	 * Minutes past the reservation time after which it expires, common to all reservations.
	 */
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
	
	/**
	 * Pax size of the reservation.
	 */
	private int paxSize;
	
	/**
	 * Name of the person who made the reservation.
	 */
	private String name;
	
	/**
	 * Contact number of the person who made the reservation.
	 */
	private String contactNo;
	
	/**
	 * The table  the reservation is assigned to.
	 */
	private Table assignedTable;
	
	/**
	 * Member ID of the person if they are a member.
	 */
	private String memberID;
	
	/**
	 * Initialize reservation based on given input when the customer is a member.
	 * @param resID		the serial number of the reservation
	 * @param resTime	the time of the reservation
	 * @param paxSize	the pax size of the reservation
	 * @param name		the name of the customer
	 * @param contactNo	the contact number of the customer
	 * @param memberID	the member ID of the customer
	 */
	public Reservation(int resID, Date resTime, int paxSize, String name, String contactNo, String memberID) {
		this.resID = resID;
		this.resTime = resTime;
		this.paxSize = paxSize;
		this.name = name;
		this.contactNo = contactNo;
		this.memberID = memberID;
		this.isValid = true;
	}
	
	/**
	 * Initialize reservation based on given input when the customer is not a member.
	 * @param resID		the serial number of the reservation
	 * @param resTime	the time of the reservation
	 * @param paxSize	the pax size of the reservation
	 * @param name		the name of the customer
	 * @param contactNo	the contact number of the customer
	 */
	public Reservation(int resID, Date resTime, int paxSize, String name, String contactNo) {
		this.resID = resID;
		this.resTime = resTime;
		this.paxSize = paxSize;
		this.name = name;
		this.contactNo = contactNo;
		this.memberID = "";
		this.isValid = true;
	}

	/**
	 * Gets the serial number of this reservation.
	 * @return	the reservation ID 
	 */
	public int getResID() {
		return this.resID;
	}

	/**
	 * Updates the serial number of this reservation, in case reservations are added before this one.
	 * @param resID	the new reservation ID
	 */
	public void setResID(int resID) {
		this.resID = resID;
	}

	/**
	 * Gets the time of this reservation.
	 * @return	the reservation time
	 */
	public Date getResTime() {
		return this.resTime;
	}

	/**
	 * Updates the reservation time, in case the customer has made any changes.
	 * @param resTime	the new reservation time
	 */
	public void setResTime(Date resTime) {
		this.resTime = resTime;
	}

	/**
	 * Gets the pax size of this reservation.
	 * @return	the pax size
	 */
	public int getPaxSize() {
		return this.paxSize;
	}

	/**
	 * Updates the pax size of this reservation, in case the customer has made changes.
	 * @param paxSize	the new pax size of the reservation
	 */
	public void setPaxSize(int paxSize) {
		this.paxSize = paxSize;
	}

	/**
	 * Gets the name of the customer.
	 * @return	the new of the customer
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Updates the name of the customer, can be used in case there's a typo.
	 * @param name	the new name of the customer
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the contact number of the customer.
	 * @return	the contact number
	 */
	public String getContactNo() {
		return this.contactNo;
	}

	/**
	 * Updates the contact number of the customer, in case there is a typo or a change is needed.
	 * @param contactNo	the new contact number
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 * Gets the table assigned to this reservation, if any.
	 * @return	the table assigned
	 */
	public Table getAssignedTable() {
		return this.assignedTable;
	}

	/**
	 * Updates the table assigned to this reservation, in case there is a change in pax size or seating preferences.
	 * @param assignedTable	the new table assigned to this reservation
	 */
	public void setAssignedTable(Table assignedTable) {
		this.assignedTable = assignedTable;
	}

	/**
	 * Gets whether this reservation is valid.
	 * @return	whether this reservation is valid
	 */
	public boolean getIsValid() {
		return this.isValid;
	}
	
	/**
	 * Updates the validity of the reservation, in case a manual override is needed.
	 * @param isValid the new validity of the reservation
	 */
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

	/**
	 * Gets the member ID of the customer.
	 * @return	the member ID of the customer, blank if they aren't a member
	 */
	public String getMemberID() {
		return this.memberID;
	}
	
	/**
	 * Updates the member ID of the customer, in case they join the membership program or don't want to use it.
	 * @param memberID the new member ID
	 */
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	/**
	 * Resets the reservation to default values.
	 */
	public void resetReservation() {
		this.resID = -1;
		this.assignedTable.setIsReserved(false);
		this.resTime = null;
		this.paxSize = 0;
		this.name = "";
		this.contactNo = "";
		this.memberID = "";
		this.isValid = false;
	}
	
	/**
	 * Updates the validity of the reservation
	 * @return	the updated validity
	 */
	public boolean updateValidity() {
		boolean updatedValidity;
		Date curDate = new Date();  //gets current date
		if (curDate.after(calculateExpiryTime())) {
			this.isValid = false;
			this.assignedTable.setIsReserved(false);
			updatedValidity = false;
		}
		else {
			this.isValid = true;
			updatedValidity = true;
		}
		return updatedValidity;
	}	

	/**
	 * Displays the details of the reservation.
	 */
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
			System.out.println("Reservation valid until "+ this.calculateExpiryTime());
			if(this.assignedTable!=null) {
				System.out.println("Assigned table: "+this.assignedTable.getTableID());
			}
			else {
				System.out.println("No assigned table");
			}
		}
		else {
			System.out.println("Reservation invalid as "+expiryMins+" minutes have passed since reservation time!");
		}
		
		
	}

	/**
	 * Gets the number of minutes past reservation time after which it expires.
	 * @return the number of minutes
	 */
	public static int getExpiryMins() {
		return expiryMins;
	}

	/**
	 * Updates the number of minutes past reservation time after which it expires.
	 * @param expiryMins the new number of minutes
	 */
	public static void setExpiryMins(int expiryMins) {
		Reservation.expiryMins = expiryMins;
	}

	/**
	 * Calculates the time at which this reservation expires.
	 * @return	the time at which this reservation expires
	 */
	private Date calculateExpiryTime() {
		Date expiry = new Date((this.resTime.getTime() + TimeUnit.MINUTES.toMillis(expiryMins)));
		return expiry;  
	}


}