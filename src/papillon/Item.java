package papillon;
/**
 * Store information for an item
 */

public abstract class Item {
    protected double price;
    protected int quantity;
    protected String name;
    
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
    
    /**
     * Get same item with different quantity
     * @param qt quantity
     * @return new item with the quantity
     */
    public abstract Item getCopy(int qt);
    
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
    
}
