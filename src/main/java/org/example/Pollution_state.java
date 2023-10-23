package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import  java.util.Scanner;

public class Pollution_state {
    private int id;
    private double Total_Consume;
    private double Consume_State;
    private String Message;

    private ArrayList<Pollution_state> states= new ArrayList<>();

    public Pollution_state(int id, double Total_Consume, double Consume_State, String Message) {
        this.id = id;
        this.Total_Consume = Total_Consume;
        this.Consume_State = Consume_State;
        this.Message = Message;
    }

    public Pollution_state() {
        this.id = 0;
        this.Total_Consume = 0;
        this.Consume_State = 0;
        this.Message = null;
    }

    public ArrayList<Pollution_state> getStates() {
        return states;
    }

    public void setStates(ArrayList<Pollution_state> states) {
        this.states = states;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        System.out.print("Ingrese el ID: ");
        this.id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el total de consumo: ");
        this.Total_Consume = scanner.nextDouble();

        System.out.print("Ingrese el estado de consumo: ");
        this.Consume_State = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese un mensaje: ");
        this.Message = scanner.nextLine();

        this.states.add(new Pollution_state(this.id,this.Total_Consume,this.Consume_State,this.Message));
        cargarDatosArchivo(new Pollution_state(this.id,this.Total_Consume,this.Consume_State,this.Message));
    }

    public String toString(){
        return id+", "+Total_Consume+", "+Consume_State+", "+Message;
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Total de consumo: " + Total_Consume);
        System.out.println("Consumo actual: " + Consume_State);
        System.out.println("Mensaje: " + Message);
        System.out.println();
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
                    states.add(state);
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

