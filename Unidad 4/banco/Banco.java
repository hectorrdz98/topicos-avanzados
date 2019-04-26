/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Héctor Rodríguez
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    
    static ArrayList<String> listaVIP = new ArrayList<String>();
    static ArrayList<String> listaFrecuente = new ArrayList<String>();
    static ArrayList<String> listaNormal = new ArrayList<String>();
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        JLabel text1 = new JLabel("Banco Héctor");
        text1.setFont(new Font("Roboto", 0, 30));
        text1.setBackground(new Color(102, 0, 255));
        text1.setOpaque(true);
        text1.setForeground(Color.white);
        text1.setPreferredSize(new Dimension(800, 75));
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(800, 250));
        p1.setBackground(new Color(77, 77, 77));
        p1.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 50));
        
        
        // Cajas
        JPanel contP1 = new JPanel();
        contP1.setPreferredSize(new Dimension(250, 150));
        contP1.setBackground(Color.white);
        contP1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        JLabel caja1Tit = new JLabel("Caja #1");
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
        
        contP1.add(caja1Tit);
        contP1.add(caja1Msg);
        contP1.add(caja1Aten);
        
        
        JPanel contP2 = new JPanel();
        contP2.setPreferredSize(new Dimension(250, 150));
        contP2.setBackground(Color.white);
        contP2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        JLabel caja2Tit = new JLabel("Caja #2");
        caja2Tit.setFont(new Font("Roboto", 0, 25));
        caja2Tit.setBackground(new Color(204, 0, 0));
        caja2Tit.setOpaque(true);
        caja2Tit.setForeground(Color.white);
        caja2Tit.setPreferredSize(new Dimension(250, 50));
        caja2Tit.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel caja2Msg = new JLabel("Sin clientes");
        caja2Msg.setFont(new Font("Roboto", 0, 18));
        caja2Msg.setForeground(new Color(102, 102, 102));
        caja2Msg.setPreferredSize(new Dimension(250, 40));
        caja2Msg.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel caja2Aten = new JLabel();
        caja2Aten.setFont(new Font("Roboto", 1, 20));
        caja2Aten.setForeground(new Color(102, 0, 51));
        caja2Aten.setPreferredSize(new Dimension(250, 60));
        caja2Aten.setHorizontalAlignment(SwingConstants.CENTER);
        
        contP2.add(caja2Tit);
        contP2.add(caja2Msg);
        contP2.add(caja2Aten);
        
        
        p1.add(contP1);
        p1.add(contP2);
        
        
        
        // Filas
        
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(800, 350));
        p2.setBackground(new Color(230, 230, 230));
        p2.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        
        JPanel fila1 = new JPanel();
        fila1.setPreferredSize(new Dimension(200, 250));
        fila1.setBackground(Color.white);
        fila1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        JLabel fila1T = new JLabel("Fila VIP");
        fila1T.setFont(new Font("Roboto", 0, 20));
        fila1T.setBackground(new Color(51, 51, 153));
        fila1T.setOpaque(true);
        fila1T.setForeground(Color.white);
        fila1T.setPreferredSize(new Dimension(200, 30));
        fila1T.setHorizontalAlignment(SwingConstants.CENTER);
        
        JScrollPane scrollPanefilaVIP = new JScrollPane();
        JList filaVIP = new JList();
        DefaultListCellRenderer rendererfilaVIP =  (DefaultListCellRenderer)filaVIP.getCellRenderer();  
        rendererfilaVIP.setHorizontalAlignment(JLabel.CENTER);  
        scrollPanefilaVIP.setViewportView(filaVIP);
        scrollPanefilaVIP.setPreferredSize(new Dimension(200, 220));
        
        fila1.add(fila1T);
        fila1.add(scrollPanefilaVIP);
        
        
        
        JPanel fila2 = new JPanel();
        fila2.setPreferredSize(new Dimension(200, 250));
        fila2.setBackground(Color.white);
        fila2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        JLabel fila2T = new JLabel("Fila Frecuente");
        fila2T.setFont(new Font("Roboto", 0, 20));
        fila2T.setBackground(new Color(51, 51, 153));
        fila2T.setOpaque(true);
        fila2T.setForeground(Color.white);
        fila2T.setPreferredSize(new Dimension(200, 30));
        fila2T.setHorizontalAlignment(SwingConstants.CENTER);
        
        JScrollPane scrollPanefilaFrec = new JScrollPane();
        JList filaFrec = new JList();
        DefaultListCellRenderer rendererfilaFrec =  (DefaultListCellRenderer)filaFrec.getCellRenderer();  
        rendererfilaFrec.setHorizontalAlignment(JLabel.CENTER); 
        scrollPanefilaFrec.setViewportView(filaFrec);
        scrollPanefilaFrec.setPreferredSize(new Dimension(200, 220));
        
        fila2.add(fila2T);
        fila2.add(scrollPanefilaFrec);
        
        
        
        JPanel fila3 = new JPanel();
        fila3.setPreferredSize(new Dimension(200, 250));
        fila3.setBackground(Color.white);
        fila3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        JLabel fila3T = new JLabel("Fila Normal");
        fila3T.setFont(new Font("Roboto", 0, 20));
        fila3T.setBackground(new Color(51, 51, 153));
        fila3T.setOpaque(true);
        fila3T.setForeground(Color.white);
        fila3T.setPreferredSize(new Dimension(200, 30));
        fila3T.setHorizontalAlignment(SwingConstants.CENTER);
        
        JScrollPane scrollPanefilaNormal = new JScrollPane();
        JList filaNormal = new JList();
        DefaultListCellRenderer rendererfilaNormal =  (DefaultListCellRenderer)filaNormal.getCellRenderer();  
        rendererfilaNormal.setHorizontalAlignment(JLabel.CENTER); 
        scrollPanefilaNormal.setViewportView(filaNormal);
        scrollPanefilaNormal.setPreferredSize(new Dimension(200, 220));
        
        fila3.add(fila3T);
        fila3.add(scrollPanefilaNormal);
        
        
        
        p2.add(fila1);
        p2.add(fila2);
        p2.add(fila3);
        
        
        // Novedades
        
        JPanel p3 = new JPanel();
        p3.setPreferredSize(new Dimension(800, 75));
        p3.setBackground(new Color(77, 77, 77));
        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 12));
        
        JLabel llegada = new JLabel("Llega:");
        llegada.setFont(new Font("Roboto", 0, 18));
        llegada.setForeground(Color.white);
        llegada.setPreferredSize(new Dimension(600, 50));
        llegada.setHorizontalAlignment(SwingConstants.CENTER);
        
        JList filas[] = { filaVIP, filaFrec, filaNormal };
        
        Llegada llegadaThread = new Llegada(llegada, filas);
        llegadaThread.iniciar();
        
        
        Caja caja1 = new Caja(caja1Aten, caja1Msg, filas);
        Caja caja2 = new Caja(caja2Aten, caja2Msg, filas);
        
        caja1.iniciar();
        caja2.iniciar();
        
        
        
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
