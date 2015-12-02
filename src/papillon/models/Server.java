package papillon.models;

import java.sql.Date;
import java.text.SimpleDateFormat;
//store information for the server
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Server {
	
	//Each element is an String array with two indices, the server and that server's id
	public static final String[][] SERVERS_AND_IDS = {{"Chesca Umeno", "6789"}, {"Lymari Montijo", "7890"}, {"Matt New", "8901"},
													  {"Caleb Mussulman", "9012"}, {"Nanette Springer", "1123"}};
	
	private String name;
	private String id;

	private ArrayList<Check> openChecks;
	private ArrayList<Check> closedChecks;
	private int currentCheck; // check index in the list
	private int checkNum;
	
	Random rndm = new Random();

	/**
	 * constructs the server
	 * 
	 * @param nm
	 *            name
	 * @param id
	 *            id
	 */
	public Server(String nm, String id) {
		this.name = nm;
		this.id = id;
		openChecks = new ArrayList<Check>();
		closedChecks = new ArrayList<Check>();
		
		Check firstCheck = new Check(name, this.invoiceNumber());
		openChecks.add(firstCheck);
		currentCheck = 0;
		checkNum = 1;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName() {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Check> getOpenChecks() {
		return openChecks;
	}
	
	public Check getCurrentCheck(){
		return(openChecks.get(currentCheck));
	}
	
	public void startNewCheck(){
		Check newCheck = new Check(name, invoiceNumber());
		openChecks.add(newCheck);
		checkNum++;
		currentCheck = checkNum - 1;
	}
	
	
	public void nextCheck(){
		if((currentCheck + 1) < checkNum){
			currentCheck++;
		}
	}
	
	public void previousCheck(){
		if(currentCheck >= 1){
			currentCheck--;
		}
	}
	
	public void closeCurrentCheck(){
		Check check = openChecks.get(currentCheck);
		if(check.getItemNum() > 0){//Makes sure we aren't adding multiple blank checks
			closedChecks.add(check);
		}
		openChecks.remove(currentCheck);
		currentCheck--;
		checkNum--;
		if(checkNum == 0){
			this.startNewCheck();
		}
		if(currentCheck == -1){
			currentCheck = 0;
		}
	}
	
	/**
	 * Creates unique invoice number using day+hours+minutes+milliseconds
	 * @return
	 */
	public int invoiceNumber(){
		SimpleDateFormat frmt = new SimpleDateFormat("ddkkmmS");
		Date date = new Date(System.currentTimeMillis());
		//return frmt.format(date);
		String invoice = frmt.format(date);
		int invoiceNum = Integer.parseInt(invoice);
		return invoiceNum;
	}
	
}