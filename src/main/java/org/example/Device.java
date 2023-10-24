package org.example;
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
        cargarDatosArchivo(new Device(this.id, this.deviceName, this.energyConsume, this.activeHours, this.priorityUsage, this.consumeClassify));
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
                setDeviceName(nuevoDeviceName);
                break;
            case 2:
                System.out.print("Nuevo consumo de energía: ");
                double nuevoEnergyConsume = scanner.nextDouble();
                setEnergyConsume(nuevoEnergyConsume);
                break;
            case 3:
                System.out.print("Nuevas horas activas: ");
                float nuevasActiveHours = scanner.nextFloat();
                setActiveHours(nuevasActiveHours);
                break;
            case 4:
                System.out.print("Nueva prioridad de uso (del 1 al 10): ");
                int nuevaPriorityUsage = scanner.nextInt();
                setPriorityUsage(nuevaPriorityUsage);
                break;
            case 5:
                System.out.print("Nueva clasificación de consumo (A-G): ");
                char nuevaConsumeClassify = scanner.next().charAt(0);
                setConsumeClassify(nuevaConsumeClassify);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void cargarDatosArchivo(Device newData){
        try{
            FileWriter fileWriter = new FileWriter("src/test/text/Devices.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n" + newData.toString());
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void leerDispositivosDesdeArchivo(String rutaArchivo) {
        try {
            FileReader fileReader = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(", ");

                if (partes.length == 6) {
                    Device dispositivo = new Device();
                    dispositivo.setId(Integer.parseInt(partes[0]));
                    dispositivo.setDeviceName(partes[1]);
                    dispositivo.setEnergyConsume(Double.parseDouble(partes[2]));
                    dispositivo.setActiveHours(Float.parseFloat(partes[3]));
                    dispositivo.setPriorityUsage(Integer.parseInt(partes[4]));
                    dispositivo.setConsumeClassify(partes[5].charAt(0));
                    dispositivos.add(dispositivo);
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
