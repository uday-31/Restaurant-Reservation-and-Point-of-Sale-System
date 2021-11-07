package Controller;
import java.util.ArrayList;
import java.util.Date;

import Entity.Reservation;
import Entity.Restaurant;
import Entity.Table;
import UI.OrderInvoiceUI;

/**
 * Controller class handling the restaurant's tables.
 */
public class TableController {

	private static ArrayList<Table> tables = Restaurant.tables;
	private static ArrayList<OrderInvoiceUI> invoices = Restaurant.invoices;

	/**
	 * 
	 * @param tableID
	 * @param tableSize
	 */
	public void addTable(int tableID, int tableSize) {
		Table newtable = new Table(tableID, tableSize);
		tables.add(newtable);
		System.out.println("Table" + tableID + " successfully added");
	}

	/**
	 * 
	 * @param idxTable
	 */
	public void viewTable(int idxTable) {
		System.out.println();
		System.out.println("Table ID:" + tables.get(idxTable).getTableID() );
		System.out.println("Table Size:" + tables.get(idxTable).getTableSize());
		if (tables.get(idxTable).getIsOccupied() == true) {
			System.out.println("Table is Occupied");
		}
		else if (tables.get(idxTable).getIsReserved() == true) {
			System.out.println("Table is Reserved");
		}
		else {
			System.out.println("Table is Available");
		}
	}

	/**
	 * 
	 * @param idxTable
	 */
	public void removeTable(int idxTable) {
		int id = tables.get(idxTable).getTableID();
		tables.remove(idxTable);
		System.out.println("Table" + id + " successfully removed");
	}

	/**
	 * 
	 * @param idxTable
	 */
	public boolean checkAvailability(int idxTable) {
		if (tables.get(idxTable).getIsOccupied() == true || tables.get(idxTable).getIsReserved() == true) {
			return false;
		}
		else {
			return true;
		}

	}

	/**
	 * 
	 * @param reservation
	 */
	public void assignTable(Reservation reservation) {
		for (int i=0; i<tables.size(); i++) {
			if (checkAvailability(i) && (tables.get(i).getTableSize() >= reservation.getPaxSize())) {
				tables.get(i).setReservation(reservation);
				reservation.setAssignedTable(tables.get(i));
			}
		}
	}

	/**
	 * 
	 * @param idxTable
	 */
	public void printInvoiceAndVacate(int idxTable) {
		invoices.get(idxTable).printInvoice();
		tables.get(idxTable).setIsOccupied(false);
	}

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 */
	public void printSalesRevenueReport(Date startDate, Date endDate) {
		int total = 0;
		for (int i=0; i<invoices.size(); i++) {
			if (invoices.get(i).getTimestamp().after(startDate) && invoices.get(i).getTimestamp().before(endDate)) {
				total += invoices.get(i).getFinalCost();
				invoices.get(i).printInvoice();
			}
				
		}
		
		System.out.println("Total Revenue: " + total);
	}

}