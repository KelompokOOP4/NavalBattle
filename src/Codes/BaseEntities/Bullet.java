package Codes.BaseEntities;

import Codes.Screens.GameScreen;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bullet extends BaseObject {
    GameScreen gs;
    Rectangle area = new Rectangle();
    public Bullet(GameScreen gs,int x,int y) {
        this.gs = gs;
        setxLocation(x);
        setyLocation(y);
        setDefaultValues();
        getImage();
        
    }

    @Override
    public void setDefaultValues() {
        setSpeed(5);
        setSpriteHeight(16);
        setSpriteWidth(16);
        createCollisionArea();
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
    public void update(){
        double x = getxLocation();
        double y = getyLocation();
        int centerxImage = (int) (x +(getSpriteWidth()/2));
        int centeryImage = (int) (y +(getSpriteHeight()/2));
        double speed = getSpeed();
        setxLocation(x+speed);
        if(centerxImage>getWindowWidth() || centeryImage>getWindowHeight() || centerxImage<0 || centeryImage<0){
            this.isDead=true;
        }
        createCollisionArea();
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
