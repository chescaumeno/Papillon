package papillon.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ManagerView extends JFrame{
	private JPanel managerPanel;
	private Font fontOne;
	
	private JButton reportButton = new JButton("Produce EOD Sales Report");
	private JButton logoutButton = new JButton("Logout");
	private JButton mainViewButton = new JButton("Main View");
	

	/*
	 *   Constructor - Initialize the login window frame
	 */
	public ManagerView(){
		super("Manager's View");
		setSize(500,700);
		setLayout(new BorderLayout(0,0));
		fontOne = new Font("Verdana", Font.BOLD, 15);
		
		//Buttons 
		JPanel managerPanel = new JPanel(new GridLayout(2,1,0,0));
		//managerPanel.setLayout(new BorderLayout());
		add(managerPanel, BorderLayout.CENTER); 
		
		managerPanel.add(reportButton);
		managerPanel.add(logoutButton);
		managerPanel.add(mainViewButton);
		managerPanel.setBackground(Color.white);

		
		reportButton.setBackground(Color.black);
		reportButton.setForeground(Color.white);
		reportButton.setFont(fontOne);
		logoutButton.setBackground(Color.black);
		logoutButton.setForeground(Color.white);
		logoutButton.setFont(fontOne);
		
		mainViewButton.setBackground(Color.black);
		mainViewButton.setForeground(Color.white);
		mainViewButton.setFont(fontOne);
		
	
		
	}
	
}