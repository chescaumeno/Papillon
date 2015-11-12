package papillon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

/**
 * Contains the check information
 */

public class CheckPanel extends JPanel {
 
    private JTextArea txtInfo = new JTextArea();
    private JButton buttonLook = new JButton("Invoice Lookup");
    private JButton buttonUp = new JButton("\u25b2");
    private JButton buttonDown = new JButton("\u25bc");
    private JButton buttonLeft = new JButton("\u25c4");
    private JButton buttonRight = new JButton("\u25ba");
    
    /**
     * Constructor
     */
    public CheckPanel() {
        setBorder(BorderFactory.createLineBorder(new Color(205, 205, 240)));
        setLayout(new BorderLayout());
        JScrollPane scr = new JScrollPane(txtInfo);
        add(scr, BorderLayout.CENTER);
        scr.setBorder(null);
        
        JPanel pnbtn = new JPanel(new BorderLayout());
        pnbtn.setBackground(Color.white);
        JPanel pnbtn1 = new JPanel(new GridLayout(1, 2));
        pnbtn1.setBackground(Color.white);
        JPanel tmp = new JPanel();
        tmp.setBackground(Color.white);
        pnbtn1.add(tmp);  // left empty
        pnbtn1.add(buttonLook);
        pnbtn.add(pnbtn1, BorderLayout.NORTH);        
        pnbtn1.setPreferredSize(new Dimension(200, 35));
        buttonLook.setFont(new Font("SansSerif", Font.BOLD, 10));
        buttonLook.setBackground(Color.blue);
        buttonLook.setForeground(Color.white);
        buttonLook.setMargin(new Insets(0,0,0,0));
        
        buttonUp.setBorderPainted(false);
        buttonDown.setBorderPainted(false);
        buttonLeft.setBorderPainted(false);
        buttonRight.setBorderPainted(false);
        buttonUp.setBackground(Color.green);
        buttonDown.setBackground(Color.green);
        buttonLeft.setBackground(Color.green);
        buttonRight.setBackground(Color.green);
        buttonUp.setForeground(Color.blue);
        buttonDown.setForeground(Color.blue);
        buttonLeft.setForeground(Color.blue);
        buttonRight.setForeground(Color.blue);
        Font txtFont = new Font("SansSerif", Font.BOLD, 20);
        buttonUp.setFont(txtFont);
        buttonDown.setFont(txtFont);
        buttonLeft.setFont(txtFont);
        buttonRight.setFont(txtFont);
        buttonUp.setActionCommand("UP");
        buttonDown.setActionCommand("DOWN");
        buttonLeft.setActionCommand("LEFT");
        buttonRight.setActionCommand("RIGHT");

        JPanel pnbtn2 = new JPanel(new GridLayout(1, 4));
        pnbtn2.setBackground(Color.white);
        pnbtn2.add(buttonUp);
        pnbtn2.add(buttonDown);
        pnbtn2.add(buttonLeft);
        pnbtn2.add(buttonRight);
        pnbtn.add(pnbtn2, BorderLayout.CENTER);        
        pnbtn.setPreferredSize(new Dimension(200, 90));
        
        add(pnbtn, BorderLayout.SOUTH);
        
    }

    /**
     * Register the action listener
     * @param controller action controller
     */
    public void register(PapillonController controller) {
        buttonLook.addActionListener(controller);
        buttonUp.addActionListener(controller);
        buttonDown.addActionListener(controller);
        buttonLeft.addActionListener(controller);
        buttonRight.addActionListener(controller);
    }
}
