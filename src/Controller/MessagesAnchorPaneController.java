package Controller;

import Model.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class MessagesAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;

    //buttons
    @FXML private JFXButton buttonApproveApp;
    @FXML private JFXButton buttonRejectApp;
    @FXML private JFXButton buttonAcceptInvitation;
    @FXML private JFXButton buttonRejecttInvitation;


    // list views
    @FXML private JFXListView listViewMessages;

    Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);

    // gets mainController and mainModel
    void injectMainControllerAndMainModel(MainAnchorPaneController mainAnchorPaneController, ActiveTeamingSystem mainModel) {
        this.mainAnchorPaneController = mainAnchorPaneController;
        this.systemModel = mainModel;

        // also, initialize required fields

        // for debugging check that the main controller and model was injected successfully!
        System.out.println("Messages Controller contains Main Controller? " + (this.mainAnchorPaneController!=null));
        System.out.println("Messages Controller contains Main Model? " + (this.systemModel!=null));
    }

    // Handle All Button Actions
    @FXML private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == buttonAcceptInvitation) {
            // get selected invitation
            Message invitation = (Message) listViewMessages.getSelectionModel().getSelectedItem();

            TextInputDialog dialog = new TextInputDialog("");
            dialog.setTitle("System Alert");
            dialog.setHeaderText("Accept invitation from, " + invitation.getSenderUsername() + "? this will automatically create a group and project");
            dialog.setContentText("Enter name of group and project, separated by a comma:");

            // Traditional way to get the response value.
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                // get group fields
                String groupName = result.get().replaceAll(",.*","");
                String groupId = String.valueOf(Math.random() * ( 99999 - 10000 ));
                String groupLeader = invitation.getReceiverUsername();

                List<User> groupMembers = new LinkedList<User>();
                groupMembers.add(systemModel.findUser(invitation.getReceiverUsername()));
                groupMembers.add(systemModel.findUser(invitation.getSenderUsername()));
                // create group
                systemModel.addGroupToDB(groupId, groupName,groupLeader,groupMembers);
                // backup messageDB
                systemModel.saveGroupDBToFile("src/Database/Groups.csv");


                // get project fields
                String projectName = result.get().replaceAll(".*,","");
                String projectGroup = groupId;
                int projectScore = 0;

                // create Project
                systemModel.addProjectToDB(projectName, projectGroup, projectScore);
                systemModel.saveProjectDBToFile("src/Database/Project.txt");

                // create project

            }
        } else if (event.getSource() == buttonRejecttInvitation) {

        } else if (event.getSource() == buttonApproveApp) {

        } else if (event.getSource() == buttonRejectApp) {

        }
    }

    public void populateApplicationListsView() {
        // disable invitation buttons for SU
        buttonAcceptInvitation.setVisible(false);
        buttonRejecttInvitation.setVisible(false);

        // check that there are applications
        if(systemModel.getApplicationList()!=null) {
            // display all applications
            listViewMessages.getItems().clear();
            listViewMessages.getItems().addAll(systemModel.getApplicationList());
        } else {
            // ALERT
            alertDialog.setTitle("System Alert");
            alertDialog.setHeaderText("Empty Applications");
            alertDialog.setContentText("you dont have any new applications for now.");
            alertDialog.showAndWait();
        }
    }

    // populate MessagesListView
    public void populateMessagesSUListView() {

        // disable acceptApp and rejectApp buttons for OU and VIP users
        buttonRejectApp.setVisible(false);
        buttonApproveApp.setVisible(false);


        // check that there are messages
        if(systemModel.getMessagesList(systemModel.getLoggedUser().getUserName())!=null) {
            // display all messages
            listViewMessages.getItems().clear();
            listViewMessages.getItems().addAll(systemModel.getMessagesList(systemModel.getLoggedUser().getUserName()));
        } else {
            // ALERT
            alertDialog.setTitle("System Alert");
            alertDialog.setHeaderText("Empty Messages");
            alertDialog.setContentText("you dont have any new Messages for now.");
            alertDialog.showAndWait();
        }
    }


    // populate MessagesListView
    public void populateMessagesListView() {

        // disable acceptApp and rejectApp buttons for OU and VIP users
        buttonRejectApp.setVisible(false);
        buttonApproveApp.setVisible(false);


        // check that there are messages
        if(systemModel.getMessagesList(systemModel.getLoggedUser().getUserName())!=null) {
            // display all messages
            listViewMessages.getItems().clear();
            listViewMessages.getItems().addAll(systemModel.getMessagesList(systemModel.getLoggedUser().getUserName()));
        } else {
            // ALERT
            alertDialog.setTitle("System Alert");
            alertDialog.setHeaderText("Empty Messages");
            alertDialog.setContentText("you dont have any new Messages for now.");
            alertDialog.showAndWait();
        }
    }

} // end MessagesAnchorPaneController
