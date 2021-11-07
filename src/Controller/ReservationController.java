package Controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import Entity.Reservation;
import Entity.Restaurant;

/**
 * Controller class handling the restaurant's reservations.
 */
public class ReservationController {

	/**
	 * The restaurant's reservations.
	 */
	private static ArrayList<Reservation> reservations = Restaurant.reservations;

	/**
	 * Creates a new reservation based on the input.
	 * @param resID		the reservation ID
	 * @param resTime	the reservation time
	 * @param paxSize	the pax size of the reservation
	 * @param name		the name of the customer
	 * @param contactNo	the contact number of the customer
	 * @param memberID	the member ID of the customer, "no" if not a member
	 */
	public Reservation createReservation(int resID, Date resTime, int paxSize, String name, String contactNo, String memberID) {
		
		Reservation res;
		
		if(Objects.equals(memberID, "no")) {
			res = new Reservation(resID, resTime, paxSize, name, contactNo);
		}
		else {
			res = new Reservation(resID, resTime, paxSize, name, contactNo, memberID);
		}
		
		reservations.add(res);
		return res;
	}

	/**
	 * Finds a given reservation based on ID and updates its validity.
	 * @param idRes	the ID of the reservation
	 * @return 		the index of the reservation if found, -1 if invalid, -2 if not found
	 */
	public int checkReservation(int idRes) {
		
		boolean updatedValidity;
		for(int i=0; i< reservations.size(); ++i) {
			if(reservations.get(i).getResID()==idRes) {
				updatedValidity=reservations.get(i).updateValidity();
				if(updatedValidity==false)
					return -1;
				else {
					return i;
				}
			}
		}
		return -2;

	}

	/**
	 * Deletes a given reservation.
	 * @param idxRes	the index of the reservation to be removed
	 */
	public void deleteReservation(int idxRes) {
		reservations.get(idxRes).resetReservation();
		reservations.remove(idxRes);
	}
	
	/**
	 * Displays a given reservation.
	 * @param idxRes	the index of the reservation to be displayed
	 */
	public void displayReservation(int idxRes) {
		reservations.get(idxRes).display();
	}
	
	/**
	 * Gets the reservation name for a given reservation ID.
	 * @param resID		the ID of the reservation
	 * @return			the name of the customer, or null if the ID can't be found
	 */
	public String getReservationName(int resID) {
		for(int i=0; i<reservations.size();++i) {
			if(reservations.get(i).getResID()==resID) {
				return reservations.get(i).getName();
			}
		}
		return "null";
	}

}