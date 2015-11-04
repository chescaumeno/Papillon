package papillon;

public class Appetizers extends Item{
	
	private String[] initialApps = { "Edamame", "Spicy Edamame", "Pork Gyoza", "Veggie Gyoza", "Beef Sashimi",
			"Agedashi Tofu", "Shishito Peppers", "Beef Sashimi", "Crunchy Roll", "Dragon Roll", "Rainbow Roll",
			"Tuna Roll", "Texas Roll", "Tuna Sashimi", "Salmon Sashimi", "Shrimp Shumai" };
	
	private double price = 5.99;
	
	public Appetizers(){
		for(int i = 0; i < initialApps.length; i++){
			super.addNewItem(initialApps[i], price);
		}
	}
}
