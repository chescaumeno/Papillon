package papillon;


public class Server {
	
	private String firstName;
	
	private String lastName;
	
	private String ssn;
	
	private static int ID;
	
	//Need to create the Check class first
	//private ArrayList<Check> checks = new ArrayList<Check>();
	
	/**
	 * Assumes that the ssn is entered in format "ddd-dd-dddd"
	 * and uses the last four digits as that server's id number
	 * @param firstName
	 * @param lastName
	 * @param ssn
	 */
	Server(String firstName, String lastName, String ssn){
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		String[] tokens = ssn.split("-");
		ID = Integer.parseInt(tokens[2]);
	}
}
