package libraryFXclient;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.lang.reflect.Field;

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
    private Field orderSearchField;

    @FXML
    void initialize() {
        orderSearchButton.setOnAction(event -> {
            if (orderSearchField == null){
                System.out.println("Field is empty!");
            } else {

            }
        });
        allReadersButton.setOnAction(event -> {});
        overdueOnlyButton.setOnAction(event -> {});
        orderRefreshingButton.setOnAction(event -> {});
    }

}
