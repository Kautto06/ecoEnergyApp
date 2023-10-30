package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import  java.util.Scanner;

public class Pollution_state extends Reporte{
    private double Total_Consume;
    private double Consume_State;
    private String Message;

    private ArrayList<Pollution_state> pollutionStates= new ArrayList<>();

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
        ArrayList<Reporte> aux =getReportes();


        System.out.print("Ingrese el ID: ");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el ID de Home: ");
        idHome = scanner.nextInt();

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

        aux.add(new Reporte(id,idHome,idAdminHome,fecha));
        setReportes(aux);
        this.pollutionStates.add(new Pollution_state(id,idHome,idAdminHome,fecha,this.Total_Consume,this.Consume_State,this.Message));
        cargarDatosArchivo(new Pollution_state(id,idHome,idAdminHome,fecha,this.Total_Consume,this.Consume_State,this.Message));
    }

    public int eliminarState(int id){
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
    public int buscarId(int idEliminado){
        for(int i=0;i < this.pollutionStates.size();i++){
            if(idEliminado == this.pollutionStates.get(i).getId()){
                return this.pollutionStates.get(i).getId();
            }
        }
        return 0;
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
        }while(buscarId(idEliminado) != idEliminado);
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
    public void MenuActualizarDatos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione qué dato del estado de contaminación desea actualizar:");
        System.out.println("1. Total de consumo");
        System.out.println("2. Consumo actual");
        System.out.println("3. Mensaje");
        int opcion = scanner.nextInt();

        scanner.nextLine(); // Consumir la línea en blanco después de nextInt()

        switch (opcion) {
            case 1:
                System.out.print("Nuevo total de consumo: ");
                double nuevoTotalConsume = scanner.nextDouble();
                setTotal_Consume(nuevoTotalConsume);
                break;
            case 2:
                System.out.print("Nuevo consumo actual: ");
                double nuevoConsumeState = scanner.nextDouble();
                setConsume_State(nuevoConsumeState);
                break;
            case 3:
                System.out.print("Nuevo mensaje: ");
                String nuevoMensaje = scanner.nextLine();
                setMessage(nuevoMensaje);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void cargarDatosArchivo(Pollution_state newData){
        try{
            FileWriter fileWriter = new FileWriter("src/test/text/Pollution.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n" + newData.toString());
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public  void leerStatesDesdeArchivo(String rutaArchivo) {

        try {
            FileReader fileReader = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(", ");

                if (partes.length == 4) {
                    Pollution_state state = new Pollution_state();
                    state.setId(Integer.parseInt(partes[0]));
                    state.setTotal_Consume(Double.parseDouble(partes[1]));
                    state.setConsume_State(Double.parseDouble(partes[2]));
                    state.setMessage(partes[3]);
                    pollutionStates.add(state);
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

