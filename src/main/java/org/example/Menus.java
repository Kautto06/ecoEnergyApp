package org.example;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class Menus {

    public static  void menuSeleccionClases() throws ParseException {
        Scanner entrada = new Scanner(System.in);
        int opcion=0;

        Device dispositvo = new Device();
        User usuarios=new User();
        Electricity_Company empresa=new Electricity_Company();
        Pollution_state estado=new Pollution_state();
        Report reporte = new Report();
        Home home =new Home();

        do{
            System.out.println("Seleccione el dato con el que desea trabajar: ");
            System.out.println("1. Dispostivos");
            System.out.println("2. Usuarios");
            System.out.println("3. Empresa de electricidad");
            System.out.println("4. Estado de contaminacion");
            System.out.println("5. Homes");
            System.out.println("6. Reportes");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opcion: ");
            opcion=entrada.nextInt(); entrada.nextLine();
            switch (opcion)
            {
                case 1:
                    menuDispositivos(dispositvo);
                    break;
                case 2:
                    menuUsuarios(usuarios);
                    break;
                case 3:
                    menuEmpresaElectricidad(empresa);
                    break;
                case 4:
                    menuEstadoDeContaminacion(estado);
                    break;
                case 5:
                    menuHomes(home);
                case 6:
                    menuReportes(reporte);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    System.out.println();
            }

        }while(opcion!=0);
    }

    public static void menuDispositivos(Device dispositivo) throws ParseException {
        System.out.println();
        Scanner entrada = new Scanner(System.in);
        int opcion=0;

        do{
            System.out.println("Seleccione la accion que desea realizar: ");
            System.out.println("1. Agregar un nuevo dispositivo");
            System.out.println("2. Mostrar todos los dispositivos");
            System.out.println("3. Cargar datos archivo dispositivos");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opcion: ");
            opcion=entrada.nextInt(); entrada.nextLine();
            switch (opcion)
            {
                case 1:
                    dispositivo.crearDatos();
                    System.out.println();
                    break;
                case 2:
                    for(int i=0;i<dispositivo.getDispositivos().size();i++)
                        dispositivo.getDispositivos().get(i).mostrarInformacion();
                    System.out.println();
                    break;
                case 3:
                    dispositivo.leerDispositivosDesdeArchivo("src/test/text/Devices.txt");
                    System.out.println("Datos cargados");
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    System.out.println();
            }

        }while(opcion!=0);
    }

    public static void menuUsuarios(User usuario) throws ParseException {
        Scanner entrada = new Scanner(System.in);
        int opcion=0;

        do{
            System.out.println("Seleccione la accion que desea realizar: ");
            System.out.println("1. Agregar un nuevo usuario");
            System.out.println("2. Mostrar todos los usuarios");
            System.out.println("3. Cargar datos archivo usuarios");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opcion: ");
            opcion=entrada.nextInt(); entrada.nextLine();
            switch (opcion)
            {
                case 1:
                    usuario.crearDatos();
                    System.out.println();
                    break;
                case 2:
                    for(int i=0;i<usuario.getUsers().size();i++)
                        usuario.getUsers().get(i).mostrarInformacion();
                    System.out.println();
                    break;
                case 3:
                    usuario.leerUsersDesdeArchivo("src/test/text/Users.txt");
                    System.out.println("Datos cargados");
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    System.out.println();
            }

        }while(opcion!=0);
    }


    public static void menuEmpresaElectricidad(Electricity_Company empresa)
    {
        Scanner entrada = new Scanner(System.in);
        int opcion=0;

        do{
            System.out.println("Seleccione la accion que desea realizar: ");
            System.out.println("1. Agregar un nueva empresa");
            System.out.println("2. Mostrar todas las empresas");
            System.out.println("3. Cargar datos archivo empresas");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opcion: ");
            opcion=entrada.nextInt(); entrada.nextLine();
            switch (opcion)
            {
                case 1:
                    empresa.crearDatos();
                    System.out.println();
                    break;
                case 2:
                    for(int i=0;i<empresa.getCompanies().size();i++)
                        empresa.getCompanies().get(i).mostrarInformacion();
                    System.out.println();
                    break;
                case 3:
                    empresa.leerDatosDesdeArchivo("src/test/text/ElectricityCompany.txt");
                    System.out.println("Datos cargados");
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    System.out.println();
            }

        }while(opcion!=0);
    }


    public static void menuEstadoDeContaminacion(Pollution_state estado)
    {
        Scanner entrada = new Scanner(System.in);
        int opcion=0;

        do{
            System.out.println("Seleccione la accion que desea realizar: ");
            System.out.println("1. Agregar un nuevo estado");
            System.out.println("2. Mostrar todos los estados");
            System.out.println("3. Cargar datos archivo estados");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opcion: ");
            opcion=entrada.nextInt(); entrada.nextLine();
            switch (opcion)
            {
                case 1:
                    estado.crearDatos();
                    System.out.println();
                    break;
                case 2:
                    for(int i=0;i<estado.getStates().size();i++)
                        estado.getStates().get(i).mostrarInformacion();
                    System.out.println();
                    break;
                case 3:
                    estado.leerStatesDesdeArchivo("src/test/text/Pollution.txt");
                    System.out.println("Datos cargados");
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    System.out.println();
            }

        }while(opcion!=0);
    }


    public static void menuReportes(Report reporte)
    {
        Scanner entrada = new Scanner(System.in);
        int opcion=0;

        do{
            System.out.println("Seleccione la accion que desea realizar: ");
            System.out.println("1. Agregar un nuevo reporte");
            System.out.println("2. Mostrar todas los reportes");
            System.out.println("3. Cargar datos archivo reportes");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opcion: ");
            opcion=entrada.nextInt();
            switch (opcion)
            {
                case 1:
                    reporte.crearDatos();
                    System.out.println();
                    break;
                case 2:
                    for(int i=0;i<reporte.getReports().size();i++)
                        reporte.getReports().get(i).mostrarInformacion();
                    System.out.println();
                    break;
                case 3:
                    reporte.leerReportsDesdeArchivo("src/test/text/Report.txt");
                    System.out.println("Datos cargados");
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    System.out.println();
            }

        }while(opcion!=0);
    }

    public  static  void menuHomes(Home home)
    {
        Scanner entrada = new Scanner(System.in);
        int opcion=0;

        do{
            System.out.println("Seleccione la accion que desea realizar: ");
            System.out.println("1. Agregar un nueva home");
            System.out.println("2. Mostrar todas las home");
            System.out.println("3. Cargar datos archivo home");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opcion: ");
            opcion=entrada.nextInt();
            switch (opcion)
            {
                case 1:
                    home.crearDatos();
                    System.out.println();
                    break;
                case 2:
                    for(int i=0;i<home.getHomes().size();i++)
                        home.getHomes().get(i).mostrarInformacion();
                    System.out.println();
                    break;
                case 3:
                    home.leerHomesDesdeArchivo("src/test/text/Home.txt");
                    System.out.println("Datos cargados");
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    System.out.println();
            }

        }while(opcion!=0);
    }

}
