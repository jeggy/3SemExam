package chatsimple;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by jeggy on 10/16/15.11:59 AM
 */
public class ClientHandler extends Thread{

    private Server server;
    private Scanner scanner;
    private String name;

    public ClientHandler(Server server, Scanner scanner, String name){
        this.server = server;
        this.scanner = scanner;
        this.name = name;
        this.start();
    }

    public void run(){
        try {
            String l;
            while ((l = scanner.nextLine()) != null) {
                // Every line the client enters will be sent to all clients
                server.sendToAll(name, l);
            }
        }catch (NoSuchElementException e){
            // We'll get a NoSuchElementException on scanner when client destroys the scanner object.
            System.out.println("Client{"+name+"} closed the connection.");
        }
    }

}
