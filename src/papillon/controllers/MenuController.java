package papillon.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import papillon.models.Category;
import papillon.models.MenuItem;

public class MenuController {
	
	Map<Category, ArrayList<MenuItem>> menuItemsByCategory; //hashMap
	
	public MenuController() {
		//TODO: move the file reading to its own method, so the menu can be customizable.
		
		menuItemsByCategory = new HashMap<Category, ArrayList<MenuItem>>();
		for (Category category : Category.values()) {
			ArrayList<MenuItem> list = new ArrayList<MenuItem>(); 
			menuItemsByCategory.put(category, list); // in the hashMap menuItemsbyCategory we will have an empty ArrayList<MenuItem> for each category 
		}
		
		BufferedReader reader = null; 
		try { 
			reader = new BufferedReader(new FileReader("src/papillon/resources/menu.csv"));
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
	
				MenuItem item = createMenuItem(currentLine); //method that parses line by line, creating the menu item 
				ArrayList<MenuItem> list = menuItemsByCategory.get(item.getCategory()); //returns the appropriate list to put the food item on 
				list.add(item); // add the item to the list; 
			}
			
		} catch(IOException ex) {
			System.out.println(ex.getMessage()); 
		}
		
	}
	
	private MenuItem createMenuItem(String currentLine) {
		String[] tokens = currentLine.split("\\s*,\\s*"); //splitting the line into tokens 
		String itemName = tokens[0].trim(); //gets the name of the food item
		double price = Double.parseDouble(tokens[1].trim()); //gets the price from the file
		Category cat = Category.valueOf(tokens[2].trim()); //gets the category from the file
		MenuItem item = new MenuItem(itemName, price, cat); 
		return item; 
	
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
