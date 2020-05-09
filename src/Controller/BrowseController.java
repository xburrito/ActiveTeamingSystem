package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class BrowseController {

    @FXML private JFXButton buttonLogin;
    @FXML private JFXButton buttonRegister;
    //@FXML private Button buttonLoadMore; create later

    String buttonDefaultColor = "-fx-background-color:#00C5FF;";

    private MainController mainController;

    // gets mainController
    void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == buttonLogin) {
            buttonLogin.setStyle("-fx-background-color:#696969;");
            buttonRegister.setStyle(buttonDefaultColor);

            //mainController.getMainAnchorPane().toFront();
            //loginAnchor
            mainController.displayLoginView();
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
