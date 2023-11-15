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
            for (String tableName : tables) {
                printTableSchema(conexion, tableName);
            }

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

    private static void printTableSchema(java.sql.Connection connection, String tableName) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();

        System.out.println("Tabla: " + tableName);

        // Obtener las columnas de la tabla
        ResultSet columns = metaData.getColumns(null, null, tableName, null);

        // Lista para almacenar los nombres de las columnas
        ArrayList<String> columnNames = new ArrayList<>();

        // Iterar sobre las columnas
        while (columns.next()) {
            String columnName = columns.getString("COLUMN_NAME");
            columnNames.add(columnName);
        }

        // Mostrar los nombres de las columnas
        System.out.println("Columnas: " + columnNames);

        // Puedes hacer algo más con los nombres de las columnas si es necesario

        // Limpiar recursos
        columns.close();

    }




}