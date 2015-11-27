package papillon.views;

import javax.swing.JButton;

import papillon.models.Category;

public class CategoryButton extends JButton{

	private Category category; 
	
	public CategoryButton(Category category) {
		this.category = category; 		
	}
	
	public Category getCategory() {
		return category;
	}
	
}
