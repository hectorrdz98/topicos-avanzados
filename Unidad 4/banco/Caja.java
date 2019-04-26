/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Héctor Rodríguez
 */
public class Caja extends Thread {
    
    boolean continuar;
    JLabel texto, aux;
    Thread hilo;
    JList filas[];
    
    public Caja(JLabel texto, JLabel aux, JList filas[]) {
        this.texto = texto;
        this.aux = aux;
        this.filas = filas;
    }
    
    @Override
    public void run() {
        System.out.println("Inicia la caja: " + this.getName());
        
        while(continuar) {
            
            /* int delay = ThreadLocalRandom.current().nextInt(3, 6 + 1);    // Cada 3 a 6 seg
            System.out.println("Inicia delay en " + this.getName() + " -> " + delay);
            
            try {
                Thread.sleep(delay * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Llegada.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Termina delay en " + this.getName()); */
            
            // Quitar uno de la lista
            
            String elemento = "";
            
            if (Banco.listaVIP.size() > 0) {
                elemento = Banco.listaVIP.remove(0);
            } else if (Banco.listaFrecuente.size() > 0) {
                elemento = Banco.listaFrecuente.remove(0);
            } else if (Banco.listaNormal.size() > 0) {
                elemento = Banco.listaNormal.remove(0);
            } 
            
            System.out.println("El elemento es: " + elemento);
            
            if (elemento.equals("")) {
                aux.setText("Sin clientes");
                texto.setText("");
            } else {
                aux.setText("Atendiendo a:");
                texto.setText(elemento);
            }
            
            // Actualizar filas
            
            String listaAux[]  = new String[Banco.listaVIP.size()];
            for (int i = 0; i<Banco.listaVIP.size(); i++) {
                listaAux[i] = Banco.listaVIP.get(i);
            }
            filas[0].setListData(listaAux);
            
            listaAux  = new String[Banco.listaFrecuente.size()];
            for (int i = 0; i<Banco.listaFrecuente.size(); i++) {
                listaAux[i] = Banco.listaFrecuente.get(i);
            }
            filas[1].setListData(listaAux);
            
            listaAux  = new String[Banco.listaNormal.size()];
            for (int i = 0; i<Banco.listaNormal.size(); i++) {
                listaAux[i] = Banco.listaNormal.get(i);
            }
            filas[2].setListData(listaAux);
            
            
            // Esperas
            if (elemento.equals("")) {
                // Si no atendió espera 1 seg para volver a atender
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Llegada.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                // Si atendiende a alguien espera entre 6 y 10 seg para acabar de atenderlo
                int delay = ThreadLocalRandom.current().nextInt(6, 10 + 1);    // Cada 3 a 6 seg
                System.out.println("Inicia delay en " + this.getName() + " -> " + delay);

                try {
                    Thread.sleep(delay * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Llegada.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println("Termina delay en " + this.getName());
            }
        }
    }
    
    public void iniciar() {
        this.continuar = true;
        this.hilo = new Thread( this );
        this.hilo.start();
    }

    public void parar(){
        this.continuar = false;
    }
    
}
