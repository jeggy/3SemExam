package chat.server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import chat.controller.ServerController;

/**
 * Created by jeggy on 11/13/15.
 */
public class MainServer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/Server.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("chat/fxml/css/style.css");
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(e -> {
            if(ServerController.server != null) ServerController.server.stopServer();
        });

        primaryStage.show();
    }

    public static void setTitle(String title){
        stage.setTitle(title);
    }
}
