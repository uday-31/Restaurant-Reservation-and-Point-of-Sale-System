package UI;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.OrderController;

/**
 * Interfacing with the user for order-related functions.
 */
public class OrderUI {

	/**
	 * Creates an order.
	 * @param scanner	the input scanner
	 * @param oc		an object of OrderController class
	 */
	public static void createOrder(Scanner scanner, OrderController oc) {
		
		System.out.println();
		System.out.print("Enter the ID of the order: ");
		int orderID = scanner.nextInt();
		scanner.nextLine(); //to read the return
		System.out.print("Enter the ID of the table: ");
		int tableID = scanner.nextInt();
		scanner.nextLine(); //to read the return
		System.out.print("Enter the ID of the creator: ");
		int creatorID = scanner.nextInt();
		scanner.nextLine(); //to read the return
		
		ArrayList<Integer> itemIDs = new ArrayList<Integer>();
		ArrayList<Integer> itemQtys = new ArrayList<Integer>();
		ArrayList<Integer> setIDs = new ArrayList<Integer>();
		ArrayList<Integer> setQtys = new ArrayList<Integer>();
		
		System.out.print("Enter the number of items in the order: ");
		int num = scanner.nextInt();
		scanner.nextLine();
		
		int ind;
		int qty;

		for (int i=0;i<num;++i) {
			System.out.print("Enter the item's ID: ");
			ind = scanner.nextInt();
			scanner.nextLine();
			itemIDs.add(ind);
			System.out.print("Enter the item's quantity: ");
			qty = scanner.nextInt();
			scanner.nextLine();
			itemQtys.add(qty);
		}
		
		System.out.print("Enter the number of sets in the order: ");
		num = scanner.nextInt();
		scanner.nextLine();

		for (int i=0;i<num;++i) {
			System.out.print("Enter the set's ID: ");
			ind = scanner.nextInt();
			scanner.nextLine();
			setIDs.add(ind);
			System.out.print("Enter the set's quantity: ");
			qty = scanner.nextInt();
			scanner.nextLine();
			setQtys.add(qty);
		}
		
		System.out.print("Enter Member ID if member, \"no\" otherwise: ");
		String memberID = scanner.nextLine();
		
		oc.createOrder(orderID, tableID, creatorID, itemIDs, itemQtys, setIDs, setQtys, memberID);
		System.out.println("Order created!");
		
		System.out.println();
		System.out.println("Press return to continue.");
		scanner.nextLine();
	}
	
	/**
	 * Displays an order.
	 * @param scanner	the input scanner
	 * @param oc		an object of OrderController class
	 */
	public static void viewOrder(Scanner scanner, OrderController oc) {
		
		System.out.println();
		System.out.print("Enter the ID of the order to be viewed (enter 0 if all): ");
		int viewID = scanner.nextInt();
		scanner.nextLine();
		int res=oc.viewOrder(viewID);
		if(res==1) {
			System.out.println("Order(s) displayed successfully!");
		}
		else {
			System.out.println("Order not found.");
		}
		
		System.out.println();
		System.out.println("Press return to continue.");
		scanner.nextLine();
		
	}
	
	/**
	 * Provides the add and remove item and/or set functionality.
	 * @param scanner	the input scanner
	 * @param oc		the order controller
	 */
	public static void addRemoveItemsSets(Scanner scanner, OrderController oc) {
		
		int inner_choice;
		
		do {
			System.out.println();
			System.out.println("[1] - Add Menu Item to Order");
			System.out.println("[2] - Remove Menu Item from Order");
			System.out.println("[3] - Add Promotion Set to Order");
			System.out.println("[4] - Remove Promotion Set from Order");
			System.out.println("[0] - Go back");
			System.out.println();
			System.out.print("Enter your choice: ");
			
			inner_choice = scanner.nextInt();
			
			switch(inner_choice) {
				case 1:
					addItemToOrder(scanner, oc);
					break;
					
				case 2:
					removeItemFromOrder(scanner, oc);
					break;
					
				case 3:
					addSetToOrder(scanner, oc);
					break;
					
				case 4:
					removeSetFromOrder(scanner, oc);
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
	 * Adds an item to an order.
	 * @param scanner	the input scanner
	 * @param oc		an object of OrderController class
	 */
	private static void addItemToOrder(Scanner scanner, OrderController oc) {
		
		System.out.println();
		System.out.print("Enter the ID of the order: ");
		int orderID = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Enter the item's quantity to be added: ");
		int qty = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Enter the ID of the item to the added: ");
		int itemID = scanner.nextInt();
		scanner.nextLine();
		
		int res = oc.addItemToOrder(orderID, qty, itemID);
		
		if(res==1) {
			System.out.println("Item added successfully!");
		}
		else {
			System.out.println("Order or item not found.");
		}
		
	}
	
	/**
	 * Removes an item from an order.
	 * @param scanner	the input scanner
	 * @param oc		an object of OrderController class
	 */
	private static void removeItemFromOrder(Scanner scanner, OrderController oc) {
		
		System.out.println();
		System.out.print("Enter the ID of the order: ");
		int orderID = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Enter the item's quantity to be removed: ");
		int qty = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Enter the ID of the item to the removed: ");
		int itemID = scanner.nextInt();
		scanner.nextLine();
		
		int res = oc.removeItemFromOrder(orderID, qty, itemID);
		
		if(res==1) {
			System.out.println("Item removed successfully!");
		}
		else {
			System.out.println("Order or item not found.");
		}
	}
	
	/**
	 * Adds a set to an order.
	 * @param scanner	the input scanner
	 * @param oc		an object of OrderController class
	 */
	private static void addSetToOrder(Scanner scanner, OrderController oc) {
		
		System.out.println();
		System.out.print("Enter the ID of the order: ");
		int orderID = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Enter the set's quantity to be added: ");
		int qty = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Enter the ID of the set to the added: ");
		int setID = scanner.nextInt();
		scanner.nextLine();

		int res = oc.addSetToOrder(orderID, qty, setID);
		
		if(res==1) {
			System.out.println("Set added successfully!");
		}
		else {
			System.out.println("Order or set not found.");
		}
	}
	
	/**
	 * Removes a set from an order.
	 * @param scanner	the input scanner
	 * @param oc		an object of OrderController class
	 */
	private static void removeSetFromOrder(Scanner scanner, OrderController oc) {
		
		System.out.println();
		System.out.print("Enter the ID of the order: ");
		int orderID = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Enter the set's quantity to be removed: ");
		int qty = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Enter the ID of the set to the removed: ");
		int setID = scanner.nextInt();
		scanner.nextLine();
		
		int res = oc.removeSetFromOrder(orderID, qty, setID);
		
		if(res==1) {
			System.out.println("Set removed successfully!");
		}
		else {
			System.out.println("Order or set not found.");
		}
	}

}
