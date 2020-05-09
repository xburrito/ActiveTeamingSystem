package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class LoginController {
    @FXML private MainController mainController;
    @FXML private Button buttonLogin;
    @FXML private Button buttonRegister;
    //@FXML private Button buttonLoadMore; create later
    @FXML private AnchorPane login;





    // gets mainController
    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void showLoginView(){
         login.toFront();
    }
}
