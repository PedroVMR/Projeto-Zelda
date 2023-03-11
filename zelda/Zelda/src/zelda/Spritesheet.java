package zelda;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Spritesheet {

    public static BufferedImage spritesheet;

    public static BufferedImage[] player_front;
    public static BufferedImage[] inimigo_front;

    public static BufferedImage tileWall;

    public Spritesheet() {
        try {
            spritesheet = ImageIO.read(getClass().getClassLoader().getResource("spritesheet.png"));
        } catch (Exception e) {

            e.printStackTrace();
        }

        player_front = new BufferedImage[2];
        inimigo_front = new BufferedImage[2];

        // Animação do personagem
        player_front[0] = Spritesheet.getSprite(0, 11, 16, 16);
        player_front[1] = Spritesheet.getSprite(18, 11, 16, 16);

        // Animação do inimigo
        inimigo_front[0] = Spritesheet.getSprite(293, 234, 16, 16);
        inimigo_front[1] = Spritesheet.getSprite(311, 234, 16, 16);

        // Sprite das paredes
        tileWall = Spritesheet.getSprite(304, 273, 16, 16);

    }

    public static BufferedImage getSprite(int x, int y, int widht, int height) {
        return spritesheet.getSubimage(x, y, widht, height);
    }
    
}
