package com.example.Data;

public interface IRepository {
    // Assigns a value d to a string key
    public void write(String key, int d);

    // Returns the value of key
    public int read(String key);
}
