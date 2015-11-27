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

	/**
	 * add the item to current check. If current check does not exist then
	 * create one.
	 * 
	 * @param item
	 *            new item
	 */
	public void addItemToCheck(Item item) {
		if (currentCheck >= 0 && currentCheck < checks.size()) {
			Check current = checks.get(currentCheck);
			if (current.isOpened())
				current.addItem(item);
		} else {
			currentCheck = checks.size();
//			Check newCheck = new Check(this, PapillonModel.newInvoiceNumber());
//			newCheck.addItem(item);
//			checks.add(newCheck);
		}
	}

	/**
	 * clear current check
	 */
	public void clearCheck() {
		Check check = getCurrentCheck();
		if (check != null) {
			check.clearItems();
		}
	}

	/**
	 * Get current check
	 * 
	 * @return current check
	 */
	public Check getCurrentCheck() {
		// TODO(limecakes)
		if (currentCheck >= 0 && currentCheck < checks.size()) {
//			return checks.getCurrentCheck;
			return null;
		}
		return null;
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