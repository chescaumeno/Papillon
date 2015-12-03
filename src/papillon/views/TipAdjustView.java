package papillon.views;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import papillon.controllers.*;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TipAdjustView extends JFrame {
	private JPanel displayPanel;
	private JPanel numPadPanel;
	private JPanel addTipPanel;
	
	private JTextArea tipDisplay;
	
	private JButton addTipButton;
	
	private Font font;
	
	private int digits;
	


	/**
	 * Constructor - Initialize the login window frame
	 * @param checkCtrl 
	 */
	public TipAdjustView() {
		setTitle("Papillon | Tip Adjust");
		setSize(450, 525); //525
		getContentPane().setLayout(new BorderLayout(0,0));
		font = new Font("Verdana", Font.PLAIN, 55);
		
		//Create display that will show hashed pin entered
		displayPanel = new JPanel(new BorderLayout());
		tipDisplay = new JTextArea("$0.00");
		tipDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		tipDisplay.setFont(font);
		tipDisplay.setBackground(Color.WHITE);
		tipDisplay.setEditable(false);
		displayPanel.add(tipDisplay);
		digits = -1;
		add(displayPanel, BorderLayout.NORTH);

		//Create number pad where user can enter pin
		numPadPanel = new JPanel();
		numPadPanel.setLayout(new GridLayout(4,3,0,0));
		String[] numPadStrings = {
				"1", "2", "3",
				"4", "5", "6",
				"7", "8", "9",
			"Clear", "0", "Enter"
		};
		for(String s: numPadStrings){
			JButton numPadButton = new JButton(s);
			numPadButton.setFont(new Font("SansSerif", Font.BOLD, 20));
			numPadButton.setPreferredSize(new Dimension(100,100));
			numPadPanel.add(numPadButton);
		}

		add(numPadPanel, BorderLayout.CENTER);
		
		setVisible(true);
}
	

	public void registerListener(TipAdjustController controller){
		
		Component[] components = numPadPanel.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
			}
		}
		//addTipButton.addActionListener(controller);
	}
	
	/**
	 * Display the value in the JLabel of the pin display.
	 * 
	 * @param value the value to be displayed
	 */
	public void update(String value) {
		if (digits < 0) {
			tipDisplay.setText(value);
		} 
	}
	
    
	/////////////////////////////////////////////////////////////////////////////////////////////
	//**************************		GETTERS AND SETTERS		*******************************//
	/////////////////////////////////////////////////////////////////////////////////////////////
	public void setDigits(int digits){
		this.digits = digits;
	}
	
	public JTextArea getTipDisplay() {
		return tipDisplay;
	}
}
