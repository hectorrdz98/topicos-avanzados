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
public class Monitor {

    private int bufferSuma = 0;
    private int turno = 0;
    public int cont = 0;
    
    public synchronized void setSuma(int valor) {
        System.out.println("Entré a setSuma");
        while (turno == 1) {
            System.out.println("Entré al while setSuma");
            try {
                this.wait();
            } catch (InterruptedException e) {}
        }
        bufferSuma = bufferSuma + valor;
        System.out.println("BufferSuma: " + bufferSuma);
        turno = 1;
        cont ++;
        this.notifyAll();
    }
    
    public synchronized int getSuma() {
        System.out.println("Entré a getSuma");
        while (turno == 0 && cont<=10) {
            System.out.println("Entré al while getSuma");
            try {
                this.wait();
            } catch (InterruptedException e) {}
        }
        turno = 0;
        this.notifyAll();
        return bufferSuma;
    }
    
}
