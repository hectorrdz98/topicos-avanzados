/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Héctor Rodríguez
 */
public class Pintarpaneles implements ActionListener{
    
    JPanel panel;
    JPanel paneles[];
    
    Pintarpaneles (JPanel panel) {
        this.panel = panel;
        this.paneles = null;
    }
    
    Pintarpaneles (JPanel paneles[]) {
        this.panel = null;
        this.paneles = paneles;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton fuente = (JButton) e.getSource();
        String Seleccioncolor = fuente.getActionCommand();
        
        if (panel != null) {
            if (Seleccioncolor.equals("Rojo")) {
                panel.setBackground(Color.red);
            } else if (Seleccioncolor.equals("Azul")) {
                panel.setBackground(Color.blue);
            } else if (Seleccioncolor.equals("Verde")) {
                panel.setBackground(Color.green);
            } 
        }
        
        if (paneles != null) {
            for (int i = 0; i<3; i++) {
                paneles[i].setBackground(Color.white);
            }
        }
        
    }
}
