package libraryFXclient;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import libraryFXclient.to.Reader;

import java.util.List;

import static libraryFXclient.LoginWindowController.currentLibrarianName;
import static libraryFXclient.LoginWindowController.getReadersToFX;

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
    private Label currentLibrarianLabel;

    @FXML
    void initialize() {
        currentLibrarianLabel.setText(currentLibrarianName);
        List<Reader> readers = getReadersToFX();
    }
}

