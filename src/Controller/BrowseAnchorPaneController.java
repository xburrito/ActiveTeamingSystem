package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class BrowseAnchorPaneController {

    //Buttons
    @FXML private JFXButton buttonGoBack;
    @FXML private JFXButton buttonLoadMore;

    //@FXML private Button buttonLoadMore; create later

    String buttonDefaultColor = "-fx-background-color:#00C5FF;";

    private MainAnchorPaneController mainAnchorPaneController;

    // gets mainController
    void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }

    // handle button action of Browse View
    @FXML private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == buttonLoadMore) {
            // LOAD MORE CONTENT
        } else if (event.getSource() == buttonGoBack) {
            // display register view
            mainAnchorPaneController.displayLoginView();
        }
    }

}
