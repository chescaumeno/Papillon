package papillon;
/**
 * Store information for a Appetizer 
 *
 */

public class Appetizers extends Item {

    public static final String[] APPETIZERS = {
        "Edamame", "Spicy\nEdamame", "Pork\nGyoza", "Veggie\nGyoza",
        "Beef\nSashimi", "Agedashi\nTofu", "Shishito\nPeppers", "Beef\nSashimi",
        "Crunchy\nRoll", "Dragon\nRoll", "Rainbow\nRoll", "Tuna\nRoll",
        "Beef\nSashimi", "Tuna\nSashimi", "Salmon\nSashimi", "Shrimp\nShumai"
    };
    
    public static final double[] PRICES = {
        5, 4, 3, 2,
        6, 5, 4, 3,
        5, 4, 3, 2,
        6, 5, 4, 3
    };
    

    /**
     * Constructs the Appetizer with parameters
     * @param nm name
     * @param qt quantity
     * @param pr price
     */
    public Appetizers(String nm, int qt, double pr) {
        super(nm, qt, pr);
    }


    /**
     * Get same item with different quantity
     * @param qt quantity
     * @return new item with the quantity
     */
    public Item getCopy(int qt) {
        return new Appetizers(getName(), qt, getPrice());
    }
}
