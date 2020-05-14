package Controller;

import Model.ActiveTeamingSystem;
import Model.Message;
import Model.TopProfile;
import Model.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    @FXML private JFXButton buttonBlackList;
    @FXML private JFXButton buttonCollaborationRequest;
    @FXML private JFXButton buttonSendMessage;
    @FXML private JFXButton buttonCompliment;

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

    }

    // handle button action of Browse View
    @FXML private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == buttonBlackList) {
            TopProfile profile = (TopProfile) listViewProfiles.getSelectionModel().getSelectedItem();
            User user = systemModel.findUser(profile.getUserName());

            Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
            alertDialog.setTitle("System Alert");
            alertDialog.setHeaderText("Selected user will be removed from the database and will be blacklisted.");
            alertDialog.setContentText("Click Ok to continue");
            alertDialog.showAndWait();

            // add user to black list
            systemModel.getBlackList().add(user);
            // update db
            systemModel.removeUser(user.getUserName());
            //systemModel.getUserBD().remove(user);
            // backup database
            systemModel.saveUserDBToFile();

            // refresh
            populateProfileListsView();

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
                systemModel.addMessageToDB(new Message("Normal","May 2020", systemModel.getLoggedUser().getUserName(),profile.getUserName(),result.get()));
                // backup messageDB
                systemModel.saveMessageDBToFile();
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
                systemModel.addMessageToDB(new Message("Collab","May 2020", systemModel.getLoggedUser().getUserName(),profile.getUserName(),result.get()));
                // backup messageDB
                systemModel.saveMessageDBToFile();
            }
        } else if (event.getSource() == buttonCompliment) {
            // get selected user
            TopProfile profile = (TopProfile) listViewProfiles.getSelectionModel().getSelectedItem();

            User user = systemModel.findUser(profile.getUserName());
//            int complimentValue;
//
//            // decide compliment score
//            if(systemModel.getLoggedUser().getStatus().equals("OU")) {
//                complimentValue = 10;
//            } else if (systemModel.getLoggedUser().getStatus().equals("VIP")){
//                complimentValue = 20;
//            } else {
//                complimentValue = 20;
//            }
//
//            // update reputation of selected user.
//            user.setRepScore(user.getRepScore()+complimentValue);
//
//            // backup database
//            systemModel.saveUserDBToFile();
//
//            Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
//            // ALERT
//            alertDialog.setHeaderText("System Alert!");
//            alertDialog.setContentText("The new score of completed user has been updated! the new score is" + user.getRepScore());
//            alertDialog.showAndWait();


            // ALERT
            Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
            alertDialog.setHeaderText("System Alert!");
            alertDialog.setContentText(user.getUserName() + " has been complimented! when user is complimented 3 times the SU can increase his reputation");
            alertDialog.showAndWait();
        }
    }


    public AnchorPane getHomeContent(){
        return homeAnchorPane;
        //homeAnchorPane.toFront();
    }

    public void populateProfileListsView(){

        if(systemModel.getLoggedUser().getStatus().equals("SU")){
            buttonCollaborationRequest.setVisible(false);
            buttonCompliment.setVisible(false);
        } else {
            buttonBlackList.setVisible(false);
        }

        listViewProfiles.getItems().clear();
        systemModel.addProfilesToList();
        listViewProfiles.getItems().addAll(systemModel.getProfiles());
    }

}