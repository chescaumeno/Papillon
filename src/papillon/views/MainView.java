package papillon.views;
/**
 * Implements the main view
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import papillon.controllers.CheckController;
import papillon.controllers.LoginController;
import papillon.controllers.MenuController;
import papillon.controllers.PapillonController;
import papillon.models.Manager;
import papillon.models.PapillonModel;
import papillon.models.Server;

/**
 * This class contains code for the main view of the GUI
 * @author Matt New, Lymari Montijo
 *
 */
public class MainView extends JFrame {
    
    private JPanel leftPanel;
    private JPanel mainPanel;
    private JPanel rightBlankPanel;
    private JPanel tmp;
    private CheckActionPanel checkActionPanel;
    private MenuPanel menuPanel; 
    private JButton buttonLogOff;
    private PapillonModel model;
    
    private MenuController menuCtrl; 
    private Server server;


    /**
     * Constructs the GUI
     * @param model 
     * @param server 
     */
    public MainView(PapillonModel model, Server server, Manager manager) {
        super("Papillon | " + server.getName());
          
        this.model = model;
        this.menuCtrl = new MenuController();
        this.server = server;
        
        leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.white);
        leftPanel.setPreferredSize(new Dimension(285, 500)); 
        
        rightBlankPanel = new JPanel();
        rightBlankPanel.setBackground(Color.WHITE);
        rightBlankPanel.setPreferredSize(new Dimension(40, 500));
        
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.white);
        
        
        // Adds CheckAction Panel
        
        CheckController checkCtrl = new CheckController(server, manager); 
        checkActionPanel = checkCtrl.createCheckActionPanel(); //this creates an ActionPanel
        checkCtrl.update();
 
        leftPanel.add(checkActionPanel, BorderLayout.CENTER);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 20));
        
        // Menu panels
        menuPanel = new MenuPanel(menuCtrl, checkCtrl);
        mainPanel.add(menuPanel, BorderLayout.CENTER);       
        
        // Add Log off button
        buttonLogOff = new JButton("Log Off");
        buttonLogOff.setFont(new Font("Sansserif", Font.BOLD, 25));
        buttonLogOff.setBackground(Color.GREEN);
        buttonLogOff.setForeground(Color.WHITE);
        
        tmp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tmp.setPreferredSize(new Dimension(400, 100));
        tmp.setBackground(Color.WHITE);
        tmp.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        tmp.add(buttonLogOff);
        mainPanel.add(tmp, BorderLayout.SOUTH);
        
        setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.WEST);
        add(rightBlankPanel, BorderLayout.EAST);
        add(mainPanel, BorderLayout.CENTER);
        
    }
    
	public void registerListener(PapillonController controller){
		
		Component[] components = tmp.getComponents();
		for (Component component : components) {
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;

				button.addActionListener(controller);
			}
		}
	}

}
