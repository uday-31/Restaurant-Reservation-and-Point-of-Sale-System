package Controller;
import java.util.ArrayList;

import Entity.Menu;
import Entity.MenuItem;
import Entity.Order;
import Entity.OrderedItem;
import Entity.OrderedSet;
import Entity.PromotionSet;
import Entity.Restaurant;
import Entity.Staff;
import Entity.Table;

public class OrderController {

	private static ArrayList<Order> orders = Restaurant.orders;
	private static Menu menu = Restaurant.menu;
	private static ArrayList<Staff> staffs = Restaurant.staffs;
	private static ArrayList<Table> tables = Restaurant.tables;

	/**
	 * 
	 * @param idxOrder
	 * @param idxTable
	 * @param idxCreator
	 * @param orderedItems
	 * @param orderedSets
	 */
	public void createOrder(int orderID, Table table, Staff creator, ArrayList<OrderedItem> orderedItems, ArrayList<OrderedSet> orderedSets)  {
		Order order = new Order(orderID, table, creator, orderedItems, orderedSets);
		orders.add(order);
	}

	/**
	 * 
	 * @param idxOrder
	 */
	public void viewOrder(int idxOrder) {
		System.out.println();
		System.out.println("Order ID: " + orders.get(idxOrder).getOrderID());
		System.out.println("Table ID: " + orders.get(idxOrder).getTable().getTableID());
		System.out.println("Created by: " + orders.get(idxOrder).getCreator());
		
		System.out.println("***** List of Ordered Items *****");
		for (int i=0; i<orders.get(idxOrder).getOrderedItems().size(); i++) {
			orders.get(idxOrder).viewOrderedItem(i);
		}
		
		System.out.println("***** List of Ordered Sets *****");
		for (int j=0; j<orders.get(idxOrder).getOrderedSets().size(); j++) {
			orders.get(idxOrder).viewOrderedSet(j);
		}
		
	}

	/**
	 * 
	 * @param idxOrder
	 */
	public void removeOrder(int idxOrder) {
		int id = orders.get(idxOrder).getOrderID();
		orders.remove(idxOrder);
		System.out.println("Order " + id + " successfully removed");
	}

	/**
	 * 
	 * @param idxOrder
	 * @param quantity
	 * @param idxItem
	 */
	public void addItemToOrder(int idxOrder, int quantity, MenuItem menuitem) {
		OrderedItem ordereditem = new OrderedItem(quantity, menuitem);
		orders.get(idxOrder).getOrderedItems().add(ordereditem);
		System.out.println("Successfully added Item " + menuitem.getName() + " with quantity " + quantity);
	}

	/**
	 * 
	 * @param idxOrder
	 * @param quantity
	 * @param idxSet
	 */
	public void addSetToOrder(int idxOrder, int quantity, PromotionSet promotionset) {
		OrderedSet orderedset = new OrderedSet(quantity, promotionset);
		orders.get(idxOrder).getOrderedSets().add(orderedset);
		System.out.println("Successfully added Set " + promotionset.getName() + " with quantity " + quantity);
	}

	/**
	 * 
	 * @param idxOrder
	 * @param idxItem
	 */
	public void removeItemFromOrder(int idxOrder, OrderedItem ordereditem) {
		orders.get(idxOrder).getOrderedItems().remove(ordereditem);
		System.out.println("Successfully removed Item " + ordereditem.getMenuItem().getName() + "from order");
	}

	/**
	 * 
	 * @param idxOrder
	 * @param idxSet
	 */
	public void removeSetFromOrder(int idxOrder, OrderedSet orderedset) {
		orders.get(idxOrder).getOrderedSets().remove(orderedset);
		System.out.println("Successfully removed Set " + orderedset.getPromotionSet().getName() + "from order");
	}

}