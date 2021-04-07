package Project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The driver class to run project 4.
 * @author Haochen Ji, Yichen Chen
 */
public class Main extends Application {
    public static final int NOT_FOUND = -1;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    /**
     * Set the title, fxml file, and the scene of the GUI, and display
     * @param primaryStage primary stage of the GUI
     * @throws Exception if unable to run the project
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("Project 4");
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.show();
    }

    /**
     * Starts the project 4.
     * @param args command line argus.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
