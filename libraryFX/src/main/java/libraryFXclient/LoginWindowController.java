package libraryFXclient;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import libraryFXclient.to.Librarian;
import libraryFXclient.to.Reader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class LoginWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button loginSignInButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private Button testButton;

    public static LoginWindowController currentReader = new LoginWindowController();
    public static LoginWindowController currentLibrarian = new LoginWindowController();

    public static String currentReaderName;
    public static String currentLibrarianName;


    @FXML
    void initialize() {

        loginSignUpButton.setOnAction(event -> {

            loginSignUpButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../signUpWindow.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        loginSignInButton.setOnAction(event -> {

            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();


            List<Reader> readers = getReadersToFX();
            List<Librarian> librarians = getLibrariansToFX();

            for (Reader reader : readers) {
                if (loginText.equals(reader.getLogin()) &&
                loginPassword.equals(reader.getPassword())) {
                    currentReaderName = reader.getFirstName() + " " + reader.getLastName();
                    System.out.println(currentReaderName);
                    loginSignUpButton.getScene().getWindow().hide();
                    openReadersWindow();
                    return;
                }
            }

            for (Librarian librarian : librarians) {
                if (loginText.equals(librarian.getLogin()) &&
                        loginPassword.equals(librarian.getPassword())) {
                    currentLibrarianName = librarian.getFirstName() + " " + librarian.getLastName();
                    System.out.println(currentLibrarianName);
                    loginSignUpButton.getScene().getWindow().hide();
                    openLibrariansWindow();
                    return;
                }
            }
            openLoginErrorWindow();
            return;
        });
//            else System.out.println("Пожалуйста, ввведите логин и пароль");
//
//        });
//    }
//
//    private void loginUser(String loginText, String loginPassword) {
//    }

    }

    public static List<Reader> getReadersToFX() {
        final String url = "http://localhost:8081/readers";

        RestTemplate operations = new RestTemplate();

        ResponseEntity<Reader[]> readers = operations.getForEntity(url, Reader[].class);

        System.out.println("success");

        return Arrays.asList(readers.getBody());

    }

    public static List<Librarian> getLibrariansToFX() {
        final String url = "http://localhost:8081/librarians";

        RestTemplate operations = new RestTemplate();

        ResponseEntity<Librarian[]> librarians = operations.getForEntity(url, Librarian[].class);

        System.out.println("success");

        return Arrays.asList(librarians.getBody());

    }

    public void openReadersWindow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../readerWindow.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

    public void openLibrariansWindow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../librarianWindow.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    private void openLoginErrorWindow() {
        loginSignUpButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../loginErrorWindow.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }
}
