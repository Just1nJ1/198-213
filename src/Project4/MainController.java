package Project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The controller class that control all reaction from main GUI
 * @author Haochen Ji, Yichen Chen
 */
public class MainController {

    StoreOrders orders = new StoreOrders();
    Order currentOrder = new Order(false);

    /**
     * Opening coffee menu GUI
     * @param event The event invoking this function
     * @throws IOException Failed to open .fxml
     */
    @FXML
    void CoffeeMenu(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CoffeeMenu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Coffee");
        stage.setScene(new Scene(root));
        CoffeeController controller = fxmlLoader.getController();
        controller.setMC(this);
        controller.setCurrent(stage.getScene().getWindow());
        stage.show();
    }

    /**
     * Opening donut menu GUI
     * @param event The event invoking this function
     * @throws IOException Failed to open .fxml
     */
    @FXML
    void DonutMenu(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DonutMenu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Donut");
        stage.setScene(new Scene(root));
        DonutController controller = fxmlLoader.getController();
        controller.setMC(this);
        controller.setCurrent(stage.getScene().getWindow());
        stage.show();
    }

    /**
     * Opening cart GUI
     * @param event The event invoking this function
     * @throws IOException Failed to open .fxml
     */
    @FXML
    void CurrentOrder(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CartMenu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Cart");
        stage.setScene(new Scene(root));
        CartController controller = fxmlLoader.getController();
        controller.setMC(this);
        controller.setCurrent(stage.getScene().getWindow());
        controller.refresh();
        stage.show();
    }

    /**
     * Opening history orders GUI
     * @param event The event invoking this function
     * @throws IOException Failed to open .fxml
     */
    @FXML
    void HistoryOrders(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HistoryMenu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Coffee");
        stage.setScene(new Scene(root));
        HistoryController controller = fxmlLoader.getController();
        controller.setMC(this);
        controller.setCurrent(stage.getScene().getWindow());
        controller.refresh();
        stage.show();
    }

}
