package Controller;

import Model.ActiveTeamingSystem;
import Model.Application;
import Model.Poll;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.IOException;

public class VotingReputationAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;

    //buttons
    @FXML private JFXButton buttonAccept;
    @FXML private JFXButton buttonReject;
    // list views
    @FXML private JFXListView listViewMeetings;

    // gets mainController and mainModel
    void injectMainControllerAndMainModel(MainAnchorPaneController mainAnchorPaneController, ActiveTeamingSystem mainModel) {
        this.mainAnchorPaneController = mainAnchorPaneController;
        this.systemModel = mainModel;

        // for debugging check that the main controller and model was injected successfully!
        System.out.println("Voting Controller contains Main Controller? " + (this.mainAnchorPaneController!=null));
        System.out.println("Voting Controller contains Main Model? " + (this.systemModel!=null));


        // also, initialize required fields
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        // get selected Application
        Poll selectedPoll = (Poll) listViewMeetings.getSelectionModel().getSelectedItem();

        if (event.getSource() == buttonAccept) {

            Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
            alertDialog.setTitle("System Alert");
            alertDialog.setHeaderText("Selected Poll was successfully Accepted");
            alertDialog.setContentText("Click Ok to continue");
            alertDialog.showAndWait();

            //remove poll
            systemModel.removePoll(selectedPoll);
            populateMeetingsListsView();

        } else if (event.getSource() == buttonReject) {

            Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
            alertDialog.setTitle("System Alert");
            alertDialog.setHeaderText("Selected Poll was successfully Rejected, and will be removed");
            alertDialog.setContentText("Click Ok to continue");
            alertDialog.showAndWait();

            //remove poll
            systemModel.removePoll(selectedPoll);
            populateMeetingsListsView();

        }
    }

    public void populateMeetingsListsView(){
        listViewMeetings.getItems().clear();
        listViewMeetings.getItems().addAll(systemModel.getPollDB(systemModel.getLoggedUser().getUserName()));
    }


} // end class
