package Project3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The driver class to run project 3.
 * @author Haochen Ji, Yichen Chen
 */
public class Main extends Application {

    /**
     * Set the title, fxml file, and the scene of the GUI, and display
     * @param primaryStage primary stage of the GUI
     * @throws Exception if unable to run the project
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
        primaryStage.setTitle("Project 3");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    /**
     * Starts the project 3.
     * @param args command line argus.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
