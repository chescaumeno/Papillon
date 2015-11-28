package papillon.views;
/**
 * Implements the main view
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import papillon.controllers.CheckController;
import papillon.controllers.MenuController;
import papillon.models.PapillonModel;

public class MainView extends JFrame {
    
    private JPanel leftPanel;
    private JPanel mainPanel;
    private JPanel rightBlankPanel;

    private CheckActionPanel checkActionPanel;
    private MenuPanel menuPanel; 
    private JButton buttonManager;
    
    private PapillonModel model;
    
    private MenuController menuCtrl; 


    /**
     * Constructs the GUI
     * @param model 
     */
    public MainView(PapillonModel model) {
        super("Papillon");
        
        //TODO: Have Papillon Controller create ALL the controllers
        //TODO: remove all these controllers from here. The controllers 
        //generate the view. 
        
        this.model = model;
        this.menuCtrl = new MenuController();
        
        // create the container panels
        leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.white);
        leftPanel.setPreferredSize(new Dimension(260, 500));
        
        rightBlankPanel = new JPanel();
        rightBlankPanel.setBackground(Color.white);
        rightBlankPanel.setPreferredSize(new Dimension(40, 500));
        
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.white);
        
        
        // Adds CheckAction Panel
        
        CheckController checkCtrl = new CheckController(); 
        checkActionPanel = checkCtrl.createCheckActionPanel(); //this creates an ActionPanel 
 
        leftPanel.add(checkActionPanel, BorderLayout.CENTER);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 20));
        
        // Menu panels
        menuPanel = new MenuPanel(menuCtrl, checkCtrl);
        mainPanel.add(menuPanel, BorderLayout.CENTER);        
        
        // Add Manager's View button
        buttonManager = new JButton("Manager View");
        buttonManager.setFont(new Font("SansSerif", Font.BOLD, 25));
        buttonManager.setBackground(Color.green);
        buttonManager.setForeground(Color.white);
        
        JPanel tmp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tmp.setPreferredSize(new Dimension(400, 100));
        tmp.setBackground(Color.white);
        tmp.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        tmp.add(buttonManager);
        mainPanel.add(tmp, BorderLayout.SOUTH);
        
        setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.WEST);
        add(rightBlankPanel, BorderLayout.EAST);
        add(mainPanel, BorderLayout.CENTER);
        
    }

}
