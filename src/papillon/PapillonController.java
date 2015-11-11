package papillon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Implements the listener
 */

public class PapillonController implements ActionListener {

    private MainView view;
    private PapillonModel model;
    
    /**
     * Constructor with view
     * @param view main view
     * @param model 
     */
    public PapillonController(MainView view, PapillonModel model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Perform the action
     */
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        System.out.println(cmd);
        
        if (cmd.equals("Drinks") || cmd.equals("Appetizers") || 
            cmd.equals("Sides") || cmd.equals("Entrees") || cmd.equals("Desserts")) {
            view.changeItemPanel(cmd);
        }
    }

}
