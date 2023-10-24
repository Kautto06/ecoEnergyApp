package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
public class Report {
    private int id;
    private String idHome;
    private String idAdminHome;
    private double totalConsume;
    private double totalCost;

    private ArrayList<Report> reports= new ArrayList<>();

    public Report(int id, String idHome, String idAdminHome, double totalConsume, double totalCost) {
        this.id = id;
        this.idHome = idHome;
        this.idAdminHome = idAdminHome;
        this.totalConsume = totalConsume;
        this.totalCost = totalCost;
    }

    public Report() {
        this.id = 0;
        this.idHome = "";
        this.idAdminHome = "";
        this.totalConsume = 0;
        this.totalCost = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdHome(String idHome) {
        this.idHome = idHome;
    }

    public void setIdAdminHome(String idAdminHome) {
        this.idAdminHome = idAdminHome;
    }

    public void setTotalConsume(double totalConsume) {
        this.totalConsume = totalConsume;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getId() {
        return id;
    }

    public String getIdHome() {
        return idHome;
    }

    public String getIdAdminHome() {
        return idAdminHome;
    }

    public double getTotalConsume() {
        return totalConsume;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public void crearDatos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID: ");
        this.id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el ID de Home: ");
        this.idHome = scanner.nextLine();

        System.out.print("Ingrese el ID de Admin Home: ");
        this.idAdminHome = scanner.nextLine();

        System.out.print("Ingrese el total de consumo: ");
        this.totalConsume = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese el total de costo: ");
        this.totalCost = scanner.nextDouble();
        scanner.nextLine();

        this.reports.add(new Report(this.id,this.idHome,this.idAdminHome,this.totalConsume,this.totalCost));
        cargarDatosArchivo(new Report(this.id,this.idHome,this.idAdminHome,this.totalConsume,this.totalCost));
    }

    public String toString(){
        return id+", "+idHome+", "+idAdminHome+", "+totalConsume+", "+totalCost;
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("ID de la casa: " + idHome);
        System.out.println("ID del administrador de la casa: " + idAdminHome);
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
                System.out.println("ID de la casa: " + idHome);
                break;
            case 2:
                System.out.println("ID del administrador de la casa: " + idAdminHome);
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

    public void cargarDatosArchivo(Report newData){
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
        for (Report reporte : this.reports){
            if(reporte.getId()==idBuscado) return true;
        }

        return false;
    }

    public int eliminarReporte(int idEliminar){
        for (int i=0;i<this.reports.size();i++){
            if(this.reports.get(i).getId()==idEliminar){
                this.reports.remove(i);
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
                    Report report = new Report();
                    report.setId(Integer.parseInt(partes[0]));
                    report.setIdHome(partes[1]);
                    report.setIdAdminHome(partes[2]);
                    report.setTotalConsume(Double.parseDouble(partes[3]));
                    report.setTotalCost(Double.parseDouble(partes[4]));
                    reports.add(report);
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