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
    @FXML private JFXButton buttonRejectInvitation;


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
                systemModel.saveGroupDBToFile();


                // get project fields
                String projectName = result.get().replaceAll(".*,","");
                String projectGroup = groupId;
                int projectScore = 0;

                // create Project
                systemModel.addProjectToDB(projectName, projectGroup, projectScore);
                systemModel.saveProjectDBToFile();

                // update model
                systemModel.removeMessage(invitation.getReceiverUsername(),invitation.getNote());
                // backup database
                systemModel.saveMessageDBToFile();
                // refresh view list
                populateMessagesListView();

            }
        } else if (event.getSource() == buttonRejectInvitation) {
            // get selected invitation
            Message invitation = (Message) listViewMessages.getSelectionModel().getSelectedItem();
            // update database
            systemModel.removeMessage(invitation.getReceiverUsername(),invitation.getNote());
            //systemModel.getMessagesDB().remove(invitation);
            // backup database
            systemModel.saveMessageDBToFile();
            // refresh view list
            populateMessagesListView();


        } else if (event.getSource() == buttonApproveApp) {
            // get selected Application
            Application application = (Application) listViewMessages.getSelectionModel().getSelectedItem();

            // potential new USER fields
            String DOB = application.getApplicantDOB();
            String dateJoined = "May 13 2020";
            int userID = (int) (Math.random() * 81 + 20);
            String password = application.getApplicantPassword();
            String email = application.getApplicantEmail();
            String username = application.getApplicantUsername();
            String lname = username + "LastName";
            String fname = username + "FirstName";
            int repScore;
            String status = "OU";

            // decide initial score based on referrer
            if (application.getApplicantReferrerStatus().equals("OU")) {
                repScore = 10;
            } else if (application.getApplicantReferrerStatus().equals("VIP")) {
                repScore = 20;
            } else {
                repScore = 30;
            }

            // store new user into userDB
            systemModel.addUser(DOB,dateJoined,userID,password,email,username,lname,fname,repScore,status);
            // backup database
            systemModel.saveUserDBToFile();

            Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
            alertDialog.setTitle("System Alert");
            alertDialog.setHeaderText("Application has been accepted!");
            alertDialog.setContentText("Click Ok to continue");
            alertDialog.showAndWait();

            // remove application
            systemModel.removeApplication(application.getApplicantEmail(),application.getApplicantDOB());
            //systemModel.getApplicationDB().remove(application);



            // backup
            systemModel.saveApplicationDBToFile();

            // refresh list
            populateApplicationListsView();
            populateMessagesSUListView();

        } else if (event.getSource() == buttonRejectApp) {

            // get application
            Application application = (Application) listViewMessages.getSelectionModel().getSelectedItem();
            // remove app and ADD TO BLACKLIST
            // remove application
            systemModel.removeApplication(application.getApplicantEmail(),application.getApplicantDOB());

            Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
            alertDialog.setTitle("System Alert");
            alertDialog.setHeaderText("Application will be added to blackList");
            alertDialog.setContentText("Click Ok to continue");
            alertDialog.showAndWait();

            // refresh list
            populateApplicationListsView();
            populateMessagesSUListView();
        }
    }

    //messagesAnchorPaneController.populateMessagesSUListView(); used by SU
    //messagesAnchorPaneController.populateApplicationListsView(); used by SU


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

    // populate MessagesListView from visitor complains
    public void populateMessagesSUListView() {

        // disable acceptApp and rejectApp buttons for OU and VIP users
        //buttonRejectApp.setVisible(true);
        //buttonApproveApp.setVisible(true);

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

    // populate incoming applications
    public void populateApplicationListsView() {
        // disable invitation buttons for SU
        buttonAcceptInvitation.setVisible(false);
        buttonRejectInvitation.setVisible(false);

        // check that there are applications
        if(systemModel.getApplicationList()!=null) {
            // display all applications
            listViewMessages.getItems().clear();
            listViewMessages.getItems().addAll(systemModel.getApplicationList());
        } else {
            // ALERT
            alertDialog.setTitle("System Alert");
            alertDialog.setHeaderText("Empty Applications");
            alertDialog.setContentText("you don't have any new applications for now.");
            alertDialog.showAndWait();
        }
    }

} // end MessagesAnchorPaneController
