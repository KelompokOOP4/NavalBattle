package Codes.BaseEntities;

import Codes.Screens.GameScreen;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Item extends BaseObject{
    private boolean isMedkit, isShield, isTreasure;
    GameScreen gs;
    public Item(GameScreen gs){
        this.gs = gs;
        setDefaultValues();
        getImage();
    }

    @Override
    public void setDefaultValues(){
        setSpeed(1.5);
    }

    @Override
    public void getImage(){
        try{ 
            if (isMedkit == true) {
            setSprite(ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/item_health.png")));
            }
            if (isShield == true) {
            setSprite(ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/item_shield.png")));
            }
            if (isTreasure == true) {
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
            setIsDead(true);
        }
    }
}

