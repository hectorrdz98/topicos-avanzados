/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrilunico;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Héctor Rodríguez
 */
public class Coche {
    
    int color[] = {0,0,0};
    int pos[] = {0,0};
    int direccion = 0;
    int velocidad = 0;
    boolean freno = false;
    
    public Coche(int color[], int direccion, int velocidad) {
        this.color = color; 
        this.direccion = direccion;
        this.velocidad = velocidad;
        
        if (this.direccion == 0) {
            this.pos[0] = 0 - 80 - 50;
            this.pos[1] = 325;
        } else {
            this.pos[0] = 1000 + 50;
            this.pos[1] = 125;
        }
    }
    
    public void avanzar(int vel) {
        if (!freno) {
            if (this.direccion == 0) this.pos[0] += vel;
            else this.pos[0] -= vel;
        }
    }
    
}
