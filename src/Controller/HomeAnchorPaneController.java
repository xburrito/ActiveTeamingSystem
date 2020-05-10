package Controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class HomeAnchorPaneController {
    private MainAnchorPaneController mainAnchorPaneController;
    @FXML private AnchorPane homeAnchorPane;

    // gets mainController
    public void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }

    public AnchorPane getHomeContent(){
        return homeAnchorPane;
        //homeAnchorPane.toFront();
    }
}
