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

	private LoginView loginView;
	private ManagerView managerView;
	private Manager manager;
	private boolean currentlyShowingOpenChecks;
	
	public ManagerController(LoginView loginView, ManagerView managerView, Manager manager){
		this.managerView = managerView;
		this.loginView = loginView;
		this.manager = manager;
		currentlyShowingOpenChecks = true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);//Temporary
		if(command.equals("Open Checks")){
			currentlyShowingOpenChecks = true;
			this.showOpenChecks();
		}
		if(command.equals("Closed Checks")){
			currentlyShowingOpenChecks = false;
			this.showClosedChecks();
		}
		if(command.equals("Display Check")){
			this.displayCheck();
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
	
	private void displayCheck(){
		int invoice = managerView.getSelectedInvoice();
		if(currentlyShowingOpenChecks){
			Check check = LoginController.getOpenCheck(invoice);
			if(check != null){
				managerView.displayCheck(check);
			}
		}else{
			Check check = manager.getClosedCheck(invoice);
			if(check != null){
				managerView.displayCheck(check);
			}
		}		
	}
	
	private void reportEOD(){
		
	}
	
	private void logout(){
		loginView.setVisible(true);
		managerView.setVisible(false);
	}
	
	/**
	 * Used to update the current open/closed invoices that should be displayed
	 * when the manager logs back in
	 */
	public void updateView(){
		if(currentlyShowingOpenChecks){
			showOpenChecks();
		}else{
			showClosedChecks();
		}
	}
	
}
