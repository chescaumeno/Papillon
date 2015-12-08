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
	
	private JList<Integer> invoiceList;
	private JScrollPane invoiceScroller;
	
	private JPanel buttonPanel;
	private JPanel topPanel;
	private JList<String> reportList;
	private JScrollPane reportDisplay;
	
	private JTextArea checkText;
	private JScrollPane checkDisplay;
	private Font fontOne;
	
	
	private JButton[] viewButtons = {new JButton("Load File"), new JButton("Open Invoices"),
									 new JButton("Display Check"), new JButton("Produce EOD Report"),
									 new JButton("File's Invoices"), new JButton("Closed Invoices"),
									 new JButton("Display EOD Report"), new JButton("Logout")};
	
	public ManagerView(Manager manager){
		super("Manager's View | " + manager.getName());
		backPanel = new JPanel();
		backPanel.setLayout(new BorderLayout(50, 50));
		this.manager = manager;
		setSize(900,600);
		setLayout(new BorderLayout(0,0));
		fontOne = new Font("Verdana", Font.BOLD, 15);
		
		invoiceList = new JList<Integer>();
		invoiceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		invoiceList.setVisibleRowCount(-1);
		invoiceScroller = new JScrollPane(invoiceList);
		invoiceScroller.setPreferredSize(new Dimension(300,100));
		
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
	
		topPanel = new JPanel(new GridLayout(1,3));
		topPanel.setSize(250,200);
		

		buttonPanel = new JPanel(new GridLayout(2,4,50,20));
		buttonPanel.setSize(250,200);
		for(JButton button : viewButtons){
			button.setForeground(Color.white);
			button.setFont(fontOne);
			button.setBackground(Color.black);
			buttonPanel.add(button);
		}
		//Container topPanel = makeIt("Top", Component.TOP_ALIGNMENT);
		backPanel.add(invoiceScroller, BorderLayout.CENTER);
		backPanel.add(topPanel, BorderLayout.PAGE_START);
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
	public void displayReport(){
		
		
	}
	
	public void hideProduceReportButton(){
		for(JButton button : viewButtons){
			if(button.getText().equals("Produce EOD Sales Report")){
				button.setVisible(false);
			}
		}
	}
	
}