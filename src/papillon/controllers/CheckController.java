package papillon.controllers;

import papillon.models.Check;
import papillon.models.CheckItem;
import papillon.models.MenuItem;
import papillon.models.Server;
import papillon.views.CheckActionPanel;
import papillon.views.CheckPanel;

public class CheckController {
	
	private CheckPanel checkPanel;
	private CheckActionPanel checkActionPanel; 
	private Check testCheck; 
	private Server server;
	private Check currentCheck;
	
	public CheckController(Server server) {
		checkActionPanel = new CheckActionPanel(this); //checActionPanel creates the checkPanel 
		checkPanel = checkActionPanel.getCheckPanel(); 
		this.server = server;
		currentCheck = server.getCurrentCheck();
	}
	
	public void addItemToCheck(MenuItem item) {
		currentCheck = server.getCurrentCheck();
		currentCheck.addCheckItem(item,  1); 
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
	}
	
}
