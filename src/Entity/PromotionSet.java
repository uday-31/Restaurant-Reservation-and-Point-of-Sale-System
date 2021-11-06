package Entity;
import java.util.ArrayList;

/**
 * Represents a promotion set consisting of multiple menu items.
 */
public class PromotionSet {

	/**
	 * ID of the promotion set.
	 */
	private int promoID;
	
	/**
	 * Name of the promotion set.
	 */
	private String name;
	
	/**
	 * Menu items present in the promotion set.
	 */
	private ArrayList<MenuItem> promoItems;
	
	/**
	 * Description of the promotion set.
	 */
	private String desc;
	
	/**
	 * Price of the promotion set. Usually lesser than the sum of its components.
	 */
	private double price;

	/**
	 * Initializes the promotion set based on the input provided.
	 * @param promoID		the serial number of the promotion set
	 * @param name			the name of the promotion set
	 * @param promoItems	the menu items in the promotion set
	 * @param desc			the description of the promotion set
	 * @param price			the price of the promotion set
	 */
	public PromotionSet(int promoID, String name, ArrayList<MenuItem> promoItems, String desc, double price) {
		this.promoID = promoID;
		this.name = name;
		this.promoItems = promoItems;
		this.desc = desc;
		this.price = price;
	}

	/**
	 * Gets the menu items present in this promotion set.
	 * @return	the menu items in this set
	 */
	public ArrayList<MenuItem> getPromoItems() {
		return this.promoItems;
	}
	
	/**
	 * Updates the menu items present in this promotion set, based on availability or limited offers.
	 * @param promoitems	the new menu items present in this set
	 */
	public void setPromoItems(ArrayList<MenuItem> promoitems) {
		this.promoItems = promoitems;
	}
	

	/**
	 * Gets the serial number of this promotion set
	 * @return	the ID of this set
	 */
	public int getPromoID() {
		return this.promoID;
	}

	/**
	 * Updates the serial number of this promotion set, to be used if there are additions before this set.
	 * @param promoID	the new ID of this set
	 */
	public void setPromoID(int promoID) {
		this.promoID = promoID;
	}

	/**
	 * Gets the name of this promotion set, which is based on the items present in it.
	 * @return	the name of this set
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Changes the name of this promotion set, which is updated based on its contents.
	 * @param name	the new name of this set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the price of this promotion set
	 * @return	the price of this set
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Updates the price of this promotion set, to keep up with inflation or change in its contents or costs.
	 * @param price	the new price of this set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Gets the description of the items present in this promotion set.
	 * @return	the description of items in this set
	 */
	public String getDesc() {
		return this.desc;
	}

	/**
	 * Updates the description of the items present in this promotion set, in there there is any change.
	 * @param desc	the new description of items in this set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/**
	 * Displays the items present in this promotion set, as well as its serial number, name, description, and price.
	 */
	public void display() {
		System.out.print(this.promoID + ". "+this.name+" : ");
		for(int i=0; i<this.promoItems.size(); ++i) {
			System.out.print(this.promoItems.get(i).getName()+" | ");
		}
		System.out.println(desc+" | "+price);
	}
}