/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import javax.swing.*;

/**
 *
 * @author Héctor Rodríguez
 */
public class Cronometro implements Runnable{

    Thread hilo;
    boolean cronometroActivo;
    JLabel tiempo;
    
    public Cronometro(JLabel tiempo) {
        this.tiempo = tiempo;
    }
    
    @Override
    public void run() {
        Integer minutos = 0 , segundos = 0, milesimas = 0;
        String min="", seg="", mil="";
        try
        {
            while( cronometroActivo )
            {
                Thread.sleep( 4 );
                milesimas += 4;

                if( milesimas == 1000 )
                {
                    milesimas = 0;
                    segundos += 1;
                    if( segundos == 60 )
                    {
                        segundos = 0;
                        minutos++;
                    }
                }
                
                if( minutos < 10 ) min = "0" + minutos;
                else min = minutos.toString();
                if( segundos < 10 ) seg = "0" + segundos;
                else seg = segundos.toString();

                if( milesimas < 10 ) mil = "00" + milesimas;
                else if( milesimas < 100 ) mil = "0" + milesimas;
                else mil = milesimas.toString();

                tiempo.setText( min + ":" + seg + ":" + mil );
            }
        }catch(Exception e){}
        
    }
    
    public void iniciarCronometro() {
        cronometroActivo = true;
        hilo = new Thread( this );
        hilo.start();
    }

    public void pararCronometro(){
        cronometroActivo = false;
    }
    
}
