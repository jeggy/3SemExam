package chatsimple;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by jeggy on 10/16/15.8:42 AM
 */
public class MainProgram {

    public static void main(String[] args) throws UnknownHostException {

        // Let user decide if he want's to start a server or client
        String message = new Scanner(System.in).next();
        switch (message){
            case "server":
                new Server(1337);
                break;
            default:
                // Client will use the first message to username, so a client have "server" to username.
                new Client(InetAddress.getLocalHost().getHostAddress(), 1337, message);
        }
    }

}
