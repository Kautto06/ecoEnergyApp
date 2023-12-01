package Controllers;
import Database.SQLConnection;
import Models.Pollution_state;
import java.sql.*;

import java.util.ArrayList;
import java.util.Arrays;


public class PollutionStateController {
    public void agregarPollutionStateABD(Pollution_state pollutionState) {
        int id =pollutionState.getId();
        int id_home = pollutionState.getIdHome();
        String id_admin = pollutionState.getIdAdminHome();
        String fecha = pollutionState.getFecha();
        double total_consume = pollutionState.getTotal_Consume();
        double consume = pollutionState.getConsume_State();
        String message = pollutionState.getMessage();
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();
        String sql = "INSERT INTO Pollution_state (ID, ID_Home, ID_Admin, Fecha, Total_Consume, Consume_State, Message) " +
                "VALUES (" + id + ", " + id_home + ", '" + id_admin + "', '" + fecha + "', " + total_consume + ", " + consume + ", '" +
                message + "')";


        conexion.ejecutarConsulta(sql);

        conexion.desconectar();
    }

    public void actualizarEstadoContaminacionEnBD(Pollution_state estadoContaminacion) {
        int id = estadoContaminacion.getId();
        int idHome = estadoContaminacion.getIdHome();
        String idAdminHome = estadoContaminacion.getIdAdminHome();
        String fecha = estadoContaminacion.getFecha();
        double totalConsume = estadoContaminacion.getTotal_Consume();
        double consumeState = estadoContaminacion.getConsume_State();
        String message = estadoContaminacion.getMessage();

        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "UPDATE Pollution_state SET ID_Home = " + idHome +
                ", ID_Admin = '" + idAdminHome + "', Fecha = '" + fecha +
                "', Total_Consume = " + totalConsume + ", Consume_State = " + consumeState +
                ", Message = '" + message + "' WHERE ID = " + id;

        conexion.ejecutarConsulta(sql);
        System.out.println("Datos de Estado de Contaminación actualizados exitosamente en la base de datos.");

        conexion.desconectar();
    }
    public void eliminarEstadoContaminacionDeBD(Pollution_state estadoContaminacion) {
        int id = estadoContaminacion.getId();
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "DELETE FROM Pollution_state WHERE ID = " + id;

        conexion.ejecutarConsulta(sql);
        System.out.println("Registro de Estado de Contaminación eliminado exitosamente de la base de datos.");

        conexion.desconectar();
    }

    public void obtenerTodosLosEstadosContaminacionDeBD(Pollution_state estadoContaminacion) {
        ArrayList<Pollution_state> nuevosEstadosContaminacion = new ArrayList<>();
        ResultSet resultSet=null;
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "SELECT * FROM Pollution_state";
        try (Statement statement = conexion.getConexion().createStatement()) {
            resultSet = statement.executeQuery(sql);
            System.out.println("Consulta ejecutada con éxito.");
            while (resultSet.next()) {
                if (estadoContaminacion.buscarPosicionId(resultSet.getInt("ID")) == -1) {
                    Pollution_state nuevoEstadoContaminacion = new Pollution_state(
                            resultSet.getInt("ID"),
                            resultSet.getInt("ID_Home"),
                            resultSet.getString("ID_Admin"),
                            resultSet.getString("Fecha"),
                            resultSet.getDouble("Total_Consume"),
                            resultSet.getDouble("Consume_State"),
                            resultSet.getString("Message")
                    );

                    nuevosEstadosContaminacion.add(nuevoEstadoContaminacion);
                }
            }
            estadoContaminacion.setPollutionStates(nuevosEstadosContaminacion);
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

    public Pollution_state obtenerEstadoContaminacionPorIdDeBD(Pollution_state estadoContaminacion) {
        Pollution_state newEstadosContaminacion = new Pollution_state();
        ResultSet resultSet=null;
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "SELECT * FROM Pollution_state WHERE ID = " + estadoContaminacion.getId();
        try (Statement statement = conexion.getConexion().createStatement()) {
            resultSet = statement.executeQuery(sql);
            System.out.println("Consulta ejecutada con éxito.");
            if(resultSet.next()) {
                    newEstadosContaminacion = new Pollution_state(
                            resultSet.getInt("ID"),
                            resultSet.getInt("ID_Home"),
                            resultSet.getString("ID_Admin"),
                            resultSet.getString("Fecha"),
                            resultSet.getDouble("Total_Consume"),
                            resultSet.getDouble("Consume_State"),
                            resultSet.getString("Message")
                    );
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
        return newEstadosContaminacion;
    }
}
