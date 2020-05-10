package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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

    // Fields
    @FXML private JFXTextField fieldEmail;
    @FXML private JFXPasswordField fieldPassword;

    // gets mainController
    public void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }

    // handle button action of Browse View
    @FXML private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == buttonLogin) {
            // for debugging ony: display credentials entered
            String email = fieldEmail.getText();
            String password = fieldPassword.getText();
            System.out.println("username: " + email);
            System.out.println("passwords:" + password);

            // validate credentials
            // ******

            // reset login fields
            fieldEmail.setText("");
            fieldPassword.setText("");

            // display main view
            mainAnchorPaneController.displayMainView();
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
