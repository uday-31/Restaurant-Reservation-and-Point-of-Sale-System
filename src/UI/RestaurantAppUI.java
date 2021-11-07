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
					MenuUI.createUpdateRemoveMenuItem(scanner, mc);
					break;
				case 2:
					MenuUI.createUpdateRemovePromotionSet(scanner, mc);
					break;
					
					
					
			}
		
		} while (choice != 0);		
		
    }
	
	
}
