package Models;
import Controllers.ConsumeStateController;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Consume_state extends Reporte{
    private double totalConsume;
    private double totalCost;
    private ArrayList<Consume_state> consumestates = new ArrayList<>();
    public ConsumeStateController controlador= new ConsumeStateController();

    public Consume_state(int id, int idHome, String idAdminHome, String fecha, double totalConsume, double totalCost) {
        super(id,idHome,idAdminHome,fecha);
        this.totalConsume = totalConsume;
        this.totalCost = totalCost;
    }

    public Consume_state() {
        super();
        this.totalConsume = 0;
        this.totalCost = 0;
    }

    public void setTotalConsume(double totalConsume) {
        this.totalConsume = totalConsume;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalConsume() {
        return totalConsume;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public ArrayList<Consume_state> getReports() {
        return consumestates;
    }

    public void setReports(ArrayList<Consume_state> consumestates) {
        this.consumestates = consumestates;
    }

    public void crearDatos() {
        Scanner scanner = new Scanner(System.in);
        int id,idHome;
        String idAdminHome,fecha;

        System.out.print("Ingrese el ID: ");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el ID de Home: ");
        idHome = scanner.nextInt(); scanner.nextLine();

        System.out.print("Ingrese el ID de Admin Home: ");
        idAdminHome = scanner.nextLine();
        
        System.out.print("Ingrese la fecha del reporte (dd/mm/yy): ");
        fecha= scanner.nextLine();

        System.out.print("Ingrese el total de consumo: ");
        this.totalConsume = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese el total de costo: ");
        this.totalCost = scanner.nextDouble(); scanner.nextLine();
        scanner.nextLine();

        this.consumestates.add(new Consume_state(id,idHome,idAdminHome,fecha,this.totalConsume,this.totalCost));
        controlador.agregarConsumeStateABD(new Consume_state(id,idHome,idAdminHome,fecha,this.totalConsume,this.totalCost));
    }

    public String toString(){
        return getId()+", "+getIdHome()+", "+getIdAdminHome()+", "+ getFecha() +", "+totalConsume+", "+totalCost;
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + getId());
        System.out.println("ID de la casa: " + getIdHome());
        System.out.println("ID del administrador de la casa: " + getIdAdminHome());
        System.out.println("Fecha reporte: "+getFecha());
        System.out.println("Total de consumo: " + totalConsume);
        System.out.println("Total de costo: " + totalCost);
        System.out.println();
    }


    public void MenuMostrarReport() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione qué elemento del informe desea mostrar:");
        System.out.println("1. ID de la casa");
        System.out.println("2. ID del administrador de la casa");
        System.out.println("3. Total de consumo");
        System.out.println("4. Total de costo");
        System.out.println("5. Mostrar toda la información");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("ID de la casa: " + getId());
                break;
            case 2:
                System.out.println("ID del administrador de la casa: " + getIdAdminHome());
                break;
            case 3:
                System.out.println("Total de consumo: " + totalConsume);
                break;
            case 4:
                System.out.println("Total de costo: " + totalCost);
                break;
            case 5:
                mostrarInformacion();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public int buscarPosicionId(int id){
        for (int i=0;i<this.consumestates.size();i++){
            if(this.consumestates.get(i).getId()==id) return i;
        }
        return -1;
    }

    public void MenuActualizarDatos() {
        Scanner scanner = new Scanner(System.in);

        if(this.consumestates==null){
            System.out.println("No hay datos registrados");
            return;
        }

        Scanner entrada = new Scanner(System.in);
        int idActualizar,index;
        if(this.consumestates==null){
            System.out.println("No hay reportes en el sistema");
            return;
        }

        do {
            for(int i=0;i<this.consumestates.size();i++)
                this.consumestates.get(i).mostrarInformacion();
            System.out.println();
            System.out.print("Ingrese el ID del reporte que desea actualizar: ");
            idActualizar= entrada.nextInt();
            System.out.println();
        }while(!buscarReporte(idActualizar));

        index=buscarPosicionId(idActualizar);

        System.out.println();

        System.out.println("Seleccione qué dato del informe desea actualizar:");
        System.out.println("1. ID del administrador de la casa");
        System.out.println("2. Total de consumo");
        System.out.println("3. Total de costo");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Nuevo ID del administrador de la casa: ");
                String nuevoIdAdminHome = scanner.next();
                this.consumestates.get(index).setIdAdminHome(nuevoIdAdminHome);
                break;
            case 2:
                System.out.print("Nuevo total de consumo: ");
                double nuevoTotalConsume = scanner.nextDouble();
                this.consumestates.get(index).setTotalConsume(nuevoTotalConsume);
                break;
            case 3:
                System.out.print("Nuevo total de costo: ");
                double nuevoTotalCosto = scanner.nextDouble();
                this.consumestates.get(index).setTotalCost(nuevoTotalCosto);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        controlador.actualizarConsumeStateEnBD(this.consumestates.get(index));
    }

    public boolean buscarReporte(int idBuscado){
        for (Consume_state reporte : this.consumestates){
            if(reporte.getId()==idBuscado) return true;
        }

        return false;
    }

    public Consume_state retornarConsumeState(int idBuscado){
        for (Consume_state reporte : this.consumestates){
            if(reporte.getId()==idBuscado) return reporte;
        }

        return null;
    }

    public int eliminarReporte(int idEliminar){
        for (int i = 0; i<this.consumestates.size(); i++){
            if(this.consumestates.get(i).getId()==idEliminar){
                this.consumestates.remove(i);
                return 1;
            }
        }
        return 0;
    }
    public void menuEliminarReporte(Consume_state reporte){

        Scanner entrada = new Scanner(System.in);
        int idAEliminar;
        Consume_state AEliminar = new Consume_state();
        if(reporte==null){
            System.out.println("No hay reportes en el sistema");
            return;
        }

        do {
            for(int i=0;i<reporte.getReports().size();i++)
                reporte.getReports().get(i).mostrarInformacion();
            System.out.println();
            System.out.print("Ingrese el ID del reporte que desea eliminar: ");
            idAEliminar= entrada.nextInt();
            System.out.println();
        }while(!reporte.buscarReporte(idAEliminar));

        AEliminar= reporte.retornarConsumeState(idAEliminar);

        controlador.eliminarEstadoContaminacionDeBD(AEliminar);

        reporte.eliminarReporte(idAEliminar);
        System.out.println("Se elimino el reporte correctamente");
    }

    public void leerDesdeBDConsumeStates() {
        controlador.obtenerTodosLosConsumeStatesDeBD(this);
    }



}