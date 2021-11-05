package Entity;

/**
 * Represents a menu item that has been ordered.
 */
public class OrderedItem {

	/**
	 * Quantity of the item ordered.
	 */
	private int quantity;
	
	/**
	 * Item ordered.
	 */
	private MenuItem menuItem;
	
	/**
	 * Price times quantity of the item ordered.
	 */
	private double cost;

	/**
	 * Initializes the item ordered based on quantity, and computes the cost.
	 * @param quantity	the quantity of item ordered
	 * @param menuItem	the item itself
	 */
	public OrderedItem(int quantity, MenuItem menuItem) {
		this.quantity = quantity;
		this.menuItem = menuItem;
		computeCost();
	}

	/**
	 * Gets the quantity of the item ordered.
	 * @return	the quantity of the item ordered
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Updates the quantity of the item ordered, in case the customer changes their mind and updates the cost.
	 * @param quantity	the new quantity of the item ordered
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		computeCost();
	}

	/**
	 * Gets the item ordered.
	 * @return	the item ordered
	 */
	public MenuItem getMenuItem() {
		return this.menuItem;
	}

	/**
	 * Updates the item ordered, in case the customer changes their mind.
	 * @param menuItem	the new item ordered
	 */
	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
		computeCost();
	}

	/**
	 * Gets the cost of the item
	 * @return	the price times quantity
	 */
	public double getCost() {
		return this.cost;
	}


	/**
	 * Displays the quantity, the item ordered, and the cost.
	 */
	public void display() {
		System.out.println(this.quantity+" "+this.menuItem.getName()+" | "+this.cost);
	}

	/**
	 * Computes and updates the cost of the item based on quantity.
	 */
	private void computeCost() {
		this.cost = this.quantity * this.menuItem.getPrice();
	}

}