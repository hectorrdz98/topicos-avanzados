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
public class Llegada extends Thread {
    boolean continuar = true;
    JLabel texto;
    JList fila;
    
    String nombres[] = {
        "Héctor", "Miguel", "Manuel", "Noah", "Pedro",
        "Gabriel", "Antonio", "Giovanni", "Gerardo", "Ernin",
        "Luis", "Alexis", "Alma", "Emilitia", "Cloth"
    };
    
    String apellidos[] = {
        "Rodríguez", "Perez", "Juarez", "Mendez", "Feregrino",
        "O'Donnell", "Cruz", "Frausto", "Mendoza", "Alegría",
        "Cobalto", "Sal", "Granados", "Feliz", "Huerta"
    };
    
    public Llegada(JLabel texto, JList fila) {
        this.texto = texto;
        this.fila = fila;
    }
    
    @Override
    public void run() {
        
        int tiempoLlegada = ThreadLocalRandom.current().nextInt(3, 6 + 1);    // Cada 3 a 6 seg llega un cliente
        System.out.println("Inicia la llegada de clientes");
        
        while(continuar) {
            
            System.out.println("\nEl cliente espera " + tiempoLlegada + "s");
            
            try {
                Thread.sleep(tiempoLlegada * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Llegada.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Terminó la espera, por lo que llega un cliente
            int idNombre = ThreadLocalRandom.current().nextInt(0, 14 + 1);
            int idApellido = ThreadLocalRandom.current().nextInt(0, 14 + 1);
            String nombre = nombres[idNombre] + " " + apellidos[idApellido];
            
            
            
            // Obtener los articulos
            
            int numArticulos = ThreadLocalRandom.current().nextInt(1, 5 + 1);    // De 1 a 5 articulos
            int articulos[] = new int[numArticulos]; 
            
            String articulosFormato = "[ "; 
            for (int i = 0; i<numArticulos; i++) {
                int valorArticulo = ThreadLocalRandom.current().nextInt(1, 3 + 1);    // De 1 a 3 segundos en cada articulo
                articulos[i] = valorArticulo;
                articulosFormato += articulos[i];
                if (i < numArticulos - 1) articulosFormato += ", ";
                else articulosFormato += " ";
            }
            articulosFormato += "]";
            
            
            // Agregar los articulos a la lista
            
            Supermercado.articulos.add(articulos);
            
            
            // Agregar el nombre a la fila
            
            Supermercado.fila.add(nombre);
            
            String listaAux[]  = new String[Supermercado.fila.size()];
            for (int i = 0; i<Supermercado.fila.size(); i++) {
                listaAux[i] = Supermercado.fila.get(i) + " lleva " + Arrays.toString(Supermercado.articulos.get(i));
            }
            fila.setListData(listaAux);
            
            
            String detalles = nombre + " lleva " + articulosFormato;
            
            System.out.println("Llega: " + detalles);
            
            texto.setText("Llega: " + detalles);
                
            tiempoLlegada = ThreadLocalRandom.current().nextInt(3, 6 + 1);    // Cada 3 a 6 seg llega un cliente
            
        }
        
    }
    
    public void parar(){
        this.continuar = false;
    }
    
}
