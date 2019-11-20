package libraryFXclient;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.lang.reflect.Field;
import java.text.Format;

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
            if (orderSearchField == null){
                System.out.println("Field is empty!");
            } else {

            }
        });
        allReadersButton.setOnAction(event -> {
            //overdueField.setTextFill('#1eb53c');
        });
        overdueOnlyButton.setOnAction(event -> {});
        orderRefreshingButton.setOnAction(event -> {});
    }

}
