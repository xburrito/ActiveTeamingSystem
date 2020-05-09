package Controller;

public class LoginController {
    private MainController mainController;

    // gets mainController
    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
