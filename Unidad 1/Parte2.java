/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenu2.pkg1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author Héctor Rodríguez
 */
public class Parte2 extends Applet {

    public void paint(Graphics e) {
        e.setColor(Color.BLACK);
        
        int nLados = 5;
        
        int size = 50;
        int limiteX = size * nLados/2;
        int limiteY = size;
        
        for (int i = 0; i<nLados; i++) {
            int preLimiteX = limiteX;
            
            for (int j = 0; j<i+1; j++) {
                e.setColor(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
                int xpoints[] = {preLimiteX, preLimiteX + size/2, preLimiteX + size};
                int ypoints[] = {limiteY + size , limiteY, limiteY + size};
                e.fillPolygon(xpoints, ypoints, 3);
                preLimiteX += size;
            }
            
            limiteY += size;
            limiteX -= size/2;
        }
        
    }

    // TODO overwrite start(), stop() and destroy() methods
}
