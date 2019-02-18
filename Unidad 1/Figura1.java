/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u2a1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Héctor Rodríguez
 */
public class Figura1 extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void paint(Graphics e) {
        // Cuadrados
        for (int i = 0; i<9; i++) {
            e.drawRect(i*30, i*30, 75, 50);
        }
        for (int i = 0; i<10; i++) {
            e.setColor(new Color(i*20, 100 - 4*i, i*5));
            e.fillRect(200 + i*5, 30 + i*5, 150 - i*10, 100 - i*10);
        }
        e.setColor(Color.blue);
        for (int i = 0; i<10; i++) {
            e.drawLine(100, 200, 300, 200 + i * 100);
        }   
        for (int i = 0; i<10; i++) {
            e.setColor(new Color(25*i, 0, i*10));
            e.fillRect(30*i, 300 + 50*i, 75, 50);
        }
        
        // Circulos
        e.setColor(Color.green);
        for (int i = 0; i<9; i++) {
            e.drawOval(400 + i*30, i*30, 75, 50);
        }
        for (int i = 0; i<10; i++) {
            e.setColor(new Color(i*5, 15*i, 0));
            e.fillOval(400 + 200 + i*5, 30 + i*5, 150 - i*10, 100 - i*10);
        }
        for (int i = 0; i<10; i++) {
            e.setColor(new Color(0, 25*i, i*5));
            e.fillOval(400 + 20*i, 300 + 40*i, 75, 50);
        }
        
        // Triangulos
        e.setColor(Color.PINK);
        for (int i = 0; i<10; i++) {
            int xPoints[] = {850 - 50, 850, 850 + 50, 850 - 50};
            int yPoints[] = {50, 0, 50, 50};
            e.drawPolyline(xPoints, yPoints, 3);
        }   
    }

    // TODO overwrite start(), stop() and destroy() methods
}
