package Controller;

import Model.ActiveTeamingSystem;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class HomeAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;

    @FXML private AnchorPane homeAnchorPane;

    // gets mainController
    public void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }

    // gets mainModel
    void injectMainModel(ActiveTeamingSystem systemModel) {
        this.systemModel = systemModel;
    }


    public AnchorPane getHomeContent(){
        return homeAnchorPane;
        //homeAnchorPane.toFront();
    }

}