/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionpersonal;

import Dominio.Sistema;
import Interfaz.Menu;

/**
 *
 * @author Rodri
 */
public class GestionPersonal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema sist = new Sistema();

        Menu v = new Menu(sist);
        v.setVisible(true);

    }
}
