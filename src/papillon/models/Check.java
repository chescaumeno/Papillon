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
	private int number; // invoice number
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
		number = invoiceNum; //we will search invoice number 	
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
		return number; 
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
	
}