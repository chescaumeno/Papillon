package papillon;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * This class manages the login view GUI layout
 * @author Anna Umeno, Lymari Montijo, Caleb Mussulman, Matt New, Nanette Springer
 *
 */
public class LoginView extends JFrame {
 private JPanel loginPanel;
 private JPanel idPanel;   //Maybe remove later
 private JPanel pinPanel;  //Maybe remove later
 private JPanel logoPanel;
 private JPanel displayPanel;
 private JPanel numPadPanel;
 
 private JLabel idLabel;   //Maybe remove later
 private JLabel pinLabel;  //Maybe remove later
 private JLabel pinDisplay;
 
 private JTextField idTextField; //Maybe remove later
 private JTextField pinTextField; //Maybe remove later
 
 private JButton loginButton;
 
 private Font font, fontHash;
 
 private int digits;

 /**
  * Constructor - Initialize the login window frame
  */
 public LoginView() {
  setTitle("Papillon POS System");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setSize(500, 675);
  setLayout(new BorderLayout(0,0));
  font = new Font("Verdana", Font.BOLD, 20);
  fontHash = new Font("Verdana", Font.PLAIN, 55);
  
  //Will display papillon logo on login screen
  logoPanel = new JPanel();      
  logoPanel.add(new JLabel(new ImageIcon(getClass().getResource("images/logo.jpg"))));
  add(logoPanel, BorderLayout.NORTH);
  
  //Create display that will show hashed pin entered
  displayPanel = new JPanel(new BorderLayout());
  pinDisplay = new JLabel("Enter PIN");
  pinDisplay.setFont(fontHash);
  pinDisplay.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
  pinDisplay.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
  displayPanel.add(pinDisplay);
  digits = -1;
  add(displayPanel, BorderLayout.CENTER);

  //Create number pad where user can enter pin
  numPadPanel = new JPanel();
  numPadPanel.setLayout(new GridLayout(4,3,0,0));
  String[] numPadStrings = {
    "1", "2", "3",
    "4", "5", "6",
    "7", "8", "9",
   "Clear", "0", "Login"
  };
  for(String s: numPadStrings){
   JButton numPadButton = new JButton(s);
   numPadButton.setPreferredSize(new Dimension(100,100));
   numPadPanel.add(numPadButton);
  }

  add(numPadPanel, BorderLayout.SOUTH);
  setVisible(true);
}
 
 public void registerListener(LoginController controller){
  //loginButton.addActionListener(controller);
 
  Component[] components = numPadPanel.getComponents();
  for (Component component : components) {
   if (component instanceof AbstractButton) {
    AbstractButton button = (AbstractButton) component;

    button.addActionListener(controller);
    button.setFont(font);
   }
  }
 }
 
 /**
  * Display the value in the JLabel of the pin display.
  * 
  * @param value the value to be displayed
  */
 public void update(String value) {
  if (digits < 0) {
   pinDisplay.setText(value);
  } 
 }
 
 /////////////////////////////////////////////////////////////////////////////////////////////
 //**************************  GETTERS AND SETTERS  *******************************//
 /////////////////////////////////////////////////////////////////////////////////////////////
 public void setDigits(int digits){
  this.digits = digits;
 }
 public JPanel getLoginPanel() {
  return loginPanel;
 }

 public void setLoginPanel(JPanel loginPanel) {
  this.loginPanel = loginPanel;
 }

 public JLabel getIdLabel() {
  return idLabel;
 }

 public void setIdLabel(JLabel idLabel) {
  this.idLabel = idLabel;
 }

 public JLabel getPinLabel() {
  return pinLabel;
 }

 public void setPinLabel(JLabel pinLabel) {
  this.pinLabel = pinLabel;
 }

 public JTextField getIdTextField() {
  return idTextField;
 }

 public void setIdTextField(JTextField idTextField) {
  this.idTextField = idTextField;
 }

 public JTextField getPinTextField() {
  return pinTextField;
 }

 public void setPinTextField(JTextField pinTextField) {
  this.pinTextField = pinTextField;
 }

 public JButton getLoginButton() {
  return loginButton;
 }

 public void setLoginButton(JButton loginButton) {
  this.loginButton = loginButton;
 }

 public JPanel getIdPanel() {
  return idPanel;
 }

 public void setIdPanel(JPanel idPanel) {
  this.idPanel = idPanel;
 }

 public JPanel getPinPanel() {
  return pinPanel;
 }

 public void setPinPanel(JPanel pinPanel) {
  this.pinPanel = pinPanel;
 }
}