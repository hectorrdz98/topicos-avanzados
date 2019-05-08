
package vasoscomunicantes;
import processing.core.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Héctor Rodríguez
 */
public class Interfaz extends PApplet{
    
    int btnsDim[][] = new int[2][4];
    int btnActivo = 1;
    String textoBtn[] = { "Iniciar", "Parar" };
    
    String cronometro = "";
    
    // Tanques de agua
    Tanque tanque2 = new Tanque(20, 50, 0, false, null);
    Tanque tanque1 = new Tanque(10, 50, 50, true, tanque2);
    
    int escala = 5;
    
    public Interfaz() {
        
    }
    
    @Override
    public void settings() { 
        size(600,600);
    }
    
    @Override
    public void setup() {
        btnsDim[0][0] = 0 + 25;
        btnsDim[0][1] = height - 100 + 25;
        btnsDim[0][2] = 150;
        btnsDim[0][3] = 50;
        
        btnsDim[1][0] = 0 + 25 + 150 + 50;
        btnsDim[1][1] = height - 100 + 25;
        btnsDim[1][2] = 150;
        btnsDim[1][3] = 50;
    }
    
    @Override
    public void draw() {
        // updateButtons(mouseX, mouseY);
        clear();
        
        // Dibujar el fondo
        background(0);
        noStroke();
        
        
        // Recuadros básicos
        
        // Superior
        fill(71, 71, 107);
        rect(0, 0, width, height - 100);

        // Inferior
        fill(41, 41, 61);
        rect(0, height - 100, width, height);
        
        // Dibujar tanques
        
        stroke(40);
        strokeWeight(3);
        noFill();
        
        // Primer tanque menos parte alta
        ellipse((float) (tanque1.r * 2) * this.escala, (float) (100 + (tanque1.h * this.escala)), (float) (tanque1.r * 2) * this.escala, (float) ((0.5) * (tanque1.r * 2)) * this.escala );
        line((float) ((tanque1.r * 2) - tanque1.r) * this.escala, 100, (float) ((tanque1.r * 2) - tanque1.r) * this.escala, (float) (100 + (tanque1.h * this.escala)));
        line((float) ((tanque1.r * 2) + tanque1.r) * this.escala, 100, (float) ((tanque1.r * 2) + tanque1.r) * this.escala, (float) (100 + (tanque1.h * this.escala)));
        
        // Segundo tanque menos parte alta
        ellipse(width - (float) (tanque2.r * 2) * this.escala, (float) (100 + (tanque2.h * this.escala)), (float) (tanque2.r * 2) * this.escala, (float) ((0.5) * (tanque2.r * 2)) * this.escala );
        line(width - (float) ((tanque2.r * 2) - tanque2.r) * this.escala, 100, width - (float) ((tanque2.r * 2) - tanque2.r) * this.escala, (float) (100 + (tanque2.h * this.escala)));
        line(width - (float) ((tanque2.r * 2) + tanque2.r) * this.escala, 100, width - (float) ((tanque2.r * 2) + tanque2.r) * this.escala, (float) (100 + (tanque2.h * this.escala)));
        
        // Unión
        line((float) ((tanque1.r * 2) + tanque1.r) * this.escala, (float) (100 + ((tanque1.h - 1) * this.escala)), width - (float) ((tanque2.r * 2) + tanque2.r) * this.escala, (float) (100 + ((tanque2.h - 1) * this.escala)));
        line((float) ((tanque1.r * 2) + tanque1.r) * this.escala, (float) (100 + ((tanque1.h + 1) * this.escala)), width - (float) ((tanque2.r * 2) + tanque2.r) * this.escala, (float) (100 + ((tanque2.h + 1) * this.escala)));
        
        // Cantidad de agua
        noStroke();
        fill(102, 153, 255);
        
        if (tanque1.ha > 0) {
            ellipse(
                    (float) (tanque1.r * 2) * this.escala, 
                    (float) (100 + (tanque1.h * this.escala)), 
                    (float) (tanque1.r * 2) * this.escala, 
                    (float) ((0.5) * (tanque1.r * 2)) * this.escala 
            );
            rect(
                    (float) ((tanque1.r * 2) - tanque1.r) * this.escala, 
                    (float) (100 + (tanque1.h * this.escala)), 
                    (float) (tanque1.r * 2) * this.escala, 
                    - (float) (tanque1.ha) * this.escala
            );
            ellipse(
                    (float) (tanque1.r * 2) * this.escala,
                    (float) (100 + (tanque1.h * this.escala)) - (float) (tanque1.ha) * this.escala, 
                    (float) (tanque1.r * 2) * this.escala,
                    (float) ((0.5) * (tanque1.r * 2)) * this.escala 
            );
        }
        
        if (tanque2.ha > 0) {
            ellipse(
                    width - (float) (tanque2.r * 2) * this.escala, 
                    (float) (100 + (tanque2.h * this.escala)), 
                    (float) (tanque2.r * 2) * this.escala, 
                    (float) ((0.5) * (tanque2.r * 2)) * this.escala 
            );
            rect(
                    width - (float) ((tanque2.r * 2) + tanque2.r) * this.escala,
                    (float) (100 + (tanque2.h * this.escala)),
                    (float) (tanque2.r * 2) * this.escala,
                    - (float) (tanque2.ha) * this.escala 
            );
            ellipse(
                    width - (float) (tanque2.r * 2) * this.escala, 
                    (float) (100 + (tanque2.h * this.escala)) - (float) (tanque2.ha) * this.escala , 
                    (float) (tanque2.r * 2) * this.escala, 
                    (float) ((0.5) * (tanque2.r * 2)) * this.escala 
            );
        }
        
        stroke(40);
        strokeWeight(3);
        noFill();
        
        // Primer tanque parte alta
        ellipse((float) (tanque1.r * 2) * this.escala, 100, (float) (tanque1.r * 2) * this.escala, (float) ((0.5) * (tanque1.r * 2)) * this.escala );
        
        // Segundo tanque parte alta
        ellipse(width - (float) (tanque2.r * 2) * this.escala, 100, (float) (tanque2.r * 2) * this.escala, (float) ((0.5) * (tanque2.r * 2)) * this.escala );
        
        // Textos con cantidad de agua
        fill(255);
        textSize(15);
        text(
                "Tanque #1: " + this.tanque1.ha,
                (float) ((tanque1.r * 2) - tanque1.r) * this.escala, 
                (float) (100 + (tanque1.h * this.escala)) + 100
            ); 
        text(
                "Tanque #2: " + this.tanque2.ha,
                width - (float) ((tanque2.r * 2) + tanque2.r) * this.escala,
                (float) (100 + (tanque2.h * this.escala)) + 100
            ); 
        
        // Botones
        for (int i = 0; i<2; i++) {
            strokeWeight(5);
            if (i != btnActivo) {
                fill(0, 102, 153);
                stroke(0, 119, 179);
            } else {
                fill(0, 204, 153);
                stroke(0, 102, 0);
            }
            rect(btnsDim[i][0], btnsDim[i][1], btnsDim[i][2], btnsDim[i][3]);
            
            // Texto
            fill(255);
            textSize(20);
            textAlign(CENTER, CENTER);
            text(textoBtn[i], btnsDim[i][0], btnsDim[i][1], btnsDim[i][2], btnsDim[i][3]); 
        } 
        
        // Cronometro
        fill(255);
        textSize(25);
        textAlign(CENTER, CENTER);
        text(this.cronometro, width - 100, height - 50); 
        
        textAlign(LEFT);
        noStroke();   
    }
    
    @Override
    public void mousePressed() {
        for (int i = 0; i<3; i++) {
            if (pmouseX >= btnsDim[i][0] && pmouseX <= btnsDim[i][0] + btnsDim[i][2] && pmouseY >= btnsDim[i][1] && pmouseY <= btnsDim[i][1] + btnsDim[i][3]) {
                if (i == 1) {
                    this.tanque1.continuar = false;
                    this.tanque2.continuar = false;
                    this.btnActivo = 1;
                } else if (btnActivo != 0) {
                    this.tanque1.continuar = false;
                    this.tanque2.continuar = false;
                    this.tanque2 = new Tanque(20, 50, 0, false, null);
                    this.tanque1 = new Tanque(10, 50, 50, true, tanque2);
                    this.tanque1.start();
                    this.tanque2.start();
                    this.btnActivo = i;
                }
                break;
            }
        }
    }

}
