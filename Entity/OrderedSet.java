package Entity;
public class OrderedSet {

	private int quantity;
	private PromotionSet promotionSet;
	private double cost;

	/**
	 * 
	 * @param quantity
	 * @param promotionSet
	 */
	public OrderedSet(int quantity, PromotionSet promotionSet) {
		this.quantity = quantity;
		this.promotionSet = promotionSet;
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

	public PromotionSet getPromotionSet() {
		return this.promotionSet;
	}

	/**
	 * 
	 * @param promotionSet
	 */
	public void setPromotionSet(PromotionSet promotionSet) {
		this.promotionSet = promotionSet;
	}

	public double getCost() {
		return this.cost;
	}


	public void computeCost() {
		this.cost = quantity * promotionSet.getPrice();
	}
	
	public void display() {
		System.out.println(this.quantity+" "+this.promotionSet.getName()+" | "+this.cost);
	}

}