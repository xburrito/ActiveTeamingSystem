package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class LoginAnchorPaneController {
    private MainAnchorPaneController mainAnchorPaneController;
    @FXML private Button buttonLogin; // from browser view
    @FXML private Button buttonRegister;
    //@FXML private Button buttonLoadMore; create later
    @FXML private AnchorPane loginAnchorPane;
    @FXML private JFXButton buttonGoBack;
    @FXML private JFXButton buttonUserLogin; // from log in view



    // gets mainController
    public void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }

    // handle button action of Browse View
    @FXML private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == buttonGoBack) {
            // display browser view
            mainAnchorPaneController.displayBrowseView();
        } else if (event.getSource() == buttonUserLogin) {
            // display main view
            mainAnchorPaneController.displayMainView();
        }
    }

} // end LoginAnchorPaneController
