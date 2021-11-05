package Controller;
import java.util.ArrayList;
import java.util.Date;

import Entity.Reservation;
import Entity.Restaurant;

public class ReservationController {

	private static ArrayList<Reservation> reservations = Restaurant.reservations;

	/**
	 * 
	 * @param resID
	 * @param resTime
	 * @param paxSize
	 * @param name
	 * @param contactNo
	 * @param memberID
	 */
	public void createReservation(int resID, Date resTime, int paxSize, String name, String contactNo, String memberID) {
		Reservation res = new Reservation(resID, resTime, paxSize, name, contactNo, memberID);
		reservations.add(res);
	}

	/**
	 * 
	 * @param idxRes
	 */
	public void checkRemoveReservation(int idxRes) {
		System.out.println();
		System.out.println("Reservation ID: " + reservations.get(idxRes).getResID());
		System.out.println("Reservation Time: " + reservations.get(idxRes).getResTime());
		System.out.println("Is Reservation Valid?: " + reservations.get(idxRes).getisValid());
		System.out.println("Reservation Pax: " + reservations.get(idxRes).getPaxSize());
		System.out.println("Customer Name: " + reservations.get(idxRes).getName());
		System.out.println("Customer Contact: " + reservations.get(idxRes).getContactNo());
		System.out.println("Customer Assigned Table: " + reservations.get(idxRes).getAssignedTable().getTableID());
	}

	/**
	 * 
	 * @param idxRes
	 */
	public void deleteReservation(int idxRes) {
		int id = reservations.get(idxRes).getResID();
		reservations.remove(idxRes);
		System.out.println("Successfully removed Reservation " + id);
	}

}