package Entity;
import java.util.Date;

import java.util.ArrayList;

public class Order {

	private int orderID;
	private Table table;
	private Staff creator;
	private ArrayList<OrderedItem> orderedItems;
	private ArrayList<OrderedSet> orderedSets;
	private double totalCost;
	private boolean completed;
	private Date timestamp;

	/**
	 * 
	 * @param orderID
	 * @param tableID
	 * @param creator
	 * @param orderedItems
	 * @param orderedSets
	 */
	public Order(int orderID, Table table, Staff creator, ArrayList<OrderedItem> orderedItems, ArrayList<OrderedSet> orderedSets, boolean completed, Date timestamp) {
		this.orderID = orderID;
		this.table = table;
		this.creator = creator;
		this.orderedItems = orderedItems;
		this.orderedSets = orderedSets;
		this.timestamp = timestamp;
		this.completed = completed;
	}

	public int getOrderID() {
		return this.orderID;
	}

	/**
	 * 
	 * @param orderID
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Staff getCreator() {
		return this.creator;
	}

	/**
	 * 
	 * @param creator
	 */
	public void setCreator(Staff creator) {
		this.creator = creator;
	}

	public ArrayList<OrderedItem> getOrderedItems() {
		return this.orderedItems;
	}

	/**
	 * 
	 * @param orderedItems
	 */
	public void setOrderedItems(ArrayList<OrderedItem> orderedItems) {
		this.orderedItems = orderedItems;
	}

	/**
	 * 
	 * @param orderedItem
	 */
	public void addOrderedItem(OrderedItem orderedItem) {
		orderedItems.add(orderedItem);
	}

	/**
	 * 
	 * @param orderedItem
	 */
	public void removeOrderedItem(OrderedItem orderedItem) {
		orderedItems.remove(orderedItem);
	}

	/**
	 * 
	 * @param itemID
	 */
	public void viewOrderedItem(int idx) {
		System.out.println();
		System.out.println("Item Ordered:" + orderedItems.get(idx).getMenuItem().getName());
		System.out.println("Quantity Ordered:" + orderedItems.get(idx).getQuantity());
		System.out.println("Cost: " + orderedItems.get(idx).getCost());
	}

	public ArrayList<OrderedSet> getOrderedSets() {
		return this.orderedSets;
	}

	/**
	 * 
	 * @param orderedSets
	 */
	public void setOrderedSets(ArrayList<OrderedSet> orderedSets) {
		this.orderedSets = orderedSets;
	}

	/**
	 * 
	 * @param orderedSet
	 */
	public void addOrderedSet(OrderedSet orderedSet) {
		orderedSets.add(orderedSet);
	}

	/**
	 * 
	 * @param orderedSet
	 */
	public void removeOrderedSet(OrderedSet orderedSet) {
		orderedSets.remove(orderedSet);
	}

	/**
	 * 
	 * @param setID
	 */
	public void viewOrderedSet(int idx) {
		System.out.println();
		System.out.println("Set Ordered:" + orderedSets.get(idx).getPromotionSet().getName());
		System.out.println("Quantity Ordered:" + orderedSets.get(idx).getQuantity());
		System.out.println("Cost: " + orderedSets.get(idx).getCost());
	}


	public void computeTotalCost() {
		for (int i=0; i <orderedItems.size(); i++) {
			totalCost += orderedItems.get(i).getCost();
		}
		
		for (int j=0; j <orderedSets.size(); j++) {
			totalCost += orderedSets.get(j).getCost();
		}
	}
	
	public double getTotalCost() {
		return this.totalCost;
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

	public boolean getCompleted() {
		return this.completed;
	}

	/**
	 * 
	 * @param completed
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
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

}