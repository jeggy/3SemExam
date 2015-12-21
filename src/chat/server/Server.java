package chat.server;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jeggy on 10/16/15.8:43 AM
 */
public class Server extends Thread{

    private int port;
    private ServerSocket server;

    private Hashtable<String, ClientHandler> clients = new Hashtable();
    private boolean serverOpen;

    private VBox vb;

    public Server(int port, VBox vb) {
        this.port = port;
        this.vb = vb;
        startServer();
    }

    private void startServer() {
        try {
            this.serverOpen = true;
            server = new ServerSocket(port);

            MainServer.setTitle("Server - " + Inet4Address.getLocalHost().getHostAddress());

            // Start listening thread.
            this.start();

            System.out.println("Server on.");
        }catch (IOException e) {
            System.out.println("Server failed to start.");
        }
    }

    public void stopServer(){
        this.serverOpen = false;
        try {
            this.sendToAll("SCL");
            this.server.close();
            System.out.println("Server turned off.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            while(this.serverOpen) {
                // New client socket
                Socket newClientSocket = server.accept();

                // PrintWriter to write messages to client
                PrintWriter newClientPrinter = new PrintWriter(newClientSocket.getOutputStream(), true);

                // Scanner for listening to client
                Scanner scanner = new Scanner(newClientSocket.getInputStream());

                // First line user writes is user's username
                String name = scanner.nextLine();

                addTextVB(name+" joined.");
                sendToAll("USJ"+name);

                this.clients.put(name, new ClientHandler(this, newClientSocket, newClientPrinter,scanner, name));
                sendUsersList(name);
            }
        } catch (SocketException e){
            System.out.println("Server got closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*  */

    public void sendUsersList(String toUser){
        String cmd = "USL";
        for (Map.Entry<String, ClientHandler> entry : clients.entrySet()) {
            cmd += entry.getKey()+"{";
            for (String userCommands : entry.getValue().getCommandsSet()) {
                cmd += userCommands+"|";
            }
            cmd += "},";
        }


        cmd.substring(0, cmd.length()-1);
        send(toUser, cmd);
    }

    public void send(String username, String message){
        addTextVB("Sending to: "+username+" | Command: "+message);
        ClientHandler c = clients.get(username);
        if(c!=null) c.getPrintWriter().println(message);
    }

    public void sendToAll(String message){
        for (Map.Entry<String,ClientHandler> entry : clients.entrySet()) {
            addTextVB("Sending to: "+entry.getKey()+" | Command: "+message);
            entry.getValue().getPrintWriter().println(message);
        }
    }

    private void addTextVB(String txt){
        Platform.runLater(() -> vb.getChildren().add(new Label(txt)));
    }


    public void userQuit(ClientHandler clientHandler) {
        sendToAll("USQ"+clientHandler.getUsername());
        this.clients.remove(clientHandler.getUsername());
        this.addTextVB(clientHandler.getUsername()+" has quited!");
    }
}
