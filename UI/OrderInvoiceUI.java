package UI;
import java.util.Date;
import java.util.Objects;

import Entity.Order;
import Entity.Table;

public class OrderInvoiceUI {

	private Date timestamp;
	private static double serviceChargeRate = 0.1;
	private static double gsTaxRate = 0.09;
	private static double memberDiscountRate = 0.1;
	private double serviceCharge;
	private double gsTax;
	private double memberDiscount;
	private double finalCost;
	private Order order;
	private Table table;

	/**
	 * 
	 * @param timestamp
	 * @param order
	 */
	public OrderInvoiceUI(Date timestamp, Order order) {
		this.timestamp = timestamp;
		this.order = order;
		computeFinalCost();
	}

	public void printInvoice() {
		System.out.println();
		System.out.println("***** Invoice *****");
		System.out.println("Billing time: " + timestamp);
		this.order.display();
		System.out.println("Service charge: "+this.serviceCharge);
		System.out.println("GST: "+this.gsTax);
		System.out.println("Member discount: -"+this.memberDiscount);
		System.out.println();
		System.out.println("Total: "+this.finalCost);
		
		
	}

	public void computeFinalCost() {
		if (!Objects.equals(this.order.getMemberID(),"")) {
			this.memberDiscount = Math.round(this.order.getTotalCost() * memberDiscountRate*100.0)/100.0;
		}
		else {
			this.memberDiscount = 0;
		}
		this.serviceCharge = Math.round(this.order.getTotalCost() * serviceChargeRate*100.0)/100.0;
		this.gsTax = Math.round(this.order.getTotalCost() * gsTaxRate*100.0)/100.0;
		
		this.finalCost = Math.round((this.order.getTotalCost()+this.gsTax+this.serviceCharge-this.memberDiscount)*100.0)/100.0;
		
		
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

	public static double getServiceChargeRate() {
		return serviceChargeRate;
	}

	/**
	 * 
	 * @param serviceCharge
	 */
	public static void setServiceChargeRate(double serviceCharge) {
		serviceChargeRate = serviceCharge;
	}

	public static double getGsTaxRate() {
		return gsTaxRate;
	}

	/**
	 * 
	 * @param gsTax
	 */
	public static void setGsTaxRate(double gsTax) {
		gsTaxRate = gsTax;
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

	public double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public double getGsTax() {
		return gsTax;
	}

	public void setGsTax(double gsTax) {
		this.gsTax = gsTax;
	}

	public static double getMemberDiscountRate() {
		return memberDiscountRate;
	}

	public static void setMemberDiscountRate(double memberDiscountRate) {
		OrderInvoiceUI.memberDiscountRate = memberDiscountRate;
	}

	public double getMemberDiscount() {
		return memberDiscount;
	}

	public void setMemberDiscount(double memberDiscount) {
		this.memberDiscount = memberDiscount;
	}

}