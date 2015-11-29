package papillon.models;

//store information for the server
import java.util.ArrayList;
import java.util.Random;

public class Server {

	private String name;
	private String id;

	private ArrayList<Check> checks;
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

		checks = new ArrayList<Check>();
		Check firstCheck = new Check(name, this.invoiceNumber());
		checks.add(firstCheck);
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

	public ArrayList<Check> getChecks() {
		return checks;
	}
	
	public Check getCurrentCheck(){
		return(checks.get(currentCheck));
	}
	
	public void startNewCheck(){
		Check newCheck = new Check(name, invoiceNumber());
		checks.add(newCheck);
		checkNum++;
		currentCheck = checkNum - 1;
	}
	
	
	public void nextCheck(){
		if((currentCheck + 1) < checkNum){
			currentCheck++;
		}else{
			this.startNewCheck();
		}
	}
	
	public void previousCheck(){
		if(currentCheck > 1){
			currentCheck--;
		}
	}
	
	//Temporarily made invoice num generator so we can see the different checks
	public int invoiceNumber(){
		Random rndm = new Random();
		return Math.abs(rndm.nextInt());//positive invoice numbers
	}
	
}