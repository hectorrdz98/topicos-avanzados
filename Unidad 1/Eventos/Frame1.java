/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Héctor Rodríguez
 */
public class Frame1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        
        Container contenedor = frame.getContentPane(); // El contenedor principal del frame
        
        JPanel panel = new JPanel(); // Este panel contiene los componentes
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));
        
        JPanel panelSup = new JPanel();
        panelSup.setPreferredSize(new Dimension(800,400));
        panelSup.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        panelSup.setBackground(new Color(150,150,150));
        
        
       // Paneles Superiores
        
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(200,300));
        p1.setBackground(Color.white);
        
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(200,300));
        p2.setBackground(Color.white);
        
        JPanel p3 = new JPanel();
        p3.setPreferredSize(new Dimension(200,300));
        p3.setBackground(Color.white);
        
        panelSup.add(p1);
        panelSup.add(p2);
        panelSup.add(p3);
        
        
        
        JPanel panelInf = new JPanel();
        panelInf.setPreferredSize(new Dimension(800,150));
        panelInf.setBackground(new Color(150,150,150));
        panelInf.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        
        // Panel inferior
        
        JPanel p4 = new JPanel();
        p4.setPreferredSize(new Dimension(700,100));
        p4.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 25));
        p4.setBackground(Color.white);
        
        // Botones
        
        JButton b1 = new JButton("Rojo");
        b1.setPreferredSize(new Dimension(130,50));
        b1.setBackground(Color.red);
        b1.setForeground(Color.white);
        
        b1.addActionListener(new Pintarpaneles(p1));
        
        JButton b2 = new JButton("Verde");
        b2.setPreferredSize(new Dimension(130,50));
        b2.setBackground(Color.green);
        b2.setForeground(Color.white);
        
        b2.addActionListener(new Pintarpaneles(p2));
        
        JButton b3 = new JButton("Azul");
        b3.setPreferredSize(new Dimension(130,50));
        b3.setBackground(Color.blue);
        b3.setForeground(Color.white);
        
        b3.addActionListener(new Pintarpaneles(p3));
        
        JButton b4 = new JButton("Restaurar");
        b4.setPreferredSize(new Dimension(130,50));
        b4.setBackground(Color.white);
        
        JPanel paneles[] = new JPanel[3];
        
        paneles[0] = p1;
        paneles[1] = p2;
        paneles[2] = p3;
        
        b4.addActionListener(new Pintarpaneles(paneles));
        
        p4.add(b1);
        p4.add(b2);
        p4.add(b3);
        p4.add(b4);
        
        panelInf.add(p4);
        
        
        
        panel.add(panelSup);
        panel.add(panelInf);
        
        contenedor.add(panel); // Agregamos al panel principal al contenedor
        
        frame.setSize(850, 615);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(2);
    }
    
}
