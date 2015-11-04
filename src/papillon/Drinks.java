package papillon;

/**
 * Until we are able to implement some sort of database to store the
 * items that the user has set up, I am just temporarily using the
 * String array and price value in each of these subclasses. That way,
 * we wont have to add all the stuff every time the program runs.
 * This is just to have a working skeleton of these classes.
 */
public class Drinks extends Item{
	
	private String[] initialDrinks = { "Coke", "Diet Coke", "Sprite", "Fanta", "Sweet Tea", "Bottled Water", "Ramune",
		"Ginger Ale", "Cucumber Saketini", "Gingertini", "Mojito", "Blackberry Smash", "Kirin Ichiban",
		"Sapporo Premium", "Shiner Bock", "Stella Artois", "White Wine", "Red Wine", "Sparkling Wine",
		"Sake Sampler" };
	
	private double price = 1.23;
	
	public Drinks(){
		for(int i = 0; i < initialDrinks.length; i++){
			super.addNewItem(initialDrinks[i], price);
		}
	}
}
