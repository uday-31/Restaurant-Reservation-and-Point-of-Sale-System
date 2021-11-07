package UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Controller.OrderInvoiceController;


/**
 * Interfacing with the user for invoice-related functions.
 */
public class OrderInvoiceUI {

	/**
	 * Prints the sales revenue report for a given period.
	 * @param scanner	the input scanner
	 * @param oic		an object of OrderInvoiceController class
	 */
	public static void printSalesRevenueReport(Scanner scanner, OrderInvoiceController oic) {
		
		System.out.println();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.print("Enter the starting date in format dd/MM/yyyy HH:mm:ss: ");
		String dateString = scanner.nextLine();
		
		Date startDate = new Date();
		try {
			startDate = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.print("Enter the ending date in format dd/MM/yyyy HH:mm:ss: ");
		dateString = scanner.nextLine();
		
		Date endDate = new Date();
		try {
			endDate = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		oic.printSalesRevenueReport(startDate, endDate);
		
		System.out.println();
		System.out.println("Press return to continue.");
		scanner.nextLine();
		
	}
	
	/**
	 * Completes the order at a table and vacates it.
	 * @param scanner	the input scanner
	 * @param oic		an object of OrderInvoiceController class
	 */
	public static void printInvoiceAndVacate(Scanner scanner, OrderInvoiceController oic) {
		
		System.out.println();
		System.out.print("Enter the table ID: ");
		int tableID = scanner.nextInt();
		scanner.nextLine();
		
		int res = oic.printInvoiceAndVacate(tableID);
		
		if(res==1) {
			System.out.println();
			System.out.print("Invoice printed successfully!");
		}
		else {
			System.out.println();
			System.out.print("Table not found!");
		}
		
		System.out.println();
		System.out.println("Press return to continue.");
		scanner.nextLine();
		
	}
}
