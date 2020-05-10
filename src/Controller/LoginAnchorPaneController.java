package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class LoginAnchorPaneController {
    private MainAnchorPaneController mainAnchorPaneController;

    // Layouts
    @FXML private AnchorPane loginAnchorPane;

    // Buttons
    @FXML private Button buttonRegister;
    @FXML private JFXButton buttonLogin;
    @FXML private JFXButton buttonBrowseGuest;

    // gets mainController
    public void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }

    // handle button action of Browse View
    @FXML private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == buttonLogin) {
            // display main view
            mainAnchorPaneController.displayMainView();
        }
        else if (event.getSource() == buttonRegister) {
            // display browser view
            mainAnchorPaneController.displayRegisterView();
        }
        else if (event.getSource() == buttonBrowseGuest) {
            // display browser view
            mainAnchorPaneController.displayBrowseView();
        }
    }

} // end LoginAnchorPaneController
