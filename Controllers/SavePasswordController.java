package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SavePasswordController {

    @FXML
    private Button saveButton, backButton;

    @FXML
    private TextField fileNameTF, websiteTF, userNameTF;

    private String password = rpgController.password;

    @FXML
    public void savePass(ActionEvent actionEvent) throws IOException {
        //method for saveButton
        // saves password and creates new file with user info
        String fileName = "", website = "", username = "";
        if(fileNameTF.getText().equals("")){
            System.out.println("Enter a file name");
            return;
        }
        else{
            fileName = fileNameTF.getText() + ".txt";
        }

        if(websiteTF.getText().equals("")){
            website = "None";
        }
        else{
            website = websiteTF.getText();
        }

        if(userNameTF.getText().equals("")){
            username = "None";
        }
        else{
            username = userNameTF.getText();
        }

        File file = new File(fileName);

        if(!file.exists()){
            file.createNewFile();
        }

        PrintWriter printer = new PrintWriter(file);
        printer.println("Website - " + website + "\n\nUsername - " + username + "\n\nPassword - " + password);
        printer.close();
        System.out.println("Done");
    }

    @FXML
    public void back(ActionEvent actionEvent) throws Exception{
        //method for back button
        //launches main.fxml and closes current scene
        Stage stage = (Stage)backButton.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Scenes/Main.fxml"));
        stage2.setTitle("Random Password Generator");
        stage2.setScene(new Scene(root, 600, 325));
        stage2.setResizable(false);
        stage2.show();
    }
}
