/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabula;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Héctor Rodríguez
 */
public class Liebre extends Thread{
    
    double vel;
    int descanso;
    String nombre;
    
    @Override
    public void run() {
        double distancia = 0;
        System.out.println((char)27 + "[31m" + "Inicia " + nombre);
        while(distancia <= 100) {
            distancia += vel;
            try {
                Thread.sleep(descanso);
                System.out.println((char)27 + "[31m" + nombre + " lleva " + distancia + "m.");
            } catch (InterruptedException ex) {
                Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println((char)27 + "[31m" + "Acabó " + nombre);
    }
    
    public Liebre(String nombre, double vel, int descanso) {
        this.vel = vel;
        this.nombre = nombre;
        this.descanso = descanso;
    }
    
}
