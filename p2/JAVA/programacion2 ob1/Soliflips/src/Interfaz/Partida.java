package Interfaz;

/**
 *
 * @author Rodrigo Soca 327536
 */
import Dominio.*;
import static Dominio.Entrada.*;
import static Interfaz.Pantalla.*;
import java.util.*;

public class Partida {
//crea la partida segun el desafio

    public static void partida(Desafio des) throws Exception {
        long tInicio;
        long tFin;
        long tTotal;
        Entrada[][] mat1 = des.getMatAsociada();
        String[] solucion = des.getSolucion();
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> historial = new ArrayList<Integer>();
        tInicio = new Date().getTime();
        //muestro opciones y inicializo el tiempo
        boolean volverMenu = false;
        while (!volverMenu) {
            System.out.println();
            System.out.println("Ingrese una opcion X,S o H  o Ingrese un movimiento la fila y la columna se ingresan de a una por vez, por separado");
            System.out.println("Si ingresas -1 -1 se retrocedera 1 movimiento");
            System.out.println();
            System.out.println("X) => Terminar partida y volver a menu");
            System.out.println("S) => Ver solucion del tablero original");
            System.out.println("H) => Ver el historial de movimientos ");
            System.out.println();
            boolean correcto = false;
            while (!correcto) {

                try {

                    String frase = in.nextLine();
                    frase = frase.toLowerCase();
                    char opcion = frase.charAt(0);
                    if (opcion == 'x' || opcion == 's' || opcion == 'h') {

                        correcto = true;
                        switch (opcion) {
                            //salir de la partida
                            case 'x': {
                                System.out.println("Si vuelves al menu se borrara el progreso de la partida");
                                System.out.println();
                                System.out.println("En caso de desear salir escribe SI en otro caso presiona cualquier boton");
                                frase = in.nextLine();
                                frase = frase.toLowerCase();
                                System.out.println();
                                if (frase.equals("si")) {
                                    tFin = new Date().getTime();
                                    tTotal = tFin - tInicio;
                                    System.out.println();
                                    System.out.print("Jugaste en esta partida: ");
                                    mostrarTiempo(tTotal);
                                    System.out.println();
                                    volverMenu = true;
                                    break;
                                } else {
                                    volverMenu = false;

                                }

                            }
                            break;
                            //mostrar solucion
                            case 's': {
                                System.out.println("Solucion del tablero original");
                                System.out.println(Arrays.toString(solucion));
                                System.out.println();
                            }
                            break;
                            //mostrar historial
                            case 'h': {
                                System.out.println("Historial de movimientos");
                                System.out.println();
                                if (historial.size() > 0) {
                                    System.out.print("[" + historial.get(0) + " " + historial.get(1));
                                    for (int i = 2; i < historial.size() - 1; i += 2) {
                                        System.out.print(", " + historial.get(i) + " " + historial.get(i + 1));
                                    }
                                    System.out.print("]");

                                } else {
                                    System.out.print("No se han realizado movimientos");

                                }
                                System.out.println(" ");

                            }
                            break;

                        }
                        //si no se ingreso un caracter de las opciones uso try catch para ver si habian ingresado un integer 
                    } else {
                        try {
                            int num1 = Integer.parseInt(frase);
                            String frase2 = in.nextLine();
                            int num2 = Integer.parseInt(frase2);
                            Entrada[][] mat2 = copiarMat(mat1);
                            //el entero ingresado no se puede salir del rango de la matriz
                            if ((num1 <= mat1.length && num1 > 0 && num2 <= mat1[0].length && num2 > 0) || (num1 == -1 && num2 == -1)) {
                                correcto = true;
                                //si se ingresa -1 -1 retrocedo un paso consultando el historial y actualizo el historial borrando el ultimo movimiento
                                if (num1 == -1 && num2 == -1) {
                                    if (historial.size() > 1) {
                                        int numCol = historial.get(historial.size() - 1);
                                        int numFil = historial.get(historial.size() - 2);
                                        modificarMat(mat2, numFil, numCol);
                                        mostrarTableroDe2(mat1, mat2);
                                        System.out.println();
                                        mostrarTablero(mat2);
                                        mat1 = copiarMat(mat2);
                                        historial.remove(historial.size() - 2);
                                        historial.remove(historial.size() - 1);

                                    } else {
                                        System.out.println("No realizaste Movimientos anteriormente");
                                        System.out.println();
                                    }
                                } else {
                                    //Modifico la matriz y actualizo la anterior
                                    historial.add(num1);
                                    historial.add(num2);
                                    modificarMat(mat2, num1, num2);
                                    mostrarTableroDe2(mat1, mat2);
                                    System.out.println();
                                    mostrarTablero(mat2);
                                    mat1 = copiarMat(mat2);
                                    //consulto si resolvio la matriz en ese caso muestro un mensaje de felicitaciones y el tiempo que toma
                                    if (  (estaResueltaMat(mat2))) {
                                        System.out.println();
                                        System.out.println("Felicitaciones Ganaste");
                                        tFin = new Date().getTime();
                                        tTotal = tFin - tInicio;
                                        System.out.println();
                                        System.out.print("Lo resolviste en: ");
                                        mostrarTiempo(tTotal);
                                        System.out.println();
                                        volverMenu = true;

                                    } else {
                                        volverMenu = false;
                                    }

                                }
                            } else {
                                throw new Exception("El numero Esta fuera de rango");
                            }

                        } catch (Exception e) {
                            throw new Exception("Entrada no valida");

                        }
                    }

                } catch (Exception e) {
                    System.out.println("Error =>" + e.getMessage());
                    System.out.println("Ingrese una opcion X,S o H  o Ingrese numero valido");
                    System.out.println();
                    System.out.println("X) => Terminar partida y volver a menu");
                    System.out.println("S) => Ver solucion del tablero original");
                    System.out.println("H) => Ver el historial de movimientos ");
                    System.out.println();
                }
            }
        }
    }

