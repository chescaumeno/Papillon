package papillon;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import papillon.controllers.*;
import papillon.models.*;
import papillon.views.*;

/**
 * The main class of the program.
 */

public class Papillon {

    /**
     * Starts the program
     * @param args arguments
     */
    public static void main(String[] args) {
    	try {
    	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    	        if ("Nimbus".equals(info.getName())) {
    	            UIManager.setLookAndFeel(info.getClassName());
    	            break;
    	        }
    	    }
    	} catch (Exception e) {
    	    // If Nimbus is not available, you can set the GUI to another look and feel.
    	}
        LoginView loginView = new LoginView();
        LoginModel loginModel = new LoginModel(loginView);
        LoginController loginController = new LoginController(loginModel, loginView);
        

        loginView.registerListener(loginController);
        loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
