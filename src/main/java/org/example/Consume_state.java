package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Consume_state extends Reporte{
    private double totalConsume;
    private double totalCost;
    private ArrayList<Consume_state> consumestates = new ArrayList<>();

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
        this.totalConsume = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese el total de costo: ");
        this.totalCost = scanner.nextDouble();
        scanner.nextLine();


        aux.add(new Reporte(id,idHome,idAdminHome,fecha));
        setReportes(aux);
        this.consumestates.add(new Consume_state(id,idHome,idAdminHome,fecha,this.totalConsume,this.totalCost));
        cargarDatosArchivo(new Consume_state(id,idHome,idAdminHome,fecha,this.totalConsume,this.totalCost));
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

    public void MenuActualizarDatos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione qué dato del informe desea actualizar:");
        System.out.println("1. ID del administrador de la casa");
        System.out.println("2. Total de consumo");
        System.out.println("3. Total de costo");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Nuevo ID del administrador de la casa: ");
                String nuevoIdAdminHome = scanner.next();
                setIdAdminHome(nuevoIdAdminHome);
                break;
            case 2:
                System.out.print("Nuevo total de consumo: ");
                double nuevoTotalConsume = scanner.nextDouble();
                setTotalConsume(nuevoTotalConsume);
                break;
            case 3:
                System.out.print("Nuevo total de costo: ");
                double nuevoTotalCosto = scanner.nextDouble();
                setTotalCost(nuevoTotalCosto);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void cargarDatosArchivo(Consume_state newData){
        try{
            FileWriter fileWriter = new FileWriter("src/test/text/Report.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n" + newData.toString());
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean buscarReporte(int idBuscado){
        for (Consume_state reporte : this.consumestates){
            if(reporte.getId()==idBuscado) return true;
        }

        return false;
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


    public void leerReportsDesdeArchivo(String rutaArchivo) {

        try {
            FileReader fileReader = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(", ");

                if (partes.length == 5) {
                    Consume_state consumestate = new Consume_state();
                    consumestate.setId(Integer.parseInt(partes[0]));
                    consumestate.setIdHome(Integer.parseInt(partes[1]));
                    consumestate.setIdAdminHome(partes[2]);
                    consumestate.setTotalConsume(Double.parseDouble(partes[3]));
                    consumestate.setTotalCost(Double.parseDouble(partes[4]));
                    consumestates.add(consumestate);
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