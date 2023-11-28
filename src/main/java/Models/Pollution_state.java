package Models;
import Controllers.PollutionStateController;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import  java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controllers.PollutionStateController.*;


public class Pollution_state extends Reporte{
    private double Total_Consume;
    private double Consume_State;
    private String Message;

    private ArrayList<Pollution_state> pollutionStates= new ArrayList<>();
    public PollutionStateController controlador = new PollutionStateController();

    public Pollution_state(int id,int idHome,String idAdminHome,String fecha, double Total_Consume, double Consume_State, String Message) {
        super(id,idHome,idAdminHome,fecha);
        this.Total_Consume = Total_Consume;
        this.Consume_State = Consume_State;
        this.Message = Message;
    }

    public Pollution_state() {
        super();
        this.Total_Consume = 0;
        this.Consume_State = 0;
        this.Message = null;
    }

    public ArrayList<Pollution_state> getPollutionStates() {
        return pollutionStates;
    }

    public void setPollutionStates(ArrayList<Pollution_state> states) {
        this.pollutionStates = states;
    }


    public double getTotal_Consume() {
        return Total_Consume;
    }

    public void setTotal_Consume(double Total_Consume) {
        this.Total_Consume = Total_Consume;
    }

    public double getConsume_State() {
        return Consume_State;
    }

    public void setConsume_State(double Consume_State) {
        this.Consume_State = Consume_State;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void crearDatos() {
        Scanner scanner = new Scanner(System.in);
        int id, idHome;
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
        this.Total_Consume = scanner.nextDouble();

        System.out.print("Ingrese el estado de consumo: ");
        this.Consume_State = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese un mensaje: ");
        this.Message = scanner.nextLine();

        this.pollutionStates.add(new Pollution_state(id,idHome,idAdminHome,fecha,this.Total_Consume,this.Consume_State,this.Message));
        controlador.agregarPollutionStateABD(new Pollution_state(id,idHome,idAdminHome,fecha,this.Total_Consume,this.Consume_State,this.Message));
    }

    public int eliminarReporte(int id){
        for(int i=0;i < this.pollutionStates.size(); i++){
            if(this.pollutionStates.get(i).getId() == id){
                this.pollutionStates.remove(i);
                return 1;
            }
        }
        return 0;
    }

    public String toString(){
        return getId()+", "+getIdHome()+", "+getIdAdminHome()+", "+ getFecha() +", "+Total_Consume+", "+Consume_State+", "+Message;
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + getId());
        System.out.println("ID de la casa: " + getIdHome());
        System.out.println("ID del administrador de la casa: " + getIdAdminHome());
        System.out.println("Fecha reporte: "+getFecha());
        System.out.println("Total de consumo: " + Total_Consume);
        System.out.println("Consumo actual: " + Consume_State);
        System.out.println("Mensaje: " + Message);
        System.out.println();
    }
    public boolean buscarReporte(int idEliminado){
        for(int i=0;i < this.pollutionStates.size();i++){
            if(idEliminado == this.pollutionStates.get(i).getId()){
                return true;
            }
        }
        return false;
    }
    public Pollution_state EncontrarReporte(int idBuscar)
    {
        for(Pollution_state state:pollutionStates)
            if(state.getId()==idBuscar)
                return state;
        return null;
    }

    public void menuEliminarPollution(){
        int idEliminado;
        Scanner read = new Scanner(System.in);
        for(int i=0;i < this.pollutionStates.size();i++){
            this.pollutionStates.get(i).mostrarInformacion();
        }
        do{
            System.out.println("Ingrese ID del elemento a eliminar");
            idEliminado = read.nextInt();
        }while(!buscarReporte(idEliminado));
        if(buscarReporte(idEliminado) == true){
            controlador.eliminarEstadoContaminacionDeBD(EncontrarReporte(idEliminado));
            eliminarReporte(idEliminado);
        }
    }

    // Método para mostrar un menú y permitir al usuario seleccionar qué elemento mostrar
    public void MenuMostrarConsume() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione qué elemento del consumo desea mostrar:");
        System.out.println("1. Total de consumo");
        System.out.println("2. Consumo actual");
        System.out.println("3. Mensaje");
        System.out.println("4. Mostrar toda la información");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Total de consumo: " + Total_Consume);
                break;
            case 2:
                System.out.println("Consumo actual: " + Consume_State);
                break;
            case 3:
                System.out.println("Mensaje: " + Message);
                break;
            case 4:
                mostrarInformacion();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public int buscarPosicionId(int id){
        for (int i=0;i<this.pollutionStates.size();i++){
            if(this.pollutionStates.get(i).getId()==id) return i;
        }
        return -1;
    }
    
    public void MenuActualizarDatos() {
        Scanner scanner = new Scanner(System.in);

        if(this.pollutionStates==null){
            System.out.println("No hay datos registrados");
            return;
        }

        int idActualizar,index;
        Scanner read = new Scanner(System.in);
        for(int i=0;i < this.pollutionStates.size();i++){
            this.pollutionStates.get(i).mostrarInformacion();
        }
        do{
            System.out.println("Ingrese ID del elemento a actualizar");
            idActualizar = read.nextInt();
        }while(!buscarReporte(idActualizar));

        System.out.println("Seleccione qué dato del estado de contaminación desea actualizar:");
        System.out.println("1. Total de consumo");
        System.out.println("2. Consumo actual");
        System.out.println("3. Mensaje");
        int opcion = scanner.nextInt();
        
        index=buscarPosicionId(idActualizar);
        
        scanner.nextLine(); // Consumir la línea en blanco después de nextInt()

        switch (opcion) {
            case 1:
                System.out.print("Nuevo total de consumo: ");
                double nuevoTotalConsume = scanner.nextDouble();
                this.pollutionStates.get(index).setTotal_Consume(nuevoTotalConsume);
                controlador.actualizarEstadoContaminacionEnBD(this.pollutionStates.get(index));
                break;
            case 2:
                System.out.print("Nuevo consumo actual: ");
                double nuevoConsumeState = scanner.nextDouble();
                this.pollutionStates.get(index).setConsume_State(nuevoConsumeState);
                controlador.actualizarEstadoContaminacionEnBD(this.pollutionStates.get(index));
                break;
            case 3:
                System.out.print("Nuevo mensaje: ");
                String nuevoMensaje = scanner.nextLine();
                this.pollutionStates.get(index).setMessage(nuevoMensaje);
                controlador.actualizarEstadoContaminacionEnBD(this.pollutionStates.get(index));
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void leerDesdeBDPollutionStates() {
        controlador.obtenerTodosLosEstadosContaminacionDeBD(this);
    }

}

