
package Dominio;


import Exceptions.Exception_ParseNumero;
import Exceptions.Exception_StringVacio;
import java.io.Serializable;


public class Evaluador extends Persona implements Serializable{
    //Atributos
    private int añoIngreso;
    //constructor

    public Evaluador(String nombre, int id, String direccion,int añoIngreso) {
        super(nombre,id,direccion);
        this.añoIngreso = añoIngreso;
    }
        public Evaluador(String nombre, String id, String direccion,String añoIngreso) throws  Exception_StringVacio, Exception_ParseNumero {
        super(nombre,id,direccion);
        asignarAtributo("añoIngreso",añoIngreso);
    }
    
    //metodos

    public int getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(int añoIngreso) {
        this.añoIngreso = añoIngreso;
    }
    
    public void darResultadoentrevista(){
        
    }

    @Override
    public void asignarAtributo(String at, String valor) throws Exception_StringVacio, Exception_ParseNumero {
         if (valor.equalsIgnoreCase("") && at.equals("añoIngreso")) {
        throw new Exception_StringVacio("Ingrese su año de ingreso");
    } else if (at.equals("añoIngreso")) {
        try {
            this.añoIngreso = getInteger(valor);
        } catch (NumberFormatException e) {
            throw new Exception_ParseNumero("Ingrese únicamente números para su año de ingreso");
        }
    }
        super.asignarAtributo(at, valor); // Llama al método de Personas
    
   
    }

    @Override
    public String toString() {
        return this.getNombre()+"("+this.getId()+")";
    }
}
