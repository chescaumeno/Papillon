package papillon;
/**
 * Store information for a drink 
 *
 */

public class Drinks extends Item {
    public static final String[] DRINKS = {
        "Fountain\nSoda", "Bottled\nWater", "Sweet\nTea", "Ramune",
        "Cucumber\nSaketini", "Blackberry\nSmash", "Strawberry\nGingertini", "House\nMojito",
        "Kirin\nIchiban", "Sapporo\nPremium", "Shiner\nBock", "Stella\nArtois",
        "White\nWine", "Red\nWine", "Sparkling\nWine", "Sake\nSampler"
    };
    
    public static final double[] PRICES = {
        5, 4, 3, 2,
        6, 5, 4, 3,
        5, 4, 3, 2,
        6, 5, 4, 3
    };
    

    /**
     * Constructs the drink with parameters
     * @param nm name
     * @param qt quantity
     * @param pr price
     */
    public Drinks(String nm, int qt, double pr) {
        super(nm, qt, pr);
    }


    /**
     * Get same item with different quantity
     * @param qt quantity
     * @return new item with the quantity
     */
    public Item getCopy(int qt) {
        return new Drinks(getName(), qt, getPrice());
    }

}
