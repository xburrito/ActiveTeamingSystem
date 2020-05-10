package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class RegisterAnchorPaneController {
    private MainAnchorPaneController mainAnchorPaneController;

    // buttons
    @FXML private JFXButton buttonGoBack;
    @FXML private JFXButton buttonSubmitForm;
    ToggleGroup group = new ToggleGroup();
    @FXML private JFXRadioButton radioButtonOU;
    @FXML private JFXRadioButton radioButtonVIP;
    @FXML private JFXRadioButton radioButtonNS;
    @FXML private JFXRadioButton radioButtonNO;

    // fields
    @FXML private JFXTextArea fieldUsername;
    @FXML private JFXTextArea fieldEmail;
    @FXML private JFXDatePicker datePickerDOB;
    @FXML private JFXTextArea fieldPassword;
    @FXML private JFXTextArea fieldPassConfirm;
    @FXML private JFXTextArea fieldReference;


//.setSelected(true);


    // gets mainController
    public void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }

    @FXML private void initialize(){
        // add all radioButtons to a group
        radioButtonOU.setToggleGroup(group);
        radioButtonVIP.setToggleGroup(group);
        radioButtonNS.setToggleGroup(group);
        radioButtonNO.setToggleGroup(group);

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