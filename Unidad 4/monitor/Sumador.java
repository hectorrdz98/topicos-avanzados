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
public class Sumador extends Thread{
    Monitor monitor;
    int num = 10; 
    int total = 10;
    
    public Sumador (Monitor mon) {
        monitor = mon;
    }
    
    public void run() {
        for (int i = 1; i<=total; i++) {
            this.monitor.setSuma(i);
            System.out.println("Estoy sumando: " + i);
        }
    }
    
}
