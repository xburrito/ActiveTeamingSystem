package Controller;

import Model.ActiveTeamingSystem;
import Model.Application;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

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

        // for debugging check that the main controller and model was injected successfully!
        System.out.println("Register Controller contains Main Controller? " + (this.mainAnchorPaneController!=null));
        System.out.println("Register Controller contains Main Model? " + (this.systemModel!=null));

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
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == buttonSubmitForm) {

            if (radioGroup.getSelectedToggle() != null && radioButtonNO == radioGroup.getSelectedToggle()) {
                // ALERT
                alertDialog.setHeaderText("No Reference!");
                alertDialog.setContentText("You cannot register into the system if you dont have a reference.");
                alertDialog.showAndWait();
            } // then check that none of the fields are empty.
            else if (!fieldUsername.getText().equals("") && !fieldEmail.getText().equals("") && !fieldPassword.getText().equals("") && datePickerDOB.getValue() != null &&
                    !fieldPassConfirm.getText().equals("") && !fieldReference.getText().equals("")) {

                // get application fields
                String submissionDate = "May 7, 2020"; // later get current date from system
                String applicantUsername = fieldUsername.getText();
                String applicantName = "Name: "+applicantUsername; // since we forgot the name field on the registration page.
                String applicantEmail = fieldEmail.getText();
                String applicantDOB = datePickerDOB.getValue().toString();
                String applicantPassword = fieldPassword.getText();
                String passConfirm = fieldPassConfirm.getText();
                String applicantReferrer = fieldReference.getText();
                String applicantReferrerStatus = radioGroup.getSelectedToggle().toString();
                // String applicantReferrerStatus = radioGroup.getSelectedToggle().getUserData().toString();

                // for debuggin only: print all entered fields
//                    System.out.println(applicantUsername);
//                    System.out.println(applicantEmail);
//                    System.out.println(applicantDOB);
//                    System.out.println(applicantPassword);
//                    System.out.println(passConfirm);
//                    System.out.println(applicantReferrer);
//                    System.out.println(applicantReferrerStatus);


                // verify username
                if(systemModel.findUser(fieldUsername.getText())!=null) {
                    // ALERT
                    alertDialog.setHeaderText("Username not available!");
                    alertDialog.setContentText("Please choose a different username!");
                    alertDialog.showAndWait();
                } else { // verify password
                    // check that passwords match
                    if (verifyPassword(applicantPassword, passConfirm)) {

                        // check that referrer if found in the database and that it's directed to him.
                        if(systemModel.findReferral(applicantReferrer)!=null && systemModel.findReferral(applicantReferrer).getReferrerinviteeEmail().equals(applicantEmail)) {
                            // create application
                            Application newApplication = new Application(submissionDate,applicantDOB,applicantPassword,applicantName,applicantUsername,applicantEmail,applicantReferrer,applicantReferrerStatus);
                            // send/store application into applicationDB (SU application)
                            systemModel.addApplicationToDB(newApplication);
                            // backup application
                            systemModel.saveApplicationDBToFile();

                            // ALERT
                            alertDialog.setHeaderText("System Alert!");
                            alertDialog.setContentText("Application Sent, if your application gets approved by the SU, you will be able to sign in!");
                            alertDialog.showAndWait();
                        } else {
                            // ALERT
                            alertDialog.setHeaderText("Referral not valid!");
                            alertDialog.setContentText("you need a valid referral!");
                            alertDialog.showAndWait();
                        }


                    } else {
                        // ALERT
                        alertDialog.setHeaderText("Entered Passwords do not Match!");
                        alertDialog.setContentText("Your password should match!");
                        alertDialog.showAndWait();
                    }

                }


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