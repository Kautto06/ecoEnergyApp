package org.example;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Electricity_Company {
    private String rut;
    private String nombre;
    private double costoBase;
    private double costoPorkW;
    private double limiteDekW;
    private double costoAdicionalPorkW;

    private ArrayList<Electricity_Company> companies= new ArrayList<>();

    public Electricity_Company(String rut, String nombre, double costoBase, double costoPorkW, double limiteDekW, double costoAnadidokW) {
        this.rut = rut;
        this.nombre = nombre;
        this.costoBase = costoBase;
        this.costoPorkW = costoPorkW;
        this.limiteDekW = limiteDekW;
        this.costoAdicionalPorkW = costoAnadidokW;
    }

    public Electricity_Company() {
        this.rut = null;
        this.nombre = null;
        this.costoBase = 0;
        this.costoPorkW = 0;
        this.limiteDekW = 0;
        this.costoAdicionalPorkW = 0;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public double getCostoPorkW() {
        return costoPorkW;
    }

    public void setCostoPorkW(double costoPorkW) {
        this.costoPorkW = costoPorkW;
    }

    public double getLimiteDekW() {
        return limiteDekW;
    }

    public void setLimiteDekW(double limiteDekW) {
        this.limiteDekW = limiteDekW;
    }

    public double getCostoAdicionalPorkW() {
        return costoAdicionalPorkW;
    }

    public void setCostoAdicionalPorkW(double costoAdicionalPorkW) {
        this.costoAdicionalPorkW = costoAdicionalPorkW;
    }

    public ArrayList<Electricity_Company> getCompanies() {
        return companies;
    }

    public void setCompanies(ArrayList<Electricity_Company> companies) {
        this.companies = companies;
    }

    public void crearDatos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el RUT: ");
        this.rut = scanner.nextLine();

        System.out.print("Ingrese el nombre: ");
        this.nombre = scanner.nextLine();

        System.out.print("Ingrese el costo base: ");
        this.costoBase = scanner.nextDouble();

        System.out.print("Ingrese el costo por kW: ");
        this.costoPorkW = scanner.nextDouble();

        System.out.print("Ingrese el límite de kW: ");
        this.limiteDekW = scanner.nextDouble();

        System.out.print("Ingrese el costo adicional por kW: ");
        this.costoAdicionalPorkW = scanner.nextDouble();

        this.companies.add(new Electricity_Company(this.rut,this.nombre,this.costoBase,this.costoPorkW,this.limiteDekW,this.costoAdicionalPorkW));
        cargarDatosArchivo(new Electricity_Company(this.rut,this.nombre,this.costoBase,this.costoPorkW,this.limiteDekW,this.costoAdicionalPorkW));
    }

    public int eliminarCompany(String rut){
        for(int i=0;i < this.companies.size(); i++){
            if(this.companies.get(i).getRut().equals(rut)){
                this.companies.remove(i);
                return 1;
            }
        }
        return 0;
    }

    public boolean buscarRut(String rut){
        for(int i=0;i < this.companies.size(); i++){
            if(this.companies.get(i).getRut().equals(rut)){
                return true;
            }
        }
        return false;
    }

    public void menuEliminar(){
        String rutEliminado;
        Scanner read = new Scanner(System.in);
        for(int i=0;i < this.companies.size(); i++){
            this.companies.get(i).mostrarInformacion();
        }
        do{
            System.out.println("Ingrese rut de la compania a eliminar");
            rutEliminado = read.nextLine();
        }while(!buscarRut(rutEliminado));

        eliminarCompany(rutEliminado);
        System.out.println("Se elimino correctamente la empresa");
    }

    public void mostrarInformacion() {
        System.out.println("RUT: " + rut);
        System.out.println("Nombre de la compañía: " + nombre);
        System.out.println("Costo base: " + costoBase);
        System.out.println("Costo por kW: " + costoPorkW);
        System.out.println("Límite de kW: " + limiteDekW);
        System.out.println("Costo adicional por kW excedido: " + costoAdicionalPorkW);
        System.out.println();
    }


    public void MenuMostrarElectricityCompany() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione qué elemento de la compañía eléctrica desea mostrar:");
        System.out.println("1. Nombre de la compañía");
        System.out.println("2. Costo base");
        System.out.println("3. Costo por kW");
        System.out.println("4. Límite de kW");
        System.out.println("5. Costo adicional por kW excedido");
        System.out.println("6. Mostrar toda la información");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Nombre de la compañía: " + nombre);
                break;
            case 2:
                System.out.println("Costo base: " + costoBase);
                break;
            case 3:
                System.out.println("Costo por kW: " + costoPorkW);
                break;
            case 4:
                System.out.println("Límite de kW: " + limiteDekW);
                break;
            case 5:
                System.out.println("Costo adicional por kW excedido: " + costoAdicionalPorkW);
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

        System.out.println("Seleccione qué dato de la compañía eléctrica desea actualizar:");
        System.out.println("1. Nombre");
        System.out.println("2. Costo base");
        System.out.println("3. Costo por kW");
        System.out.println("4. Límite de kW");
        System.out.println("5. Costo adicional por kW");
        int opcion = scanner.nextInt();

        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                setNombre(nuevoNombre);
                break;
            case 2:
                System.out.print("Nuevo costo base: ");
                double nuevoCostoBase = scanner.nextDouble();
                setCostoBase(nuevoCostoBase);
                break;
            case 3:
                System.out.print("Nuevo costo por kW: ");
                double nuevoCostoPorkW = scanner.nextDouble();
                setCostoPorkW(nuevoCostoPorkW);
                break;
            case 4:
                System.out.print("Nuevo límite de kW: ");
                double nuevoLimiteDekW = scanner.nextDouble();
                setLimiteDekW(nuevoLimiteDekW);
                break;
            case 5:
                System.out.print("Nuevo costo adicional por kW: ");
                double nuevoCostoAdicionalPorkW = scanner.nextDouble();
                setCostoAdicionalPorkW(nuevoCostoAdicionalPorkW);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public String toString(){
        return rut+", "+nombre+", "+costoBase+", "+costoPorkW+", "+limiteDekW+", "+costoAdicionalPorkW;
    }

    public void cargarDatosArchivo(Electricity_Company newData){
        try{
            FileWriter fileWriter = new FileWriter("src/test/text/ElectricityCompany.csv",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n" + newData.toString());
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
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
                if(i>=0)companies.add(new Electricity_Company(nextRecord[0],nextRecord[1],Double.valueOf(nextRecord[2]),Double.valueOf(nextRecord[3]),Double.valueOf(nextRecord[4]),Double.valueOf(nextRecord[5])));


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