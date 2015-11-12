package papillon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * Contains the item buttons
 */

public class ItemPanel extends JPanel {

    JButton[] buttons;
    
    /**
     * Constructs the item panel
     * @param rows   total rows
     * @param cols   total columns
     * @param items  names
     * @param type   item type
     * @param color  button color
     */
    public ItemPanel(int rows, int cols, String[] items, String type, Color color) {
        super.setBackground(Color.white);        
        
        buttons = new JButton[rows * cols];
        
        setLayout(new BorderLayout());
        add(createBorderPanel(500, 30), BorderLayout.NORTH);
        add(createBorderPanel(500, 30), BorderLayout.SOUTH);
        add(createBorderPanel(30, 300), BorderLayout.WEST);
        add(createBorderPanel(30, 300), BorderLayout.EAST);
        
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.white);
        btnPanel.setLayout(new GridLayout(rows, cols, 15, 15));
        add(btnPanel, BorderLayout.CENTER);
        
        this.setBorder(BorderFactory.createLineBorder(new Color(205, 205, 240)));
        
        
        for (int i = 0; i < rows * cols; i++) {
            if (i < items.length) {                
                buttons[i] = new JButton("<html><center>" + 
                        items[i].replace("\n", "<br />") + "</center></html>");
                buttons[i].setActionCommand("item " + i + " " + type);
            }
            else {
                buttons[i] = new JButton();
            }
            buttons[i].setBackground(color);
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(new Font("SansSerif", Font.BOLD, 15));
            btnPanel.add(buttons[i]);
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

    /**
     * Register the action listener
     * @param controller action controller
     */
    public void register(PapillonController controller) {
        for (int i = 0; i < buttons.length; i++) {
            if (!buttons[i].getText().isEmpty())
                buttons[i].addActionListener(controller);
        }
    }
}
