package papillon;

public class Sides extends Item {
	
	private String[] initialSides = { "Miso Soup", "Tori Zosui", "Sukiyaki Udon", "Tempura Udon", "Squid Salad",
			"Seaweed Salad", "Curry Rice", "Chashu Rice", "Negi Rice", "Brussel Sprouts", "Daikon Salad",
			"Okonomiyaki fries", "Takoyaki", "Kimchi", "Broccoli", "Garlic Bread" };
	
	private double price = 1.99;
	
	public Sides(){
		for(int i = 0; i < initialSides.length; i++){
			super.addNewItem(initialSides[i], price);
		}
	}
}
