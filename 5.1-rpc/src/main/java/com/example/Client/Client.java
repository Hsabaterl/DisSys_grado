package com.example.Client;

import java.io.IOException;
import java.util.Scanner;

import com.example.Server.Server;

public class Client {
    public static void main(String[] args) {
        try {
            Agenda agendaTelefonica = new Agenda("localhost", Server.SERVER_PORT);
            Scanner scanner = new Scanner(System.in);
            boolean salir = false;

            while (!salir) {
                System.out.println("\n--- MENÚ ---");
                System.out.println("1. Asociar un teléfono");
                System.out.println("2. Obtener teléfono de un contacto");
                System.out.println("3. Mostrar toda la agenda");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el teléfono: ");
                        int telefono = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        agendaTelefonica.asociar(nombre, telefono);
                        System.out.println("Contacto guardado exitosamente.");
                        break;

                    case 2:
                        System.out.print("Ingrese el nombre para buscar el teléfono: ");
                        String nombreBuscar = scanner.nextLine();
                        Integer telefonoEncontrado = agendaTelefonica.obtener(nombreBuscar);
                        if (telefonoEncontrado != null) {
                            System.out.println("Teléfono de " + nombreBuscar + " = " + telefonoEncontrado);
                        } else {
                            System.out.println("No se encontró el contacto.");
                        }
                        break;

                    case 3:
                        System.out.println("Agenda completa:");
                        System.out.println(agendaTelefonica.obtenerTodos());
                        break;

                    case 4:
                        salir = true;
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("No se pudo conectar al servidor.");
        }
    }
}
