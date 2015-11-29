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

	public int getQuantity() {
		return quantity; 
	}
}
