package papillon;

public class PapillonModel {

	private int panel;

	public PapillonModel() {
		panel = 1; // default panel to display is the Drinks menu
	}

	public int whichPanel() {
		return panel;
	}

	public void menuSwitcher(int i) {
		panel = i; 
	}

}
