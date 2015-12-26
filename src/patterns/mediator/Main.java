package patterns.mediator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Jógvan 26/12-2015 02:14.
 */
public class Main extends Application{

    final ObservableList<Label> list =
        FXCollections.observableArrayList(
                new JObject1("Some text"),
                new JObject2("Text"),
                new JObject1("Other")
        );

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();


        VBox vb = new VBox();

        for (Label label : list) {
            vb.getChildren().add(label);
        }

        ComboBox<Label> cb = new ComboBox<>(list);
        cb.setValue(list.get(0));


        root.setTop(cb);
        root.setCenter(vb);

        Scene s = new Scene(root);
        primaryStage.setScene(s);
        primaryStage.show();
    }
}
