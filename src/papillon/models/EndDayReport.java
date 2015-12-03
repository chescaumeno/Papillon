package papillon.models;

import java.util.ArrayList;

/**
 * Stores the information for the end of day report
 */

public class EndDayReport {
    
    private Server server;
    private int numChecks;
    private double grossSales;
    private double drinkSales;
    private double dessertSales;
    private double totalTips;   
    private ArrayList<Check> EODChecks; 
    
    
    /**
     * Constructor with parameters
     * @param server
     * @param numChecks
     * @param grossSales
     * @param drinkSales
     * @param dessertSales
     * @param totalTips
     */
    public EndDayReport(Server server, int numChecks, double grossSales,
            double drinkSales, double dessertSales, double totalTips) {
        this.server = server;
        this.numChecks = numChecks;
        this.grossSales = grossSales;
        this.drinkSales = drinkSales;
        this.dessertSales = dessertSales;
        this.totalTips = totalTips;
       // EODSales = checkManager.sendChecksToReport(); //this will get me the ArrayLists of checks that I need to extract the report from. 
        
    }
    
    /**
     * Return the comma separate string
     */
    public String toString() {
        String result = server.getName() + ", " +
                numChecks + ", " + grossSales + ", " +
                drinkSales + ", " + dessertSales + ", " +
                totalTips;
        return result;
    }
    
    // getter and setters
    public Server getServer()
    {
        return server;
    }
    public int getNumChecks()
    {
    	
    	//take the arayList of Checks and just count how many checks we should have. 
        return numChecks;
    }
    public double getGrossSales() {
    	double grossSales = 0.00; 
        for(Check c: EODChecks) {
        	grossSales += c.getTotal(); 
        	}
        return grossSales; 
        }
 
    
	public double getDrinkSales() {
		double drinkSales = 0.0; 
		for (Check c : EODChecks) {
			for (CheckItem ci : c.getCheckItems()) {
				String cat = ci.getMenuItem().getCategory().toString();
				if (cat.equals("DRINKS")) {
					drinkSales += ci.getSubtotal();
				}

			}
		}
		
		return drinkSales; 
	}
		
		
    public double getTotalTips()
    {
        return totalTips;
    }
    
    

}

