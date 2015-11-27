package papillon.views;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import papillon.controllers.CheckController;

public class CheckActionPanel extends JPanel {
	
	private CheckController checkCtrl;
	private CheckPanel checkPanel; 
	private ActionPanel actionPanel;  
	
	public CheckActionPanel(CheckController checkCtrl) {
		this.checkCtrl = checkCtrl;
		checkPanel = new CheckPanel(checkCtrl);
		actionPanel = new ActionPanel(checkCtrl); 
		
		setLayout(new BorderLayout());
		add(checkPanel, BorderLayout.CENTER);
		add(actionPanel, BorderLayout.SOUTH);
	}

	public void updateView() {
		checkPanel.updateView();
		actionPanel.updateView();
	}
}
