package Entity;

/**
 * Represents an item in the menu.
 */
public class MenuItem {

	/***
	 * ID of the menu item.
	 */
	private int itemID;
	
	/**
	 * Name of the menu item.
	 */
	private String name;
	
	/**
	 * Description of the menu item.
	 */
	private String desc;
	
	/**
	 * Price of the menu item.
	 */
	private double price;
	
	/**
	 * Type of the menu item.
	 */
	private MenuItemType type;

	/**
	 * Initializes the menu item using the given input
	 * @param itemID	the ID, in serial numbers
	 * @param name		the name of the item
	 * @param desc		the food description
	 * @param price		the price, without tax
	 * @param type		the type of the menu item
	 */
	public MenuItem(int itemID, String name, String desc, double price, MenuItemType type) {
		this.itemID = itemID;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.type = type;
	}

	/**
	 * Gets the serial number of this item.
	 * @return	the ID of this menu item
	 */
	public int getItemID() {
		return this.itemID;
	}

	/**
	 * Updates the serial number of this item. Used if there are additions in the menu at earlier spots.
	 * @param itemID  the new ID of this menu item
	 */
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	/**
	 * Returns the name of this item.
	 * @return	the name of this menu item
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Changes the name of this item. Used if an item is renamed if there is a change in the recipe.
	 * @param name  the new name of this menu item
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description of this item. Required if the customer wants to learn more.
	 * @return	the description of this item
	 */
	public String getDesc() {
		return this.desc;
	}

	/**
	 * Updates the description of this item, either to make it sound more attractive or to make updates to the recipe.
	 * @param desc	the new description of this item
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Gets the price of this item, before taxes.
	 * @return	the price of this item
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Changes the price of this item, to keep up with inflation or change in cost of ingredients.
	 * @param price	the new price of this item
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets the type of this menu item.
	 * @return	the type of this menu item
	 */
	public MenuItemType getType() {
		return this.type;
	}

	/**
	 * Changes the type of this menu item, to be used in case the portion size changes.
	 * @param type	the new type of this menu item
	 */
	public void setType(MenuItemType type) {
		this.type = type;
	}
	
	/**
	 * Displays the type, description, name, and price of this menu item.
	 */
	public void display() {
		String type;
		if (this.type==MenuItemType.MAIN_COURSE) {
			type = "Main Course";
		}
		else if (this.type==MenuItemType.DESSERT) {
			type = "Dessert";
		}
		else if (this.type==MenuItemType.APPETISER) {
			type = "Appetiser";
		}
		else
			type = "Drink";
			
		System.out.println(this.itemID+". "+this.name+": "+this.desc+" | "+this.price+" | "+type);
	}

}