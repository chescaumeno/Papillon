package papillon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import papillon.controllers.*;
import papillon.views.*;
import papillon.models.*;

public class TipAdjustController implements ActionListener {
	private TipAdjustView tipAdjustView;
	private TipAdjustModel tipAdjustModel;

	
	/**
	 * Constructor - Initializes LoginController with LoginModel and LoginView
	 * @param loginModel
	 * @param loginView
	 */
	public TipAdjustController(TipAdjustModel tipAdjustModel, TipAdjustView tipAdjustView) {
		this.tipAdjustModel = tipAdjustModel;
		this.tipAdjustView = tipAdjustView;
	}
	
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		tipAdjustModel.update(command);
		tipAdjustView.update(tipAdjustModel.getValue());
	}

}
