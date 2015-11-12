package papillon;
import javax.swing.JFrame;

/**
 * The main class of the program.
 */

public class Papillon {

    /**
     * Starts the program
     * @param args arguments
     */
    public static void main(String[] args) {

        PapillonModel model = new PapillonModel();
        MainView view = new MainView(model);
        PapillonController controller = new PapillonController(view, model);
        
        view.register(controller);

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(PapillonModel.FRAME_WIDTH,PapillonModel.FRAME_HEIGHT);
        view.setVisible(true);

    }

}
