package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;


// This is the main controller for the GUI, its connected to all other controllers
public class MainAnchorPaneController {
    //private ModelClass theModel;

    //@FXML private AnchorPane browserAnchorPane;
    //@FXML private AnchorPane loginAnchorPane;
    //@FXML private AnchorPane registerAnchorPane;

    // main pane
    @FXML private AnchorPane mainAnchorPane;
    @FXML private AnchorPane browseAnchorPane;
    @FXML private AnchorPane loginAnchorPane;
    @FXML private AnchorPane registerAnchorPane;

    // sidebar
    @FXML private AnchorPane sidebarAnchorPane;
    @FXML private Button buttonHomePage, buttonMessages, buttonGroups, buttonProjects,
            buttonVotingReputation, buttonSettings, buttonLogOut;

    // content
    @FXML private AnchorPane contentAnchorPane;
    @FXML private StackPane mainContentStackPanePane;
    @FXML private AnchorPane homeAnchorPane;
    @FXML private AnchorPane messagesAnchorPane;
    @FXML private AnchorPane groupsAnchorPane;
    @FXML private AnchorPane projectsAnchorPane;
    @FXML private AnchorPane votingReputationAnchorPane;
    @FXML private AnchorPane settingsAnchorPane;
    //@FXML private AnchorPane logOutAnchorPane;  // create later

    @FXML private HomeAnchorPaneController homeAnchorPaneController;
    @FXML private BrowseAnchorPaneController browseAnchorPaneController;
    @FXML private LoginAnchorPaneController loginAnchorPaneController;
    @FXML private RegisterAnchorPaneController registerAnchorPaneController;


    @FXML private void initialize() {
        // CONNECT all other controller to MainController
        System.out.println("sdfa");
        // send mainController to homeController
        //homeController.injectMainController(this);
        // send mainController to browseController
        browseAnchorPaneController.injectMainController(this);
        // send mainController to loginController
        loginAnchorPaneController.injectMainController(this);
        // send mainController to registerController
        registerAnchorPaneController.injectMainController(this);
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

            displayBrowseView();

        }
//        else if (event.getSource() == browseController.getButton()) {
//            browseController.getButton().setStyle("-fx-background-color:#696969;");
//            //buttonRegister.setStyle(buttonDefaultColor);
//
//            loginAnchorPane.toFront();
//            System.out.println("WTF");
//            //mainController.getLoginAnchorPane();
//            //borderPaneTransactions.setVisible(false);
//        }
    } // end handle button

    // brings LoginArchorPane to the front.
    public void getLoginAnchorPane(){
        //loginAnchorPane.toFront();
        //loginController.getLoginAchorPaneX().toFront();
        loginAnchorPane.toFront();
        //browseAnchorPane.setVisible(false);
    }

    @FXML public void getRegisterAnchorPane() {
        //loginAnchorPane.toFront();
    }

    public AnchorPane getMainAnchorPane(){
        return mainAnchorPane;
    }



    // brings "mainAnchorPane" to the front.
    public void displayMainView(){
        contentAnchorPane.toFront();
        sidebarAnchorPane.toFront();
    }

    // brings browseAnchorPane to the front.
    public void displayBrowseView(){
        browseAnchorPane.toFront();
    }

    // brings loginAnchorPane to the front.
    public void displayLoginView(){
        loginAnchorPane.toFront();
    }

    // brings registerAnchorPane to the front.
    public void displayRegisterView(){
        registerAnchorPane.toFront();
    }

}