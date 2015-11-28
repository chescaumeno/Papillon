package papillon.controllers;

import papillon.models.PapillonModel;
import papillon.views.MainView;

/**
 * Implements the listener
 */

public class PapillonController {

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

}