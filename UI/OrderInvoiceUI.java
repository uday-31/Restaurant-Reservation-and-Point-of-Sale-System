package UI;
import java.util.Date;

import Entity.Order;
import Entity.Table;

public class OrderInvoiceUI {

	private Date timestamp;
	private double serviceCharge;
	private double gsTax;
	private boolean isMember;
	private double finalCost;
	private Order order;
	private Table table;

	/**
	 * 
	 * @param timestamp
	 * @param isMember
	 * @param order
	 */
	public OrderInvoiceUI(Date timestamp, boolean isMember, Order order) {
		this.timestamp = timestamp;
		this.isMember = isMember;
		this.order = order;
	}

	public void printInvoice() {
		System.out.println();
		System.out.println("***** Invoice ******");
		System.out.println("Timestamp: " + timestamp);
		System.out.println("Table no: " + table.getTableID());
		
		System.out.println("***** List of Ordered Items *****");
		for (int i=0; i<order.getOrderedItems().size(); i++) {
			order.viewOrderedItem(i);
		}
		
		System.out.println("***** List of Ordered Sets *****");
		for (int j=0; j<order.getOrderedSets().size(); j++) {
			order.viewOrderedSet(j);
		}
		
		
	}

	public void computeFinalCost() {
		if (isMember == true) {
			finalCost = order.getTotalCost() * 0.9 * (1 + serviceCharge + gsTax); //offer 10% discount if member
		}
		else {
			finalCost = order.getTotalCost() * (1 + serviceCharge + gsTax);
		}
		
		
		
		
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	/**
	 * 
	 * @param timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public double getServiceCharge() {
		return this.serviceCharge;
	}

	/**
	 * 
	 * @param serviceCharge
	 */
	public void setServiceCharge(int serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public double getGsTax() {
		return this.gsTax;
	}

	/**
	 * 
	 * @param gsTax
	 */
	public void setGsTax(int gsTax) {
		this.gsTax = gsTax;
	}

	public boolean getIsMember() {
		return this.isMember;
	}

	/**
	 * 
	 * @param isMember
	 */
	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}

	public double getFinalCost() {
		return this.finalCost;
	}

	/**
	 * 
	 * @param finalCost
	 */
	public void setFinalCost(double finalCost) {
		this.finalCost = finalCost;
	}

	public Order getOrder() {
		return this.order;
	}

	/**
	 * 
	 * @param order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	public Table getTable() {
		return this.table;
	}

	/**
	 * 
	 * @param table
	 */
	public void setTable(Table table) {
		this.table = table;
	}

}