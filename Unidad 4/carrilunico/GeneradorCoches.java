/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrilunico;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Héctor Rodríguez
 */
public class GeneradorCoches extends Thread{
    
    boolean continuar = true;
    Interfaz interfaz;
    
    public GeneradorCoches(Interfaz interfaz) {
        this.interfaz = interfaz;
    }
    
    @Override
    public void run() {
        while(continuar) {
            try {
                if (this.interfaz.btnActivo == 0) Thread.sleep(10000);
                else Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GeneradorCoches.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int color[] = {
                ThreadLocalRandom.current().nextInt(0, 255 + 1),
                ThreadLocalRandom.current().nextInt(0, 255 + 1),
                ThreadLocalRandom.current().nextInt(0, 255 + 1)
            };
            
            int direccion = 0;
            
            if (this.interfaz.btnActivo == 0 || this.interfaz.btnActivo == 1) {
                direccion = ThreadLocalRandom.current().nextInt(0, 0 + 1);
            } else {
                direccion = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            }
            
            int velocidad = ThreadLocalRandom.current().nextInt(3, 7 + 1);
            
            Coche aux = new Coche(color, direccion, velocidad);
            
            interfaz.coches.add(aux);
            
            if (direccion == 0) {
                this.interfaz.carriles[1].coches.add(aux);
            } else {
                this.interfaz.carriles[2].coches.add(aux);
            }
            
            System.out.println("Generé auto. Color: " + Arrays.toString(color) + ", direccion: " + direccion + ", velocidad: " + velocidad);
        }
    }
    
    public void parar(){
        this.continuar = false;
    }
}
