package papillon.views;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import papillon.controllers.CheckController;
import papillon.controllers.ManagerController;
import papillon.models.Check;
import papillon.models.Manager;

public class ManagerView extends JFrame{
	
	private Manager manager;
	
	private JPanel backPanel;
	
	private JPanel buttonPanel;
	private JList<Integer> invoiceList;
	private JScrollPane invoiceScroller;
	//private JPanel invoicePanel;
	
	private JTextArea checkText;
	private JScrollPane checkDisplay;
	private JPanel checkPanel;
	private Font fontOne;
	//report
	private JList<String> reportList;
	private JScrollPane reportDisplay;
	private JPanel reportPanel;

	
	private JButton[] viewButtons = {new JButton("Open Checks"), new JButton("Load Checks"), new JButton("Display Check"),
								     new JButton("Closed Checks"), new JButton("Produce EOD Sales Report"), new JButton("Logout")};	

	/*
	 *   Constructor - Initialize the login window frame
	 */
	public ManagerView(Manager manager){
		super("Manager's View | " + manager.getName());
		backPanel = new JPanel();
		backPanel.setLayout(new BorderLayout(50, 50));
		this.manager = manager;
		setSize(900,600);
		setLayout(new BorderLayout(0,0));
		fontOne = new Font("Verdana", Font.BOLD, 15);
		
		//BorderLayout(50, 50);
		
		invoiceList = new JList<Integer>();
		invoiceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		invoiceList.setVisibleRowCount(-1);
		invoiceScroller = new JScrollPane(invoiceList);
		invoiceScroller.setPreferredSize(new Dimension(300,100));
		

	//	JUST IN CASE WE NEED BORDER AGAIN
	//	invoicePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "check display", TitledBorder.CENTER, TitledBorder.TOP));
	
		
		//make report
		reportList = new JList<String>();
		reportList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		reportList.setVisibleRowCount(-1);
		reportList.setFont(new Font("monospaced", 0, 11));
		reportDisplay = new JScrollPane(reportList);
		reportDisplay.setPreferredSize(new Dimension(300,100));
		
		checkText = new JTextArea();
		checkText.setEditable(false);
		checkText.setFont(new Font("monospaced", 0, 11));
		checkDisplay = new JScrollPane(checkText);
		checkDisplay.setPreferredSize(new Dimension(300,100));
	


		buttonPanel = new JPanel(new GridLayout(2,3,100,20));
		buttonPanel.setSize(250,200);
		for(JButton button : viewButtons){
			button.setBackground(Color.black);
			button.setForeground(Color.white);
			button.setFont(fontOne);
			buttonPanel.add(button);
		}
		
		
		
		
		backPanel.add(invoiceScroller, BorderLayout.CENTER);
		
		//report
		backPanel.add(reportDisplay, BorderLayout.LINE_START);
		backPanel.add(checkDisplay, BorderLayout.LINE_END);
		backPanel.add(buttonPanel, BorderLayout.PAGE_END);
		
		add(backPanel, BorderLayout.CENTER);
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
	
	public void setReportDisplay(String[] reports){
		reportList.setListData(reports);
	}
	
	public int getSelectedInvoice(){
		int item = -1;
		if(invoiceList.getSelectedIndex() >= 0){
			item = invoiceList.getSelectedValue();
		}
		return item;
	}
	
	public String getSelectedReportFile(){
		String file = null;
		if(reportList.getSelectedIndex() >= 0){
			file = reportList.getSelectedValue();
		}
		return file;
	}
	
	public void displayText(String text){
		checkText.setText(text);
	}
	
	//eod report
	public void displayReprot(){
		
	}
	
	public void hideProduceReportButton(){
		for(JButton button : viewButtons){
			if(button.getText().equals("Produce EOD Sales Report")){
				button.setVisible(false);
			}
		}
	}
	
}