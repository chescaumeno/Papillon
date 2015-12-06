package papillon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import papillon.models.Check;
import papillon.models.Manager;
import papillon.views.LoginView;
import papillon.views.MainView;
import papillon.views.ManagerView;

public class ManagerController implements ActionListener{

	LoginView loginView;
	ManagerView managerView;
	Manager manager;
	
	public ManagerController(LoginView loginView, ManagerView managerView, Manager manager){
		this.managerView = managerView;
		this.loginView = loginView;
		this.manager = manager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);//Temporary
		if(command.equals("Open Checks")){
			this.showOpenChecks();
		}
		if(command.equals("Closed Checks")){
			this.showClosedChecks();
		}
		if(command.equals("Lookup Invoice")){
			this.lookupInvoice();
		}
		if(command.equals("Produce EOD Sales Report")){
			this.reportEOD();
		}
		if(command.equals("Logout")){
			this.logout();
		}
	}
	
	private void showOpenChecks(){
		ArrayList<Integer> invoiceList = LoginController.getOpenInvoices();
		if(invoiceList != null){
			Integer[] openInvoiceNums = invoiceList.toArray(new Integer[invoiceList.size()]);
			Arrays.sort(openInvoiceNums);
			managerView.setInvoiceDisplay(openInvoiceNums);
		}else{
			Integer[] blank = new Integer[1];
			managerView.setInvoiceDisplay(blank);
		}
	}
	
	private void showClosedChecks(){
		ArrayList<Integer> invoiceList = manager.getClosedInvoices();
		if(invoiceList != null){
			Integer[] closedInvoiceNums = invoiceList.toArray(new Integer[invoiceList.size()]);
			Arrays.sort(closedInvoiceNums);
			managerView.setInvoiceDisplay(closedInvoiceNums);
		}else{
			Integer[] blank = new Integer[1];
			managerView.setInvoiceDisplay(blank);
		}
	}
	
	private void lookupInvoice(){
		
	}
	
	private void reportEOD(){
		
	}
	
	private void logout(){
		loginView.setVisible(true);
		managerView.setVisible(false);
	}
	
	public void updateView(){
		showOpenChecks();//need to update once more is added to view
	}
	
}
