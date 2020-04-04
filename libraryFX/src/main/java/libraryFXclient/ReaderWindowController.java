package libraryFXclient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private TreeTableView booksTable;
    @FXML
    private TreeTableView myBooksTable;
    @FXML
    private TreeTableColumn bookNameColumn;
    @FXML
    private TreeTableColumn authorNameColumn;
    @FXML
    private TreeTableColumn availabilityColumn;
    @FXML
    private TreeTableColumn checkBookColumn;
    @FXML
    private TreeTableColumn checkMyBookColumn;
    @FXML
    private TextField booksList;


    public void initialize() {

        currentReaderLabel.setText(currentReaderName);
        if (currentReaderLabel.getText() == null) {
            currentReaderLabel.setText(newReaderName);
        }

        List<Book> books = getBooksToFX();
        booksList.setText(books.toString());

    }

    private static List<Book> getBooksToFX() {
        final String url = "http://localhost:8081/books";

        RestTemplate operations = new RestTemplate();

        ResponseEntity<Book[]> books = operations.getForEntity(url, Book[].class);

        System.out.println("success");

        return Arrays.asList(books.getBody());

    }
}
