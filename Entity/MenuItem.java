package Entity;
public class MenuItem {

	private int itemID;
	private String name;
	private String desc;
	private double price;
	private MenuItemType type;

	/**
	 * 
	 * @param intID
	 * @param name
	 * @param desc
	 * @param price
	 * @param type
	 */
	public MenuItem(int itemID, String name, String desc, double price, MenuItemType type) {
		this.itemID = itemID;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.type = type;
	}

	public int getItemID() {
		return this.itemID;
	}

	/**
	 * 
	 * @param itemID
	 */
	public void setItemID(int itemID) {
		this.itemID = itemID;
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

	public MenuItemType getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(MenuItemType type) {
		this.type = type;
	}
	
	public void displayItem() {
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