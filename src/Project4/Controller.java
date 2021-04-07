package Project4;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The parent controller for all sub-menu GUI.
 * @author Haochen Ji, Yichen Chen
 */
public class Controller implements Initializable {
    MainController mc;
    Window current;

    public static final List<Integer> ITEM_RANGE = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    public static final int INITIAL_INDEX = 0;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;
    public static final int INITIAL_VALUE = 1;

    /**
     * Setting the main controller in order to
     * @param mc the main controller
     */
    public void setMC(MainController mc){
        this.mc = mc;
    }

    /**
     * Setting current window
     * @param current the current window
     */
    public void setCurrent(Window current) {
        this.current = current;
    }

    /**
     * Closing current window
     */
    public void close(){
        ((Stage)current).close();
    }

    /**
     * Updating information on label and list view by the order information
     * @param order the order with information
     * @param label the label to be updated
     * @param listView the list view to be updated
     */
    public void updateInfo(Order order, Label label, ListView<MenuItem> listView){
        label.setText(String.format("Subtotal: $%.02f", order.getSumPrice()));
        listView.getItems().clear();
        listView.getItems().addAll(order.getContents());
    }

    /**
     * Updating information on labels and list view by the order information
     * @param order the order with information
     * @param subtotal the subtotal label to be updated
     * @param tax the tax label to be updated
     * @param total the total label to be updated
     * @param listView the list view to be updated
     */
    public void updateInfo(Order order, Label subtotal, Label tax, Label total, ListView<MenuItem> listView){
        tax.setText(String.format("Tax: $%.02f", order.getTax()));
        total.setText(String.format("Total: $%.02f", order.getSumPrice() + order.getTax()));
        updateInfo(order, subtotal, listView);
    }

    /**
     * Initializing Function for child classes
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }
}
