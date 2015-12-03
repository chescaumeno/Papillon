package papillon.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.Highlight;

import papillon.controllers.*;
import papillon.models.*;
import papillon.views.*;

/**
 * Contains the check information
 */

public class CheckPanel extends JPanel implements ActionListener{
 
	private static SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yy hh:mm:ss a");
	
    private JTextArea txtInfo = new JTextArea();
    private JButton buttonLook = new JButton("<html><center>Invoice<br>Lookup</center></html>");
    private JButton buttonNewCheck = new JButton("<html><center>New<br>Check</center></html>");
    private JButton buttonTipAdj = new JButton("<html><center>Tip<br>Adjust</center></html>");
    private Highlighter.HighlightPainter orange = new DefaultHighlighter.DefaultHighlightPainter(Color.orange);
    
    private String serverName; 
    private Date date; 
    private String invoiceNum; 
    private ArrayList<CheckItem> checkItems;
    private double subtotal; 
    private double tax; 
    private double total;
    private double tip;
    private String header;//needed to get the right offset for highlighter
    private String result;
    
    private CheckController checkCtrl;
    
    public CheckPanel(CheckController checkCtrl) {
    	this.checkCtrl = checkCtrl;
    	initialize();
    }
    

    private void initialize() {
    	setBorder(BorderFactory.createLineBorder(new Color(205, 205, 240)));
        setLayout(new BorderLayout());
        JScrollPane scr = new JScrollPane(txtInfo);
        scr.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        scr.setBackground(Color.white);
        add(scr, BorderLayout.CENTER);
        Font txtFont1 = new Font ("monospaced", 0, 11);
        txtInfo.setFont(txtFont1);
        txtInfo.setEditable(false);
        
        JPanel pnbtn = new JPanel(new BorderLayout());
        pnbtn.setBackground(Color.white);
        JPanel pnbtn1 = new JPanel(new GridLayout(1, 2));
        pnbtn1.setBackground(Color.white);
        JPanel tmp = new JPanel();
        tmp.setBackground(Color.white);
        pnbtn1.add(buttonNewCheck);
        pnbtn1.add(buttonLook);
        pnbtn1.add(buttonTipAdj);
        pnbtn.add(pnbtn1, BorderLayout.NORTH);        
        pnbtn1.setPreferredSize(new Dimension(200, 35));
        
        buttonLook.setFont(new Font("SansSerif", Font.BOLD, 10));
        buttonLook.setBackground(Color.blue);
        buttonLook.setForeground(Color.white);
        buttonLook.setMargin(new Insets(0,0,0,0));
        buttonLook.setActionCommand("INVOICE");
        buttonLook.addActionListener(this);
        
        buttonNewCheck.setFont(new Font("SansSerif", Font.BOLD, 10));
        buttonNewCheck.setBackground(Color.blue);
        buttonNewCheck.setForeground(Color.white);
        buttonNewCheck.setMargin(new Insets(0,0,0,0));
        buttonNewCheck.setActionCommand("NEW");
        buttonNewCheck.addActionListener(this);
       
        buttonTipAdj.setFont(new Font("SansSerif", Font.BOLD, 10));
        buttonTipAdj.setBackground(Color.blue);
        buttonTipAdj.setForeground(Color.white);
        buttonTipAdj.setMargin(new Insets(0,0,0,0));
        buttonTipAdj.setActionCommand("TIP");
        buttonTipAdj.addActionListener(this);
        
        ArrowsPanel arrowsPanel = new ArrowsPanel(checkCtrl);
        pnbtn.add(arrowsPanel, BorderLayout.CENTER);
        pnbtn.setPreferredSize(new Dimension(200, 90));
        
        add(pnbtn, BorderLayout.SOUTH);
        this.setBackground(Color.white);
    }
    
    
    /**
     * Update the view
     */
    public String getCheckFormat() {
    	//TODO: Add the subtotal, tax and total. 
    	//check must also change the quantity of the same item and not add it n times. 
    	
    	
    	result = "KYOTO SUSHI HOUSE\n"; 
    	result += "1 Sushi Way Ste 345\n"; 
    	result += "San Antonio, TX, 78260\n"; 
    	result += "210-555-6789\n"; 
    	result += "\n\n";  
    	
    	result += "Server: " + serverName + "\n";
		
		result += fmt.format(date) + "\n";
		result += "Invoice number: " + invoiceNum + "\n\n";
		result += " ---------------------------  \n\n";
		
		header = result;
		for (CheckItem item: checkItems) {
			result += convertCheckItemToString(item); 
			result += "\n";  
		}
		
		result += "\n\n"; 
		result += "Subtotal:\t" + formatCurrency(subtotal) + "\n"; 
		result += "Tax:\t\t" + formatCurrency(tax) + "\n"; 
		result += "Total:\t\t" + formatCurrency(total) + "\n";
		result += "\nTip:\t\t" + formatCurrency(tip) + "\n";
		
		return result;
    }
    
    public String formatCurrency(double d) {
    	if(d < 10){
    		return(String.format("$ %.2f", d));
    	}
    	return String.format("$%.2f", d); 
    }
    
    public void setResult(String result) {
    	this.result = result;
    }
    
    public String getResult(){
    	return result;
    }
    
    public String getHeader(){
    	return header;
    }
	public void setServerName(String name) {
		serverName = name; 
	}
	
	public void setDate(Date date) {
		this.date = date; 
	}
	
	public void setInvoice(int invoiceNum) {
		this.invoiceNum = Integer.toString(invoiceNum);  
	}
	
	public void setCheckItems(ArrayList<CheckItem> items) {
		checkItems = items; 
	}
	
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public void setTax(double tax) {
		this.tax = tax; 
	}
	
	public void setTotal(double total) {
		this.total = total; 
	}
	
	public void setTip(double tip) {
		this.tip = tip;
	}
	
	public String convertCheckItemToString(CheckItem item) {
		String word = "             "; 
		String shortName = item.getMenuItem().getName() + word;   
		if (shortName.length() >= 13) {
			shortName = shortName.substring(0, 13);
		}
		String price = formatCurrency(item.getMenuItem().getPrice() * item.getQuantity()); 
		String checkItemString = shortName + "    " + item.getQuantity() + "    " + price;
		return checkItemString; 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("NEW")){
			checkCtrl.newCheck();
		} 
		if(cmd.equals("TIP")){
			TipAdjustView tipAdjView = new TipAdjustView();
			TipAdjustModel tipAdjModel = new TipAdjustModel(tipAdjView, checkCtrl);
			TipAdjustController tipAdjCntrl = new TipAdjustController(tipAdjModel, tipAdjView);
			tipAdjView.registerListener(tipAdjCntrl);
		}
		
	}
	
	public void highlightCurrentItem(int itemNum){
		if(itemNum >= 0 && itemNum < checkItems.size()){
			try{
				int start = header.length() + (itemNum * 29);
				int end = (header.length() + 29) + (itemNum * 29);
				txtInfo.getHighlighter().addHighlight(start, end, orange);
			}catch(BadLocationException e){
				//not sure what to do here
			}
		}
	}
	
	public void renderCheck(){
		txtInfo.setText(this.getCheckFormat());
		this.highlightCurrentItem(checkCtrl.getCurrentCheck().getCurrentItem());
	}
}
