/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escritores;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Héctor Rodríguez
 */
public class Escritor extends Thread{
    
    Monitor monitor;
    
    public Escritor (Monitor mon) {
        monitor = mon;
    }
    
    public void run() {
        for (int i = 0; i<5; i++) {
            int delayEscribir = ThreadLocalRandom.current().nextInt(1, 2 + 1);    // Cada 1 a 2 seg
            try {
                Thread.sleep(delayEscribir * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.monitor.addLibro(this.getName());
        }
        this.monitor.finLibro++;
    }
    
}
