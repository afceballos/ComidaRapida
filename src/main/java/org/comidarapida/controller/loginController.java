package org.comidarapida.controller;


import org.comidarapida.models.Empleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class loginController {

    private static Connection connection;

    private static final String URL = "jdbc:sqlite:C:\\sqlite\\comidas.db";

    // Conexion en el modelo o en package Connection

    public static Connection conectar(){
        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("Conexion establecida");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void desconectar() {
        try {
            connection.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión con la base de datos: " + e.getMessage());
        }
    }

}
