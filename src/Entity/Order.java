package Entity;
import java.util.Date;

import java.util.ArrayList;

/**
 * Represents an order containing menu items and sets.
 */
public class Order {

	/**
	 * Serial number of the order.
	 */
	private int orderID;
	
	/**
	 * Table this order is served at.
	 */
	private Table table;
	
	/**
	 * Staff that created the order.
	 */
	private Staff creator;
	
	/**
	 * Menu items ordered along with respective quantities.
	 */
	private ArrayList<OrderedItem> orderedItems;
	
	/**
	 * Menu sets ordered along with respective quantities.
	 */
	private ArrayList<OrderedSet> orderedSets;
	
	/**
	 * Total cost of the items and sets.
	 */
	private double totalCost;
	
	/**
	 * Whether the order is completed or not.
	 */
	private boolean completed;
	
	/**
	 * Time the order was created.
	 */
	private Date timestamp;
	
	/**
	 * Member ID if the customer is a member of the restaurant's rewards program, blank otherwise.
	 */
	private String memberID;

	/**
	 * Initializes the order when the customer is a member, and computes the total cost.
	 * @param orderID		the serial number of the order
	 * @param table			the table at which the order is served
	 * @param creator		the staff who created the order
	 * @param orderedItems	the menu items ordered
	 * @param orderedSets	the promotion sets ordered
	 * @param completed		whether the order is been completed and payment made
	 * @param timestamp		the time the order was placed
	 * @param memberID		the membership ID of the customer
	 */
	public Order(int orderID, Table table, Staff creator, ArrayList<OrderedItem> orderedItems, ArrayList<OrderedSet> orderedSets, boolean completed, Date timestamp, String memberID) {
		this.orderID = orderID;
		this.table = table;
		this.creator = creator;
		this.orderedItems = orderedItems;
		this.orderedSets = orderedSets;
		this.timestamp =timestamp;
		this.completed = completed;
		this.memberID = memberID;
		computeTotalCost();
	}
	
	/**
	 * Initializes the order when the customer is not a member, and computes the total cost.
	 * @param orderID		the serial number of the order
	 * @param table			the table at which the order is served
	 * @param creator		the staff who created the order
	 * @param orderedItems	the menu items ordered
	 * @param orderedSets	the promotion sets ordered
	 * @param completed		whether the order is been completed and payment made
	 * @param timestamp		the time the order was placed
	 */
	public Order(int orderID, Table table, Staff creator, ArrayList<OrderedItem> orderedItems, ArrayList<OrderedSet> orderedSets, boolean completed, Date timestamp) {
		this.orderID = orderID;
		this.table = table;
		this.creator = creator;
		this.orderedItems = orderedItems;
		this.orderedSets = orderedSets;
		this.timestamp =timestamp;
		this.completed = completed;
		this.memberID = "";
		computeTotalCost();
	}

	/**
	 * Gets the serial number of this order.
	 * @return	the serial number of this order
	 */
	public int getOrderID() {
		return this.orderID;
	}

	/**
	 * Updates the serial number of this order, in case new orders are added before.
	 * @param orderID	the new serial number of this order
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	/**
	 * Gets the member ID of the customer who placed this order.
	 * @return	the member ID, blank if the customer is not a number
	 */
	public String getMemberID() {
		return this.memberID;
	}

	/**
	 * Updates the member ID of the customer who placed this order, in case it was recorded incorrectly.
	 * @param memberID	the new member ID of the customer
	 */
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	/**
	 * Gets the details of the staff who created this order.
	 * @return	the details of the staff
	 */
	public Staff getCreator() {
		return this.creator;
	}

	/**
	 * Updates the details of the staff who created this order, in case the order is re-assigned.
	 * @param creator	the new staff who created this order
	 */
	public void setCreator(Staff creator) {
		this.creator = creator;
	}

	/**
	 * Gets the list of items ordered.
	 * @return	the items ordered
	 */
	public ArrayList<OrderedItem> getOrderedItems() {
		return this.orderedItems;
	}

	/**
	 * Updates the list of items ordered, in case it was recorded incorrectly, and updates the cost.
	 * @param orderedItems	the new list of items ordered
	 */
	public void setOrderedItems(ArrayList<OrderedItem> orderedItems) {
		this.orderedItems = orderedItems;
		computeTotalCost();
	}

	/**
	 * Adds an item to the list of ordered items and computes the cost.
	 * @param orderedItem	the new item to be added.
	 */
	public void addOrderedItem(OrderedItem orderedItem) {
		
		for(int i=0; i<this.orderedItems.size();++i) {
			if(this.orderedItems.get(i).getMenuItem().getItemID()==orderedItem.getMenuItem().getItemID()) {
				
				int qtyOld = orderedItems.get(i).getQuantity();
				int qtyNew = orderedItem.getQuantity();
				orderedItems.get(i).setQuantity(qtyOld+qtyNew);

				computeTotalCost();
				return;
			}
		}
		
		orderedItems.add(orderedItem);
		computeTotalCost();
	}

	/**
	 * Removes an item from the list of ordered items and computes the cost.
	 * @param orderedItem	the item to be removed
	 */
	public void removeOrderedItem(OrderedItem orderedItem) {
		for(int i=0; i<this.orderedItems.size();++i) {
			if(this.orderedItems.get(i).getMenuItem().getItemID()==orderedItem.getMenuItem().getItemID()) {
				
				int qtyOld = orderedItems.get(i).getQuantity();
				int qtyNew = orderedItem.getQuantity();
				if(qtyOld>qtyNew) {
					orderedItems.get(i).setQuantity(qtyOld-qtyNew);
				}
				else {
					orderedItems.remove(i);
				}
				computeTotalCost();
				return;
			}
		}
	}

