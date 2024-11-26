package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class servidorEchoMonoThreadTCP {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = null;
    Socket socket = null;

    try {
      // 1. Create a server socket that listens on port 9999
      serverSocket = new ServerSocket(9999);
      // 2. wait for an incoming new user connection
      socket = serverSocket.accept();
      // 3. Reading lines from the socket byte input stream
      BufferedReader userInputLine = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      // 4. Writing lines to the socket byte output stream
      PrintWriter lineOutputStream = new PrintWriter(socket.getOutputStream(), true);
      // 5. Read a line from the input stream socket and echo it to the output stream
      // socket
      String inputLine;
      do {
        inputLine = userInputLine.readLine();
        // 6. write the line to output stream socket
        lineOutputStream.println(inputLine);
      } while (userInputLine != null);
    } catch (IOException e) {
      System.out.println(e.getMessage());
      serverSocket.close();
    }
  }
}