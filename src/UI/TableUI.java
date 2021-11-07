package UI;

import java.util.Scanner;

import Controller.TableController;

/**
 * Interfacing with the user for table-related functions.
 */
public class TableUI {
	
	/**
	 * Checks the availability of a table.
	 * @param scanner	the input scanner
	 * @param tc		an object of TableController class
	 */
	public static void checkTableAvailability(Scanner scanner, TableController tc) {
		
		System.out.println();
		System.out.print("Enter the ID of the table: ");
		int ID = scanner.nextInt();
		scanner.nextLine(); //to read the return
		
		boolean avail = tc.checkAvailability(ID);
		
		if(avail==true) {
			System.out.println("Table is available!");
			tc.viewTable(ID);
		}
		else {
			System.out.println("Table unavailable!");
			tc.viewTable(ID);
		}
		
		System.out.println();
		System.out.println("Press return to continue.");
		scanner.nextLine();
		
	}


}
