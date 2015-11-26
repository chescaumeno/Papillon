package papillon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Implements the listener
 */

public class PapillonController implements ActionListener {

    private MainView view;
    private PapillonModel model;

    /**
     * Constructor with view
     * @param view main view
     * @param model
     */
    public PapillonController(MainView view, PapillonModel model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Perform the action
     */
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        System.out.println(cmd);

        if (cmd.equals("Drinks") || cmd.equals("Appetizers") ||
            cmd.equals("Sides") || cmd.equals("Entrees") || cmd.equals("Desserts")) {
            view.changeItemPanel(cmd);
        }
        else if (cmd.startsWith("item")){
			String[] data = cmd.split("  ");
			int index = Integer.parseInt(data[1]);
			String type = data[2];

			Item itemAdded = null;
		 	if (type.equals("drinks")){
				itemAdded = new Drinks(Drinks.DRINKS[index], 1, Drinks.PRICES[index]);
		    }
		    else if (type.equals("appetizers")){
				itemAdded = new Appetizers(Appetizers.APPETIZERS[index], 1, Appetizers.PRICES[index]);
    		}
    		else if (type.equals("sides")){
				itemAdded = new Sides(Sides.SIDES[index], 1, Sides.PRICES[index]);
			}
			else if (type.equals("entrees")){
				itemAdded = new Entrees(Entrees.ENTREES[index], 1, Entrees.PRICES[index]);
			}
			else if (type.equals("desserts")){
				itemAdded = new Desserts(Desserts.DESSERTS[index], 1, Desserts.PRICES[index]);
			}
			if (itemAdded != null){
				model.getCurrentServer().addItemToCheck(itemAdded);
				view.updateView();
			}
//}
			else if (cmd.equals("clear")){
				model.getCurrentSever().clearCheck();
				view.updateView();
			}
			else if (cmd.equals("edit")){
				model.editCurrentCheck();
				view.updateView();
			}
			else if (cmd.equals("up")){
				 	if (model.isEditItem()){
						Check check = model.getCurrentServer().getCurrentCheck();
						if (check != null){
			            int pos = Math.max(0, Math.min(check.getCurrentItem() - 1,
						                  check.getItems().size() - 1));
					    check.setCurrentItem(pos);
                        view.updateView();
					}
				}
			}
			else if (cmd.equals("DOWN")){
			     	if (model.isEditItem()){
			         	Check check = model.getCurrentServer().getCurrentCheck();
                     	if (check != null){
						 	int pos = check.getCurrentItem() + 1;
						    if (pos >= check.getItems().size())
						 		pos = 0;
						 	check.setCurrentItem(pos);
						 	view.updateView();
						}
					}
			}
			else if (cmd.equals("RIGHT")){
			     if (model.isEditItem()){
					 Check check = model.getCurrentServer().getCurrentCheck();
					 if (check != null){
					     check.increaseCurrentItem();
                         view.updateView();
					}
				}
				}
        }
			else if (cmd.equals("LEFT")) {
			     if (model.isEditItem()) {
			         Check check = model.getCurrentServer().getCurrentCheck();
			         if (check != null) {
			             check.decreaseCurrentItem();
			             view.updateView();
			         }
			     }
			}
			        else if (cmd.equals("PRINT")) {
			            model.printCheck(); // write print method in PapillonModel
			        }
    }


}