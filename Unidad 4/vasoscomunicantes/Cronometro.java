/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vasoscomunicantes;

/**
 *
 * @author Héctor Rodríguez
 */
public class Cronometro extends Thread{

    boolean cronometroActivo = true;
    Interfaz interfaz;
    
    public Cronometro(Interfaz interfaz) {
        this.interfaz = interfaz;
    }
    
    @Override
    public void run() {
        Integer minutos = 0 , segundos = 0, milesimas = 0;
        String min="", seg="", mil="";
        try
        {
            while( cronometroActivo )
            {
                if (this.interfaz.btnActivo == 1) {
                    minutos = 0; segundos = 0; milesimas = 0;
                    Thread.sleep( 4 );
                } else {
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
                }
                
                if( minutos < 10 ) min = "0" + minutos;
                else min = minutos.toString();
                if( segundos < 10 ) seg = "0" + segundos;
                else seg = segundos.toString();

                if( milesimas < 10 ) mil = "00" + milesimas;
                else if( milesimas < 100 ) mil = "0" + milesimas;
                else mil = milesimas.toString();

                interfaz.cronometro =  min + ":" + seg + ":" + mil ;
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
    }

    public void pararCronometro(){
        cronometroActivo = false;
    }
    
}
