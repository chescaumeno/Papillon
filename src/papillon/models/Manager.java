package papillon.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//store information for the manager
import java.util.ArrayList;

public class Manager implements Serializable{
	
	public static final String[] MANAGER_AND_ID = {"Mark Robinson", "8405"};
	public static int FRAME_WIDTH = 1024; 
    public static int FRAME_HEIGHT = 768;

	private String name;
	private String id;

	private ArrayList<Check> closedChecks;
	private int currentCheck; // check index in the list
	private int checkNum;
	
	private final File eodFolder;

	public Manager(String nm, String id) {
		this.name = nm;
		this.id = id;
		closedChecks = new ArrayList<Check>();
		currentCheck = -1;
		checkNum = 0;
		eodFolder = new File("src/papillon/resources/endDayReports");
	}

	public void nextCheck() {
		if ((currentCheck + 1) < checkNum) {
			currentCheck++;
		}
	}

	public void previousCheck() {
		if (currentCheck >= 1) {
			currentCheck--;
		}
	}

	public void addClosedCheck(Check check) {
		for (Check c : closedChecks) {
			if (c.getInvoiceNumber() == check.getInvoiceNumber()) {
				return;
			}
		}
		closedChecks.add(check);
	}

	public int writeDayReportToFile(EndDayReport eodReport) {
		FileOutputStream out = null;
		ObjectOutputStream outStream = null;
		String eodName = eodReport.getReportName();
		String filePath = eodFolder + "/";
		String fileName = filePath + eodName + ".ser";
		File file = new File(fileName);
		try {
			out = new FileOutputStream(file);
			outStream = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
			outStream.writeObject(eodReport);
			outStream.close();
			out.close();
			return (0);
		} catch (IOException e) {
			System.err.println("Error writing report object to file for report " + eodName);
			e.printStackTrace();
		}
		return (-1);
	}

	public EndDayReport loadDayReportFromFile(String fileName) {
		EndDayReport eodReport = null;
		FileInputStream in = null;
		ObjectInputStream inStream = null;
		try {
			in = new FileInputStream(fileName);
			inStream = new ObjectInputStream(in);
			eodReport = (EndDayReport) inStream.readObject();
			inStream.close();
			in.close();
		} catch (IOException e) {
			System.err.println("Error reading report object from file for report file " + fileName);
		} catch (ClassNotFoundException e) {
			// Not sure how that would even happen...
		}
		return (eodReport);
	}
	
	public ArrayList<String> getEODFileNames(){
		ArrayList<String> eodFileNames = new ArrayList<String>();
		for (final File fileEntry : eodFolder.listFiles()) {
	            System.out.println(fileEntry.getName());
	            eodFileNames.add(fileEntry.getName());
	    }
		return(eodFileNames);
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Check> getClosedChecks() {
		return closedChecks;
	}
	
	public ArrayList<Integer> getClosedInvoices(){
		ArrayList<Integer> closedInvoices = new ArrayList<Integer>();
		for(Check check : closedChecks){
			closedInvoices.add(check.getInvoiceNumber());
		}
		return closedInvoices;
	}
	
	public Check getClosedCheck(int invoice){
		for(Check check : closedChecks){
			if(check.getInvoiceNumber() == invoice){
				return check;
			}
		}
		return null;
	}
}
