package Controller;

import Model.ActiveTeamingSystem;

public class MessagesAnchorPaneController {
    // main Controller
    private MainAnchorPaneController mainAnchorPaneController;
    // ActiveTeamingSystem Model
    private ActiveTeamingSystem systemModel;

    // gets mainController
    void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }
    // gets mainModel
    void injectMainModel(ActiveTeamingSystem systemModel) {
        this.systemModel = systemModel;
    }
}
