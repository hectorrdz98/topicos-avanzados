/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivero;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Héctor Rodríguez
 */
public class Vivero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frame frame = new Frame("Mis datos personales");
        
        Panel panelP = new Panel();
        panelP.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        Label labelT = new Label("Vivero de Héctor");
        labelT.setBackground(new Color(0, 102, 153));
        labelT.setPreferredSize(new Dimension(1280, 80));
        labelT.setForeground(Color.WHITE);
        labelT.setAlignment(Label.CENTER);
        labelT.setFont(new Font("Roboto", 0, 28));
        
        Panel panelInf = new Panel();
        panelInf.setPreferredSize(new Dimension(1000, 640));
        panelInf.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        
        // PANEL IZQ
        
        Panel panelIzq = new Panel();
        panelIzq.setPreferredSize(new Dimension(600, 640));
        panelIzq.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        
        Panel aux1 =  new Panel();
        aux1.setPreferredSize(new Dimension(600, 40));
        
        panelIzq.add(aux1);
        
        
        
        
        Panel m1 = new Panel();
        m1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
        m1.setPreferredSize(new Dimension(250, 300));
        
        Label labelT1 = new Label("Árboles");
        labelT1.setAlignment(Label.LEFT);
        labelT1.setPreferredSize(new Dimension(250, 60));
        labelT1.setFont(new Font("Roboto", 0, 24));
        
        Label labelM1 = new Label();
        labelM1.setBackground(new Color(10,10,10));
        labelM1.setPreferredSize(new Dimension(150, 2));
        
        m1.add(labelT1);
        m1.add(labelM1);
        
        Panel check1 = new Panel();
        check1.setPreferredSize(new Dimension(250, 150));
        check1.setLayout(new GridLayout(5,1));
        
        Checkbox arbolesC[] = new Checkbox[5];
        String arboles[] = { "Encina", "Pino Carrasco", "Pino Albar", "Roble Continental", "Castaño" };
        String arbolesP[] = { "123", "50", "100", "80", "54" };
        
        for (int i = 0; i < 5; i++) {
            arbolesC[i] = new Checkbox(arboles[i] + "  -  $" + arbolesP[i], false);
            arbolesC[i].setFont(new Font("Roboto", 0, 18));
            check1.add(arbolesC[i]);
        }
        
        m1.add(check1);
        
        panelIzq.add(m1);
        
        
        
        Panel m2 = new Panel();
        m2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
        m2.setPreferredSize(new Dimension(250, 300));
        
        Label labelT2 = new Label("Arbustos");
        labelT2.setAlignment(Label.LEFT);
        labelT2.setPreferredSize(new Dimension(250, 60));
        labelT2.setFont(new Font("Roboto", 0, 24));
        
        Label labelM2 = new Label();
        labelM2.setBackground(new Color(10,10,10));
        labelM2.setPreferredSize(new Dimension(150, 2));
        
        m2.add(labelT2);
        m2.add(labelM2);
        
        Panel check2 = new Panel();
        check2.setPreferredSize(new Dimension(250, 150));
        check2.setLayout(new GridLayout(5,1));
        
        CheckboxGroup prueba = new CheckboxGroup();
        
        Checkbox arbustosC[] = new Checkbox[4];
        String arbustos[] = { "Abelia", "Adelfa", "Aligustre", "Celindo" };
        String arbustosP[] = { "43", "21", "65", "98" };
        
        for (int i = 0; i < 4; i++) {
            arbustosC[i] = new Checkbox(arbustos[i] + "  -  $" + arbustosP[i], false, prueba);
            arbustosC[i].setFont(new Font("Roboto", 0, 18));
            check2.add(arbustosC[i]);
        }
        
        m2.add(check2);
        
        panelIzq.add(m2);
        
        
        Panel m3 = new Panel();
        m3.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
        m3.setPreferredSize(new Dimension(250, 300));
        
        Label labelT3 = new Label("Flores");
        labelT3.setAlignment(Label.LEFT);
        labelT3.setPreferredSize(new Dimension(250, 60));
        labelT3.setFont(new Font("Roboto", 0, 24));
        
        Label labelM3 = new Label();
        labelM3.setBackground(new Color(10,10,10));
        labelM3.setPreferredSize(new Dimension(150, 2));
        
        m3.add(labelT3);
        m3.add(labelM3);
        
        Panel check3 = new Panel();
        check3.setPreferredSize(new Dimension(250, 150));
        check3.setLayout(new GridLayout(5,1));
        
        Checkbox floresC[] = new Checkbox[6];
        String flores[] = { "Clavel", "Crisantemo", "Dalia", "Alfalfa",  "Anturio",  "Begonia" };
        String floresP[] = { "24", "13", "150", "76", "85", "90" };
        
        for (int i = 0; i < 4; i++) {
            floresC[i] = new Checkbox(flores[i] + "  -  $" + floresP[i], false);
            floresC[i].setFont(new Font("Roboto", 0, 18));
            check3.add(floresC[i]);
        }
        
        m3.add(check3);
        
        panelIzq.add(m3);
        
        
        
        Panel m4 = new Panel();
        m4.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
        m4.setPreferredSize(new Dimension(250, 300));
        
        Label labelT4 = new Label("Ornamentos");
        labelT4.setAlignment(Label.LEFT);
        labelT4.setPreferredSize(new Dimension(250, 60));
        labelT4.setFont(new Font("Roboto", 0, 24));
        
        Label labelM4 = new Label();
        labelM4.setBackground(new Color(10,10,10));
        labelM4.setPreferredSize(new Dimension(150, 2));
        
        m4.add(labelT4);
        m4.add(labelM4);
        
        Panel check4 = new Panel();
        check4.setPreferredSize(new Dimension(250, 150));
        check4.setLayout(new GridLayout(5,1));
        
        Checkbox ornaC[] = new Checkbox[6];
        String orna[] = { "Lamparas", "Macetas", "Nomos" };
        String ornaP[] = { "300", "120", "40" };
        
        for (int i = 0; i < 3; i++) {
            ornaC[i] = new Checkbox(orna[i] + "  -  $" + ornaP[i], false, prueba);
            ornaC[i].setFont(new Font("Roboto", 0, 18));
            check4.add(ornaC[i]);
        }
        
        m4.add(check4);
        
        panelIzq.add(m4);
        
        
        // PANEL DER
        
        Panel panelDer = new Panel();
        panelDer.setPreferredSize(new Dimension(400, 640));
        
        Label labelCarrito = new Label("Carrito de compras");
        labelCarrito.setBackground(new Color(0, 102, 153));
        labelCarrito.setPreferredSize(new Dimension(400, 60));
        labelCarrito.setForeground(Color.WHITE);
        labelCarrito.setAlignment(Label.CENTER);
        labelCarrito.setFont(new Font("Roboto", 0, 20));
        
        panelDer.add(labelCarrito);
        
        Panel auxa1 = new Panel();
        auxa1.setPreferredSize(new Dimension(400, 30));
        auxa1.setLayout(new BorderLayout());
        
        Label prep1 = new Label("Clavel");
        prep1.setPreferredSize(new Dimension(80, 30));
        prep1.setFont(new Font("Roboto", 1, 12));
        
        Label prep2 = new Label("Cantidad 1");
        prep2.setPreferredSize(new Dimension(80, 30));
        prep2.setFont(new Font("Roboto", 0, 12));
        
        auxa1.add(prep1, BorderLayout.WEST);
        auxa1.add(prep2, BorderLayout.CENTER);
        auxa1.add(new Label("$24"), BorderLayout.EAST);
        
        Panel auxa2 = new Panel();
        auxa2.setPreferredSize(new Dimension(400, 30));
        auxa2.setLayout(new BorderLayout());
        
        Label prep3 = new Label("Dalia");
        prep3.setPreferredSize(new Dimension(80, 30));
        prep3.setFont(new Font("Roboto", 1, 12));
        
        Label prep4 = new Label("Cantidad 2");
        prep4.setPreferredSize(new Dimension(80, 30));
        prep4.setFont(new Font("Roboto", 0, 12));
        
        auxa2.add(prep3, BorderLayout.WEST);
        auxa2.add(prep4, BorderLayout.CENTER);
        auxa2.add(new Label("$300"), BorderLayout.EAST);
        
        Panel auxa3 = new Panel();
        auxa3.setPreferredSize(new Dimension(400, 30));
        auxa3.setLayout(new BorderLayout());
        
        Label prep5 = new Label("Begonia");
        prep5.setPreferredSize(new Dimension(80, 30));
        prep5.setFont(new Font("Roboto", 1, 12));
        
        Label prep6 = new Label("Cantidad 3");
        prep6.setPreferredSize(new Dimension(80, 30));
        prep6.setFont(new Font("Roboto", 0, 12));
        
        auxa3.add(prep5, BorderLayout.WEST);
        auxa3.add(prep6, BorderLayout.CENTER);
        auxa3.add(new Label("$180"), BorderLayout.EAST);
        
        panelDer.add(auxa1);
        panelDer.add(auxa2);
        panelDer.add(auxa3);
        
        Panel asfasf1 = new Panel();
        asfasf1.setBackground(Color.BLACK);
        asfasf1.setPreferredSize(new Dimension(400, 1));
        
        panelDer.add(asfasf1);
        
        Label total1 = new Label("Total = " + "$504");
        total1.setAlignment(Label.CENTER);
        total1.setPreferredSize(new Dimension(120, 30));
        total1.setFont(new Font("Roboto", 1, 16));
        
        panelDer.add(total1);
        
        Panel datosInf = new Panel();
        datosInf.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 20));
        datosInf.setPreferredSize(new Dimension(400, 400));
        
        Label total2 = new Label("Datos de entrega");
        total2.setBackground(new Color(0, 102, 153));
        total2.setPreferredSize(new Dimension(400, 60));
        total2.setForeground(Color.WHITE);
        total2.setAlignment(Label.CENTER);
        total2.setFont(new Font("Roboto", 0, 20));
        
        Choice choice1 = new Choice();
        choice1.setFont(new Font("Roboto", 0, 16));
        choice1.add("Entrega a domicilio");
        choice1.add("Recoger en sucursal");
        choice1.add("Acordar con el vendedor");
        
        datosInf.add(total2);
        datosInf.add(choice1);
        
        Panel fa1 = new Panel();
        fa1.setPreferredSize(new Dimension(400, 30));
        fa1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        
        Label t1s = new Label("Nombre");
        t1s.setPreferredSize(new Dimension(100, 30));
        t1s.setFont(new Font("Roboto", 1, 16));
        
        TextField t1 = new TextField("Ingrese su nombre...");
        t1.setFont(new Font("Roboto", 0, 16));
        
        fa1.add(t1s);
        fa1.add(t1);
        
        datosInf.add(fa1);
        
        Panel fa2 = new Panel();
        fa2.setPreferredSize(new Dimension(400, 30));
        fa2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        
        Label t2s = new Label("Correo");
        t2s.setPreferredSize(new Dimension(100, 30));
        t2s.setFont(new Font("Roboto", 1, 16));
        
        TextField t2 = new TextField("Ingrese su correo...");
        t2.setFont(new Font("Roboto", 0, 16));
        
        fa2.add(t2s);
        fa2.add(t2);
        
        datosInf.add(fa2);
        
        Panel fa3 = new Panel();
        fa3.setPreferredSize(new Dimension(400, 80));
        fa3.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        
        Label t3s = new Label("Comentarios");
        t3s.setPreferredSize(new Dimension(150, 30));
        t3s.setFont(new Font("Roboto", 1, 16));
        
        TextArea t3 = new TextArea("Ingrese sus comentarios...", 3, 20, TextArea.SCROLLBARS_VERTICAL_ONLY);
        t3.setFont(new Font("Roboto", 0, 16));
        
        fa3.add(t3s);
        fa3.add(t3);
        
        datosInf.add(fa3);
        
        Button total3 = new Button("Pagar");
        total3.setBackground(new Color(0, 102, 153));
        total3.setPreferredSize(new Dimension(100, 60));
        total3.setForeground(Color.WHITE);
        total3.setFont(new Font("Roboto", 0, 20));
        
        datosInf.add(total3);
        
        panelDer.add(datosInf);
        
        panelInf.add(panelIzq);
        panelInf.add(panelDer);
        
        panelP.add(labelT);
        panelP.add(panelInf);
        
        frame.add(panelP);
        
        frame.setVisible(true);
        frame.setSize(1280, 800);
        frame.setLocation(960 - 640, 540 - 360);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    
}
