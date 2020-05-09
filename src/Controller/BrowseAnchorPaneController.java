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

    @FXML private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == buttonLogin) {
            buttonLogin.setStyle("-fx-background-color:#696969;");
            buttonRegister.setStyle(buttonDefaultColor);

            //mainController.getMainAnchorPane().toFront();
            //loginAnchor
            mainAnchorPaneController.displayLoginView();
            //mainController.getLoginAnchorPane();
            //borderPaneTransactions.setVisible(false);
        } else if (event.getSource() == buttonRegister) {
            //buttonLogin.setStyle(buttonDefaultColor);
            //buttonRegister.setStyle("-fx-background-color:#696969;");
            //mainController.getRegisterAnchorPane();
        }
    }

    public JFXButton getButton(){
        return buttonLogin;
    }

}
