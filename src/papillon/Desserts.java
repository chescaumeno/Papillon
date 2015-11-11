package papillon;
/**
 * Store information for a dessert 
 *
 */

public class Desserts extends Item {
    public static final String[] DESSERTS = {
        "Green tea\nMochi", "Black Sesame\nMochi", "Red Bean\nMochi",
        "Chocolate\nMochi", "Strawberry\nMochi", "Coffee\nMochi",
        "Oreo\nTempura", "Banana\nTempura", "Cheesecake"
    };
    
    public static final double[] PRICES = {
        5, 4, 3, 
        6, 5, 4, 
        5, 4, 3
    };
    

    /**
     * Constructs the dessert with parameters
     * @param nm name
     * @param qt quantity
     * @param pr price
     */
    public Desserts(String nm, int qt, double pr) {
        super(nm, qt, pr);
    }


    /**
     * Get same item with different quantity
     * @param qt quantity
     * @return new item with the quantity
     */
    public Item getCopy(int qt) {
        return new Desserts(getName(), qt, getPrice());
    }

}
