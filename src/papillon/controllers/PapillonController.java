package papillon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import papillon.models.*;
import papillon.views.*;

/**
 * Implements the listener
 */

public class PapillonController implements ActionListener {

	private MainView view;
	private PapillonModel model;
	private LoginView loginView;
	private ManagerView managerView; 

	/**
	 * Constructor with view
	 * 
	 * @param view
	 *            main view
	 * @param model
	 */
	public PapillonController(MainView view, PapillonModel model, LoginView loginView, ManagerView managerView) {
		this.view = view;
		this.model = model;
		this.loginView = loginView;
		this.managerView = managerView; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		performCommand(command);
		
	}

    public void performCommand(String command){
    	if(command.equals("Log Off")) {
    		bringBackLoginScreen();
    	}
    }
    public void bringBackLoginScreen(){
    	view.setVisible(false);
    	loginView.getPinDisplay().setText("Enter PIN");
    	loginView.setVisible(true);
    }    
}