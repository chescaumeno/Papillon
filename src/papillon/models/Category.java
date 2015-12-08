package papillon.models;

import java.awt.Color;
import java.io.Serializable;

public enum Category implements Serializable{
	DRINKS("Drinks", new Color(204, 0, 153)), 
	APPETIZERS("Appetizers", new Color(102, 0, 102)), 
	SIDES("Sides", new Color(102, 0, 204)),
	ENTREES("Entrees", new Color(0, 50, 198)), 
	DESSERTS("Desserts", new Color(0, 143, 179));  
	
	
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
