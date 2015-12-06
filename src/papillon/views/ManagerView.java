package papillon.views;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import papillon.controllers.ManagerController;
import papillon.models.Manager;

public class ManagerView extends JFrame{
	
	private Manager manager;
	
	private JPanel buttonPanel;
	private JList<Integer> invoiceList;
	private JScrollPane invoiceScroller;
	private JPanel checkPanel;
	private Font fontOne;
	
	private JButton[] viewButtons = {new JButton("Open Checks"), new JButton("Lookup Invoice"), new JButton(""),
								     new JButton("Closed Checks"), new JButton("Produce EOD Sales Report"), new JButton("Logout")};	

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
		
		invoiceList = new JList<Integer>();
		invoiceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		invoiceList.setVisibleRowCount(-1);
		
		invoiceScroller = new JScrollPane(invoiceList);
		invoiceScroller.setPreferredSize(new Dimension(250,500));
		
		add(invoiceScroller, BorderLayout.WEST);
		
		for(JButton button : viewButtons){
			button.setBackground(Color.black);
			button.setForeground(Color.white);
			button.setFont(fontOne);
			buttonPanel.add(button);
		}
		viewButtons[2].setVisible(false);
		
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
	
	public void setInvoiceDisplay(Integer[] invoiceNums){
		invoiceList.setListData(invoiceNums);
	}
	
}