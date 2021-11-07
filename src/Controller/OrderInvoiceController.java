package Controller;

import java.util.ArrayList;
import java.util.Date;

import Entity.OrderInvoice;
import Entity.Restaurant;

public class OrderInvoiceController {
	
	private static ArrayList<OrderInvoice> invoices = Restaurant.invoices;
	
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
	
	/**
	 * 
	 * @param idxTable
	 */
	public void printInvoiceAndVacate(int idxTable) {
		invoices.get(idxTable).printInvoice();
		tables.get(idxTable).setIsOccupied(false);
	}
}
