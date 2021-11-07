package Controller;
import java.util.ArrayList;

import Entity.Reservation;
import Entity.Restaurant;
import Entity.Table;

/**
 * Controller class handling the restaurant's tables.
 */
public class TableController {

	/**
	 * Restaurant's tables.
	 */
	private static ArrayList<Table> tables = Restaurant.tables;

	/**
	 * Adds a table to the restaurant.
	 * @param tableID	the ID of the table
	 * @param tableSize	the size of the table
	 */
	public void addTable(int tableID, int tableSize) {
		Table newtable = new Table(tableID, tableSize);
		tables.add(newtable);
	}

	/**
	 * Views a table with a given ID.
	 * @param tableID	the ID of the table
	 * @return			1 if table displayed successfully, -1 if table not found
	 */
	public int viewTable(int tableID) {
		for(int i=0; i<tables.size(); ++i) {
			if(tables.get(i).getTableID()==tableID) {
				tables.get(i).display();
				return 1;
			}
		}
		return -1;
	}

	/**
	 * Removes a table with the given ID.
	 * @param table ID	the ID of the table
	 * @return 			1 if table removed successfully, -1 otherwise
	 */
	public int removeTable(int tableID) {
		for(int i=0; i<tables.size(); ++i) {
			if(tables.get(i).getTableID()==tableID) {
				tables.remove(i);
				return 1;
			}
		}
		return -1;
	}

	/**
	 * Checks whether a table is available, i.e., neither occupied nor reserved.
	 * @param tableID	the ID of the table
	 * @return 			true if table is available, false if it isn't or if it doesn't exist
	 */
	public boolean checkAvailability(int tableID) {
		for(int i=0; i<tables.size(); ++i) {
			if(tables.get(i).getTableID()==tableID) {
				if (tables.get(i).getIsOccupied() == true || tables.get(i).getIsReserved() == true) {
					return false;
				}
				else {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks whether there is any table available for the given pax size.
	 * @param paxSize	the pax size of the reservation to be made
	 * @return 			true if the restaurant is full for this size, false if it isn't
	 */
	public boolean checkFull(int paxSize) {
		
		for(int i=0; i<tables.size();++i) {
			if ((tables.get(i).getIsOccupied() == false & tables.get(i).getIsReserved() == false)&tables.get(i).getTableSize()>=paxSize) {
				return false;
			}
		}	
		return true;

	}

	/**
	 * Assigns a table to a given reservation.
	 * @param reservation	the reservation that needs to be assigned a table
	 * @return 				the table assigned to the reservation, -1 if no table found
	 */
	public int assignTable(Reservation res) {
		for(int i=0; i<Restaurant.tables.size(); ++i) {
			if((Restaurant.tables.get(i).getIsOccupied()==false&Restaurant.tables.get(i).getIsReserved()==false)&Restaurant.tables.get(i).getTableSize()>=res.getPaxSize()) {
				res.setAssignedTable(Restaurant.tables.get(i));
				Restaurant.tables.get(i).setIsReserved(true);
				Restaurant.tables.get(i).setReservation(res);
				for(int j=0; j<Restaurant.reservations.size();++j) {
					if(Restaurant.reservations.get(j).getResID()==res.getResID()) {
						Restaurant.reservations.get(j).setAssignedTable(Restaurant.tables.get(i));
					}
				}
				return Restaurant.tables.get(i).getTableID();
			}
		}
		return -1;
	}

}