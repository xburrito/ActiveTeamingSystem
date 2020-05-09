package Controller;

public class RegisterAnchorPaneController {
    private MainAnchorPaneController mainAnchorPaneController;

    // gets mainController
    public void injectMainController(MainAnchorPaneController mainAnchorPaneController) {
        this.mainAnchorPaneController = mainAnchorPaneController;
    }

}