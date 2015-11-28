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
	private Server dummy = new Server("Lymari", "12");  
	
	public CheckController() {
		checkActionPanel = new CheckActionPanel(this); //checActionPanel creates the checkPanel 
		checkPanel = checkActionPanel.getCheckPanel(); 
		testCheck = new Check(dummy, 1); 
		
	}
	public void addItemToCheck(MenuItem item) {
		CheckItem checkItem = testCheck.addCheckItem(item,  1); 
		checkPanel.setServerName(dummy.getName());
		checkPanel.setInvoice(testCheck.getInvoiceNumber()); 	
		checkPanel.setDate(testCheck.getDate());
		checkPanel.setCheckItems(testCheck.getCheckItems());
		checkPanel.setSubtotal(testCheck.getSubTotal());
		checkPanel.setTax(testCheck.getTax());
		checkPanel.setTotal(testCheck.getTotal());
		
		checkPanel.renderCheck();
		
	}
	
	public CheckActionPanel createCheckActionPanel() {
		return checkActionPanel;  
	}
	
	
	
	
}
