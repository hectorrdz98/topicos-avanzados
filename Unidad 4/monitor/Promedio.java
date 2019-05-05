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
public class Promedio extends Thread{
    Monitor monitor;
    int res = 0;
    double promedio = 0.0;

    public Promedio (Monitor mon) {
        monitor = mon;
    }
    
    public void run() {
        while (true) {
            res = (int) this.monitor.getSuma();
            System.out.println("Recibí suma: " + res);
            System.out.println("Voy a calcular promedio");
            promedio = (double) res / 10;
            System.out.println("El promedio es: " + promedio);
            if (this.monitor.cont > 10) {
                break;
            }
        }
    }
}
