package Controllers;

import Models.Device;

import java.sql.*;

import Database.SQLConnection;
import Models.Home;

import java.util.ArrayList;
import java.util.Date;

public class DeviceController {
    public void agregarDeviceABD(Device device) {
        int id = device.getId();
        String deviceName = device.getDeviceName();
        double energyConsume = device.getEnergyConsume();
        float activeHours = device.getActiveHours();
        int priorityUsage = device.getPriorityUsage();
        String consumeClassify = String.valueOf(device.getConsumeClassify());

        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "INSERT INTO Devices (ID, Nombre_Device, Consumo_Energia, Horas_Activo, Priority_Use, Consume_Classify) " +
                "VALUES (" + id + ", '" + deviceName + "', " + energyConsume + ", " + activeHours + ", " + priorityUsage + ", '" + consumeClassify + "')";

        conexion.ejecutarConsulta(sql);

        conexion.desconectar();
    }

    public void actualizarDeviceEnBD(Device device) {
        int id = device.getId();
        String deviceName = device.getDeviceName();
        double energyConsume = device.getEnergyConsume();
        float activeHours = device.getActiveHours();
        int priorityUsage = device.getPriorityUsage();
        char consumeClassify = device.getConsumeClassify();

        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        // Consulta SQL de actualización con concatenación
        String sql = "UPDATE Devices SET " +
                "Nombre_Device = '" + deviceName + "', " +
                "Consumo_Energia = " + energyConsume + ", " +
                "Horas_Activo = " + activeHours + ", " +
                "Priority_Use = " + priorityUsage + ", " +
                "Consume_Classify = '" + consumeClassify + "' " +
                "WHERE ID = " + id;

        // Ejecutar la consulta
        conexion.ejecutarConsulta(sql);
        System.out.println("Datos de Device actualizados exitosamente en la base de datos.");

        conexion.desconectar();
    }

    public void obtenerTodosLosDevicesDeBD(Device device) {
        ArrayList<Device> newDevices = new ArrayList<>();
        ResultSet resultSet=null;
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();
        String sql = "SELECT * FROM Devices";
        try (Statement statement = conexion.getConexion().createStatement()){
            resultSet = statement.executeQuery(sql);
            System.out.println("Consulta ejecutada con éxito.");

            System.out.println(resultSet);
            while (resultSet.next()) {
                if(device.buscarId(resultSet.getInt("ID"))==0){
                    Device newDevice = new Device();
                    newDevice.setId(resultSet.getInt("ID"));
                    newDevice.setDeviceName(resultSet.getString("Nombre_Device"));
                    newDevice.setEnergyConsume(resultSet.getDouble("Consumo_Energia"));
                    newDevice.setActiveHours(resultSet.getFloat("Horas_Activo"));
                    newDevice.setPriorityUsage(resultSet.getInt("Priority_Use"));
                    newDevice.setConsumeClassify(resultSet.getString("Consume_Classify").charAt(0));
                    newDevices.add(newDevice);
                }
            }
            System.out.println("Holi 2");
            device.setDispositivos(newDevices);
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

    public void eliminarDeviceDeBD(Device device) {
        int deviceId = device.getId();
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        // Concatenar directamente en la cadena de consulta
        String sql = "DELETE FROM Devices WHERE ID = " + deviceId;

        // Ejecutar la consulta
        conexion.ejecutarConsulta(sql);
        System.out.println("Registro de Device eliminado exitosamente de la base de datos.");

        conexion.desconectar();
    }

    public Device obtenerDevicePorId(int deviceId) {
        Device newDevice = null;
        ResultSet resultSet=null;

        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "SELECT * FROM Devices WHERE ID = " + deviceId;
        try (Statement statement = conexion.getConexion().createStatement()) {
            resultSet = statement.executeQuery(sql);
            System.out.println("Consulta ejecutada con éxito.");
            if (resultSet.next()) {
                newDevice = new Device();
                newDevice.setId(resultSet.getInt("ID"));
                newDevice.setDeviceName(resultSet.getString("DeviceName"));
                newDevice.setEnergyConsume(resultSet.getDouble("EnergyConsume"));
                newDevice.setActiveHours(resultSet.getFloat("ActiveHours"));
                newDevice.setPriorityUsage(resultSet.getInt("PriorityUsage"));
                newDevice.setConsumeClassify(resultSet.getString("ConsumeClassify").charAt(0));
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

        return newDevice;
    }


}
