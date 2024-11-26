package com.example.Client;

public class AgendaClient {
    public static void main(String[] args) {
    Agenda phoneAgenda= new Agenda();
    Agenda passwdAgenda = new Agenda();
    phoneAgenda.write("www.google.es", 66756677);
    passwdAgenda.write("www.moodle.es", "mypassword");
    phoneAgenda.write("Pepe", 644454456);
    System.out.println("Juan's Phone = " + phoneAgenda.read("Juan"));
    System.out.println("Pepe's Phone = " + phoneAgenda.read("Pepe"));
    System.out.println("Password Moodle = " +
    passwdAgenda.read("Moodle"));
    }
}

