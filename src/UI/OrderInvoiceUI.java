package UI;

import java.util.Date;

public class OrderInvoiceUI {


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