	/**
	 * Displays an item from the list of ordered items.
	 * @param idx	the serial number of the item to be displayed
	 */
	public void viewOrderedItem(int idx) {
		System.out.println();
		System.out.println("Item Ordered:" + orderedItems.get(idx).getMenuItem().getName());
		System.out.println("Quantity Ordered:" + orderedItems.get(idx).getQuantity());
		System.out.println("Cost: " + orderedItems.get(idx).getCost());
	}

	/**
	 * Gets the promotional sets ordered.
	 * @return	the sets ordered
	 */
	public ArrayList<OrderedSet> getOrderedSets() {
		return this.orderedSets;
	}

	/**
	 * Updates the list of promotional sets ordered, in case it is recorded incorrectly, and updates the cost.
	 * @param orderedSets	the new list of promotional sets
	 */
	public void setOrderedSets(ArrayList<OrderedSet> orderedSets) {
		this.orderedSets = orderedSets;
		computeTotalCost();
	}

	/**
	 * Adds a promotional set to the list of ordered sets and updates the cost.
	 * @param orderedSet	the set to be added
	 */
	public void addOrderedSet(OrderedSet orderedSet) {
		
		for(int i=0; i<this.orderedSets.size();++i) {
			if(this.orderedSets.get(i).getPromotionSet().getPromoID()==orderedSet.getPromotionSet().getPromoID()) {
				int qtyOld = orderedSets.get(i).getQuantity();
				int qtyNew = orderedSet.getQuantity();
				orderedSets.get(i).setQuantity(qtyOld+qtyNew);
				computeTotalCost();
				return;
			}
		}
		orderedSets.add(orderedSet);
		computeTotalCost();
	}

	/**
	 * Removes a promotional set from the list of ordered sets and updates the cost.
	 * @param orderedSet	the set to be removed
	 */
	public void removeOrderedSet(OrderedSet orderedSet) {
		
		for(int i=0; i<this.orderedSets.size();++i) {
			if(this.orderedSets.get(i).getPromotionSet().getPromoID()==orderedSet.getPromotionSet().getPromoID()) {
				int qtyOld = orderedSets.get(i).getQuantity();
				int qtyNew = orderedSet.getQuantity();
				if(qtyOld>qtyNew) {
					orderedSets.get(i).setQuantity(qtyOld-qtyNew);
				}
				else {
					orderedSets.remove(i);
				}
				computeTotalCost();
				return;
			}
		}
	}

	/**
	 * Displays a set from the list of promotional sets ordered.
	 * @param idx	the serial number of the set to be displayed
	 */
	public void viewOrderedSet(int idx) {
		System.out.println();
		System.out.println("Set Ordered:" + orderedSets.get(idx).getPromotionSet().getName());
		System.out.println("Quantity Ordered:" + orderedSets.get(idx).getQuantity());
		System.out.println("Cost: " + orderedSets.get(idx).getCost());
	}

	/**
	 * Gets the table this order is served at.
	 * @return	the table this ordered is served at
	 */
	public Table getTable() {
		return this.table;
	}

	/**
	 * Updates the table this order is served at, in case the customer moves tables.
	 * @param table	the new table the order is served at
	 */
	public void setTable(Table table) {
		this.table = table;
	}

	/**
	 * Gets whether this order is completed and paid for or not.
	 * @return	whether the order is completed and paid for
	 */
	public boolean getCompleted() {
		return this.completed;
	}

	/**
	 * Updates the status of this order's completion, in case payment method fails or customer returns
	 * @param completed	the new status of whether the order is complete and paid for
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	/**
	 * Gets the time this order was placed.
	 * @return	the time this ordered was placed
	 */
	public Date getTimestamp() {
		return this.timestamp;
	}

	/**
	 * Updates the time this order was placed, in case it was recorded incorrectly.
	 * @param timestamp	the new time this order was placed at
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * Gets the total cost of this order before taxes and discounts.
	 * @return	the total cost
	 */
	public double getTotalCost() {
		return this.totalCost;
	}

	/**
	 * Displays the details of the order, including the time, server, table, member ID (if any), details of the items and sets ordered, and the cost before taxes and discounts. 
	 */
	public void display() {
		System.out.println();
		System.out.println("***Order Details***");
		System.out.println("Order ID: "+this.orderID);
		System.out.println("Time: "+this.timestamp);
		System.out.println("Server: "+this.creator.getName());
		System.out.println("Table: "+this.table.getTableID());
		if(memberID.length()>0) {
			System.out.println("Member ID: "+this.memberID);
		}
		System.out.println();
		if(this.orderedItems.size()>0) {
			System.out.println("Ordered items: ");
			for(int i=0; i<this.orderedItems.size(); ++i) {
				this.orderedItems.get(i).display();
			}
		}
		System.out.println();
		if(this.orderedSets.size()>0) {
			System.out.println("Ordered sets: ");
			for(int i=0; i<this.orderedSets.size(); ++i) {
				this.orderedSets.get(i).display();
			}
		}
		System.out.println();
		System.out.println("Sub-total: "+this.totalCost);
		
	}

	/**
	 * Computes the total cost of this order as the sum of prices of items and sets.
	 */
	private void computeTotalCost() {
		this.totalCost = 0;
		for (int i=0; i <orderedItems.size(); i++) {
			this.totalCost += orderedItems.get(i).getCost();
		}
		
		for (int j=0; j <orderedSets.size(); j++) {
			this.totalCost += orderedSets.get(j).getCost();
		}
	}

}