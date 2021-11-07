package UI;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import Controller.MenuController;
import Entity.MenuItemType;

/**
 * Interfacing with the user for menu-related functions.
 */
public class MenuUI {
	
	/**
	 * Provides the create, update, and remove menu item functionality.
	 * @param scanner	the input scanner
	 * @param mc		the menu controller
	 */
	public static void createUpdateRemoveMenuItem(Scanner scanner, MenuController mc) {
		
		int inner_choice;
		
		do {
			System.out.println();
			System.out.println("[1] - Create Menu Item");
			System.out.println("[2] - Update Menu Item Name");
			System.out.println("[3] - Update Menu Item Description");
			System.out.println("[4] - Update Menu Item Price");
			System.out.println("[5] - Update Menu Item Type");
			System.out.println("[6] - Remove Menu Item");
			System.out.println("[7] - Display Menu Items");
			System.out.println("[0] - Go back");
			System.out.println();
			System.out.print("Enter your choice: ");
			
			inner_choice = scanner.nextInt();
			
			switch(inner_choice) {
				case 1:
					createMenuItem(scanner, mc);
					break;
					
				case 2:
					updateMenuItemName(scanner, mc);
					break;
					
				case 3:
					updateMenuItemDesc(scanner, mc);
					break;
					
				case 4:
					updateMenuItemPrice(scanner, mc);
					break;
					
				case 5:
					updateMenuItemType(scanner, mc);
					break;
					
				case 6:
					removeMenuItem(scanner, mc);
					break;
					
				case 7:
					displayMenuItems(scanner, mc);
					break;
				
				default:
					return;
			
			}
			
			System.out.println();
			System.out.println("Press return to continue.");
			scanner.nextLine();
			
		} while (inner_choice !=0);
		
	}
	
	/**
	 * Provides the create, update, and remove promotion set functionality.
	 * @param scanner	the input scanner
	 * @param mc		the menu controller class
	 */
	public static void createUpdateRemovePromotionSet(Scanner scanner, MenuController mc) {
		
		int inner_choice;
		
		do {
			System.out.println();
			System.out.println("[1] - Create Promotion Set");
			System.out.println("[2] - Add Menu Item to Promotion Set");
			System.out.println("[3] - Remove Menu Item from Promotion Set");
			System.out.println("[4] - Update Promotion Set");
			System.out.println("[5] - Display Promotion Set");
			System.out.println("[0] - Go back");
			System.out.println();
			System.out.print("Enter your choice: ");
			
			inner_choice = scanner.nextInt();
			
			switch(inner_choice) {
				case 1:
					createPromotionSet(scanner, mc);
					break;
					
				case 2:
					addItemToSet(scanner, mc);
					break;
					
				case 3:
					removeItemFromSet(scanner, mc);
					break;
					
				case 4:
					updateSet(scanner, mc);
					break;
					
				case 5:
					displaySet(scanner, mc);
					break;
				
				default:
					return;
			
			}
			
			System.out.println();
			System.out.println("Press return to continue.");
			scanner.nextLine();
			
		} while (inner_choice !=0);
		
	}

	/**
	 * Creates a new menu item.
	 * @param scanner	the input scanner
	 * @param mc		an object of MenuController class
	 */
	private static void createMenuItem(Scanner scanner, MenuController mc) {
		
		System.out.println();
		System.out.print("Enter the ID: ");
		int ID = scanner.nextInt();
		scanner.nextLine(); //to read the return
		System.out.print("Enter the name: ");
		String name = scanner.nextLine();
		System.out.print("Enter the description: ");
		String desc = scanner.nextLine();
		System.out.print("Enter the price: ");
		double price = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Enter the item type: ");
		String itemType = scanner.nextLine();
		MenuItemType type;
		if(Objects.equals(itemType, "MAINCOURSE"))
        	type = MenuItemType.MAIN_COURSE;
        else if(Objects.equals(itemType, "DESSERT"))
        	type = MenuItemType.DESSERT;
        else if(Objects.equals(itemType, "APPETISER"))
        	type = MenuItemType.APPETISER;
        else
        	type = MenuItemType.DRINK;
		mc.createMenuItem(ID, name, desc, price, type);
		System.out.println("Item created!");
	}
	
