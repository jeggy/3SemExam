package chat.controller;

import chat.client.Client;
import chat.client.OtherClient;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 * Created by jeggy on 11/13/15.
 */
public class ClientController{


    public Button connectBtn;
    public TextField ipField;
    public TextField portField;
    public Label ipMessage;
    public Label portMessage;
    public VBox vb;
    public TabPane tabPane;
    public TextField usernameField;
    public Label usernameMessage;
    public TextField messageField;
    public VBox rightVB;
    public ScrollPane scrollVB;
    public ListView<OtherClient> listView;

    public Client client;

    public void connect(ActionEvent actionEvent) {
        int port = -1;
        try {
            port = Integer.parseInt(portField.getText());
            if(port>1024&&port<65535){
                portMessage.setText("");
            }else
                portMessage.setText("Port can be numbers ");
        } catch (NumberFormatException e){
            portMessage.setText("Port has to be numbers only");
        }

        client = new Client(ipField.getText(), port, usernameField.getText(), this);

        tabPane.getSelectionModel().select(1);
        listView.setItems(client.otherClients);
        setListViewSettings();
    }

    public void sendMessage(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)) {
            String msg = messageField.getText();
            if((msg.charAt(0)=='/'||msg.charAt(0)=='\\')&&client.validateCommand(msg)!=null){
                client.sendMessage("USC"+msg);
            }else{
                client.sendMessage("MSG"+msg);
            }
            messageField.setText("");
        }
    }

    public void addToVB(Node node) {
        this.vb.getChildren().add(node);
        // TODO: fix scroll to bottom bug.
//        this.scrollVB.setVvalue(1.0);
    }


    public void closeProgram(Stage primaryStage) {
        client.closeClient();
        primaryStage.close();
    }

    // TODO: ↓ Beautify this ↓
    public void setListViewSettings() {

        listView.setCellFactory((ListView<OtherClient> l) -> new test());
    }

    public class test extends ListCell<OtherClient>{
        @Override
        public void updateItem(OtherClient item, boolean empty) {
            super.updateItem(item, empty);
            this.setId("defaultListCell");
            if(item!=null) {
                item.test = this;
                this.setText(item.getUsername());
                if(client.getUsername().equalsIgnoreCase(item.getUsername()))
                    this.getStyleClass().add("currentUser");

            }
            if(empty)this.setText("");
        }
    }
}
