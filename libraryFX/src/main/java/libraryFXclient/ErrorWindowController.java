package libraryFXclient;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;

public class ErrorWindowController {

    public void setErrorLabel(String errorMessage) {
        this.errorLabel.setText(errorMessage);
        this.errorLabel.setAlignment(Pos.CENTER);
        this.errorLabel.setTextAlignment(TextAlignment.CENTER);
    }

    @FXML
    private Label errorLabel;

    @FXML
    void initialize() {
    }

}

