
package Interfaz;

/**
 *
 * @author  Rodrigo Soca 327536
 */

import static Interfaz.Pantalla.mostrarTiempo;
import static Interfaz.Partida.jugar;
import java.util.Date;


public class Soliflips {

    public static void main(String[] args) {

        System.out.println("Rodrigo Soca Num: 327536");
        System.out.println();
        String asciiArt
                = "\033[31m"
                + "  _____  ____  _      _____ ______ _      _____ _____   _____ \n" + "\033[31m"
                + " / ____|/ __ \\| |    |_   _|  ____| |    |_   _|  __ \\ / ____|\n" + "\033[31m"
                + "| (___ | |  | | |      | | | |__  | |      | | | |__) | (___  \n" + "\033[34m"
                + " \\___ \\| |  | | |      | | |  __| | |      | | |  ___/ \\___ \\ \n" + "\033[34m"
                + " ____) | |__| | |____ _| |_| |    | |____ _| |_| |     ____) |\n" + "\033[34m"
                + "|_____/ \\____/|______|_____|_|    |______|_____|_|    |_____/ "+"\u001B[0m";

        System.out.println(asciiArt);

        long tInicio= new Date().getTime();
        long tFin;
        long tTotal;
        jugar();
         tFin = new Date().getTime();
                                    tTotal = tFin - tInicio;
                                    System.out.println();
                                    System.out.print("Tu tiempo de juego fue: ");
                                    mostrarTiempo(tTotal);
                                    System.out.println();
    }

}
