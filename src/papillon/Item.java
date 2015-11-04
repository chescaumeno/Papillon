package papillon;

import java.util.ArrayList;

/**
 * Abstract class for the subclasses Drinks, Appetizers, Entrees, Desserts, and Sides.
 * Uses the ItemData class for each menu item.
 */
public abstract class Item {
	
	/**
	 * An array list to hold the menu items for each category(i.e. subclass)
	 */
	private ArrayList<ItemData> items = new ArrayList<ItemData>();
	
	/**
	 * Adds an item to the check given the item name.
	 * @param s The name of the item to add
	 * @return The new number of items of that type on the check, if successful;
	 * 		   -1 on failure
	 */
	public int addItemToCheck(String s){
		for(ItemData index : items){
			if(s.equals(index.getName())){
				index.addItem();
				return(index.getNum());
			}
		}
		return(-1);
	}
	
	/**
	 * Adds a new item to the menu. First checks that the name for the new item
	 * does not already exist, to avoid duplicate items.
	 * @param newName The name of the new item
	 * @param price The price of the new item
	 * @return 0 on success; -1 on failure
	 */
	public int addNewItem(String newName, double price){
		for(ItemData index : items){
			if(newName.equals(index.getName())){
				return(-1);
			}
		}
		ItemData newItem = new ItemData(newName, price);
		items.add(newItem);
		return(0);
	}
	
	/**
	 * If an item of the given name exists, it will be removed
	 * @param itemName The name of the item to remove
	 * @return 0 on success; -1 on failure
	 */
	public int removeItem(String itemName){
		for(ItemData index : items){
			if(itemName.equals(index.getName())){
				items.remove(index);
				return(0);
			}
		}
		return(-1);
	}
}
