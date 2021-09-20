package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class MainController {

    @FXML
    private Button startButton, tutorialButton, openFileButton;

    @FXML
    void start(ActionEvent event) throws Exception {
        Stage stage = (Stage)startButton.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/rpg.fxml"));
        stage2.setTitle("Random Password Generator");
        stage2.setScene(new Scene(root, 600, 400));
        stage2.setResizable(false);
        stage2.show();
    }

    @FXML
    void tutorial(ActionEvent event) throws Exception{
        Stage stage = (Stage)tutorialButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/tutorial.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Password Generator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void openFiles(ActionEvent actionEvent) {
        File folder = new File("Passwords/");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}
