package com.example.Client;

import com.example.Data.*;

import java.util.Hashtable;

public class Agenda implements IRepository {
    private Hashtable<String, Integer> ht = new Hashtable<String, Integer>();

    public void write(String s, int v) {
        // Assigns a value d to a string key
        ht.put(s, v);
    }

    public int read(String s) {
        // Returns the value of key
        return ((Integer) ht.get(s)).intValue();
    }
}