//Autores: Andres Dalla Rizza, Rodrigo Soca
package Dominio;


import Exceptions.Exception_ParseNumero;
import Exceptions.Exception_StringVacio;
import java.io.Serializable;


abstract class Persona implements Serializable {
    //Atributos
    private String nombre;
    private int id;
    private String direccion;
    //contrucotr
    public Persona(){
    }
    public Persona(String nombre, int id, String direccion) {
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
    }
    
        public Persona(String nombre, String id, String direccion) throws  Exception_StringVacio, Exception_ParseNumero {
           asignarAtributo("nombre", nombre);
           asignarAtributo("id", id);
           asignarAtributo("direccion", direccion);
    }
    
//metodos
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public int getInteger(String valor) throws NumberFormatException{
         return Integer.parseInt(valor);
    }
    public void asignarAtributo(String at, String valor) throws Exception_StringVacio, Exception_ParseNumero{
        if (valor.equalsIgnoreCase("")){
            throw new Exception_StringVacio("Ingrese su "+at);
        } else {
            switch (at){
                case "nombre":
                this.nombre = valor;
                break;
                case "id" :
                    try{
                       this.id = getInteger(valor);
                    }catch(NumberFormatException e){
                        throw new Exception_ParseNumero("Ingrese unicamente numeros para su id ");
                    }
                    break;
                case "direccion":
                this.direccion = valor;
                break;
            }
            
        }
        
    }
}

 