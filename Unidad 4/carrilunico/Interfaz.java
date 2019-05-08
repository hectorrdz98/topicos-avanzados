
package carrilunico;
import processing.core.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Héctor Rodríguez
 */
public class Interfaz extends PApplet{
    
    public ArrayList <Coche> coches = new ArrayList<>();
    public Carril carriles[] = new Carril[4];
    
    int btnsDim[][] = new int[3][4];
    
    int btnActivo = 0;
    
    // Datos del puente
    Coche cocheEnPuente = null;
    
    String cronometro = "";
    
    public Interfaz() {

    }
    
    @Override
    public void settings() { 
        size(1000,600);
    }
    
    @Override
    public void setup() {
        for (int i = 0; i<4; i++) {
            carriles[i] = new Carril();
        }
        
        carriles[0].limiteCarril = 0;
        carriles[1].limiteCarril = 200;
        carriles[2].limiteCarril = 650;
        carriles[3].limiteCarril = 1000;
        
        btnsDim[0][0] = 0 + 25;
        btnsDim[0][1] = height - 100 + 25;
        btnsDim[0][2] = 150;
        btnsDim[0][3] = 50;
        
        btnsDim[1][0] = 0 + 25 + 150 + 50;
        btnsDim[1][1] = height - 100 + 25;
        btnsDim[1][2] = 150;
        btnsDim[1][3] = 50;
        
        btnsDim[2][0] = 0 + 25 + 150 + 50 + 150 + 50;
        btnsDim[2][1] = height - 100 + 25;
        btnsDim[2][2] = 150;
        btnsDim[2][3] = 50;
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
        // Linea diagonal del fondo
        fill(51, 51, 77);
        quad(450, 0, 580, 0, 520, 600, 390, 600);
        // Inferior
        fill(41, 41, 61);
        rect(0, height - 100, width, height);
        
        // Botones
        for (int i = 0; i<3; i++) {
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
            text("Version #" + (i+1), btnsDim[i][0], btnsDim[i][1], btnsDim[i][2], btnsDim[i][3]); 
        } 
        
        // Cronometro
        fill(255);
        textSize(25);
        textAlign(CENTER, CENTER);
        text(this.cronometro, width - 100, height - 50); 
        
        textAlign(LEFT);
        noStroke();
        
        
        // Carretera
        fill(133, 133, 173);
        rect(0, 75, 200, 350);  // Rect izq
        rect(width - 200, 75, width, 350);  // Rect der
        triangle(200, 75, 200 + 250, ((425 - 75) / 2) + 75, 200, 425);  // Tria izq
        triangle(width - 200, 75, (width - 200) - 250, ((425 - 75) / 2) + 75, width - 200, 425);  // Tria izq
        rect((width/2) - 175, (height/2) - 125, 350, 150);  // Rect central
        
        // Lineas de la carretera
        strokeWeight(10);
        stroke(0);
        // Superiores
        line(200, 75, 350, (height/2) - 125);
        line(350, (height/2) - 125, 650, (height/2) - 125);
        line(650, (height/2) - 125, width - 200, 75);
        // Inferiores
        line(200, 425, 350, (height/2) - 125 + 150);
        line(350, (height/2) - 125 + 150, 650, (height/2) - 125 + 150);
        line(650, (height/2) - 125 + 150, width - 200, 425);
        // Para revasar
        stroke(255);
        line(0, ((425 - 75) / 2) + 75, 200, ((425 - 75) / 2) + 75);
        line(width - 200, ((425 - 75) / 2) + 75, width, ((425 - 75) / 2) + 75);
        
        try {
            // Dibujar cada coche completo
            this.coches.forEach((coche) -> {
                noStroke();
                fill(coche.color[0], coche.color[1], coche.color[2]);
                rect(coche.pos[0], coche.pos[1], 80, 50);
                square(coche.pos[0] - 30, coche.pos[1] + 20, 30);
                square(coche.pos[0] + 80, coche.pos[1] + 20, 30);
                fill(255, 255, 255);
                strokeWeight(2);
                stroke(0);
                circle(coche.pos[0], coche.pos[1] + 50, 25);
                circle(coche.pos[0] + 80, coche.pos[1] + 50, 25);
                fill(255);
                textSize(25);
                text(this.coches.indexOf(coche), coche.pos[0] + 30, coche.pos[1] + 30); 
                
                // Comprobar la velocidad maxima
                
                if (coche.direccion == 0) {
                    // Si ya cruzó el puente
                    if (this.carriles[3].coches.indexOf(coche) != -1) {
                        coche.avanzar(coche.velocidad);
                    // Si no ha cruzado el puente
                    } else {
                        // Si hay coches en el carril
                        if (!this.carriles[1].coches.isEmpty()) {
                            // Si llegamos al limite del carril
                            if (coche.pos[0] + 80 + 50 > this.carriles[1].limiteCarril) {
                                // Si no somos el coche en el puente
                                if (coche != this.cocheEnPuente) {
                                    // Si ya hay un coche en el puente
                                    if (this.cocheEnPuente != null) {
                                        // coche.velocidad = 0;
                                        coche.freno = true;
                                    // Si no hay coche en el puente
                                    } else {
                                        this.carriles[1].coches.remove(coche);
                                        this.cocheEnPuente = coche;
                                        coche.pos[1] -= 100;
                                    }
                                // Si somos el coche en el puente
                                } else {
                                    // Si llegamos al final del puente
                                    if (coche.pos[0] - 80 - 50 - 50> this.carriles[2].limiteCarril) { 
                                        this.cocheEnPuente = null;
                                        this.carriles[3].coches.add(coche);
                                        coche.pos[1] += 100;
                                        // Quitar el freno al ultimo coche
                                        // this.carriles[1].coches.get(0).freno = false;
                                        int idCocheActual = this.coches.indexOf(coche);
                                        if (this.coches.size() > idCocheActual + 1) {
                                            while (this.coches.get(idCocheActual + 1).freno == false) {
                                                idCocheActual++;
                                            }
                                            this.coches.get(idCocheActual + 1).freno = false;
                                        }
                                        // coche.velocidad = 0;
                                    // Si no llegamos aun seguimos avanzando
                                    } else {
                                        coche.avanzar(coche.velocidad);
                                    }
                                }
                            // Si no hemos llegado al limite del carril
                            } else {
                                // Si no somos el coche en el puente
                                if (coche != this.cocheEnPuente) {
                                    // Obtenemos el id del nuestro coche en el carril
                                    int indexActualCoche = this.carriles[1].coches.indexOf(coche);
                                    // Si no somos el primer coche
                                    if (indexActualCoche > 0) {
                                        // Obtenemos el coche que va adelante de nosotros
                                        Coche ultimoCoche = this.carriles[1].coches.get(indexActualCoche - 1);
                                        // Si no lo hemos alcanzado
                                        if (coche.pos[0] < (ultimoCoche.pos[0] - 80 - 50 - 50)) {
                                            coche.avanzar(coche.velocidad);
                                        // Si ya lo alcanzamos
                                        } else {
                                            // No avanzar
                                            // coche.avanzar(ultimoCoche.velocidad);
                                        }
                                    // Si somos el primer coche del carril solo avanzamos
                                    } else {
                                        coche.avanzar(coche.velocidad);
                                    }
                                // Si somos el coche en el puente
                                } else {
                                    coche.avanzar(coche.velocidad);
                                }
                            }
                        // Si no hay coches en el carril, ya que estamos en el puente
                        } else {
                            // Si llegamos al final del puente
                            if (coche.pos[0] - 80 - 50 - 50> this.carriles[2].limiteCarril) { 
                                this.cocheEnPuente = null;
                                this.carriles[3].coches.add(coche);
                                coche.pos[1] += 100;
                                // Quitar el freno al ultimo coche
                                // this.carriles[1].coches.get(0).freno = false;
                                int idCocheActual = this.coches.indexOf(coche);
                                if (this.coches.size() > idCocheActual + 1) {
                                    while (this.coches.get(idCocheActual + 1).freno == false) {
                                        idCocheActual++;
                                    }
                                    this.coches.get(idCocheActual + 1).freno = false;
                                }
                                // coche.velocidad = 0;
                            // Si no llegamos aun seguimos avanzando
                            } else {
                                coche.avanzar(coche.velocidad);
                            }
                        }
                    }
                } else {
                    // Si ya cruzó el puente
                    if (this.carriles[0].coches.indexOf(coche) != -1) {
                        coche.avanzar(coche.velocidad);
                    // Si no ha cruzado el puente
                    } else {
                        // Si hay coches en el carril
                        if (!this.carriles[2].coches.isEmpty()) {
                            // Si llegamos al limite del carril
                            if (coche.pos[0] - 80 - 50 - 50 < this.carriles[2].limiteCarril) {
                                // Si no somos el coche en el puente
                                if (coche != this.cocheEnPuente) {
                                    // Si ya hay un coche en el puente
                                    if (this.cocheEnPuente != null) {
                                        // coche.velocidad = 0;
                                        coche.freno = true;
                                    // Si no hay coche en el puente
                                    } else {
                                        this.carriles[2].coches.remove(coche);
                                        this.cocheEnPuente = coche;
                                        coche.pos[1] += 100;
                                    }
                                // Si somos el coche en el puente
                                } else {
                                    // Si llegamos al final del puente
                                    if (coche.pos[0] + 80 + 50 < this.carriles[1].limiteCarril) { 
                                        this.cocheEnPuente = null;
                                        this.carriles[0].coches.add(coche);
                                        coche.pos[1] -= 100;
                                        // Quitar el freno al ultimo coche
                                        // this.carriles[1].coches.get(0).freno = false;
                                        int idCocheActual = this.coches.indexOf(coche);
                                        if (this.coches.size() > idCocheActual + 1) {
                                            while (this.coches.get(idCocheActual + 1).freno == false) {
                                                idCocheActual++;
                                            }
                                            this.coches.get(idCocheActual + 1).freno = false;
                                        }
                                        // coche.velocidad = 0;
                                    // Si no llegamos aun seguimos avanzando
                                    } else {
                                        coche.avanzar(coche.velocidad);
                                    }
                                }
                            // Si no hemos llegado al limite del carril
                            } else {
                                // Si no somos el coche en el puente
                                if (coche != this.cocheEnPuente) {
                                    // Obtenemos el id del nuestro coche en el carril
                                    int indexActualCoche = this.carriles[2].coches.indexOf(coche);
                                    // Si no somos el primer coche
                                    if (indexActualCoche > 0) {
                                        // Obtenemos el coche que va adelante de nosotros
                                        Coche ultimoCoche = this.carriles[2].coches.get(indexActualCoche - 1);
                                        // Si no lo hemos alcanzado
                                        if (coche.pos[0] > (ultimoCoche.pos[0] + 80 + 50 + 50)) {
                                            coche.avanzar(coche.velocidad);
                                        // Si ya lo alcanzamos
                                        } else {
                                            // No avanzar
                                            // coche.avanzar(ultimoCoche.velocidad);
                                        }
                                    // Si somos el primer coche del carril solo avanzamos
                                    } else {
                                        coche.avanzar(coche.velocidad);
                                    }
                                // Si somos el coche en el puente
                                } else {
                                    coche.avanzar(coche.velocidad);
                                }
                            }
                        // Si no hay coches en el carril, ya que estamos en el puente
                        } else {
                            // Si llegamos al final del puente
                            if (coche.pos[0] + 80 + 50 < this.carriles[1].limiteCarril) { 
                                this.cocheEnPuente = null;
                                this.carriles[0].coches.add(coche);
                                coche.pos[1] -= 100;
                                // Quitar el freno al ultimo coche
                                // this.carriles[1].coches.get(0).freno = false;
                                int idCocheActual = this.coches.indexOf(coche);
                                if (this.coches.size() > idCocheActual + 1) {
                                    while (this.coches.get(idCocheActual + 1).freno == false) {
                                        idCocheActual++;
                                    }
                                    this.coches.get(idCocheActual + 1).freno = false;
                                }
                                // coche.velocidad = 0;
                            // Si no llegamos aun seguimos avanzando
                            } else {
                                coche.avanzar(coche.velocidad);
                            }
                        }
                    }
                }
                
                // Borrar coches que se salen de los limites
                
                if (coche.direccion == 0) {
                    if (coche.pos[0] > 1000 + 50) {
                        this.carriles[1].coches.remove(coche);
                        this.coches.remove(coche);
                    }
                } else {
                    if (coche.pos[0] < 0 - 80 - 50) {
                        this.carriles[2].coches.remove(coche);
                        this.coches.remove(coche);
                    }
                }
            });
            
            // Debugg de los carriles
            /*
            for (int i = 0; i<4; i++) {
                System.out.println("El carril " + i + ":");
                if (this.carriles[i].coches.isEmpty()) {
                    System.out.println("No hay coches");
                } else {
                    System.out.println("El primer coche. Pos: " + Arrays.toString(this.carriles[i].coches.get(0).pos) + ", vel: " + this.carriles[i].coches.get(0).velocidad);
                }
            }*/
            
            fill(255);
            textSize(30);
            text("Coches: " + coches.size(), 20, 50);
        } catch (Exception e) {}
    }
    
    @Override
    public void mousePressed() {
        for (int i = 0; i<3; i++) {
            if (pmouseX >= btnsDim[i][0] && pmouseX <= btnsDim[i][0] + btnsDim[i][2] && pmouseY >= btnsDim[i][1] && pmouseY <= btnsDim[i][1] + btnsDim[i][3]) {
                this.btnActivo = i;
                break;
            }
        }
    }

}
