package zelda;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Inimigo extends Rectangle {

    /* Velocidade do Inimigo */
    public int speed = 3;
    public int right = 1,up = 0 ,down = 0 ,left = 0;

    public int curAnimation = 0;
    public int curFrames = 0, targetFrames = 15;

    public static List<Bullet> bullets = new ArrayList<Bullet>();

    public boolean shoot = false;

    public int dir = 1;

    /* Dimensões do Inimigo */
    public Inimigo(int x, int y) {
        super(x,y,32,32);
    }

    // Sistema básico de "I.A" de persiguição do Player, o Random determina se o inimigo vai se mover ou não
    public void perseguirPlayer() {
        Player p = Game.player;
        if(x < p.x && World.isFree(x+ 1, y)) {
            if(new Random().nextInt(100) < 50)
                x+=speed;
        }else if(x > p.x && World.isFree(x- 1, y)) {
            if(new Random().nextInt(100) < 50)
                x-=speed;
        }if(y < p.y && World.isFree(y+ 1, x)) {
            if(new Random().nextInt(100) < 50)
                y+=speed;
        }else if(y > p.y && World.isFree(y- 1, x))
            if(new Random().nextInt(100) < 50)
                y-=speed; 
    }
    
    /* Movimentação */
    public void tick() {
        boolean moved = true;

        perseguirPlayer();

        if(moved) {
        curFrames++;
            if(curFrames == targetFrames) {
                curFrames = 0;
                curAnimation++;
                if(curAnimation == Spritesheet.player_front.length) {
                    curAnimation = 0;
                }
            }
            }


        if (shoot) {
            shoot = false;
            bullets.add(new Bullet(x, y, dir));
            }
            
            for (int i = 0; i < bullets.size(); i++) {
                bullets.get(i).tick();
            }


    }

    /* Grafico do inimigo */
    public void render(Graphics g) {
        g.drawImage(Spritesheet.inimigo_front[curAnimation], x, y, 32, 32, null);

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).render(g);
        }
    
    }
}
