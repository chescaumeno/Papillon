package papillon.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import papillon.models.Check;
import papillon.models.CheckItem;
import papillon.models.CheckManager;
import papillon.models.MenuItem;
import papillon.models.Server;
import papillon.views.ActionPanel;
import papillon.views.CheckActionPanel;
import papillon.views.CheckPanel;

public class CheckController{
	
	private CheckActionPanel checkActionPanel;
	private CheckPanel checkPanel;
	private ActionPanel actionPanel; 
	private Server server;
	private Check currentCheck;

	private CheckManager checkManager;  //////new change
	
	public CheckController(Server server) {
		checkActionPanel = new CheckActionPanel(this); //checActionPanel creates the checkPanel 
		checkPanel = checkActionPanel.getCheckPanel(); 
		actionPanel = checkActionPanel.getActionPanel(); 
		this.server = server;
		currentCheck = server.getCurrentCheck();
		checkManager = new CheckManager(); //////new change
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
	public CheckActionPanel createCheckActionPanel() {
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
		checkPanel.renderCheck(); 
		actionPanel.updateSubtotal(currentCheck.getSubTotal());
		actionPanel.updateTax(currentCheck.getTax());
		actionPanel.updateTotal(currentCheck.getTotal());
	}
	
	public Check getCurrentCheck(){
		return currentCheck;
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
		checkManager.add(closedCheck); 
		this.update();
	}

	
}
