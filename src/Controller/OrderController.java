package Controller;
import java.util.Date;
import java.util.Objects;
import java.util.ArrayList;

import Entity.Menu;
import Entity.Order;
import Entity.OrderedItem;
import Entity.OrderedSet;
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
	 * @param orderID		the ID of the order
	 * @param tableID		the ID of the order's table
	 * @param creatorID		the ID of the order's creator
	 * @param itemIndices	the indices of the menu items in the order
	 * @param itemQtys		the quantities of the respective items
	 * @param setIndices	the indices of the sets in the order
	 * @param setQtys		the quantities of the respective sets
	 */
	public void createOrder(int orderID, int tableID, int creatorID, ArrayList<Integer> itemIndices, ArrayList<Integer> itemQtys, ArrayList<Integer> setIndices, ArrayList<Integer> setQtys, String memberID)  {
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
		
		Date timestamp = new Date();
		
		Order order;
		
		if(Objects.equals(memberID, "no")) {
			order = new Order(orderID, table, creator, orderedItems, orderedSets, true, timestamp);
		}
		else {
			order = new Order(orderID, table, creator, orderedItems, orderedSets, true, timestamp, memberID);
		}
		
		orders.add(order);
	}

	/**
	 * Displays an order with the given ID.
	 * @param idxOrder	ID of the order
	 * @return			1 if successfully displayed, -1 if order not found
	 */
	public int viewOrder(int idOrder) {
		
		if(idOrder==0) {
			for(int i=0; i<orders.size(); ++i) {
				orders.get(i).display();
			}
			return 1;
		}
		
		for(int i=0; i<orders.size(); ++i) {
			if(orders.get(i).getOrderID()==idOrder) {
				orders.get(i).display();
				return 1;
			}
		}
		return -1;
		
	}

	/**
	 * Removes an order with the given ID.
	 * @param idOrder	ID of the order to be removed
	 * @return			1 if successfully removed, -1 if order not found
	 */
	public int removeOrder(int idOrder) {
		
		for(int i=0; i<orders.size(); ++i) {
			if(orders.get(i).getOrderID()==idOrder) {
				orders.remove(i);
				return 1;
			}
		}
		return -1;
	}

	/**
	 * Adds a menu item to an order with the given ID.
	 * @param idOrder		ID of the order
	 * @param quantity		Quantity of the item
	 * @param menuItemID	ID of the menu item
	 * @return 				1 if successfully added, -1 if item or order not found
	 */
	public int addItemToOrder(int idOrder, int quantity, int menuItemID) {
		
		for(int i=0; i<orders.size(); ++i) {
			if(orders.get(i).getOrderID()==idOrder) {
				for(int j=0; j<menu.getMenuItems().size(); ++j) {
					if(menu.getMenuItems().get(j).getItemID()==menuItemID) {
						orders.get(i).addOrderedItem(new OrderedItem(quantity, menu.getMenuItems().get(j)));
						return 1;
					}
				}
				return -1;
			}
		}
		return -1;
	}

	/**
	 * Adds a promotion set to an order with the given ID.
	 * @param idOrder		ID of the order
	 * @param quantity		Quantity of the set
	 * @param promoSetID	ID of the menu set
	 * @return 				1 if successfully added, -1 if set or order not found
	 */
	public int addSetToOrder(int idOrder, int quantity, int promoSetID) {
		
		for(int i=0; i<orders.size(); ++i) {
			if(orders.get(i).getOrderID()==idOrder) {
				for(int j=0; j<menu.getPromotionSets().size(); ++j) {
					if(menu.getPromotionSets().get(j).getPromoID()==promoSetID) {
						orders.get(i).addOrderedSet(new OrderedSet(quantity, menu.getPromotionSets().get(j)));
						return 1;
					}
				}
				return -1;
			}
		}
		return -1;
	}

	/**
	 * Removes a menu item from an order with the given ID.
	 * @param idOrder		ID of the order
	 * @param quantity		Quantity of the item
	 * @param menuItemID	ID of the menu item
	 * @return 				1 if successfully removed, -1 if item or order not found
	 */
	public int removeItemFromOrder(int idOrder, int quantity, int menuItemID) {
		
		for(int i=0; i<orders.size(); ++i) {
			if(orders.get(i).getOrderID()==idOrder) {
				for(int j=0; j<menu.getMenuItems().size(); ++j) {
					if(menu.getMenuItems().get(j).getItemID()==menuItemID) {
						orders.get(i).removeOrderedItem(new OrderedItem(quantity, menu.getMenuItems().get(j)));
						return 1;
					}
				}
				return -1;
			}
		}
		return -1;
	}

	/**
	 * Removes a set from an order with the given ID.
	 * @param idOrder		ID of the order
	 * @param quantity		Quantity of the set
	 * @param promoSetID	ID of the menu set
	 * @return 				1 if successfully removed, -1 if set or order not found
	 */
	public int removeSetFromOrder(int idOrder, int quantity, int promoSetID) {
		
		for(int i=0; i<orders.size(); ++i) {
			if(orders.get(i).getOrderID()==idOrder) {
				for(int j=0; j<menu.getPromotionSets().size(); ++j) {
					if(menu.getPromotionSets().get(j).getPromoID()==promoSetID) {
						orders.get(i).removeOrderedSet(new OrderedSet(quantity, menu.getPromotionSets().get(j)));
						return 1;
					}
				}
				return -1;
			}
		}
		return -1;
	}

}