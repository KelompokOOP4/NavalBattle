package Codes.BaseEntities;

import Codes.Screens.GameScreen;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Item extends BaseObject{
    private boolean isMedkit, isShield, isTreasure;
    GameScreen gs;
    Rectangle area = new Rectangle();
    public Item(GameScreen gs, int x, int y){
        setxLocation(x);
        setyLocation(y);
        setCollisionArea(area);
        this.gs = gs;
        this.isDead = false;
        setDefaultValues();
        getImage();
    }

    @Override
    public void setDefaultValues(){
        setSpeed(1.5);
        area.width = getSpriteWidth() * 75/100;
        area.height = getSpriteHeight() * 75/100;
        area.x = (1/2 * getSpriteWidth()) - (1/2 * area.width);
        area.y = (1/2 * getSpriteHeight()) - (1/2 * area.height);
        setCollisionArea(area);
    }

    @Override
    public void getImage(){
        try{ 
            if (isMedkit) {
            setSprite(ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/item_health.png")));
            }
            if (isShield) {
            setSprite(ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/item_shield.png")));
            }
            if (isTreasure) {
            setSprite(ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/item_treasure.png")));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(){
        double x = getxLocation();
        
        if(x%29==0) {
            setxLocation((x-getSpeed()-1));
        }
        else{
            setxLocation((x+getSpeed()));
        }
        
        double y = getyLocation();
        int centerxImage = (int) (x +(getSpriteWidth()/2));
        int centeryImage = (int) (y +(getSpriteHeight()/2));
        double speed = getSpeed();
        setyLocation(y-speed);
        setxLocation(x-speed);
        if(centerxImage>800 || centeryImage>450 || centerxImage<0 || centeryImage<0){
            this.isDead=true;
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        if(!isDead){
            super.draw(g2);
        }
    }

    @Override
    public void createCollisionArea() {
        area.width = (int) (getSpriteWidth() /3);
        area.height = (int) (getSpriteHeight() /3);
        area.x =  (int) ((getxLocation()+getSpriteWidth()/2) - (area.width/2));
        area.y = (int) ((getyLocation()+getSpriteHeight()/2) - (area.height/2));
        setCollisionArea(area);
    }
    
}

