package papillon.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ManagerView extends JFrame{
	private JPanel managerPanel;
	private Font fontOne;
	
	private JButton reportButton = new JButton("Close Reprot");
	private JButton logoutButton = new JButton("Logout");
	
	
	
	
	/*
	 *   Constructor - Initialize the login window frame
	 */
	public ManagerView(){
		setTitle("Manager's View");
		setSize(500,700);
		setLayout(new BorderLayout(0,0));
		fontOne = new Font("Verdana", Font.BOLD, 15);
		
		//Buttons 
		JPanel managerPanel = new JPanel(new GridLayout(2,1,0,0));
		//managerPanel.setLayout(new BorderLayout());
		
		managerPanel.add(reportButton);
		managerPanel.add(logoutButton);
		managerPanel.setBackground(Color.white);
		
		reportButton.setBackground(Color.black);
		reportButton.setForeground(Color.white);
		reportButton.setFont(fontOne);
		logoutButton.setBackground(Color.black);
		logoutButton.setForeground(Color.white);
		logoutButton.setFont(fontOne);
		
		
		
		
		
		
	}
	
}