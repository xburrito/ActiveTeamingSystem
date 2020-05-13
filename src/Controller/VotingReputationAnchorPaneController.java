package Controller;

import Model.ActiveTeamingSystem;

public class VotingReputationAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;

    // gets mainController and mainModel
    void injectMainControllerAndMainModel(MainAnchorPaneController mainAnchorPaneController, ActiveTeamingSystem mainModel) {
        this.mainAnchorPaneController = mainAnchorPaneController;
        this.systemModel = mainModel;

        // for debugging check that the main controller and model was injected successfully!
        System.out.println("Voting Controller contains Main Controller? " + (this.mainAnchorPaneController!=null));
        System.out.println("Voting Controller contains Main Model? " + (this.systemModel!=null));


        // also, initialize required fields
    }

}
