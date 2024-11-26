package com.example.Client;

import com.example.Data.IRepository;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Agenda implements IRepository {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Agenda(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        // Crear la agenda remota
        this.out.writeInt(1);
        if (!this.in.readBoolean()) {
            throw new IOException();
        }
    }

    @Override
    public void asociar(String key, int d) {
        try {
            this.out.writeInt(2); // Código para "asociar" en el servidor
            this.out.writeUTF(key);
            this.out.writeInt(d);
            if (!this.in.readBoolean()) throw new IOException();
        } catch (IOException e) {
            System.out.println("Error al escribir en la agenda remota");
        }
    }

    @Override
    public Integer obtener(String key) {
        try {
            this.out.writeInt(3); // Código para "obtener" en el servidor
            this.out.writeUTF(key);
            if (!this.in.readBoolean()) throw new IOException();
            return this.in.readInt();
        } catch (IOException e) {
            System.out.println("Error al leer de la agenda remota");
        }

        return null;
    }

    // Nuevo método para obtener todos los contactos de la agenda
    public Map<String, Integer> obtenerTodos() {
        Map<String, Integer> agendaCompleta = new HashMap<>();
        try {
            this.out.writeInt(4); // Código para "obtener todos" en el servidor
            int cantidadContactos = this.in.readInt(); // Leer el número de contactos
            for (int i = 0; i < cantidadContactos; i++) {
                String nombre = this.in.readUTF();
                int telefono = this.in.readInt();
                agendaCompleta.put(nombre, telefono);
            }
        } catch (IOException e) {
            System.out.println("Error al obtener toda la agenda remota");
        }
        return agendaCompleta;
    }
}
