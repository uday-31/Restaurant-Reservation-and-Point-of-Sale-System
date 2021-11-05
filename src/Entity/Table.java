package Entity;
public class Table {

	private int tableID;
	private int tableSize;
	private boolean isOccupied;
	private boolean isReserved;
	private Reservation reservation;
	private Order currentOrder;

	/**
	 * 
	 * @param tableID
	 * @param tableSize
	 */
	public Table(int tableID, int tableSize) {
		this.tableID = tableID;
		this.tableSize = tableSize;
		this.isOccupied = false;
		this.isReserved = false;
		this.reservation = null;
		this.currentOrder = null;
	}
	
	
	public int getTableID() {
		return this.tableID;
	}

	/**
	 * 
	 * @param tableID
	 */
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	public int getTableSize() {
		return this.tableSize;
	}

	/**
	 * 
	 * @param tableSize
	 */
	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}

	public boolean getIsOccupied() {
		return this.isOccupied;
	}

	/**
	 * 
	 * @param isOccupied
	 */
	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public boolean getIsReserved() {
		return this.isReserved;
	}

	/**
	 * 
	 * @param isReserved
	 */
	public void setIsReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	public Reservation getReservation() {
		return this.reservation;
	}

	/**
	 * 
	 * @param reservation
	 */
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Order getCurrentOrder() {
		return this.currentOrder;
	}

	/**
	 * 
	 * @param currentOrder
	 */
	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}
	
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