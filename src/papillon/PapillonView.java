package papillon;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class PapillonView extends JFrame {

	private JPanel categoryPanel;
	private JPanel appetizersPanel;
	private JPanel drinksPanel;
	private JPanel sidesPanel;
	private JPanel entreesPanel;
	private JPanel dessertsPanel;
	private JPanel managementPanel;

	private String[] menuCategories = { "Drinks", "Appetizers", "Sides", "Entreés", "Desserts" };
	private String[] drinks = { "Coke", "Diet Coke", "Sprite", "Fanta", "Sweet Tea", "Bottled Water", "Ramune",
			"Ginger Ale", "Cucumber Saketini", "Gingertini", "Mojito", "Blackberry Smash", "Kirin Ichiban",
			"Sapporo Premium", "Shiner Bock", "Stella Artois", "White Wine", "Red Wine", "Sparkling Wine",
			"Sake Sampler" };
	private String[] appetizers = { "Edamame", "Spicy Edamame", "Pork Gyoza", "Veggie Gyoza", "Beef Sashimi",
			"Agedashi Tofu", "Shishito Peppers", "Beef Sashimi", "Crunchy Roll", "Dragon Roll", "Rainbow Roll",
			"Tuna Roll", "Texas Roll", "Tuna Sashimi", "Salmon Sashimi", "Shrimp Shumai" };
	private String[] sides = { "Miso Soup", "Tori Zosui", "Sukiyaki Udon", "Tempura Udon", "Squid Salad",
			"Seaweed Salad", "Curry Rice", "Chashu Rice", "Negi Rice", "Brussel Sprouts", "Daikon Salad",
			"Okonomiyaki fries", "Takoyaki", "Kimchi", "Broccoli", "Garlic Bread" };
	private String[] entrees = { "Tonkotsu Ramen", "Shoyu Ramen", "Veggie Ramen", "Tsukemen", "Miso Ramen",
			"Shoyu Ramen", "Shashu Don", "Gyu Don", "Oyako Don", "Unagi Don", "Kushi Age", "Chicken Yakitori",
			"Beef Negimaki", "Yakisoba", "Yakiudon", "Sashimi Sampler" };
	private String[] desserts = { "Green tea mochi", "Red Bean Mochi", "Black Sesame Mochi", "Chocolate Mochi",
			"Strawberry Mochi", "Coffee Mochi", "Oreo Tempura", "Banana Tempura", "Cheesecake" };
	private Font font;

	public PapillonView() {

		super("Papillon Main View");
		font = new Font("Verdana", Font.BOLD, 20);

		categoryPanel = new JPanel();
		add(categoryPanel, BorderLayout.NORTH);

		for (String s : menuCategories) {
			JButton newButton = new JButton(s);
			categoryPanel.add(newButton);
		}

		appetizersPanel = new JPanel();
		appetizersPanel = itemsPanelMaker(appetizersPanel, appetizers);

		sidesPanel = new JPanel();
		sidesPanel = itemsPanelMaker(sidesPanel, sides);

		entreesPanel = new JPanel();
		entreesPanel = itemsPanelMaker(entreesPanel, entrees);

		dessertsPanel = new JPanel();
		dessertsPanel = itemsPanelMaker(dessertsPanel, desserts);

		drinksPanel = new JPanel();
		add(drinksPanel, BorderLayout.CENTER); //makes the drinks panel the default on screen
		drinksPanel = itemsPanelMaker(drinksPanel, drinks);

		managementPanel = new JPanel();
		add(managementPanel, BorderLayout.SOUTH);
		managementPanel.setBackground(Color.WHITE);

		String[] managementChoices = { "Tip Adjust", "Manager View" };

		for (String s : managementChoices) {
			JButton mgmtButtons = new JButton(s);
			managementPanel.add(mgmtButtons);
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

		components = managementPanel.getComponents();
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
		} else if (whichPanel == 2) {
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

	public JPanel itemsPanelMaker(JPanel itemsPanel, String[] names) {

		if (names.length == 9) {
			itemsPanel.setLayout(new GridLayout(3, 3, 7, 7));
		} else {
			itemsPanel.setLayout(new GridLayout(4, 4, 7, 7));
		}
		JButton button;
		// Icon color = new ImageIcon(getClass().getResource("pink.jpg"));
		// button.setIcon(color);

		for (String s : names) {
			button = new JButton(s);
			itemsPanel.add(button);
		}

		/*
		 * for (String s : names) { if (s.contains(" ")) { String[] tokens =
		 * s.split(" ", 2); JLabel label1 = new JLabel(tokens[0]);
		 * label1.setFont(font);
		 * label1.setHorizontalAlignment(SwingConstants.CENTER); JLabel label2 =
		 * new JLabel(tokens[1]); label2.setFont(font);
		 * label2.setHorizontalAlignment(SwingConstants.CENTER);
		 * button.setLayout(new BorderLayout()); button.add(BorderLayout.NORTH,
		 * label1); button.add(BorderLayout.SOUTH, label2);
		 * itemsPanel.add(button);
		 * 
		 * } else {
		 * 
		 * JLabel label = new JLabel(s); label.setFont(font);
		 * label.setHorizontalAlignment(SwingConstants.CENTER);
		 * button.setLayout(new BorderLayout()); button.add(BorderLayout.CENTER,
		 * label); itemsPanel.add(button); } }
		 */

		return itemsPanel;
	}

}
