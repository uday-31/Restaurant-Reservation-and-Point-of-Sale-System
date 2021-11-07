package UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Controller.ReservationController;
import Controller.TableController;
import Entity.Reservation;

/**
 * Interfacing with the user for reservation-related functions.
 */
public class ReservationUI {
	
	/**
	 * Creates a new reservation.
	 * @param scanner	the input scanner
	 * @param rc		an object of ReservationController class
	 * @param tc		an object of TableController class
	 */
	public static void createReservation(Scanner scanner, ReservationController rc, TableController tc) {
		
		System.out.println();
		
		System.out.print("Enter the size of the reservation: ");
		int paxSize = scanner.nextInt();
		scanner.nextLine();
		
		boolean tablesFull = tc.checkFull(paxSize);
		if(tablesFull==true) {
			System.out.println("All tables are either occupied or reserved!");
			System.out.println();
			System.out.println("Press return to continue.");
			scanner.nextLine();
			return;
		}
		
		System.out.print("Enter the reservation ID: ");
		int resID = scanner.nextInt();
		scanner.nextLine(); //to read the return
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.print("Enter the reservation date in format dd/MM/yyyy HH:mm:ss: ");
		String dateString = scanner.nextLine();
		
		Date date = new Date();
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.print("Enter the name of the customer: ");
		String name = scanner.nextLine();
		
		System.out.print("Enter the contact number of the customer: ");
		String contactNo = scanner.nextLine();
		
		System.out.print("Enter the Member ID of the customer (\"no\" if not a member): ");
		String memberID = scanner.nextLine();
		
		Reservation res = rc.createReservation(resID, date, paxSize, name, contactNo, memberID);
		int table = tc.assignTable(res);
		
		System.out.println();
		System.out.println("Reservation for "+paxSize+" pax created successfully and assigned to table "+table+"!");
		System.out.println("Press return to continue.");
		scanner.nextLine();
		
	}
	
	/**
	 * Creates a new reservation.
	 * @param scanner	the input scanner
	 * @param rc		an object of ReservationController class
	 */
	public static void checkRemoveReservation(Scanner scanner, ReservationController rc) {
		
		System.out.println();
		
		System.out.print("Enter the reservation ID: ");
		int resID = scanner.nextInt();
		scanner.nextLine(); //to read the return
		
		int val = rc.checkReservation(resID);
		
		if(val==-1) {
			System.out.println();
			rc.displayReservation(resID-1);
			System.out.println("Reservation has expired! Press return to continue.");
			scanner.nextLine();
			return;
		}
		else if(val==-2) {
			System.out.println();
			System.out.println("Reservation not found! Press return to continue.");
			scanner.nextLine();
			return;
		}
		
		System.out.println();
		System.out.println("Reservation found! Enter 1 to delete it, and enter 2 to display it: ");
		int input = scanner.nextInt();
		scanner.nextLine();
		
		if(input==1) {
			rc.deleteReservation(val);
			System.out.println();
			System.out.println("Reservation deleted successfully! Press return to continue.");
			scanner.nextLine();
		}
		else {
			rc.displayReservation(val);
			System.out.println();
			System.out.println("Reservation displayed successfully! Press return to continue.");
			scanner.nextLine();
		}
		
	}

}
