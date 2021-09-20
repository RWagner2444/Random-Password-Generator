package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class rpgController {

    public static String password = "";

    @FXML
    private TextField length;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button backButton, savePasswordButton;

    @FXML
    private RadioButton upperCaseButton, specialCharButton;

    private File file;

    private boolean upper = false, special = false;

    @FXML
    public void generate(ActionEvent actionEvent) {
        int value = 0;
        try {
            value = Integer.parseInt(length.getText());

        } catch (Exception e) {
            passwordLabel.setText("Enter a number value for length of password");
        }
        passwordLabel.setText(generatePassword(value));
    }

    @FXML
    public void back(javafx.event.ActionEvent actionEvent) throws Exception{
        Stage stage = (Stage)backButton.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/Main.fxml"));
        stage2.setTitle("Random Password Generator");
        stage2.setScene(new Scene(root, 600, 400));
        stage2.setResizable(false);
        stage2.show();
    }

    @FXML
    public void upperButtonClick(ActionEvent actionEvent) {
        if(upper){
            upper = false;
        }
        else upper = true;
    }

    @FXML
    public void specialButtonClick(ActionEvent actionEvent) {
        if(special){
            special = false;
        }
        else special = true;
    }

    public String generatePassword(int length){
        Random rand = new Random();
        String password = "";
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] capAlpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] specialC = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "-", "+", "="};
        for(int i = 0; i < length; i++){
            int c = rand.nextInt(3);
            if(c == 0) {
                int index = rand.nextInt(26);
                password += alphabet[index];
            }
            if(c == 1 && upper){
                int index = rand.nextInt(26);
                password += capAlpha[index];
            }
            if(c == 1 && !upper){
                int index = rand.nextInt(26);
                password += alphabet[index];
            }
            if(c == 2 && special){
                int index = rand.nextInt(14);
                password += specialC[index];
            }
            if(c == 2 && !special){
                int index = rand.nextInt(26);
                password += alphabet[index];
            }
        }
        return password;
    }

    @FXML
    public void savePassword(ActionEvent actionEvent) throws Exception{
        password = passwordLabel.getText();
        Stage stage = (Stage)savePasswordButton.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/savePassword.fxml"));
        stage2.setTitle("Save Password");
        stage2.setScene(new Scene(root, 300, 250));
        stage2.setResizable(false);
        stage2.show();
    }
}
