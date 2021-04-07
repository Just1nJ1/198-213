package Project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * The controller class that control all reaction from Cart GUI.
 * @author Haochen Ji, Yichen Chen
 */
public class CartController extends Controller {

    @FXML
    private ListView<MenuItem> items;

    @FXML
    private Label subtotal;

    @FXML
    private Label tax;

    @FXML
    private Label total;

    /**
     * Closing the window
     * @param event The event invoking this function
     */
    @FXML
    void close(ActionEvent event) {
        close();
    }

    /**
     * Placing current order and adding it to history orders list.
     * @param event The event invoking this function
     */
    @FXML
    void placeOrder(ActionEvent event) {
        if (mc.currentOrder.getContents().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Please add items before placing order.").show();
        } else {
            mc.orders.add(mc.currentOrder);
            mc.currentOrder = new Order(false);
            close();
        }
    }

    /**
     * Removing any item from current order that is selected when the remove button is clicked
     * @param event The event invoking this function
     */
    @FXML
    void remove(ActionEvent event) {
        int index = items.getSelectionModel().getSelectedIndex();
        if (index == -1){
            if (mc.currentOrder.getSumPrice() != 0){
                new Alert(Alert.AlertType.ERROR, "Please select an item to be removed.").show();
            }
        } else {
            mc.currentOrder.remove(index);
            updateInfo(mc.currentOrder, subtotal, tax, total, items);
        }
    }

    /**
     * Updating current display information.
     */
    void refresh(){
        updateInfo(mc.currentOrder, subtotal, tax, total, items);
    }
}
