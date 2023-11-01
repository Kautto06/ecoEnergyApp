package org.example;

import com.opencsv.exceptions.CsvValidationException;

import java.text.ParseException;
import java.util.Scanner;


public class Menus {

    public static  void menuSeleccionClases() throws ParseException, CsvValidationException {
        Scanner entrada = new Scanner(System.in);
        int opcion=0;

        Device dispositvo = new Device();
        User usuarios=new User();
        Electricity_Company empresa=new Electricity_Company();
        Pollution_state estado=new Pollution_state();
        Consume_state reporte = new Consume_state();
        Home home =new Home();

        do{
            System.out.println("Seleccione el dato con el que desea trabajar: ");
            System.out.println("1. Dispostivos");
            System.out.println("2. Usuarios");
            System.out.println("3. Empresa de electricidad");
            System.out.println("4. Reportes de contaminacion");
            System.out.println("5. Homes");
            System.out.println("6. Reportes de consumo");
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
                    break;
                case 6:
                    menuConsumeState(reporte);
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

    public static void menuDispositivos(Device dispositivo) throws ParseException, CsvValidationException {
        System.out.println();
        Scanner entrada = new Scanner(System.in);
        int opcion=0;

        do{
            System.out.println("Seleccione la accion que desea realizar: ");
            System.out.println("1. Agregar un nuevo dispositivo");
            System.out.println("2. Mostrar todos los dispositivos");
            System.out.println("3. Cargar datos archivo dispositivos");
            System.out.println("4. Eliminar un dispositivo");
            System.out.println("5. Actualizar datos de un dispositivo");
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
                    dispositivo.LeerDesdeCsv("src/test/text/Devices.csv");
                    System.out.println("Datos cargados");
                    System.out.println();
                    break;
                case 4:
                    dispositivo.MenuActualizarDatos();
                    System.out.println("Datos actualizados");
                    System.out.println();
                    break;
                case 5:
                    dispositivo.menuEliminar();
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



    public static void menuUsuarios(User usuario) throws ParseException, CsvValidationException {
        Scanner entrada = new Scanner(System.in);
        int opcion=0;

        do{
            System.out.println("Seleccione la accion que desea realizar: ");
            System.out.println("1. Agregar un nuevo usuario");
            System.out.println("2. Mostrar todos los usuarios");
            System.out.println("3. Cargar datos archivo usuarios");
            System.out.println("4. Eliminar un usuario");
            System.out.println("5. Actualizar un usuario");
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
                    for(int i=0;i<usuario.getUsers().size();i++){
                        usuario.getUsers().get(i).mostrarInformacion();
                    }
                    System.out.println();
                    break;
                case 3:
                    usuario.LeerDesdeCsv("src/test/text/Users.csv");
                    System.out.println("Datos cargados");
                    System.out.println();
                    break;
                case 4:
                    usuario.menuEliminarUsuarios();
                    System.out.println();
                    break;
                case 5:
                    usuario.MenuActualizarDatos();
                    System.out.println("Datos actualizados");
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


    public static void menuEmpresaElectricidad(Electricity_Company empresa) throws ParseException, CsvValidationException{
        Scanner entrada = new Scanner(System.in);
        int opcion=0;

        do{
            System.out.println("Seleccione la accion que desea realizar: ");
            System.out.println("1. Agregar un nueva empresa");
            System.out.println("2. Mostrar todas las empresas");
            System.out.println("3. Cargar datos archivo empresas");
            System.out.println("4. Eliminar una empresa");
            System.out.println("5. Modificar una empresa");
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
                    empresa.LeerDesdeCsv("src/test/text/Electricity_Company.csv");
                    System.out.println("Datos cargados");
                    System.out.println();
                    break;
                case 4:
                    empresa.menuEliminar();
                    System.out.println();
                    break;
                case 5:
                    empresa.MenuActualizarDatos();
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


    public static void menuEstadoDeContaminacion(Pollution_state estado) throws ParseException, CsvValidationException
    {
        Scanner entrada = new Scanner(System.in);
        int opcion=0;

        do{
            System.out.println("Seleccione la accion que desea realizar: ");
            System.out.println("1. Agregar un nuevo reporte de contaminacion");
            System.out.println("2. Mostrar todos los reportes de contaminacion");
            System.out.println("3. Cargar datos archivo reporte contaminacion");
            System.out.println("4. Eliminar reporte de contaminacion");
            System.out.println("5. Actualizar un menu de estado.");
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
                    for(int i=0;i<estado.getPollutionStates().size();i++)
                        estado.getPollutionStates().get(i).mostrarInformacion();
                    System.out.println();
                    break;
                case 3:
                    estado.LeerDesdeCsv("src/test/text/PollutionState.csv");
                    System.out.println("Datos cargados");
                    System.out.println();
                    break;
                case 4:
                    estado.menuEliminarPollution();
                    break;
                case 5:
                    estado.MenuActualizarDatos();
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



    public static void menuConsumeState(Consume_state reporte) throws ParseException, CsvValidationException
    {
        Scanner entrada = new Scanner(System.in);
        int opcion=0;

        do{
            System.out.println("Seleccione la accion que desea realizar: ");
            System.out.println("1. Agregar un nuevo reporte de consumo");
            System.out.println("2. Mostrar todas los reportes de consumo");
            System.out.println("3. Cargar datos archivo reportes de consumo");
            System.out.println("4. Eliminar un reporte de consumo");
            System.out.println("5. Actualizar un reporte de consumo");
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
                    reporte.LeerDesdeCsv("src/test/text/ConsumeState.csv");
                    System.out.println("Datos cargados");
                    System.out.println();
                    break;
                case 4:
                    reporte.menuEliminarReporte(reporte);
                    System.out.println();
                    break;

                case 5:
                    reporte.MenuActualizarDatos();
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

    public  static  void menuHomes(Home home) throws ParseException, CsvValidationException
    {
        Scanner entrada = new Scanner(System.in);
        int opcion=0;

        do{
            System.out.println("Seleccione la accion que desea realizar: ");
            System.out.println("1. Agregar un nueva home");
            System.out.println("2. Mostrar todas las home");
            System.out.println("3. Cargar datos archivo home");
            System.out.println("4. Eliminar una home");
            System.out.println("5. Actualizar un home");
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
                    home.LeerDesdeCsv("src/test/text/Home.csv");
                    System.out.println("Datos cargados");
                    System.out.println();
                    break;
                case 4:
                    home.MenuEliminarHome();
                    break;
                case 5:
                    home.MenuActualizarDatos();
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
