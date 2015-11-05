package papillon;


import javax.swing.JFrame;

public class Papillon {

	public static void main(String[] args) {
		LoginModel loginModel = new LoginModel();
		LoginView loginView = new LoginView();
		LoginController loginController = new LoginController(loginModel, loginView);
		PapillonModel model = new PapillonModel(); 
		PapillonView view = new PapillonView(); 
		PapillonController controller = new PapillonController(model, view); 
		
		loginView.registerListener(loginController);
		view.registerListener(controller);
		
		
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(800, 600);
		view.setVisible(true);
		
		
	}

}
