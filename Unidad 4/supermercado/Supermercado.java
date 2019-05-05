/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Héctor Rodríguez
 */
public class Supermercado {

    static ArrayList<String> fila = new ArrayList<String>();
    static ArrayList<int[]> articulos = new ArrayList<int[]>();
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        JLabel text1 = new JLabel("Mini-Supermercado");
        text1.setFont(new Font("Roboto", 0, 30));
        text1.setBackground(new Color(102, 0, 255));
        text1.setOpaque(true);
        text1.setForeground(Color.white);
        text1.setPreferredSize(new Dimension(800, 75));
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(800, 250));
        p1.setBackground(new Color(77, 77, 77));
        p1.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 25));
        
        
        // Caja
        JPanel contP1 = new JPanel();
        contP1.setPreferredSize(new Dimension(250, 200));
        contP1.setBackground(Color.white);
        contP1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        JLabel caja1Tit = new JLabel("Caja");
        caja1Tit.setFont(new Font("Roboto", 0, 25));
        caja1Tit.setBackground(new Color(51, 153, 102));
        caja1Tit.setOpaque(true);
        caja1Tit.setForeground(Color.white);
        caja1Tit.setPreferredSize(new Dimension(250, 50));
        caja1Tit.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel caja1Msg = new JLabel("Sin clientes");
        caja1Msg.setFont(new Font("Roboto", 0, 18));
        caja1Msg.setForeground(new Color(102, 102, 102));
        caja1Msg.setPreferredSize(new Dimension(250, 40));
        caja1Msg.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel caja1Aten = new JLabel();
        caja1Aten.setFont(new Font("Roboto", 1, 20));
        caja1Aten.setForeground(new Color(0, 77, 0));
        caja1Aten.setPreferredSize(new Dimension(250, 60));
        caja1Aten.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel caja1Msg2 = new JLabel();
        caja1Msg2.setFont(new Font("Roboto", 0, 18));
        caja1Msg2.setForeground(new Color(102, 102, 102));
        caja1Msg2.setPreferredSize(new Dimension(250, 40));
        caja1Msg2.setHorizontalAlignment(SwingConstants.CENTER);
        
        contP1.add(caja1Tit);
        contP1.add(caja1Msg);
        contP1.add(caja1Aten);
        contP1.add(caja1Msg2);
        
        p1.add(contP1);
        
        
        
        // Filas
        
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(800, 350));
        p2.setBackground(new Color(230, 230, 230));
        p2.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        
        JPanel fila1 = new JPanel();
        fila1.setPreferredSize(new Dimension(400, 250));
        fila1.setBackground(Color.white);
        fila1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        JLabel fila1T = new JLabel("Fila de clientes");
        fila1T.setFont(new Font("Roboto", 0, 20));
        fila1T.setBackground(new Color(51, 51, 153));
        fila1T.setOpaque(true);
        fila1T.setForeground(Color.white);
        fila1T.setPreferredSize(new Dimension(400, 50));
        fila1T.setHorizontalAlignment(SwingConstants.CENTER);
        
        JScrollPane scrollPanefilaVIP = new JScrollPane();
        JList filaClientes = new JList();
        DefaultListCellRenderer rendererfilaVIP =  (DefaultListCellRenderer)filaClientes.getCellRenderer();  
        rendererfilaVIP.setHorizontalAlignment(JLabel.CENTER);  
        scrollPanefilaVIP.setViewportView(filaClientes);
        scrollPanefilaVIP.setPreferredSize(new Dimension(400, 200));
        
        fila1.add(fila1T);
        fila1.add(scrollPanefilaVIP);
        
        
        p2.add(fila1);
        
        
        // Novedades
        
        JPanel p3 = new JPanel();
        p3.setPreferredSize(new Dimension(800, 75));
        p3.setBackground(new Color(77, 77, 77));
        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 12));
        
        JLabel llegada = new JLabel("Info sobre lo que ocurre");
        llegada.setFont(new Font("Roboto", 0, 18));
        llegada.setForeground(Color.white);
        llegada.setPreferredSize(new Dimension(600, 50));
        llegada.setHorizontalAlignment(SwingConstants.CENTER);
        

        
        // Hilo para los clientes
        
        Llegada llegadaThread = new Llegada(llegada, filaClientes);
        llegadaThread.start();
        
        // Hilo para la caja
        
        Caja caja1 = new Caja(caja1Aten, caja1Msg2, caja1Msg, filaClientes);
        caja1.start();
        
        
        
        
        JLabel tiempo = new JLabel("00:00:000");
        tiempo.setFont(new Font("Roboto", 0, 18));
        tiempo.setForeground(Color.white);
        tiempo.setBackground(new Color(102, 0, 255));
        tiempo.setOpaque(true);
        tiempo.setPreferredSize(new Dimension(100, 50));
        tiempo.setHorizontalAlignment(SwingConstants.CENTER);
        
        Cronometro cronometro = new Cronometro(tiempo);
        cronometro.iniciarCronometro();
        
        p3.add(llegada);
        p3.add(tiempo);
        
        
        panel.add(text1);
        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        
        frame.add(panel);
        
        frame.setVisible(true);
        frame.setSize(800,795);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
