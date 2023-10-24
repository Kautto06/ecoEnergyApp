package org.example;

import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

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

    public boolean crearDatos() throws ParseException{
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
        this.fechaNacimiento=formato.parse(entrada.nextLine());
        users.add(new User(this.rut,this.Nombres,this.Apellidos,this.password,this.rol,this.fechaNacimiento));
        cargarDatosArchivo(new User(this.rut,this.Nombres,this.Apellidos,this.password,this.rol,this.fechaNacimiento));
        return true;
    }

    public void mostrarInformacion() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("RUT: " + rut);
        System.out.println("Nombres: " + Nombres);
        System.out.println("Apellidos: " + Apellidos);
        System.out.println("Contraseña: "+password);
        System.out.println("Rol en el sistema: " + rol);
        System.out.println("Fecha de nacimiento: " + dateFormat.format(fechaNacimiento));
        System.out.println();
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

    public int eliminarUsuarioArreglo(String rutEliminar){

        for(int i=0;i<this.users.size();i++){
            if(this.users.get(i).getRut().equals(rutEliminar)){
                this.users.remove(i);
                return 1;
            }
        }
        return 0;
    }

    public boolean buscarUsuario(String rutBuscado){
        for (int i=0;i<this.users.size();i++){
            if(this.users.get(i).getRut().equals(rutBuscado))return true;
        }
        return false;
    }

    public void MenuActualizarDatos() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

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
                setNombres(nuevosNombres);
                break;
            case 2:
                System.out.print("Nuevos apellidos: ");
                String nuevosApellidos = scanner.nextLine();
                setApellidos(nuevosApellidos);
                break;
            case 3:
                System.out.print("Nueva contraseña: ");
                String nuevaContrasena= scanner.nextLine();
                setPassword(nuevaContrasena);
            case 4:
                System.out.print("Nuevo rol en el sistema [ADMIN, USER]: ");
                String nuevoRol = scanner.nextLine();
                setRol(nuevoRol);
                break;
            case 5:
                System.out.print("Nueva fecha de nacimiento (dd/MM/yyyy): ");
                String nuevaFechaStr = scanner.nextLine();
                try {
                    Date nuevaFecha = dateFormat.parse(nuevaFechaStr);
                    setFechaNacimiento(nuevaFecha);
                } catch (ParseException e) {
                    System.out.println("Formato de fecha incorrecto. Use dd/MM/yyyy.");
                }
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void cargarDatosArchivo(User newData){
        try{
            FileWriter fileWriter = new FileWriter("src/test/text/Users.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n" + newData.toString());
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void leerUsersDesdeArchivo(String rutaArchivo) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);

        try {
            FileReader fileReader = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(", ");

                if (partes.length == 6) {
                    User user = new User();
                    user.setRut(partes[0]);
                    user.setNombres(partes[1]);
                    user.setApellidos(partes[2]);
                    user.setPassword(partes[3]);
                    user.setRol(partes[4]);
                    Date fechaNacimiento = dateFormat.parse(partes[5]);
                    user.setFechaNacimiento(fechaNacimiento);
                    users.add(user);
                } else {
                    System.err.println("Error en el formato de la línea: " + linea);
                }
            }

            bufferedReader.close();
            fileReader.close();

        } catch (IOException | ParseException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

    }
}

