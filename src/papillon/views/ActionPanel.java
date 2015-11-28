package papillon.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import papillon.controllers.CheckController;

/**
 * Contains the action buttons
 */

public class ActionPanel extends JPanel {

	private JTextArea txtSubtotal = new JTextArea(3, 20);
	private JTextArea txtTax = new JTextArea(3, 20);
	private JTextArea txtTotal = new JTextArea(3, 20);

	private JButton buttonPrint = new JButton("PRINT");
	private JButton buttonPay = new JButton("PAY");
	private JButton buttonSplitCheck = new JButton("<html><center>SPLIT<br />CHECK</center></html>");
	private JButton buttonNumPad = new JButton("<html><center>NUM<br />PAD</center></html>");
	private JButton buttonEdit = new JButton("EDIT");
	private JButton buttonClear = new JButton("CLEAR");

	private CheckController checkCtrl;

	public ActionPanel(CheckController checkCtrl) {
		this.checkCtrl = checkCtrl; 
		initialize(); 
	}

	private void initialize() {
		setLayout(new BorderLayout());

		setBorder(BorderFactory.createEmptyBorder(0, 40, 10, 0));

		JPanel center = new JPanel(new BorderLayout());
		JPanel pntxt = new JPanel(new GridLayout(3, 1));
		pntxt.add(txtSubtotal);
		pntxt.add(txtTax);
		pntxt.add(txtTotal);
		Font txtFont = new Font("Courier New", 0, 12);
		txtSubtotal.setBorder(BorderFactory.createLineBorder(new Color(205, 205, 240)));
		txtTax.setBorder(BorderFactory.createLineBorder(new Color(205, 205, 240)));
		txtTotal.setBorder(BorderFactory.createLineBorder(new Color(205, 205, 240)));
		txtSubtotal.setFont(txtFont);
		txtTax.setFont(txtFont);
		txtTotal.setFont(txtFont);
		center.add(pntxt, BorderLayout.CENTER);
		pntxt.setBackground(Color.white);
		pntxt.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		center.setBackground(Color.white);

		JPanel pnbtn = new JPanel(new GridLayout(4, 1, 0, 5));
		pnbtn.add(buttonSplitCheck);
		pnbtn.add(buttonNumPad);
		pnbtn.add(buttonEdit);
		pnbtn.add(buttonClear);
		pnbtn.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 0));
		pnbtn.setBackground(Color.white);
		center.add(pnbtn, BorderLayout.EAST);
		buttonSplitCheck.setBackground(Color.blue);
		buttonNumPad.setBackground(Color.blue);
		buttonEdit.setBackground(Color.blue);
		buttonClear.setBackground(Color.blue);
		buttonSplitCheck.setForeground(Color.white);
		buttonNumPad.setForeground(Color.white);
		buttonEdit.setForeground(Color.white);
		buttonClear.setForeground(Color.white);
		center.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

		JPanel bottom = new JPanel(new GridLayout(1, 2, 10, 0));
		bottom.add(buttonPrint);
		buttonPrint.setBackground(Color.blue);
		buttonPrint.setForeground(Color.white);
		buttonPrint.setFont(new Font("SansSerif", Font.BOLD, 15));
		buttonPrint.setMargin(new Insets(0, 0, 0, 0));
		bottom.add(buttonPay);
		buttonPay.setBackground(Color.green);
		buttonPay.setForeground(Color.white);
		buttonPay.setFont(new Font("SansSerif", Font.BOLD, 15));
		buttonPay.setMargin(new Insets(0, 0, 0, 0));
		bottom.setBackground(Color.white);

		bottom.setPreferredSize(new Dimension(220, 35));

		buttonSplitCheck.setActionCommand("SPLIT CHECK");
		buttonNumPad.setActionCommand("NUM PAD");
		buttonEdit.setActionCommand("EDIT");

		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);

		this.setPreferredSize(new Dimension(250, 210));
		this.setBackground(Color.white);

	}
}
