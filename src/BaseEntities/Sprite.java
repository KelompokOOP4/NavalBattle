package BaseEntities;
/**
 *
 * @author rizky
 */
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
public class Sprite {
    private Image spriteImage;
    private Graphics2D spriteImageG2D;
    private double spriteXPosition;
    private double spriteYPosition;
    private int spriteHeight;
    private int spriteWidth;
    private AffineTransform spriteTransform;
    BufferedImage spriteDoubleBuffer;
    Graphics2D spriteDouleBufferG2D;
    public Sprite (int width, int height, BufferedImage, doubleBuffer){
        this.spriteXPosition = 0;
        this.spriteYPosition = 0;
        this.spriteWidth = width;
        this.spriteHeight = height;
        this.spriteDoubleBufferG2D = (Graphics2D) doubleBuffer.getGraphics();
        this.spriteTransform = new AffineTransform();
        this.spriteImageG2D = (Graphics2D);
        this.spriteImage.getGraphics();
    }
    public Graphics2D getSpriteDoubleBufferG2D(){
        return spriteDoubleBufferG2D;
    }
    public void setSpriteDoubleBufferG2D (Graphics2D spriteDoubleBufferG2D){
        this.spriteDoubleBufferG2D = spriteDoubleBufferG2D;
    }
    public void transform(){
        this.spriteTransform.setTodayIdentity();
        this.spriteTransform.translate((int)this.getSpriteXPosition(), (int)this.getSpriteYPosition());
    }
    public void draw(){
        this.transform();
        this.spriteDoubleBufferG2D.drawImage(this.getSpriteImage(), spriteTransform,  Main.getInstance());
        this.spriteDoubleBufferG2D.drawImage(spriteImage, 0, 0, null);
    }
    public void loadSpriteImage(String name){
        this.setSpriteImage(Toolkit.getDefaultToolkit().getImage("<path>"+name));
        public Image getSpriteImage(){
            return spriteImage;
        }
        public void setSpriteImage(Image spriteImage){
            this.spriteImage = spriteImage;
        }
        public Graphics2D getSpriteImageG2D(){
            return spriteImageG2D;
        }
        public void setSpriteImageG2D(Graphics2D spriteImageG2D){
            this.spriteImageG2D = spriteImageG2D;
        }
        public int getSpriteHeight(){
        return spriteHeight;
    }
    public void setSpriteHeight(int spriteHeight){
        this.spriteHeight = spriteHeight;
    }
    public int getSpriteWidth(){
        return spriteWidth;
    }
    public void setSpriteWidth(int spriteWidth){
        this.spriteWidth = spriteWidth;
    }
    public double getSpriteXPosition(){
        return spriteXPosition;
    }
    public void setSpriteXPosition(double spriteXPosition){
        this.spriteXPosition = spriteXPosition;
    }
    public double getSpriteYPosition(){
        return spriteYPosition;
    }
    public void setSpriteYPosition(double spriteYPosition){
        this.spriteYPosition = spriteYPosition;
    }
}
