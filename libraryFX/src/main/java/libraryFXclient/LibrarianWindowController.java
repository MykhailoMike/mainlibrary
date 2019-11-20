package libraryFXclient;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

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
    void initialize() {
        orderSearchButton.setOnAction(event -> {
            if (orderSearchField.getText().trim().equals("")) {
                System.out.println("True");
                errorLoad("Поле поиска пустое!");
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
    }

    private void errorLoad(String errorMessage) {
        FXMLLoader errorLoader = new FXMLLoader(getClass().getResource("../errorWindow.fxml"));
        try {
            Parent errorRoot = (Parent) errorLoader.load();
            ErrorWindowController controller = errorLoader.<ErrorWindowController>getController();
            controller.setErrorLabel(errorMessage);
            Stage stage = new Stage();
            stage.setScene(new Scene(errorRoot));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
