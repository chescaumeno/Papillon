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
	
	Map<Category, ArrayList<MenuItem>> menuItemsByCategory;
	public static final String LUNCH_MENU_PATH = "src/papillon/resources/lunchMenu.csv";   
	public static final String DINNER_MENU_PATH = "src/papillon/resources/dinnerMenu.csv";
	
	public MenuController() {
		
		menuItemsByCategory = new HashMap<Category, ArrayList<MenuItem>>();
		for (Category category : Category.values()) {
			ArrayList<MenuItem> list = new ArrayList<MenuItem>(); 
			menuItemsByCategory.put(category, list); 
		}
		loadMenuFromFile(MenuController.LUNCH_MENU_PATH); 
	}

	private MenuItem createMenuItem(String currentLine) {
		String[] tokens = currentLine.split("\\s*,\\s*");
		String itemName = tokens[0].trim(); 
		double price = Double.parseDouble(tokens[1].trim());
		Category cat = Category.valueOf(tokens[2].trim()); 
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
	
	public void loadMenuFromFile(String path) {
		
		for (Category category : Category.values()) {
			menuItemsByCategory.get(category).clear();  
		}
		
		BufferedReader reader = null; 
		try { 
			reader = new BufferedReader(new FileReader(path));
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
	
				MenuItem item = createMenuItem(currentLine);
				ArrayList<MenuItem> list = menuItemsByCategory.get(item.getCategory()); 
				list.add(item); 
			}
			
		} catch(IOException ex) {
			System.out.println(ex.getMessage()); 
		}
	}

}


