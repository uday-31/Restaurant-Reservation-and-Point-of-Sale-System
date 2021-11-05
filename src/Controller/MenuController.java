package Controller;
import java.util.ArrayList;

import Entity.Menu;
import Entity.MenuItem;
import Entity.MenuItemType;
import Entity.PromotionSet;
import Entity.Restaurant;

public class MenuController {

	private static Menu menu = Entity.Restaurant.menu;

	public void viewMenu() {
		System.out.println("***** List of Menu Items *****");
		for (int i=0; i< menu.getMenuItems().size(); i++) {
			viewMenuItem(i);
		}
		System.out.println("***** List of Promotion Sets *****");
		for (int j=0; j< menu.getPromotionSets().size(); j++) {
			viewMenuItem(j);
		}
	}

	/**
	 * 
	 * @param itemID
	 * @param name
	 * @param desc
	 * @param price
	 * @param type
	 */
	public void createMenuItem(int itemID, String name, String desc, double price, MenuItemType type) {
		MenuItem newitem = new MenuItem(itemID, name, desc, price, type);
		ArrayList <MenuItem> curitems = menu.getMenuItems();
		curitems.add(newitem);
		System.out.println("Successfully added Menu Item" + name + "to Menu");
	}
	

	/**
	 * 
	 * @param idx
	 */
	public void removeMenuItem(int idx) {
		ArrayList <MenuItem> curitems = menu.getMenuItems();
		String oldname = curitems.get(idx).getName();
		curitems.remove(idx);
		System.out.println("Successfully removed Menu Item" + oldname + "from Menu");
	}

	/**
	 * 
	 * @param idx
	 */
	public void viewMenuItem(int idx) {
		System.out.println();
		System.out.println("Item ID: " + menu.getMenuItems().get(idx).getItemID());
		System.out.println("Item Name: " + menu.getMenuItems().get(idx).getName());
		System.out.println("Item Description: " + menu.getMenuItems().get(idx).getDesc());
		System.out.println("Item Price: " + menu.getMenuItems().get(idx).getPrice());
		System.out.println("Item course type: " + menu.getMenuItems().get(idx).getType());
	}



	/**
	 * 
	 * @param promoID
	 * @param name
	 * @param promoItems
	 * @param desc
	 * @param price
	 */
	public void createPromotionSet(int promoID, String name, ArrayList<MenuItem> promoItems, String desc, double price) {
		PromotionSet newset = new PromotionSet(promoID, name, promoItems, desc, price);
		menu.getPromotionSets().add(newset);
		System.out.println("Successfully added Promotion Set" + name + "to Menu");
	}

	/**
	 * 
	 * @param idx
	 */
	public void removePromotionSet(int idx) {
		String oldname = menu.getPromotionSets().get(idx).getName();
		menu.getPromotionSets().remove(idx);
		System.out.println("Successfully removed Promotion Set" + oldname + "from Menu");
	}

	/**
	 * 
	 * @param idx
	 */
	public void viewPromotionSet(int idx) {
		System.out.println();
		System.out.println("Promo ID: " + menu.getPromotionSets().get(idx).getPromoID());
		System.out.println("Promo Name: " + menu.getPromotionSets().get(idx).getName());
		System.out.println("Promo Description: " + menu.getPromotionSets().get(idx).getDesc());
		System.out.println("Promo Price: " + menu.getPromotionSets().get(idx).getPrice());
		System.out.println();
		System.out.println("Contains the following Promo Items:");
		ArrayList <MenuItem> promo = menu.getPromotionSets().get(idx).getPromoItems();
		for (int i=0; i< promo.size(); i++) {
			viewMenuItem(i);
		}
	}


	/**
	 * 
	 * @param idx
	 * @param name
	 */
	public void updateMenuItemName(int idx, String name) {
		String oldname = menu.getMenuItems().get(idx).getName();
		menu.getMenuItems().get(idx).setName(name);
		System.out.println("Successfully updated name from " + oldname + " to " + name);
	}
	
	
	/**
	 * 
	 * @param idx
	 * @param desc
	 */
	public void updateMenuItemDesc(int idx, String desc) {
		String name = menu.getMenuItems().get(idx).getName();
		String olddesc = menu.getMenuItems().get(idx).getDesc();
		menu.getMenuItems().get(idx).setDesc(desc);
		System.out.println("Successfully updated description of " + name + " from " + olddesc + " to " + desc);
	}

	/**
	 * 
	 * @param idx
	 * @param price
	 */
	public void updateMenuItemPrice(int idx, double price) {
		String name = menu.getMenuItems().get(idx).getName();
		double oldprice = menu.getMenuItems().get(idx).getPrice();
		menu.getMenuItems().get(idx).setPrice(price);
		System.out.println("Successfully updated price of " + name + " from " + oldprice + " to " + price);
	}

	/**
	 * 
	 * @param idx
	 * @param type
	 */
	public void updateMenuItemType(int idx, MenuItemType type) {
		String name = menu.getMenuItems().get(idx).getName();
		MenuItemType oldtype = menu.getMenuItems().get(idx).getType();
		menu.getMenuItems().get(idx).setType(type);
		System.out.println("Successfully updated type of " + name + " from " + oldtype + " to " + type);
	}
	
	
	/**
	 * 
	 * @param idx
	 * @param menuitem
	 */
	public void addItemPromotionSet(int idx, MenuItem menuitem) {
		ArrayList <MenuItem> promo = menu.getPromotionSets().get(idx).getPromoItems();
		String name = menu.getPromotionSets().get(idx).getName();
		promo.add(menuitem);
		menu.getPromotionSets().get(idx).setPromoItems(promo);
		System.out.println("Successfully added " + menuitem.getName() + " to Promotion Set " + name);
	}

	/**
	 * 
	 * @param idx
	 */
	public void removeItemPromotionSet(int idx, MenuItem menuitem) {
		ArrayList <MenuItem> promo = menu.getPromotionSets().get(idx).getPromoItems();
		String name = menu.getPromotionSets().get(idx).getName();
		promo.remove(menuitem);
		menu.getPromotionSets().get(idx).setPromoItems(promo);
		System.out.println("Successfully removed " + menuitem + " from Promotion Set " + name);
	}

}