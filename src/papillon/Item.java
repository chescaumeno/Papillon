package papillon;

/**
 * Abstract class for the subclasses Drinks Appetizers, Entrees, Desserts, and Sides.
 * The implementation here is to use a few arrays for the name, price, and current number
 * of an item. A specific index in all three arrays will represent these values for
 * a specific menu item. All arrays will be initialized to 16 to allow for that many items,
 * and the num value will keep track of how many items there actually are. IF we want to allow
 * for more than 16, then I will change a lot of this implementation.
 */
public abstract class Item {

	/**
	 * num is the number of menu items currently in the system
	 * for that particular subclass. This may not be needed, but I
	 * am including it because we may need this for adding and
	 * removing items from the menu.
	 */
	private int num;
	
	/**
	 * item is an array to keep track of how many items are currently
	 * on the check. The size of the array will be the number of items
	 * corresponding to that subclass. The array will be initialized to
	 * zero at every index. An index will be incremented if that
	 * corresponding food item was added to the check.
	 */
	private int[] item = new int[16];
	
	/**
	 * prices is an array that will hold the dollar value for each
	 * item in the index corresponding to the item that is in the
	 * item array's index.
	 */
	private double[] prices = new double[16];
	
	/**
	 * names is an array to hold the name of each item in its
	 * corresponding index. 
	 */
	private String[] names = new String[16];
	
	/**
	 * Will return the price for the item that was added to the check
	 * as well as increment the index for that item to represent that
	 * there is one more of that item on the check.
	 * If that item does not exist, then the function returns -1
	 * @param s The string name of the item to add to the check.
	 */
	public double addItemToCheck(String s){
		for(int i = 0; i < num; i++){
			if(s.equals(names[i])){
				item[i]++;
				return(prices[i]);
			}
		}
		//If we get to this point, no items matched
		return(-1);
	}
	
	/**
	 * Method for adding a new item to the menu. Assumes that there
	 * is a max of 16 items per category. Will change this if we want
	 * to allow more than that. Simply adds the item at the end, instead
	 * of a specified index.
	 * @param newName the name of the new item to add
	 * @param price
	 */
	public int addNewItem(String newName, double price){
		if(num == 16){
			return(-1);
		}
		names[num] = newName;
		prices[num] = price;
		num++;
		return(0);
	}
	
	/**
	 * 
	 * @param itemName The name of the item to remove
	 * @return 0 on success; -1 on failure
	 */
	public int removeItem(String itemName){
		//If there are no items, then just exit
		if(num == 0){
			return(-1);
		}
		//Compare the given name with all the names stored
		for(int i = 0; i < num; i++){
			//If the given itemName matches one of the stored names
			if(itemName.equals(names[i])){
				//Then we will shift everything left by one index
				for(; i < num; i++){
					names[i] = names[i + 1];
					prices[i] = prices[i + 1];
				}
				//Get rid of last index and decrement
				names[num] = "";
				prices[num] = 0.0;
				num--;
				return(0);
			}
		}
		//If we get here, then no items matched
		return(-1);
	}
}
