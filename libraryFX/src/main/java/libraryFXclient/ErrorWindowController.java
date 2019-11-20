package libraryFXclient;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

public class ErrorWindowController {

    public void setErrorLabel(String message) {
        this.errorLabel.setText(message);
        this.errorLabel.setAlignment(Pos.CENTER);
        this.errorLabel.setTextAlignment(TextAlignment.CENTER);
        GridPane.setHalignment(errorLabel, HPos.CENTER);
    }

    @FXML
    private Label errorLabel;

    @FXML
    void initialize() {
        GridPane.setHalignment(errorLabel, HPos.CENTER);
    }
}

