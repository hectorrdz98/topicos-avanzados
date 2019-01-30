/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u1a1;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author 1ZW05LA_RS4
 */
public class U1A1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frame frame = new Frame("Mis datos personales");
        Panel panelPrincipal = new Panel();
        
        Panel p1 = new Panel();
        p1.setBackground(new Color(97, 97, 97));
        p1.setPreferredSize(new Dimension(800,75));
        
        Panel p2 = new Panel();
        p2.setBackground(new Color(241, 241, 241));
        p2.setPreferredSize(new Dimension(800,240));
        
        Label eti1 = new Label("Datos Personales");
        eti1.setPreferredSize(new Dimension(800,40));
        eti1.setFont(new Font("Roboto", 0, 24));
        eti1.setAlignment(Label.CENTER);
        
        
        Panel p3 = new Panel();
        //p3.setBackground(Color.cyan);
        p3.setPreferredSize(new Dimension(75,75));
        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 12));
        
        Panel p4 = new Panel();
        //p4.setBackground(Color.cyan);
        p4.setPreferredSize(new Dimension(75,75));
        p4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 12));
        
        //p1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 12));
        p1.setLayout(new BorderLayout());
        
        Label foto = new Label("Foto");
        foto.setPreferredSize(new Dimension(50,50));
        foto.setBackground(Color.white);
        foto.setAlignment(Label.CENTER);
        
        Label logo = new Label("Logo");
        logo.setPreferredSize(new Dimension(50,50));
        logo.setBackground(Color.white);
        logo.setAlignment(Label.CENTER);
        
        p3.add(foto);
        p4.add(logo);
    
        Panel panelesDatos[] = new Panel[6];
        p2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        
        String datosPaneles[] = {"Nombre", "Edad", "Sexo", "Dirección", "Escuela", "Lenguaje"};
        
        for (int i = 0; i < 6; i++) {
            panelesDatos[i] = new Panel();
            panelesDatos[i].setLayout(new FlowLayout(FlowLayout.LEFT, 12, 12));
            //panelesDatos[i].setBackground(Color.RED);
            panelesDatos[i].setPreferredSize(new Dimension(375,50));
            
            Label labelDatos = new Label(datosPaneles[i]);
            labelDatos.setFont(new Font("Roboto", 0, 18));
            labelDatos.setPreferredSize(new Dimension(130,40));
            labelDatos.setAlignment(Label.CENTER);
            labelDatos.setBackground(new Color(97, 97, 97));
            labelDatos.setForeground(Color.WHITE);
            
            TextField textFieldDatos = new TextField("Ingresa tu " + datosPaneles[i].toLowerCase() + "...", 20);
            textFieldDatos.setFont(new Font("Roboto", 0, 15));
            
            panelesDatos[i].add(
                labelDatos
            );
            panelesDatos[i].add(
                textFieldDatos
            );
            p2.add(panelesDatos[i]);
        }
        
        p1.add(p3, BorderLayout.LINE_START);
        p1.add(p4, BorderLayout.LINE_END);
        
        panelPrincipal.add(p1);
        panelPrincipal.add(eti1);
        panelPrincipal.add(p2);
        
        frame.add(panelPrincipal);
        panelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        frame.setVisible(true);
        frame.setSize(850, 435);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        
        ImageIcon img = new ImageIcon("src/u1a1/icono.jpg");
        frame.setIconImage(img.getImage());
    }
    
}
