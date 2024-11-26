package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class clienteEchoTCP {
    public static void main(String[] args) throws IOException {
        // for reading lines form the kwyboard / Leer las lineas del teclado.
        BufferedReader userInputStream;
        String userInputLine;

        // Socket for conntecting to the echo server
        Socket socket;

        // For writing lines immediately to the socket byte input stream
        // escribir lineas inmediaamente al socket byte stream
        PrintWriter serverOutputStream;

        // For reading lines form the socjet byte input stream
        // Leer lineas del socket byte input stream
        BufferedReader serverInputStream;

        try {
            // 1. Create a socket to conntect with the server running on localhost:9999
            socket = new Socket("localhost", 9999);
            // 2 init serverInputStream for flushing IMMEDIATELY line chars to OS after
            // writeln is called.
            serverOutputStream = new PrintWriter(socket.getOutputStream(), true);

            // 3. Init serverInputStream for reading lines from the server.
            serverInputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 4. Init userInputStream for deading lines from the keyboard.
            userInputStream = new BufferedReader(new InputStreamReader(System.in));
            // 5. Read lines from the keyboard until ctrl-z or ctrl-d for eof.
            while ((userInputLine = userInputStream.readLine()) != null){
                // 6. write the line to the serverOutputStream
                serverOutputStream.println(userInputLine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {
            
        }

    }
}
