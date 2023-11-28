package Models;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import Controllers.HomeController;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Collections;
import java.util.Comparator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Home {
    private int id;
    private String companyRut;
    private String homeName;
    private String environmentType;
    private ArrayList<User> homeUsers=new ArrayList();
    private ArrayList<Device> homeDevices= new ArrayList<>();
    private String idAdminHome;

    private ArrayList<Home> homes= new ArrayList<>();

    public HomeController controlador = new HomeController();

    public Home(int id, String companyRut, String homeName, String environmentType, String idAdminHome) {
        this.id = id;
        this.companyRut = companyRut;
        this.homeName = homeName;
        this.environmentType = environmentType;
        this.idAdminHome = idAdminHome;
    }

    public Home(){
        this.id = 0;
        this.companyRut = "";
        this.homeName = "";
        this.environmentType = "";
        this.idAdminHome = "";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyRut(String companyRut) {
        this.companyRut = companyRut;
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

    public int getId() {
        return id;
    }

    public String getCompanyRut() {
        return companyRut;
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

    public String getEnvironmentType() {
        return environmentType;
    }

    public ArrayList<User> getHomeUsers() {
        return homeUsers;
    }

    public ArrayList<Device> getHomeDevices() {
        return homeDevices;
    }

    public ArrayList<Home> getHomes() {
        return homes;
    }

    public void setHomeUsers(ArrayList<User> homeUsers) {
        this.homeUsers = homeUsers;
    }

    public void setHomeDevices(ArrayList<Device> homeDevices) {
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

        System.out.print("Ingrese el nombre del hogar: ");
        this.homeName = scanner.nextLine();

        System.out.print("Ingrese el tipo de ambiente: ");
        this.environmentType = scanner.nextLine();

        System.out.print("Ingrese el ID del administrador del hogar: ");
        this.idAdminHome = scanner.next();
        scanner.nextLine();


        this.homes.add(new Home(this.id,this.companyRut,this.homeName,this.environmentType,this.idAdminHome));
        controlador.agregarHomeABD(new Home(this.id,this.companyRut,this.homeName,this.environmentType,this.idAdminHome));

    }

    public int eliminarHomeArreglo(int IdEliminar){

        for(int i=0;i<this.homes.size();i++){
            if(this.homes.get(i).getId() == IdEliminar){
                this.homes.remove(i);
                return 1;
            }
        }
        return 0;
    }
    public String toString(){
        return id+", "+homeName+", "+environmentType+", "+idAdminHome;
    }


    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("ID de la compañía: " + companyRut);
        System.out.println("Nombre de la casa: " + homeName);
        System.out.println("Tipo de entorno: " + environmentType);
        System.out.println("Usuarios en la casa: " + homeUsers);
        System.out.println("Dispositivos en la casa: " + homeDevices);
        System.out.println("ID del administrador de la casa: " + idAdminHome);
        System.out.println();
    }

    public int BuscarHome(int idBuscar)
    {
        for(Home home:homes)
            if(home.getId()==idBuscar)
                return 1;
        return 0;
    }

    public Home EncontrarHome(int idBuscar)
    {
        for(Home home:homes)
            if(home.getId()==idBuscar)
                return home;
        return null;
    }
    public void MenuEliminarHome()
    {
        int id=0;
        Scanner entrada= new Scanner(System.in);

        System.out.println("Mostrando todas las homes del sistema.");
        for(int i=0;i<this.homes.size();i++)
        {
            System.out.println("ID="+homes.get(i).id +"Nombre hombre ="+homes.get(i).homeName);
        }
        while(true)
        {
            System.out.println("Seleccione un id de  Home valido  para eliminar");
            id=entrada.nextInt();
            if(BuscarHome(id)==1)
            {
                controlador.eliminarHomeDeBD(EncontrarHome(id));
                eliminarHomeArreglo(id);
                return;
            }
        }
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
                mostrarInformacion();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void actualizarDatos(int id)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione qué dato de la casa desea actualizar:");
        System.out.println("1. RUT de la compañía");
        System.out.println("2. Nombre de la casa");
        System.out.println("3. Tipo de entorno");
        System.out.println("4. ID del administrador de la casa");
        System.out.println("5. ID del informe");


        int opcion=scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Nuevo RUT de la compañía: ");
                String nuevoCompanyRut = scanner.nextLine();
                this.homes.get(id).setCompanyRut(nuevoCompanyRut);
                controlador.actualizarHomeEnBD(this.homes.get(id));
                break;
            case 2:
                System.out.print("Nuevo nombre de la casa: ");
                String nuevoHomeName = scanner.nextLine();
                this.homes.get(id).setHomeName(nuevoHomeName);
                controlador.actualizarHomeEnBD(this.homes.get(id));
                break;
            case 3:
                System.out.print("Nuevo tipo de entorno: ");
                String nuevoEnvironmentType = scanner.nextLine();
                this.homes.get(id).setEnvironmentType(nuevoEnvironmentType);
                controlador.actualizarHomeEnBD(this.homes.get(id));
                break;
            case 4:
                System.out.print("Nuevo ID del administrador de la casa: ");
                String nuevoIdAdminHome = scanner.nextLine();
                this.homes.get(id).setIdAdminHome(nuevoIdAdminHome);
                controlador.actualizarHomeEnBD(this.homes.get(id));
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public int buscarPosicionId(int id){
        for (int i=0;i<this.homes.size();i++){
            if(this.homes.get(i).getId()==id) return i;
        }
        return -1;
    }

    public void MenuActualizarDatos() {

        if(this.homes==null){
            System.out.println("No hay datos registrados");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int id = 0,posId;

        System.out.println("Mostrando todas las homes del sistema.");
        for (int i = 0; i < this.homes.size(); i++) {
            System.out.println("ID=" + homes.get(i).id + "Nombre hombre =" + homes.get(i).homeName);
        }
        while (true) {
            System.out.println("Seleccione un id de  Home valido  para actualizar");
            id = scanner.nextInt();
            if (BuscarHome(id) == 1) {
                posId=buscarPosicionId(id);
                actualizarDatos(posId);
                return;
            }

        }


    }

    public void leerDesdeBDHomes() {
        controlador.obtenerTodosLosHomesDeBD(this);
    }

    public double calcularGastoEnergetico() {
        double gastoTotal = 0.0;


        for (Device device : homeDevices) {
            double consumoKwPorHora = device.getEnergyConsume() * device.getActiveHours();
            gastoTotal += consumoKwPorHora;
        }

        return gastoTotal;
    }

    public double calcularHuellaCarbono() {


        double huellaCarbonoTotal = 0.0;

        for (Device device : homeDevices) {
            double consumoKwPorHora = device.getEnergyConsume() * device.getActiveHours();
            double emisionesKg = consumoKwPorHora * 0.4;
            huellaCarbonoTotal += emisionesKg;
        }

        return huellaCarbonoTotal;
    }

    public ArrayList<Device> obtenerDispositivosOrdenadosPorConsumo() {

        ArrayList<Device> copiaDispositivos = new ArrayList<>(homeDevices);


        Collections.sort(copiaDispositivos, new Comparator<Device>() {
            @Override
            public int compare(Device device1, Device device2) {

                double consumoTotal1 = device1.getEnergyConsume() * device1.getActiveHours();
                double consumoTotal2 = device2.getEnergyConsume() * device2.getActiveHours();

                return Double.compare(consumoTotal2, consumoTotal1);
            }
        });

        return copiaDispositivos;
    }

    public void indicarConsumoElectrico() {
        double limiteNormal = 100;
        double limiteExceso = 200;

        if (calcularGastoEnergetico() <= limiteNormal) {
            System.out.println("Estás dentro de los parámetros normales de consumo eléctrico.");
        } else if (calcularGastoEnergetico() <= limiteExceso) {
            System.out.println("Estás sobrepasando un poco los parámetros normales de consumo eléctrico.");
        } else {
            System.out.println("Estás sobrepasando en exceso los parámetros normales de consumo eléctrico.");
        }
    }
}
