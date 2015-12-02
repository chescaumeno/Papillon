package papillon.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import papillon.controllers.CheckController;

public class ArrowsPanel extends JPanel implements ActionListener {

	private JButton buttonUp = new JButton("\u25b2");
    private JButton buttonDown = new JButton("\u25bc");
    private JButton buttonLeft = new JButton("\u25c4");
    private JButton buttonRight = new JButton("\u25ba");
    private CheckController checkCtrl;
    private Font txtFont = new Font("SansSerif", Font.BOLD, 20);
    
	public ArrowsPanel(CheckController checkCtrl) {
		this.checkCtrl = checkCtrl;
		initialize(); 
		
	}
	
	public void initialize() {
		this.setLayout(new GridLayout(1,4));
		buttonUp.setBorderPainted(false);
		buttonUp.setBackground(Color.green);
		buttonUp.setForeground(Color.blue); 
		buttonUp.setFont(txtFont);
		buttonUp.setActionCommand("UP");
		buttonUp.addActionListener(this);
		
		buttonDown.setBorderPainted(false);
		buttonDown.setBackground(Color.green);
		buttonDown.setForeground(Color.blue); 
		buttonDown.setFont(txtFont);
		buttonDown.setActionCommand("DOWN");
		buttonDown.addActionListener(this);
		
		buttonLeft.setBorderPainted(false);
		buttonLeft.setBackground(Color.green);
		buttonLeft.setForeground(Color.blue); 
		buttonLeft.setFont(txtFont);
		buttonLeft.setActionCommand("LEFT");
		buttonLeft.addActionListener(this);
		
		buttonRight.setBorderPainted(false);
		buttonRight.setBackground(Color.green);
		buttonRight.setForeground(Color.blue); 
		buttonRight.setFont(txtFont);
		buttonRight.setActionCommand("RIGHT");
		buttonRight.addActionListener(this);
		
		add(buttonUp); 
		add(buttonDown); 
		add(buttonLeft);
		add(buttonRight); 
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("UP")){
			checkCtrl.previousItem();
		}else if(cmd.equals("DOWN")){
			checkCtrl.nextItem();
		}else if(cmd.equals("LEFT")){
			checkCtrl.previousCheck();
		}else if(cmd.equals("RIGHT")){
			checkCtrl.nextCheck();
		}

		
	}
}
