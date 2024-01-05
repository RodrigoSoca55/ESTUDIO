
package Dominio;

import java.io.Serializable;


public class Experiencia implements Serializable {
    //atributos
    private int nivel;
    private String experiencia;
    //construcor
    public Experiencia(int nivel, String nombre) {
        this.experiencia = nombre;
        this.nivel = nivel;
        
    }
    //metodos
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getExperiencia() {
        return experiencia;
    }

    @Override
    public String toString() {
        return this.getExperiencia() + "-"+ this.getNivel();
    }

}
