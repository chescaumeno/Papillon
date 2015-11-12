package papillon;
/**
 * Store information for a entree 
 *
 */

public class Entrees extends Item {
    public static final String[] ENTREES = {
        "Tonkotsu\nRamen", "Tonkotsu\nSho-Yu", "Veggie\nRamen", "Tsukemen",
        "Miso\nRamen", "Shoyu\nRamen", "Chashu\nDon", "Gyu Don",
        "Oyako\nDon", "Unagi Don", "Kushi\nAgge", "Chicken\nYakitori",
        "Beef\nNegimaki", "Yakisoba", "Yakiudon", "Sashimi\nSampler"
    };
    
    public static final double[] PRICES = {
        5, 4, 3, 2,
        6, 5, 4, 3,
        5, 4, 3, 2,
        6, 5, 4, 3
    };
    

    /**
     * Constructs the entree with parameters
     * @param nm name
     * @param qt quantity
     * @param pr price
     */
    public Entrees(String nm, int qt, double pr) {
        super(nm, qt, pr);
    }


    /**
     * Get same item with different quantity
     * @param qt quantity
     * @return new item with the quantity
     */
    public Item getCopy(int qt) {
        return new Entrees(getName(), qt, getPrice());
    }

}
