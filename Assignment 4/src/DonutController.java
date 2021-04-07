package Project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The controller class that control all reaction from Donut ordering GUI
 * @author Haochen Ji, Yichen Chen
 */
public class DonutController extends Controller {
    public static final String CAKE_DONUT = "CakeDonut";
    public static final String YEAST_DONUT = "YeastDonut";
    public static final String DONUT_HOLE = "DonutHole";
    public static final String CHOCOLATE_FLAVOR = "Chocolate";
    public static final String BLUEBERRY_FLAVOR = "Blueberry";
    public static final String STRAWBERRY_FLAVOR = "Strawberry";


    Order suborder;

    @FXML
    private ChoiceBox<String> kind;

    @FXML
    private ComboBox<Integer> quantity;

    @FXML
    private ListView<MenuItem> items;

    @FXML
    private Label subtotal;

    @FXML
    private ChoiceBox<String> flavor;

    /**
     * Adding current donut into the suborder that will merge with the order when close button is clicked.
     * @param event The event invoking this function
     */
    @FXML
    void add(ActionEvent event) {
        MenuItem donut;
        switch (kind.getValue()){
            case CAKE_DONUT:
                donut = new CakeDonut(quantity.getValue(), flavor.getValue());
                break;
            case YEAST_DONUT:
                donut = new YeastDonut(quantity.getValue(), flavor.getValue());
                break;
            default:
                donut = new DonutHole(quantity.getValue(), flavor.getValue());
                break;
        }
        suborder.add(donut);
        updateInfo(suborder, subtotal, items);
    }

    /**
     * Merging the suborder to current order, and closing the window
     * @param event The event invoking this function
     */
    @FXML
    void close(ActionEvent event) {
        close();
        mc.currentOrder.add(suborder);
    }

    /**
     * Removing the selected donut from the suborder
     * @param event The event invoking this function
     */
    @FXML
    void remove(ActionEvent event) {
        int index = items.getSelectionModel().getSelectedIndex();
        if (index == -1){
            if (suborder.getSumPrice() != 0){
                new Alert(Alert.AlertType.ERROR, "Please select an item to be removed.").show();
            }
        } else {
            suborder.remove(index);
            updateInfo(suborder, subtotal, items);
        }
    }

    /**
     * Initializing the donut menu GUI
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        suborder = new Order(true);
        kind.getItems().addAll(CAKE_DONUT, YEAST_DONUT, DONUT_HOLE);
        kind.setValue(CAKE_DONUT);
        flavor.getItems().addAll(CHOCOLATE_FLAVOR, BLUEBERRY_FLAVOR, STRAWBERRY_FLAVOR);
        flavor.setValue(CHOCOLATE_FLAVOR);
        quantity.getItems().addAll(ITEM_RANGE);
        quantity.getSelectionModel().select(INITIAL_INDEX);
    }

}