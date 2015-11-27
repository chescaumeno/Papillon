package papillon.models;

public class MenuItem {
	private String name; 
	private double price; 
	private Category category; 
	
	public MenuItem(String name, double price, Category category) {
		this.name = name; 
		this.price = price; 
		this.category = category; 
	}

	public String getName() {
		return name; 
	}
	
	public double getPrice() {
		return price; 
	}
	
	public Category getCategory() {
		return category; 
	}
}
