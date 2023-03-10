package zelda;

/* imports necessários */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{

    public static int WIDTH = 480, HEIGHT = 480;
    public Player player;

    public World world;

    public Game() {
        this.addKeyListener(this);
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));

        player = new Player(32,32);
        world = new World();

    }

    public void tick() {
        player.tick();

    }

    /* Gráficos do Jogo */
    public void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) { 
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        player.render(g);

        world.render(g);

        bs.show();
        
    }

    /* Interface do Jogo */
    public static void main(String[] args) {
        Game game = new Game();
        JFrame frame = new JFrame();

        frame.add(game);
        frame.setTitle("Zeldinha");
        
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        new Thread(game).start();

    }
    /* Looping do jogo que faz ele rodar a 60 fps */
    @Override
    public void run() {
        while(true) {
            tick();
            render();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* Sistema de Controles */
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D) {
            player.right = true;

        }
        if(e.getKeyCode() == KeyEvent.VK_A) {
            player.left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_W) {
            player.up = true;

        }
        if(e.getKeyCode() == KeyEvent.VK_S) {
            player.down = true;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D) {
            player.right = true;

        }
        if(e.getKeyCode() == KeyEvent.VK_A) {
            player.left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_W) {
            player.up = true;

        }
        if(e.getKeyCode() == KeyEvent.VK_S) {
            player.down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D) {
            player.right = false;

        }
        if(e.getKeyCode() == KeyEvent.VK_A) {
            player.left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_W) {
            player.up = false;

        }
        if(e.getKeyCode() == KeyEvent.VK_S) {
            player.down = false;
        }
    }

}
