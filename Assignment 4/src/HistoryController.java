package Project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * The controller class that control all reaction from History orders GUI
 * @author Haochen Ji, Yichen Chen
 */
public class HistoryController extends Controller {

    @FXML
    private ListView<Order> items;

    /**
     * Closing the window
     * @param event The event invoking this function
     */
    @FXML
    void close(ActionEvent event) {
        close();
    }

    /**
     * Exporting all history orders remaining into a given file selected by user
     * @param event The event invoking this function
     */
    @FXML
    void export(ActionEvent event) {
        if (mc.orders.getOrders().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "History orders is empty.").show();
        } else {
            File file = new FileChooser().showSaveDialog(null);
            if (file == null){
                new Alert(Alert.AlertType.ERROR, "Please choose a file.").show();
            } else {
                PrintWriter printWriter = null;
                try {
                    printWriter = new PrintWriter(file);
                } catch (FileNotFoundException e) {
                    new Alert(Alert.AlertType.ERROR, "Print Writer cannot initialize.").show();
                }
                for (Order o : mc.orders.getOrders())
                    printWriter.println(o);
                printWriter.close();
            }
        }
    }

    /**
     * Removing the selected order from the orders list
     * @param event The event invoking this function
     */
    @FXML
    void remove(ActionEvent event) {
        int index = items.getSelectionModel().getSelectedIndex();
        if (index == Main.NOT_FOUND){
            if (!mc.orders.getOrders().isEmpty()){
                new Alert(Alert.AlertType.ERROR, "Please select an item to be removed.").show();
            }
        } else {
            mc.orders.getOrders().remove(index);
            refresh();
        }
    }

    /**
     * Updating orders list view
     */
    void refresh(){
        items.getItems().clear();
        items.getItems().addAll(mc.orders.getOrders());
    }
}
