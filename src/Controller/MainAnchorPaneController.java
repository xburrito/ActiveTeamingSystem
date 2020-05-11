package Controller;

import Model.ActiveTeamingSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.util.Optional;


// This is the main controller for the GUI, its connected to all other controllers
public class MainAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;

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
    @FXML private Label labelUsername;
    @FXML private Label labelReputationScore;
    @FXML private Label labelStatus;

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

    Alert alertDialog = new Alert(Alert.AlertType.CONFIRMATION);

    @FXML private HomeAnchorPaneController homeAnchorPaneController;
    @FXML private BrowseAnchorPaneController browseAnchorPaneController;
    @FXML private GroupsAnchorPaneController groupsAnchorPaneController;
    @FXML private LoginAnchorPaneController loginAnchorPaneController;
    @FXML private MessagesAnchorPaneController messagesAnchorPaneController;
    @FXML private ProjectsAnchorPaneController projectsAnchorPaneController;
    @FXML private RegisterAnchorPaneController registerAnchorPaneController;
    @FXML private SettingsAnchorPaneController settingsAnchorPaneController;
    @FXML private VotingReputationAnchorPaneController votingReputationAnchorPaneController;

    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;


    public MainAnchorPaneController() {
        // create and initialize the System Model
        systemModel = new ActiveTeamingSystem();

    }


    @FXML private void initialize() throws Exception {
        // create and initialize the System Model
       //systemModel = new ActiveTeamingSystem();

        // CONNECT this MainController to all other controllers
        // send mainController to homeController
        homeAnchorPaneController.injectMainController(this);
        browseAnchorPaneController.injectMainController(this);
        loginAnchorPaneController.injectMainController(this);
        groupsAnchorPaneController.injectMainController(this);
        messagesAnchorPaneController.injectMainController(this);
        projectsAnchorPaneController.injectMainController(this);
        registerAnchorPaneController.injectMainController(this);
        settingsAnchorPaneController.injectMainController(this);
        votingReputationAnchorPaneController.injectMainController(this);

        // CONNECT this systemModel to all other controllers
        homeAnchorPaneController.injectMainModel(systemModel);
        browseAnchorPaneController.injectMainModel(systemModel);
        groupsAnchorPaneController.injectMainModel(systemModel);
        loginAnchorPaneController.injectMainModel(systemModel);
        messagesAnchorPaneController.injectMainModel(systemModel);
        projectsAnchorPaneController.injectMainModel(systemModel);
        registerAnchorPaneController.injectMainModel(systemModel);
        settingsAnchorPaneController.injectMainModel(systemModel);
        votingReputationAnchorPaneController.injectMainModel(systemModel);


        // get user records from external file
        systemModel.readFileToUser("src/Database/User_database.csv");

        systemModel.addTopProfilesToList();
        //listViewTopProfiles.getItems().addAll(systemModel.getTopProfilesList());

        // get group records from external file
        //systemModel.readFileToGroup("PATH");


    }

    String buttonDefaultColor = "-fx-background-color:#00C5FF;";

    // Handle All Button Actions
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == buttonHomePage) {
            buttonHomePage.setStyle("-fx-background-color:#00909e;");
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
            buttonMessages.setStyle("-fx-background-color:#00909e;");
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
            buttonGroups.setStyle("-fx-background-color:#00909e;");
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
            buttonProjects.setStyle("-fx-background-color:#00909e;");
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
            buttonVotingReputation.setStyle("-fx-background-color:#00909e;");
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
            buttonSettings.setStyle("-fx-background-color:#00909e;");
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
            buttonLogOut.setStyle("-fx-background-color:#00909e;");

            alertDialog.setTitle("System Alert");
            alertDialog.setHeaderText("Logout");
            alertDialog.setContentText("Are you sure you want to logout? you will be redirected to the browse page.");

            Optional<ButtonType> result = alertDialog.showAndWait();
            if (result.get() == ButtonType.OK){
                // sign out user from the system
                systemModel.setLoggedUser(null);

                // Redirect to Browse View
                displayBrowseView();
            } else {
                // ... user chose CANCEL or closed the dialog
            }

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

    public Label getLabeUsername(){
        return labelUsername;
    }

    public void setLabeUsername(String username){
        labelUsername.setText(username);
    }

    public void setLabelReputationScore(String score){
        labelReputationScore.setText(score);
    }

    public void setLabelStatus(String status){
        labelStatus.setText(status);
    }

}