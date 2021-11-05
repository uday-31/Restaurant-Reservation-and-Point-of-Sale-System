package Entity;

/**
 * Represents a promotional set that has been ordered.
 */
public class OrderedSet {

	/**
	 * Quantity of the set ordered.
	 */
	private int quantity;
	
	/**
	 * Set ordered.
	 */
	private PromotionSet promotionSet;
	
	/**
	 * Price times quantity of the ordered set.
	 */
	private double cost;

	/**
	 * Initializes the set ordered based on quantity and promotional set and computes the cost.
	 * @param quantity		the quantity of set ordered
	 * @param promotionSet	the set itself
	 */
	public OrderedSet(int quantity, PromotionSet promotionSet) {
		this.quantity = quantity;
		this.promotionSet = promotionSet;
		computeCost();
		
	}

	/**
	 * Gets the quantity of the set ordered.
	 * @return	the quantity of the set ordered
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Updates the quantity of the set ordered, in case the customer changes their mind and updates the cost.
	 * @param quantity	the new quantity of the set ordered
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		computeCost();
	}

	/**
	 * Gets the set ordered.
	 * @return	the set ordered
	 */
	public PromotionSet getPromotionSet() {
		return this.promotionSet;
	}

	/**
	 * Updates the set ordered, in case the customer changes their mind and updates the cost.
	 * @param promotionSet	the new set ordered
	 */
	public void setPromotionSet(PromotionSet promotionSet) {
		this.promotionSet = promotionSet;
		computeCost();
	}

	/**
	 * Gets the cost of the set.
	 * @return	the price times quantity
	 */
	public double getCost() {
		return this.cost;
	}

	/**
	 * Displays the quantity, the set ordered, and the cost.
	 */
	public void display() {
		System.out.println(this.quantity+" "+this.promotionSet.getName()+" | "+this.cost);
	}

	/**
	 * Computes and updates the cost of the set based on quantity.
	 */
	private void computeCost() {
		this.cost = quantity * promotionSet.getPrice();
	}

}