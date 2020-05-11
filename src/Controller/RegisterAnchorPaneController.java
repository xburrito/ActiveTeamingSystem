package Controller;

import Model.ActiveTeamingSystem;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;

public class RegisterAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;

    // buttons
    @FXML private JFXButton buttonGoBack;
    @FXML private JFXButton buttonSubmitForm;
    ToggleGroup radioGroup = new ToggleGroup();
    @FXML private JFXRadioButton radioButtonOU;
    @FXML private JFXRadioButton radioButtonVIP;
    @FXML private JFXRadioButton radioButtonNS;
    @FXML private JFXRadioButton radioButtonNO;

    // fields
    @FXML private JFXTextArea fieldUsername;
    @FXML private JFXTextArea fieldEmail;
    @FXML private JFXDatePicker datePickerDOB;
    @FXML private JFXPasswordField fieldPassword;
    @FXML private JFXPasswordField fieldPassConfirm;
    @FXML private JFXTextArea fieldReference;


//.setSelected(true);


    // gets mainController
    public void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }
    // gets mainModel
    void injectMainModel(ActiveTeamingSystem systemModel) {
        this.systemModel = systemModel;
    }

    @FXML private void initialize(){
        // add all radioButtons to a group
        radioButtonOU.setToggleGroup(radioGroup);
        radioButtonVIP.setToggleGroup(radioGroup);
        radioButtonNS.setToggleGroup(radioGroup);
        radioButtonNO.setToggleGroup(radioGroup);

    }

    // handle button action on Browse View
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == buttonSubmitForm) {

            // first check that none of the fields are empty.
            if (fieldUsername.getText() != null && fieldEmail.getText() != null && fieldPassword != null && datePickerDOB.getValue() != null &&
                    fieldPassConfirm != null && fieldReference != null && radioGroup.getSelectedToggle() != null) {

                // get all fields
                String username = fieldUsername.getText();
                String email = fieldEmail.getText();
                String dateOfBirth = datePickerDOB.getValue().toString();
                String password = fieldPassword.getText();
                String passConfirm = fieldPassConfirm.getText();
                String referrer = fieldReference.getText();
                String radio = radioGroup.getSelectedToggle().toString();

                // for debuggin only: print all entered fields
                System.out.println(username);
                System.out.println(email);
                System.out.println(dateOfBirth);
                System.out.println(password);
                System.out.println(passConfirm);
                System.out.println(referrer);
                System.out.println(radio);
            }
            // SEND FORM "NOTIFICATION" TO SU
        }
        else if (event.getSource() == buttonGoBack) {
            // display browser view
            mainAnchorPaneController.displayLoginView();
        }
    }

}