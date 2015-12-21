package chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by jeggy on 11/13/15.
 */
public class Main extends Application {

    /**
     * MSG: Message
     * USJ: User Joined
     * USQ: User Exited
     * USL: all User List
     * SCL: Server got closed
     * USC: User Set Command
     * UUC: User Update Command
     * WSU: Whisper to User
     */

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("fxml/Main.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("chat/fxml/css/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
