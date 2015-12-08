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
	EndDayReport report;
	
	//stuff that's displayed on the GUI
	private String displayString; //String corresponding to what the user is entering
	private String operation; //either "Clear" or "Login"
	private boolean start; //True if next digit entered starts a new value
	
	private static ArrayList<Server> serverList = null; //holds ArrayList of servers
	private Manager manager;
	
	MainView[] mainView;
	PapillonController[] papillonController;
	ManagerView managerView;
	ManagerController managerController;
	
	/**
	 * Constructor - Initializes the LoginModel instance variables
	 */
	public LoginModel(){
		this(null);
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
		generateServersAndManager();
		mainView = new MainView[serverList.size()];
		papillonController = new PapillonController[serverList.size()];
		createViews();
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
			System.out.println(internalString);
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
				        mainView[i].setVisible(true);
				        loginView.setVisible(false);
						success = true;
				        break;
					}
				}
				if(value == Integer.valueOf(manager.getId())){
					managerController.updateView();
					managerView.setVisible(true);
					displayString = "Enter PIN";
					loginView.setVisible(false);
					success = true;
				}
				if(success == false) {
					displayString = "Invalid PIN";
					//JOptionPane.showMessageDialog(null, "Invalid PIN!");
				}
				value = 0;
				//displayString = "Enter PIN";
				internalString = "0";
			}
		}	
	}
	
	private void generateServersAndManager(){
		String serverName;
		String ID;
		Server server;
		for(String[] serverAndID : Server.SERVERS_AND_IDS){
			serverName = serverAndID[0];
			ID = serverAndID[1];
			server = new Server(serverName, ID);
			serverList.add(server);
		}
		String managerName = Manager.MANAGER_AND_ID[0];
		String M_ID = Manager.MANAGER_AND_ID[1];
		manager = new Manager(managerName, M_ID);
	}
	
	private void createViews(){
		PapillonModel model = new PapillonModel();
		managerView = new ManagerView(manager); 
		for(int i = 0; i < serverList.size(); i++){
			mainView[i] = new MainView(model, serverList.get(i), manager);
			papillonController[i] = new PapillonController(mainView[i], model, loginView, managerView);
			mainView[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainView[i].registerListener(papillonController[i]);
			mainView[i].setSize(PapillonModel.FRAME_WIDTH,PapillonModel.FRAME_HEIGHT);
			mainView[i].setVisible(false);
		}
		managerController = new ManagerController(loginView, managerView, manager);
		managerView.registerListener(managerController);
		managerView.setSize(Manager.FRAME_WIDTH, Manager.FRAME_HEIGHT);
		managerView.setVisible(false);
	}
	
	public ArrayList<Server> getLoggedInServers(){
		return serverList;
	}
	
}