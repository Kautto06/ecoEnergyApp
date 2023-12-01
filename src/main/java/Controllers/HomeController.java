
package Controllers;
import  Models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import Database.SQLConnection;

public class HomeController {
    public void agregarHomeABD(Home home) {
        int id = home.getId();
        String companyRut = home.getCompanyRut();
        String homeName = home.getHomeName();
        String environmentType = home.getEnvironmentType();
        String idAdminHome = home.getIdAdminHome();

        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "INSERT INTO Home (ID, Company_Rut, Nombre, Enviroment_Type) " +
                "VALUES (" + id + ", '" + companyRut + "', '" + homeName + "', '" + environmentType + "')";

        conexion.ejecutarConsulta(sql);


        conexion.desconectar();
    }
    public void agregarUsersHome(String esAdmin,String Rut, int IdHome)
    {
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql="INSERT INTO Users_Home (EsAdmin, RUT, ID_HOME)" +
                "VALUES ('" + esAdmin + "', '" + Rut + "', " + IdHome +  ")";
        conexion.ejecutarConsulta(sql);
        conexion.desconectar();
    }

    public void actualizarHomeEnBD(Home home) {
        int id = home.getId();
        String companyRut = home.getCompanyRut();
        String homeName = home.getHomeName();
        String environmentType = home.getEnvironmentType();
        String idAdminHome = home.getIdAdminHome();

        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        // Concatenar directamente en la cadena de consulta
        String sql = "UPDATE Home SET Company_Rut = '" + companyRut + "', Nombre = '" + homeName +
                "', Enviroment_Type = '" + environmentType + "' WHERE ID = " + id;

        // Ejecutar la consulta
        conexion.ejecutarConsulta(sql);
        System.out.println("Datos de Home actualizados exitosamente en la base de datos.");

        conexion.desconectar();
    }

    public void eliminarHomeDeBD(Home home) {
        int homeId = home.getId();
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        // Concatenar directamente en la cadena de consulta
        String sql = "DELETE FROM Home WHERE ID = " + homeId;

        // Ejecutar la consulta
        conexion.ejecutarConsulta(sql);
        System.out.println("Registro de Home eliminado exitosamente de la base de datos.");

        conexion.desconectar();
    }

    public void obtenerTodosLosHomesDeBD(Home home) {
        ArrayList<Home> newHomes = new ArrayList<>();
        ResultSet resultSet=null;

        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "SELECT * FROM Home";
        try (Statement statement = conexion.getConexion().createStatement()){
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if(home.BuscarHome(resultSet.getInt("ID"))==0){
                    Home newHome = new Home();
                    newHome.setId(resultSet.getInt("ID"));
                    newHome.setCompanyRut(resultSet.getString("Company_Rut"));
                    newHome.setHomeName(resultSet.getString("Nombre"));
                    newHome.setEnvironmentType(resultSet.getString("Enviroment_Type"));

                    newHomes.add(newHome);
                }
                home.setHomes(newHomes);
            }
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

    public Home obtenerHomePorId(int homeId) {
        Home newHome = null;
        ResultSet resultSet=null;
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "SELECT * FROM Home WHERE ID = " + homeId;
        try (Statement statement = conexion.getConexion().createStatement()) {
            resultSet = statement.executeQuery(sql);
            System.out.println("Consulta ejecutada con éxito.");
            if (resultSet.next()) {
                newHome = new Home();
                newHome.setId(resultSet.getInt("ID"));
                newHome.setCompanyRut(resultSet.getString("Company_Rut"));
                newHome.setHomeName(resultSet.getString("Nombre"));
                newHome.setEnvironmentType(resultSet.getString("Enviroment_Type"));
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
        return newHome;
    }

    public int verificarHome(int homeId) {
        int resultado = 0;
        ResultSet resultSet = null;
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "SELECT * FROM Home WHERE ID = " + homeId;
        try (Statement statement = conexion.getConexion().createStatement()) {
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                resultado = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return resultado;
    }
    public int obtenerUltimoIdDeHomes() {
        int ultimoId = -1;  // Valor predeterminado en caso de que no se encuentren registros

        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "SELECT MAX(ID) AS UltimoId FROM Home";
        try (Statement statement = conexion.getConexion().createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                if (resultSet.next()) {
                    ultimoId = resultSet.getInt("UltimoId");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }

        return ultimoId;
    }
}