    public static void jugar() {
        Scanner in = new Scanner(System.in);
        boolean terminar = false;
        while (!terminar) {
            System.out.println("Menu ");
            System.out.println();
            System.out.println();
            System.out.println("Ingrese una opcion A,B,C o X");
            System.out.println();
            System.out.println("A) => Crear partida tomando datos del archivo 'datos.txt'");
            System.out.println("B) => Crear partida usando el tablero predefinido");
            System.out.println("C) => Crear partida usando un tablero al azar");
            System.out.println("X) => Salir del juego");
            System.out.println();
            boolean correcto = false;
            while (!correcto) {
                try {
                    String frase = in.nextLine();

                    frase = frase.toLowerCase();
                    char opcion = frase.charAt(0);
                    if (opcion == 'a' || opcion == 'b' || opcion == 'c' || opcion == 'x') {
                        correcto = true;
                    } else {
                        throw new Exception("caracter no valido");
                    }

                    switch (opcion) {
                        //creo partida con datos.txt
                        case 'a': {
                            System.out.println("Elegiste crear la partida con el tablero del archivo 'datos.txt'");
                            Desafio des = new Desafio("datos", 0, 0, 0);
                            Entrada[][] mat = des.getMatAsociada();
                            mostrarTablero(mat);
                            partida(des);
                        }
                        break;
                        //creo partida con tablero predefinido
                        case 'b': {
                            System.out.println("Elegiste crear la partida con el tablero predefinido");
                            System.out.println();
                            Desafio des = new Desafio("predefinido", 5, 6, 3);
                            Entrada[][] mat = des.getMatAsociada();
                            mostrarTablero(mat);
                            partida(des);

                        }
                        break;
                        //creo partida con un tablero al azar
                        case 'c': {
                            boolean correcto2 = false;

                            System.out.println("Elegiste crear la partida con el tablero al azar");
                            while (!correcto2)
                            try {
                                System.out.println("ingrese cantidad de filas de 3 a 9");
                                int filas = in.nextInt();
                                System.out.println("ingrese cantidad de Columnas de 3 a 9");
                                int columnas = in.nextInt();
                                System.out.println("ingrese  nivel de 1 a 8");
                                int nivel = in.nextInt();

                                if (filas < 3 || filas > 9) {
                                    throw new Exception("cantidad de filas incorrecto");
                                } else if (columnas < 3 || columnas > 9) {
                                    throw new Exception("cantidad de columnas incorrecto");
                                } else if (nivel < 1 || nivel > 8) {

                                    throw new Exception("nivel  incorrecto");
                                } else if (filas >= 3 && filas <= 9 && columnas >= 3 && columnas <= 9 && nivel >= 1 && nivel <= 8) {
                                    correcto2 = true;
                                    Desafio des = new Desafio("azar", filas, columnas, nivel);
                                    Entrada[][] mat = des.getMatAsociada();
                                    mostrarTablero(mat);
                                    partida(des);
                                    in.nextLine();
                                }
                            } catch (Exception e) {
                                System.out.println("Error=>" + e.getMessage());
                                System.out.println("ingrese valores dentro del Rango");
                                System.out.println();
                            }
                        }
                        break;

                        case 'x': {
                            System.out.println("Gracias por jugar Soliflips");
                            terminar = true;
                        }
                        break;

                        default: {
                            System.out.println("Error => No se ingreso correctamente la opcion");
                            System.out.println("Ingrese A,B,C o X");

                        }

                    }

                } catch (Exception e) {
                    System.out.println("Error => No se ingreso correctamente la opcion");
                    System.out.println("Ingrese nuevamente una opcion (A,B,C o X)");
                    System.out.println();
                    System.out.println("A) => Crear partida tomando datos del archivo 'datos.txt'");
                    System.out.println("B) => Crear partida usando el tablero predefinido");
                    System.out.println("C) => Crear partida usando un tablero al azar");
                    System.out.println("X) => Salir del juego");
                    System.out.println();
                    correcto = false;
                }
            }

        }
    }

}
