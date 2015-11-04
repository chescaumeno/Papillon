package papillon;

public class Desserts extends Item {
	
	private String[] initialDesserts = { "Green tea mochi", "Red Bean Mochi", "Black Sesame Mochi", "Chocolate Mochi",
			"Strawberry Mochi", "Coffee Mochi", "Oreo Tempura", "Banana Tempura", "Cheesecake" };
	
	private double price = 7.99;
	
	public Desserts(){
		for(int i = 0; i < initialDesserts.length; i++){
			super.addNewItem(initialDesserts[i], price);
		}
	}
}
