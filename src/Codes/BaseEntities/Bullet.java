package Codes.BaseEntities;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Bullet extends BaseObject {
    //GameScreen gs;
    public Bullet(int x,int y) {
        //this.gs = gs;
        setxLocation(x);
        setyLocation(y);
        setDefaultValues();
        getImage();
        
    }

    @Override
    public void setDefaultValues() {
        setSpeed(1);
        setSpriteHeight(16);
        setSpriteWidth(16);
    }

    @Override
    public void getImage() {
        try{
            setSprite(ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/bullet.png")));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        double x = getxLocation();
        double y = getyLocation();
        double speed = getSpeed();
        int centerxImage = (int) (x +(getSpriteWidth()/2));

        int centeryImage = (int) (y +(getSpriteHeight()/2));
        setxLocation(x+speed);
        if(centerxImage>768 || centeryImage>576 || centerxImage<0 || centeryImage<0){
            setIsDead(true);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        if(!getIsDead()){
            super.draw(g2);
        }
    }
}
