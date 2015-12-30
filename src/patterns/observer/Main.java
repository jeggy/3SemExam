package patterns.observer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Jógvan 21/12-2015 19:07.
 */
public class Main extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane bp = new GridPane();

        Person p = new Person("Jógvan", 21, "jo@jebster.net");


        TextField tf = new TextField(p.getName());

        Observer o = new Observer();
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            o.notifyObservers();
        });

        Field tf1 = new Field(p.getName(), tf);

        bp.add(tf, 0, 0);
        bp.add(tf1, 0, 1);


        primaryStage.setScene(new Scene(bp));
        primaryStage.show();
    }

}
