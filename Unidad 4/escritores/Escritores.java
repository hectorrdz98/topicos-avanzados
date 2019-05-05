/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escritores;

/**
 *
 * @author Héctor Rodríguez
 */
public class Escritores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Monitor mon1 = new Monitor();
        
        Escritor escritores[] = new Escritor[10];
        Lector lectores[] = new Lector[10];
        
        for (int n = 0; n<10; n++) {
            escritores[n] = new Escritor(mon1);
            escritores[n].setName(String.valueOf(n));
            
            lectores[n] = new Lector(mon1);
            lectores[n].setName(String.valueOf(n + 20));
        }
        
        for (int n = 0; n<10; n++) {
            escritores[n].start();
            lectores[n].start();
        }
        
    }
    
}
