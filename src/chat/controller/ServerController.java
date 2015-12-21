package chat.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import chat.server.Server;

/**
 * Created by jeggy on 11/13/15.
 */
public class ServerController {

    public VBox vb;
    @FXML
    private TabPane tabPane;
    @FXML
    private Label errorMessage;
    @FXML
    private TextField portField;


    public static Server server;

    public void startServer(ActionEvent actionEvent) {
        try {
            int port = Integer.parseInt(portField.getText());
            if(port>1024&&port<65535){
                server = new Server(port, vb);
                tabPane.getSelectionModel().select(1);
                errorMessage.setText("");
            }else
                errorMessage.setText("Port can be numbers ");
        } catch (NumberFormatException e){
            errorMessage.setText("Port has to be numbers only");
        }
    }
}
