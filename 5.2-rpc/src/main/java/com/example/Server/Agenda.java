package com.example.Server;

import com.example.Data.IRepository;
import java.util.Hashtable;
import java.util.Map;

public class Agenda implements IRepository {
    private Hashtable<String, Integer> ht;

    public Agenda() {
        this.ht = new Hashtable<>();
    }

    public void asociar(String s, int v) {
        // Inserta una nueva tupla en la tabla hash
        ht.put(s, v);
    }

    public Integer obtener(String s) {
        // Obtiene el valor asociado a la clave s
        return ht.get(s);
    }

    public Map<String, Integer> obtenerTodos() {
        // Devuelve todos los contactos en la agenda
        return new Hashtable<>(ht);
    }
}
