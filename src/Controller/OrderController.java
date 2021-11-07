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

/**
 * Controller class handling the restaurant's orders.
 */
public class OrderController {

	/**
	 * The restaurant's orders.
	 */
	private static ArrayList<Order> orders = Restaurant.orders;
	
	/**
	 * The restaurant's menu.
	 */
	private static Menu menu = Restaurant.menu;
	
	/**
	 * The restaurant's staffs.
	 */
	private static ArrayList<Staff> staffs = Restaurant.staffs;
	
	/**
	 * The restaurant's tables.
	 */
	private static ArrayList<Table> tables = Restaurant.tables;

	/**
	 * Creates an order based on the given input.
	 * @param orderID
	 * @param table
	 * @param creator
	 * @param itemIndices
	 * @param itemQtys
	 * @param setIndices
	 * @param setQtys
	 */
	public void createOrder(int orderID, int tableID, int creatorID, ArrayList<Integer> itemIndices, ArrayList<Integer> itemQtys, ArrayList<Integer> setIndices, ArrayList<Integer> setQtys)  {
		Table table = tables.get(tableID-1);
		Staff creator = staffs.get(creatorID-1);
		
		ArrayList<OrderedItem> orderedItems = new ArrayList<OrderedItem>();
		for(int i=0; i<itemIndices.size();++i) {
			orderedItems.add(new OrderedItem(itemQtys.get(i), menu.getMenuItems().get(itemIndices.get(i)-1)));
		}
		
		ArrayList<OrderedSet> orderedSets = new ArrayList<OrderedSet>();
		for(int i=0; i<setIndices.size();++i) {
			orderedSets.add(new OrderedSet(setQtys.get(i), menu.getPromotionSets().get(setIndices.get(i)-1)));
		}
		
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