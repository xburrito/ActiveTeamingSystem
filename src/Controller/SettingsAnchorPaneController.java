package Controller;

import Model.ActiveTeamingSystem;
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

        // for debugging check that the main controller and model was injected successfully!
        System.out.println("Settings Controller contains Main Controller? " + (this.mainAnchorPaneController!=null));
        System.out.println("Settings Controller contains Main Model? " + (this.systemModel!=null));

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


            // update Profile
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
        systemModel.saveUserDBToFile("src/Database/User.csv");
    }

    // this methods populates settings fields. it gets triggered when the user clicks the setting tab
    public void triggerInitializationOfSettingsView(){
        systemModel.printUserDB();

        // set fields
        labelFirstName.setText(systemModel.getLoggedUser().getFirstName());
        labelLastName.setText(systemModel.getLoggedUser().getLastName());
        fieldUsername.setText(systemModel.getLoggedUser().getUserName());
        fieldEmail.setText(systemModel.getLoggedUser().getEmail());
    }
}
