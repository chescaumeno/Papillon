package papillon.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import papillon.controllers.CheckController;
import papillon.controllers.MenuController;
import papillon.models.Category;
import papillon.models.MenuItem;

/**
 * Contains the item buttons
 */

public class ItemPanel extends JPanel implements ActionListener {

    private Category category; 
    private CheckController checkCtrl; 
    private MenuController menuCtrl; 
    
    public ItemPanel(int rows, int cols, Color color,
    		Category category, MenuController menuCtrl, CheckController checkCtrl) {
    	
    	this.category = category; 
    	this.menuCtrl = menuCtrl; 
    	this.checkCtrl = checkCtrl; 
    	
    	setLayout(new BorderLayout());
        add(createBorderPanel(500, 30), BorderLayout.NORTH);
        add(createBorderPanel(500, 30), BorderLayout.SOUTH);
        add(createBorderPanel(30, 300), BorderLayout.WEST);
        add(createBorderPanel(30, 300), BorderLayout.EAST);
        
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.white);
        btnPanel.setLayout(new GridLayout(rows, cols, 15, 15));
        add(btnPanel, BorderLayout.CENTER);
        
        setBorder(BorderFactory.createLineBorder(new Color(205, 205, 240)));
        
        ArrayList<MenuItem> menuItems = menuCtrl.getMenuItems(category);
        
        for (MenuItem i : menuItems) {
        	MenuItemButton btn = new MenuItemButton(i);
        	btn.setBackground(color);
            btn.setForeground(Color.white);
            btn.setFont(new Font("SansSerif", Font.BOLD, 15));
            btn.addActionListener(this);
            btnPanel.add(btn);
        }
        
    }
   
    /**
     * Create blank panel
     * @param width
     * @param height
     * @return blank panel
     */
    private JPanel createBorderPanel(int width, int height) {
        JPanel tmp = new JPanel();
        tmp.setBackground(Color.white);
        tmp.setPreferredSize(new Dimension(width, height));
        return tmp;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// Check if the event comes from a MenuItem button
		Object o = e.getSource(); 
		if (o instanceof MenuItemButton) {
			MenuItemButton btn = (MenuItemButton) o; 
			MenuItem item = btn.getMenuItem(); 
			checkCtrl.addItemToCheck(item); 
		}
		
		//Now we can communicate with the check panel 
		
	}
}
