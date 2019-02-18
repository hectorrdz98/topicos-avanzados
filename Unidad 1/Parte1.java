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
public class Parte1 extends Applet {

    public void paint(Graphics e) {
        for (int i = 0; i<5; i++) {
            int rnd = (int)(Math.random() * 1000);
            for (int j = 0; j<rnd; j++) {
                switch (i) {
                    case 5: {    // Circulo 
                        e.setColor(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
                        int width = (int)(Math.random() * 40);
                        e.fillOval((int)(Math.random() * 800), (int)(Math.random() * 400), width, width);
                    } break;
                    case 1: {    // Cuadrado
                        e.setColor(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
                        int width = (int)(Math.random() * 40);
                        e.fillRect((int)(Math.random() * 800), (int)(Math.random() * 400), width, width);
                    } break;
                    case 2: {    // Ovalo
                        e.setColor(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
                        e.fillOval((int)(Math.random() * 800), (int)(Math.random() * 400), (int)(Math.random() * 40), (int)(Math.random() * 40));
                    } break;
                    case 3: {    // Triangulo
                        e.setColor(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
                        int limitX = (int)(Math.random() * 400); 
                        int limitY = (int)(Math.random() * 800);
                        int []nXpts = {
                            (int)(Math.random() * 80) + limitX,
                            (int)(Math.random() * 80) + limitX,
                            (int)(Math.random() * 80) + limitX
                        };
                        int []nYpts = {
                            (int)(Math.random() * 80) + limitY,
                            (int)(Math.random() * 80) + limitY,
                            (int)(Math.random() * 80) + limitY
                        };
                        e.fillPolygon(nXpts, nYpts, 3);
                    } break;
                    case 0: {    // Hexagono 
                        e.setColor(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
                        int limitX = (int)(Math.random() * 400); 
                        int limitY = (int)(Math.random() * 800);
                        int size = (int)(Math.random() * 50);
                        Polygon s = new Polygon();
                        for (int k = 0; k < 6; k++) {
                            s.addPoint(
                                limitX + (int) (size * Math.cos(k * 2 * Math.PI / 6)),
                                limitY + (int) (size * Math.sin(k * 2 * Math.PI / 6))
                            );
                        }
                        e.fillPolygon(s);
                    } break;
                }
            }
        }
    }
    
}