	/**
	 * Updates the name of a menu item.
	 * @param scanner	the input scanner
	 * @param mc		an object of MenuController class
	 */
	private static void updateMenuItemName(Scanner scanner, MenuController mc) {
		
		int res;
		System.out.println();
		System.out.print("Enter the ID of the item to be changed: ");
		int changeID = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter the new name: ");
		String newName = scanner.nextLine();
		res=mc.updateMenuItem(changeID, newName);
		if(res==1) {
			System.out.println("Name changed successfully!");
		}
		else {
			System.out.println("Item not found.");
		}
	}
	
	/**
	 * Updates the description of a menu item.
	 * @param scanner	the input scanner
	 * @param mc		an object of MenuController class
	 */
	private static void updateMenuItemDesc(Scanner scanner, MenuController mc) {
		int res;
		System.out.println();
		System.out.print("Enter the ID of the item to be changed: ");
		int changeID = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter the new description: ");
		String newDesc = scanner.nextLine();
		res=mc.updateMenuItemDesc(changeID, newDesc);
		if(res==1) {
			System.out.println("Description changed successfully!");
		}
		else {
			System.out.println("Item not found.");
		}
	}
	
	/**
	 * Updates the price of a menu item.
	 * @param scanner	the input scanner
	 * @param mc		an object of MenuController class
	 */
	private static void updateMenuItemPrice(Scanner scanner, MenuController mc) {
		
		int res;
		System.out.println();
		System.out.print("Enter the ID of the item to be changed: ");
		int changeID = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter the new price: ");
		double newPrice = scanner.nextDouble();
		scanner.nextLine();
		res=mc.updateMenuItem(changeID, newPrice);
		if(res==1) {
			System.out.println("Price changed successfully!");
		}
		else {
			System.out.println("Item not found.");
		}
	}
	
	/**
	 * Updates the type of a menu item.
	 * @param scanner	the input scanner
	 * @param mc		an object of MenuController class
	 */
	private static void updateMenuItemType(Scanner scanner, MenuController mc) {
		
		int res;
		System.out.println();
		System.out.print("Enter the ID of the item to be changed: ");
		int changeID = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter the new type: ");
		String newTypeStr = scanner.nextLine();
		MenuItemType newType;
		if(Objects.equals(newTypeStr, "MAINCOURSE"))
			newType = MenuItemType.MAIN_COURSE;
        else if(Objects.equals(newTypeStr, "DESSERT"))
        	newType = MenuItemType.DESSERT;
        else if(Objects.equals(newTypeStr, "APPETISER"))
        	newType = MenuItemType.APPETISER;
        else
        	newType = MenuItemType.DRINK;
		res=mc.updateMenuItem(changeID, newType);
		if(res==1) {
			System.out.println("Type changed successfully!");
		}
		else {
			System.out.println("Item not found.");
		}
	}
	
	/**
	 * Removes a menu item.
	 * @param scanner	the input scanner
	 * @param mc		an object of MenuController class
	 */
	private static void removeMenuItem(Scanner scanner, MenuController mc) {
		System.out.println();
		System.out.print("Enter the ID of the item to be removed: ");
		int removeID = scanner.nextInt();
		scanner.nextLine();
		int res=mc.removeMenuItem(removeID);
		if(res==1) {
			System.out.println("Item removed successfully!");
		}
		else {
			System.out.println("Item not found.");
		}
	}
	
