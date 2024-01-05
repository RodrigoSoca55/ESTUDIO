
package Dominio;

import java.io.Serializable;


public class Entrevista implements Comparable<Entrevista>, Serializable{
    //Atributos
    private Evaluador evaluador;
    private Postulante postulante;
    private String comentarios;
    private int puntaje;
    private int id;
        
    //constructor
    public Entrevista(Evaluador evaluador, Postulante postulante, int puntaje, int id, String comen) {    
        this.evaluador = evaluador;
        this.postulante = postulante;
        this.puntaje = puntaje; 
        this.comentarios = comen;
        this.id = id;
        

    }
    //Getter y setters
    public Evaluador getEvaluador() {
        return evaluador;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public String getComentarios() {
        return comentarios;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getId() {
        return id;
    }

    public void setEvaluador(Evaluador evaluador) {
        this.evaluador = evaluador;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setId(int id) {
        this.id = id+1;
    }

    @Override
    public int compareTo(Entrevista ent) {
        return this.id - ent.id;
    }
    
}
