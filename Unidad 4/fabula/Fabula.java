/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabula;

/**
 *
 * @author Héctor Rodríguez
 */
public class Fabula {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Liebre liebre = new Liebre("Liebre Arturo", 8, 1000);
        Thread tortuga = new Thread(new Tortuga("Tortuga Ray", 1, 100));
        
        liebre.start();
        tortuga.start();
    }
    
}
