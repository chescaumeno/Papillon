package papillon.views;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import papillon.controllers.LoginController;

/**
 * This class manages the login view GUI layout
 * @author Anna Umeno, Lymari Montijo, Caleb Mussulman, Matt New, Nanette Springer
 *
 */
public class LoginView extends JFrame {
	private JPanel loginPanel;
	private JPanel logoPanel;
	private JPanel displayPanel;
	private JPanel numPadPanel;
	
	private JLabel pinDisplay;
	
	private JButton loginButton;
	
	private Font font, fontHash;
	
	private int digits;

	/**
	 * Constructor - Initialize the login window frame
	 */
	public LoginView() {
		setTitle("Papillon POS System");
		setSize(500, 700);
		setLayout(new BorderLayout(0,0));
		font = new Font("Verdana", Font.BOLD, 20);
		fontHash = new Font("Verdana", Font.PLAIN, 55);
		
		//Will display papillon logo on login screen
		logoPanel = new JPanel();      
		logoPanel.add(new JLabel(new ImageIcon(getClass().getResource("logo.jpg"))));
		add(logoPanel, BorderLayout.NORTH);
		
		//Create display that will show hashed pin entered
		displayPanel = new JPanel(new BorderLayout());
		pinDisplay = new JLabel("Enter PIN");
		pinDisplay.setFont(fontHash);
		pinDisplay.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
		pinDisplay.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
		displayPanel.add(pinDisplay);
		digits = -1;
		add(displayPanel, BorderLayout.CENTER);

		//Create number pad where user can enter pin
		numPadPanel = new JPanel();
		numPadPanel.setLayout(new GridLayout(4,3,0,0));
		String[] numPadStrings = {
				"1", "2", "3",
				"4", "5", "6",
				"7", "8", "9",
			"Clear", "0", "Login"
		};
		for(String s: numPadStrings){
			JButton numPadButton = new JButton(s);
			numPadButton.setPreferredSize(new Dimension(100,100));
			numPadPanel.add(numPadButton);
		}

		add(numPadPanel, BorderLayout.SOUTH);
		setVisible(true);
}
	
	public void registerListener(LoginController controller){
		
		Component[] components = numPadPanel.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;

				button.addActionListener(controller);
				button.setFont(font);
			}
		}
	}
	
	/**
	 * Display the value in the JLabel of the pin display.
	 * 
	 * @param value the value to be displayed
	 */
	public void update(String value) {
		if (digits < 0) {
			pinDisplay.setText(value);
		} 
	}
	

	/////////////////////////////////////////////////////////////////////////////////////////////
	//**************************		GETTERS AND SETTERS		*******************************//
	/////////////////////////////////////////////////////////////////////////////////////////////
	public void setDigits(int digits){
		this.digits = digits;
	}
	public JPanel getLoginPanel() {
		return loginPanel;
	}

	public void setLoginPanel(JPanel loginPanel) {
		this.loginPanel = loginPanel;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}
	
	public JLabel getPinDisplay() {
		return pinDisplay;
	}
}
