package papillon.models;

import java.awt.Color;
import java.io.Serializable;

public enum Category implements Serializable{
	DRINKS("Drinks", new Color(221, 0, 100)), 
	APPETIZERS("Appetizers", new Color(202, 0, 213)), 
	SIDES("Sides", new Color(149, 51, 204)),
	ENTREES("Entrees", new Color(0, 50, 198)), 
	DESSERTS("Desserts", new Color(51, 141, 153));  
	
	
	private final String str;
	public final Color color; 
	
    private Category(final String text, final Color color) {
        this.str = text;
        this.color = color; 
    }


    @Override
    public String toString() {
        return str;
    }
}
