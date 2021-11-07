package Controller;

import java.util.ArrayList;
import java.util.Date;

import Entity.Order;
import Entity.OrderInvoice;
import Entity.Restaurant;
import Entity.Table;

/**
 * Controller class handling the restaurant's invoices.
 */
public class OrderInvoiceController {
	
	/**
	 * The restaurant's invoices.
	 */
	private static ArrayList<OrderInvoice> invoices = Restaurant.invoices;
	
	/**
	 * The restaurant's tables.
	 */
	private static ArrayList<Table> tables = Restaurant.tables;
	
	/**
	 * Prints the sales revenue report for a given time period.
	 * @param startDate	the starting date
	 * @param endDate	the ending date
	 */
	public void printSalesRevenueReport(Date startDate, Date endDate) {
		double total = 0;
		for (int i=0; i<invoices.size(); i++) {
			if (invoices.get(i).getTimestamp().after(startDate) && invoices.get(i).getTimestamp().before(endDate)) {
				total += invoices.get(i).getFinalCost();
				invoices.get(i).printInvoice();
			}
				
		}
		System.out.println();
		System.out.println("Total Revenue: " + Math.round(total*100.0)/100.0);
	}
	
	/**
	 * Completes the order at a table and vacates it.
	 * @param tableID	the ID of the table
	 * @return 			1 if done successfully, -1 if table not found
	 */
	public int printInvoiceAndVacate(int tableID) {
		Order currentOrder;
		Date timestamp = new Date();
		for(int i =0; i<tables.size(); ++i) {
			if(tables.get(i).getTableID()==tableID) {
				currentOrder = tables.get(i).getCurrentOrder();
				currentOrder.setCompleted(true);
				tables.get(i).setCurrentOrder(null);
				tables.get(i).setIsOccupied(false);
				OrderInvoice invoice = new OrderInvoice(timestamp, currentOrder);
				invoice.printInvoice();
				invoices.add(invoice);
				return 1;
			}
		}
		return -1;
	}
}
