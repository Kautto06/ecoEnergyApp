package Controllers;
import Models.Consume_state;

import java.sql.*;

import Database.SQLConnection;
import Models.Electricity_Company;
import Models.Pollution_state;
import java.util.ArrayList;


import java.util.Date;

public class ConsumeStateController {
    public void agregarConsumeStateABD(Consume_state consumeState) {
        int id = consumeState.getId();
        int id_home = consumeState.getIdHome();
        String id_admin = consumeState.getIdAdminHome();
        String fecha = consumeState.getFecha();
        double total_consume = consumeState.getTotalConsume();
        double total_cost = consumeState.getTotalCost();
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();
        String sql = "INSERT INTO Consume_State (ID, ID_Home, ID_Admin, Fecha, Total_Consume, Total_Cost) " +
                "VALUES ("+ id + ", " + id_home + ", '" + id_admin + "', '" + fecha + "', " + total_consume + ", " + total_cost + ")";

        conexion.ejecutarConsulta(sql);

        conexion.desconectar();
    }

    public void actualizarConsumeStateEnBD(Consume_state consumeState) {
        int id = consumeState.getId();
        int idHome = consumeState.getIdHome();
        String idAdminHome = consumeState.getIdAdminHome();
        String fecha = consumeState.getFecha();
        double totalConsume = consumeState.getTotalConsume();
        double totalCost = consumeState.getTotalCost();


        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "UPDATE Consume_State SET " +
                "ID_Home = " + idHome +
                ", ID_Admin = '" + idAdminHome + "'" +
                ", Fecha = '" + fecha + "'" +
                ", Total_Consume = " + totalConsume +
                ", Total_Cost = " + totalCost +
                " WHERE ID = " + id;

        conexion.ejecutarConsulta(sql);
        System.out.println("Datos de Estado de Consumo actualizados exitosamente en la base de datos.");

        conexion.desconectar();
    }
    public void eliminarEstadoContaminacionDeBD(Consume_state consumeState) {
        int id = consumeState.getId();
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "DELETE FROM Consume_State WHERE ID = " + id;

        conexion.ejecutarConsulta(sql);
        System.out.println("Registro de Estado de Consumo eliminado exitosamente de la base de datos.");

        conexion.desconectar();
    }

    public void obtenerTodosLosConsumeStatesDeBD(Consume_state consumeState) {
        ArrayList<Consume_state> newConsumeStates = new ArrayList<>();
        ResultSet resultSet=null;
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "SELECT * FROM Consume_State";
        try (Statement statement = conexion.getConexion().createStatement()) {
            resultSet = statement.executeQuery(sql);
            System.out.println("Consulta ejecutada con éxito.");
            while (resultSet.next()) {
                if(consumeState.buscarReporte(resultSet.getInt("ID"))==false){

                    Consume_state newConsumeState = new Consume_state();
                    newConsumeState.setId(resultSet.getInt("ID"));
                    newConsumeState.setIdHome(resultSet.getInt("ID_Home"));
                    newConsumeState.setIdAdminHome(resultSet.getString("ID_Admin"));
                    newConsumeState.setFecha(resultSet.getString("Fecha"));
                    newConsumeState.setTotalConsume(resultSet.getDouble("Total_Consume"));
                    newConsumeState.setTotalCost(resultSet.getDouble("Total_Cost"));
                    newConsumeStates.add(newConsumeState);
                }
            }

            consumeState.setReports(newConsumeStates);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conexion.desconectar();
        }
    }

    public Consume_state obtenerConsumeStatePorId(int consumeStateId) {
        Consume_state consumeState = null;
        ResultSet resultSet=null;
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "SELECT * FROM Consume_State WHERE ID = " + consumeStateId;
        try (Statement statement = conexion.getConexion().createStatement()) {
            resultSet = statement.executeQuery(sql);
            System.out.println("Consulta ejecutada con éxito.");
            if (resultSet.next()) {
                consumeState = new Consume_state();
                consumeState.setId(resultSet.getInt("ID"));
                consumeState.setIdHome(resultSet.getInt("ID_Home"));
                consumeState.setIdAdminHome(resultSet.getString("ID_Admin"));
                consumeState.setFecha(resultSet.getString("Fecha"));
                consumeState.setTotalConsume(resultSet.getDouble("Total_Consume"));
                consumeState.setTotalCost(resultSet.getDouble("Total_Cost"));

                // Puedes agregar más lógica según sea necesario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return consumeState;
    }

}
