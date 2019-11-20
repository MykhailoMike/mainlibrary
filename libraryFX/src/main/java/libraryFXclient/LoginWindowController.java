package libraryFXclient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import libraryFXclient.ErrorWindowController;

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
    void initialize() {

        loginSignUpButton.setOnAction(event -> {
            loginSignUpButton.getScene().getWindow().hide();
            toLoad("../signUpWindow.fxml");
        });

        loginSignInButton.setOnAction(event -> {
            String loginField = login_field.getText().trim();
            String passwordField = password_field.getText().trim();
            if (loginField.equals("") || passwordField.equals("")) {
                errorLoad("Заполните оба поля ввода!");
            } else {
                loginSignUpButton.getScene().getWindow().hide();
                boolean checkForAdmin = loginUser(loginField, passwordField);
                if (checkForAdmin == true) {
                    toLoad("../librarianWindow.fxml");
                } else if (checkForAdmin == false) {
                    toLoad("../readerWindow.fxml");
                } else {
                    errorLoad("Логин или пароль введены не правильно!");
                }
            }
        });
    }

    private boolean loginUser(String loginField, String passwordField) {
        return loginField.equals("Admin");
    }

    private void toLoad(String url) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(url));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
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
