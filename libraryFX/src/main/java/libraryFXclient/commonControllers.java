package libraryFXclient;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class commonControllers {

    public void errorLoad(String errorMessage) {
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

    public void toLoad(String url) {
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
