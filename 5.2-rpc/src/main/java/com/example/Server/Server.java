package com.example.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Server {
    public static final int SERVER_PORT = 9999;

    private int port;
    private Agenda agenda;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Listening on port " + port);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client connected");
                    this.handle_client(socket);
                } catch (IOException e) {
                    System.out.println("Client disconnected");
                }
            }
        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }

    public void handle_client(Socket socket) throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        while (true) {
            switch (in.readInt()) {
                case 1 -> { // Crear objeto Agenda
                    this.agenda = new Agenda();
                    System.out.println("New agenda created");
                    out.writeBoolean(true);
                }
                case 2 -> { // Asociar
                    try {
                        String clave = in.readUTF();
                        int valor = in.readInt();
                        this.agenda.asociar(clave, valor);
                        System.out.println("Set \"" + clave + "\" to " + valor);
                        out.writeBoolean(true);
                    } catch (EOFException | UTFDataFormatException e) {
                        System.out.println("Set Error: Invalid parameters");
                        out.writeBoolean(false);
                    }
                }
                case 3 -> { // Obtener
                    try {
                        String clave = in.readUTF();
                        Integer valor = this.agenda.obtener(clave);
                        if (valor == null) {
                            System.out.println("Retrieve Error: \"" + clave + "\" not found");
                            out.writeBoolean(false);
                        } else {
                            System.out.println("Retrieved \"" + clave + "\" as " + valor);
                            out.writeBoolean(true);
                            out.writeInt(valor);
                        }
                    } catch (EOFException | UTFDataFormatException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 4 -> { // Obtener toda la agenda
                    try {
                        Map<String, Integer> contactos = this.agenda.obtenerTodos();
                        out.writeInt(contactos.size()); // Enviar cantidad de contactos
                        for (Map.Entry<String, Integer> entry : contactos.entrySet()) {
                            out.writeUTF(entry.getKey()); // Enviar nombre
                            out.writeInt(entry.getValue()); // Enviar teléfono
                        }
                        System.out.println("Sent all contacts to client");
                    } catch (IOException e) {
                        System.out.println("Error sending all contacts to client");
                    }
                }
                default -> System.out.println("Invalid operation code received");
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server(SERVER_PORT);
        server.start();
    }
}
