package papillon;
/**
 * Store information for check
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Check {
 static SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yy hh:mm:ss a");
 
 private Server server; // server belongs to
 private int number; // invoice number
 private Date date;
 
 private ArrayList<Item> items; // items purchased
 private double subTotal;
 private double tax;
 private double grandTotal;
 private double tips;
 
 private boolean opened; // if the check is opened
 private int currentItem; // current item to modify
 
 /**
  * constructs the check with server and number
  * @param server server
  * @param num invoice number
  */
 public Check(Server server, int num){
  this.server = server;
  number = num;
  items = new ArrayList<Item>();
  subTotal = 0;
  tax = 0;
  grandTotal = 0;
  tips = 0;
  currentItem = 0;
  opened = true;
  date = new Date();
 }
 
 /**
  * clear the item
  */
 public void clearItems(){
  if (!opened)
   return;
  items.clear();
  calculate();
 }
 /**
  * add new item to the check
  * @param item new item
  */
 public void addItem(Item item){
  if (!opened)
   return;
  
  for (int i = 0; i < items.size(); i++){
   //same item
   Item curr = items.get(i);
   if (curr.getName().equals(item.getName())){
    curr.setQuantity(curr.getQuantity() + item.getQuantity());
    calculate();
    return;
   }
  }
  // if not found
  items.add(item);
  calculate();
 }
 
 /**
  *calculate the total price
  */
 public void calculate(){
  subTotal = 0;
  for (Item item : items){
   subTotal += item.priceCalculation();
  }
  tax = subTotal * PapillonModel.TAX_RATE; //will be in PapillonModel
  grandTotal = subTotal + tax;
 }
 
 /**
  * decrease the quantity of the current item
  */
 public void decreaseCurrentItem(){
  if (currentItem >= 0 && currentItem < items.size()){
   Item item = items.get(currentItem);
   item.setQuantity(item.getQuantity() - 1);
   calculate();
  }
 }
 
 /**
  * increase the quantity of the current item
  */
 public void increaseCurrentItem(){
  if (currentItem >= 0 && currentItem < items.size()){
   Item item = items.get(currentItem);
   item.setQuantity(item.getQuantity() + 1);
   calculate();
  }
 }
 
 /**
  * get the description
  */
 public String toString(){
  String result = " server: " + server.getName() + "\n";
  
  result += "  " + fmt.format(date) + "\n";
  result += "  " + "Invoice number: " + number + "\n\n";
  result += "  Item    Total\n\n";
  for (int i = 0; i < items.size(); i++){
   Item item = items.get(i);
   if (i == currentItem)
    result += "=>";
   else
    result += "  ";
   result += (item.getQuantity()) + " " + item.getName().replace("\n", " ") + "\n";
   result += String.format("%18s%5s%.2f\n", 
                    String.format("(%.2f ea)", item.getPrice()),
                    "$", item.priceCalculation());
   
  }
  return result;
 }
 
 //getters and setters
 public double getTips(){
  return tips;
 }
 public void setTips(double tips){
  this.tips = tips;
 }
 
 public boolean isOpened(){
  return opened;
 }
 public void setOpened(boolean opened){
  this.opened = opened;
 }
 
 public int getCurrentItem(){
  return currentItem;
 }
 public void setCurrentItem(int currentItem){
  this.currentItem = currentItem;
 }
 
 public Server getServer(){
  return server;
 }

 public int getNumber(){
  return number;
 }
 
 public ArrayList<Item> getItems(){
  return items;
 }
 
 public double getSubTotal(){
  return subTotal;
 }
 
 public double getTax(){
  return tax;
 }
 
 public double getGrandTotal(){
  return grandTotal;
 }
}