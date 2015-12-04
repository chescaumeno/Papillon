package papillon.models;

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
        return numChecks;
    }
    public double getGrossSales()
    {
        return grossSales;
    }
    public double getDrinkSales()
    {
        return drinkSales;
    }
    public double getTotalTips()
    {
        return totalTips;
    }
    
    

}

