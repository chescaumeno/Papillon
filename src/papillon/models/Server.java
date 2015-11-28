package papillon.models;

//store information for the server
import java.util.ArrayList;

public class Server {

	private String name;
	private String id;

	private ArrayList<Check> checks;
	private int currentCheck; // check index in the list

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
		currentCheck = 0;
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
}