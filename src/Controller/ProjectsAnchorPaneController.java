package Controller;

import Model.ActiveTeamingSystem;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;

public class ProjectsAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;
    // list views
    @FXML
    private JFXListView listViewProjects;

    // gets mainController and mainModel
    void injectMainControllerAndMainModel(MainAnchorPaneController mainAnchorPaneController, ActiveTeamingSystem mainModel) {
        this.mainAnchorPaneController = mainAnchorPaneController;
        this.systemModel = mainModel;

        // also, initialize required fields
        populateProjectsListsView();
    }

    public void populateProjectsListsView(){
        //systemModel.addProjectsToList();
        //listViewProjects.getItems().addAll(systemModel.getTopProfilesList());
    }

}
