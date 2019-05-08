/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vasoscomunicantes;

import processing.core.PApplet;

/**
 *
 * @author Héctor Rodríguez
 */
public class VasosComunicantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        String[] processingArgs = { "Vasos" };
        PApplet.runSketch(processingArgs, interfaz);
        
        Cronometro cron = new Cronometro(interfaz);
        cron.start();
    }
    
}
