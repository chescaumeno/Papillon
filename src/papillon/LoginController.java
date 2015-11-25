package papillon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles events from Login UI
 * @author Anna Umeno, Lymari Montijo, Caleb Mussulman, Matt New, Nanette Springer
 */
public class LoginController implements ActionListener {
 private LoginModel loginModel;
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
}
