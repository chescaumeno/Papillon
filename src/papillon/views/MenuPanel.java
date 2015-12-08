package papillon.views;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import papillon.controllers.CheckController;
import papillon.controllers.MenuController;
import papillon.models.Category;

public class MenuPanel extends JPanel implements ActionListener {
	
	private MenuController menuCtrl;
	private CheckController checkCtrl;
	private Map<Category, ItemPanel> categoriesMap;
	private CategoryPanel categoryPanel;
	private ItemPanel currentCategoryPanel;
	

	public MenuPanel(MenuController controller, CheckController checkCtrl) {
		this.menuCtrl = controller;
		this.checkCtrl = checkCtrl;
		this.categoriesMap = new HashMap<Category, ItemPanel>();
		initializeMenu();
	}

	private void initializeMenu() {
		categoryPanel = new CategoryPanel(menuCtrl, this);
		
		ArrayList<Category> categories = menuCtrl.getMenuCategories();
		
		
		for (Category cat : categories) {
			ItemPanel p = new ItemPanel(4, 4, cat.color, cat, menuCtrl, checkCtrl);
			categoriesMap.put(cat, p);
		}
		
		currentCategoryPanel = categoriesMap.get(categories.get(0));
		
		setLayout(new BorderLayout());
		add(categoryPanel, BorderLayout.NORTH);
		add(currentCategoryPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object b = e.getSource();
		if (b instanceof CategoryButton) {
			CategoryButton catBtn = (CategoryButton) b;
			Category category = catBtn.getCategory(); 
			remove(currentCategoryPanel);
			currentCategoryPanel = categoriesMap.get(category);
			add(currentCategoryPanel, BorderLayout.CENTER);
			validate();
			repaint();
		}

	}
}
