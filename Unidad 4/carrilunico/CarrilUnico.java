/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrilunico;

import processing.core.PApplet;

/**
 *
 * @author Héctor Rodríguez
 */
public class CarrilUnico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        String[] processingArgs = { "Carril único" };
        PApplet.runSketch(processingArgs, interfaz);
        
        GeneradorCoches gen = new GeneradorCoches(interfaz);
        gen.start();
        
        Cronometro cron = new Cronometro(interfaz);
        cron.start();
    }
    
}
