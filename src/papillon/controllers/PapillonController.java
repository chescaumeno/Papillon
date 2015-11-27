package papillon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import papillon.models.Check;
import papillon.models.PapillonModel;
import papillon.views.MainView;

/**
 * Implements the listener
 */

public class PapillonController implements ActionListener {

	private MainView view;
	private PapillonModel model;

	/**
	 * Constructor with view
	 * 
	 * @param view
	 *            main view
	 * @param model
	 */
	public PapillonController(MainView view, PapillonModel model) {
		this.view = view;
		this.model = model;
	}

	/**
	 * Perform the action
	 */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println(cmd);

		if (cmd.startsWith("item")) {

			if (cmd.equals("clear")) {
				// model.getCurrentSever().clearCheck();
				view.updateView();
			} else if (cmd.equals("edit")) {
				model.editCurrentCheck();
				view.updateView();
			} else if (cmd.equals("up")) {
				if (model.isEditItem()) {
					Check check = model.getCurrentServer().getCurrentCheck();
					if (check != null) {
						int pos = Math.max(0, Math.min(check.getCurrentItem() - 1, check.getItems().size() - 1));
						check.setCurrentItem(pos);
						view.updateView();
					}
				}
			} else if (cmd.equals("DOWN")) {
				if (model.isEditItem()) {
					Check check = model.getCurrentServer().getCurrentCheck();
					if (check != null) {
						int pos = check.getCurrentItem() + 1;
						if (pos >= check.getItems().size())
							pos = 0;
						check.setCurrentItem(pos);
						view.updateView();
					}
				}
			} else if (cmd.equals("RIGHT")) {
				if (model.isEditItem()) {
					Check check = model.getCurrentServer().getCurrentCheck();
					if (check != null) {
						check.increaseCurrentItem();
						view.updateView();
					}
				}
			}
		} else if (cmd.equals("LEFT")) {
			if (model.isEditItem()) {
				Check check = model.getCurrentServer().getCurrentCheck();
				if (check != null) {
					check.decreaseCurrentItem();
					view.updateView();
				}
			}
		} else if (cmd.equals("PRINT")) {
			// model.printCheck(); // write print method in PapillonModel
		}
	}

}