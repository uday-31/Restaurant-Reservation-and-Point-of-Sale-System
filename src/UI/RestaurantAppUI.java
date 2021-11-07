package UI;
import java.util.Scanner;

import Controller.MenuController;
import Controller.OrderController;
import Controller.OrderInvoiceController;
import Controller.ReservationController;
import Controller.TableController;
import Entity.Restaurant;

/**
 * Used to interface with the user and perform functions.
 */
public class RestaurantAppUI {
	
	/**
	 * The main function implementing user interfacing functionality.
	 * @param args	optional arguments
	 */
	public static void main(String[] args)
    {
        int choice;

        Restaurant.initializeRestaurant();
        
        MenuController mc = new MenuController();
		OrderController oc = new OrderController();
		ReservationController rc = new ReservationController();
		TableController tc = new TableController();
		OrderInvoiceController oic = new OrderInvoiceController();
     
		Scanner scanner = new Scanner(System.in);
		do {
			
			System.out.println("\nRestaurant App");
			
			System.out.println("[1] - Create/Update/Remove Menu Item");
			System.out.println("[2] - Create/Update/Remove Promotion Set");
			System.out.println("[3] - Create Order");
			System.out.println("[4] - View Order");
			System.out.println("[5] - Add/Remove Items or Sets from Order");
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
				case 3:
					OrderUI.createOrder(scanner, oc, rc);
					break;
				case 4:
					OrderUI.viewOrder(scanner, oc);
					break;
				case 5:
					OrderUI.addRemoveItemsSets(scanner, oc);
					break;
				case 6:
					ReservationUI.createReservation(scanner, rc, tc);
					break;
				case 7:
					ReservationUI.checkRemoveReservation(scanner, rc);
					break;
				case 8:
					TableUI.checkTableAvailability(scanner, tc);
					break;
				case 9:
					OrderInvoiceUI.printInvoiceAndVacate(scanner, oic);
					break;
				case 10:
					OrderInvoiceUI.printSalesRevenueReport(scanner, oic);
					break;
				case 0:
					break;
				default:
					System.out.println("Enter a valid number!");
					break;
			}
		} while (choice != 0);	
		System.out.println();
		System.out.println("Thank you for using the application!");
    }
	
	
}
