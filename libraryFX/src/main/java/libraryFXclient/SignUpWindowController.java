package libraryFXclient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import repository.ReaderRepository;


public class SignUpWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpFirstName;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpPhone;

    @FXML
    private TextField signUpAddress;

    @FXML
    private TextField signUpLogin;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private Button signUpButton;


    @FXML
    void initialize() {
        ReaderRepository readerRepository = new ReaderRepository();

        signUpButton.setOnAction(event -> {
            readerRepository.signUpReader(signUpFirstName.getText(), signUpLastName.getText(),
                    signUpPhone.getText(), signUpAddress.getText(),
                    signUpLogin.getText(), signUpPassword.getText());
        });

    }


}
