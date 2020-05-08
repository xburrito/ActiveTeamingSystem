package Home;

public class Controller {

    @FXML
    private void open_registration (MouseEvent event){
        Parent fxml = FXMLLoader.load(getClass().getResource("Register.fxml"));
        content_area.getChildren().removeAll();
        content_area.getChildren().setAll(fxml);
    }


}
