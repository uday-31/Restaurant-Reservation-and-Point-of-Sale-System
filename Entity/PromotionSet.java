package Entity;
import java.util.ArrayList;

public class PromotionSet {

	private int promoID;
	private String name;
	private ArrayList<MenuItem> promoItems;
	private String desc;
	private double price;

	/**
	 * 
	 * @param promoID
	 * @param name
	 * @param promoItems
	 * @param desc
	 * @param price
	 */
	public PromotionSet(int promoID, String name, ArrayList<MenuItem> promoItems, String desc, double price) {
		this.promoID = promoID;
		this.name = name;
		this.promoItems = promoItems;
		this.desc = desc;
		this.price = price;
	}

	public ArrayList<MenuItem> getPromoItems() {
		return this.promoItems;
	}
	
	/**
	 * 
	 * @param promoitems
	 */
	public void setPromoItems(ArrayList<MenuItem> promoitems) {
		this.promoItems = promoitems;
	}
	

	public int getPromoID() {
		return this.promoID;
	}

	/**
	 * 
	 * @param promoID
	 */
	public void setPromoID(int promoID) {
		this.promoID = promoID;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDesc() {
		return this.desc;
	}

	/**
	 * 
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void displaySet() {
		System.out.print(this.promoID + ". "+this.name+" : ");
		for(int i=0; i<this.promoItems.size(); ++i) {
			System.out.print(this.promoItems.get(i).getName()+" ");
		}
		System.out.println("| "+desc+" | "+price);
	}
}