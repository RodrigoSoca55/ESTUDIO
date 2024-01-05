//Autores: Andres Dalla Rizza, Rodrigo Soca
package Dominio;

import Exceptions.Exception_ParseNumero;
import Exceptions.Exception_StringVacio;
import java.util.ArrayList;
import Serializacion.*;
import Exceptions.Exception_DuplicateName;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

public class Sistema implements Serializable {

    //Atributos
    private ArrayList<Postulante> listaPostulantes;
    private ArrayList<Evaluador> listaEvaluadores;
    private ArrayList<Entrevista> listaEntrevistas;
    private ArrayList<Tematica> listaTematicas;
    private ArrayList<Puesto> listaPuestos;

    //Costructor
    public Sistema() {
        listaPostulantes = new ArrayList();
        listaEvaluadores = new ArrayList();
        listaEntrevistas = new ArrayList();
        listaTematicas = new ArrayList();
        listaPuestos = new ArrayList();
    }

    
    //getters y setters
    public ArrayList<Postulante> getListaPostulantes() {
        return listaPostulantes;
    }

    public ArrayList<Evaluador> getListaEvaluadores() {
        return listaEvaluadores;
    }

    public ArrayList<Entrevista> getListaEntrevistas() {
        return listaEntrevistas;
    }

    public ArrayList<Tematica> getListaTematicas() {
        return listaTematicas;
    }

    public ArrayList<Puesto> getListaPuestos() {
        return listaPuestos;
    }

    public void setListaPostulantes(ArrayList<Postulante> listaPostulantes) {
        this.listaPostulantes = listaPostulantes;
    }

    public void setListaEvaluadores(ArrayList<Evaluador> listaEvaluadores) {
        this.listaEvaluadores = listaEvaluadores;
    }

    public void setListaEntrevistas(ArrayList<Entrevista> listaEntrevistas) {
        this.listaEntrevistas = listaEntrevistas;
    }

    public void setListaTematicas(ArrayList<Tematica> listaTematicas) {
        this.listaTematicas = listaTematicas;
    }

    public void setListaPuestos(ArrayList<Puesto> listaPuestos) {
        this.listaPuestos = listaPuestos;
    }

    //Metodos
    public void registrarEvaluador(String nombre, String cedula, String direccion, String añoIngreso) throws Exception_StringVacio, Exception_ParseNumero {
        if (nombre.equals("") || direccion.equals("") || añoIngreso.equals("") || cedula.equals("")) {
            throw new Exception_StringVacio("Error: Complete los campos vacios");
        } else {
            Evaluador ev = new Evaluador(nombre, cedula, direccion, añoIngreso);
            ArrayList<Evaluador> oldValue = this.getListaEvaluadores();
            this.getListaEvaluadores().add(ev);
        }
    }

    public void registrarTematica(String nombre, String descripcion) throws Exception_StringVacio, Exception_DuplicateName {
        if (nombre.equals("") || descripcion.equals("")) {
            throw new Exception_StringVacio("Error: Complete los campos vacios");
        } else if (!esTematicaValida(nombre)) {
            throw new Exception_DuplicateName("Error:Nombre ya existente en el sistema");
        } else {
            Tematica tem = new Tematica(nombre, descripcion);
            this.getListaTematicas().add(tem);

        }

    }

    public void registrarExperiencia(Postulante pos, int nivel, String nombre) {
        Experiencia res = new Experiencia(nivel, nombre);
        pos.agregarExperiencia(res);
    }

    public void registrarPostulante(String nombre, String cedula, String direccion, String telefono, String mail, String linkedin, String formato) throws Exception_StringVacio, Exception_ParseNumero {
        if (nombre.equals("") || cedula.equals("") || direccion.equals("") || telefono.equals("") || mail.equals("") || linkedin.equals("") || formato.equals("")) {
            throw new Exception_StringVacio("Error: Complete los campos vacios");
        } else {
            try {
                int ced = Integer.parseInt(cedula);
                int tel = Integer.parseInt(telefono);
                Postulante post = new Postulante(nombre, Integer.parseInt(cedula), direccion, Integer.parseInt(telefono), mail, linkedin, formato);
                this.getListaPostulantes().add(post);
            } catch (Exception e) {
                throw new Exception_ParseNumero("Error:Se ingreso un String no un numero");
            }

        }

    }

    public void registrarPuesto(String nombre, String modalidad) throws Exception_StringVacio, Exception_DuplicateName {
        if (nombre.equals("") || modalidad.equals("")) {
            throw new Exception_StringVacio("Error: Complete los campos vacios");
        } else if (!esPuestoValido(nombre)) {
            throw new Exception_DuplicateName("Error:Nombre de puesto ya existente en el sistema");
        } else {
            Puesto pues = new Puesto(nombre, modalidad);
            this.getListaPuestos().add(pues);

        }
    }

