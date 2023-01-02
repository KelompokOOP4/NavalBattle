package Codes.BaseEntities;

import Codes.Screens.GameScreen;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Obstacle extends BaseObject {
    private boolean isRock, isCrystal;
    GameScreen gs;
    Rectangle area = new Rectangle();
    
    public Obstacle(GameScreen gs, int x, int y){
        setxLocation(x);
        setyLocation(y);
        setCollisionArea(area);
        this.gs = gs;
        this.isDead = false;
        setDefaultValues();
        getImage();
    }

    @Override
    public void setDefaultValues() {
        setSpeed(1.5);
        
    }

    @Override
    public void getImage() {
        try{ 
            if (isRock) {
            setSprite(ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/obstacle_rock2.png")));
            }
            if (isCrystal) {
            setSprite(ImageIO.read(getClass().getResourceAsStream("/Resources/Sprites/obstacle_crystal2.png")));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void update() {
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
        createCollisionArea();
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
    