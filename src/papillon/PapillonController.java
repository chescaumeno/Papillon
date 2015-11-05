package papillon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class manages interaction with the main menu GUI's Category Panel buttons
 * @author Lymari Montijo, Anna F. Umeno, Nanette Springer, Matt New, Caleb Mussulman
 *
 */
public class PapillonController implements ActionListener{

	private PapillonModel model; 
	private PapillonView view; 
	
	public PapillonController(PapillonModel model, PapillonView view) {
		this.model = model; 
		this.view = view; 
	}
	
	/**
	 * Actions performed when user interacts with main menu UI
	 * @param e An action event within the main menu UI
	 */
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equalsIgnoreCase("Drinks")) {
			model.menuSwitcher(1);
			view.itemsPanelSwitcher(model.whichPanel());
		} else if (command.equalsIgnoreCase("Appetizers")) {
			model.menuSwitcher(2);
			view.itemsPanelSwitcher(model.whichPanel());
		} else if (command.equalsIgnoreCase("Sides")) {
			model.menuSwitcher(3); 
			view.itemsPanelSwitcher(model.whichPanel());
		} else if (command.equalsIgnoreCase("Entreés")) {
			model.menuSwitcher(4);
			view.itemsPanelSwitcher(model.whichPanel());
		} else if (command.equalsIgnoreCase("Desserts")) {
			model.menuSwitcher(5);
			view.itemsPanelSwitcher(model.whichPanel());
		}
		
	}
	
}

		
