package chat.server;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jeggy on 10/16/15.11:59 AM
 */
public class ClientHandler extends Thread{

    private Socket socket;
    private PrintWriter printWriter;
    private Server server;
    private Scanner scanner;
    private String username;
    private ArrayList<String> commandsSet = new ArrayList();

    public ClientHandler(Server server, Socket socket, PrintWriter printWriter, Scanner scanner, String name){
        this.socket = socket;
        this.printWriter = printWriter;
        this.server = server;
        this.scanner = scanner;
        this.username = name;
        this.start();
    }

    public void run(){
        String l;
        while(scanner.hasNextLine()){
            l = scanner.nextLine();
            String cmd = l.substring(0, 3);
            String msg = l.substring(3);
            switch (cmd){
                case "MSG":
                    server.sendToAll(cmd+username+": "+msg);
                    break;
                case "USC":
                    uuc(msg);
                    break;
                default:
                    System.out.println("'"+cmd+"' command not added in server's ClientHandler.");
            }
        }
        server.userQuit(this);
    }

    private void uuc(String cmd) {
        if(cmd.substring(1,9).equalsIgnoreCase("setcolor")){
            String commandSet = "UUC"+username+","+cmd;
            this.commandsSet.add(cmd.substring(1));
            server.sendToAll(commandSet);
        }else if(cmd.substring(1,8).equalsIgnoreCase("whisper")){
            String tmp = cmd.substring(9);
            int spacePos = tmp.indexOf(' ');
            if(spacePos>=0) {
                String userTo = tmp.substring(0, spacePos);
                String msg = tmp.substring(spacePos);
                server.send(userTo, "WSU" + username + ": " + msg);
            }
        }


    }


    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getCommandsSet() {
        return commandsSet;
    }

}
