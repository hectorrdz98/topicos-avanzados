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
public class Monitor {
    
    private String libro = "";
    private int turno = 0;
    public int finLibro = 0;
    
    public synchronized void addLibro(String valor) {
        while (this.turno != 0) {
            System.out.println("Entre al while del addLibro");
            try {
                this.wait();
            } catch (InterruptedException e) {}
        }
        this.turno = 1;
        this.libro += valor;
        // System.out.println("Agregué al libro " + valor + ": " + this.libro);
        this.turno = 0;
        this.notify();
    }
    
    public synchronized void readLibro(String valor) {
        while (this.turno != 0) {
            System.out.println("Entre al while del readLibro");
            try {
                this.wait();
            } catch (InterruptedException e) {}
        }
        this.turno = 1;
        double tiempoLeyendo = ThreadLocalRandom.current().nextInt(1, 2 + 1) - 0.5;    // Cada 0.5 a 1.5 seg
        // System.out.println("Lector " + valor + " empezó a leer por " + tiempoLeyendo + "s");
        try {
            Thread.sleep((long) (tiempoLeyendo * 1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Leído por " + valor + ": " + this.libro);
        this.turno = 0;
        this.notify();
    }
  
}
