package papillon.models;

/**
 * Store information for an item
 */

public class Item {
    protected double price;
    protected int quantity;
    protected String name;
   
    private Category category;
    
    /**
     * Constructs the item with parameters
     * @param nm name
     * @param qt quantity
     * @param pr price
     */
    public Item(String nm, int qt, double pr) {
        this.name = nm;
        this.quantity = qt;
        this.price = pr;
    }    
    
    public Item(String name, Category category, double price) {
    	this.name = name; 
    	this.category = category; 
    	this.price = price; 
    }
    
    /**
     * Calculate total price
     * @return total price
     */
    public double priceCalculation() {
        return price * quantity;
    }

    /**
     * Get the price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get the quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Update the quantity
     * @param quantity new value
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the name
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * returns the category for the item
     * @return category
     */
    public Category getCategory() {
    	return category; 
    }
    
}
