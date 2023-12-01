package Controllers;


import Database.SQLConnection;
import Models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ElectricityCompanyController {

    public void agregarElectricityCompanyABD(Electricity_Company ElectricityCompany) {
        String rut = ElectricityCompany.getRut();
        String nombre = ElectricityCompany.getNombre();
        double costoBase =ElectricityCompany.getCostoBase();
        double costoPorkW =ElectricityCompany.getCostoPorkW();
        double limitePorkW =ElectricityCompany.getLimiteDekW();
        double costoAdicional =ElectricityCompany.getCostoAdicionalPorkW();
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();
        String sql = "INSERT INTO Electricity_Company (Rut, Nombre, Costo_Base, Costo_kW, Limite_kW, Costo_Adicional_kW) " +
                "VALUES ('" + rut + "', '" + nombre + "', " + costoBase + ", " + costoPorkW + ", " + limitePorkW +
                ", " + costoAdicional + ")";

        System.out.println(sql);

        conexion.ejecutarConsulta(sql);

        conexion.desconectar();
    }
    public void actualizarElectricityCompanyEnBD(Electricity_Company ElectricityCompany) {
        String rut = ElectricityCompany.getRut();
        String nombre = ElectricityCompany.getNombre();
        double costoBase =ElectricityCompany.getCostoBase();
        double costoPorkW =ElectricityCompany.getCostoPorkW();
        double limitePorkW =ElectricityCompany.getLimiteDekW();
        double costoAdicional =ElectricityCompany.getCostoAdicionalPorkW();

        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        // Concatenar directamente en la cadena de consulta
        String sql = "UPDATE Electricity_Company SET Rut = '" + rut + "', Nombre = '" + nombre +
                "', Costo_Base = " + costoBase + ", Costo_kW = " + costoPorkW +
                ", Limite_kW = " + limitePorkW + ", Costo_Adicional_kW = " + costoAdicional +
                " WHERE Rut = " + rut;

        // Ejecutar la consulta
        conexion.ejecutarConsulta(sql);
        System.out.println("Datos de Electricity_Company actualizados exitosamente en la base de datos.");

        conexion.desconectar();
    }

    public void eliminarElectricityCompany(Electricity_Company ElectricityCompany) {
        String rut = ElectricityCompany.getRut();
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        // Concatenar directamente en la cadena de consulta
        String sql = "DELETE FROM Electricity_Company WHERE Rut = '" + rut +"'";

        System.out.println(sql);
        // Ejecutar la consulta
        conexion.ejecutarConsulta(sql);
        System.out.println("Registro de Electricity_Company eliminado exitosamente de la base de datos.");

        conexion.desconectar();
    }

    public void obtenerTodosLasElectricityCompanyDeBD(Electricity_Company ElectricityCompany) {
        ArrayList<Electricity_Company> newEC = new ArrayList<>();
        ResultSet resultSet=null;
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "SELECT * FROM Electricity_Company";
        try (Statement statement = conexion.getConexion().createStatement()) {
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                if(!ElectricityCompany.buscarRut(resultSet.getString("Rut"))){
                    Electricity_Company newECompany = new Electricity_Company();
                    newECompany.setRut(resultSet.getString("Rut"));
                    newECompany.setNombre(resultSet.getString("Nombre"));
                    newECompany.setCostoBase(resultSet.getDouble("Costo_Base"));
                    newECompany.setCostoPorkW(resultSet.getDouble("Costo_kW"));
                    newECompany.setLimiteDekW(resultSet.getDouble("Limite_kW"));
                    newECompany.setCostoAdicionalPorkW(resultSet.getDouble("Costo_Adicional_kW"));
                    newEC.add(newECompany);
                }

                ElectricityCompany.setCompanies(newEC);
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

    public Electricity_Company obtenerElectricityCompanyPorId(String rut) {
        Electricity_Company newEC = null;
        ResultSet resultSet=null;

        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "SELECT * FROM Home WHERE Rut = " + rut;
        try (Statement statement = conexion.getConexion().createStatement()) {
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                newEC = new Electricity_Company();
                newEC.setRut(resultSet.getString("Rut"));
                newEC.setNombre(resultSet.getString("Nombre"));
                newEC.setCostoBase(resultSet.getDouble("Costo_Base"));
                newEC.setCostoPorkW(resultSet.getDouble("Costo_kW"));
                newEC.setLimiteDekW(resultSet.getDouble("Cosot_Adicional_kW"));
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
        return newEC;
    }
    
    
    public int ComprobarCompania(String rut) {
        int resultado = 0;
        ResultSet resultSet = null;

        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "SELECT * FROM Electricity_Company WHERE Rut = '" + rut + "'";

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
            conexion.desconectar();
        }
        return resultado;
    }
    
}
