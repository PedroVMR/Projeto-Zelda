package zelda;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Player extends Rectangle {

    /* Velocidade do Player */
    public int speed = 5;
    public boolean right,up,down,left;

    /* Dimensões do Player */
    public Player(int x, int y) {
        super(x,y,32,32);
    }
    
    /* Movimentação */
    public void tick() {
        if(right && World.isFree(x+speed, y)) {
            x += speed;
        }else if(left && World.isFree(x-speed, y)) {
            x -= speed;
        } 

        if(up && World.isFree(x, y-speed)) {
            y -= speed;
        }else if(down && World.isFree(x, y+speed)) {
            y += speed;
        }
    }

    /* Grafico do Player */
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
    }
}
