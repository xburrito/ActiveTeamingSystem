package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class LoginAnchorPaneController {
    @FXML private MainAnchorPaneController mainAnchorPaneController;
    @FXML private Button buttonLogin;
    @FXML private Button buttonRegister;
    //@FXML private Button buttonLoadMore; create later
    @FXML private AnchorPane loginAnchorPane;





    // gets mainController
    public void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }

    public void showLoginView(){
         loginAnchorPane.toFront();
    }
}
