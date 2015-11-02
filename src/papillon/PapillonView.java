package papillon;

import java.awt.*;
import javax.swing.*;

public class PapillonView extends JFrame {

	private JPanel categoryPanel;
	private JPanel appetizersPanel;
	private JPanel drinksPanel;
	private JPanel sidesPanel;
	private JPanel entreesPanel;
	private JPanel dessertsPanel;

	private Font font;

	public PapillonView() {

		super("Papillon Main View");
		font = new Font("Verdana", Font.BOLD, 20);

		categoryPanel = new JPanel();
		add(categoryPanel, BorderLayout.NORTH);
		categoryPanel.setBackground(Color.BLUE);

		String[] menuCategories = { "Drinks", "Appetizers", "Sides", "Entreés", "Desserts" };

		for (String s : menuCategories) {
			JButton newButton = new JButton(s);
			categoryPanel.add(newButton);
		}

		appetizersPanel = new JPanel();
		add(appetizersPanel, BorderLayout.CENTER);
		appetizersPanel.setLayout(new GridLayout(4, 4, 7, 7));
		appetizersPanel.setBackground(Color.ORANGE); 

		String[] appetizers = { "Edamame", "Spicy Edamame", "Pork Gyoza", "Veggie Gyoza", "Beef Sashimi",
				"Agedashi Tofu", "Shishito Peppers", "Beef Sashimi", "Crunchy Roll", "Dragon Roll", "Rainbow Roll",
				"Tuna Roll", "Texas Roll", "Tuna Sashimi", "Salmon Sashimi", "Shrimp Shumai" };

		
		for (String s : appetizers) {
			JButton button = new JButton(s);
			appetizersPanel.add(button);
			
		}

		drinksPanel = new JPanel();
		add(drinksPanel, BorderLayout.CENTER);
		drinksPanel.setLayout(new GridLayout(5, 4, 7, 7));
		drinksPanel.setBackground(Color.GREEN);

		String[] drinks = { "Coke", "Diet Coke", "Sprite", "Fanta", "Sweet Tea", "Bottled Water", "Ramune",
				"Ginger Ale", "Cumcumber Saketini", "Gingertini", "Mojito", "Backberry Smash", "Kiri Ichiban",
				"Sapporo Premium", "Shiner Bock", "Stella Artois", "White wine", "Red Whine", "Sparkling Wine",
				"Sake Sampler" };

		for (String s : drinks) {
			drinksPanel.add(new JButton(s));
		}

		sidesPanel = new JPanel();
		add(sidesPanel, BorderLayout.CENTER); 
		sidesPanel.setLayout(new GridLayout(4,4,7,7));
		sidesPanel.setBackground(Color.ORANGE);
		
		String[] sides = { "Miso Soup", "Tori Zosui", "Sukiyaki Udon", "Tempura Udon", 
				"Squid Salad", "Seaweed Salad", "Curry Rice", "Chashu Rice", 
				"Negi Rice", "Brussel Sprouts", "Daikon Salad", "Okonomiyaki fries",
				"Takoyaki", "Kimchi", "Broccoli", "Garlic Bread" };

		for(String s: sides) {
			sidesPanel.add(new JButton(s)); 
		}
		
		
		entreesPanel = new JPanel(); 
		add(entreesPanel, BorderLayout.CENTER); 
		entreesPanel.setLayout(new GridLayout(4,4,7,7));
		entreesPanel.setBackground(Color.ORANGE);
		
		String[] entrees = {"Tonkotsu Ramen", "Shoyu Ramen", "Veggie Ramen", "Tsukemen", 
							"Miso Ramen", "Shoyu Ramen", "Shashu Don", "Gyo Don", 
							"Oyako Don", "Unagi Don", "Kushi Agge", "Chicken Yakitori", 
							"Beef Negimaki", "Yakisoba", "Yakiudon", "Sashimi Sampler"
							};
		
		for (String s: entrees) {
			entreesPanel.add(new JButton(s)); 
		}
		
		
		dessertsPanel = new JPanel();  
		add(dessertsPanel, BorderLayout.CENTER); 
		dessertsPanel.setLayout(new GridLayout(3,3,7,7));
		dessertsPanel.setBackground(Color.PINK);
		
		String[] desserts = {"Green tea mochi", "Red Bean Mochi", "Black Sesame Mochi", 
							"Chocolate Mochi", "Strawberry Mochi", "Coffee Mochi", 
							"Oreo Tempura", "Banana Tempura", "Cheesecake"}; 
		
		for (String s: desserts) {
			dessertsPanel.add(new JButton(s)); 
		}

		
		
	}

	
	public void registerListener(PapillonController controller) {
		Component[] components = appetizersPanel.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component; 
																	
				button.addActionListener(controller);
				button.setFont(font);
			}
		}

		components = categoryPanel.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
				button.setFont(font);
			}
		}

		components = drinksPanel.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
				button.setFont(font);
			}
		}
		
		components = sidesPanel.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
				button.setFont(font);
			}
		}

		components = entreesPanel.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
				button.setFont(font);
			}
		}
		
		components = dessertsPanel.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
				button.setFont(font);
			}
		}
	}

	public void itemsPanelSwitcher(int whichPanel) {
		remove(appetizersPanel);
		remove(drinksPanel);
		remove(sidesPanel); 
		remove(entreesPanel); 
		remove(dessertsPanel); 
		if (whichPanel == 1) {
			add(drinksPanel, BorderLayout.CENTER);
		} else if(whichPanel == 2) {
			add(appetizersPanel, BorderLayout.CENTER);
		} else if (whichPanel == 3) {
			add(sidesPanel, BorderLayout.CENTER);
		} else if (whichPanel == 4) {
			add(entreesPanel, BorderLayout.CENTER); 
		} else if (whichPanel == 5) {
			add(dessertsPanel, BorderLayout.CENTER); 
		}
		validate();
		repaint();

	}

}
