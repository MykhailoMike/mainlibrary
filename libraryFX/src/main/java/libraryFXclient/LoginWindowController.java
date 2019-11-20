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
import repository.DBConfigs;

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
                FXMLLoader errorLoader = new FXMLLoader(getClass().getResource("../errorWindow.fxml"));
                try {
                    Parent errorRoot = (Parent) errorLoader.load();
                    ErrorWindowController controller = errorLoader.<ErrorWindowController>getController();
                    controller.setErrorLabel("Заполните оба поля ввода!");
                    Stage stage = new Stage();
                    stage.setScene(new Scene(errorRoot));
                    stage.showAndWait();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                loginSignUpButton.getScene().getWindow().hide();
                //loginUser(loginField, passwordField);
                if (loginField.equals("Admin")) {
                    toLoad("../librarianWindow.fxml");
                } else {
                    toLoad("../readerWindow.fxml");
                }
            }
        });
    }

    //    private boolean loginUser(String loginField, String passwordField) {
//        return false;
//    }
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
}
