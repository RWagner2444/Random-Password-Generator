import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        //starts off in Main.fxml scene
        //launches first stage
        Parent root = FXMLLoader.load(getClass().getResource("Scenes/Main.fxml"));
        stage.setTitle("Password Generator");
        stage.setScene(new Scene(root, 600, 325));
        stage.setResizable(false);
        stage.show();
    }

    //Main method to launch program
    public static void main(String[] args) {
        launch(args);
    }


}
