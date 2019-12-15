package libraryFXclient;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import libraryFXclient.to.Reader;
import libraryFXclient.to.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import libraryFXclient.LoginWindowController;

import static libraryFXclient.SignUpWindowController.newReader;
import static libraryFXclient.LoginWindowController.currentReader;
import static libraryFXclient.SignUpWindowController.newReaderName;
import static libraryFXclient.LoginWindowController.currentReaderName;


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
    private Label currentReaderLabel;
    @FXML
    private TreeTableColumn bookNameColumn;
    @FXML
    private TreeTableColumn authorNameColumn;
    @FXML
    private TreeTableColumn availabilityColumn;


    public void initialize() {

        currentReaderLabel.setText(currentReaderName);
        if (currentReaderLabel.getText() == null) {
            currentReaderLabel.setText(newReaderName);
        }
    }
}
