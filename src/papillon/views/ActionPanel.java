package papillon.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import papillon.controllers.CheckController;

/**
 * Contains the action buttons
 */

public class ActionPanel extends JPanel implements ActionListener{

	private JTextField txtSubtotal = new JTextField();
	private JTextField txtTax = new JTextField(); 
	private JTextField txtTotal = new JTextField(); 

	private JButton buttonPrint = new JButton("PRINT");
	private JButton buttonPay = new JButton("PAY");
	private JButton buttonSplitCheck = new JButton("<html><center>SPLIT<br />CHECK</center></html>");
	private JButton buttonNumPad = new JButton("<html><center>NUM<br />PAD</center></html>");
	private JButton buttonRemove = new JButton("REMOVE");
	private JButton buttonClear = new JButton("CLEAR");

	private CheckController checkCtrl;
	private JLabel subTotalLabel = new JLabel("SUB T");
	private JLabel taxLabel = new JLabel("TAX");
	private JLabel totalLabel = new JLabel("TOTAL");

	public ActionPanel(CheckController checkCtrl) {
		this.checkCtrl = checkCtrl; 
		initialize(); 
	}

	private void initialize() {

		setBorder(BorderFactory.createEmptyBorder(0, 40, 10, 0));
		JPanel center = new JPanel();
		center.setBounds(50, 0, 200, 165);
		JPanel pntxt = new JPanel(new GridLayout(3, 1));
		pntxt.setBounds(16, 10, 100, 145);
		pntxt.add(txtSubtotal);
		pntxt.add(txtTax);
		pntxt.add(txtTotal);
		Font txtFont = new Font ("monospaced", 0, 18);
		center.setLayout(null);
		txtSubtotal.setBorder(BorderFactory.createLineBorder(new Color(205, 205, 240)));
		txtSubtotal.setEditable(false);
		txtSubtotal.setHorizontalAlignment(JTextField.CENTER);
		txtSubtotal.setFont(txtFont);
		
		txtTax.setBorder(BorderFactory.createLineBorder(new Color(205, 205, 240)));
		txtTax.setEditable(false);
		txtTax.setHorizontalAlignment(JTextField.CENTER);
		txtTax.setFont(txtFont);
		
		txtTotal.setBorder(BorderFactory.createLineBorder(new Color(205, 205, 240)));
		txtTotal.setEditable(false);
		txtTotal.setHorizontalAlignment(JTextField.CENTER); 
		txtTotal.setFont(txtFont);
		
		center.add(pntxt);
		pntxt.setBackground(Color.white);
		pntxt.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		center.setBackground(Color.WHITE);

		JPanel pnbtn = new JPanel(new GridLayout(4, 1, 0, 5));
		pnbtn.setBounds(116, 10, 84, 145);
		pnbtn.add(buttonSplitCheck);
		pnbtn.add(buttonNumPad);
		pnbtn.add(buttonRemove);
		pnbtn.add(buttonClear);
		pnbtn.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 0));
		pnbtn.setBackground(Color.white);
		center.add(pnbtn);
		buttonSplitCheck.setBackground(Color.BLUE);
		buttonNumPad.setBackground(Color.blue);
		buttonRemove.setBackground(Color.blue);
		buttonClear.setBackground(Color.blue);
		buttonSplitCheck.setForeground(Color.white);
		buttonNumPad.setForeground(Color.white);
		buttonRemove.setForeground(Color.white);
		buttonClear.setForeground(Color.white);
		center.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

		JPanel bottom = new JPanel(new GridLayout(1, 2, 10, 0));
		bottom.setBounds(50, 165, 200, 35);
		bottom.add(buttonPrint);
		buttonPrint.setBackground(Color.BLUE);
		buttonPrint.setForeground(Color.white);
		buttonPrint.setFont(new Font("SansSerif", Font.BOLD, 15));
		buttonPrint.setMargin(new Insets(0, 0, 0, 0));
		bottom.add(buttonPay);
		
		buttonPay.setBackground(new Color(0, 204, 0));
		buttonPay.setForeground(Color.white);
		buttonPay.setFont(new Font("SansSerif", Font.BOLD, 15));
		buttonPay.setMargin(new Insets(0, 0, 0, 0));
		bottom.setBackground(Color.white);

		bottom.setPreferredSize(new Dimension(220, 35));

		buttonSplitCheck.setActionCommand("SPLIT CHECK");
		buttonNumPad.setActionCommand("NUM PAD");
		buttonRemove.setActionCommand("REMOVE");
		buttonRemove.addActionListener(this);
		
		buttonClear.setActionCommand("CLEAR");
		buttonClear.addActionListener(this);
		setLayout(null);
		
		buttonPay.setActionCommand("PAY");
		buttonPay.addActionListener(this);
		buttonPrint.setActionCommand("PRINT");
		buttonPrint.addActionListener(this);


		add(center);
		add(bottom);

		this.setPreferredSize(new Dimension(250, 210));
		this.setBackground(Color.WHITE);
		subTotalLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		subTotalLabel.setBounds(0, 17, 56, 40);
		add(subTotalLabel);
		
		taxLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		taxLabel.setBounds(0, 65, 56, 40);
		add(taxLabel);
		
		totalLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		totalLabel.setBounds(0, 112, 56, 40);
		add(totalLabel);

	}
	
	public void updateSubtotal(double subtotal) {
		String sub = formatJText(subtotal);  
		txtSubtotal.setText(sub);
	}
	
	public void updateTax(double tax) {
		String tx = formatJText(tax); 
		txtTax.setText(tx);
	}
	
	public void updateTotal(double total) {
		String ttl = formatJText(total);
		txtTotal.setText(ttl); 
	}

	public String formatJText(double d) {
    	return String.format("$%.2f", d); 
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("REMOVE")){
			checkCtrl.removeItemFromCheck();
		} 
		else if(cmd.equals("CLEAR")){
			checkCtrl.clearCheck();
			
		} else if(cmd.equals("PAY")){
			checkCtrl.payCheck();
			
		} else if(cmd.equals("PRINT")){
			checkCtrl.printCheck();
		}
	}
}
