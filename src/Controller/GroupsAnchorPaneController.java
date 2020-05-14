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

public class GroupsAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;

    //Buttons
    @FXML private JFXButton buttonMeetingSchedule;
    @FXML private JFXButton buttonDelete;

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
        buttonDelete.setVisible(false);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == buttonDelete) {
            // get selected Application
            Group selectedGroup = (Group) listViewGroups.getSelectionModel().getSelectedItem();


            //update remove group
            systemModel.getGroupBD().remove(selectedGroup);
            //backup db
            systemModel.saveGroupDBToFile();

            Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
            alertDialog.setTitle("System Alert");
            alertDialog.setHeaderText("Selected group has been removed");
            alertDialog.setContentText("Click Ok to continue");
            alertDialog.showAndWait();

            // refresh group list
            populateGroupsListsView();

        } else if (event.getSource() == buttonMeetingSchedule) {
            // get selected invitation
            Group selectedGroup = (Group) listViewGroups.getSelectionModel().getSelectedItem();

            if (selectedGroup.findMember(systemModel.getLoggedUser().getUserName())) { // check if he belongs on that group
                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("System Alert");
                String groupMembers = selectedGroup.membersToString().replaceAll(systemModel.getLoggedUser().getUserName()+"-","");
                //System.out.println(groupMembers);
                dialog.setHeaderText("Schedule a meeting?, A poll will be sent to all group members: " + groupMembers);
                dialog.setContentText("Enter Date and Time of meeting, separated by a comma:");

                // Traditional way to get the response value.
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    // get group fields
                    String pollType = "Meeting";
                    String pollDate = result.get().replaceAll(",.*", "");
                    String pollTime = result.get().replaceAll(".*,","");
                    List<User> pollMemebers = systemModel.converToMembersList(groupMembers);


                    // create poll
                    Poll meetingPoll = new Poll(pollType,pollMemebers,pollDate,pollTime);

                    // add poll to  database
                    systemModel.addPollToDB(meetingPoll);
                    // backup poll
                    systemModel.savePollDBToFile();

            } else {
                    Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
                    // ALERT
                    alertDialog.setHeaderText("Your not in that group.");
                    alertDialog.setContentText("Please Select a group where you are a member.");
                    alertDialog.showAndWait();

            }

            }
        }
    }

    public void populateGroupsListsView() {
        if(systemModel.getLoggedUser().getStatus().equals("SU")){
            buttonDelete.setVisible(true);
            buttonMeetingSchedule.setVisible(false);
        }

        listViewGroups.getItems().clear();
        listViewGroups.getItems().addAll(systemModel.getGroupBD());
    }

}