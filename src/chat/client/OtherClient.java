package chat.client;

import chat.controller.ClientController;
import javafx.scene.control.Label;

/**
 * Created by Jógvan on 30/11-2015 13:51.
 */
public class OtherClient {

    private String username;
    private String colorStyle = "-fx-text-fill: #000";
    public ClientController.test test;

    public Label getLabel(String txt) {
        Label l = new Label(txt);
        l.setStyle(this.colorStyle);
        return l;
    }

    public OtherClient(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setColor(String color){
        this.colorStyle = "-fx-text-fill: "+color+";";
        this.test.setStyle(this.colorStyle);
    }

    public String getColorStyle(){
        return colorStyle;
    }
}
