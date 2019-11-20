package libraryFXclient;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ReaderWindowController {

    @FXML
    private Button bookSearchButton;

    @FXML
    private Button orderReadingRoomButton;

    @FXML
    private Button orderHomeButton;

    @FXML
    private Button returnBooksButton;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        commonControllers controller = new commonControllers();
        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            controller.toLoad("../loginWindow.fxml");
        });
    }

}
