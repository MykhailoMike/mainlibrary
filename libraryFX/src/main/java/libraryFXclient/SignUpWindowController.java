package libraryFXclient;

import java.awt.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static libraryFXclient.LoginWindowController.currentReader;


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

    public static SignUpWindowController newReader = new SignUpWindowController();

    public static String newReaderName;

    @FXML
    public void initialize() {

        signUpButton.setOnAction(event -> {

            System.out.println(signUpFirstName.getText());
            System.out.println(signUpLastName.getText());
            System.out.println(signUpPhone.getText());
            System.out.println(signUpAddress.getText());
            System.out.println(signUpLogin.getText());
            System.out.println(signUpPassword.getText());

        signUpButton.getScene().getWindow().hide();

        final String addReaderUrl = "http://localhost:8081/reader/add";

        RestTemplate newReaderTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> newReaderParamsMap = new HashMap<>();
        newReaderParamsMap.put("firstName", signUpFirstName.getText());
        newReaderParamsMap.put("lastName", signUpLastName.getText());
        newReaderParamsMap.put("tel", signUpPhone.getText());
        newReaderParamsMap.put("address", signUpAddress.getText());
        newReaderParamsMap.put("login", signUpLogin.getText());
        newReaderParamsMap.put("password", signUpPassword.getText());

        HttpEntity<Map<String, Object>> newReaderEntity =
                new HttpEntity<Map<String, Object>>(newReaderParamsMap, headers);

        String result = newReaderTemplate.postForObject(addReaderUrl, newReaderEntity, String.class);

        System.out.println("OK");

        newReaderName = signUpFirstName.getText() + " " + signUpLastName.getText();
        currentReader.openReadersWindow();

    });
    }

}
