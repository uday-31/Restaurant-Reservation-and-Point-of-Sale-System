package Controller;
import java.util.ArrayList;

import Entity.Menu;
import Entity.MenuItem;
import Entity.MenuItemType;
import Entity.PromotionSet;

/**
 * Controller class handling the restaurant's menu.
 */
public class MenuController {

	/**
	 * The restaurant's menu.
	 */
	private static Menu menu = Entity.Restaurant.menu;

	/**
	 * Display's the restaurant's menu.
	 */
	public void viewMenu() {
		menu.display();
	}

	/**
	 * Creates a menu item based on the given input.
	 * @param itemID	the item's serial number
	 * @param name		the item's name
	 * @param desc		the item's description
	 * @param price		the item's price
	 * @param type		the item's type
	 */
	public void createMenuItem(int itemID, String name, String desc, double price, MenuItemType type) {
		MenuItem newItem = new MenuItem(itemID, name, desc, price, type);
		menu.addMenuItem(newItem);
	}
	

	/**
	 * Removes a menu item from the menu at the given serial number.
	 * @param id	the serial number of the menu item to be removed
	 * @return		1 if successfully removed, -1 if item not found
	 */
	public int removeMenuItem(int id) {
		ArrayList<MenuItem> currItems = menu.getMenuItems();
		
		for(int i=0; i<menu.getMenuItems().size(); ++i) {
			if(currItems.get(i).getItemID()==id) {
				menu.removeMenuItem(i);
				return 1;
			}
		}
		return -1;
	}

	/**
	 * Updates the name of a menu item with the given ID.
	 * @param id	the ID of the menu item
	 * @param name	the new name of the menu item
	 */
	public int updateMenuItem(int id, String name) {
		ArrayList<MenuItem> currItems = menu.getMenuItems();
		
		for(int i=0; i<menu.getMenuItems().size(); ++i) {
			if(currItems.get(i).getItemID()==id) {
				currItems.get(i).setName(name);
				menu.setMenuItems(currItems);
				return 1;
			}
		}
		return -1;
	}

	/**
	 * Updates the description of a menu item with the given ID.
	 * @param id	the ID of the menu item
	 * @param desc	the new description of the menu item
	 * @return		1 if successfully updated, -1 if item not found
	 */
	public int updateMenuItemDesc(int id, String desc) {
		ArrayList<MenuItem> currItems = menu.getMenuItems();
		
		for(int i=0; i<menu.getMenuItems().size(); ++i) {
			if(currItems.get(i).getItemID()==id) {
				currItems.get(i).setDesc(desc);
				menu.setMenuItems(currItems);
				return 1;
			}
		}
		return -1;
	}

	/**
	 * Updates the price of a menu item with the given ID.
	 * @param id	the ID of the menu item
	 * @param price	the new price of the menu item
	 * @return		1 if successfully updated, -1 if item not found
	 */
	public int updateMenuItem(int id, double price) {
		ArrayList<MenuItem> currItems = menu.getMenuItems();
		
		for(int i=0; i<menu.getMenuItems().size(); ++i) {
			if(currItems.get(i).getItemID()==id) {
				currItems.get(i).setPrice(price);
				menu.setMenuItems(currItems);
				return 1;
			}
		}
		return -1;
	}

	/**
	 * Updates the type of a menu item with the given ID.
	 * @param id	the ID of the menu item
	 * @param type	the new type of the menu item
	 * @return		1 if successfully updated, -1 if item not found
	 */
	public int updateMenuItem(int id, MenuItemType type) {
		ArrayList<MenuItem> currItems = menu.getMenuItems();
		
		for(int i=0; i<menu.getMenuItems().size(); ++i) {
			if(currItems.get(i).getItemID()==id) {
				currItems.get(i).setType(type);
				menu.setMenuItems(currItems);
				return 1;
			}
		}
		return -1;
	}

	/**
	 * Displays the menu item with the given ID.
	 * @param id	the ID of the menu item, 0 if all
	 * @return		1 if successfully displayed, -1 if item not found
	 */
	public int viewMenuItem(int id) {
		
		ArrayList<MenuItem> currItems = menu.getMenuItems();
		
		if(id==0) {
			for(int i=0; i<currItems.size(); ++i) {
				currItems.get(i).display();
			}
			return 1;
		}
		
		for(int i=0; i<menu.getMenuItems().size(); ++i) {
			if(currItems.get(i).getItemID()==id) {
				currItems.get(i).display();;
				return 1;
			}
		}
		return -1;
	}

