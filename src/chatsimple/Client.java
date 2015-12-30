package chatsimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by jeggy on 10/16/15.8:47 AM
 */
public class Client extends Thread{

    private Socket socket;

    public Client(String ip, int port, String message) {
        // Scanner object for listening to clients keyboard.
        Scanner s = new Scanner(System.in);

        try {
            // Connect to server's ip and server's port
            socket = new Socket(ip, port);

            // PrintWriter object for beining able to print messages to the server.
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // True for flush, cause we only wanna send one line at the time

            // Start thread on listening to the server
            this.start();

            // While true for listening to the clients keyboard
            while(true){
                if(message.equals("break")) break;

                // Send message and then start waiting on the next message.
                out.println((message));
                message = s.nextLine();
            }
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            // BufferedReader for listening to the server
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String l;
            // Wait for a message from the server and print it each time we'll get one.
            while((l = br.readLine()) != null) {
                System.out.println(l);
            }

            // Will get here when server closes which will cause br to get to EOF
            System.out.println("Closed connection.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
