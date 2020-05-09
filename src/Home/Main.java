package Home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage primaryStage;
    public static Stage getStage() { return primaryStage; } //method for controller: returns the stage

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("static-access")
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage; // set primary stage
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("Active Teaming System");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));
    }
}
