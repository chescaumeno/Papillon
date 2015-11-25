package papillon;
/**
 * Implements the main view
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class MainView extends JFrame {
    
    private JPanel leftPanel;
    private JPanel mainPanel;
    private JPanel rightBlankPanel;

    private CheckPanel checkPanel;
    private ActionPanel actionPanel;
    private CategoryPanel categoryPanel;
    private ItemPanel drinksPanel;
    private ItemPanel appetizersPanel;
    private ItemPanel sidesPanel;
    private ItemPanel entreesPanel;
    private ItemPanel dessertsPanel;
    
    private JButton buttonManager;
    
    private PapillonModel model;

    /**
     * Constructs the GUI
     * @param model 
     */
    public MainView(PapillonModel model) {
        super("Papillion");
        
        this.model = model;
        
        // create the container panels
        leftPanel = new JPanel(new BorderLayout());
        mainPanel = new JPanel(new BorderLayout());
        rightBlankPanel = new JPanel();
        leftPanel.setBackground(Color.white);
        mainPanel.setBackground(Color.white);
        rightBlankPanel.setBackground(Color.white);
        
        setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(260, 500));
        rightBlankPanel.setPreferredSize(new Dimension(40, 500));
        add(leftPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
        add(rightBlankPanel, BorderLayout.EAST);
        
        // create other panels
        checkPanel = new CheckPanel(model);
        actionPanel = new ActionPanel(model);
        categoryPanel = new CategoryPanel();
        drinksPanel = new ItemPanel(4, 4, Drinks.DRINKS, "DRINKS", new Color(112, 48, 160));   
        appetizersPanel = new ItemPanel(4, 4, Appetizers.APPETIZERS, "APPETIZERS", new Color(255, 100, 0));
        sidesPanel = new ItemPanel(4, 4, Sides.SIDES, "SIDES", new Color(255, 100, 0));
        entreesPanel = new ItemPanel(4, 4, Entrees.ENTREES, "ENTREES", new Color(255, 100, 0));
        dessertsPanel = new ItemPanel(3, 3, Desserts.DESSERTS, "DESSERTS", new Color(255, 100, 200));
        
        buttonManager = new JButton("Manager View");
        buttonManager.setFont(new Font("SansSerif", Font.BOLD, 25));
        buttonManager.setBackground(Color.green);
        buttonManager.setForeground(Color.white);
        
        actionPanel.setPreferredSize(new Dimension(250, 210));
        actionPanel.setBackground(Color.white);
        checkPanel.setBackground(Color.white);
        leftPanel.add(checkPanel, BorderLayout.CENTER);
        leftPanel.add(actionPanel, BorderLayout.SOUTH);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 20));
        mainPanel.add(categoryPanel, BorderLayout.NORTH);
        mainPanel.add(drinksPanel, BorderLayout.CENTER);
        
        JPanel tmp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tmp.setPreferredSize(new Dimension(400, 100));
        tmp.setBackground(Color.white);
        tmp.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        tmp.add(buttonManager);
        mainPanel.add(tmp, BorderLayout.SOUTH);
    }

    /**
     * Register action listener
     * @param controller action controller
     */
    public void register(PapillonController controller) {
        buttonManager.addActionListener(controller);
        categoryPanel.register(controller);
        drinksPanel.register(controller);
        appetizersPanel.register(controller);
        dessertsPanel.register(controller);
        entreesPanel.register(controller);
        sidesPanel.register(controller);
        checkPanel.register(controller);
        actionPanel.register(controller);
    }

    /**
     * Change the panel
     * @param panelName panel name
     */
    public void changeItemPanel(String panelName) {

        mainPanel.remove(drinksPanel); 
        mainPanel.remove(dessertsPanel); 
        mainPanel.remove(appetizersPanel); 
        mainPanel.remove(sidesPanel); 
        mainPanel.remove(entreesPanel); 

        
        if (panelName.equals("Drinks")) {
            mainPanel.add(drinksPanel, BorderLayout.CENTER);
        }
        else if (panelName.equals("Appetizers")) {
            mainPanel.add(appetizersPanel, BorderLayout.CENTER);
        }
        else if (panelName.equals("Sides")) {
            mainPanel.add(sidesPanel, BorderLayout.CENTER);
        }
        else if (panelName.equals("Entrees")) {
            mainPanel.add(entreesPanel, BorderLayout.CENTER);
        }
        else { // Desserts
            mainPanel.add(dessertsPanel, BorderLayout.CENTER);
        }

        mainPanel.validate();
        mainPanel.repaint();
        validate();
        repaint();
    }   
        
        /**
         * Update the view
         */
        public void updateView(){
         actionPanel.updateView();
         checkPanel.updateView();
        }
    }
