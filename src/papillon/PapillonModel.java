package papillon;

import java.util.ArrayList;

/**
 * The model class
 */

public class PapillonModel {
    public static int FRAME_WIDTH = 885; 
    public static int FRAME_HEIGHT = 600;
    public static int invoiceNumber;
    public static final double TAX_RATE = 0.0825;
    
    private ArrayList<Server> servers;
    private int currentServer;
    private boolean editItem;   // arrow can be used to edit items or lookup invoice 
    
    /**
     * Get the edit mode
     * @return true if we can edit item
     */
    public boolean isEditItem() {
        return editItem;
    }
    
    /**    
     * Set the edit mode
     * @param edit edit mode
     */
    public void setEditItem(boolean edit) {
        editItem = edit;
    }
    
    /**
     * Edit current check
     */
    public void editCurrentCheck() {
        editItem = !editItem;
        Check check = getCurrentServer().getCurrentCheck();
        if (check != null)
            check.setOpened(true);
    }
    
    /**
     * Get the server
     */
    public Server getCurrentServer() {
        return servers.get(currentServer);

    }
    
    public static int newInvoiceNumber(){
    	return ++invoiceNumber;
    }
    
    public void printCheck(){
    	//Not sure what we want to do here
    }

}
    
    
