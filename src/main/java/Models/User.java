package Models;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String rut;
    private String Nombres;
    private String Apellidos;
    private String password;
    private String rol; // rol en el sistema [CEOS, ADMIN, USER]
    private Date fechaNacimiento;

    private ArrayList<User> users= new ArrayList<>();



    public User(String rut, String Nombres, String Apellidos,String password, String rol, Date fechaNacimiento) {
        this.rut = rut;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.password=password;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
    }

    public User() {
        this.rut = null;
        this.Nombres = null;
        this.Apellidos = null;
        this.password =null;
        this.rol = null;
        this.fechaNacimiento = null;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String toString(){
        return rut+", "+Nombres+", "+Apellidos+", "+password+", "+rol+", "+fechaNacimiento;
    }

    public void crearDatos(){
        Scanner entrada = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Ingrese el rut del nuevo usuario: ");
        this.rut=entrada.nextLine();
        System.out.print("Ingrese los nombres del nuevo usuario: ");
        this.Nombres=entrada.nextLine();
        System.out.print("Ingrese los apellidos del nuevo usuario: ");
        this.Apellidos=entrada.nextLine();
        System.out.print("Ingrese la contraseña del nuevo usuario: ");
        this.password=entrada.nextLine();
        System.out.print("Ingrese el rol del nuevo usuario: ");
        this.rol=entrada.nextLine();
        System.out.print("Ingrese la fecha de nacimiento del usuario: ");
        try {
            this.fechaNacimiento=formato.parse(entrada.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.users.add(new User(this.rut,this.Nombres,this.Apellidos,this.password,this.rol,this.fechaNacimiento));
    }

    public void mostrarInformacion() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("RUT: " + this.rut);
        System.out.println("Nombres: " + this.Nombres);
        System.out.println("Apellidos: " + this.Apellidos);
        System.out.println("Contraseña: "+ this.password);
        System.out.println("Rol en el sistema: " + this.rol);
        System.out.println("Fecha de nacimiento: " + dateFormat.format(this.fechaNacimiento));
        System.out.println();
    }
    
    public void menuEliminarUsuarios(){
        Scanner entrada = new Scanner(System.in);
        String rutAEliminar;
        if(users==null){
            System.out.println("No hay usuarios en el sistema");
            return;
        }

        do {
            for(int i=0;i<this.users.size();i++)
                this.users.get(i).mostrarInformacion();
            System.out.println();
            System.out.print("Ingrese el Rut del usuario que desea eliminar: ");
            rutAEliminar= entrada.nextLine();
            System.out.println();
        }while(!buscarUsuario(rutAEliminar));

        eliminarUsuarioArreglo(rutAEliminar);
        System.out.println("Se elimino el usuario correctamente");
    }
    // Método para mostrar un menú y permitir al usuario seleccionar qué elemento mostrar
    public void MenuMostrarUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione qué elemento del usuario desea mostrar:");
        System.out.println("1. Nombres");
        System.out.println("2. Apellidos");
        System.out.println("3. Contraseña");
        System.out.println("4. Rol en el sistema");
        System.out.println("5. Fecha de nacimiento");
        System.out.println("6. Mostrar toda la información");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Nombres: " + Nombres);
                break;
            case 2:
                System.out.println("Apellidos: " + Apellidos);
                break;
            case 3:
                System.out.println("Contraseña: "+password);
            case 4:
                System.out.println("Rol en el sistema: " + rol);
                break;
            case 5:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Fecha de nacimiento: " + dateFormat.format(fechaNacimiento));
                break;
            case 6:
                mostrarInformacion();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }


    public int eliminarUsuarioArreglo(String rutEliminar) {
        boolean removed = this.users.removeIf(user -> user.getRut().equals(rutEliminar));
        return removed ? 1 : 0;
    }

    public boolean buscarUsuario(String rutBuscado) {
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getRut().equals(rutBuscado)) return true;
        }
        return false;
    }
    public int buscarUser(String rutBuscado) {
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getRut().equals(rutBuscado)) return i;
        }
        return -1;
    }
    public void MenuActualizarDatos() {
        Scanner scanner = new Scanner(System.in);

        if(this.users==null){
            System.out.println("No hay datos registrados");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (int i=0;i<this.users.size();i++){
            this.users.get(i).mostrarInformacion();
        }

        String rutActualizado;
        do {
            System.out.println("Ingrese el rut del usuraio que desa actualizar");
            rutActualizado = scanner.nextLine();
        }while(!buscarUsuario(rutActualizado));
        int i = buscarUser(rutActualizado);
        System.out.println("Seleccione qué dato del usuario desea actualizar:");
        System.out.println("1. Nombres");
        System.out.println("2. Apellidos");
        System.out.println("3. Contraseña");
        System.out.println("4. Rol en el sistema");
        System.out.println("5. Fecha de nacimiento");
        int opcion = scanner.nextInt();

        scanner.nextLine();

        switch (opcion) {
                case 1:
                    System.out.print("Nuevo nombre: ");
                    String nuevosNombres = scanner.nextLine();
                    this.users.get(i).setNombres(nuevosNombres);
                    break;
                case 2:
                    System.out.print("Nuevos apellidos: ");
                    String nuevosApellidos = scanner.nextLine();
                    this.users.get(i).setApellidos(nuevosApellidos);
                    break;
                case 3:
                    System.out.print("Nueva contraseña: ");
                    String nuevaContrasena = scanner.nextLine();
                    this.users.get(i).setPassword(nuevaContrasena);
                case 4:
                    System.out.print("Nuevo rol en el sistema [ADMIN, USER]: ");
                    String nuevoRol = scanner.nextLine();
                    this.users.get(i).setRol(nuevoRol);
                    break;
                case 5:
                    System.out.print("Nueva fecha de nacimiento (dd/MM/yyyy): ");
                    String nuevaFechaStr = scanner.nextLine();
                    try {
                        Date nuevaFecha = dateFormat.parse(nuevaFechaStr);
                        this.users.get(i).setFechaNacimiento(nuevaFecha);
                    } catch (ParseException e) {
                        System.out.println("Formato de fecha incorrecto. Use dd/MM/yyyy.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    public static Boolean VerificarUsuario(String rutaArchivo, String rut, String password){
        File file = new File(rutaArchivo);
        try {
            FileReader inputfile = new FileReader(file);
            CSVReader reader = new CSVReader(inputfile);
            String[] nextRecord;

            // we are going to read data line by line
            int i=0;
            while (true){
                try {
                    if (!((nextRecord = reader.readNext()) != null)) break;
                } catch (CsvValidationException e) {
                    throw new RuntimeException(e);
                }
                if(nextRecord[0].equals(rut) && nextRecord[3].equals(password)){
                    return true;
                }
                i++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public void leerDesdeBDUsers(String urlBD, String usuario, String contraseña) {
        String sql = "SELECT * FROM User";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try (
                Connection connection = DriverManager.getConnection(urlBD, usuario, contraseña);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                String rut = resultSet.getString("Rut");
                String nombres = resultSet.getString("Nombres");
                String apellidos = resultSet.getString("Apellidos");
                String password = resultSet.getString("Password");
                String rol = resultSet.getString("Rol");
                Date fechaNacimiento = resultSet.getDate("Fecha_De_Nacimiento");
                users.add(new User(rut, nombres, apellidos, password, rol, fechaNacimiento));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

