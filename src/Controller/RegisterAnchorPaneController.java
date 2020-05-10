package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class RegisterAnchorPaneController {
    private MainAnchorPaneController mainAnchorPaneController;

    // buttons
    @FXML private JFXButton buttonGoBack;
    @FXML private JFXButton buttonSubmitForm;
    //@FXML private JFXRadioButton radioButton;

    // fields
    @FXML private JFXDatePicker datePickerDOB;


    // gets mainController
    public void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }

    // handle button action on Browse View
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