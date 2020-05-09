package Controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class HomeController {
    private MainController mainController;
    @FXML private AnchorPane homeAnchorPane;

    // gets mainController
    public void injectMainController(MainController mainController) {
        System.out.println("sdfa");
        this.mainController = mainController;
    }

    public AnchorPane getHomeContent(){
        return homeAnchorPane;
        //homeAnchorPane.toFront();
    }
}
