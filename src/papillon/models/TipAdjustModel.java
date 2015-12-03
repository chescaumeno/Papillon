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
	private boolean dot;
	
	public TipAdjustModel(TipAdjustView tipAdjustView, CheckController checkCtrl) {
		value = 0;
		internalString = "0";
		displayString = "";
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
			displayString = "";
			start = false;
			dot = false;
		}
		if(text.length() == 1 && "0123456789".indexOf(text) >= 0){
			
			displayString += text;
			internalString += text;
			value = Double.valueOf(internalString);
		}
		else if (text.equals(".")) {
			if (! dot) {	
				dot = true;	
				if (displayString.equals("")) {
					displayString = "0";
				}
				displayString += ".";
				internalString += text;
				value = Double.valueOf(internalString);
			}
		}
		else{
			displayString = "";
			operation = text;
			start = true;
			if(operation.equals("Clear")){
				value = 0;
				checkCtrl.getCurrentCheck().setTips(value);
				displayString = "";
				internalString = "0";
			}
			else if(operation.equals("SUBMIT")) {
				checkCtrl.getCurrentCheck().setTips(value);
				checkCtrl.update();
				System.out.println("Tip entered : " + value);
				value = 0;
				displayString = "";
				internalString = "0";
				tipAdjustView.setVisible(false);
			}
		}	
	}

}
