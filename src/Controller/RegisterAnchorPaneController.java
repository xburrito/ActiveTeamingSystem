package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class RegisterAnchorPaneController {
    private MainAnchorPaneController mainAnchorPaneController;

    @FXML private JFXButton buttonGoBack;
    @FXML private JFXButton buttonSubmitForm;


    // gets mainController
    public void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }

    // handle button action of Browse View
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == buttonSubmitForm) {
            // SEND FORM "NOTIFICATION" TO SU
        }
        else if (event.getSource() == buttonGoBack) {
            // display browser view
            mainAnchorPaneController.displayLoginView();
        }
    }

}