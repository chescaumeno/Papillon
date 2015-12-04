package papillon.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import papillon.controllers.ManagerController;
import papillon.models.Manager;

public class ManagerView extends JFrame{
	
	Manager manager;
	
	private JPanel managerPanel;
	private JPanel buttonPanel;
	private JList<Integer> invoiceList;
	private JScrollPane invoiceScroller;
	private JPanel checkPanel;
	private Font fontOne;
	
	private JButton reportButton = new JButton("Produce EOD Sales Report");
	private JButton logoutButton = new JButton("Logout");
	private JButton mainViewButton = new JButton("Main View");
	private JButton invoiceButton= new JButton("Lookup Invoice");
	
	private Integer[] testArray = {103333, 453453, 332345234, 55234525,1,1,15,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,3,4,4};
	

	/*
	 *   Constructor - Initialize the login window frame
	 */
	public ManagerView(Manager manager){
		super("Manager's View | " + manager.getName());
		this.manager = manager;
		setSize(500,700);
		setLayout(new BorderLayout(0,0));
		fontOne = new Font("Verdana", Font.BOLD, 15);
		
		buttonPanel = new JPanel(new GridLayout(2,2,100,20));
		buttonPanel.setSize(500,200);
		
		invoiceList = new JList<Integer>(testArray);
		invoiceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		invoiceList.setVisibleRowCount(-1);
		
		invoiceScroller = new JScrollPane(invoiceList);
		invoiceScroller.setPreferredSize(new Dimension(250,500));
		
		add(invoiceScroller, BorderLayout.CENTER);
		
		//Buttons 
		managerPanel = new JPanel(new GridLayout(2,1,0,0));
		//managerPanel.setLayout(new BorderLayout());
		//add(managerPanel, BorderLayout.CENTER); 
		
		/*
		managerPanel.add(reportButton);
		managerPanel.add(logoutButton);
		managerPanel.add(mainViewButton);
		managerPanel.setBackground(Color.white);
		*/

		
		reportButton.setBackground(Color.black);
		reportButton.setForeground(Color.white);
		reportButton.setFont(fontOne);
		logoutButton.setBackground(Color.black);
		logoutButton.setForeground(Color.white);
		logoutButton.setFont(fontOne);
		mainViewButton.setBackground(Color.black);
		mainViewButton.setForeground(Color.white);
		mainViewButton.setFont(fontOne);
		invoiceButton.setBackground(Color.black);
		invoiceButton.setForeground(Color.white);
		invoiceButton.setFont(fontOne);
		
		buttonPanel.add(invoiceButton);
		buttonPanel.add(reportButton);
		buttonPanel.add(mainViewButton);
		buttonPanel.add(logoutButton);
		
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void registerListener(ManagerController controller){
		Component[] components = buttonPanel.getComponents();
		for(Component component : components){
			if(component instanceof AbstractButton){
				AbstractButton button = (AbstractButton) component;
				button.addActionListener(controller);
			}
		}
	}
	
}