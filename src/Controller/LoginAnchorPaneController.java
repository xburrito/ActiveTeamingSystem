package Controller;

import Model.ActiveTeamingSystem;
import Model.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class LoginAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;

    // Layouts
    @FXML private AnchorPane loginAnchorPane;

    // Buttons
    @FXML private Button buttonRegister;
    @FXML private JFXButton buttonLogin;
    @FXML private JFXButton buttonBrowseGuest;

    // Fields
    @FXML private JFXTextField fieldEmail;
    @FXML private JFXPasswordField fieldPassword;

    Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);


    // gets mainController
    public void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }
    // gets mainModel
    void injectMainModel(ActiveTeamingSystem systemModel) {
        this.systemModel = systemModel;
    }

   @FXML private void initialize(){
       alertDialog.setTitle("System Alert");
    }

    // handle button action of Browse View
    @FXML private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == buttonLogin) {
            // for debugging ony: display credentials entered
            String email = fieldEmail.getText();
            String password = fieldPassword.getText();
            System.out.println("username:" + email);
            System.out.println("passwords:" + password);

            // validate credentials
            boolean response = systemModel.authenticateCredentials(email, password);

            if(response) {
                // get logged user
                User loggedUser = systemModel.getLoggedUser();
                // set username on profile
                mainAnchorPaneController.setLabeUsername(loggedUser.getUserName());
                mainAnchorPaneController.setLabelReputationScore(String.valueOf(loggedUser.getRepScore()));
                mainAnchorPaneController.setLabelStatus(loggedUser.getStatus());
                // display main view
                mainAnchorPaneController.displayMainView();
            } else {
                alertDialog.setHeaderText("Authentication Failed");
                alertDialog.setContentText("User account not found in database, please try again.");
                alertDialog.showAndWait();
            }

            // ******

            // reset login fields
            fieldEmail.setText("");
            fieldPassword.setText("");


        }
        else if (event.getSource() == buttonRegister) {
            // reset login fields
            fieldEmail.setText("");
            fieldPassword.setText("");

            // display browser view
            mainAnchorPaneController.displayRegisterView();
        }
        else if (event.getSource() == buttonBrowseGuest) {
            // reset login fields
            fieldEmail.setText("");
            fieldPassword.setText("");

            // display browser view
            mainAnchorPaneController.displayBrowseView();
        }
    }

} // end LoginAnchorPaneController
