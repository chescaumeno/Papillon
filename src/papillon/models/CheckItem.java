package papillon.models;

import java.util.UUID;

public class CheckItem {
	private UUID id;
	private MenuItem item;
	private int quantity; 
	
	public CheckItem(MenuItem item, int quantity) {
		this.id = UUID.randomUUID(); //random id and unlikely to repeat. Uniquely identifies the item
		this.item = item; 
		this.quantity = quantity; 
	}
	
	public double getSubtotal() {
		return (item.getPrice() * quantity); 
	}
	
	public MenuItem getMenuItem() {
		return item; 
		
	}

	public UUID getId() {
		return id; 
	}
	
	@Override
	public String toString() {
		String shortName = item.getName();  
		if (shortName.length() >= 13) {
			shortName = shortName.substring(0, 13); 
		
		}
		String checkItemString = shortName+ "\t" + quantity + "\t" + (item.getPrice() * quantity);
		return checkItemString; 
	}
}
