package Entity;
import java.util.ArrayList;

public class Menu {

	private ArrayList<MenuItem> menuItems;
	private ArrayList<PromotionSet> promotionSets;

	/**
	 * 
	 * @param menuItems
	 * @param promotionSets
	 */
	public Menu() {
		this.menuItems = new ArrayList<MenuItem>();
		this.promotionSets = new ArrayList<PromotionSet>();
	}

	public ArrayList<MenuItem> getMenuItems() {
		return this.menuItems;
	}

	/**
	 * 
	 * @param menuItems
	 */
	public void addMenuItem(MenuItem menuItem) {
		this.menuItems.add(menuItem);
	}

	public ArrayList<PromotionSet> getPromotionSets() {
		return this.promotionSets;
	}

	/**
	 * 
	 * @param promotionSets
	 */
	public void addPromotionSet(PromotionSet promotionSet) {
		this.promotionSets.add(promotionSet);
	}
	
	public void display() {
		System.out.println("Menu items: ");
		for(int i=0; i<this.menuItems.size(); ++i) {
			this.menuItems.get(i).display();
		}
		System.out.println();
		System.out.println("Promotion sets: ");
		for(int i=0; i<this.promotionSets.size(); ++i) {
			this.promotionSets.get(i).display();
		}
	}

}