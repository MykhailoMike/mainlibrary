package libraryFXclient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

        commonControllers controller = new commonControllers();

        loginSignUpButton.setOnAction(event -> {
            loginSignUpButton.getScene().getWindow().hide();
            controller.toLoad("../signUpWindow.fxml");
        });

        loginSignInButton.setOnAction(event -> {
            String loginField = login_field.getText().trim();
            String passwordField = password_field.getText().trim();
            if (loginField.equals("") || passwordField.equals("")) {
                controller.errorLoad("Заполните оба поля ввода!");
            } else {
                loginSignUpButton.getScene().getWindow().hide();
                boolean checkForAdmin = loginUser(loginField, passwordField);
                if (checkForAdmin == true) {
                    controller.toLoad("../librarianWindow.fxml");
                } else if (checkForAdmin == false) {
                    controller.toLoad("../readerWindow.fxml");
                } else {
                    controller.errorLoad("Логин или пароль введены не правильно!");
                }
            }
        });
    }

    private boolean loginUser(String loginField, String passwordField) {
        return loginField.equals("Admin");
    }


}
