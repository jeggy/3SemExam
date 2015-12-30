package chatsimple;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by jeggy on 10/16/15.8:43 AM
 */
public class Server extends Thread{

    private int port;
    private ServerSocket server;

    // A hashTable for all our clients
    private Hashtable<Socket, PrintWriter> clients = new Hashtable<>();
    private boolean serverOpen;

    public Server(int port) {
        this.port = port;
        startServer();
    }


    private void startServer() {
        try {
            // Set serverOpen to true, instead of using a while(true) in thread.
            this.serverOpen = true;

            // Create a ServerSocket with the entered port
            server = new ServerSocket(port);

            // Start listening thread.
            this.start();
            System.out.println("Server on.");
        }catch (IOException e) {
            System.out.println("Server failed to start.");
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
                System.out.println(name+" joined.");

                new ClientHandler(this, scanner, name);
                clients.put(newClientSocket, newClientPrinter);
            }
            server.close();
            System.out.println("Server turned off.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param sender
     * @param message
     */
    public void sendToAll(String sender, String message) {
        for (PrintWriter printer : clients.values()) {
            printer.println(sender+": "+message);
        }
    }

}
