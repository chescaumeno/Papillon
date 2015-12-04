package papillon.models;

import java.util.ArrayList;

/**
 * Stores the information for the end of day report
 */

public class EndDayReport {

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

	public EndDayReport() {
		manager = new Manager("Jane Doe", "1234"); 
		EODChecks = manager.getClosedChecks(); //I dont know if this method works. 
		
		grossSales = getGrossSales();
		drinkSales = getDrinkSales(); 
		appetizerSales = getAppetizerSales(); 
		sidesSales = getSidesSales(); 
		entreesSales = getEntreesSales(); 
		dessertSales = getDessertsSales(); 
		totalTaxes = getTaxes(); 
		
	}

	/**
	 * Return the comma separate string
	 */
	public String toString() {
		String result = server.getName() + ", " + numChecks + ", " + grossSales + ", " + drinkSales + ", "
				+ dessertSales + ", " + totalTips;
		return result;
	}

	// getter and setters
	public Server getServer() {
		return server;
	}

	public int getNumChecks() {

		// take the arayList of Checks and just count how many checks we should
		// have.
		return numChecks;
	}

	public double getGrossSales() {
		double grossSales = 0.00;
		for (Check c : EODChecks) {
			grossSales += c.getTotal();
		}
		return grossSales;
	}

	public double getDrinkSales() {
		double drinkSales = 0.00;
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
	public String EndDayReport() {

		String eod = "EOD SALES REPORT\n";
		eod += "----------------------------------------\n\n"; 
		eod += "Date:\t" + EODChecks.get(1).getDate(); //date of the first check, they are all from the same day. 
		eod += "Manager in Charge:\tJane Doe\n";
		eod += "Total Gross Sales:\t" + this.getGrossSales() + "\n"; 
		eod += "Total Taxes:\t" + this.getTaxes() + "\n";
		eod += "----------------------------------------\n"; 
		eod += "Total Drink Sales:\t" + this.getDrinkSales() + "\n"; 
		eod += "Total Appetizer Sales:\t" + this.getAppetizerSales() + "\n"; 
		eod += "Total Sides Sales:\t" + this.getSidesSales() + "\n";
		eod += "Total Entrees Sales:\t" + this.getEntreesSales() + "\n";
		eod += "Total DessertSales:\t" + this.getDessertsSales() + "\n";
		
		eod += "Sales by server:\n"; 
		//eod += write code to get the sales of each server 
				
		
		return eod; 
	}
	
	
	/**
	 * This class will get the total Sales by Server. To print out in the report. 
	 * @param server
	 * @return 
	 */
	public double serverSales(Server server) {
		double serverSales = 0.00; 
		return serverSales; 
	}

}
