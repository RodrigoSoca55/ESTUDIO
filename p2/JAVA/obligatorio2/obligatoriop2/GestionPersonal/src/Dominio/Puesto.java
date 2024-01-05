
package Dominio;

import java.io.Serializable;
import java.util.ArrayList;

public class Puesto implements Serializable{
    //Atributos
    private String nombrePuesto;
    private String modalidad;
    private ArrayList<Tematica> listaRequerimientos;
    //Costructor

    public Puesto(String nombrePuesto, String modalidad) {
        this.nombrePuesto = nombrePuesto;
        this.modalidad = modalidad;
        this.listaRequerimientos = new ArrayList();
    }
    
    //Metodos
    //setters y getters

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public void setListaRequerimientos(ArrayList<Tematica> listaRequerimientos) {
        this.listaRequerimientos = listaRequerimientos;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public String getModalidad() {
        return modalidad;
    }

    public ArrayList<Tematica> getListaRequerimientos() {
        return listaRequerimientos;
    }
    //otros metodos
    public ArrayList<Postulante> consultaParaPuestos(String puesto, int nivel){
        return null;
    }

    public void agregarRequerimiento(Tematica tem){
        this.getListaRequerimientos().add(tem);
    }
    
    @Override
    public String toString() {
        return this.nombrePuesto;
    }

}
