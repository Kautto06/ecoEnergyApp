package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Home {
    private int id;
    private String companyRut;
    private int stateId;
    private String homeName;
    private String environmentType;
    private ArrayList<String> homeUsers=new ArrayList(); // futuro uso con base de datos
    private ArrayList<String> homeDevices= new ArrayList(); // futuro uso con base de datos
    private String idAdminHome;
    private int idInforme;

    private ArrayList<Home> homes= new ArrayList<>();


    public Home(int id, String companyRut, int stateId, String homeName, String envioromentType, String idAdminHome, int inform) {
        this.id = id;
        this.companyRut = companyRut;
        this.stateId = stateId;
        this.homeName = homeName;
        this.environmentType = envioromentType;
        this.idAdminHome = idAdminHome;
        this.idInforme = inform;
    }

    public Home(){
        this.id = 0;
        this.companyRut = "";
        this.stateId = 0;
        this.homeName = "";
        this.environmentType = "";
        this.idAdminHome = "";
        this.idInforme = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyRut(String companyRut) {
        this.companyRut = companyRut;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public void setEnvironmentType(String environmentType) {
        this.environmentType = environmentType;
    }

    public void setIdAdminHome(String idAdminHome) {
        this.idAdminHome = idAdminHome;
    }

    public void setIdInforme(int idInforme) {
        this.idInforme = idInforme;
    }

    public int getId() {
        return id;
    }

    public String getCompanyRut() {
        return companyRut;
    }

    public int getStateId() {
        return stateId;
    }

    public String getHomeName() {
        return homeName;
    }

    public String getEnvioromentType() {
        return environmentType;
    }

    public String getIdAdminHome() {
        return idAdminHome;
    }

    public int getInform() {
        return idInforme;
    }

    public String getEnvironmentType() {
        return environmentType;
    }

    public ArrayList<String> getHomeUsers() {
        return homeUsers;
    }

    public ArrayList<String> getHomeDevices() {
        return homeDevices;
    }

    public int getIdInforme() {
        return idInforme;
    }

    public ArrayList<Home> getHomes() {
        return homes;
    }

    public void setHomeUsers(ArrayList<String> homeUsers) {
        this.homeUsers = homeUsers;
    }

    public void setHomeDevices(ArrayList<String> homeDevices) {
        this.homeDevices = homeDevices;
    }

    public void setHomes(ArrayList<Home> homes) {
        this.homes = homes;
    }

    public void crearDatos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID: ");
        this.id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el RUT de la empresa: ");
        this.companyRut = scanner.next();
        scanner.nextLine();

        System.out.print("Ingrese el ID del estado: ");
        this.stateId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre del hogar: ");
        this.homeName = scanner.nextLine();

        System.out.print("Ingrese el tipo de ambiente: ");
        this.environmentType = scanner.nextLine();

        System.out.print("Ingrese el ID del administrador del hogar: ");
        this.idAdminHome = scanner.next();
        scanner.nextLine();

        System.out.print("Ingrese el ID del informe: ");
        this.idInforme = scanner.nextInt();
        scanner.nextLine();

        this.homes.add(new Home(this.id,this.companyRut,this.stateId,this.homeName,this.environmentType,this.idAdminHome,this.idInforme));
        cargarDatosArchivo(new Home(this.id,this.companyRut,this.stateId,this.homeName,this.environmentType,this.idAdminHome,this.idInforme));
    }

    public String toString(){
        return id+", "+stateId+", "+homeName+", "+environmentType+", "+idAdminHome+", "+idInforme;
    }


    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("ID de la compañía: " + companyRut);
        System.out.println("ID del estado: " + stateId);
        System.out.println("Nombre de la casa: " + homeName);
        System.out.println("Tipo de entorno: " + environmentType);
        System.out.println("Usuarios en la casa: " + homeUsers);
        System.out.println("Dispositivos en la casa: " + homeDevices);
        System.out.println("ID del administrador de la casa: " + idAdminHome);
        System.out.println("ID del informe: " + idInforme);
        System.out.println();
    }

    public void MenuMostrarHome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione qué elemento de la casa desea mostrar:");
        System.out.println("1. Nombre de la casa");
        System.out.println("2. Tipo de entorno");
        System.out.println("3. ID del administrador de la casa");
        System.out.println("4. Usuarios en la casa");
        System.out.println("5. Dispositivos en la casa");
        System.out.println("6. ID del informe");
        System.out.println("7. Mostrar toda la información");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Nombre de la casa: " + homeName);
                break;
            case 2:
                System.out.println("Tipo de entorno: " + environmentType);
                break;
            case 3:
                System.out.println("ID del administrador de la casa: " + idAdminHome);
                break;
            case 4:
                System.out.println("Usuarios en la casa: " + homeUsers);
                break;
            case 5:
                System.out.println("Dispositivos en la casa: " + homeDevices);
                break;
            case 6:
                System.out.println("ID del informe: " + idInforme);
                break;
            case 7:
                mostrarInformacion();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
    public void MenuActualizarDatos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione qué dato de la casa desea actualizar:");
        System.out.println("1. RUT de la compañía");
        System.out.println("2. Nombre de la casa");
        System.out.println("3. Tipo de entorno");
        System.out.println("4. ID del administrador de la casa");
        System.out.println("5. ID del informe");
        int opcion = scanner.nextInt();

        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Nuevo RUT de la compañía: ");
                String nuevoCompanyRut = scanner.next();
                setCompanyRut(nuevoCompanyRut);
                break;
            case 2:
                System.out.print("Nuevo nombre de la casa: ");
                String nuevoHomeName = scanner.nextLine();
                setHomeName(nuevoHomeName);
                break;
            case 3:
                System.out.print("Nuevo tipo de entorno: ");
                String nuevoEnvironmentType = scanner.nextLine();
                setEnvironmentType(nuevoEnvironmentType);
                break;
            case 4:
                System.out.print("Nuevo ID del administrador de la casa: ");
                String nuevoIdAdminHome = scanner.next();
                setIdAdminHome(nuevoIdAdminHome);
                break;
            case 5:
                System.out.print("Nuevo ID del informe: ");
                int nuevoIdInforme = scanner.nextInt();
                setIdInforme(nuevoIdInforme);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void cargarDatosArchivo(Home newData){
        try{
            FileWriter fileWriter = new FileWriter("src/test/text/Home.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n" + newData.toString());
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void leerHomesDesdeArchivo(String rutaArchivo) {
        try {
            FileReader fileReader = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(", ");

                if (partes.length == 6) {
                    Home home = new Home();
                    home.setId(Integer.parseInt(partes[0]));
                    home.setCompanyRut(partes[1]);
                    home.setHomeName(partes[2]);
                    home.setEnvironmentType(partes[3]);
                    home.setIdAdminHome(partes[4]);
                    home.setIdInforme(Integer.parseInt(partes[5]));
                    homes.add(home);
                } else {
                    System.err.println("Error en el formato de la línea: " + linea);
                }
            }

            bufferedReader.close();
            fileReader.close();

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

    }
}
