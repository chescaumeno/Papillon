package papillon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import papillon.models.Check;
import papillon.models.EndDayReport;
import papillon.models.Manager;
//import papillon.models.Server;
import papillon.views.CheckPanel;
import papillon.views.LoginView;
import papillon.views.MainView;
import papillon.views.ManagerView;

public class ManagerController implements ActionListener{

	private LoginView loginView;
	private ManagerView managerView;
	private Manager manager;
	//eod report
	private EndDayReport report;
	private boolean currentlyShowingOpenChecks;
	private boolean nextLogoutExits;
	
	public ManagerController(EndDayReport report, LoginView loginView, ManagerView managerView, Manager manager){
		this.managerView = managerView;
		this.loginView = loginView;
		this.manager = manager;
		this.report = report;
		currentlyShowingOpenChecks = true;
		nextLogoutExits = false;
		showEODReportFiles();
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
		if(command.equals("View EOD Sales Report")){
			this.viewReportEOD();
		}
		if(command.equals("Produce EOD Sales Report")){
			int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to produce an end-of-day report",
											"Confirmation", JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.YES_OPTION){
				this.produceReportEOD();
			}
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
		if(invoice == -1){
			return;
		}
		if(currentlyShowingOpenChecks){
			Check check = LoginController.getOpenCheck(invoice);
			if(check != null){
				managerView.displayText(check.toString());
			}
		}else{
			Check check = manager.getClosedCheck(invoice);
			if(check != null){
				managerView.displayText(check.toString());
			}
		}		
	}
	
	private void viewReportEOD(){
		//String display = report.EndDayReport();
		
		System.out.print("report");
		
	}
	
	private void produceReportEOD(){
		ArrayList<Integer> invoiceList = LoginController.getOpenInvoices();
		if(invoiceList.size() > 0){
			JOptionPane.showMessageDialog(null, "Can not produce end-of-day report while check(s) currently open");
		}else{
			EndDayReport eodReport = new EndDayReport(manager);
			if(manager.writeDayReportToFile(eodReport) == -1){
				JOptionPane.showMessageDialog(null, "Error writing end-of-day report to file");
			}
			managerView.hideProduceReportButton();
			nextLogoutExits = true;
			managerView.displayText(eodReport.toString());
		}
	}
	
	private void logout(){
		if(nextLogoutExits){
			System.exit(0);
		}
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
	
	public void showEODReportFiles(){
		ArrayList<String> eodFileNames = manager.getEODFileNames();
	}
}
