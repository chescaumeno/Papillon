package papillon;

/**
 * This is the model for the login portion of the program.
 * @author Anna Umeno, Lymari Montijo, Caleb Mussulman, Matt New, Nanette Springer
 *
 */
public class LoginModel {
 
 //private int value; //numeric value of the button the user just pressed from UI
 
 //stuff that's displayed on the GUI
 private String displayString; //String corresponding to what the user is entering
 private String operation; //either "Clear" or "Login"
 private boolean start; //True if next digit entered starts a new value
 
 /**
  * Constructor - Initializes the LoginModel instance variables
  */
 public LoginModel(){
  //value = 0;
  displayString = ""; //+ guiValue;
  start = true;
  operation = "";
 }
 
 /**
  * @return displayString the String value of what was just calculated or what the 
  * user is entering
  */
 public String getValue(){
  return displayString;
 }
 
 public void update(String text){
  if(start){   
   //value = 0;
   displayString = "";
   start = false;
  }
  if(text.length() == 1 && "0123456789".indexOf(text) >= 0){
   displayString += "*";
   //value = Integer.valueOf(displayString);
  }
  else{
   displayString = ""; //+ guiValue;
   operation = text;
   start = true;
   if(operation.equals("Clear")){
   // value = 0;
    displayString = "";
   }
  }
  
 }
}
