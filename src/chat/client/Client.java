package chat.client;

import chat.controller.ClientController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import tools.Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.regex.Pattern;

/**
 * Created by jeggy on 10/16/15.8:47 AM
 */
public class Client extends Thread{

    private String username;
    private Socket socket;
    private PrintWriter out;

    private ClientController cc;

    public ObservableList<OtherClient> otherClients = FXCollections.observableArrayList();

    public Client(String ip, int port, String username, ClientController cc) {
        this.cc = cc;
        this.username = username;


        try {
            socket = new Socket(ip, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            this.start();

            new Thread(() -> out.println(username)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeClient() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg){
        out.println(msg);
    }

    private BufferedReader br;
    public void run(){
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String l;
            while((l = br.readLine()) != null) {
                final String cmd = l.substring(0,3);
                final String msg = l.substring(3);
                Label label;
                switch (cmd){
                    case "MSG":
                        OtherClient sentClient = findClient(msg.substring(0, msg.indexOf(':')));
                        Platform.runLater(() -> cc.addToVB(sentClient.getLabel(msg)));
                        break;
                    case "USJ":
                        Platform.runLater(() -> otherClients.add(new OtherClient(msg)));
                        break;
                    case "USQ":
                        Platform.runLater(() -> otherClients.remove(findClient(msg)));
                        break;
                    case "UUC":
                        uuc(msg);
                        break;
                    case "USL":
                        String[] users = msg.split(",");
                        for (String userInfo : users) {
                            System.out.println("TEST");
                            // TODO: Not working.
                            String user = userInfo.substring(0, userInfo.indexOf('{'));
                            OtherClient other = new OtherClient(user);
                            String[] cmds = (userInfo.substring(userInfo.indexOf('{')+1, userInfo.indexOf('}'))).split("|");
                            for (String s : cmds) {
                                System.out.println(s);
                            }
                            Platform.runLater(() -> otherClients.add(other));
                        }
                        break;
                    case "WSU":
                        OtherClient from = findClient(msg.substring(0, msg.indexOf(':')));
                        String message = msg.substring(msg.indexOf(':')).substring(2);

                        if(from!=null){
                            label = from.getLabel(from.getUsername()+": "+message);
                            label.getStyleClass().add("italicLabel");


    //                        label.setFont(Font.font("Serif", FontPosture.ITALIC, Font.getDefault().getSize()));
                            Platform.runLater(() -> cc.addToVB(label));
                        }
                        break;
                    default:
                        System.out.println("'"+cmd+"' command not supported yet.");
                }
            }
            System.out.println("Server closed the connection.");
        } catch (SocketException e){
//            System.out.println("User closed the connection");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private OtherClient findClient(String client) {
        for (OtherClient otherClient : otherClients)
            if(otherClient.getUsername().equals(client))
                return otherClient;
        return null;
    }

    public String getUsername() {
        return username;
    }


    /**
     * run when user command comes from another user.
     * @param cmd
     */
    private void uuc(String cmd) {
        System.out.println("test | "+cmd);
        switch (validateCommand(cmd.substring(cmd.lastIndexOf(',')+1))){
            case "setColor":
                int comPos = cmd.lastIndexOf(",");
                for (OtherClient otherClient : otherClients) {
                    if(otherClient.getUsername().equals(cmd.substring(0, comPos))){
                        otherClient.setColor(cmd.substring(comPos+11));
                    }
                }
                break;
            case "whisper":
                String toUser = cmd.substring(3, cmd.indexOf(' '));
                for (OtherClient otherClient : otherClients) {
                    if(toUser.equalsIgnoreCase(otherClient.getUsername())){
                        out.print("MSG"+cmd);
                        Label label = new Label("Whisper to '"+toUser+": "+cmd.substring(3, cmd.indexOf(' ', 2)));
                        label.setFont(Font.font("Serif", FontPosture.ITALIC, Font.getDefault().getSize()));
                        Platform.runLater(()->cc.addToVB(label));
                    }
                }
                break;
        }
    }

    public String validateCommand(String msg) {
        try {
            if (msg.substring(1, 9).equalsIgnoreCase("setColor"))
                return (Regex.isColor(msg.substring(10))) ? "setColor" : null;
            else if(msg.substring(1, 8).equalsIgnoreCase("whisper"))
                return "whisper";
        }catch (StringIndexOutOfBoundsException e){
            return null;
        }
        return null;
    }


}
