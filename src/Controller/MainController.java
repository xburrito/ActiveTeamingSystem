package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MainController {
    //private ModelClass theModel;

    // main pane
    @FXML private AnchorPane mainAnchorPane;

    // sidebar
    @FXML private AnchorPane sidebarAnchorPane;
    @FXML private Button buttonHomePage, buttonMessages, buttonGroups, buttonProjects,
            buttonVotingReputation, buttonSettings, buttonLogOut;

    // content
    @FXML private AnchorPane ContentAnchorPane;
    @FXML private StackPane mainContentStackPanePane;
    @FXML private AnchorPane homeAnchorPane;
    @FXML private AnchorPane messagesAnchorPane;
    @FXML private AnchorPane groupsAnchorPane;
    @FXML private AnchorPane projectsAnchorPane;
    @FXML private AnchorPane votingReputationAnchorPane;
    @FXML private AnchorPane settingsAnchorPane;
    //@FXML private AnchorPane logOutAnchorPane;  // create later

    private HomeController homeController;

    private void initialize() {
        // send mainController to homeController
        homeController.injectMainController(this);
    }

    String buttonDefaultColor = "-fx-background-color:#00C5FF;";

    // Handle All Button Actions
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == buttonHomePage) {
            buttonHomePage.setStyle("-fx-background-color:#696969;");
            buttonMessages.setStyle(buttonDefaultColor);
            buttonGroups.setStyle(buttonDefaultColor);
            buttonProjects.setStyle(buttonDefaultColor);
            buttonVotingReputation.setStyle(buttonDefaultColor);
            buttonSettings.setStyle(buttonDefaultColor);
            buttonLogOut.setStyle(buttonDefaultColor);

            homeAnchorPane.toFront();
            //mainContentStackPanePane.requestLayout();
            //homeAnchorPane.setVisible(true);
            //homeController.getHomeContent();
            //borderPanePortfolio.setVisible(true);
            //borderPanePortfolio.toFront();
            //borderPaneTransactions.setVisible(false);
        }
        else if (event.getSource() == buttonMessages) {
            buttonHomePage.setStyle(buttonDefaultColor);
            buttonMessages.setStyle("-fx-background-color:#696969;");
            buttonGroups.setStyle(buttonDefaultColor);
            buttonProjects.setStyle(buttonDefaultColor);
            buttonVotingReputation.setStyle(buttonDefaultColor);
            buttonSettings.setStyle(buttonDefaultColor);
            buttonLogOut.setStyle(buttonDefaultColor);

            messagesAnchorPane.toFront();
            //borderPaneTransactions.toFront();
            //borderPaneTransactions.setVisible(true);
            //borderPanePortfolio.setVisible(false);
        }
        else if (event.getSource() == buttonGroups) {
            buttonHomePage.setStyle(buttonDefaultColor);
            buttonMessages.setStyle(buttonDefaultColor);
            buttonGroups.setStyle("-fx-background-color:#696969;");
            buttonProjects.setStyle(buttonDefaultColor);
            buttonVotingReputation.setStyle(buttonDefaultColor);
            buttonSettings.setStyle(buttonDefaultColor);
            buttonLogOut.setStyle(buttonDefaultColor);

            groupsAnchorPane.toFront();
        }
        else if (event.getSource() == buttonProjects) {
            buttonHomePage.setStyle(buttonDefaultColor);
            buttonMessages.setStyle(buttonDefaultColor);
            buttonGroups.setStyle(buttonDefaultColor);
            buttonProjects.setStyle("-fx-background-color:#696969;");
            buttonVotingReputation.setStyle(buttonDefaultColor);
            buttonSettings.setStyle(buttonDefaultColor);
            buttonLogOut.setStyle(buttonDefaultColor);

            projectsAnchorPane.toFront();
        }
        else if (event.getSource() == buttonVotingReputation) {
            buttonHomePage.setStyle(buttonDefaultColor);
            buttonMessages.setStyle(buttonDefaultColor);
            buttonGroups.setStyle(buttonDefaultColor);
            buttonProjects.setStyle(buttonDefaultColor);
            buttonVotingReputation.setStyle("-fx-background-color:#696969;");
            buttonSettings.setStyle(buttonDefaultColor);
            buttonLogOut.setStyle(buttonDefaultColor);

            votingReputationAnchorPane.toFront();
        }
        else if (event.getSource() == buttonSettings) {
            buttonHomePage.setStyle(buttonDefaultColor);
            buttonMessages.setStyle(buttonDefaultColor);
            buttonGroups.setStyle(buttonDefaultColor);
            buttonProjects.setStyle(buttonDefaultColor);
            buttonVotingReputation.setStyle(buttonDefaultColor);
            buttonSettings.setStyle("-fx-background-color:#696969;");
            buttonLogOut.setStyle(buttonDefaultColor);

            settingsAnchorPane.toFront();
        }
        else if (event.getSource() == buttonLogOut) {
            buttonHomePage.setStyle(buttonDefaultColor);
            buttonMessages.setStyle(buttonDefaultColor);
            buttonGroups.setStyle(buttonDefaultColor);
            buttonProjects.setStyle(buttonDefaultColor);
            buttonVotingReputation.setStyle(buttonDefaultColor);
            buttonSettings.setStyle(buttonDefaultColor);
            buttonLogOut.setStyle("-fx-background-color:#696969;");

            //logOutAnchorPane.toFront();
        }

    } // end handle button


}
