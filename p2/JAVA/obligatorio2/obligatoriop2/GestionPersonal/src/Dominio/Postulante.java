
package Dominio;

import Exceptions.Exception_ParseNumero;
import Exceptions.Exception_StringVacio;
import java.util.ArrayList;
import Serializacion.*;

import java.io.Serializable;

public class Postulante extends Persona implements Serializable, Comparable<Postulante>{

    //Atributos


    private int telefono;
    private String mail;
    private String link;
    private String formato;
    private ArrayList<Experiencia> listaExperiencia;
    private ArrayList<Entrevista> listaEntrevistas;
    //constructor

    public Postulante(String nombre, int id, String direccion, int telefono, String mail, String link, String formato) {
        super(nombre, id, direccion);
        this.telefono = telefono;
        this.mail = mail;
        this.link = link;
        this.formato = formato;
        this.listaExperiencia = new ArrayList<Experiencia>();
        this.listaEntrevistas = new ArrayList<Entrevista>();

    }

    public ArrayList<Entrevista> getListaEntrevistas() {
        return listaEntrevistas;
    }

    public Postulante(String nombre, String id, String direccion, String telefono, String mail, String link, String formato) throws Exception_StringVacio, Exception_ParseNumero {
        super(nombre, id, direccion);
        this.telefono = Integer.parseInt(telefono);
        this.mail = mail;
        this.link = link;
        this.formato = formato;
        this.listaExperiencia = new ArrayList<Experiencia>();
    }

    //metodos
    public int getTelefono() {
        return telefono;
    }

    public ArrayList<Entrevista> getListaEntrevistasP() {
        return listaEntrevistas;
    }

    public void setListaEntrevistasP(ArrayList<Entrevista> listaEntrevistas) {
        this.listaEntrevistas = listaEntrevistas;
    }

    public ArrayList<Experiencia> getListaExperiencia() {
        return listaExperiencia;
    }

    public void setListaExperiencia(ArrayList<Experiencia> listaExperiencia) {
        this.listaExperiencia = listaExperiencia;
    }

    public void agregarExperiencia(Experiencia e) {
        this.getListaExperiencia().add(e);
    }

    public String getMail() {
        return mail;
    }

    public String getLink() {
        return link;
    }

    public String getFormato() {
        return formato;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    public int getUltimoPuntajeEntrevista(){
       ArrayList<Entrevista> listaEntrevista = this.getListaEntrevistas();
       int ultima = listaEntrevista.size()-1;
       int puntaje = listaEntrevista.get(ultima).getPuntaje();
       return puntaje;
    }
    public void grabarPostulante(String pathArchivo) {
        ArchivoGrabacion agDatos = new ArchivoGrabacion(pathArchivo, true);
        String lineaNombre = this.getNombre();
        String lineaCedula = "" + this.getId();
        String lineaMail = this.getMail();
        agDatos.grabarLinea(lineaNombre);
        agDatos.grabarLinea(lineaCedula);
        agDatos.grabarLinea(lineaMail);
        agDatos.cerrar();
    }
    
    public boolean postulanteTieneExperienciaMayorNivel(int nivel,Tematica tematica){
       ArrayList<Experiencia> listaExperiencia = this.getListaExperiencia() ;
       Boolean contiene = false;
       for (int i=0;i<listaExperiencia.size()&&!contiene;i++){
           Experiencia experiencia = listaExperiencia.get(i);
          String nombreExp =experiencia.getExperiencia();
          int nivelExp = experiencia.getNivel();
           if (nombreExp.equals(tematica.getNombre())&&nivelExp>nivel){
               contiene = true;
           }
       }
       return contiene ;
    }
    
    @Override
    public String toString() {
        return this.getNombre() + "(" + this.getId() + ')';
    }

    @Override
    public int compareTo(Postulante pos) {
        return this.getId() - pos.getId();
    }
    
}
