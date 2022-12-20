package navalbattle;

/**
 *
 * @author Rizky Hamdani Sakto
 */
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Sprite {
    public int x, y, speed;
    public BufferedImage <nama gambar>;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public boolean collisionOn = false;
    public BufferedImage setup(String imagePath) {
    BufferedImage image = null;
    try {
        image = ImageIO.read(getClass().getResourceAsStream(imagePath +".png"));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return image;
    }
}
