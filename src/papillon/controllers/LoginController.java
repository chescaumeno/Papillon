package papillon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import papillon.models.LoginModel;
import papillon.models.Manager;
import papillon.models.Server;
import papillon.views.LoginView;

/**
 * Handles events from Login UI
 * @author Anna Umeno, Lymari Montijo, Caleb Mussulman, Matt New, Nanette Springer
 */
public class LoginController implements ActionListener {
	private static LoginModel loginModel;
	private LoginView loginView;
	
	/**
	 * Constructor - Initializes LoginController with LoginModel and LoginView
	 * @param loginModel
	 * @param loginView
	 */
	public LoginController(LoginModel loginModel, LoginView loginView) {
		this.loginModel = loginModel;
		this.loginView = loginView;
	}
	
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		loginModel.update(command);
		loginView.update(loginModel.getValue());
	}
	
	public static ArrayList<Integer> getOpenInvoices(){
		ArrayList<Integer> openInvoices = new ArrayList<Integer>();
		for(Server server : loginModel.getLoggedInServers()){
			openInvoices.addAll(server.getOpenInvoices());
		}
		return openInvoices;
	}
	
}
