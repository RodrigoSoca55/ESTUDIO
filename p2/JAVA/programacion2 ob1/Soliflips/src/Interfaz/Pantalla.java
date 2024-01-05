
package Interfaz;

/**
 *
 * @author  Rodrigo Soca 327536
 */

import Dominio.*;

public class Pantalla {


    // imprimir decorados-----------------------------------------------------------------------------------------------------------------------------
    //imprime los numeros arriba de la matriz
    public static void patron0(int cols) {
        System.out.print(" ");
        String patron = "   ";
        for (int i = 0; i < cols; i++) {
            int num = i + 1;
            System.out.print(patron + num);
        }
    }

    //imprime los separadores de la matriz
    public static void patron1(int cols) {
        System.out.print("  +");
        String patron = "---+";
        for (int i = 0; i < cols; i++) {
            System.out.print(patron);

        }
    }

    // muestra el tablero con la decoracion --------------------------------------------------------------------------------------------------------------
    public static void mostrarTablero(Entrada[][] mat) {
        String b = "\u001B[0m"; //borrar   
        patron0(mat[0].length);
        System.out.println();

        patron1(mat[0].length);
        System.out.println();

        for (int i = 0; i < mat.length; i++) {
            String indice = String.valueOf(i + 1);
            System.out.print(indice + " " + "|");
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(" " + mat[i][j].getColor() + mat[i][j].getCaracter() + b + " " + "|");
            }
            System.out.println();
            patron1(mat[0].length);
            System.out.println();

        }
    }

    public static void mostrarTableroDe2(Entrada[][] mat1, Entrada[][] mat2) {
        int cols1 = mat1[0].length;
        int cols2 = mat2[0].length;
        String b = "\u001B[0m"; // borrar

        // Imprimir la primera matriz
        patron0(cols1);
        System.out.print("         ");
        patron0(cols2);
        System.out.println();

        patron1(cols1);
        System.out.print("  ==>  ");
        patron1(cols2);
        System.out.println();

        for (int i = 0; i < mat1.length; i++) {
            String indice = String.valueOf(i + 1);
            System.out.print(indice + " " + "|");
            for (int j = 0; j < cols1; j++) {
                System.out.print(" " + mat1[i][j].getColor() + mat1[i][j].getCaracter() + b + " " + "|");
            }
            System.out.print("  ==>  "); // Separador entre las matrices
            //imprimir segunda mat
            System.out.print(indice + " " + "|");
            for (int j = 0; j < cols2; j++) {
                System.out.print(" " + mat2[i][j].getColor() + mat2[i][j].getCaracter() + b + " " + "|");
            }
            System.out.println();
            patron1(cols1);
            System.out.print("  ==>  ");
            patron1(cols2);
            System.out.println();
        }
    }
    public static void mostrarTiempo(long milisegundos) {
        
        long segundosTotales = milisegundos / 1000;
        int horas = (int) (segundosTotales / 3600);
        int minutos = (int) ((segundosTotales % 3600) / 60);
        int segundos = (int) (segundosTotales % 60);
        System.out.print(horas+"h:"+minutos+"m:"+segundos+"s");
    }
}
