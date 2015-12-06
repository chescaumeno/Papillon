package papillon.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//store information for the manager
import java.util.ArrayList;

public class Manager {
	
	public static final String[] MANAGER_AND_ID = {"Mark Robinson", "8405"};
	public static int FRAME_WIDTH = 1024; 
    public static int FRAME_HEIGHT = 768;

	private String name;
	private String id;

	private ArrayList<Check> closedChecks;
	private int currentCheck; // check index in the list
	private int checkNum;

	public Manager(String nm, String id) {
		this.name = nm;
		this.id = id;
		closedChecks = new ArrayList<Check>();
		currentCheck = -1;
		checkNum = 0;
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

	public int writeCheckToFile(Check check) {
		FileOutputStream out = null;
		ObjectOutputStream outStream = null;
		int invoice = check.getInvoiceNumber();
		String filePath = "src/papillon/resources/serializedChecks/";
		String fileName = filePath + invoice + ".ser";
		File file = new File(fileName);
		try {
			out = new FileOutputStream(file);
			outStream = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
			outStream.writeObject(check);
			outStream.close();
			out.close();
			return (0);
		} catch (IOException e) {
			System.err.println("Error writing check object to file for check " + invoice);
			e.printStackTrace();
		}
		return (-1);
	}

	public Check loadCheckFromFile(int invoice) {
		Check check = null;
		FileInputStream in = null;
		ObjectInputStream inStream = null;
		String filePath = "src/papillon/resources/serializedChecks/";
		String fileName = filePath + invoice + ".ser";
		try {
			in = new FileInputStream(fileName);
			inStream = new ObjectInputStream(in);
			check = (Check) inStream.readObject();
			inStream.close();
			in.close();
		} catch (IOException e) {
			System.err.println("Error reading check object from file for check " + invoice);
		} catch (ClassNotFoundException e) {
			// Not sure how that would even happen...
		}
		return (check);
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
}
