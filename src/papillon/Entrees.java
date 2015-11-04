package papillon;

public class Entrees extends Item {
	
	private String[] initialEntrees = { "Tonkotsu Ramen", "Shoyu Ramen", "Veggie Ramen", "Tsukemen", "Miso Ramen",
			"Shoyu Ramen", "Shashu Don", "Gyu Don", "Oyako Don", "Unagi Don", "Kushi Age", "Chicken Yakitori",
			"Beef Negimaki", "Yakisoba", "Yakiudon", "Sashimi Sampler" };
	
	private double price = 7.99;
	
	public Entrees(){
		for(int i = 0; i < initialEntrees.length; i++){
			super.addNewItem(initialEntrees[i], price);
		}
	}
}
