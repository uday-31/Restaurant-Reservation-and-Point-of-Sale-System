package UI;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import Controller.MenuController;
import Controller.OrderController;
import Controller.ReservationController;
import Controller.TableController;
import Entity.MenuItemType;
import Entity.Restaurant;

/**
 * Used to interface with the user and perform functions.
 */
public class RestaurantAppUI {
	
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
			
			int res;
			
			switch(inner_choice) {
				case 1:
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
					break;
					
				case 2:
					System.out.println();
					System.out.print("Enter the ID of the item to be changed: ");
					int changeID = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter the new name: ");
					String newName = scanner.nextLine();
					res=mc.updateMenuItemName(changeID, newName);
					if(res==1) {
						System.out.println("Name changed successfully!");
					}
					else {
						System.out.println("Item not found.");
					}
					break;
					
				case 3:
					System.out.println();
					System.out.print("Enter the ID of the item to be changed: ");
					int changeID_2 = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter the new description: ");
					String newDesc = scanner.nextLine();
					res=mc.updateMenuItemDesc(changeID_2, newDesc);
					if(res==1) {
						System.out.println("Description changed successfully!");
					}
					else {
						System.out.println("Item not found.");
					}
					break;
					
				case 4:
					System.out.println();
					System.out.print("Enter the ID of the item to be changed: ");
					int changeID_3 = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter the new price: ");
					double newPrice = scanner.nextDouble();
					scanner.nextLine();
					res=mc.updateMenuItemPrice(changeID_3, newPrice);
					if(res==1) {
						System.out.println("Price changed successfully!");
					}
					else {
						System.out.println("Item not found.");
					}
					break;
					
				case 5:
					System.out.println();
					System.out.print("Enter the ID of the item to be changed: ");
					int changeID_4 = scanner.nextInt();
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
					res=mc.updateMenuItemType(changeID_4, newType);
					if(res==1) {
						System.out.println("Type changed successfully!");
					}
					else {
						System.out.println("Item not found.");
					}
					break;
					
				case 6:
					System.out.println();
					System.out.print("Enter the ID of the item to be removed: ");
					int removeID = scanner.nextInt();
					scanner.nextLine();
					res=mc.removeMenuItem(removeID);
					if(res==1) {
						System.out.println("Type removed successfully!");
					}
					else {
						System.out.println("Item not found.");
					}
					break;
					
				case 7:
					System.out.println();
					System.out.print("Enter the ID of the item to be viewed (enter 0 if all): ");
					int viewID = scanner.nextInt();
					scanner.nextLine();
					res=mc.viewMenuItem(viewID);
					if(res==1) {
						System.out.println("Menu item(s) displayed successfully!");
					}
					else {
						System.out.println("Item not found.");
					}
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
			
			int res;
			
			switch(inner_choice) {
				case 1:
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
					break;
					
				case 2:
					System.out.println();
					System.out.print("Enter the ID of the set to be changed: ");
					int changeID = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter the ID of the menu item to be added: ");
					int addID = scanner.nextInt();
					scanner.nextLine();
					res=mc.addItemPromotionSet(changeID, addID);
					if(res==1) {
						System.out.println("Item added successfully!");
					}
					else {
						System.out.println("Item or set not found.");
					}
					break;
					
				case 3:
					System.out.println();
					System.out.print("Enter the ID of the set to be changed: ");
					int changeID_2 = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter the ID of the menu item to be added: ");
					int removeID = scanner.nextInt();
					scanner.nextLine();
					res=mc.removeItemPromotionSet(changeID_2, removeID);
					if(res==1) {
						System.out.println("Item removed successfully!");
					}
					else {
						System.out.println("Item or set not found.");
					}
					break;
					
				case 4:
					System.out.println();
					System.out.print("Enter the ID of the set to be updated: ");
					int changeID_3 = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter the name of the set: ");
					String newName = scanner.nextLine();
					System.out.print("Enter the description of the set: ");
					String newDesc = scanner.nextLine();
					System.out.print("Enter the price of the set: ");
					double newPrice = scanner.nextDouble();
					scanner.nextLine();
					mc.updatePromotionSet(changeID_3, newName, newDesc, newPrice);
					System.out.println("Set updated!");
					break;
					
				case 5:
					System.out.println();
					System.out.print("Enter the ID of the set to be viewed (enter 0 if all): ");
					int viewID = scanner.nextInt();
					scanner.nextLine();
					res=mc.viewPromotionSet(viewID);
					if(res==1) {
						System.out.println("Set(s) displayed successfully!");
					}
					else {
						System.out.println("Set not found.");
					}
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
	 * The main function implementing user interfacing functionality.
	 * @param args
	 */
	public static void main(String[] args)
    {
        int choice;

        Restaurant.initializeRestaurant();
        
        MenuController mc = new MenuController();
		OrderController oc = new OrderController();
		ReservationController rc = new ReservationController();
		TableController tc = new TableController();
     
		Scanner scanner = new Scanner(System.in);
		do {
			
			System.out.println("\nRestaurant App");
			
			System.out.println("[1] - Create/Update/Remove Menu Item");
			System.out.println("[2] - Create/Update/Remove Promotion");
			System.out.println("[3] - Create Order");
			System.out.println("[4] - View Order");
			System.out.println("[5] - Add/Remove Order Items from Order");
			System.out.println("[6] - Create Reservation Booking");
			System.out.println("[7] - Check/Remove Reservation Booking");
			System.out.println("[8] - Check Table Availability");
			System.out.println("[9] - Print Order Invoice");
			System.out.println("[10] - Print Sale Revenue Report by Period");
			System.out.println("[0] - Quit");
			System.out.println();
			System.out.print("Enter your choice: ");
			
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
				case 1:
					createUpdateRemoveMenuItem(scanner, mc);
					break;
				case 2:
					createUpdateRemovePromotionSet(scanner, mc);
					break;
					
					
					
					
					
					
					
					
					
					
					
			}
		
		} while (choice != 0);		
		
    }
	
	
}
