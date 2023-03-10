package zelda;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;

public class Blocks extends Rectangle{

    public Blocks(int x, int y) {
        super(x,y, 32,32);
    }

    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(x, y, width, height);
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
    }
}
