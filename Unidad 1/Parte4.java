/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenu2.pkg1;

import java.applet.Applet;
import java.awt.*;

/**
 *
 * @author Héctor Rodríguez
 */
public class Parte4 extends Applet {

    public void init() {
        Panel e1 = new Panel();
        e1.setPreferredSize(new Dimension(2000,25));
        add(e1);
    
        // CABEZA
        
        Panel e2 = new Panel();
        e2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        e2.setPreferredSize(new Dimension(2000,300));
        
        Panel p1 = new Panel();
        p1.setPreferredSize(new Dimension(400,300));
        p1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 60));
        p1.setBackground(new Color(51, 51, 153));
        
        Panel p11 = new Panel();
        p11.setPreferredSize(new Dimension(400,100));
        p11.setLayout(new FlowLayout(FlowLayout.LEFT, 45, 0));
        
        Panel p111 = new Panel();
        p111.setPreferredSize(new Dimension(130,100));
        p111.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 35));
        p111.setBackground(new Color(255,255,255));
        
        Label ojo1 = new Label();
        ojo1.setBackground(Color.BLACK);
        ojo1.setPreferredSize(new Dimension(40,40));
        p111.add(ojo1);
        
        p11.add(p111);

        Panel p112 = new Panel();
        p112.setPreferredSize(new Dimension(130,100));
        p112.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 35));
        p112.setBackground(new Color(255,255,255));
        
        Label ojo2 = new Label();
        ojo2.setBackground(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
        ojo2.setPreferredSize(new Dimension(40,40));
        p112.add(ojo2);
        
        p11.add(p112);
        
        p1.add(p11);
        
        // Boca esa
        
        Panel p12 = new Panel();
        p12.setPreferredSize(new Dimension(400,100));
        p12.setBackground(new Color(0, 77, 0));
        p12.setLayout(new FlowLayout(FlowLayout.CENTER, 45, 27));
        
        TextField tf1 = new TextField(20);
        p12.add(tf1);
        
        
        p1.add(p12);
        
        e2.add(p1);
        
        add(e2);
        
        // CUELLO
        
        Panel e3 = new Panel();
        e3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        e3.setPreferredSize(new Dimension(2000,30));
        
        Panel p2 = new Panel();
        p2.setPreferredSize(new Dimension(150,30));
        p2.setBackground(new Color(51, 51, 153));
        e3.add(p2);
        
        add(e3);
        
        // TRONCO
        
        Panel e4= new Panel();
        e4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        e4.setPreferredSize(new Dimension(2000,350));
        
        Panel p3 = new Panel();
        p3.setPreferredSize(new Dimension(300,350));
        p3.setBackground(new Color(51, 51, 153));
        
        // Moño
        
        Label p31 = new Label();
        p31.setPreferredSize(new Dimension(40, 50));
        p31.setBackground(new Color(0, 77, 0));
        p3.add(p31);
        
        Label p32 = new Label();
        p32.setPreferredSize(new Dimension(30, 20));
        p32.setBackground(new Color(0, 128, 64));
        p3.add(p32);
        
        Label p33 = new Label();
        p33.setPreferredSize(new Dimension(40, 50));
        p33.setBackground(new Color(0, 77, 0));
        p3.add(p33);
        
        // Panel intermedio
        
        Panel pi2 = new Panel();
        pi2.setPreferredSize(new Dimension(200,210));
        p3.add(pi2);
        
        // Detalle del pantalon
        
        Label pi1 = new Label();
        pi1.setPreferredSize(new Dimension(200,75));
        pi1.setBackground(new Color(0, 77, 0));
        p3.add(pi1);
        
        e4.add(p3);
        
        add(e4);
        
        // PIERNAS
        
        Panel e5= new Panel();
        e5.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        e5.setPreferredSize(new Dimension(2000,350));
        
        Panel p4 = new Panel();
        p4.setPreferredSize(new Dimension(200,350));
        p4.setBackground(new Color(0, 77, 0));
        p4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        Panel zaps1 = new Panel();
        zaps1.setPreferredSize(new Dimension(200,175));
        p4.add(zaps1);
        
        Panel zaps = new Panel();
        zaps.setPreferredSize(new Dimension(200,75));
        zaps.setLayout(new BorderLayout(0,0));
        p4.add(zaps);
        
        Button zap1 = new Button();
        zap1.setBackground(new Color(0, 0, 0));
        zap1.setPreferredSize(new Dimension(100, 60));
        zap1.setForeground(Color.WHITE);
        zap1.setFont(new Font("Roboto", 0, 20));
        
        zaps.add(zap1, BorderLayout.EAST);
        
        Button zap2 = new Button();
        zap2.setBackground(new Color(0, 0, 0));
        zap2.setPreferredSize(new Dimension(100, 60));
        zap2.setForeground(Color.WHITE);
        zap2.setFont(new Font("Roboto", 0, 20));
        
        zaps.add(zap2, BorderLayout.WEST);
        
        e5.add(p4);
        
        add(e5);
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }

}
