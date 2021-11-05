package Entity;
import java.util.ArrayList;

/**
 * Represents the menu of the restaurant.
 */
public class Menu {

	/**
	 * The items on the menu.
	 */
	private ArrayList<MenuItem> menuItems;
	
	/**
	 * The promotional sets on the menu.
	 */
	private ArrayList<PromotionSet> promotionSets;

	/**
	 * Initializes the menu with empty lists for menu items and promotional sets.
	 */
	public Menu() {
		this.menuItems = new ArrayList<MenuItem>();
		this.promotionSets = new ArrayList<PromotionSet>();
	}

	/**
	 * Gets the items on this menu.
	 * @return	the items on this menu
	 */
	public ArrayList<MenuItem> getMenuItems() {
		return this.menuItems;
	}

	/**
	 * Adds an item to this menu.
	 * @param menuItems	the item to be added
	 */
	public void addMenuItem(MenuItem menuItem) {
		this.menuItems.add(menuItem);
	}

	/**
	 * Gets the sets on this menu.
	 * @return	the sets on this menu
	 */
	public ArrayList<PromotionSet> getPromotionSets() {
		return this.promotionSets;
	}

	/**
	 * Adds a set to this menu.
	 * @param promotionSets	the set to be added
	 */
	public void addPromotionSet(PromotionSet promotionSet) {
		this.promotionSets.add(promotionSet);
	}
	
	/**
	 * Displays the items and sets on the menu along with their respective serial number, description, and price.
	 */
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