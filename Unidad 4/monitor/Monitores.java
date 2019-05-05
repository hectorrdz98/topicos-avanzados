/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor;

/**
 *
 * @author Héctor Rodríguez
 */
public class Monitores {
    public static void main(String [] args) {
        Monitor mon1 = new Monitor();
        Sumador hilo1 = new Sumador(mon1);
        Promedio hilo2 = new Promedio(mon1);
        hilo1.start();
        hilo2.start();
    }
}
