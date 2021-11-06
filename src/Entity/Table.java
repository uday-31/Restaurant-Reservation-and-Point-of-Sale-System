package Entity;

/**
 * Represents a table at the restaurant.
 */
public class Table {

	/**
	 * The serial number of the table.
	 */
	private int tableID;
	
	/**
	 * The seating capacity of the table.
	 */
	private int tableSize;
	
	/**
	 * Whether the table is occupied.
	 */
	private boolean isOccupied;
	
	/**
	 * Whether the table is reserved.
	 */
	private boolean isReserved;
	
	/**
	 * If the table is reserved, the reservation corresponding to the table.
	 */
	private Reservation reservation;
	
	/**
	 * If the table is occupied, the current order at the table.
	 */
	private Order currentOrder;

	/**
	 * Initializes a table based on its serial number and seating capacity.
	 * @param tableID	the serial number of the table
	 * @param tableSize	the seating capacity of the table
	 */
	public Table(int tableID, int tableSize) {
		this.tableID = tableID;
		this.tableSize = tableSize;
		this.isOccupied = false;
		this.isReserved = false;
		this.reservation = null;
		this.currentOrder = null;
	}
	
	
	/**
	 * Gets the serial number of this table.
	 * @return	the table ID
	 */
	public int getTableID() {
		return this.tableID;
	}

	/**
	 * Updates the serial number of this table, in case there are additions before it.
	 * @param tableID	the new table ID
	 */
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	/**
	 * Gets the seating capacity of this table.
	 * @return	the seating capacity
	 */
	public int getTableSize() {
		return this.tableSize;
	}

	/**
	 * Updates the seating capacity of this table.
	 * @param tableSize	the new seating capacity
	 */
	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}

	/**
	 * Gets whether this table is occupied currently.
	 * @return	the current occupancy of the table
	 */
	public boolean getIsOccupied() {
		return this.isOccupied;
	}

	/**
	 * Updates the occupancy status of this table.
	 * @param isOccupied	the new occupancy status of the table
	 */
	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	/**
	 * Gets whether this table is reserved currently.
	 * @return	the reservation status of this table
	 */
	public boolean getIsReserved() {
		return this.isReserved;
	}

	/**
	 * Updates the reservation status of this table.
	 * @param isReserved	the new reservation status of this table
	 */
	public void setIsReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	/**
	 * Gets the details of the reservation at this table.
	 * @return	the reservation details, null if no reservation
	 */
	public Reservation getReservation() {
		return this.reservation;
	}

	/**
	 * Updates the details of the reservation at this table.
	 * @param reservation	the new reservation details
	 */
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	/**
	 * Gets the current order at this table.
	 * @return	the order at the table, null if no order
	 */
	public Order getCurrentOrder() {
		return this.currentOrder;
	}

	/**
	 * Updates the current order at this table.
	 * @param currentOrder	the new order at this table
	 */
	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}
	
	/**
	 * Displays all information regarding this table.
	 */
	public void display() {
		System.out.println();
		System.out.println("***Table Details***");
		System.out.println("Table number "+this.tableID);
		System.out.println("Table size: "+this.tableSize);
		System.out.print("Occupied: ");
		if(this.isOccupied)
			System.out.println("yes");
		else
			System.out.println("no");
		System.out.print("Reserved: ");
		if(this.isReserved) {
			System.out.println("yes");
			System.out.println("Reservation details: "+this.reservation.getName()+", "+this.reservation.getPaxSize()+" pax");
		}
		else
			System.out.println("no");
		if(this.currentOrder!=null) {
			System.out.println("Current order: "+this.currentOrder.getCreator()+" "+this.currentOrder.getTimestamp());
		}
	}


}