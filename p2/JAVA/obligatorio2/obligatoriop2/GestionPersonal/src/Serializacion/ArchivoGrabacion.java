package Serializacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Formatter;

public class ArchivoGrabacion {

    private Formatter out;
    private boolean appendable;
    public ArchivoGrabacion(String unNombre,boolean appendable) {
        try {
             out = new Formatter(new FileOutputStream(unNombre, appendable));
        } catch (FileNotFoundException e) {
            System.out.println("no se puede crear");
            System.exit(1);
        } catch (SecurityException e) {
            System.out.println("sin permisos");
            System.exit(1);
        }
    }

    public void grabarLinea(String linea) {
        out.format("%s%n", linea);
    }
    
    public void cerrar() {
        out.close();
    }
    

}


