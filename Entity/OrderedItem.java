package Entity;
public class OrderedItem {

	private int quantity;
	private MenuItem menuItem;
	private double cost;

	/**
	 * 
	 * @param quantity
	 * @param menuItem
	 */
	public OrderedItem(int quantity, MenuItem menuItem) {
		this.quantity = quantity;
		this.menuItem = menuItem;
		computeCost();
	}

	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MenuItem getMenuItem() {
		return this.menuItem;
	}

	/**
	 * 
	 * @param menuItem
	 */
	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public double getCost() {
		return this.cost;
	}


	public void computeCost() {
		this.cost = this.quantity * this.menuItem.getPrice();
	}
	
	public void display() {
		System.out.println(this.quantity+" "+this.menuItem.getName()+" | "+this.cost);
	}

}