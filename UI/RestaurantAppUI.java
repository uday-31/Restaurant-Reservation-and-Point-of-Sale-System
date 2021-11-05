package UI;
import java.util.Scanner;

import Controller.MenuController;
import Controller.OrderController;
import Controller.ReservationController;
import Controller.TableController;
import Entity.Restaurant;


public class RestaurantAppUI {
	public static void main(String[] args)
    {
        int choice;
        int inner_choice;
        Restaurant.initializeRestaurant();
     
		Scanner scanner = new Scanner(System.in);
		do {
			// initialise restaurant
			
			
			//initialise controllers
			MenuController menuController = new MenuController();
			OrderController orderController = new OrderController();
			ReservationController reservationController = new ReservationController();
			TableController tableController = new TableController();
			
			
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
			
			choice = scanner.nextInt();
			
			switch (choice) {
				case 1:
					do {
						System.out.println("[1] - Create Menu Item");
						System.out.println("[2] - Update Menu Item");
						System.out.println("[3] - Remove Menu Item");
						System.out.println("[0] - Go back");
						
						inner_choice = scanner.nextInt();
						
						switch(inner_choice) {
							case 1:
								
							case 2:
								
							
						}
					} while (inner_choice !=0);
					
					
					
					
					
					
					
					
					
					
					
			}
			
	
			
			
			
			
			
			
		} while (choice != 0);
		
		
		
		
		
		
		
		
    }
	
	
}
