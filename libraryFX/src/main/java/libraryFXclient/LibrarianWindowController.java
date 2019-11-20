package libraryFXclient;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LibrarianWindowController {

    @FXML
    private Button orderSearchButton;

    @FXML
    private Button allReadersButton;

    @FXML
    private Button overdueOnlyButton;

    @FXML
    private Button orderRefreshingButton;

    @FXML
    private TextField orderSearchField;

    @FXML
    private Label overdueField;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        commonControllers controller = new commonControllers();
        orderSearchButton.setOnAction(event -> {
            if (orderSearchField.getText().trim().equals("")) {
                System.out.println("True");
                controller.errorLoad("Поле поиска пустое!");
            } else {
                System.out.println("False");
            }
        });
        allReadersButton.setOnAction(event -> {
            overdueField.setText("Читатели");
            overdueField.setTextFill(Color.web("#1eb53c"));
        });
        overdueOnlyButton.setOnAction(event -> {
            overdueField.setText("Должники");
            overdueField.setTextFill(Color.web("#b51515"));
        });
        orderRefreshingButton.setOnAction(event -> {
        });
        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            controller.toLoad("../loginWindow.fxml");
        });
    }
}
