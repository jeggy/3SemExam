package chat.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import tools.FXTools;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by jeggy on 11/13/15.
 */
public class MainController implements Initializable{


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void startServer(ActionEvent actionEvent) {
        FXTools.startFXApplication("chat.server.MainServer");
    }

    public void startClient(ActionEvent actionEvent) {
        FXTools.startFXApplication("chat.client.MainClient");
    }

}
