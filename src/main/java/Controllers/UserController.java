package Controllers;

import Database.SQLConnection;
import Models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.time.LocalDate;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import Database.SQLConnection;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserController {

    public void agregarUserADB(User user)
    {

        String rut = user.getRut();
        String nombres = user.getNombres();
        String apellidos = user.getApellidos();
        String password = user.getPassword();
        String rol = user.getRol();
        String fechaNacimiento= user.getFechaNacimiento();

        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "INSERT INTO User (Rut, Nombres, Apellidos, Password, Rol, Fecha_De_Nacimiento) " +
                "VALUES ('" + rut + "', '" + nombres + "', '" + apellidos + "', '" +
                password + "', '" + rol + "', '" + fechaNacimiento + "')";

        conexion.ejecutarConsulta(sql);

        conexion.desconectar();

    }

    public void actualizarUsuarioEnBD(User usuario) {
        String rut = usuario.getRut();
        String nombres = usuario.getNombres();
        String apellidos = usuario.getApellidos();
        String password = usuario.getPassword();
        String rol = usuario.getRol();
        String fechaNacimiento = usuario.getFechaNacimiento();

        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "UPDATE User SET Nombres = '" + nombres + "', Apellidos = '" + apellidos +
                "', Password = '" + password + "', Rol = '" + rol +
                "', Fecha_De_Nacimiento = '" + fechaNacimiento +
                "' WHERE Rut = '" + rut + "'";

        conexion.ejecutarConsulta(sql);
        System.out.println("Datos de Usuario actualizados exitosamente en la base de datos.");

        conexion.desconectar();
    }
    public void eliminarUsuarioDeBD(User usuario) {
        String rut = usuario.getRut();
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "DELETE FROM User WHERE Rut = '" + rut + "'";

        conexion.ejecutarConsulta(sql);
        System.out.println("Registro de Usuario eliminado exitosamente de la base de datos.");

        conexion.desconectar();
    }

    public void obtenerTodosLosUsuariosDeBD(User user) {
        ArrayList<User> nuevosUsuarios = new ArrayList<>();
        ResultSet resultSet = null;
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "SELECT * FROM User";

        try (PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql)) {
            resultSet = preparedStatement.executeQuery();
            System.out.println("Consulta ejecutada con éxito.");

            while (resultSet.next()) {
                if (user.buscarUser(resultSet.getString("Rut")) == -1) {
                    User nuevoUsuario = new User();
                    nuevoUsuario.setRut(resultSet.getString("Rut"));
                    nuevoUsuario.setNombres(resultSet.getString("Nombres"));
                    nuevoUsuario.setApellidos(resultSet.getString("Apellidos"));
                    nuevoUsuario.setPassword(resultSet.getString("Password"));
                    nuevoUsuario.setRol(resultSet.getString("Rol"));
                    nuevoUsuario.setFechaNacimiento(resultSet.getString("Fecha_De_Nacimiento"));

                    nuevosUsuarios.add(nuevoUsuario);
                }
            }
            user.setUsers(nuevosUsuarios);
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
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
    }

    public User obtenerUsuarioPorRut(String rut) {
        User nuevoUsuario = null;
        ResultSet resultSet=null;
        SQLConnection conexion = new SQLConnection();
        conexion.conectar();

        String sql = "SELECT * FROM User WHERE Rut = '" + rut + "'";
        try (Statement statement = conexion.getConexion().createStatement()) {
            resultSet = statement.executeQuery(sql);
            System.out.println("Consulta ejecutada con éxito.");
            if (resultSet.next()) {
                nuevoUsuario = new User();
                nuevoUsuario.setRut(resultSet.getString("Rut"));
                nuevoUsuario.setNombres(resultSet.getString("Nombres"));
                nuevoUsuario.setApellidos(resultSet.getString("Apellidos"));
                nuevoUsuario.setPassword(resultSet.getString("Password"));
                nuevoUsuario.setRol(resultSet.getString("Rol"));
                nuevoUsuario.setFechaNacimiento(resultSet.getString("Fecha_De_Nacimiento"));
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
        return nuevoUsuario;
    }
}
