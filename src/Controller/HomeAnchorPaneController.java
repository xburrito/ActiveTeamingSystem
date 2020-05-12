package Controller;

import Model.ActiveTeamingSystem;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class HomeAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;

    //Buttons
    //@FXML private JFXButton ;
    //@FXML private JFXButton ;
    //FXML private JFXButton ;

    // list views
    @FXML private JFXListView listViewProfiles;
    @FXML private JFXListView listViewGroups;
    @FXML private JFXListView listViewProjects;

    @FXML private AnchorPane homeAnchorPane;

    // gets mainController and mainModel
    public void injectMainControllerAndMainModel(MainAnchorPaneController mainAnchorPaneController, ActiveTeamingSystem mainModel) {
        this.mainAnchorPaneController = mainAnchorPaneController;
        this.systemModel = mainModel;

        // also, initialize required fields
        populateAllViewLists();
    }


    public AnchorPane getHomeContent(){
        return homeAnchorPane;
        //homeAnchorPane.toFront();
    }

    public void populateAllViewLists(){
        systemModel.addProfilesToList();
        listViewProfiles.getItems().addAll(systemModel.getProfiles());
        listViewGroups.getItems().addAll(systemModel.getGroupBD());
        //listViewProjects.getItems().addAll(systemModel.getTopProfilesList());
    }

}