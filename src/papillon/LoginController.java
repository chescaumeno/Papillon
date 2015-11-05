package papillon;

/**
 * Handles events from Login UI
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginController implements ActionListener {
	private LoginModel loginModel;
	private LoginView loginView;
	
	public LoginController(LoginModel loginModel, LoginView loginView) {
		this.loginModel = loginModel;
		this.loginView = loginView;
	}
	
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		loginModel.update(command);
		loginView.update(loginModel.getValue());
	}
}
