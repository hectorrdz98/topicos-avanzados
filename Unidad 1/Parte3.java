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
public class Parte3 extends Applet {

    public void paint(Graphics e) {
        
        int dia = 600;
        int r1 = dia/2;
        int r2 = (int) (dia/2.5);
        int r3 = (int) (dia/3);
        int r4 = (int) (dia/10);
        int pos = 50;
        int points = 10;
        int centro[] = {pos + r1, pos + r1};
        
        e.setColor(Color.BLACK);
        
        e.drawOval(pos, pos, dia, dia);
        
        for (int  i = 0; i<points; i++) {
            e.drawLine(
                centro[0], 
                centro[1], 
                centro[0] + (int) (r1 * Math.sin(i * Math.PI / 5)), 
                centro[1] + (int) (r1 * Math.cos(i * Math.PI / 5))
            );
        }
        
        Polygon s = new Polygon();
        for (int k = 0; k < points * 2; k++) {
            if (k%2 == 0) {
                s.addPoint(
                    centro[0] + (int) (r2 * Math.sin(k * Math.PI / 10)), 
                    centro[1] + (int) (r2 * Math.cos(k * Math.PI / 10))
                );
            } else {
                s.addPoint(
                    centro[0] + (int) (r1 * Math.sin(k * Math.PI / 10)), 
                    centro[1] + (int) (r1 * Math.cos(k * Math.PI / 10))
                );
            }
            
        }
        e.drawPolygon(s);
        
        Polygon s2 = new Polygon();
        for (int k = 0; k < points * 2; k++) {
            if (k%2 == 0) {
                s2.addPoint(
                    centro[0] + (int) (r2 * Math.sin(k * Math.PI / 10)), 
                    centro[1] + (int) (r2 * Math.cos(k * Math.PI / 10))
                );
            } else {
                s2.addPoint(
                    centro[0] + (int) (r3 * Math.sin(k * Math.PI / 10)), 
                    centro[1] + (int) (r3 * Math.cos(k * Math.PI / 10))
                );
            }
            
        }
        e.drawPolygon(s2);
        
        Polygon s3 = new Polygon();
        for (int k = 0; k < points * 2; k++) {
            if (k%2 == 0) {
                s3.addPoint(
                    centro[0] + (int) (r4 * Math.sin(k * Math.PI / 10)), 
                    centro[1] + (int) (r4 * Math.cos(k * Math.PI / 10))
                );
            } else {
                s3.addPoint(
                    centro[0] + (int) (r3 * Math.sin(k * Math.PI / 10)), 
                    centro[1] + (int) (r3 * Math.cos(k * Math.PI / 10))
                );
            }
            
        }
        e.drawPolygon(s3);
        
        
    }

    // TODO overwrite start(), stop() and destroy() methods
}
