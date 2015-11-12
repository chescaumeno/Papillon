package papillon;
/**
 * Store information for a side 
 *
 */

public class Sides extends Item {
    public static final String[] SIDES = {
        "Miso\nSoup", "Tori\nZosui", "Sukiyaki\nUdon", "Tempura\nUdon",
        "Squid\nSalad", "Seaweed\nSalad", "Japanese\nCurry Rice", "Chashu\nRice",
        "Negi Rice", "Brussels\nSprouts", "Daikon\nSalad", "Kimchi",
        "Streamed\nBroccoli"
    };
    
    public static final double[] PRICES = {
        5, 4, 3, 2,
        6, 5, 4, 3,
        5, 4, 3, 2,
        6
    };
    

    /**
     * Constructs the side with parameters
     * @param nm name
     * @param qt quantity
     * @param pr price
     */
    public Sides(String nm, int qt, double pr) {
        super(nm, qt, pr);
    }


    /**
     * Get same item with different quantity
     * @param qt quantity
     * @return new item with the quantity
     */
    public Item getCopy(int qt) {
        return new Sides(getName(), qt, getPrice());
    }

}
