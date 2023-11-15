package Models;

import java.util.ArrayList;

public abstract class Reporte{

    private int id;
    private int idHome;
    private String idAdminHome;
    private String fecha;

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


    public abstract void crearDatos();

    public abstract void mostrarInformacion();

    public abstract boolean buscarReporte(int id);

    public abstract int eliminarReporte(int id);
}
