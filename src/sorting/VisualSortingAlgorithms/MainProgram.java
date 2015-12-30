package sorting.VisualSortingAlgorithms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by jeggy on 10/12/15.5:53 PM
 */
public class MainProgram extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     *
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene s = new Scene(FXMLLoader.load(getClass().getResource("Window.fxml")));

        primaryStage.setScene(s);

        primaryStage.show();
    }
}
