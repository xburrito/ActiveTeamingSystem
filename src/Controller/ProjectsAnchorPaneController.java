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
    @FXML private JFXListView listViewProjects;

    // gets mainController and mainModel
    void injectMainControllerAndMainModel(MainAnchorPaneController mainAnchorPaneController, ActiveTeamingSystem mainModel) {
        this.mainAnchorPaneController = mainAnchorPaneController;
        this.systemModel = mainModel;

        // for debugging check that the main controller and model was injected successfully!
        System.out.println("Projects Controller contains Main Controller? " + (this.mainAnchorPaneController!=null));
        System.out.println("Projects Controller contains Main Model? " + (this.systemModel!=null));

        // also, initialize required fields
        populateProjectsListsView();
    }

    public void populateProjectsListsView(){
        listViewProjects.getItems().clear();
        listViewProjects.getItems().addAll(systemModel.getProjectList());
    }

}
