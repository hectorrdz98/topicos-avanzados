/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JList;

/**
 *
 * @author Héctor Rodríguez
 */
public class Llegada extends Thread {
    
    boolean continuar;
    JLabel texto;
    Thread hilo;
    JList filas[];
    
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
    
    String tipos[] = {
        "VIP", "Frecuente", "Normal"
    };
    
    public Llegada(JLabel texto, JList filas[]) {
        this.texto = texto;
        this.filas = filas;
    }
    
    @Override
    public void run() {
        
        int actualCont = 1;
        int objetivoCont = ThreadLocalRandom.current().nextInt(1, 3 + 1);    // Cada 3 a 6 seg
        System.out.println("Inicia la llegada de clientes");
        
        while(continuar) {
           
            if (actualCont >= objetivoCont) {
                // System.out.println("Listo, llegamos a " + objetivoCont);
                
                int idNombre = ThreadLocalRandom.current().nextInt(0, 14 + 1);
                int idApellido = ThreadLocalRandom.current().nextInt(0, 14 + 1);
                int preIdTipo = ThreadLocalRandom.current().nextInt(1, 10 + 1);
                // System.out.println("preIdTipo: " + preIdTipo);
                int idTipo = 2;
                
                if (preIdTipo < 2) {
                    idTipo = 0;
                    Banco.listaVIP.add(nombres[idNombre] + " " + apellidos[idApellido]);
                    
                    String listaAux[]  = new String[Banco.listaVIP.size()];
                    for (int i = 0; i<Banco.listaVIP.size(); i++) {
                        listaAux[i] = Banco.listaVIP.get(i);
                    }
                    
                    filas[0].setListData(listaAux);
                    
                } else if (preIdTipo < 5) {
                    idTipo = 1;
                    Banco.listaFrecuente.add(nombres[idNombre] + " " + apellidos[idApellido]);
                    
                    String listaAux[]  = new String[Banco.listaFrecuente.size()];
                    for (int i = 0; i<Banco.listaFrecuente.size(); i++) {
                        listaAux[i] = Banco.listaFrecuente.get(i);
                    }
                    
                    filas[1].setListData(listaAux);
                    
                } else {
                    Banco.listaNormal.add(nombres[idNombre] + " " + apellidos[idApellido]);
                    
                    String listaAux[]  = new String[Banco.listaNormal.size()];
                    for (int i = 0; i<Banco.listaNormal.size(); i++) {
                        listaAux[i] = Banco.listaNormal.get(i);
                    }
                    
                    filas[2].setListData(listaAux);
                    
                }
                
                String detalles = nombres[idNombre] + " " + apellidos[idApellido] + " -- " + tipos[idTipo] + " -- ";
                
                // System.out.println("listaNormal: " + Banco.listaNormal);
                // System.out.println("listaFrecuente: " + Banco.listaFrecuente);
                // System.out.println("listaVIP: " + Banco.listaVIP);
                
                // System.out.println("Llegó... " + detalles);
                
                texto.setText("Llega: " + detalles);
                
                objetivoCont = ThreadLocalRandom.current().nextInt(1, 3 + 1);
                actualCont = 1;
            } else {
                actualCont++;
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Llegada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Finalizamos la llegada");
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
