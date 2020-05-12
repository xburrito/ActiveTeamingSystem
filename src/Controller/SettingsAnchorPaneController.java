package Controller;

import Model.ActiveTeamingSystem;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.io.IOException;

public class SettingsAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;

    // labels
    @FXML private Label labelFirstName;
    @FXML private Label labelLastName;

    // fields
    @FXML private JFXTextField fieldUsername;
    @FXML private JFXTextField fieldEmail;
    @FXML private JFXPasswordField fieldPassword;
    @FXML private JFXPasswordField fieldPasswordConfirm;

    // button
    @FXML private JFXButton buttonSaveSettings;

    Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);


    // gets mainController and mainModel
    void injectMainControllerAndMainModel(MainAnchorPaneController mainAnchorPaneController, ActiveTeamingSystem mainModel) {
        this.mainAnchorPaneController = mainAnchorPaneController;
        this.systemModel = mainModel;

        // also, initialize required fields
    }

    // Handle All Button Actions
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == buttonSaveSettings) {

            // get settings to save
            String username = fieldUsername.getText();
            String email = fieldEmail.getText();
            String password = fieldPassword.getText();
            String confirmPassword = fieldPasswordConfirm.getText();


            // change user values
            systemModel.getLoggedUser().setUserName(username);
            systemModel.getLoggedUser().setEmail(email);

            // check password
            if (!password.equals("") && password.equals(confirmPassword)) {
                // set new pass
                systemModel.getLoggedUser().setPassword(password);


                // ALERT
                alertDialog.setHeaderText("System Alert");
                alertDialog.setContentText("Settings have been Successfully Saved!");
                alertDialog.showAndWait();
                // Alert Changes have been saved
            }
            else if (!password.equals("")  && !password.equals(confirmPassword)) {
                // Alert Passwords do not match
                alertDialog.setHeaderText("System Alert!");
                alertDialog.setContentText("Entered Passwords do not match! try again");
                alertDialog.showAndWait();
            }
        }
        // save changes to external database
        systemModel.overwriteUserFile("src/Database/User_database.csv");
    }

    /**
     * Saves New Account Changes
     */
//		this.theView.saveSettingsButton(new ActionListener() {
//        public void actionPerformed(ActionEvent e) {
//
//            // if Name & Picture Fields are not empty
//            if (!theView.getProfileName().equals("") && !theView.getProfilePicturePath().equals("")) {
//
//                String name = theView.getNewName();
//                String picturePath = theView.getProfilePicturePath();
//                String country = theView.getNewCountry();
//                boolean status = theModel.getCurrentUser().getStatus();
//
//                // update Profile
//                theModel.updateUserProfile(picturePath, name, country, status);
//
//                // populate current user profile
//                theView.setprofilePicture(theModel.getCurrentUser().getPicture());
//                theView.setProfileName(theModel.getCurrentUser().getName());
//                theView.setProfileCountry(theModel.getCurrentUser().getCountry());
//
//                if (theModel.getCurrentUser().getStatus() == true) {
//                    theView.setProfileStatus("Online");
//                } else {
//                    theView.setProfileStatus("Offline");
//                }
//
//                // update network List
//                repopulateNetworkList();
//
//                //resetKeyFields after settings are saved
//                //theView.resetKeyFields();
//            }
//        }
//    });

    // this methods populates settings fields. it gets triggered when the user clicks the setting tab
    public void triggerInitializationOfSettingsView(){
        systemModel.printUserDB();

        // set fields
        labelFirstName.setText(systemModel.getLoggedUser().getFirstName());
        labelLastName.setText(systemModel.getLoggedUser().getFirstName());
        fieldUsername.setText(systemModel.getLoggedUser().getUserName());
        fieldEmail.setText(systemModel.getLoggedUser().getEmail());
    }
}
