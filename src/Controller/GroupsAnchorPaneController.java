package Controller;

import Model.ActiveTeamingSystem;
import Model.Message;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.util.Optional;

public class GroupsAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;
    // list views
    @FXML private JFXListView listViewGroups;

    // gets mainController and mainModel
    void injectMainControllerAndMainModel(MainAnchorPaneController mainAnchorPaneController, ActiveTeamingSystem mainModel) {
        this.mainAnchorPaneController = mainAnchorPaneController;
        this.systemModel = mainModel;

        // for debugging check that the main controller and model was injected successfully!
        System.out.println("Groups Controller contains Main Controller? " + (this.mainAnchorPaneController!=null));
        System.out.println("Groups Controller contains Main Model? " + (this.systemModel!=null));


        // also, initialize required fields

    }

//    // handle button action of Browse View
//    @FXML private void handleButtonAction(ActionEvent event) throws IOException {
//        if (event.getSource() == buttonGoBack) {
//            TextInputDialog dialog = new TextInputDialog("");
//            dialog.setTitle("System Alert");
//            dialog.setHeaderText("Want to report a user? please fill out the report using the following format -> \"username: Reason for report \"");
//            dialog.setContentText("Please enter your report:");
//
//            // Traditional way to get the response value.
//            Optional<String> result = dialog.showAndWait();
//            if (result.isPresent()){
//                systemModel.storeMessage(new Message("Report","May 2020", "Visitor","JackAdminSU",result.get()));
//                // backup messageDB
//                systemModel.saveMessageDBToFile("src/Database/Messages.txt");
//            }
//        }
//    }

    public void populateGroupsListsView(){
        listViewGroups.getItems().clear();
        listViewGroups.getItems().addAll(systemModel.getGroupBD());
    }






}