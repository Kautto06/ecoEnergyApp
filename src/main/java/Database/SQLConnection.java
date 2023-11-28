package Database;

import java.sql.*;
import java.util.ArrayList;


public class SQLConnection implements ConnectionInterface {
    private Connection conexion;


    public void conectar() {
        String url = "jdbc:sqlite:src/test/DB/EcoEnergyApp.db";
        try {
            conexion =  DriverManager.getConnection(url);

            // Lista de tablas en la base de datos
            String[] tables = {"Devices", "Electricity_Company", "Pollution_State", "Consume_State", "User", "Home"};

            // Iterar sobre las tablas e imprimir la información del esquema

        } catch (SQLException e) {
            System.err.println("Error en la operación de la base de datos: " + e.getMessage());
        }

    }

    public void desconectar() {
        // Lógica para cerrar la conexión
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ejecutarConsulta(String consulta) {
        // Lógica para ejecutar consultas SQL
        try (Statement statement = conexion.createStatement()) {
            statement.executeUpdate(consulta);
            System.out.println("Consulta ejecutada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet ejecutarConsultaRetorno(String consulta){
        ResultSet resultSet = null;
        try (Statement statement = conexion.createStatement()) {
            resultSet = statement.executeQuery(consulta);
            System.out.println("Consulta ejecutada con éxito.");
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public Connection getConexion() {
        return conexion;
    }
}

