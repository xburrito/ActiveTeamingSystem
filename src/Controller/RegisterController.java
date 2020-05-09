package Controller;

public class RegisterController {
    private MainController mainController;

    // gets mainController
    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

}