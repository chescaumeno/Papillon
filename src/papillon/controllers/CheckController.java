package papillon.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import papillon.models.Check;
import papillon.models.CheckItem;
import papillon.models.Manager;
import papillon.models.MenuItem;
import papillon.models.Server;
import papillon.models.TipAdjustModel;
import papillon.views.ActionPanel;
import papillon.views.CheckActionPanel;
import papillon.views.CheckPanel;
import papillon.views.TipAdjustView;

public class CheckController{
	
	private CheckActionPanel checkActionPanel;
	private CheckPanel checkPanel;
	private ActionPanel actionPanel; 
	private Server server;
	private Check currentCheck;

	private Manager manager;  //////new change
	
	public CheckController(Server server, Manager manager) {
		checkActionPanel = new CheckActionPanel(this); //checActionPanel creates the checkPanel 
		checkPanel = checkActionPanel.getCheckPanel(); 
		actionPanel = checkActionPanel.getActionPanel(); 
		this.server = server;
		currentCheck = server.getCurrentCheck();
		this.manager = manager; 
	}
	
	public void addItemToCheck(MenuItem item) {
		currentCheck.addCheckItem(item,  1); 
		this.update();
	}
	
	public void removeItemFromCheck(){
		currentCheck.removeCheckItem();
		this.update();
	}
	
	public void clearCheck(){
		currentCheck.resetCheck();
		checkPanel.setResult(checkPanel.getHeader());
		this.update();
	}
	public CheckActionPanel createCheckActionPanel(){
		return checkActionPanel;  
	}
	
	public void nextCheck(){
		server.nextCheck();
		this.update();
	}
	
	public void previousCheck(){
		server.previousCheck();
		this.update();
	}
	
	public void nextItem(){
		currentCheck.nextItem();
		this.update();
	}
	
	public void previousItem(){
		currentCheck.previousItem();
		this.update();
	}
	
	public void newCheck(){
		server.startNewCheck();
		this.update();
	}
	
	public void update(){
		currentCheck = server.getCurrentCheck();
		checkPanel.setServerName(server.getName());
		checkPanel.setInvoice(currentCheck.getInvoiceNumber()); 	
		checkPanel.setDate(currentCheck.getDate());
		checkPanel.setCheckItems(currentCheck.getCheckItems());
		checkPanel.setSubtotal(currentCheck.getSubTotal());
		checkPanel.setTax(currentCheck.getTax());
		checkPanel.setTotal(currentCheck.getTotal());
		checkPanel.setTip(currentCheck.getTips());
		checkPanel.renderCheck(); 
		actionPanel.updateSubtotal(currentCheck.getSubTotal());
		actionPanel.updateTax(currentCheck.getTax());
		actionPanel.updateTotal(currentCheck.getTotal());
	}
	
	public Check getCurrentCheck(){
		return currentCheck;
	}
	
	public void setCurrentCheck(Check check){
		currentCheck = check;
	}
	
	public Server getServer(){
		return server;
	}

//	public void closeCheck() {
//		checkManager.add(currentCheck); 
//		currentCheckClosed = true; 
//		newCheck(); 
//	}
	
	public void printCheck(){
		int invoice = currentCheck.getInvoiceNumber();
		String printOutput = checkPanel.getCheckFormat();
		String filePath = "src/papillon/resources/printOutput/";
		String fileName = filePath + invoice + ".txt";
		PrintWriter out = null;
		try{
			out = new PrintWriter(fileName);
		}catch(FileNotFoundException e){
			System.err.println("Error creating print output for invoice number " + invoice);
		}
		out.print(printOutput);
		out.close();		
	}
	
	public void payCheck(){
		//TODO may want to add some verification that the check was paid instead of only closing it
		Check closedCheck = server.closeCurrentCheck();
		if(closedCheck.getItemNum() > 0){
			manager.addClosedCheck(closedCheck);
		}
		this.update();
	}

	//Not sure what this is for. It's almost identical to update() function
	/*public void jumpUpdate() {
			checkPanel.setServerName(server.getName());
			checkPanel.setInvoice(currentCheck.getInvoiceNumber()); 	
			checkPanel.setDate(currentCheck.getDate());
			checkPanel.setCheckItems(currentCheck.getCheckItems());
			checkPanel.setSubtotal(currentCheck.getSubTotal());
			checkPanel.setTax(currentCheck.getTax());
			checkPanel.setTotal(currentCheck.getTotal());
			checkPanel.setTip(currentCheck.getTips());
			checkPanel.renderCheck(); 
			actionPanel.updateSubtotal(currentCheck.getSubTotal());
			actionPanel.updateTax(currentCheck.getTax());
			actionPanel.updateTotal(currentCheck.getTotal());
	}*/
	
	public void setTip(){
		TipAdjustView tipAdjView = new TipAdjustView();
		TipAdjustModel tipAdjModel = new TipAdjustModel(tipAdjView, this);
		TipAdjustController tipAdjCntrl = new TipAdjustController(tipAdjModel, tipAdjView);
		tipAdjView.registerListener(tipAdjCntrl);
	}

	public void invoiceLookup(){
		String input = JOptionPane.showInputDialog("Enter Invoice Number:");
		if(input != null){
			try{
				int inv = Integer.parseInt(input);
				if(!server.getInvoiceLookUpMap().containsKey(inv)){
					JOptionPane.showMessageDialog(null, "Invoice not found!");
				}
				else {
					server.setCurrentCheck(server.getInvoiceLookUpMap().get(inv));
					this.update();
	
				}
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Must enter integer format");
			}
		}
	}
}
