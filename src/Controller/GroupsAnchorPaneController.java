package Controller;

import Model.ActiveTeamingSystem;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;

public class GroupsAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;
    // list views
    @FXML
    private JFXListView listViewGroups;

    // gets mainController and mainModel
    void injectMainControllerAndMainModel(MainAnchorPaneController mainAnchorPaneController, ActiveTeamingSystem mainModel) {
        this.mainAnchorPaneController = mainAnchorPaneController;
        this.systemModel = mainModel;

        // also, initialize required fields
        populateGroupsListsView();
    }

    public void populateGroupsListsView(){
        listViewGroups.getItems().addAll(systemModel.getGroupBD());
    }

}