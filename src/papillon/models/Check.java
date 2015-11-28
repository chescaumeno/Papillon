package papillon.models;
/**
 * Store information for check
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Check {
	private static final double TAX_RATE = 0.0825; 
	static SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yy hh:mm:ss a");
	
	private Server server; // server belongs to
	private int number; // invoice number
	private Date date;
	
	private ArrayList<CheckItem> checkItems; 
	
	private double subTotal;
	private double tax;
	private double tips;
	
	private boolean opened; // if the check is opened
	
	/**
	 * constructs the check with server and number
	 * @param server server
	 * @param num invoice number
	 */
	public Check(Server server, int num){
		this.server = server;
		number = num;		
		checkItems = new ArrayList<CheckItem>(); 
		
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
		
		return checkItem; 
	}
	
	public void removeCheckItem(CheckItem checkItem) {
		for (int i = 0; i < checkItems.size(); i++) {
			CheckItem c = checkItems.get(i);
			if (c.getId() == checkItem.getId()) {
				checkItems.remove(i);
				subTotal -= c.getSubtotal(); 
				return;
			}
		}
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
	
	public Server getServer(){
		return server;
	}
	
	public double getSubTotal(){
		return subTotal;
	}
	
	public double getTax(){
		return tax;
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
}