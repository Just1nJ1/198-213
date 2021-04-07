package Project4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The controller class that control all reaction from Coffee ordering GUI.
 * @author Haochen Ji, Yichen Chen
 */
public class CoffeeController extends Controller {
    Order suborder;
    public static final int SIZE_INCREMENT = 1;

    @FXML
    private CheckBox addCream;

    @FXML
    private CheckBox addSyrup;

    @FXML
    private CheckBox addMilk;

    @FXML
    private CheckBox addCrarmel;

    @FXML
    private CheckBox addWhippedCreme;

    @FXML
    private ChoiceBox<String> Size;

    @FXML
    private ComboBox<Integer> Quantity;

    @FXML
    private Spinner<Integer> CreamNum;

    @FXML
    private Spinner<Integer> SyrupNum;

    @FXML
    private Spinner<Integer> MilkNum;

    @FXML
    private Spinner<Integer> CrarmelNum;

    @FXML
    private Spinner<Integer> WhippedCremeNum;

    @FXML
    private Label subtotal;

    @FXML
    private ListView<MenuItem> items;

    /**
     * Adding current coffee into the suborder that will merge with the order when close button is clicked.
     * @param event The event invoking this function
     */
    @FXML
    void add(ActionEvent event) {
        int size = 0;
        switch (Size.getValue()){
            case Coffee.VENTI:
                size += SIZE_INCREMENT;
            case Coffee.GRANDE:
                size += SIZE_INCREMENT;
            case Coffee.TALL:
                size += SIZE_INCREMENT;
            case Coffee.SHORT:
            default:
        }
        Coffee coffee = new Coffee(Quantity.getValue(), size);
        if (addCream.isSelected())
            coffee.add(CreamNum.getValue() + Coffee.CREAM);
        if (addSyrup.isSelected())
            coffee.add(SyrupNum.getValue() + Coffee.SYRUP);
        if (addMilk.isSelected())
            coffee.add(MilkNum.getValue() + Coffee.MILK);
        if (addCrarmel.isSelected())
            coffee.add(CrarmelNum.getValue() + Coffee.CARAMEL);
        if (addWhippedCreme.isSelected())
            coffee.add(WhippedCremeNum.getValue() + Coffee.WHIPPED_CREME);
        suborder.add(coffee);
        updateInfo(suborder, subtotal, items);
    }

    /**
     * Removing the selected coffee from the suborder
     * @param event The event invoking this function
     */
    @FXML
    void remove(ActionEvent event) {
        int index = items.getSelectionModel().getSelectedIndex();
        if (index == Main.NOT_FOUND){
            if (suborder.getSumPrice() != 0){
                new Alert(Alert.AlertType.ERROR, "Please select an item to be removed.").show();
            }
        } else {
            suborder.remove(index);
            updateInfo(suborder, subtotal, items);
        }
    }

    /**
     * Merging the suborder to current order, and closing the window
     * @param event The event invoking this function
     */
    @FXML
    void close(ActionEvent event) {
        mc.currentOrder.add(suborder);
        close();
    }

    /**
     * Initializing the coffee menu GUI
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        suborder = new Order(true);
        Size.getItems().addAll(Coffee.SHORT, Coffee.TALL, Coffee.GRANDE, Coffee.VENTI);
        Size.setValue(Coffee.VENTI);
        Quantity.getItems().addAll(ITEM_RANGE);
        Quantity.getSelectionModel().select(INITIAL_INDEX);
        CreamNum.setVisible(false);
        SyrupNum.setVisible(false);
        MilkNum.setVisible(false);
        CrarmelNum.setVisible(false);
        WhippedCremeNum.setVisible(false);
        CreamNum.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(START_NUMBER, END_NUMBER, INITIAL_VALUE));
        SyrupNum.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(START_NUMBER, END_NUMBER, INITIAL_VALUE));
        MilkNum.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(START_NUMBER, END_NUMBER, INITIAL_VALUE));
        CrarmelNum.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(START_NUMBER, END_NUMBER, INITIAL_VALUE));
        WhippedCremeNum.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(START_NUMBER, END_NUMBER, INITIAL_VALUE));
        addListener();
    }

    /**
     * Adding listener to check boxes
     */
    private void addListener(){
        addCream.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                CreamNum.setVisible(t1);
            }
        });
        addSyrup.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                SyrupNum.setVisible(t1);
            }
        });
        addMilk.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                MilkNum.setVisible(t1);
            }
        });
        addCrarmel.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                CrarmelNum.setVisible(t1);
            }
        });
        addWhippedCreme.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                WhippedCremeNum.setVisible(t1);
            }
        });
    }
}
