package papillon.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import papillon.controllers.MenuController;
import papillon.models.Category;

/**
 * Contains the category buttons
 */
public class CategoryPanel extends JPanel {
    
    private ArrayList<CategoryButton> buttons;

    /**
     * Constructor
     */
    public CategoryPanel(MenuController menuCtrl, ActionListener listener) {
        this.setPreferredSize(new Dimension(500, 100));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(1, 5, 10, 1));   
        this.setBorder(BorderFactory.createEmptyBorder(15, 1, 15, 1));
        
        buttons = new ArrayList<CategoryButton>();
        
        for (Category cat : menuCtrl.getMenuCategories()) {
        	CategoryButton btn = new CategoryButton(cat);

        	btn.setText(cat.toString());
            btn.setForeground(Color.white);
            btn.setFont(new Font("SansSerif", 0, 15));
            btn.setBackground(cat.color);
            btn.setMargin(new Insets(5, 5, 5, 5));
            Dimension old = btn.getPreferredSize();
            btn.setPreferredSize(new Dimension((int)old.getWidth(), 70));
            btn.addActionListener(listener);
            
            buttons.add(btn);
            
            add(btn);
        }
    }

}
