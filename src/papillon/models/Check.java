package papillon.models;
import java.io.Serializable;
/**
 * Store information for check
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextArea;


public class Check implements Serializable{
	private static final double TAX_RATE = 0.0825; 
	static SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yy hh:mm:ss a");
	
	private String server; // server belongs to
	private int invoiceNumber; // invoice number
	private Date date;
	private int currentItem;
	
	private ArrayList<CheckItem> checkItems; 
	
	private double subTotal;
	private double tax;
	private double tips;
	
	private boolean opened; // if the check is opened
	
	/**
	 * constructs the check with server and number
	 * @param server server
	 * @param invoiceNum invoice number
	 */
	public Check(String server, int invoiceNum){
		this.server = server;
		invoiceNumber = invoiceNum; //we will search invoice number 	
		checkItems = new ArrayList<CheckItem>();
		currentItem = -1;
		
		subTotal = 0;
		tax = 0;
		tips = 0;
		opened = true;
		date = new Date();
	}
	
	public CheckItem addCheckItem(MenuItem item, int quantity) { 
		CheckItem checkItem = new CheckItem(item, quantity); 
		checkItems.add(checkItem);
		subTotal += checkItem.getSubtotal();
		currentItem = checkItems.size() - 1;	
		return checkItem; 
	}
	
	public void removeCheckItem() {
		if(checkItems.size() > 0 && currentItem >= 0){
			CheckItem checkItem = checkItems.get(currentItem);
			subTotal -= checkItem.getSubtotal();
			checkItems.remove(currentItem);
		}
		currentItem--;
		if(checkItems.size() > 0 && currentItem < 0){
			currentItem = 0;
		}
	}
	
	public void resetCheck() {
		subTotal = 0;
		checkItems.clear();
		tax = 0;
		currentItem = -1;
	}

	public double getTotal() {
		double tax = TAX_RATE * subTotal; 
		double total = subTotal + tax; 
		return total; 
	}	
	//getters and setters
	public double getTips(){
		return tips;
	}
	public void setTips(double tips){
		this.tips = tips;
	}
	
	public boolean isOpened(){
		return opened;
	}
	public void setOpened(boolean opened){
		this.opened = opened;
	}
	
	public String getServer(){
		return server;
	}
	
	public double getSubTotal(){
		return subTotal;
	}
	
	public double getTax(){
		return subTotal * TAX_RATE;
	}
	

	public int getInvoiceNumber() {
		return invoiceNumber; 
	}

	public Date getDate() {
		return date; 

	}
	public ArrayList<CheckItem> getCheckItems() {
		return checkItems; 
	}
	
	public void nextItem(){
		if(currentItem < (checkItems.size() - 1)){
			currentItem++;
		}
	}
	
	public void previousItem(){
		if(currentItem > 0){
			currentItem--;
		}
	}
	
	public int getCurrentItem(){
		return currentItem;
	}
	
	public int getItemNum(){
		return (checkItems.size());
	}
	
	public String toString(){
		String result = "KYOTO SUSHI HOUSE\n"; 
    	result += "1 Sushi Way Ste 345\n"; 
    	result += "San Antonio, TX, 78260\n"; 
    	result += "210-555-6789\n"; 
    	result += "\n\n";  
    	
    	result += "Server: " + server + "\n";
		
		result += fmt.format(date) + "\n";
		result += "Invoice number: " + invoiceNumber + "\n\n";
		result += " ---------------------------  \n\n";
		
		for (CheckItem item: checkItems) {
			result += convertCheckItemToString(item); 
			result += "\n";  
		}
		
		result += "\n\n"; 
		result += "Subtotal:\t" + formatCurrency(subTotal) + "\n"; 
		result += "Tax:\t\t" + formatCurrency(tax) + "\n"; 
		result += "Total:\t\t" + formatCurrency(getTotal()) + "\n";
		result += "\nTip:\t\t" + formatCurrency(tips) + "\n";
		
		return result;
	}
	
	 public String formatCurrency(double d) {
	    	if(d < 10){
	    		return(String.format("$ %.2f", d));
	    	}
	    	return String.format("$%.2f", d); 
	 }
	 
	 public String convertCheckItemToString(CheckItem item) {
			String word = "             "; 
			String shortName = item.getMenuItem().getName() + word;   
			if (shortName.length() >= 13) {
				shortName = shortName.substring(0, 13);
			}
			String price = formatCurrency(item.getMenuItem().getPrice() * item.getQuantity()); 
			String checkItemString = shortName + "    " + item.getQuantity() + "    " + price;
			return checkItemString; 
		}
}