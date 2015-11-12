package papillon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * The main class of the program.
 */

public class Papillon {

    /**
     * Starts the program
     * @param args arguments
     */
    public static void main(String[] args) {
    	try {
    	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    	        if ("Nimbus".equals(info.getName())) {
    	            UIManager.setLookAndFeel(info.getClassName());
    	            break;
    	        }
    	    }
    	} catch (Exception e) {
    	    // If Nimbus is not available, you can set the GUI to another look and feel.
    	}
        PapillonModel model = new PapillonModel();
        MainView view = new MainView(model);
        PapillonController controller = new PapillonController(view, model);
        
        view.register(controller);

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(PapillonModel.FRAME_WIDTH,PapillonModel.FRAME_HEIGHT);
        view.setVisible(true);

    }

}
