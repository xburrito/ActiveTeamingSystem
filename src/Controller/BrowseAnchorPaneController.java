package Controller;

import Model.ActiveTeamingSystem;
import Model.Message;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.util.Optional;

public class BrowseAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;


    //Buttons
    @FXML private JFXButton buttonGoBack;
    @FXML private JFXButton buttonLoadMoreProfiles;
    @FXML private JFXButton buttonLoadMoreTeams;
    @FXML private JFXButton buttonReportUser;

    // list views
    @FXML private JFXListView listViewTopProfiles;

    //@FXML private Button buttonLoadMore; create later

    String buttonDefaultColor = "-fx-background-color:#00C5FF;";

    // gets mainController and mainModel
    void injectMainControllerAndMainModel(MainAnchorPaneController mainAnchorPaneController, ActiveTeamingSystem mainModel) throws Exception {
        this.mainAnchorPaneController = mainAnchorPaneController;
        this.systemModel = mainModel;

        // for debugging check that the main controller and model was injected successfully!
        System.out.println("Browse Controller contains Main Controller? " + (this.mainAnchorPaneController!=null));
        System.out.println("Browse Controller contains Main Model? " + (this.systemModel!=null));

        // also, initialize required fields
        systemModel.addTopProfilesToList();
        listViewTopProfiles.getItems().addAll(systemModel.getTopProfilesList());

    }

    // handle button action of Browse View
    @FXML private void handleButtonAction(ActionEvent event) throws IOException {
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
        } else if (event.getSource() == buttonReportUser) {
            TextInputDialog dialog = new TextInputDialog("");
            dialog.setTitle("System Alert");
            dialog.setHeaderText("Want to report a user? please fill out the report using the following format -> \"username: Reason for report \"");
            dialog.setContentText("Please enter your report:");

            // Traditional way to get the response value.
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                systemModel.storeMessage(new Message("Report","May 2020", "Visitor","JackAdminSU",result.get()));
                // backup messageDB
                systemModel.saveMessageDBToFile("src/Database/Messages.txt");
            }
        }
    }

    // in case we want to trigger a "manual" initialization of fields
    public void triggerBrowserInitialization() throws Exception {
        //
    }

} // end BrowseAnchorPaneController