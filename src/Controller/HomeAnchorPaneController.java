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

    // gets mainController and mainModel
    public void injectMainControllerAndMainModel(MainAnchorPaneController mainAnchorPaneController, ActiveTeamingSystem mainModel) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }


    public AnchorPane getHomeContent(){
        return homeAnchorPane;
        //homeAnchorPane.toFront();
    }

}