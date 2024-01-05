/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Serializacion.ArchivoGrabacion;
import java.io.Serializable;

/**
 *
 * @author andre
 */
public class Tematica implements Serializable{
    //atributos
    private String nombre;
    private String descripcion;
    //constructor
    public Tematica(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    //metodos

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return  nombre;
    }
   
}
