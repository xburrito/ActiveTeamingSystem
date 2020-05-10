package Controller;

import Model.ActiveTeamingSystem;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class BrowseAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;


    //Buttons
    @FXML private JFXButton buttonGoBack;
    @FXML private JFXButton buttonLoadMoreProfiles;
    @FXML private JFXButton buttonLoadMoreTeams;

    // list views
    @FXML private JFXListView listViewTopProfiles;

    //@FXML private Button buttonLoadMore; create later

    String buttonDefaultColor = "-fx-background-color:#00C5FF;";


    @FXML private void initialize() throws Exception {

        // create the System Model
        systemModel = new ActiveTeamingSystem();

        // get user records from external file
        systemModel.readFileToUser("src/Database/User_database.csv");

        systemModel.addTopProfilesToList();
        listViewTopProfiles.getItems().addAll(systemModel.getTopProfilesList());
               // getItems().addAll(fruitList);   //listViewTopProfiles.add


        // get group records from external file
        //systemModel.readFileToGroup("PATH");





    }
    // gets mainController
    void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }

    // handle button action of Browse View
    @FXML private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == buttonGoBack) {
            // display register view
            mainAnchorPaneController.displayLoginView();
        } else if (event.getSource() == buttonLoadMoreProfiles) {
            // LOAD MORE CONTENT
            // add 3 new profiles
            listViewTopProfiles.getItems().clear();
            systemModel.addTopProfilesToList();
            listViewTopProfiles.getItems().addAll(systemModel.getTopProfilesList());
        } else if (event.getSource() == buttonLoadMoreTeams) {
            // add 3 new Teams
            //listViewTopProfiles.getItems().clear();
            //systemModel.addTopProfilesToList();
            //listViewTopProfiles.getItems().addAll(systemModel.getTopProfilesList());
        }
    }

} // end BrowseAnchorPaneController