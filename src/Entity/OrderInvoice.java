package Entity;
import java.util.Date;
import java.util.Objects;

/**
 * Represents an invoice.
 */
public class OrderInvoice {

	/**
	 * The service charge rate.
	 */
	private static double serviceChargeRate = 0.1;
	
	/**
	 * The GST rate.
	 */
	private static double gsTaxRate = 0.09;
	
	/**
	 * The discount rate for members.
	 */
	private static double memberDiscountRate = 0.1;
	
	/**
	 * Time the invoice was generated.
	 */
	private Date timestamp;
	
	/**
	 * The service charge for this invoice.
	 */
	private double serviceCharge;
	
	/**
	 * The GST charged for this invoice.
	 */
	private double gsTax;
	
	/**
	 * The member discount, if any, for this invoice.
	 */
	private double memberDiscount;
	
	/**
	 * The final cost for the order.
	 */
	private double finalCost;
	
	/**
	 * The order for which the invoice is generated.
	 */
	private Order order;
	
	/**
	 * The table at which the invoice is generated.
	 */
	private Table table;

	/**
	 * Constructor that initializes the invoice based on the time and order.
	 * @param timestamp	the time the invoice is generated
	 * @param order		the order for which the invoice is generated
	 */
	public OrderInvoice(Date timestamp, Order order) {
		this.timestamp = timestamp;
		this.order = order;
		this.table = order.getTable();
		computeFinalCost();
	}

	/**
	 * Prints the invoice.
	 */
	public void printInvoice() {
		System.out.println();
		System.out.println("***** Invoice *****");
		System.out.println("Billing time: " + timestamp);
		this.order.display();
		System.out.println("Service charge ("+serviceChargeRate*100+"%): "+this.serviceCharge);
		System.out.println("GST ("+gsTaxRate*100+"%): "+this.gsTax);
		System.out.println("Member discount ("+memberDiscountRate*100+"%): -"+this.memberDiscount);
		System.out.println();
		System.out.println("Total: "+this.finalCost);
		
		
	}

	/**
	 * Computes the final cost based on price of items, service charge, GST, and member discount.
	 */
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

	/**
	 * Gets this invoice's timestamp.
	 * @return  the timestamp of this invoice.
	 */
	public Date getTimestamp() {
		return this.timestamp;
	}

	/**
	 * Updates the timestamp of this invoice, in case it was incorrectly generated.
	 * @param timestamp		the new timestamp of this invoice
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Gets the final cost of this invoice.
	 * @return 	the final cost of this invoice
	 */
	public double getFinalCost() {
		return this.finalCost;
	}

	/**
	 * Updates the final cost of this invoice, in case a manual override is needed.
	 * @param finalCost		the new final cost of this invoice
	 */
	public void setFinalCost(double finalCost) {
		this.finalCost = finalCost;
	}

	/**
	 * Gets the order for which this invoice is generated.
	 * @return 		the order for which this invoice is generated
	 */
	public Order getOrder() {
		return this.order;
	}

	/**
	 * Updates the order for which this invoice is generated.
	 * @param order		the new order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * Gets the table at which this invoice is generated.
	 * @return 	the table at which this invoice is generated
	 */
	public Table getTable() {
		return this.table;
	}

	/**
	 * Updates the table at which this invoice is generated.
	 * @param table		the new table at which this invoice is generated
	 */
	public void setTable(Table table) {
		this.table = table;
	}

	/**
	 * Gets the service charge amount for this invoice.
	 * @return	the service charge amount
	 */
	public double getServiceCharge() {
		return serviceCharge;
	}

	/**
	 * Updates the service charge amount for this invoice.
	 * @param serviceCharge		the new service charge amount
	 */
	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	/**
	 * Gets the GST amount for this invoice.
	 * @return	the GST amount
	 */
	public double getGsTax() {
		return gsTax;
	}

	/**
	 * Updates the GST amount for this invoice.
	 * @param gsTax		the new GST amount
	 */
	public void setGsTax(double gsTax) {
		this.gsTax = gsTax;
	}

	/**
	 * Gets the member discount amount for this invoice.
	 * @return		the member discount amount
	 */
	public double getMemberDiscount() {
		return memberDiscount;
	}

	/**
	 * Updates the member discount amount for this invoice.
	 * @param memberDiscount	the new member discount amount
	 */
	public void setMemberDiscount(double memberDiscount) {
		this.memberDiscount = memberDiscount;
	}

	/**
	 * Gets the restaurant's service charge rate.
	 * @return	the service charge rate
	 */
	public static double getServiceChargeRate() {
		return serviceChargeRate;
	}

	/**
	 * Updates the restaurant's service charge rate, in case there is a change in the restaurant's policy.
	 * @param serviceCharge	the new service charge rate
	 */
	public static void setServiceChargeRate(double serviceCharge) {
		serviceChargeRate = serviceCharge;
	}

	/**
	 * Gets the current GST rate levied by the government.
	 * @return	the GST rate levied
	 */
	public static double getGsTaxRate() {
		return gsTaxRate;
	}

	/**
	 * Updates the GST rate, in case there is a change in government policy.
	 * @param gsTax	the new GST rate
	 */
	public static void setGsTaxRate(double gsTax) {
		gsTaxRate = gsTax;
	}

	/**
	 * Gets the current member discount rate offered by the restaurant's group.
	 * @return	the current member discount rate
	 */
	public static double getMemberDiscountRate() {
		return memberDiscountRate;
	}

	/**
	 * Updates the member discount rate, in case there is a change in the restaurant group's policy.
	 * @param memberDiscountRate	the new member discount rate
	 */
	public static void setMemberDiscountRate(double memberDiscountRate) {
		OrderInvoice.memberDiscountRate = memberDiscountRate;
	}

}