package papillon.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Stores the information for the end of day report
 */

public class EndDayReport implements Serializable{


	private static final long serialVersionUID = -8594593588675985176L;
	private Server server; // not sure if I need this yet
	private int numChecks; // not sure of I need this.
	private double grossSales;
	private double drinkSales;
	private double appetizerSales;
	private double sidesSales;
	private double entreesSales;
	private double dessertSales;
	private double totalTaxes;

	private double totalTips;
	private ArrayList<Check> EODChecks;
	private Manager manager; 
	
	private SimpleDateFormat fmt = new SimpleDateFormat("ddMMMMyyyy");
	private Date date;

	/**
	 * Constructor with parameters
	 * 
	 * @param server
	 * @param numChecks
	 * @param grossSales
	 * @param drinkSales
	 * @param dessertSales
	 * @param totalTips
	 */

	public EndDayReport(Manager manager) {
		this.manager = manager; 
		EODChecks = this.manager.getClosedChecks(); //I don't know if this method works. 
		
		grossSales = getGrossSales();
		drinkSales = getDrinkSales(); 
		appetizerSales = getAppetizerSales(); 
		sidesSales = getSidesSales(); 
		entreesSales = getEntreesSales(); 
		dessertSales = getDessertsSales(); 
		totalTaxes = getTaxes(); 
		
		fmt = new SimpleDateFormat("ddMMMMyyyy");
		date = new Date();
	}

	// getter and setters
	public Server getServer() {
		return server;
	}

	public int getNumChecks() {
		return numChecks;
	}

	public double getGrossSales() {
		grossSales = 0.00;
		for (Check c : EODChecks) {
			grossSales += c.getTotal();
		}
		return grossSales;
	}

	public double getDrinkSales() {
		drinkSales = 0.00;
		for (Check c : EODChecks) {
			for (CheckItem ci : c.getCheckItems()) {
				Category cat = ci.getMenuItem().getCategory();
				if (cat == Category.DRINKS) {
					drinkSales += ci.getSubtotal();
				}

			}
		}

		return drinkSales;
	}

	public double getAppetizerSales() {
		appetizerSales = 0.00;
		for (Check c : EODChecks) {
			for (CheckItem ci : c.getCheckItems()) {
				Category cat = ci.getMenuItem().getCategory();
				if (cat == Category.APPETIZERS) {
					appetizerSales += ci.getSubtotal();
				}
			}
		}
		return appetizerSales;
	}

	public double getSidesSales() {
		sidesSales = 0.00;
		for (Check c : EODChecks) {
			for (CheckItem ci : c.getCheckItems()) {
				Category cat = ci.getMenuItem().getCategory();
				if (cat == Category.SIDES) {
					sidesSales += ci.getSubtotal();
				}
			}
		}
		return sidesSales;
	}

	public double getEntreesSales() {
		entreesSales = 0.00;
		for (Check c : EODChecks) {
			for (CheckItem ci : c.getCheckItems()) {
				Category cat = ci.getMenuItem().getCategory();
				if (cat == Category.ENTREES) {
					entreesSales += ci.getSubtotal();
				}
			}
		}
		return entreesSales;
	}

	public double getDessertsSales() {
		dessertSales = 0.00;
		for (Check c : EODChecks) {
			for (CheckItem ci : c.getCheckItems()) {
				Category cat = ci.getMenuItem().getCategory();
				if (cat == Category.DESSERTS) {
					dessertSales += ci.getSubtotal();
				}
			}
		}
		return dessertSales;
	}

	public double getTotalTips() {
		totalTips = 0.00;
		for (Check c : EODChecks) {
			c.getTips();
		}

		return totalTips;

	}
	
	public double getTaxes() {
		totalTaxes = 0.00; 
		for(Check c: EODChecks) {
			totalTaxes += c.getTax(); 
		}
		return totalTaxes; 
	}
	
	/**
	 * This class will return the report String and it will display in the Manager view 
	 * text Field. 
	 * @return
	 */
	@Override
	public String toString() {
		
		String eod = "TOKYO SUSHI HOUSE\n"; 
		eod += "1 Sushi Way Ste 345\nSan Antonio, TX, 78260\n"; 
		eod += "210-555-6789\n"; 
		
		eod += "EOD SALES REPORT\n";
		eod += "----------------------------------------\n\n"; 
		eod += "Date:\t" + EODChecks.get(1).getDate(); 
		eod += "\nManager in Charge:\tMark Robinson\n";
		eod += "\n\n"; 
		
		eod += "----------------------------------------\n\n"; 
		eod += "Total Drink Sales:\t\t" + formatDouble(this.getDrinkSales()) + "\n"; 
		eod += "Total Appetizer Sales:\t\t" + formatDouble(this.getAppetizerSales()) + "\n"; 
		eod += "Total Sides Sales:\t\t" + formatDouble(this.getSidesSales()) + "\n";
		eod += "Total Entrees Sales:\t\t" + formatDouble(this.getEntreesSales()) + "\n";
		eod += "Total DessertSales:\t\t" + formatDouble(this.getDessertsSales()) + "\n";
		
		eod += "----------------------------------------\n\n"; 
		eod += "Total Gross Sales:\t\t" + formatDouble(this.getGrossSales()) + "\n"; 
		eod += "Total Taxes:\t\t" + formatDouble(this.getTaxes()) + "\n";
		
		
		eod += "\n\n\tEnd of Sales Report\n"; 
		return eod; 
	}
	
	public String getReportName(){
		return fmt.format(date);
	}
	


	public ArrayList<Integer> getEODInvoices(){
		ArrayList<Integer> invoices = new ArrayList<Integer>();
		for(Check check : EODChecks){
			invoices.add(check.getInvoiceNumber());
		}
		return invoices;
	}
	
	public Check getCheck(int invoice){
		for(Check check : EODChecks){
			if(invoice == check.getInvoiceNumber()){
				return check;
			}
		}
		return null;
	}

	 public String formatDouble(double d) {
	    	if(d < 10) {
	    		return(String.format("$ %.2f", d));
	    	}
	    	return String.format("$ %.2f", d); 
	 }

}
