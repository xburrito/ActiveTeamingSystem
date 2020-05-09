package Controller;

public class BrowseController {
    private MainController mainController;

    // gets mainController
    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
