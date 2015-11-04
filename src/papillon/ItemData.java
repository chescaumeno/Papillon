package papillon;

/**
 * This class represents one menu item. It will hold the item
 * @author wuc956
 *
 */
public class ItemData {
	
	/**
	 * num keeps track of how many items are currently on the check.
	 */
	private int num;
	
	/**
	 * holds the double value for the price of this specific item
	 */
	private double price;
	
	/**
	 * holds the name of the item.
	 */
	private String name;
	
	/**
	 * Creates a new menu item
	 * @param name The name of the menu item
	 * @param price The price of the menu item
	 */
	ItemData(String name, double price){
		this.name = name;
		this.price = price;
		num = 0;
	}
	
	/**
	 * Creates a new menu item, given only the name
	 * We may not want to allow this though..
	 * @param name The name of the menu item
	 */
	ItemData(String name){
		this(name, 1.0);
	}
	
	/**
	 * Simply adds one more of this item.
	 */
	public void addItem(){
		num++;
	}
	
	/**
	 * Removes one of this item, only if there are 1 or
	 * more items
	 * @return 0 on success; -1 on failure
	 */
	public int removeItem(){
		if(num >= 1){
			num--;
			return(0);
		}
		return(-1);
	}

	/**
	 * @return the item
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