	/**
	 * Displays the items in the menu.
	 * @param scanner	the input scanner
	 * @param mc		an object of MenuController class
	 */
	private static void displayMenuItems(Scanner scanner, MenuController mc) {
		System.out.println();
		System.out.print("Enter the ID of the item to be viewed (enter 0 if all): ");
		int viewID = scanner.nextInt();
		scanner.nextLine();
		int res=mc.viewMenuItem(viewID);
		if(res==1) {
			System.out.println("Menu item(s) displayed successfully!");
		}
		else {
			System.out.println("Item not found.");
		}
	}
	
	/**
	 * Create promotion set.
	 * @param scanner	the input scanner
	 * @param mc		an object of MenuController class
	 */
	private static void createPromotionSet(Scanner scanner, MenuController mc) {
		System.out.println();
		System.out.print("Enter the ID of the set: ");
		int ID = scanner.nextInt();
		scanner.nextLine(); //to read the return
		System.out.print("Enter the name of the set: ");
		String name = scanner.nextLine();
		System.out.print("Enter the description of the set: ");
		String desc = scanner.nextLine();
		System.out.print("Enter the price of the set: ");
		double price = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Enter the number of menu items in the set: ");
		int num = scanner.nextInt();
		scanner.nextLine();
		int ind;
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for (int i=0;i<num;++i) {
			System.out.print("Enter the item's ID: ");
			ind = scanner.nextInt();
			scanner.nextLine();
			indices.add(ind);
		}
		
		mc.createPromotionSet(ID, name, indices, desc, price);
		System.out.println("Item created!");
	
	}
	
	/**
	 * Adds a menu item to a promotion set.
	 * @param scanner	the input scanner
	 * @param mc		an object of MenuController class
	 */
	private static void addItemToSet(Scanner scanner, MenuController mc) {
		System.out.println();
		System.out.print("Enter the ID of the set to be changed: ");
		int changeID = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter the ID of the menu item to be added: ");
		int addID = scanner.nextInt();
		scanner.nextLine();
		int res=mc.addItemPromotionSet(changeID, addID);
		if(res==1) {
			System.out.println("Item added successfully!");
		}
		else {
			System.out.println("Item or set not found.");
		}
	}
	
	/**
	 * Removes a menu item from a promotion set.
	 * @param scanner	the input scanner
	 * @param mc		an object of MenuController class
	 */
	private static void removeItemFromSet(Scanner scanner, MenuController mc) {
		System.out.println();
		System.out.print("Enter the ID of the set to be changed: ");
		int changeID = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter the ID of the menu item to be removed: ");
		int removeID = scanner.nextInt();
		scanner.nextLine();
		int res=mc.removeItemPromotionSet(changeID, removeID);
		if(res==1) {
			System.out.println("Item removed successfully!");
		}
		else {
			System.out.println("Item or set not found.");
		}
	}
	
	/**
	 * Updates a promotion set.
	 * @param scanner	the input scanner
	 * @param mc		an object of MenuController class
	 */
	private static void updateSet(Scanner scanner, MenuController mc) {
		System.out.println();
		System.out.print("Enter the ID of the set to be updated: ");
		int changeID = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter the name of the set: ");
		String newName = scanner.nextLine();
		System.out.print("Enter the description of the set: ");
		String newDesc = scanner.nextLine();
		System.out.print("Enter the price of the set: ");
		double newPrice = scanner.nextDouble();
		scanner.nextLine();
		int res = mc.updatePromotionSet(changeID, newName, newDesc, newPrice);
		if(res==1) {
			System.out.println("Set updated!");
		}
		else {
			System.out.println("Set not found.");
		}
	}
	
	/**
	 * Displays a promotion set.
	 * @param scanner	the input scanner
	 * @param mc		an object of MenuController class
	 */
	private static void displaySet(Scanner scanner, MenuController mc) {
		System.out.println();
		System.out.print("Enter the ID of the set to be viewed (enter 0 if all): ");
		int viewID = scanner.nextInt();
		scanner.nextLine();
		int res=mc.viewPromotionSet(viewID);
		if(res==1) {
			System.out.println("Set(s) displayed successfully!");
		}
		else {
			System.out.println("Set not found.");
		}
	}

}
