package org.example;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Device {
    private int id;
    private String deviceName;
    private double energyConsume;
    private float activeHours;
    private int priorityUsage; //del 1-10
    private char consumeClassify; // A-G

    private ArrayList<Device> dispositivos = new ArrayList<>();

    public Device(int id, String deviceName, double energyConsume, float activesHours, int priorityUsage, char consumeClasify) {
        this.id = id;
        this.deviceName = deviceName;
        this.energyConsume = energyConsume;
        this.activeHours = activesHours;
        this.priorityUsage = priorityUsage;
        this.consumeClassify = consumeClasify;
    }

    public Device() {
        this.id = 0;
        this.deviceName = null;
        this.energyConsume = 0;
        this.activeHours = 0;
        this.priorityUsage = 0;
        this.consumeClassify = ' ';
    }

    public void setDispositivos(ArrayList<Device> dispositivos) {
        this.dispositivos = dispositivos;
    }

    public ArrayList<Device> getDispositivos() {
        return dispositivos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setEnergyConsume(double energyConsume) {
        this.energyConsume = energyConsume;
    }

    public void setActiveHours(float activeHours) {
        this.activeHours = activeHours;
    }

    public void setPriorityUsage(int priorityUsage) {
        this.priorityUsage = priorityUsage;
    }

    public void setConsumeClassify(char consumeClassify) {
        this.consumeClassify = consumeClassify;
    }

    public int getId() {
        return id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public double getEnergyConsume() {
        return energyConsume;
    }

    public float getActiveHours() {
        return activeHours;
    }

    public int getPriorityUsage() {
        return priorityUsage;
    }

    public char getConsumeClassify() {
        return consumeClassify;
    }


    public void crearDatos() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID: ");
        this.id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre del dispositivo: ");
        this.deviceName = scanner.nextLine();

        System.out.print("Ingrese el consumo de energía: ");
        this.energyConsume = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese las horas activas: ");
        this.activeHours = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Ingrese la prioridad de uso (1-10): ");
        this.priorityUsage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la clasificación de consumo (A-G): ");
        this.consumeClassify = scanner.next().charAt(0);

        this.dispositivos.add(new Device(this.id, this.deviceName, this.energyConsume, this.activeHours, this.priorityUsage, this.consumeClassify));
    }

    public int eliminarDevice(int id){
            for(int i=0; i < this.dispositivos.size();i++){
                if(this.dispositivos.get(i).getId() == id) {
                    this.dispositivos.remove(i);
                    return 1;
                }
            }
            return 0;
    }

    public String toString(){
        return id+", "+deviceName+", "+energyConsume+", "+activeHours+", "+priorityUsage + ", "+consumeClassify;
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre del dispositivo: " + deviceName);
        System.out.println("Consumo de energía: " + energyConsume);
        System.out.println("Horas activas: " + activeHours);
        System.out.println("Prioridad de uso: " + priorityUsage);
        System.out.println("Clasificación de consumo: " + consumeClassify);
    }

    public int buscarPosicionId(int id){
        for (int i=0;i<this.dispositivos.size();i++){
            if(this.dispositivos.get(i).getId()==id) return i;
        }
        return -1;
    }

    public int buscarId(int idEliminado){
        for(int i=0;i < this.dispositivos.size();i++){
            if(idEliminado == this.dispositivos.get(i).getId()){
                return this.dispositivos.get(i).getId();
            }
        }
        return 0;
    }

    public void menuEliminar(){
        int idEliminado, i;
        Scanner read = new Scanner(System.in);
        System.out.println("Lista de todos los Dispositivos");
        for (i = 0; i < this.dispositivos.size(); i++){
            System.out.println("ID: " + this.dispositivos.get(i).getId());
            System.out.println("Nombre del dispositivo: " + this.dispositivos.get(i).getDeviceName());
        }
        do {
            System.out.println("Ingrese el id del dispositivo que desea eliminar:");
            idEliminado = read.nextInt();
        }while(idEliminado != buscarId(idEliminado));
        eliminarDevice(idEliminado);
        System.out.println("Se elimino correctamente el dispositivo");
    }

    public void MostrarDevice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione qué elemento del dispositivo desea mostrar:");
        System.out.println("1. Nombre del dispositivo");
        System.out.println("2. Consumo de energía");
        System.out.println("3. Horas activas");
        System.out.println("4. Prioridad de uso");
        System.out.println("5. Clasificación de consumo");
        System.out.println("6. Mostrar todos los elementos");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Nombre del dispositivo: " + deviceName);
                break;
            case 2:
                System.out.println("Consumo de energía: " + energyConsume);
                break;
            case 3:
                System.out.println("Horas activas: " + activeHours);
                break;
            case 4:
                System.out.println("Prioridad de uso: " + priorityUsage);
                break;
            case 5:
                System.out.println("Clasificación de consumo: " + consumeClassify);
                break;
            case 6:
                mostrarInformacion();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
    public void MenuActualizarDatos() {
        Scanner scanner = new Scanner(System.in);

        if(this.dispositivos==null){
            System.out.println("No hay datos registrados");
            return;
        }

        int idActualizar, i;
        Scanner read = new Scanner(System.in);
        System.out.println("Lista de todos los Dispositivos");
        for (i = 0; i < this.dispositivos.size(); i++){
            System.out.println("ID: " + this.dispositivos.get(i).getId());
            System.out.println("Nombre del dispositivo: " + this.dispositivos.get(i).getDeviceName());
        }
        do {
            System.out.println("Ingrese el id del dispositivo que desea actualizar:");
            idActualizar = read.nextInt();
        }while(idActualizar != buscarId(idActualizar));

        i=buscarPosicionId(idActualizar);

        System.out.println();


        System.out.println("Seleccione qué dato del dispositivo desea actualizar:");
        System.out.println("1. Nombre del dispositivo");
        System.out.println("2. Consumo de energía");
        System.out.println("3. Horas activas");
        System.out.println("4. Prioridad de uso (del 1 al 10)");
        System.out.println("5. Clasificación de consumo (A-G)");
        int opcion = scanner.nextInt();

        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Nuevo nombre del dispositivo: ");
                String nuevoDeviceName = scanner.nextLine();
                this.dispositivos.get(i).setDeviceName(nuevoDeviceName);
                break;
            case 2:
                System.out.print("Nuevo consumo de energía: ");
                double nuevoEnergyConsume = scanner.nextDouble();
                this.dispositivos.get(i).setEnergyConsume(nuevoEnergyConsume);
                break;
            case 3:
                System.out.print("Nuevas horas activas: ");
                float nuevasActiveHours = scanner.nextFloat();
                this.dispositivos.get(i).setActiveHours(nuevasActiveHours);
                break;
            case 4:
                System.out.print("Nueva prioridad de uso (del 1 al 10): ");
                int nuevaPriorityUsage = scanner.nextInt();
                this.dispositivos.get(i).setPriorityUsage(nuevaPriorityUsage);
                break;
            case 5:
                System.out.print("Nueva clasificación de consumo (A-G): ");
                char nuevaConsumeClassify = scanner.next().charAt(0);
                this.dispositivos.get(i).setConsumeClassify(nuevaConsumeClassify);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void LeerDesdeCsv(String rutaArchivo) throws CsvValidationException {
        File file = new File(rutaArchivo);
        try {
            FileReader inputfile = new FileReader(file);
            CSVReader reader = new CSVReader(inputfile);

            String[] nextRecord;

            // we are going to read data line by line
            int i=0;
            while ((nextRecord = reader.readNext()) != null) {

                //System.out.println(nextRecord[4]);
                if(i>=0)dispositivos.add(new Device(Integer.valueOf(nextRecord[0]),nextRecord[1],Double.valueOf(nextRecord[2]),Float.valueOf(nextRecord[3]),Integer.valueOf(nextRecord[4]),nextRecord[5].charAt(0)));


                for (String cell : nextRecord) {

                    System.out.print(cell + "\t");
                }
                i++;
                System.out.println();
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
