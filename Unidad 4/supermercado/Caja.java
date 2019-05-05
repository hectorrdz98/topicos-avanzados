/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.Arrays;
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
    
    boolean continuar = true;
    JLabel texto, texto2, aux;
    JList fila;
    
    public Caja(JLabel texto, JLabel texto2, JLabel aux, JList fila) {
        this.texto = texto;
        this.texto2 = texto2;
        this.aux = aux;
        this.fila = fila;
    }
    
    @Override
    public void run() {
        System.out.println("Inicia la caja");
        
        while(continuar) {
            
            // Quitar uno de la lista
            
            String cliente = "";
            int articulo[] = null;
            
            if (Supermercado.fila.size() > 0 && Supermercado.articulos.size() > 0) {
                cliente = Supermercado.fila.remove(0);
                articulo = Supermercado.articulos.remove(0);
            }
            
            System.out.println("El cliente a atender es: " + cliente + " y lleva " + Arrays.toString(articulo));
            
            if (cliente.equals("") || articulo == null) {
                aux.setText("Sin clientes");
                texto.setText("");
                texto2.setText("");
            } else {
                aux.setText("Atendiendo a:");
                texto.setText(cliente);
            }
            
            // Actualizar filas
            
            String listaAux[]  = new String[Supermercado.fila.size()];
            for (int i = 0; i<Supermercado.fila.size(); i++) {
                listaAux[i] = Supermercado.fila.get(i) + " lleva " + Arrays.toString(Supermercado.articulos.get(i));
            }
            fila.setListData(listaAux);
            
            
            // Esperas
            if (cliente.equals("") || articulo == null) {
                // Si no atendió espera 1 seg para volver a atender
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Llegada.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                // Si atendiende a alguien espera el tiempo de cada articulo
                
                for (int i = 0; i<articulo.length; i++) {
                    int delay = articulo[i];
                    System.out.println("Inicia delay para articulo " + (i + 1) + " -> " + delay);
                    texto2.setText("Pasando articulo " + (i + 1) + " por " + delay + "s");
                    try {
                        Thread.sleep(delay * 1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Llegada.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Termina delay para articulo " + (i + 1));
                }
            }
        }
    }

    public void parar(){
        this.continuar = false;
    }
    
}