    public void registrarEntrevista(Evaluador ev, Postulante pos, String puntaje, int id, String comentarios) throws Exception_StringVacio {
        String aux = String.valueOf(puntaje);
        if (aux.equals("") || comentarios.equals("") || ev == null || pos == null) {
            throw new Exception_StringVacio("Error:campo sin completar");
        }
        try {
            int punt = Integer.parseInt(puntaje);
            Entrevista ent = new Entrevista(ev, pos, punt, id, comentarios);
            pos.getListaEntrevistasP().add(ent);
            this.getListaEntrevistas().add(ent);
        } catch (Exception e) {

        }

    }

    public void bajaPostulante(Postulante post) {
        this.getListaPostulantes().remove(post);
        for (int i = 0; i < this.getListaEntrevistas().size(); i++) {
            if (this.getListaEntrevistas().get(i).getPostulante().equals(post)) {
                this.getListaEntrevistas().remove(i);
            }

        }

    }

    public ArrayList<Postulante> darListaPostulantesPorPuesto(Puesto puesto, int nivel) {
        //Filtra la lista de postulantes en base al puesto y nivel que se elijan
        ArrayList<Postulante> listaPost = this.getListaPostulantes();
        ArrayList<Postulante> listaRetorno = new ArrayList();
        ArrayList<Tematica> listaRequerimientos = puesto.getListaRequerimientos();
        for (int i = 0; i < listaPost.size(); i++) {
            Postulante post = listaPost.get(i);
            ArrayList<Experiencia> listaExp = post.getListaExperiencia();
            for (int j = 0; j < listaRequerimientos.size(); j++) {
                Tematica requerimiento = listaRequerimientos.get(j);
                String temaPos = listaExp.get(j).getExperiencia();
                int cantEntrevista = post.getListaEntrevistas().size();
                int nivelPos = listaExp.get(j).getNivel();
                String formatoPos = post.getFormato();
                String tema = requerimiento.getNombre();
                String formato = puesto.getModalidad();
                if (temaPos.equalsIgnoreCase(tema) && nivelPos >= nivel && formatoPos.equalsIgnoreCase(formato) && cantEntrevista > 0) {
                    listaRetorno.add(post);
                }
            }
        }
        Collections.sort(listaRetorno, new Comparator<Postulante>() {
            // se ordenan segun el puntaje de la ultima entrevista
            @Override
            public int compare(Postulante post1, Postulante post2) {
                // Comparar por el puntaje de la última entrevista
                return Integer.compare(post2.getUltimoPuntajeEntrevista(), post1.getUltimoPuntajeEntrevista());
            }
        });
        return listaRetorno;
    }

    public boolean esTematicaValida(String nom) {
        boolean res = true;
        for (Tematica t : this.getListaTematicas()) {
            if (t.getNombre().equalsIgnoreCase(nom)) {
                res = false;
            }
        }
        return res;
    }

    public boolean esCedulaValidaPos(String id) {
        //verifica si no hya cedula duplicada
        boolean res = true;
        for (int i = 0; i < this.getListaPostulantes().size(); i++) {
            if (String.valueOf(this.getListaPostulantes().get(i).getId()).equals(id)) {
                res = false;
            }
        }
        return res;
    }

    public boolean esPuestoValido(String nom) {
        //verifica si no hay nombres de puestos duplicados
        boolean res = true;
        for (Puesto t : this.getListaPuestos()) {
            if (t.getNombrePuesto().equalsIgnoreCase(nom)) {
                res = false;
            }
        }
        return res;
    }

    public void guardarDataPuesto(String pathArchivo, ArrayList<Postulante> listaPos, Puesto puesto) {
        ArchivoGrabacion agDatos = new ArchivoGrabacion(pathArchivo, false);
        String lineaNombrePuesto = puesto.getNombrePuesto();
        agDatos.grabarLinea(lineaNombrePuesto);
        agDatos.cerrar();

        for (int i = 0; i < listaPos.size(); i++) {
            Postulante postulante = listaPos.get(i);
            postulante.grabarPostulante(pathArchivo);
        }
        agDatos.cerrar();

    }

    public boolean sistemaEstaVacio() {
        return this.getListaEntrevistas().isEmpty()
                && this.getListaEvaluadores().isEmpty()
                && this.getListaPostulantes().isEmpty()
                && this.getListaPuestos().isEmpty()
                && this.getListaTematicas().isEmpty();

    }

    public void resetearSistema() {
        ArchivoGrabacion agDataSistema = new ArchivoGrabacion("data.txt", false);
        ArchivoGrabacion agDataPuesto = new ArchivoGrabacion("consulta.txt", false);
        vaciarListas();
    }
    
    public int cantPuestosTematica(Tematica tem){
        int cont = 0;
        for(Puesto pues: this.getListaPuestos()){
            if(pues.getListaRequerimientos().contains(tem)){
                cont++;
            }
        }
        return cont;
    } 
    
    public void vaciarListas() {
        this.getListaEntrevistas().clear();
        this.getListaEvaluadores().clear();
        this.getListaPostulantes().clear();
        this.getListaPuestos().clear();
        this.getListaTematicas().clear();
    }

    public void guardarDatosSistema() throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.txt"));
        out.writeObject(this);
        out.close();
    }

}
