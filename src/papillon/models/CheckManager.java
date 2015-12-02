package papillon.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * this class is going to store the checkItems during the day. 
 * 
 * @author limecakes
 *
 */
public class CheckManager {

	private SimpleDateFormat formatter; 
	private Date date;	
	private ArrayList<Check> checks; 
	
	public CheckManager() {
		checks = new ArrayList<Check>(); 
		date = new Date(); 
		formatter = new SimpleDateFormat("MM/dd/yy hh:mm:ss a");
		
	}
	
	public String getDateString() {
		String dateString = formatter.format(this.date); 
		return dateString; 
	}
	
	public void add(Check check) {
		checks.add(check); 
	}
	
//	public Check getCheck(int invoiceNum) {
//		//this class will search in a HashMap???
//	}
	
	// In the manager view, when the manager hits END of Day Sales Report 
	// the checkManager class will export or write the report based on the checkItems 
	//ArrayList. When the report is generated. CheckManager will have a clear() method that will reset
	//the arrayList for the next bussiness day. 
	
}
