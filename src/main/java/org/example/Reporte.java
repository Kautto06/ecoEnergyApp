package org.example;

import java.util.ArrayList;

public class Reporte {

    private int id;
    private int idHome;
    private String idAdminHome;
    private String fecha;
    private ArrayList<Reporte> reportes =new ArrayList<>();

    public Reporte(int id, int idHome, String idAdminHome, String fecha) {
        this.id = id;
        this.idHome = idHome;
        this.idAdminHome = idAdminHome;
        this.fecha = fecha;
    }

    public Reporte(){
        this.id= 0;
        this.idHome=0;
        this.idAdminHome=null;
        this.fecha=null;
    }

    public ArrayList<Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(ArrayList<Reporte> reportes) {
        this.reportes = reportes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdHome(int idHome) {
        this.idHome = idHome;
    }

    public void setIdAdminHome(String idAdminHome) {
        this.idAdminHome = idAdminHome;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public int getIdHome() {
        return idHome;
    }

    public String getIdAdminHome() {
        return idAdminHome;
    }

    public String getFecha() {
        return fecha;
    }
}
