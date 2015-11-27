package papillon.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import papillon.models.Category;
import papillon.models.MenuItem;

public class MenuController {

	Map<Category, ArrayList<MenuItem>> menuItemsByCategory;
	
	public MenuController() {
		menuItemsByCategory = new HashMap<Category, ArrayList<MenuItem>>();
		
		//TODO: Menu Items will be uploaded from a file into the GUI rather than hardcoded like this. 
		
		ArrayList<MenuItem> drinks = new ArrayList<MenuItem>();
		drinks.add(new MenuItem("<html><center>Fountain<br>Soda</center></html>", 2.00, Category.DRINKS));
		drinks.add(new MenuItem("<html><center>Bottled<br>Water</center></html>", 2.00, Category.DRINKS)); 
		drinks.add(new MenuItem("<html><center>Sweet<br>Tea</center></html>", 3.00, Category.DRINKS)); 
		drinks.add(new MenuItem("<html><center>Ramune</center></html>", 6.00, Category.DRINKS));
		drinks.add(new MenuItem("<html><center>Cucumber<br>Saketini</center></html>", 9.00, Category.DRINKS));
		drinks.add(new MenuItem("<html><center>Blackberry<br>Smash</center></html>", 9.00, Category.DRINKS));
		drinks.add(new MenuItem("<html><center>Strawberry<br>Gingertini</center></html>", 9.00, Category.DRINKS));
		drinks.add(new MenuItem("<html><center>House<br>Mojito</center></html>", 9.00, Category.DRINKS));
		drinks.add(new MenuItem("<html><center>Kirin<br>Ichiban</center></html>", 6.00, Category.DRINKS));
		drinks.add(new MenuItem("<html><center>Sapporo<br>Premium</center></html>", 6.00, Category.DRINKS));
		drinks.add(new MenuItem("<html><center>Shiner<br>Bock</center></html>", 5.00, Category.DRINKS));
		drinks.add(new MenuItem("<html><center>Stella<br>Artois</center></html>", 6.00, Category.DRINKS));
		drinks.add(new MenuItem("<html><center>White<br>Wine</center></html>", 8.00, Category.DRINKS));
		drinks.add(new MenuItem("<html><center>Red<br>Wine</center></html>", 8.00, Category.DRINKS));
		drinks.add(new MenuItem("<html><center>Sparkling<br>Wine</center></html>", 10.00, Category.DRINKS));
		drinks.add(new MenuItem("<html><center>Sake<br>Sampler</center></html>", 12.00, Category.DRINKS));
		
		
		
		ArrayList<MenuItem> sides = new ArrayList<MenuItem>(); 
		sides.add(new MenuItem("Miso Soup", 4.00, Category.SIDES)); 
		sides.add(new MenuItem("Tori Zosui", 5.00, Category.SIDES)); 
		sides.add(new MenuItem("Sukiyaki Udon", 6.00, Category.SIDES));
		sides.add(new MenuItem("Tempura Udon", 6.00, Category.SIDES));
		sides.add(new MenuItem("Squid Salad", 6.00, Category.SIDES));
		sides.add(new MenuItem("Seaweed Salad", 6.00, Category.SIDES));
		sides.add(new MenuItem("Curry Rice", 6.00, Category.SIDES));
		sides.add(new MenuItem("Chashu Rice", 6.00, Category.SIDES));
		sides.add(new MenuItem("Negi Rice", 6.00, Category.SIDES));
		sides.add(new MenuItem("Brussels Sprouts", 6.00, Category.SIDES));
		sides.add(new MenuItem("Daikon Salad", 6.00, Category.SIDES));
		sides.add(new MenuItem("Kimchi", 6.00, Category.SIDES));
		sides.add(new MenuItem("Steamed Broccoli", 6.00, Category.SIDES));
		sides.add(new MenuItem("Red Curry", 6.00, Category.SIDES));
		sides.add(new MenuItem("Green Curry", 6.00, Category.SIDES));
		sides.add(new MenuItem("Yellow Curry", 6.00, Category.SIDES));
		
		
		
		ArrayList<MenuItem> appetizers = new ArrayList<MenuItem>(); 
		appetizers.add(new MenuItem("Edamame", 5.00, Category.APPETIZERS)); 
		appetizers.add(new MenuItem("Spicy Edamame", 5.00, Category.APPETIZERS)); 
		appetizers.add(new MenuItem("Pork Gyoza", 6.00, Category.APPETIZERS));
		appetizers.add(new MenuItem("Agedashi Tofu", 6.00, Category.APPETIZERS));
		appetizers.add(new MenuItem("Shishito Peppers", 6.00, Category.APPETIZERS));
		appetizers.add(new MenuItem("Crunchy Roll", 6.00, Category.APPETIZERS));
		appetizers.add(new MenuItem("Dragon Roll", 6.00, Category.APPETIZERS));
		appetizers.add(new MenuItem("Rainbow Roll", 6.00, Category.APPETIZERS));
		appetizers.add(new MenuItem("Tuna Roll", 6.00, Category.APPETIZERS));
		appetizers.add(new MenuItem("Eel Roll", 6.00, Category.APPETIZERS));
		appetizers.add(new MenuItem("Crab Roll", 6.00, Category.APPETIZERS));
		appetizers.add(new MenuItem("Texas Roll", 6.00, Category.APPETIZERS));
		appetizers.add(new MenuItem("Philadelphia Roll", 6.00, Category.APPETIZERS));
		appetizers.add(new MenuItem("Beef Sashimi", 6.00, Category.APPETIZERS));
		appetizers.add(new MenuItem("Salmon Sashimi", 6.00, Category.APPETIZERS));
		appetizers.add(new MenuItem("Shrimp Shumai", 6.00, Category.APPETIZERS));
	
		
		
		
		ArrayList<MenuItem> entrees = new ArrayList<MenuItem>(); 
		entrees.add(new MenuItem("Tonkotsu Ramen", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Tonkotsu Shoyu", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Veggie Ramen", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Tsukemen", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Miso Ramen", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Shoyu Ramen", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Chashu Don", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Gyo Don", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Oyako Don", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Unagi Don", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Kushi Agge", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Chicken Yakitori", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Beef Negimaki", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Yakisoba", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Yakiudon", 12.00, Category.ENTREES)); 
		entrees.add(new MenuItem("Sashimi Sampler", 12.00, Category.ENTREES)); 
		
		
		
		ArrayList<MenuItem> desserts = new ArrayList<MenuItem>(); 
		desserts.add(new MenuItem("Green Tea Mochi", 5.00, Category.DESSERTS)); 
		desserts.add(new MenuItem("Black Sesame Mochi", 5.00, Category.DESSERTS)); 
		desserts.add(new MenuItem("Red Bean Mochi", 6.00, Category.DESSERTS)); 
		desserts.add(new MenuItem("Chocolate Mochi", 5.00, Category.DESSERTS)); 
		desserts.add(new MenuItem("Strawberry Mochi", 5.00, Category.DESSERTS)); 
		desserts.add(new MenuItem("Coffee Mochi", 6.00, Category.DESSERTS)); 
		desserts.add(new MenuItem("Oreo Tempura", 5.00, Category.DESSERTS)); 
		desserts.add(new MenuItem("Banana Tempura", 5.00, Category.DESSERTS)); 
		desserts.add(new MenuItem("Cheesecake", 6.00, Category.DESSERTS)); 
		
		
		menuItemsByCategory.put(Category.DRINKS, drinks); 
		menuItemsByCategory.put(Category.SIDES, sides); 
		menuItemsByCategory.put(Category.APPETIZERS, appetizers); 
		menuItemsByCategory.put(Category.ENTREES, entrees);
		menuItemsByCategory.put(Category.DESSERTS, desserts); 
		
		
	}
	
	public ArrayList<MenuItem> getMenuItems(Category category) {
		ArrayList<MenuItem> copyItems = new ArrayList<MenuItem>();
		for (MenuItem menuItem : menuItemsByCategory.get(category)) {
			copyItems.add(menuItem);
		}
		return copyItems;
	}

	public ArrayList<Category> getMenuCategories() {
		ArrayList<Category> categories = new ArrayList<Category>(); 
		for (Category c : Category.values()) {
			categories.add(c);
		}
		return categories;
	}

}
