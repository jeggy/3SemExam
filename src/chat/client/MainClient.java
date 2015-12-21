package chat.client;

import chat.controller.ClientController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Created by jeggy on 11/13/15.
 */
public class MainClient extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/Client.fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add("chat/fxml/css/style.css");


        primaryStage.setOnCloseRequest(e -> ((ClientController)loader.getController()).closeProgram(primaryStage));


        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
