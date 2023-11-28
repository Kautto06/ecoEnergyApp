package org.example;

import Database.SQLConnection;

public class Main {
    public static void sistema(){
        SQLConnection conexion= new SQLConnection();

        conexion.conectar();
        conexion.desconectar();
        Menus.menuSeleccionClases();
    }
}