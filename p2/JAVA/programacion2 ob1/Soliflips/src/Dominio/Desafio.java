package Dominio;

/**
 *
 * @author Rodrigo Soca 327536
 */
import static Dominio.Entrada.*;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Desafio {

    //atributos
    private Entrada[][] matAsociada;
    private int nivel;
    private String[] Solucion;

    //constructores
    public Desafio(Entrada[][] unaMat, int unNivel, String[] unaSolucion) {
        this.matAsociada = unaMat;
        this.nivel = unNivel;
        this.Solucion = unaSolucion;
    }

    //construyo el desafio segun su tipo
    public Desafio(String tipo, int filas, int col, int nivel) {
        if (tipo.equalsIgnoreCase("predefinido")) {
            Entrada[][] mat = new Entrada[5][6];
            mat[0][0] = new Entrada('|', "A");
            mat[0][1] = new Entrada('|', "A");
            mat[0][2] = new Entrada('-', "R");
            mat[0][3] = new Entrada('/', "A");
            mat[0][4] = new Entrada('|', "R");
            mat[0][5] = new Entrada('-', "R");
            mat[1][0] = new Entrada('-', "R");
            mat[1][1] = new Entrada('/', "A");
            mat[1][2] = new Entrada('/', "A");
            mat[1][3] = new Entrada('|', "A");
            mat[1][4] = new Entrada('-', "R");
            mat[1][5] = new Entrada('-', "R");
            mat[2][0] = new Entrada('-', "R");
            mat[2][1] = new Entrada('-', "R");
            mat[2][2] = new Entrada('|', "A");
            mat[2][3] = new Entrada('-', "R");
            mat[2][4] = new Entrada('/', "R");
            mat[2][5] = new Entrada('-', "R");
            mat[3][0] = new Entrada('\\', "R");
            mat[3][1] = new Entrada('-', "R");
            mat[3][2] = new Entrada('|', "R");
            mat[3][3] = new Entrada('\\', "R");
            mat[3][4] = new Entrada('|', "A");
            mat[3][5] = new Entrada('|', "R");
            mat[4][0] = new Entrada('\\', "R");
            mat[4][1] = new Entrada('/', "R");
            mat[4][2] = new Entrada('/', "R");
            mat[4][3] = new Entrada('|', "A");
            mat[4][4] = new Entrada('/', "A");
            mat[4][5] = new Entrada('\\', "A");

            String[] solucion = new String[]{"4 4", "5 6", "5 4"};
            this.matAsociada = mat;
            this.nivel = 3;
            this.Solucion = solucion;

        } else if (tipo.equalsIgnoreCase("datos")) {

            try {
                Scanner scanner = new Scanner(new File(".\\Test\\datos.txt"));
                Desafio des = desafioDeScanner(scanner);
                this.Solucion = des.Solucion;
                this.nivel = des.nivel;
                this.matAsociada = des.getMatAsociada();
            } catch (FileNotFoundException ex) {
                System.out.print("error");
            }

        } else if (tipo.equalsIgnoreCase("azar")) {
            Entrada[][] mat = new Entrada[filas][col];
            int numColor = (int) (Math.random() * 2 + 1);
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {

                    int numChar = (int) (Math.random() * 4 + 1);
                    switch (numColor) {
                        case 1 -> {
                            switch (numChar) {
                                case 1 -> {
                                    mat[i][j] = new Entrada('/', "R");
                                }
                                case 2 -> {
                                    mat[i][j] = new Entrada('\\', "R");
                                }
                                case 3 -> {
                                    mat[i][j] = new Entrada('-', "R");
                                }
                                case 4 -> {
                                    mat[i][j] = new Entrada('|', "R");
                                }
                            }
                        }
                        case 2 -> {
                            switch (numChar) {
                                case 1 -> {
                                    mat[i][j] = new Entrada('/', "A");
                                }
                                case 2 -> {
                                    mat[i][j] = new Entrada('\\', "A");
                                }
                                case 3 -> {
                                    mat[i][j] = new Entrada('-', "A");
                                }
                                case 4 -> {
                                    mat[i][j] = new Entrada('|', "A");
                                }
                            }
                        }

                    }
                }
            }
            String[] solucion = new String[nivel];
            for (int n = 0; n < nivel; n++) {
                int numFila = (int) (Math.random() * mat.length) + 1;
                int numCol = (int) (Math.random() * mat[0].length) + 1;
                modificarMat(mat, numFila, numCol);

                solucion[n] = Integer.toString(numFila) + " " + Integer.toString(numCol);

            }
            this.Solucion = solucion;
            this.matAsociada = mat;
            this.nivel = nivel;

        }
    }

    //getters y setters
    public Entrada[][] getMatAsociada() {
        return matAsociada;
    }

    public int getNivel() {
        return nivel;
    }

    public String[] getSolucion() {
        return Solucion;
    }

    public void setMatAsociada(Entrada[][] matAsociada) {
        this.matAsociada = matAsociada;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setSolucion(String[] Solucion) {
        this.Solucion = Solucion;
    }

    //metodos
    //crea un desafio segun el scanner 
    public static Desafio desafioDeScanner(Scanner in) {

        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        Entrada[][] mat = new Entrada[n][m];
        for (int i = 0; i < mat.length; i++) {
            String frase = in.nextLine();
            String[] datos = frase.split(" ");

            for (int j = 0; j < m; j++) {

                if (datos[j].charAt(1) == 'R') {
                    mat[i][j] = new Entrada(datos[j].charAt(0), "R");
                } else if (datos[j].charAt(1) == 'A') {
                    mat[i][j] = new Entrada(datos[j].charAt(0), "A");
                }

            }
        }
        int nivel = Integer.parseInt(in.nextLine());

        String[] Solucion = new String[nivel];
        for (int i = 0; i < nivel; i++) {
            String fraseSol = in.nextLine();

            Solucion[i] = fraseSol;
        }
        in.close();
        Desafio des = new Desafio(mat, nivel, Solucion);

        return des;
    }

}
