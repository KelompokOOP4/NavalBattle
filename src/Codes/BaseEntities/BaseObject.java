package Codes.BaseEntities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class BaseObject {
    private double xLocation,yLocation;
    private double speed;
    private Rectangle collisionArea;
    private BufferedImage sprite = null;
    private int spriteHeight=200;
    private int spriteWidth=200;
    private boolean isDead;
    private int windowWidth = 800;
    private int windowHeight = 450;

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setxLocation(double xLocation) {
        this.xLocation = xLocation;
    }
    
    public double getxLocation() {
        return xLocation;
    }

    public void setyLocation(double yLocation) {
        this.yLocation = yLocation;
    }

    public double getyLocation() {
        return yLocation;
    }

    public void setSpriteHeight(int spriteHeight) {
        this.spriteHeight = spriteHeight;
    }

    public int getSpriteHeight() {
        return spriteHeight;
    }
    
    public void setSpriteWidth(int spriteWidth) {
        this.spriteWidth = spriteWidth;
    }

    public int getSpriteWidth() {
        return spriteWidth;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }
    
    public boolean getIsDead(){
        return isDead;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }
    
    public int getWindowWidth() {
        return windowWidth;
    }
    
    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }
    
    public int getWindowHeight() {
        return windowHeight;
    }

    
    

    public void draw(Graphics2D g2){
        BufferedImage image = sprite;
        g2.drawImage(image, (int)xLocation, (int)yLocation,spriteWidth,spriteHeight,null);
    }
    
    public abstract void setDefaultValues();
    public abstract void getImage();
    public abstract void update();
}
