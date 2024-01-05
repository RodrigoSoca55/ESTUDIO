
package Dominio;


/**
 *
 * @author  Rodrigo Soca 327536
 */
public class Entrada {

    private String color;
    private char caracter;
//Constructor "cuando el color es Rojo o Azul en el constructor se cambia la letra por su codigo para representarla"

    public Entrada(char unCaracter, String unColor) {
        if (unColor.equals("R") || unColor.equals("\033[31m")) {
            this.color = "\033[31m";
        } else if (unColor.equals("A") || unColor.equals("\033[34m")) {
            this.color = "\033[34m";
        }
        this.caracter = unCaracter;
    }
//Getters y Setters "cuando el color es Rojo o Azul en el constructor se cambia la letra por su codigo para representarla"

    public String getColor() {
        return color;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setColor(String unColor) {
        if (unColor.equals("R")) {
            this.color = "\033[31m";
        } else if (unColor.equals("A")) {
            this.color = "\033[34m";
        }
    }

    public void setCaracter(char unCaracter) {
        this.caracter = unCaracter;
    }

// modificacion del equals
    @Override
    public boolean equals(Object o) {
        Entrada e = (Entrada) o;
        return this.getCaracter() == e.getCaracter() && this.getColor().equals(e.getColor());
    }
 
//metodos
    //Verifica si la matriz esta resuelta 
    public static boolean estaResueltaMat(Entrada[][] mat) {
        String color = mat[0][0].getColor();
        boolean mismoColor = true;
        for (int i = 0; i < mat.length && mismoColor; i++) {
            for (int j = 0; j < mat[0].length && mismoColor; j++) {
              mismoColor = mat[i][j].getColor().equals(color);
            }
        }
        return mismoColor;
    }
    //Copia la matriz Creando una nueva
    public static Entrada[][] copiarMat(Entrada[][] mat) {
        Entrada[][] mat2 = new Entrada[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                char caracter = mat[i][j].getCaracter();
                String color = mat[i][j].getColor();
                mat2[i][j] = new Entrada(caracter, color);
            }
        }
        return mat2;
    }
    //modifica la matriz segun caracter y color de la posicion [fila][col] en la matriz
    public static Entrada[][] modificarMat(Entrada[][] mat, int fila, int col) {
        int posF = fila - 1;
        int posC = col - 1;
        char caracterEntrada = mat[posF][posC].getCaracter();

        switch (caracterEntrada) {
            case '-':
                // caso fila -
                for (int j = 0; j < mat[0].length; j++) {
                    cambiarColor(mat, posF, j);
                }
                break;
            case '|':
                // caso columna |
                for (int i = 0; i < mat.length; i++) {
                    cambiarColor(mat, i, posC);
                }
                break;
            case '/':
                // caso diagonal abajo izquierda o arriba derecha
                int cont2 = 0;
                for (int i = posF; i > 0; i--) {
                    cont2++;
                }
                posF = 0;
                posC += cont2;

                // Verificar límites antes de realizar cambios
                while (posC >= 0 && posF < mat.length) {
                    if (posF >= 0 && posF < mat.length && posC >= 0 && posC < mat[0].length) {
                        cambiarColor(mat, posF, posC);
                    }
                    posF++;
                    posC--;
                }
                break;
            case '\\':
                // caso diagonal A ARRIBA izquierda o abajo derecha
                int cont = 0;
                int c = posC;
                for (int i = posF; i < mat.length && c < mat[0].length; i++) {
                    cont++;
                    c++;
                }
                posF = mat.length - 1;
                posC += cont - 1;

                // Verificar límites antes de realizar cambios
                while (posF >= 0 && posC >= 0) {
                    if (posF >= 0 && posF < mat.length && posC >= 0 && posC < mat[0].length) {
                        cambiarColor(mat, posF, posC);
                    }
                    posF--;
                    posC--;
                }
                break;
        }

        return mat;
    }
    //Si la entrada tiene un color lo cambio al otro

    public static void cambiarColor(Entrada[][] mat, int fila, int col) {
        String color = "\033[31m"; //color rojo es "\033[31m"
        if (mat[fila][col].getColor().equals(color)) {
            mat[fila][col].setColor("A");
        } else {
            mat[fila][col].setColor("R");
        }

    }

}
