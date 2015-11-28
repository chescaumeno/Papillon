package papillon.views;

import javax.swing.JButton;

import papillon.models.MenuItem;

public class MenuItemButton extends JButton {

	private MenuItem item;  
	
	public MenuItemButton(MenuItem item) {
		super(formatName(item.getName()));
		this.item = item; 
	}
	
	public MenuItem getMenuItem() {
		return item; 
	}
	
	private static String formatName(String name) {
		String modName = name.replace(" ", "<br>");
		return "<html><center>" + modName + "</center></html>"; 
		
	}
}
