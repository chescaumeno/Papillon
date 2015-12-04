package papillon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import papillon.views.LoginView;
import papillon.views.MainView;
import papillon.views.ManagerView;

public class ManagerController implements ActionListener{

	LoginView loginView;
	MainView mainView;
	ManagerView managerView;
	
	public ManagerController(LoginView loginView, MainView mainView, ManagerView managerView){
		this.mainView = mainView;
		this.managerView = managerView;
		this.loginView = loginView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);//Temporary
		if(command.equals("Logout")){
			this.bringBackMainView();
		}
	}
	
	public void bringBackMainView(){
		if(mainView == null){
			loginView.setVisible(true);
			managerView.setVisible(false);
		}else{
			mainView.setVisible(true);
			managerView.setVisible(false);
		}
	}
}