	/**
	 * Creates a new promotion set based on the given input.
	 * @param promoID		the ID of the set
	 * @param name			the name of the set
	 * @param promoItems	the items in the set
	 * @param desc			the description of the set
	 * @param price			the price of the set
	 */
	public void createPromotionSet(int promoID, String name, ArrayList<Integer> indices, String desc, double price) {
		ArrayList<MenuItem> promoItems = new ArrayList<MenuItem>();
		for(int i=0; i<indices.size();++i) {
			promoItems.add(menu.getMenuItems().get(indices.get(i)-1));
		}
		PromotionSet newSet = new PromotionSet(promoID, name, promoItems, desc, price);
		menu.addPromotionSet(newSet);
	}

	/**
	 * Removes a promotion set with the given ID.
	 * @param id	the id of the promotion set to be removed
	 * @return		1 if successfully removed, -1 if set not found
	 */
	public int removePromotionSet(int id) {
		ArrayList<PromotionSet> currSets = menu.getPromotionSets();
		
		for(int i=0; i<menu.getPromotionSets().size(); ++i) {
			if(currSets.get(i).getPromoID()==id) {
				menu.removePromotionSet(i);
				return 1;
			}
		}
		return -1;
	}

	/**
	 * Adds a menu item to a promotion set with a given ID.
	 * @param id		the ID of the promotion set
	 * @param menuitem	the menu item to be added
	 * @return		1 if successfully added, -1 if set not found
	 */
	public int addItemPromotionSet(int id, int idItem) {
		
		ArrayList<PromotionSet> currSets = menu.getPromotionSets();
		MenuItem menuItem = menu.getMenuItems().get(idItem-1);
		
		for(int i=0; i<menu.getPromotionSets().size(); ++i) {
			if(currSets.get(i).getPromoID()==id) {
				ArrayList<MenuItem> promoItems = currSets.get(i).getPromoItems();
				promoItems.add(menuItem);
				currSets.get(i).setPromoItems(promoItems);
				menu.setPromotionSets(currSets);
				return 1;
			}
		}
		return -1;
		
	}

	/**
	 * Removes an item with the given ID from a promo set with the given ID.
	 * @param idPromo	the ID of the promo set
	 * @param idItem	the ID of the item
	 * @return			1 if successful, -1 if either item or promo set not found
	 */
	public int removeItemPromotionSet(int idPromo, int idItem) {
		
		ArrayList<PromotionSet> currSets = menu.getPromotionSets();
		
		for(int i=0; i<menu.getPromotionSets().size(); ++i) {
			if(currSets.get(i).getPromoID()==idPromo) {
				ArrayList<MenuItem> menuItems = currSets.get(i).getPromoItems();
				
				for(int j=0; j<menuItems.size();++j) {
					if(menuItems.get(j).getItemID()==idItem) {
						menuItems.remove(j);
						currSets.get(i).setPromoItems(menuItems);
						menu.setPromotionSets(currSets);
						return 1;
					}
				}
			}
		}
		return -1;
		
	}
	
	/**
	 * Updates the promotion set's details
	 * @param id	the id of the set
	 * @param name	the new name of the set
	 * @param desc	the new description of the set
	 * @param price	the new price of the set
	 * @return		1 if change is successful, -1 if set not found
	 */
	public int updatePromotionSet(int id, String name, String desc, double price) {
		ArrayList<PromotionSet> currSets = menu.getPromotionSets();
		
		for(int i=0; i<menu.getPromotionSets().size(); ++i) {
			if(currSets.get(i).getPromoID()==id) {
				currSets.get(i).setDesc(desc);
				currSets.get(i).setName(name);
				currSets.get(i).setPrice(price);
				menu.setPromotionSets(currSets);
				return 1;
			}
		}
		return -1;
	}

	/**
	 * Displays the promotion set with the given ID
	 * @param id	the ID of the promotion set, 0 if all
	 * @return		1 if successfully displayed, -1 if set not found
	 */
	public int viewPromotionSet(int id) {
		
		ArrayList<PromotionSet> currSets = menu.getPromotionSets();
		
		if(id==0) {
			for(int i=0; i<currSets.size(); ++i) {
				currSets.get(i).display();
			}
			return 1;
		}
		
		for(int i=0; i<menu.getPromotionSets().size(); ++i) {
			if(currSets.get(i).getPromoID()==id) {
				currSets.get(i).display();
				return 1;
			}
		}
		return -1;
	}

}
