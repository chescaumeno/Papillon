package papillon.views;

import javax.swing.JButton;

import papillon.models.MenuItem;

public class MenuItemButton extends JButton {

	private MenuItem item;  
	
	public MenuItemButton(MenuItem item) {
		super(item.getName());
		this.item = item; 
	}
	
	public MenuItem getMenuItem() {
		return item; 
	}
}
