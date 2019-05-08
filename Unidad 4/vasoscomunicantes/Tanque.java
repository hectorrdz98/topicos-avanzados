/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vasoscomunicantes;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Héctor Rodríguez
 */
public class Tanque extends Thread{
    
    double r = 0;
    double h = 0;
    double ha = 0;
    boolean continuar = true;
    boolean baja;
    Tanque destino;
    
    public Tanque(double r, double h, double ha, boolean baja, Tanque destino) {
        this.r = r;
        this.h = h;
        this.ha = ha;
        this.baja = baja;
        this.destino = destino;
    }
    
    public void run() {
        while(this.continuar) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tanque.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (this.ha > 0 && this.baja) {
                if (Math.abs(this.ha - this.destino.ha) <= 0.001) {
                    JOptionPane.showMessageDialog(null, "El agua en los contenedores llegó a la tolerancia de 0.001");
                    this.continuar = false;
                } else {
                    this.ha--;
                    this.destino.ha += (((this.r * this.r) * 1) / (this.destino.r * this.destino.r));
                }
            }
        }
    }
}
