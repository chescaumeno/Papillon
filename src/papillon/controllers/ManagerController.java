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
	private EndDayReport currentLoadedReport;

	private boolean currentlyShowingOpenChecks;
	private boolean currentlyShowingClosedChecks;
	private boolean nextLogoutExits;
	
	public ManagerController(LoginView loginView, ManagerView managerView, Manager manager){
		this.managerView = managerView;
		this.loginView = loginView;
		this.manager = manager;
		currentlyShowingOpenChecks = true;
		currentlyShowingClosedChecks = false;
		nextLogoutExits = false;
		currentLoadedReport = null;
		displayReportFiles();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("Open Checks")){
			currentlyShowingOpenChecks = true;
			currentlyShowingClosedChecks = false;
			this.showOpenChecks();
		}
		if(command.equals("Closed Checks")){
			currentlyShowingOpenChecks = false;
			currentlyShowingClosedChecks = true;
			this.showClosedChecks();
		}
		if(command.equals("Display Check")){
			this.displayCheck();
		}
		if(command.equals("Load Checks")){
			currentlyShowingOpenChecks = false;
			currentlyShowingClosedChecks = false;
			this.loadChecks();
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
		}else if(currentlyShowingClosedChecks){
			Check check = manager.getClosedCheck(invoice);
			if(check != null){
				managerView.displayText(check.toString());
			}
		}else{
			Check check = currentLoadedReport.getCheck(invoice);
			if(check != null){
				managerView.displayText(check.toString());
			}
		}
	}
	
	private void loadChecks(){
		String file = managerView.getSelectedReportFile();
		currentLoadedReport = null;
		if(file == null){
			return;
		}else{
			currentLoadedReport = manager.loadDayReportFromFile(file);
			if(currentLoadedReport == null){
				return;
			}else{
				ArrayList<Integer> eodInvoiceList = currentLoadedReport.getEODInvoices();
				Integer[] eodInvoices = eodInvoiceList.toArray(new Integer[eodInvoiceList.size()]);
				Arrays.sort(eodInvoices);
				managerView.setInvoiceDisplay(eodInvoices);
			}
		}	
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
	
	public void displayReportFiles(){
		ArrayList<String> eodFileList = manager.getEODFileNames();
		if(eodFileList.size() == 0){
			String[] noEODFiles = {"No end-of-day files on record"};
			managerView.setReportDisplay(noEODFiles);
		}else{
			String[] eodFileNames = eodFileList.toArray(new String[eodFileList.size()]);
			Arrays.sort(eodFileNames);
			managerView.setReportDisplay(eodFileNames);
		}
	}
}
