package papillon.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * this class is going to store the checkItems during the day. 
 * 
 * @author limecakes
 *
 */
public class CheckManager implements Serializable{

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
	
	public void endOfDayReport(){
		
	}
	
	public int writeCheckToFile(Check check){
		FileOutputStream out = null;
		ObjectOutputStream outStream = null;
		int invoice = check.getInvoiceNumber();
		String filePath = "src/papillon/resources/serializedChecks/";
		String fileName = filePath + invoice + ".ser";
		File file = new File(fileName);
		try{
			out = new FileOutputStream(file);
			outStream = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
			outStream.writeObject(check);
			outStream.close();
			out.close();
			return(0);
		}catch(IOException e){
			System.err.println("Error writing check object to file for check " + invoice);
			e.printStackTrace();
		}
		return(-1);
	}
	
	public static Check loadCheckFromFile(int invoice){
		Check check = null;
		FileInputStream in = null;
		ObjectInputStream inStream = null;
		String filePath = "src/papillon/resources/serializedChecks/";
		String fileName = filePath + invoice + ".ser";
		try{
			in = new FileInputStream(fileName);
			inStream = new ObjectInputStream(in);
			check = (Check) inStream.readObject();
			inStream.close();
			in.close();
		}catch(IOException e){
			System.err.println("Error reading check object from file for check " + invoice);
		}catch(ClassNotFoundException e){
			//Not sure how that would even happen...
		}
		return(check);
	}
	
	
	// In the manager view, when the manager hits END of Day Sales Report 
	// the checkManager class will export or write the report based on the checkItems 
	//ArrayList. When the report is generated. CheckManager will have a clear() method that will reset
	//the arrayList for the next business day. 
	
}
