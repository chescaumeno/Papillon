package papillon.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

import papillon.controllers.CheckController;
import papillon.controllers.PapillonController;
import papillon.models.Check;
import papillon.models.PapillonModel;

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

	private PapillonModel model;

	/**
	 * Constructor
	 * 
	 * @param model
	 *            data model
	 */
	public ActionPanel(PapillonModel panel) {
		this.model = model;
		initialize(); 

	}

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

	/**
	 * Register the action listener
	 * 
	 * @param controller
	 *            action controller
	 */
	public void register(PapillonController controller) {
		buttonPrint.addActionListener(controller);
		buttonPay.addActionListener(controller);
		buttonSplitCheck.addActionListener(controller);
		buttonNumPad.addActionListener(controller);
		buttonEdit.addActionListener(controller);
		buttonClear.addActionListener(controller);
	}

	/**
	 * Update the view
	 */
	public void updateView() {
		Check check = model.getCurrentServer().getCurrentCheck(); // will have
																	// to create
																	// in
																	// PapillonModel

		txtSubtotal.setEditable(check == null || check.isOpened());
		txtTax.setEditable(check == null || check.isOpened());
		txtTotal.setEditable(check == null || check.isOpened());

		if (check == null) {
			txtSubtotal.setText("");
			txtTax.setText("");
			txtTotal.setText("");
		} else {
			txtSubtotal.setText(String.format("Subtotal: \n\n %12s", String.format("$%,.2f", check.getSubTotal())));
			txtTax.setText(String.format("Tax: \n\n %12s", String.format("$%,.2f", check.getTax())));
			txtTotal.setText(String.format("Total: \n\n %12s", String.format("$%,.2f", check.getGrandTotal())));
		}

		if (model.isEditItem()) { // will have to create method in PapillonModel
			buttonEdit.setText("<html><center>END<br />EDIT</center></html>");
		} else {
			buttonEdit.setText("EDIT");
		}
	}
}
