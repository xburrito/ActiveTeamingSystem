package Controller;

import Model.ActiveTeamingSystem;
import Model.Message;
import Model.TopProfile;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

public class HomeAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;

    //Buttons
    @FXML private JFXButton buttonBlacklist;
    @FXML private JFXButton buttonCollaborationRequest;
    @FXML private JFXButton buttonSendMessage;

    // list views
    @FXML private JFXListView listViewProfiles;

    @FXML private AnchorPane homeAnchorPane;

    // gets mainController and mainModel
    public void injectMainControllerAndMainModel(MainAnchorPaneController mainAnchorPaneController, ActiveTeamingSystem mainModel) {
        this.mainAnchorPaneController = mainAnchorPaneController;
        this.systemModel = mainModel;

        // for debugging check that the main controller and model was injected successfully!
        System.out.println("Home Controller contains Main Controller? " + (this.mainAnchorPaneController!=null));
        System.out.println("Home Controller contains Main Model? " + (this.systemModel!=null));

        // also, initialize required fields
        populateProfileListsView();
    }

    // handle button action of Browse View
    @FXML private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == buttonBlacklist) {
            // .....
        } else if (event.getSource() == buttonSendMessage) {
            // get selected user
            TopProfile profile = (TopProfile) listViewProfiles.getSelectionModel().getSelectedItem();

            TextInputDialog dialog = new TextInputDialog("");
            dialog.setTitle("System Alert");
            dialog.setHeaderText("Send Message to, " + profile.getUserName() + "?");
            dialog.setContentText("Please enter your message:");

            // Traditional way to get the response value.
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                systemModel.storeMessage(new Message("Normal","May 2020", systemModel.getLoggedUser().getUserName(),profile.getUserName(),result.get()));
                // backup messageDB
                systemModel.saveMessageDBToFile("src/Database/Messages.txt");
            }
        } else if (event.getSource() == buttonCollaborationRequest) {
            // get selected user
            TopProfile profile = (TopProfile) listViewProfiles.getSelectionModel().getSelectedItem();

            TextInputDialog dialog = new TextInputDialog("");
            dialog.setTitle("System Alert");
            dialog.setHeaderText("Want to collaborate with, " + profile.getUserName() + "?");;
            dialog.setContentText("Enter your message:");

            // Traditional way to get the response value.
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                systemModel.storeMessage(new Message("Collab","May 2020", systemModel.getLoggedUser().getUserName(),profile.getUserName(),result.get()));
                // backup messageDB
                systemModel.saveMessageDBToFile("src/Database/Messages.txt");
            }
        }
    }


    public AnchorPane getHomeContent(){
        return homeAnchorPane;
        //homeAnchorPane.toFront();
    }

    public void populateProfileListsView(){
        systemModel.addProfilesToList();
        listViewProfiles.getItems().addAll(systemModel.getProfiles());
    }

}