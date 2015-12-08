package papillon.models;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import papillon.controllers.CheckController;
import papillon.controllers.PapillonController;
import papillon.views.*;

public class TipAdjustModel {
	private double value; //numeric value of the button the user just pressed from UI
	private String internalString;
	private boolean success;
	private TipAdjustView tipAdjustView;
	private CheckController checkCtrl;
	//stuff that's displayed on the GUI
	private String displayString; //String corresponding to what the user is entering
	private String operation; //either "Clear" or "Login"
	private boolean start; //True if next digit entered starts a new value
	
	public TipAdjustModel(TipAdjustView tipAdjustView, CheckController checkCtrl) {
		value = 0;
		internalString = "0";
		displayString = "$0.00";
		start = true;
		operation = "";
		this.tipAdjustView = tipAdjustView;
		this.checkCtrl = checkCtrl;
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
			value = Double.valueOf(internalString);
			displayString = "$0.00";
			start = false;
		}
		if(text.length() == 1 && "0123456789".indexOf(text) >= 0){
			if(internalString.length() < 8){
				internalString += text;
				if(internalString.length() > 3){
					int s = internalString.length();
					String cents = internalString.substring(s - 2, s);
					String dollarsString = internalString.substring(1, s - 2);
					int dollars = Integer.parseInt(dollarsString);
					internalString = "0" + dollars + cents;
					displayString = dollars + "." + cents;
					value = Double.valueOf(displayString);
				}else if(internalString.length() == 3){
					displayString = "0." + internalString.substring(1, 3);
					value = Double.valueOf(displayString);
				}else{
					displayString = "0.0" + internalString.substring(1, 2);
					value = Double.valueOf(displayString);
				}
				displayString = "$" + displayString;
			}
		}
		else{
			displayString = "$0.00";
			operation = text;
			start = true;
			if(operation.equals("Clear")){
				value = 0;
				checkCtrl.getCurrentCheck().setTips(value);
				displayString = "$0.00";
				internalString = "0";
			}
			else if(operation.equals("Enter")) {
				checkCtrl.getCurrentCheck().setTips(value);
				checkCtrl.update();
				value = 0;
				displayString = "$0.00";
				internalString = "0";
				tipAdjustView.setVisible(false);
			}
		}	
	}

}
