package com.example.Data;

public interface IRepository {
    // Se asocia un valor entero a una cadena
    public void asociar(String key, int d);

    // Se obtiene el valor entero asociado previamente a la cadena especificada
    public Integer obtener(String key);
}
