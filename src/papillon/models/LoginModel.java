package papillon.models;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import papillon.views.*;
import papillon.controllers.*;
import papillon.models.*;
/**
 * This is the model for the login portion of the program.
 * @author Anna Umeno, Lymari Montijo, Caleb Mussulman, Matt New, Nanette Springer
 *
 */
public class LoginModel {
	
	private int value; //numeric value of the button the user just pressed from UI
	private String internalString;
	private boolean success;
	LoginView loginView;
	
	//stuff that's displayed on the GUI
	private String displayString; //String corresponding to what the user is entering
	private String operation; //either "Clear" or "Login"
	private boolean start; //True if next digit entered starts a new value
	
	private ArrayList<Server> serverList; //holds ArrayList of servers
	
	/**
	 * Constructor - Initializes the LoginModel instance variables
	 */
	public LoginModel(){
		value = 0;
		internalString = "0";
		displayString = "";
		start = true;
		operation = "";
		
		serverList = new ArrayList<Server>();
		generateServers();
	}
	/**
	 * Constructor - Initializes the LoginModel instance variables with LoginView argument passed
	 */
	public LoginModel(LoginView loginView){
		value = 0;
		internalString = "0";
		displayString = "";
		start = true;
		operation = "";
		this.loginView = loginView;
		
		serverList = new ArrayList<Server>();
		generateServers();
	}
	
	/**
	 * @return displayString the String value of what was just calculated or what the 
	 * user is entering
	 */
	public String getValue(){
		return displayString;
	}
	
	public void update(String text){
		if(start){			
			value = Integer.valueOf(internalString);
			displayString = "";
			start = false;
		}
		if(text.length() == 1 && "0123456789".indexOf(text) >= 0){
			displayString += "*";
			internalString += text;
			if(internalString.length() > 4){
				internalString = internalString.substring(1, 5);
				displayString = "****";
			}
			value = Integer.valueOf(internalString);
		}
		else{
			displayString = "";;
			operation = text;
			start = true;
			if(operation.equals("Clear")){
				value = 0;
				displayString = "Enter PIN";
				internalString = "0";
			}
			else if(operation.equals("Login")) {
				success = false;
				for(int i = 0; i < serverList.size(); i++) {
					if(value == Integer.valueOf(serverList.get(i).getId())) {
						
				        PapillonModel model = new PapillonModel();
				        MainView view = new MainView(model, serverList.get(i));
				        PapillonController controller = new PapillonController(view, model, loginView);
				        
				        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        view.registerListener(controller);
				        view.setSize(PapillonModel.FRAME_WIDTH,PapillonModel.FRAME_HEIGHT);
				        view.setVisible(true);
				        loginView.setVisible(false);
						success = true;
				        break;
					}
				}
				if(success == false) {
					JOptionPane.showMessageDialog(null, "Invalid PIN!");
				}
				value = 0;
				displayString = "Enter PIN";
				internalString = "0";
			}
		}	
	}
	
	private void generateServers(){
		String serverName;
		String ID;
		Server server;
		for(String[] serverAndID : Server.SERVERS_AND_IDS){
			serverName = serverAndID[0];
			ID = serverAndID[1];
			server = new Server(serverName, ID);
			serverList.add(server);
		}
	}
	
	
}