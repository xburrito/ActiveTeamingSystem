package Controller;

import Model.ActiveTeamingSystem;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);


//.setSelected(true);


    // gets mainController and mainModel
    public void injectMainControllerAndMainModel(MainAnchorPaneController mainAnchorPaneController, ActiveTeamingSystem mainModel) {
        this.mainAnchorPaneController = mainAnchorPaneController;
        this.systemModel = mainModel;

        // also, initialize required fields
    }


    @FXML private void initialize(){
        alertDialog.setTitle("System Alert");

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

            if (radioGroup.getSelectedToggle() != null && radioButtonNO == radioGroup.getSelectedToggle()) {
                // ALERT
                alertDialog.setHeaderText("No Reference!");
                alertDialog.setContentText("You cannot register into the system if you dont have a reference.");
                alertDialog.showAndWait();
            } // then check that none of the fields are empty.
            else if (!fieldUsername.getText().equals("") && !fieldEmail.getText().equals("") && !fieldPassword.getText().equals("") && datePickerDOB.getValue() != null &&
                    !fieldPassConfirm.getText().equals("") && !fieldReference.getText().equals("")) {

                // get password
                String password = fieldPassword.getText();
                String passConfirm = fieldPassConfirm.getText();
                // check that passwords match
                if (verifyPassword(password, passConfirm)) {
                    // get other fields
                    String username = fieldUsername.getText();
                    String email = fieldEmail.getText();
                    String dateOfBirth = datePickerDOB.getValue().toString();

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

                    // Send application to SU
                   // systemModel.addUser();

                } else {
                    // ALERT
                    alertDialog.setHeaderText("Entered Passwords do not Match!");
                    alertDialog.setContentText("Your password should match!");
                    alertDialog.showAndWait();
                }

                // SEND FORM "NOTIFICATION" TO SU
            } else {
                // ALERT
                alertDialog.setHeaderText("Empty Fields!");
                alertDialog.setContentText("Please make sure that you fill out every field.");
                alertDialog.showAndWait();
            }
        }
        else if (event.getSource() == buttonGoBack) {
            // reset all register fields
            fieldUsername.setText("");
            fieldEmail.setText("");
            datePickerDOB.getEditor().clear();
            datePickerDOB.setValue(null);
            fieldPassword.setText("");
            fieldPassConfirm.setText("");
            fieldReference.setText("");
            radioGroup.selectToggle(null);


            // display browser view
            mainAnchorPaneController.displayLoginView();
        }
    }

    // checks that given passwords match
    public boolean verifyPassword(String pass1, String pass2){
        if (pass1.equals(pass2)) {
            return true;
        }
        return false;
    }

}