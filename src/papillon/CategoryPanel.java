package papillon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

/**
 * Contains the category buttons
 */
public class CategoryPanel extends JPanel {
    
    private JButton[] buttons;
    /**
     * Constructor
     */
    public CategoryPanel() {
        this.setPreferredSize(new Dimension(500, 100));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(1, 5, 10, 1));   
        this.setBorder(BorderFactory.createEmptyBorder(15, 1, 15, 1));
        
        String[] data = {"Drinks", "Appetizers", "Sides", "Entrees", "Desserts"};
        buttons = new JButton[data.length];
        
        for (int i = 0; i < data.length; i++) {
            buttons[i] = new JButton(data[i]); 
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(new Font("SansSerif", 0, 15));
            buttons[i].setBackground(new Color(60, 110, 200));
            buttons[i].setMargin(new Insets(5, 5, 5, 5));
            Dimension old = buttons[i].getPreferredSize();
            buttons[i].setPreferredSize(new Dimension((int)old.getWidth(), 70));
            add(buttons[i]);
        }
    }
    
    /**
     * Register the action listener
     * @param controller action controller
     */
    public void register(PapillonController controller) {
        for (int i = 0; i < buttons.length; i++)
            buttons[i].addActionListener(controller);
    }
}
