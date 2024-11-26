package sockets;

import java.net.ServerSocket;
import java.net.Socket;

import sockets.echoService;

public class serverEchoMultThreadTCP {

    public static void main(String[] args) {
        // define the server socket, socket and counters for the connections
        ServerSocket serverSocket = null;
        Socket socket;
        int connections = 4;
        try {
            // 1 create the server socket
            serverSocket = new ServerSocket(9999);
            // 2. loop to accept and handle multiple connections
            while (connections > 0) {
                socket = serverSocket.accept();
                new Thread(new echoService(socket, --connections)).start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                // close the socket
                if (serverSocket != null)
                    serverSocket.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
