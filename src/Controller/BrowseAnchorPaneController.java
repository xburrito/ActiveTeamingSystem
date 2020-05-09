package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class BrowseAnchorPaneController {

    @FXML private JFXButton buttonLogin;
    @FXML private JFXButton buttonRegister;
    //@FXML private Button buttonLoadMore; create later

    String buttonDefaultColor = "-fx-background-color:#00C5FF;";

    private MainAnchorPaneController mainAnchorPaneController;

    // gets mainController
    void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }

    // handle button action of Browse View
    @FXML private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == buttonLogin) {
            // display login view
            mainAnchorPaneController.displayLoginView();
        } else if (event.getSource() == buttonRegister) {
            // display register view
            mainAnchorPaneController.displayRegisterView();
        }
    }

    public JFXButton getButton(){
        return buttonLogin;
    }

}
